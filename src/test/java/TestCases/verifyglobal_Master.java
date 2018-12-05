package TestCases;

import Base.TestBase;
import Pages.GlobalMasterMenu_Pagecheck;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

public class verifyglobal_Master {
    /**
     * will verify the page inside of Global Master
     */
    @AfterSuite
public void Pageverification() {



    GlobalMasterMenu_Pagecheck v=new GlobalMasterMenu_Pagecheck(TestBase.returnInstance().returnDriver());

    v.verifyPage_split();

}
public void PageNotFound()
{

}
}

