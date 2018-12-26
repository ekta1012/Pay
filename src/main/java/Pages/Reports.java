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
import static Pages.Master_Settings.Global_link;
import static Pages.Payroll_Master.define_SA;


//import static Pages.Payroll_menu.arrName;
import static Pages.Payroll_menu.Excel;
import static Pages.Payroll_menu.arrName;
import static Pages.Salary_Reports.B_stmt;
import static Pages.Salary_str.LWP;


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


    @FindBy(xpath = ("//span[text()='Employee Statistics']/ancestor::li//a[@onclick]"))
    static
    @CacheLookup
    List<WebElement> Bank_stmt;

    public Reports(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void find_allLinksTitle() {

        try {
            Payroll_menu pm = new Payroll_menu();
            List<String> allAttribute = new ArrayList<>();
            List<String> global_master = utility_methods.find_allLinksTitle(li);
            List<String> master_setting = utility_methods.find_allLinksTitle(Global_link);
            //payroll master not working
            List<String> payroll_master = utility_methods.find_allLinksTitle(define_SA);
            //
            List<String> Advance = utility_methods.find_allLinksTitle(Fix_fad);

            List<String> sal_str = utility_methods.find_allLinksTitle(LWP);
            List<String> sal_reports = utility_methods.find_allLinksTitle(B_stmt);
            List<String> reports = utility_methods.find_allLinksTitle(Bank_stmt);

            allAttribute.addAll(global_master);
            allAttribute.addAll(master_setting);
            allAttribute.addAll(payroll_master);
            allAttribute.addAll(Advance);
            allAttribute.addAll(sal_str);
            allAttribute.addAll(sal_reports);
            allAttribute.addAll(reports);

            for (String ms : allAttribute) {
                System.out.println("" + ms);
            }


            List<String> notFoundLink = new ArrayList<String>();
            System.out.println("ekta" + pm.arrName);
            Payroll_menu.Excel();
            boolean isLinkFoundinForms = false;
            for (String valueFromXLS : Payroll_menu.arrName) {
                isLinkFoundinForms = false;
                System.out.println("ekta" + valueFromXLS);
                for (String valueFromForm : allAttribute) {
                    if (valueFromXLS.equalsIgnoreCase(valueFromForm)) {
                        isLinkFoundinForms = true;
                        break;

                    }
                }
                if(!isLinkFoundinForms){
                    notFoundLink.add(valueFromXLS);
                    System.out.println("" + notFoundLink);
                }

            }

            if (notFoundLink.size() > 0) {
                System.out.println("One or more link not found");
                for (String valuenotFound : notFoundLink) {
                    System.out.println("" + valuenotFound);
                }
            }
        } catch (Exception E) {

        }

    }


//   if(ms==Payroll_menu.w)
//                {
//                System.out.println("String are Equal");
//                }
//                else
//                {
//                    System.out.println("String are't Equal");
//                }


    public void gl() {
        utility_methods.action_movetoElements(reports, true);
        utility_methods.action_movetoElements(Emp_statistics, true);
    }

    public String url_responsecode() {
        int noOfFailURL = 0;
        int successURL = 0;
        String FailedURL = "";
        try {
            urls = utility_methods.find_allLinksURL(Bank_stmt);
            for (String urloc : urls) {
                fullURL = "http://qaerp.franciscanecare.net" + urloc;
                System.out.println("" + fullURL);
                int s = utility_methods.getResponseCode(fullURL);
                System.out.println("" + s);
                if (s == 200) {

                    successURL++;

                } else {
                    System.out.println("Issue in this URL:::" + fullURL);
                    noOfFailURL++;
                    FailedURL = FailedURL + " " + "\n" + "URL" + noOfFailURL + ":" + fullURL;
                }

            }
        }
        /** below specified screenshoot method executed successfully but has no use here thatswhy commenting*/

        //   utility_methods.takeScreenShoot(TestBase.returnInstance().returnDriver(),"G://test1.png");


        catch (Exception e) {
            // log.fatal("Fatal");
            //System.out.println("Issue in" + fullURL + "" + e.getMessage());
            e.printStackTrace();
        }

        if (noOfFailURL > 0)
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