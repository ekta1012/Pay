package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase  {
    public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream fp;

    public TestBase() {
        try {
            prop = new Properties();

            fp = new FileInputStream("C:\\Users\\abc\\IdeaProjects\\Pay\\src\\main\\java\\Config\\config.properties");

            prop.load(fp);
             //prop.load(inputStream);
        } catch (Exception e) {
            System.out.println("There is some Issue" + e);
        }
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
    }
