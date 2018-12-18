package TestCases;

import Base.TestBase;
import Pages.Salary_Reports;
import Pages.Salary_str;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class verifySal_report {

    @Test
    public void click_on_verifySal_str()
    {
        //utility_methods.windowHandler();
        Salary_Reports mc = new Salary_Reports(TestBase.returnInstance().returnDriver());
        mc.gl();
    }

    @Test
    public void VerifyPageSplit_verifySal_str()
    {
        Salary_Reports mc = new Salary_Reports(TestBase.returnInstance().returnDriver());
        mc.verifyPage_split_Master();
    }

    @Test
    public void VerifyFailedURL()
    {
        Salary_Reports mc = new Salary_Reports(TestBase.returnInstance().returnDriver());

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(mc.url_responsecode(), "OK");
        soft.assertAll();
    }
}
