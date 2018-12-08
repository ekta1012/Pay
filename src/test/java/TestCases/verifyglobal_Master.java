package TestCases;

import Base.TestBase;
import Pages.GlobalMasterMenu_Pagecheck;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.MalformedURLException;

public class verifyglobal_Master {

    /**
     * will verify the page inside of Global Master
     */

    @Test
    public void PageVerification(){

try {
    GlobalMasterMenu_Pagecheck vi = new GlobalMasterMenu_Pagecheck(TestBase.returnInstance().returnDriver());
    vi.url_responsecode();

}
 catch (Exception e) {
    e.printStackTrace();
}

    }

@Test
public void ListofPages() {
        GlobalMasterMenu_Pagecheck v=new GlobalMasterMenu_Pagecheck(TestBase.returnInstance().returnDriver());
    v.verifyPage_split();

}
//@AfterSuite

}

