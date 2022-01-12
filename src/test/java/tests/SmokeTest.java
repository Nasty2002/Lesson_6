package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest1(){
        LoginPage loginPage=new LoginPage(driver);

        loginPage.getEmailField().sendKeys(ReadProperties.getPassword());
        loginPage.getPasswordField().sendKeys(ReadProperties.getPassword());
        loginPage.getLoginButton().click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        driver.get("");


        dashboardPage = new DashboardPage(driver, true)


    }
}
