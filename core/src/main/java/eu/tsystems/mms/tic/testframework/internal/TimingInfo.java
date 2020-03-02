/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann
 *     pele
 */
package eu.tsystems.mms.tic.testframework.internal;

public class TimingInfo {

    private final String context;
    private final String currentUrl;
    private final long timeStampMilli;
    private final long loadDuration;

    /**
     * loads page infos
     * @param context .
     * @param currentUrl .
     * @param loadDuration .
     * @param timeStampMilli
     */
    public TimingInfo(String context, String currentUrl, long loadDuration, long timeStampMilli) {
        this.context = context;
        this.currentUrl = currentUrl;
        this.timeStampMilli = timeStampMilli;
        this.loadDuration = loadDuration;
    }

    public String getContext() {
        return context;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public long getLoadDuration() {
        return loadDuration;
    }

    public long getTimeStamp() {
        return timeStampMilli;
    }

}
