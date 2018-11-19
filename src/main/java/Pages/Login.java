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
    private String us;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public Login() {

    }

   /* public void setUserName(String us)
   {
       username.sendKeys(us);
    }

   public void setPwd(String txtPassword)
  {
      password.sendKeys(txtPassword);
  }
*/

  public void login(String us, String pwd)
  {

      System.out.println(us);

 /* username.sendKeys(us);


System.out.println(us);
      //System.out.println(pwd);
      //prop.getProperty("username");


      password.sendKeys(pwd);
      btn.click();
      this.setUserName(us);
     this.setPwd(pwd);
*/
      txtUserName.sendKeys(us);

  }


}
