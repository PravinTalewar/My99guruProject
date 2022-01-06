package Stepdef;

import Utills.BaseTest;
import Utills.Testcontext;
import io.cucumber.java.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@Log4j2
public class Hooks  extends BaseTest {
    Testcontext testcontext;

    public Hooks(Testcontext testcontext){
        this.testcontext = testcontext;
    }

    //WebDriver driver
    Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenario.log("executed before step");
    }

    @After
    public void cleanUP(Scenario scenario) {
        if (!( testcontext.getDriver() == null)) {
            testcontext.getDriver().quit();
        }
        scenario.log("executed after step");
    }
    @BeforeStep
    public void BeforeStep() throws InterruptedException {
        Thread.sleep(2000);
    }

    @AfterStep
    public void afterEachStep() {
        //    if (scenario.isFailed()) {
        if (!( testcontext.getDriver() == null)) {
            TakesScreenshot screenshot = (TakesScreenshot) testcontext.getDriver();
            byte[] data = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", "Failed Step Name: " + scenario.getName());
        }
        log.debug("Each step hook is executed, Screen shot taken");
        //  scenario.log("After each step");
    }

}
