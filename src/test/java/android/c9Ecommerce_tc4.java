package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class c9Ecommerce_tc4 extends base2 {

        public static void main(String[] args) throws MalformedURLException, InterruptedException {
            AndroidDriver<AndroidElement> driver=capabilities();
            driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
            driver.hideKeyboard();
            driver.findElement(By.xpath("//*[@text='Female']")).click();
            driver.findElement(By.id("android:id/text1")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
            //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
            driver.findElement(By.xpath("//*[@text='Argentina']")).click();
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
            driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
            driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
            driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
            Thread.sleep(4000);
            int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
            double sum=0;
            for(int i=0;i<count;i++)
            {String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
                double amount=getAmount(amount1);
                sum=sum+amount;//280.97+116.97
            }
            System.out.println(sum+" sum of products");
            String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
            total= total.substring(1);
            double totalValue=Double.parseDouble(total);
            System.out.println(totalValue+"Total value of products");
            Assert.assertEquals(sum, totalValue);
//Mobile Gestures

            WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
          TouchAction t=new TouchAction(driver);
             t.tap(tapOptions().withElement(element(checkbox))).perform();
           driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
           Thread.sleep(3000);//webview takes some times
           //hybrid we gonna switch to webView like windows handles context handle will store and switch
            Set<String> contexts=driver.getContextHandles();
            List<String> contextsList = contexts.stream().collect(Collectors.toList());
            //print results//NATIVE_APP //WEBVIEW_com.androidsample.generalstore// means 2 element so hybrid
            contextsList.stream().forEach(s-> System.out.println(s));
            //driver.context like windows handle u give string code to switch
            driver.context(contextsList.get(1));//or driver.context("WEBVIEW_com.androidsample.generalstore")
            driver.findElement(By.name("q")).sendKeys("Hello", Keys.ENTER);//selolocators
            driver.pressKey(new KeyEvent(AndroidKey.BACK));//android phone button
            driver.context(contextsList.get(0));//native back

 }
public static double getAmount(String value){
            value=value.substring(1);
            double amount=Double.parseDouble(value);
            return amount;
}
}
