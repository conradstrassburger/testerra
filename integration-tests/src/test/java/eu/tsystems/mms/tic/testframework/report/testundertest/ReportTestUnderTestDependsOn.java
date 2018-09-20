/*
 * Created on 10.05.2017
 *
 * Copyright(c) 2011 - 2014 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */

package eu.tsystems.mms.tic.testframework.report.testundertest;

import eu.tsystems.mms.tic.testframework.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This class ...
 *
 * @author fakr
 */
public class ReportTestUnderTestDependsOn extends AbstractTest {

    @Test
    public void test_PassedAlways() {
        Assert.assertTrue(true);
    }

    // A
    @Test
    public void test_FailedAlways() {
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"test_PassedAlways"})
    public void test_FailedDependsOnPassedMethod() {
        TestUtils.sleep(1000); // simulate work
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"test_FailedDependsOnPassedMethod"})
    public void test_SkippedDependsOnFailedMethod() {
        TestUtils.sleep(2000); // simulate work
        Assert.assertTrue(true, "Skipped - Not reachable. Depends on failed method");
    }

    @Test(dependsOnMethods = {"test_FailedDependsOnPassedMethod"}, alwaysRun = true)
    public void test_PassedDependsOnFailedMethodButAlwaysRun() {
        TestUtils.sleep(3000); // simulate work
        Assert.assertTrue(true, "Reachable. Depends on failed method but alwaysRun flag is set");
    }

    // B dependsOn A
    @Test(dependsOnMethods = {"test_FailedAlways"}, dataProvider = "dependsOnDP")
    public void test_dependsOnFailedMethodWithDP(String actualRun) {
        final String expectedRun = "Run1";
        TestUtils.sleep(2000);
        Assert.assertEquals(actualRun, expectedRun, "This test Run is not the expected Run");
    }

    // C dependsOn B
    @Test(dependsOnMethods = {"test_dependsOnFailedMethodWithDP"}, dataProvider = "dependsOnDP")
    public void test_dependsOnFailedMethodWithDP2(String actualRun) {
        final String expectedRun = "Run1";
        TestUtils.sleep(3000);
        Assert.assertEquals(actualRun, expectedRun, "This test Run is not the expected Run");
    }

    @Test(dependsOnMethods = {"test_FailedDependsOnPassedMethod"}, dataProvider = "dependsOnDP", alwaysRun = true)
    public void test_dependsOnFailedMethodButAlwaysRunWithDP(String actualRun) {
        final String expectedRun = "Run1";
        TestUtils.sleep(1000);
        Assert.assertEquals(actualRun, expectedRun, "This test Run is not the expected Run");
    }

    @AfterMethod(alwaysRun = true)
    public void test_AfterMethodWithDP() {
        Assert.assertTrue(true);
    }

    @DataProvider(name = "dependsOnDP")
    public Object[][] createDependsOnDP() {
        Object[][] objects = new Object[3][1];
        objects[0][0] = "Run1";
        objects[1][0] = "Run2";
        objects[2][0] = "Run3";
        return objects;
    }

}