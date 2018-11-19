package TestCases;

import Base.TestBase;
import Pages.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.TestBase.prop;

public class verifyLogin {

    Login log;

    public verifyLogin() {
        super();

    }

    @BeforeMethod
    public void Setup() {
        TestBase tb = new TestBase();
        tb.initn();
        log = new Login();
    }

    @Test
    public void loginTest() {
      Login l=new Login();
     // l.login();

       l.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void teardown() {

    }
}