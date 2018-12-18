package TestCases;

import Base.TestBase;
import Pages.Advance;
import Pages.Payroll_Master;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class verifyAdvance {
    @Test
    public void click_on_Advance()
    {
        //utility_methods.windowHandler();
        Advance mc = new Advance(TestBase.returnInstance().returnDriver());

        mc.gl();
    }

    @Test
    public void VerifyPageSplit_Advance()
    {
        Advance mc = new Advance(TestBase.returnInstance().returnDriver());
        mc.verifyPage_split_Master();
    }

    @Test
    public void VerifyFailedURL()
    {
        Advance mc = new Advance(TestBase.returnInstance().returnDriver());

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(mc.url_responsecode(), "OK");
        soft.assertAll();
    }

}


