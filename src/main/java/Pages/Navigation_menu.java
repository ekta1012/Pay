package Pages;

import Utility.utility_methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.xpath;

public class Navigation_menu {

    WebDriver driver;
    @FindBy(xpath=("//span[text()='Navigation']"))
    static
    @CacheLookup
    WebElement a;

    @FindBy(xpath=("//span[text()='Global Masters']"))
    static
    @CacheLookup
    WebElement clickEle;
    public Navigation_menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Navigation_menu()
    {

    }
     public  void Navigation_action() {


       utility_methods.action_movetoElements(a,false);
       System.out.println("ekta");
       utility_methods.action_movetoElements(clickEle,true);
    }
}
