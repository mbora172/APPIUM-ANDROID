package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class c1Basics extends Hybridbase{
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("real");
        //xpath id className, androidUIautomator
        //xpath Syntax
        //tagName[@attribute='value']
        driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("hello");
       // driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
        driver.findElementsByClassName("android.widget.Button").get(1).click();


    }
}
