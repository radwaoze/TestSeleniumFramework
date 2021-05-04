package testPages;

import baseMethods.BrowserSetup;
import baseMethods.Methods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

import java.io.File;
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
    public void TestRegister() {

       // method = new Methods(driver);
        //method.navigateToAnyPage("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        homePage.openRegisterLink();
        registerationPage = new UserRegisterationPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registerationPage.registerForm("Radwa" , "Elsayed", "radwa101999@gmail.com" , "salma22");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement registerMsg = driver.findElement(By.cssSelector("div.result"));
        Assert.assertEquals(registerMsg.getText() , "Your registration completed");
        System.out.println("URL : " + driver.getCurrentUrl());
         //nextURL = driver.getCurrentUrl();
    }

    @Test(dependsOnMethods = "TestRegister")
    public void TestLogout()
    {
       // method.navigateToAnyPage(nextURL);
        System.out.println("URL 2 : " + driver.getCurrentUrl());
        homePage = new HomePage(driver);
        homePage.userLogoutLink();
    }

    @Test(dependsOnMethods = "TestLogout")
    public void TestLogin() throws InterruptedException {

        System.out.println("URL 3 : " + driver.getCurrentUrl());
        homePage.openLoginLink();
        loginPage = new UserLoginPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.loginForm("radwa101999@gmail.com" , "radwa22");
    }


}
