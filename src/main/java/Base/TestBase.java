package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase  {
    private  WebDriver web;
    public static WebDriver driver;
    private static TestBase instance=new TestBase();
    public static Properties prop;
    public static FileInputStream fp;
    public static  TestBase returnInstance()
    {
      return instance;
    }
    private TestBase()
    {

    }

        public static void initn()
        {
            String browserName = prop.getProperty("browser");
            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            // driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD.TIMEOUT,TimeUnit.SECONDS);
            //If Application take too much time then go to Util Folder
            //public static long PAGE_LOAD_TIMEOUT=20;
            //public static long IMPLICIT_WAIT=30
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }
    public WebDriver returnDriver()
    {
        return driver;
    }


  // public static WebDriver getDriver() {
     //  return driver;
     // }

    public static void setDriver(WebDriver driver) {

        TestBase.driver = driver;
    }
    public static void setProp() {

        try {
            prop = new Properties();

            String className = TestBase.class.getName().replace(".", "/")+".class";
            URL classUrl  = TestBase.class.getClassLoader().getResource(className);
            String fullPath = classUrl==null ? null : classUrl.getPath();
            String absolutePath = fullPath.substring(1,fullPath.length()-className.length());
            fp = new FileInputStream(absolutePath + "/Config/config.properties");

            prop.load(fp);
            //prop.load(inputStream);
        } catch (Exception e) {
            System.out.println("There is some Issue" + e);
        }
    }
    }
