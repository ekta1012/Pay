package Utility;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This method is used to perform actions .
 */

public class utility_methods {

    static public void action_movetoElements(WebElement element, Boolean flag) {
        Actions ac = new Actions(TestBase.returnInstance().returnDriver());
        if (flag) {
            ac.moveToElement(element).click().build().perform();

        } else {
            //ac.moveToElement(element).perform();
            ac.moveToElement(element).perform();
        }
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
        huc.setRequestMethod("HEAD");
        huc.connect();
        return huc.getResponseCode();
        //huc.getWebResponse().getStatusCode();

    }


    public static String isLinkBroken(URL url) throws Exception {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        /**
         * Pass a Hard coded cookie info
         */
        String cookie = "_ga=GA1.2.643104291.1542458958; .ASPXAUTH=F51E63A30126BB7A77F7619342D6A300DE0207DBD66E6FE2974B3F3AED62465E9653A29A719885788CC3AF6F41E84C78D773CB963AEDC4D15A3478E7B2B7B73A328966FE002D442362576519EA8C2526882A9FFD04E570B396436E9AE9CCC5F699FEDD3D89BE7FFCEFBAA22409CF4AC6E172D2A7E493D63ABF574C242D192AE31ACDA0331B29D7D2048D4E58A5E3B19AB9EDBD3D30E9D04AB4891875C27D4CDC5245D1B2109A681B58FE01D3473AE204E4E69624F788932154C7CF5FE06D4EE22597E75CBADE0FEC5FF08DFC5DC8345A4BDBCD46FFAE06712A8CF4BC948E2201056985ECF489CF2B6E774F043B6CF19B95D5AACEA68F9C8BD7F43643BB5CF82D35E23BF94C0361CBC10E6F58A9A45660AE84A939E6088E18475A1277E5E17B52471023A9";

        try {
            connection.setRequestProperty("Cookie", cookie);
            connection.connect();



            int res = connection.getResponseCode();
            String response = connection.getResponseMessage();
            System.out.println(""+response);

            connection.disconnect();

            return response;


        } catch (Exception exp) {

            return exp.getMessage();

        }


    }


}
