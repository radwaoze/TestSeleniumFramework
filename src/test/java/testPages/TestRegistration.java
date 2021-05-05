package testPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

import java.util.concurrent.TimeUnit;

public class TestRegistration extends TestBase{
    pages.HomePage homePage ;
    pages.UserRegisterationPage registrationPage;
    pages.UserLoginPage loginPage;
    baseMethods.BrowserSetup BrowserSetup;
    baseMethods.Methods method;


    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    //String pass = fakeData.phoneNumber().toString();
    String pass = "radwa123";

    @Test
    public void TestRegister() {

       // method = new Methods(driver);
        //method.navigateToAnyPage("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        homePage.openRegisterLink();
        registrationPage = new UserRegisterationPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage.registerForm(firstName , lastName , email , pass);
        System.out.println("User Data : " + firstName + " " + lastName + " " + email + " " + pass);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement registerMsg = driver.findElement(By.cssSelector("div.result"));
        Assert.assertEquals(registerMsg.getText() , "Your registration completed");
        System.out.println("URL : " + driver.getCurrentUrl());
    }

    @Test(dependsOnMethods = "TestRegister")
    public void TestLogout()
    {
        System.out.println("URL 2 : " + driver.getCurrentUrl());
        homePage.userLogoutLink();
    }

    @Test(dependsOnMethods = "TestLogout")
    public void TestLogin() throws InterruptedException {

        System.out.println("URL 3 : " + driver.getCurrentUrl());
        homePage.openLoginLink();
        loginPage = new UserLoginPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.loginForm(email, pass);
    }


}
