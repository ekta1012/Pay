package TestCases;

import Base.TestBase;
import Pages.Master_Settings;
import Pages.Payroll_Master;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class verifyPayrollMaster {
    @Test
    public void click_on_Payroll()
    {
        //utility_methods.windowHandler();
        Payroll_Master mc = new Payroll_Master(TestBase.returnInstance().returnDriver());

        mc.gl();
    }

    @Test
    public void VerifyPageSplit_MasterSettings()
    {
        Payroll_Master mc = new Payroll_Master(TestBase.returnInstance().returnDriver());
        mc.verifyPage_split_Master();

    }

    @Test
    public void VerifyFailedURL()
    {
        Payroll_Master mc = new Payroll_Master(TestBase.returnInstance().returnDriver());

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(mc.url_responsecode(), "OK");
        soft.assertAll();
    }

}
