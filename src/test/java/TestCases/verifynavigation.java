package TestCases;

import Base.TestBase;
import Pages.Navigation_menu;
import Utility.utility_methods;
import org.testng.annotations.*;

public class verifynavigation {

    /**
     * This method will used to perform action on  navigation  and click on Global master
     *
     */

   // @AfterTest
    @Test
    public void Navigation_on_global_master()
    {

        utility_methods.windowHandler();
        Navigation_menu m=new Navigation_menu(TestBase.returnInstance().returnDriver());
        m.Navigation_action();

    }

    /**
     * will Teardown the session
     *
     */
    /*
  @AfterSuite
    public void Teardown() {


        TestBase.returnInstance().returnDriver().quit();
    }*/
}
