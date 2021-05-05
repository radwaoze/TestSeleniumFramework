package testPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

import java.util.concurrent.TimeUnit;


public class UserRegistrationGrid extends TestBaseGrid{

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
    public void UserCanRegisterSuccessfully() {

        // method = new Methods(driver);
        //method.navigateToAnyPage("https://demo.nopcommerce.com/");
        homePage = new HomePage(getDriver());
        homePage.openRegisterLink();
        registrationPage = new UserRegisterationPage(getDriver());
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationPage.registerForm(firstName , lastName , email , pass);
        System.out.println("User Data : " + firstName + " " + lastName + " " + email + " " + pass);
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement registerMsg = getDriver().findElement(By.cssSelector("div.result"));
        Assert.assertTrue(registerMsg.getText().contains("Your registration completed"));
        System.out.println("URL : " + getDriver().getCurrentUrl());
    }

    @Test(dependsOnMethods = "UserCanRegisterSuccessfully")
    public void RegisteredUserCanLogout()
    {
        System.out.println("URL 2 : " + getDriver().getCurrentUrl());
        homePage.userLogoutLink();
    }

    @Test(dependsOnMethods = "RegisteredUserCanLogout")
    public void RegisteredUserCanLogin() throws InterruptedException {

        System.out.println("URL 3 : " + getDriver().getCurrentUrl());
        homePage.openLoginLink();
        loginPage = new UserLoginPage(getDriver());
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.loginForm(email, pass);
    }

}
