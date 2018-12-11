package TestCases;

import Base.TestBase;
import Pages.Login;
import Pages.Navigation_menu;
import Utility.utility;
import Utility.utility_methods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static Base.TestBase.driver;
import static Base.TestBase.initn;
import static Base.TestBase.prop;

public class verifyLogin {

    Login log;

    public ExtentReports extent;
    public ExtentTest extentTest;

    public verifyLogin() {
        super();

    }

    /**
     * will perform initial Browser based setting
     */
  //  @BeforeSuite
    @Test
    public void Setup() {

        TestBase.setProp();
        TestBase.initn();
       //log=new Login(TestBase.getDriver());
        log=new Login(TestBase.returnInstance().returnDriver());
        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Extentreport.html", true);
       extentTest= extent.startTest("ext");
    }

    /**
     * will fetch the data from  property file
     */
   @Test
    //@BeforeTest
    public void loginTest(){
      Login l=new Login();
     // l.login();

      l.login(prop.getProperty("username"),prop.getProperty("password"));
    }




}