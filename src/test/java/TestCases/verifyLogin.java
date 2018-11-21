package TestCases;

import Base.TestBase;
import Pages.Login;
import Utility.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Base.TestBase.driver;
import static Base.TestBase.initn;
import static Base.TestBase.prop;

public class verifyLogin {

    Login log;

    public verifyLogin() {
        super();

    }

    @BeforeMethod
    public void Setup() {
        /*TestBase cdriver = new TestBase();
        cdriver.initn();

   ash *****log = new Login(cdriver.getDriver()); */
        TestBase.setProp();
        TestBase.initn();
       //log=new Login(TestBase.getDriver());
        log=new Login(TestBase.returnInstance().returnDriver());
    }

    @Test
    public void loginTest() {
      Login l=new Login();
     // l.login();

      l.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterTest
    public void global_master()
    {
        if(utility.desiredframe)
        {

        }
        else
        {
            Actions ac = new Actions(TestBase.returnInstance().returnDriver());

            ac.moveToElement(TestBase.returnInstance().returnDriver().findElement(By.xpath("//div[@role='navigation']"))).build();
            ac.perform();
            TestBase.returnInstance().returnDriver().findElement(By.xpath("//span[text()='Global Masters']")).click();
        }

    }



    @AfterMethod
    public void teardown() {
       // driver.quit();
    }
}