package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegisterationPage;
import testPages.TestBase;

import java.util.concurrent.TimeUnit;

public class UserRegistration extends TestBase {
    pages.HomePage homePage ;
    pages.UserRegisterationPage registrationPage;


    @Given("^the user in the home page$")
    public void the_user_in_the_home_page() {
        homePage = new HomePage(driver);
        homePage.openRegisterLink();
    }

    @When("^I click on register button$")
    public void i_click_on_register_button() {

        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }

    @When("^I entered the user data$")
    public void i_entered_the_user_data() {

        registrationPage = new UserRegisterationPage(driver);
        registrationPage.registerForm("Salma", "Elsayed" , "salma142002@gmail.com", "123456");
    }

    @Then("^The registration page displayed successfully$")
    public void the_registration_page_displayed_successfully()  {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement registerMsg = driver.findElement(By.cssSelector("div.result"));
        Assert.assertEquals(registerMsg.getText() , "Your registration completed");

    }

}
