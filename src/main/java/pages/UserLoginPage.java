package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static baseMethods.Methods.clickButton;
import static baseMethods.Methods.setText;

public class UserLoginPage {
    WebDriver driver;

    public UserLoginPage(WebDriver driver)
    {
        this.driver = driver;
    }


    public void loginForm(String email , String password)
    {
        WebElement emailTxt = driver.findElement(By.id("Email"));
        WebElement passTxt = driver.findElement(By.id("Password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.button-1.login-button"));

        setText(emailTxt , email);
        setText(passTxt , password);
        clickButton(loginBtn);
    }
}
