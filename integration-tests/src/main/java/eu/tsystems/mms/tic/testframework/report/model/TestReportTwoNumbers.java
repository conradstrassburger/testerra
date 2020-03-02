package eu.tsystems.mms.tic.testframework.report.model;

import eu.tsystems.mms.tic.testframework.report.abstracts.AbstractTestReportNumbers;

public class TestReportTwoNumbers extends AbstractTestReportNumbers {

    public TestReportTwoNumbers() {
        highCorridorLimit = 19;
        highCorridorActual = 26;
        midCorridorActual = 3;
        lowCorridorActual = 5;
        all = 76;
        allSuccessful = 26;
        passed = 11;
        passedMinor = 13;
        passedRetry = 2;
        allSkipped = 16;
        skipped = 16;
        allBroken = 34;
        failed = 13;
        failedMinor = 21;
        failedRetried = 4;
        failedExpected = 6;
        failureAspects = 6;
        exitPoints = 40;
        percentage = 34;
    }


}
