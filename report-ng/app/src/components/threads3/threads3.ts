/*
 * Testerra
 *
 * (C) 2023, Martin Großmann, Telekom MMS GmbH, Deutsche Telekom AG
 *
 * Deutsche Telekom AG and all other contributors /
 * copyright owners license this file to you under the Apache
 * License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import {autoinject, observable} from "aurelia-framework";
import {IFilter, StatusConverter} from "services/status-converter";
import {StatisticsGenerator} from "services/statistics-generator";
import {ExecutionStatistics} from "services/statistic-models";
import {AbstractViewModel} from "../abstract-view-model";
import "./threads3.scss"
import {NavigationInstruction, RouteConfig, Router} from "aurelia-router";
// import echarts from "echarts/types/dist/shared";
import * as echarts from "echarts";
import {EChartsOption} from "echarts";


@autoinject()
export class Threads3 extends AbstractViewModel {
    private _executionStatistics: ExecutionStatistics;
    private _filter: IFilter;
    private _loading = true;

    private _options: EChartsOption;
    @observable()
    private _chart: echarts.ECharts;

    constructor(
        private _statusConverter: StatusConverter,
        private _statisticsGenerator: StatisticsGenerator,
        private _router: Router
    ) {
        super();
    }

    activate(params: any, routeConfig: RouteConfig, navInstruction: NavigationInstruction) {
        super.activate(params, routeConfig, navInstruction);
        this._router = navInstruction.router;
        if (this.queryParams.status) {
            this._filter = {
                status: this._statusConverter.getStatusForClass(this.queryParams.status)
            }
        }
    }

    attached() {
        this._statisticsGenerator.getExecutionStatistics().then(executionStatistics => {
            this._executionStatistics = executionStatistics;
            // TODO: Add logic to prepare timeline
            this._prepareTimeline();

            this._loading = false;
        });
    };

    private _chartChanged() {
        this._chart.on('click', event => this._handleClickEvent(event));
    }

    zoom() {
        this._chart.dispatchAction({
            type: 'dataZoom',
            id: 'threadZoom',
            start: 10,  // Percent from
            end: 20,     // Percent to
            // startValue: 10000,
            // endValue: 20000
        });
    }

    resetZoom() {
        // console.log("Data", this._options);
        // console.log("End", this._options.series[0].data.endValue);
        this._chart.dispatchAction({
            type: 'dataZoom',
            id: 'threadZoom',
            start: 0,
            end: 100
            // startValue:0,
            // endValue: undefined
        });
    }

    /**
     * Build Thread timeline according https://echarts.apache.org/examples/en/editor.html?c=custom-profile
     */
    private _prepareTimeline() {
        const data = [];
        const dataCount = 10;
        const startTime = +new Date();
        // TODO: Test threads
        const categories = ['categoryA', 'categoryB', 'categoryC'];
        // TODO: Passed, Failed, Skipped, Expected failed
        const types = [
            {name: 'JS Heap', color: '#7b9ce1'},
            {name: 'Documents', color: '#bd6d6c'},
            {name: 'Nodes', color: '#75d874'},
            {name: 'Listeners', color: '#e0bc78'},
            {name: 'GPU Memory', color: '#dc77dc'},
            {name: 'GPU', color: '#72b362'}
        ];

        // TODO: Add method contexts to every thread
        // Generate mock data
        categories.forEach(function (category, index) {
            let baseTime = startTime;
            for (var i = 0; i < dataCount; i++) {
                const typeItem = types[Math.round(Math.random() * (types.length - 1))];
                const duration = Math.round(Math.random() * 10000);
                data.push({
                    name: typeItem.name,
                    value: [index, baseTime, (baseTime += duration), duration],
                    itemStyle: {
                        normal: {
                            color: typeItem.color
                        }
                    }
                });
                baseTime += Math.round(Math.random() * 2000);
            }
        });

        this._options = {
            tooltip: {
                formatter: function (params) {
                    // console.log(params);
                    // params.value[1]: from date
                    // params.value[2]: to date
                    return params.marker + params.name + ': ' + params.value[3] + ' ms';
                }
            },
            // title: {
            //     text: 'Profile',
            //     left: 'center'
            // },
            dataZoom: [
                {
                    type: 'slider',
                    filterMode: 'weakFilter',
                    showDataShadow: false,
                    // TODO Based of grid height + 100 px
                    top: 400,
                    labelFormatter: ''
                },
                {
                    id: 'threadZoom',
                    type: 'inside',
                    filterMode: 'weakFilter'
                }
            ],
            grid: {
                // TODO: Custom height according number of threads
                height: 300
            },
            xAxis: {
                min: startTime,
                scale: true,
                axisLabel: {
                    formatter: function (val) {
                        return Math.max(0, val - startTime) + ' ms';
                    }
                }
            },
            yAxis: {
                data: categories
            },
            series: [
                {
                    type: 'custom',
                    renderItem: function (params: echarts.CustomSeriesRenderItemParams, api: echarts.CustomSeriesRenderItemAPI) {
                        // return this.getRenderItem(params, api); -> does not work
                        const categoryIndex = api.value(0);
                        // TODO: (Start, end) -> (start time, end time)
                        const start = api.coord([api.value(1), categoryIndex]);
                        const end = api.coord([api.value(2), categoryIndex]);
                        // TODO: 0.6: Minimized height to get space between threads
                        const height = api.size([0, 1])[1] * 0.6;

                        const rectShape = echarts.graphic.clipRectByRect(
                            {
                                x: start[0],
                                y: start[1] - height / 2,
                                width: end[0] - start[0],
                                height: height
                            },
                            {
                                x: params.coordSys["x"],
                                y: params.coordSys["y"],
                                width: params.coordSys["width"],
                                height: params.coordSys["height"]
                            }
                        );
                        return (
                            rectShape && {
                                type: 'rect',
                                transition: ['shape'],
                                shape: rectShape,
                                style: api.style()
                            }
                        );
                    },
                    itemStyle: {
                        opacity: 0.8
                    },
                    encode: {
                        x: [1, 2],
                        y: 0
                    },
                    data: data
                }
            ]
        };
    }

    private _handleClickEvent(event: echarts.ECElementEvent) {
        // TODO: Route to method details
        console.log("clicked", event);
    }

    getRenderItem(params, api): any {
        const categoryIndex = api.value(0);
        const start = api.coord([api.value(1), categoryIndex]);
        const end = api.coord([api.value(2), categoryIndex]);
        const height = api.size([0, 1])[1] * 0.6;
        const rectShape = echarts.graphic.clipRectByRect(
            {
                x: start[0],
                y: start[1] - height / 2,
                width: end[0] - start[0],
                height: height
            },
            {
                x: params.coordSys["x"],
                y: params.coordSys["y"],
                width: params.coordSys["width"],
                height: params.coordSys["height"]
            }
        );
        return (
            rectShape && {
                type: 'rect',
                transition: ['shape'],
                shape: rectShape,
                style: api.style()
            }
        );
    }

}

