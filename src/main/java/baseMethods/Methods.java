package baseMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods {
    WebDriver driver;

    public Methods(WebDriver driver)
    {
        this.driver = driver;
    }

    /*public boolean isElementedPresent(By elementPath) {
        try {
            driver.findElement(elementPath);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }*/
    public void navigateToAnyPage(String homeUrl)
    {
            driver.get(homeUrl);
    }
    public static void clickButton (WebElement button)
    {
        button.click();
    }
    public static void setText (WebElement textElement , String text)
    {
        textElement.sendKeys(text);
    }
}
