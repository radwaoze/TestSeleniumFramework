package testPages;

import baseMethods.BrowserSetup;
import baseMethods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestRegistration extends TestBase{
    pages.HomePage homePage ;
    pages.UserRegisterationPage registerationPage;
    pages.UserLoginPage loginPage;
    baseMethods.BrowserSetup BrowserSetup;
    baseMethods.Methods method;


   // @BeforeMethod
  //  @Parameters(("browser"))

    @Test
    public void testRegisterSuccessfully() {

        method = new Methods(driver);
        method.navigateToAnyPage("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        homePage.openRegisterLink();
        registerationPage = new UserRegisterationPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        registerationPage.registerForm("Radwa" , "Elsayed", "radwa101999999@gmail.com" , "salma22");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement registerMsg = driver.findElement(By.cssSelector("div.result"));
        Assert.assertEquals(registerMsg.getText() , "Your registration completed");
        System.out.println("URL " + driver.getCurrentUrl());
         //nextURL = driver.getCurrentUrl();
    }
/*
    @Test(dependsOnMethods = "testRegisterSuccessfully")
    public void testLogoutSuccessfully()
    {
       // method.navigateToAnyPage(nextURL);
        System.out.println(driver.getCurrentUrl());
        homePage = new HomePage(driver);
        homePage.userLogoutLink();
    }

    @Test(dependsOnMethods = "testLogoutSuccessfully")
    public void testLoginSuccessfully() throws InterruptedException {

        homePage.openLoginLink();
        loginPage = new UserLoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.loginForm("salma20200@gmail.com" , "radwa22");
    }
*/

}
