package android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class c8Ecommerce_tc3 extends base2 {

        public static void main(String[] args) throws MalformedURLException {
            AndroidDriver<AndroidElement> driver=capabilities();
            driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
            driver.hideKeyboard();
            driver.findElementByXPath("//*[@text='Female']").click();
            driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
            driver.findElementByXPath("//*[@text='Argentina']").click();
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
            driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
            int count= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
            for (int i=0;i<count;i++){
               String text= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
                if (text.equalsIgnoreCase("Jordan 6 Rings")){
                    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                    break;
                }
            }
            driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        }
}
