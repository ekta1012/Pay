package TestCases;

import Base.TestBase;
import Pages.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.TestBase.driver;
import static Base.TestBase.prop;

public class verifyLogin {

    Login log;

    public verifyLogin() {
        super();

    }

    @BeforeMethod
    public void Setup() {
        TestBase cdriver = new TestBase();
        cdriver.initn();

     log = new Login(cdriver.getDriver());
    }

    @Test
    public void loginTest() {
      Login l=new Login();
     // l.login();

       l.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}