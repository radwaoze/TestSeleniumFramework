package pages;

import baseMethods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static baseMethods.Methods.clickButton;
import static baseMethods.Methods.setText;

public class UserRegisterationPage {

    WebDriver driver;

    public UserRegisterationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //@FindBy(id="gender-male")
    //WebElement genderRadioBtn;



    public void registerForm(String fName , String lName , String email , String password)
    {
        WebElement genderRadioBtn = driver.findElement(By.id("gender-male"));
        WebElement fNameTxt = driver.findElement(By.id("FirstName"));
        WebElement lNameTxt = driver.findElement(By.id("LastName"));
        WebElement emailTxt = driver.findElement(By.id("Email"));
        WebElement passTxt = driver.findElement(By.id("Password"));
        WebElement confirmpassTxt = driver.findElement(By.id("ConfirmPassword"));
        WebElement registerBtn = driver.findElement(By.id("register-button"));


        clickButton(genderRadioBtn);
        setText(fNameTxt, fName);
        setText(lNameTxt, lName);
        setText(emailTxt, email);
        setText(passTxt, password);
        setText(confirmpassTxt, password);
        clickButton(registerBtn);
    }

}
