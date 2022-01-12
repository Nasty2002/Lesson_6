package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import untils.Listener;
import untils.Waits;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    private BrowsersService browsersService;
    protected Waits waits;

    @BeforeClass
    public void openPage() {
        browsersService = new BrowsersService();
        driver.get(ReadProperties.getUrl());
        waits = new Waits(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void closePage() {
        driver.quit();
    }
}
