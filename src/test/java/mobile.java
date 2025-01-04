import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class mobile {
    public static AndroidDriver driver; //inisiasi android appium
    public static DesiredCapabilities capabilities; //inisiasi kapabilitas
    public static String baseUrl = "http://127.0.0.1:4723/wd/hub"; //appium v1, kalau v2 hapus wd/hub

    @Test
    public void main() throws MalformedURLException{
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        //capabilities.setCapability("app", System.getProperty("user.dir") + "/apps/Calculator.apk");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("noReset", "true");

        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url, capabilities);
    }
}
