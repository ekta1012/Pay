package Utility;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class utility_methods {

    static public void action_movetoElements(WebElement element, Boolean flag) {
        Actions ac = new Actions(TestBase.returnInstance().returnDriver());
        if (flag) {
            ac.moveToElement(element).click().build().perform();
        } else {
            ac.moveToElement(element).perform();
        }
    }
}

