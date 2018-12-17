package Utility;

import Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This method is used to perform actions .
 */

public class utility_methods {


    public static String response;
    public static int res;

    public static List<String> find_allLinksTitle(List<WebElement> eleList) throws Exception {
        List<String> names = new ArrayList<>();
        try {
            for (WebElement currentWebElement : eleList) {
                if (!currentWebElement.getAttribute("href").equalsIgnoreCase("javascript:void(0)")) {

                    names.add(currentWebElement.getAttribute("span"));

                }

            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
        return names;

    }


    static public void action_movetoElements(WebElement element, Boolean flag) {
        Actions ac = new Actions(TestBase.returnInstance().returnDriver());
        if (flag) {
            ac.moveToElement(element).click().build().perform();

        } else {
            //ac.moveToElement(element).perform();
            ac.moveToElement(element).perform();
        }
    }

    static public String takeScreenShoot(WebDriver driver, String screenshotName) throws IOException {


            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot scrShot = ((TakesScreenshot) TestBase.returnInstance().returnDriver());

            //Call getScreenshotAs method to create image file

            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/FailedTestsScreenShots/" + screenshotName + dateName + ".png";

            //Move image file to new destination

            File DestFile = new File(destination);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);
        return  destination;
        }

    /**
     * This is used to handling the window
     *
     */
    static public void windowHandler() {
        for (String handle : TestBase.returnInstance().returnDriver().getWindowHandles()) {
            TestBase.returnInstance().returnDriver().switchTo().window(handle);
        }
    }

    /**
     *Purpose is to find the all Link URL on the basis of anchor tag and If no anchor tag exist than will search onclick() and perform the String
     *  Trimming
     * @param elementList (its a kind of list)
     * @return
     * @throws Exception
     */

    public static List<String> find_allLinksURL(List<WebElement> elementList) throws Exception {
        List<String> urls = new ArrayList<>();
        try {
            for (WebElement currentWebElement : elementList) {
                if (!currentWebElement.getAttribute("href").equalsIgnoreCase("javascript:void(0)")) {
                    urls.add(currentWebElement.getAttribute("href"));
                } else {
                    /**
                     * will pick the value on the basis of onclick() in case of no anchor tag exist
                     */
                    String onClickStr = currentWebElement.getAttribute("onclick");
                    String[] onClickStrSplitArr = onClickStr.split(",");
                    String url = onClickStrSplitArr[1].substring(0, onClickStrSplitArr[1].length() - 1);
                    String str = url.replaceAll("'", "");
                   // System.out.println("" + str);
                    urls.add(str);
                }

            }

        }
        catch (Exception e) {
            e.getMessage();

        }return urls;
    }


    public static int getResponseCode(String urlString) throws  IOException {
        URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        String cookie = "_ga=GA1.2.1888049134.1543650832; _gid=GA1.2.169693167.1544585283; .ASPXAUTH=010274C35A3F2460D608FE74C39D8EFBF440090005610064006D0069006E006631007C0065002D0043006100720065002000410064006D0069006E007C00610064006D0069006E0040006600720061006E00630069007300630061006E00650063006100720065002E006E00650074007C0039007C0039007C00300031002D004100700072002D0032003000310038007C00330031002D004D00610072002D0032003000310039007C0032003000310038002D0032003000310039007C0031007C0032003000310038002D0032003000310039007C0030007C0030007C007C004600530050004C0047004E00012F00FF4F5104CBADF2ACFAB8B45CC8200071455C35D3A3";

        huc.setRequestProperty("Cookie", cookie);
        //huc.setRequestMethod("GET");
        huc.connect();
        huc.disconnect();
        return huc.getResponseCode();
        //huc.getWebResponse().getStatusCode();


    }



    public static String isLinkBroken(URL url) throws Exception {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        /**
         * Pass a Hard coded cookie info
         */
        String cookie = "_ga=GA1.2.1888049134.1543650832; _gid=GA1.2.169693167.1544585283; .ASPXAUTH=010274C35A3F2460D608FE74C39D8EFBF440090005610064006D0069006E006631007C0065002D0043006100720065002000410064006D0069006E007C00610064006D0069006E0040006600720061006E00630069007300630061006E00650063006100720065002E006E00650074007C0039007C0039007C00300031002D004100700072002D0032003000310038007C00330031002D004D00610072002D0032003000310039007C0032003000310038002D0032003000310039007C0031007C0032003000310038002D0032003000310039007C0030007C0030007C007C004600530050004C0047004E00012F00FF4F5104CBADF2ACFAB8B45CC8200071455C35D3A3";
        try {
            connection.setRequestProperty("Cookie", cookie);
            connection.connect();
            res = connection.getResponseCode();
           response = connection.getResponseMessage();

            System.out.println(""+res);
            connection.disconnect();
            return response;



        } catch (Exception exp) {

            return exp.getMessage();

        }


    }


}
