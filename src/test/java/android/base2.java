package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class base2 {
    public static AndroidDriver<AndroidElement> driver;
    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        //chrome- url first things for selo
        //in appium instead url u must give app
        //app .apk, devicename, 4723 port appium server
        //commands
        File appDir = new File("src");//parent file path
        //creating file with apk path for cap with parent file and file name
        File app = new File(appDir, "General-Store.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());//need apk path instead create file
        //UI automater-> android apps
        //uiautomator2 //appium developed from apple
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);

        //cap, in our local server and port
        // we gave local url as new url otherwise java things its just string
        //and we tell take cap from server as driver argument
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //now its became like selo driver

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;}



}
