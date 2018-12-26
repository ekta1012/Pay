package TestCases;

import Base.TestBase;
import Pages.Master_Settings;
import Pages.Payroll_menu;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class VerifyMaster_Settings {

    @Test
    public void click_on_Master() {
        //utility_methods.windowHandler();
        Master_Settings mc = new Master_Settings(TestBase.returnInstance().returnDriver());

        mc.gl();
    }

    @Test
    public void VerifyPageSplit_MasterSettings() {
        Master_Settings mc = new Master_Settings(TestBase.returnInstance().returnDriver());
        mc.verifyPage_split_Master();
    }

    @Test
    public void VerifyFailedURL() {
        Master_Settings mc = new Master_Settings(TestBase.returnInstance().returnDriver());

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(mc.url_responsecode(), "OK");
        soft.assertAll();
    }


}