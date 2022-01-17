package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import enums.ProjectType;
import models.Project;
import models.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import untils.Randomization;
import untils.Retry;

public class SmokeTest extends BaseTest {
    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test
    public void loginTestWithBuilder() {
        UserBuilder user = new UserBuilder.Builder()
                .withEmail(ReadProperties.getUsername())
                .withPassword(ReadProperties.getPassword())
                .build();

        LoginPage loginPage = new LoginPage(driver);
        //loginPage.login(user);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @Test (retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getUsername());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("https://qa1504.testrail.io/index.php?/admin/overview");

        dashboardPage = new DashboardPage(driver, true);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());

    }
    private void setUpProjects(){
        addProject = new Project();
        addProject.setName(Randomization.getRandomString(8));
        addProject.setTypeOfProject(ProjectType.MULTIPLE);

        updateProject = new Project();
        updateProject.setName(Randomization.getRandomString(8));
        updateProject.setTypeOfProject(Randomization.getRandomType(2));
    }
}
