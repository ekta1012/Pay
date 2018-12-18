package Pages;

import Utility.utility_methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.util.List;

public class Reports {

    WebDriver driver;
    List<String> urls;
    String fullURL;

    @FindBy(xpath = ("//span[text()='Reports']"))
    static
    @CacheLookup
    WebElement reports;

    @FindBy(xpath = ("//span[text()='Employee Statistics']"))
    static
    @CacheLookup
    WebElement Emp_statistics;


    @FindBy(xpath = ("//span[text()='Bank Statement Report']/ancestor::li//a[@onclick]"))
    static
    @CacheLookup
    List<WebElement> Bank_stmt;

    public Reports(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gl() {
        utility_methods.action_movetoElements(reports, true);
        utility_methods.action_movetoElements(Emp_statistics, true);
    }
    public String url_responsecode() {
        int noOfFailURL=0;
        int successURL=0;
        String FailedURL="";
        try {
            urls = utility_methods.find_allLinksURL(Bank_stmt);
            for (String urloc : urls) {
                fullURL = "http://qaerp.franciscanecare.net" + urloc;
                System.out.println("" + fullURL);
                int s = utility_methods.getResponseCode(fullURL);
                System.out.println("" + s);
                if (s == 200) {

                    successURL++;

                }

                else {
                    System.out.println("Issue in this URL:::" + fullURL);
                    noOfFailURL++;
                    FailedURL = FailedURL +" "+"\n"+ "URL" + noOfFailURL + ":" + fullURL;
                }

            }
        }
        /** below specified screenshoot method executed successfully but has no use here thatswhy commenting*/

        //   utility_methods.takeScreenShoot(TestBase.returnInstance().returnDriver(),"G://test1.png");



        catch(Exception e) {
            // log.fatal("Fatal");
            //System.out.println("Issue in" + fullURL + "" + e.getMessage());
            e.printStackTrace();
        }

        if(noOfFailURL>0)
            return FailedURL;
        else
            System.out.println("*************NO URL IN FAILED CATEGORY******************");
        return "OK";

    }

    public void verifyPage_split_Master() {
        try {
            urls = utility_methods.find_allLinksURL(Bank_stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * <B>This block of code is used to get the list of Full URL's and isLinkBroken() will check the Page is opening or not.</B>
         */

        for (String urloc : urls) {

            try {

                fullURL = "http://qaerp.franciscanecare.net" + urloc;

                System.out.println("URL:" + fullURL + " Returned::::" + utility_methods.isLinkBroken(new URL(fullURL)));
                // String m=utility_methods.isLinkBroken(new URL(fullURL));
            } catch (Exception ex) {
                System.out.println("At " + " Exception occured)");

            }
        }
    }
}

