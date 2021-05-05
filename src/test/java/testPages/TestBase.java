package testPages;

import baseMethods.BrowserSetup;
import baseMethods.Methods;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    baseMethods.BrowserSetup BrowserSetup;
    baseMethods.Methods method;


    //@BeforeMethod(alwaysRun = true)
    //@Parameters("browser")
    //String browserName
    @BeforeSuite
    @Parameters({"browserName"})
    public void setup(@Optional("Chrome")String browserName) {

        BrowserSetup = new BrowserSetup();
        driver = BrowserSetup.BrowserName(browserName);
        BrowserSetup.maximizeScreen();
        method = new Methods(driver);
        method.navigateToAnyPage("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshot/" + result.getName()+".png"));
        }

    }

    @AfterSuite
    public void afterSuite()  {

        BrowserSetup.closeBrowser();
    }

}
