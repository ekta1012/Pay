package TestCases;

import Base.TestBase;

import Pages.GlobalMasterMenu_Pagecheck;
import Pages.Master_Settings;
import Utility.utility_methods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class VerifyMaster_Settings {

    @Test
    public void click_on_Master()
    {
        //utility_methods.windowHandler();
        Master_Settings mc = new Master_Settings(TestBase.returnInstance().returnDriver());

        mc.gl();
    }

    @Test
    public void VerifyPageSplit_MasterSettings()
    {
        Master_Settings mc = new Master_Settings(TestBase.returnInstance().returnDriver());
        mc.verifyPage_split_Master();
    }

    @Test
    public void VerifyFailedURL()
    {
        Master_Settings mc = new Master_Settings(TestBase.returnInstance().returnDriver());

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(mc.url_responsecode(), "OK");
        soft.assertAll();
    }
    @Test
    public void Try()
    {
        Master_Settings mc = new Master_Settings(TestBase.returnInstance().returnDriver());
        mc.find_allLinksTitle();
    }
}
