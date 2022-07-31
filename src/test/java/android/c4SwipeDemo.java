package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class c4SwipeDemo extends base{
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        TouchAction action=new TouchAction(driver);
        //longpress //on element/ few sec// move  another element release
        WebElement webElement=driver.findElementByXPath("//*[@content-desc='15']");
        WebElement webElement2=driver.findElementByXPath("//*[@content-desc='45']");
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(webElement))
                .withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(webElement2)).release().perform();


}}
