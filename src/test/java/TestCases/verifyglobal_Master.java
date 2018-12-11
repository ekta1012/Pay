package TestCases;

import Base.TestBase;
import Pages.GlobalMasterMenu_Pagecheck;
import Utility.utility_methods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class verifyglobal_Master {
    public ExtentReports extent;
    public ExtentTest extentTest;

    /**
     * will verify the page inside of Global Master
     */

    @Test
    public void PageVerification() {


        GlobalMasterMenu_Pagecheck vi = new GlobalMasterMenu_Pagecheck(TestBase.returnInstance().returnDriver());
        vi.url_responsecode();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals("ok", "OK");
        soft.assertAll();


    }

    @Test
    public void ListofPages() {
        GlobalMasterMenu_Pagecheck v = new GlobalMasterMenu_Pagecheck(TestBase.returnInstance().returnDriver());
        v.verifyPage_split();

    }

    @AfterMethod

    public void FailedTest(ITestResult result) {

        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Extentreport.html", true);
        extentTest = extent.startTest("ext");
        //System.out.println(""+result.getName());
        if (result.getStatus() == ITestResult.FAILURE) {

            extentTest.log(LogStatus.FAIL, "Test Case Failed" + result.getName());
            extentTest.log(LogStatus.FAIL,"" + result.getTestContext());

            extentTest.log(LogStatus.FAIL, "Test Case Failed" + this.getClass().getSimpleName());


            try {

                String screenshotPath = utility_methods.takeScreenShoot(TestBase.returnInstance().returnDriver(), result.getName());
                extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
                extent.flush();
            } catch (Exception e) {

            }

        }
    }

/*
    public void onFinish(ITestContext context) {
        System.out.println("Passed tests: " + context.getPassedTests());
        System.out.println("Failed tests:" + context.getFailedTests());

    }*/
}







