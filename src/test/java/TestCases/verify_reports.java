package TestCases;

import Base.TestBase;
import Pages.Reports;
import Pages.Salary_str;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class verify_reports {



    @Test
    public void click_on_verifySal_str()
    {
        //utility_methods.windowHandler();
        Reports mc = new Reports(TestBase.returnInstance().returnDriver());
        mc.gl();
    }

    @Test
    public void VerifyPageSplit_verifySal_str()
    {
        Reports mc = new Reports(TestBase.returnInstance().returnDriver());
        mc.verifyPage_split_Master();
    }

    @Test
    public void VerifyFailedURL()
    {
        Reports mc = new Reports(TestBase.returnInstance().returnDriver());

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(mc.url_responsecode(), "OK");
        soft.assertAll();
    }

    @Test(dependsOnMethods = { "click_on_verifySal_str" ,"VerifyPageSplit_verifySal_str","VerifyFailedURL"})
    public void verify_Tittle()
    {
        Reports mc = new Reports(TestBase.returnInstance().returnDriver());
        mc.find_allLinksTitle();
    }
}
