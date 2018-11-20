package Pages;

import Base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public  class Login {
    String use;
    TestBase tb = new TestBase();
    WebDriver driver;

    @FindBy(id="txtUserName")
    static
   public WebElement txtUserName;

    @FindBy(id="txtPassword")
     static
    @CacheLookup
    WebElement password;

    @FindBy(id="btnLogin")
    static
    @CacheLookup
    WebElement btn;

    @FindBy(xpath="//a[contains(text(),'Go to Payroll')]")
    static
    @CacheLookup
    WebElement Go_button;

    @FindBy(xpath="//span[contains(text(),'Global Masters')]")
    static
    @CacheLookup
    WebElement global_master;


    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public Login() {

    }


  public void login(String us, String pwd)
  {

      txtUserName.sendKeys(us);
      this.password.sendKeys(pwd);
      this.btn.click();
      Go_button.click();
      global_master.click();
  }


}
