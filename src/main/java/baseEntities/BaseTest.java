package baseEntities;

import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        switch (ReadProperties.getBrowserName().toLowerCase(Locale.ROOT)){
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--silent");
   //           chromeOptions.addArguments("--start-maximized");  //не работает на маке
                chromeOptions.setHeadless(ReadProperties.isHeadless());

                driver= new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

                driver=new FirefoxDriver();
                break;
            case "Edge":
                WebDriverManager.getInstance(DriverManagerType.EDGE).setup();

                driver=new EdgeDriver();
                break;
            default:
                System.out.println("This type of browser is not supported.");
                break;
        }

        driver.manage().window().maximize();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
