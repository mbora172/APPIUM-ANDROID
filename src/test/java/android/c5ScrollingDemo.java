package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class c5ScrollingDemo extends base{
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //scroll not supported in appium u need android api
        //new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\")); this from android development
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
    }
}
