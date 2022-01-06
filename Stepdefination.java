package Stepdef;

import Utills.BaseTest;
import Utills.DriverFactory;
import Utills.Testcontext;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Stepdefination extends BaseTest {
    Scenario scenario;
    Testcontext testcontext;

   public Stepdefination(Testcontext testcontext){
       this.testcontext = testcontext;
    }

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenario.log("executed before step");
    }

    @Given("user operated the browser")
    public void user_operated_the_browser() {
       //String browserName= System.getProperty("browser");
        testcontext.setDriver(DriverFactory.createInstance("firefox"));
        testcontext.getDriver().manage().window().maximize();
        testcontext.getDriver().manage().deleteAllCookies();
        testcontext.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        testcontext.getDriver().get(url);

    }
    @Given("user click Resister page")
    public void user_click_resister_page() {
        testcontext.getDriver().findElement(By.xpath("//a[@href='register.php']")).click();
    }
    @Then("user fill Resister form")
    public void user_fill_resister_form(){
        testcontext.getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");
        testcontext.getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("Smith");
        testcontext.getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("9800000001");
        testcontext.getDriver().findElement(By.xpath("//input[@id='userName']")).sendKeys("johnsmith2021@yopmail.com");
        testcontext.getDriver().findElement(By.xpath("//input[@name='address1']")).sendKeys("3201,GlobalStore,NY");
        testcontext.getDriver().findElement(By.xpath("//input[@name='city']")).sendKeys("NewYork");
        testcontext.getDriver().findElement(By.xpath("//input[@name='state']")).sendKeys("US");
        testcontext.getDriver().findElement(By.xpath("//input[@name='postalCode']")).sendKeys("90129");
        WebElement dropdownCouNum = testcontext.getDriver().findElement(By.xpath("//select[@name='country']"));
        Select selectCount = new Select(dropdownCouNum);
        selectCount.selectByIndex(246);
        testcontext.getDriver().findElement(By.xpath("//input[@id='email']"));
        testcontext.getDriver().findElement(By.xpath("//input[@name='password']"));
        testcontext.getDriver().findElement(By.xpath("//input[@name='confirmPassword']"));

    }
    @Given("user operated browser")
    public void user_operated_browser() {
        testcontext.setDriver(DriverFactory.createInstance("firefox"));
        testcontext.getDriver().manage().window().maximize();
        testcontext.getDriver().manage().deleteAllCookies();
        testcontext.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        testcontext.getDriver().get(url);
    }
    @Given("user enter user name and password")
    public void user_enter_user_name_and_password() {
        testcontext.getDriver().findElement(By.xpath("//input[@name='userName']"));
        testcontext.getDriver().findElement(By.xpath("//input[@name='password']"));
    }
    @Then("user click submit button")
    public void user_click_submit_button(){
        testcontext.getDriver().findElement(By.xpath("//input[@name='submit']"));
    }
    @Given("user automated the browser")
    public void user_automated_the_browser() {
        testcontext.setDriver(DriverFactory.createInstance("firefox"));
        testcontext.getDriver().manage().window().maximize();
        testcontext.getDriver().manage().deleteAllCookies();
        testcontext.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        testcontext.getDriver().get(url);
    }
    @Given("user click flight option")
    public void user_click_flight_option() {
        testcontext.getDriver().findElement(By.xpath("//a[@href='reservation.php']"));
    }
    @Then("user enter flight detail")
    public void user_enter_flight_detail(){
        WebElement dropdownCouNum = testcontext.getDriver().findElement(By.xpath("//select[@name='fromPort']"));
        Select selectCount = new Select(dropdownCouNum);
        selectCount.selectByIndex(4);

        WebElement dropdownReturn = testcontext.getDriver().findElement(By.xpath("//select[@name='toMonth']"));
        Select selectRetCon = new Select(dropdownReturn);
        selectRetCon.selectByIndex(8);
    }
    @Then("user click continue button")
    public void user_click_continue_button() {
        testcontext.getDriver().findElement(By.xpath("//input[@name='findFlights']")).click();

    }
}
