package Pages;


import Utility.utility_methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static Pages.Advance.Fix_fad;
import static Pages.GlobalMasterMenu_Pagecheck.li;
import static Pages.Payroll_Master.define_SA;
import static Pages.Reports.Bank_stmt;
import static Pages.Salary_Reports.B_stmt;
import static Pages.Salary_str.LWP;


public class Master_Settings {

    WebDriver driver;
    List<String> urls;
    String fullURL;

    @FindBy(xpath = ("//span[text()='Master Settings']"))
    static
    @CacheLookup
    WebElement gl;

    @FindBy(xpath = ("//span[text()='Define Global Settings']"))
    static
    @CacheLookup
    //List<WebElement> dl;
            WebElement dl;

    //span[text()='Define Global Settings']/ancestor::li//a[@onclick]
    @FindBy(xpath = ("//span[text()='Define Global Settings']/ancestor::li//a[@onclick]"))
    static
    @CacheLookup
    List<WebElement> Global_link;

    public Master_Settings(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gl() {
        utility_methods.action_movetoElements(gl, true);
        utility_methods.action_movetoElements(dl, true);
    }
    public static void find_allLinksTitle() {
        try {

            List<String> master_setting = utility_methods.find_allLinksTitle(Global_link);
            List<String> global_master = utility_methods.find_allLinksTitle(li);
            //payroll master not working
            List<String> payroll_master = utility_methods.find_allLinksTitle(define_SA);
            //
            List<String> Advance = utility_methods.find_allLinksTitle(Fix_fad);

            List<String> sal_str = utility_methods.find_allLinksTitle(LWP);
            List<String> sal_reports = utility_methods.find_allLinksTitle(B_stmt);
            List<String> reports = utility_methods.find_allLinksTitle(Bank_stmt);

            for(String ms: master_setting)
            {
                System.out.println("" +ms);
            }

            for(String gl: global_master)
            {
                System.out.println("" +gl);
            }



            for(String pay: payroll_master)
            {
                System.out.println("" +pay);
            }


            for(String sal: sal_reports)
            {
                System.out.println("" +sal);
            }




           /* ArrayList<String> arrList = new ArrayList<String>();


            //arrList.add(master_setting);
            arrList.add("global_master");
            arrList.add("payroll_master");
            arrList.add("Advance");
            arrList.add("sal_str");
            arrList.add("sal_reports");
            arrList.add("sal_reports");

            System.out.println("" + arrList); */


        } catch (Exception E) {

        }
    }

    public String url_responsecode() {
        int noOfFailURL=0;
        int successURL=0;
        String FailedURL="";
        try {

           urls = utility_methods.find_allLinksURL(Global_link);
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
            urls = utility_methods.find_allLinksURL(Global_link);
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