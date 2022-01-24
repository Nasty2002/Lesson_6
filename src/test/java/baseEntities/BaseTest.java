package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.MilestoneSteps;
import steps.ProjectSteps;
import untils.Listener;
import untils.Waits;

@Listeners(Listener.class)
public class BaseTest {
    protected WebDriver driver;
    private BrowsersService browsersService;
    protected Waits waits;

    protected ProjectSteps projectSteps;
    protected MilestoneSteps milestoneSteps;

    @BeforeClass
    public void setUp() {
        browsersService = new BrowsersService();
        driver.get(ReadProperties.getUrl());
        waits = new Waits(driver);
        projectSteps = new ProjectSteps(driver);
        milestoneSteps = new MilestoneSteps(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void closePage() {
        driver.quit();
    }
}
