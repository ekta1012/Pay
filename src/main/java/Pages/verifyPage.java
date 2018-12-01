package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class verifyPage {

    WebDriver driver;
    @FindBy(xpath=("//span[text()='Define Session']"))
    static
    @CacheLookup
    WebElement clickEle1;

    @FindBy(xpath=("//span[text()='Define Session']/ancestor::li//a[@onclick]"))
    static
    @CacheLookup
    List<WebElement> link;
    public verifyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyPage_split()
    {
        for ( WebElement we: link) {
            String sss =  we.getAttribute("onclick");
            String[] arrSplit = sss.split(",");
            String url = arrSplit[1].substring(0, arrSplit[1].length() - 1);
            System.out.println(url);
            List<String> urls= Arrays.asList(url);


            try {

                System.out.println("URL:" +we.getAttribute("onclick")+"returned" +isLinkBroken(new URL(we.getAttribute("onclick"))));
                //System.out.println("Pass URL" +url.c)
            }
            catch(Exception e)
            {
              // System.out.println("At " + we.getAttribute("innerHTML") + " Exception occured)");
            }

        }
    }

    public static String isLinkBroken(URL url) throws Exception {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {

            connection.connect();

            String response = connection.getResponseMessage();

            connection.disconnect();

            return response;

        } catch (Exception exp) {

            return exp.getMessage();

        }
    }
}

