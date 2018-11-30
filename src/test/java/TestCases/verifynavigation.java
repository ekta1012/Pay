package TestCases;

import Base.TestBase;
import Pages.Navigation_menu;
import Utility.utility_methods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class verifynavigation {
    @AfterTest
    public void global_master()
    {

        utility_methods.windowHandler();
        Navigation_menu m=new Navigation_menu(TestBase.returnInstance().returnDriver());
        m.Navigation_action();

    }
    @AfterSuite
    public void teardown() {


        TestBase.returnInstance().returnDriver().quit();
    }
}
