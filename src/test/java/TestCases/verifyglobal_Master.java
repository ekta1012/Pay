package TestCases;

import Base.TestBase;
import Pages.GlobalMasterMenu_Pagecheck;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;



public class verifyglobal_Master {
    public ExtentReports extent;
    public ExtentTest extentTest;
    private int i;

    /**
     * will verify the page inside of Global Master
     */
    GlobalMasterMenu_Pagecheck vi = new GlobalMasterMenu_Pagecheck(TestBase.returnInstance().returnDriver());
    @Test
    public void PageVerification() {

        //vi.url_responsecode();
        SoftAssert soft = new SoftAssert();
       soft.assertEquals("NOT FOUND", "OK",vi.url_responsecode());
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
            extentTest.log(LogStatus.FAIL,"" + result.getThrowable());

           // extentTest.log(LogStatus.FAIL, "Test Case Failed" + this.getClass().getSimpleName());


            try {
/** For taking the screen shoot
 *  String screenshotPath = utility_methods.takeScreenShoot(TestBase.returnInstance().returnDriver(), result.getName());
 *  extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
 */

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







