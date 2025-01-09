import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

 class AndroidTest {

    @Test
     void androidLaunchTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options= new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Pixel6");
        options.setApp(System.getProperty("user.dir")+"/apps/SauceLabs.apk");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(5000);
       WebElement username = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
       WebElement password=driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
       WebElement loginBtn=driver.findElement(By.xpath("//android.widget.TextView[@text=\"LOGIN\"]"));

       username.sendKeys("standard_user");
       Thread.sleep(5000);
       password.sendKeys("secret_sauce");
       Thread.sleep(5000);
       loginBtn.click();
       Thread.sleep(5000);
       WebElement productTitle=driver.findElement(By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]"));
       Assert.isTrue(productTitle.isDisplayed(),"Login UnSuccessfull");
       driver.quit();

    }


}
