package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.PanelUI;

import static baseMethods.Methods.clickButton;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //@FindBy(cssSelector = "Register")

    public void openRegisterLink()
    {
        WebElement registerLink = driver.findElement(By.cssSelector("a.ico-register"));

        clickButton(registerLink);
    }

    public  void userLogoutLink()
    {
        WebElement logoutLink = driver.findElement(By.cssSelector("a.ico-logout"));

        clickButton(logoutLink);
    }

    public void openLoginLink()
    {
        WebElement loginLink = driver.findElement(By.cssSelector("a.ico-login"));

        clickButton(loginLink);
    }

}
