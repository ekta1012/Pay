package Utility;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

public class utility {
    static public boolean desiredframe = false;
    @FindBy(xpath = "//iframe")
    static
    private List<WebElement> Frame;

    static {
        PageFactory.initElements(TestBase.returnInstance().returnDriver(), utility.class);

    }

    public static void getframe(String framename) {
        Iterator it = utility.Frame.iterator();
        while (it.hasNext()) {
            WebElement element = (WebElement) it.next();
            if (element.getAttribute("name").equalsIgnoreCase(framename.toString())) ;
            {
                TestBase.returnInstance().returnDriver().switchTo().frame(element);
                desiredframe = true;
                break;
            }
        }
    }
}
