package Pages;

import Utility.utility_methods;




import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.net.URL;
import java.util.List;





public class GlobalMasterMenu_Pagecheck {

    /**
     * LOGGER OF THE DEFINED CLASS
     */
    private static Logger log = Logger.getLogger("GlobalMasterMenu_Pagecheck.class.getName()");

    List<String> urls;

    WebDriver driver;
    @FindBy(xpath = ("//span[text()='Define Session']"))
    static
    @CacheLookup
    WebElement clickEle1;

    @FindBy(xpath = ("//span[text()='Define Session']/ancestor::li//a[@onclick]"))
    static
    @CacheLookup
    List<WebElement> link;

    public GlobalMasterMenu_Pagecheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * <h1><B>This method is used to check the Page is opening or not  </B></h1>
     */

    public void verifyPage_split() {
        log.trace("startup");
        DOMConfigurator.configure("Log4j.xml");
        //BasicConfigurator.configure();
        log.info("123");
        try {


//   *******NEED TO ASK ABOUT :FOR MOVE ON TABS BELOW CODE IS REQUIRED <SO DO WE NEED TO IMPLEMENT ACTION FOR LIST ALSO?*******
            //utility_methods.action_movetoElements(link,true);
            //action_movetoElements.ac.moveToElement(we).click().build().perform();
            log.debug("jhhd");
            urls = utility_methods.find_allLinksURL(link);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * <B>This block of code is used to get the list of Full URL's and isLinkBroken() will check the Page is opening or not.</B>
         */

        for (String urloc : urls) {

            try {
                log.warn("warning");

                String fullURL = "http://qaerp.franciscanecare.net" + urloc;

                System.out.println("URL:" + fullURL + " Returned::::" + utility_methods.isLinkBroken(new URL(fullURL)));


                int s=utility_methods.getResponseCode(fullURL);
                System.out.println(""+s);
                if(s== 404)
                {
                    try
                    {
                        log.fatal("Page is't opening,its have some issue" + fullURL);

                    }
                    catch(Exception e)
                    {
                       // log.fatal("Fatal");
                       // System.out.println("At " +e.getMessage());
                    }
                }


            } catch (Exception ex) {

                log.fatal("Fatal");
                System.out.println("At " + " Exception occured)");
                // "//-&gt; " + exp .getMessage());                }
            }
        }
    }
}





