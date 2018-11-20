package Pages;

import Base.TestBase;
import org.openqa.selenium.*;
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
    WebElement password;

    @FindBy(id="btnLogin")
    static
    WebElement btn;


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
  }


}
