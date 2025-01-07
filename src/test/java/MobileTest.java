import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileTest {
    public static AndroidDriver driver; // Deklarasi AndroidDriver
    public static String baseUrl = "http://127.0.0.1:4723/";

    @Before
    public void setUp() throws MalformedURLException {
        // Inisiasi DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "11.0");
        capabilities.setCapability("appium:deviceName", "UwU");
        capabilities.setCapability("appium:automationName", "UIAutomator2");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "\\src\\test\\java\\apk\\Diet_meal.apk"); // Path APK
        capabilities.setCapability("appium:autoGrantPermissions", true);

        // Inisiasi AndroidDriver
        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url, capabilities);

        // Atur waktu tunggu default
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void testDietMealApp() {
        // Interaksi dengan elemen-elemen di aplikasi
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/et_name")).sendKeys("Budi");
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/et_weight")).sendKeys("50");
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/et_height")).sendKeys("165");
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/rb_male")).click();
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/bt_next")).click();
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/rb_medium")).click();
        driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/bt_finish")).click();

        // Assertion: Pastikan elemen hasil muncul
        boolean isDisplayed = driver.findElement(AppiumBy.id("com.fghilmany.dietmealapp:id/tv_header_name")).isDisplayed();
        assert isDisplayed : "Header name tidak ditemukan!";
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Tutup aplikasi setelah pengujian selesai
        }
    }
}
