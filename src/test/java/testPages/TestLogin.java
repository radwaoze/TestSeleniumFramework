package testPages;

import baseMethods.BrowserSetup;
import baseMethods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

public class TestLogin {
    WebDriver driver;

    pages.HomePage homePage ;
    pages.UserRegisterationPage registerationPage;
    baseMethods.BrowserSetup BrowserSetup;
    baseMethods.Methods method;
    @BeforeMethod
    public void setup() {
        //WebDriverManager.chromedriver().setup();

        BrowserSetup = new BrowserSetup();
        driver = BrowserSetup.BrowserName("Chrome");
        BrowserSetup.maximizeScreen();
        method = new Methods(driver);
        method.navigateToAnyPage("https://demo.nopcommerce.com/");
        registerationPage = new UserRegisterationPage(driver);

    }

    @Test
    public void testRegister() {

        homePage = new HomePage(driver);
        homePage.openRegisterLink();
        registerationPage = new UserRegisterationPage(driver);
        registerationPage.registerForm("Ali" , "Elsayed", "ali@gmail.com" , "ahmed22");
        WebElement registerMsg = driver.findElement(By.cssSelector("div.result"));
        Assert.assertEquals(registerMsg.getText() , "Your registration completed");

    }

    @AfterMethod
    public void afterMethod() {
        BrowserSetup.closeBrowser();
    }

}
