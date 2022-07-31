package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class c6DragDropDemo extends base{
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver=capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        TouchAction t=new TouchAction<>(driver);
        WebElement source=driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination=driver.findElementsByClassName("android.view.View").get(1);
   //longpress(source)/move(destination)//release
//        t.longPress(LongPressOptions.longPressOptions().withElement(element(source)))
//                .moveTo(element(destination)).release().perform();
        t.longPress(element(source)).moveTo(element(destination)).release().perform();


    }}

