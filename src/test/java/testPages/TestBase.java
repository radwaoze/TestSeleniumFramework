package testPages;

import baseMethods.BrowserSetup;
import baseMethods.Methods;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    baseMethods.BrowserSetup BrowserSetup;
    baseMethods.Methods method;


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")

    public void setup(String browserName) {

        BrowserSetup = new BrowserSetup();
        driver = BrowserSetup.BrowserName(browserName);
        BrowserSetup.maximizeScreen();
        method = new Methods(driver);
        method.navigateToAnyPage("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public void afterTest() {
        BrowserSetup.closeBrowser();
    }
}
