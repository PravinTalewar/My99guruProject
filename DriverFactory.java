package Utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DriverFactory {
    public static WebDriver createInstance(String browserName) {

        WebDriver driver = null;
        switch (browserName.trim().toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "Chrome":
                driver = new ChromeDriver();
                break;
            default:
                Assert.fail("No Such Method Defined");
        }
        return driver;
    }
}
