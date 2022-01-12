package pages;

import baseEntities.BasePage;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;

public class LoginPage extends BasePage{
    private static String ENDPOINT = "/auth/login/";

    //Описание элементов страницы
    private By PAGE_OPENED_IDENTIFIER = By.className("logo-loginpage");

    private By email_Selector = By.id("name");

    private By password_Selector = By.id("password");

    private By login_Selector = By.id("button_primary");

    //конструктор страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened(){
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    //реализация геттеров элементов
    public WebElement getEmailField(){
        return driver.findElement(email_Selector);
    }

    public WebElement getPasswordField(){
        return driver.findElement(password_Selector);
    }

    public WebElement getLoginButton(){
        return driver.findElement(login_Selector);
    }

    //реализация базовых методов
    public void login(String username, String password){
        getEmailField().sendKeys(ReadProperties.getUsername());
        getPasswordField().sendKeys(ReadProperties.getPassword());
        getLoginButton().click();
    }

}
