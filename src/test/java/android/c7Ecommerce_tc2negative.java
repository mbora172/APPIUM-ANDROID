package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;

public class c7Ecommerce_tc2negative extends base2 {

        public static void main(String[] args) throws MalformedURLException {
            AndroidDriver<AndroidElement> driver=capabilities();
            //driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
         //   driver.hideKeyboard();
            driver.findElementByXPath("//*[@text='Female']").click();
            driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
            driver.findElementByXPath("//*[@text='Argentina']").click();
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
            //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
        ///   xpath( "//android.widget.Toast[1]") //toast messages is u can not see but default this
            //message will be in name attribute
           String toastmessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
            System.out.println(toastmessage);
            Assert.assertEquals(toastmessage,"Please enter your name");//actual validation


        }
}
