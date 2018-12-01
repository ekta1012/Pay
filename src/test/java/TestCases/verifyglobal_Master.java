package TestCases;

import Base.TestBase;
import Pages.Login;
import Pages.verifyPage;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.awt.*;

public class verifyglobal_Master {
@AfterSuite
public void Setup1() {

   // System.out.println("EKTA");

    verifyPage v=new verifyPage(TestBase.returnInstance().returnDriver());

    v.verifyPage_split();
}
}

