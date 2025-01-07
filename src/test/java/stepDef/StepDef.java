package stepDef;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StepDef {

    public static AndroidDriver driver;
    public static String baseUrl = "http://127.0.0.1:4723/";
    public static DesiredCapabilities capabilities;

    @Given("open register page")
    public void open_register_page() throws MalformedURLException {
        // Write code here that turns the phrase above into concrete actions
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:deviceName", "UwU");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "\\src\\test\\java\\apk\\Diet_meal.apk"); // Path APK
        capabilities.setCapability("appium:autoGrantPermissions", true);

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @When("input data")
    public void input_data() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/et_name")).sendKeys("Budi");
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/et_weight")).sendKeys("50");
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/et_height")).sendKeys("165");
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/rb_male")).click();
        driver.findElement(By.id("com.fghilmany.dietmealapp:id/bt_next")).click();
    }

    @And("click next button")
    public void click_next_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/rb_medium")).click();
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/bt_finish")).click();
    }

    @Then("user in homepage diet app")
    public void user_in_diet_app() {
        // Write code here that turns the phrase above into concrete actions
        boolean isDisplayed = driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/tv_header_name")).isDisplayed();
        assert isDisplayed : "Header name tidak ditemukan!";
        driver.quit();
    }
}
