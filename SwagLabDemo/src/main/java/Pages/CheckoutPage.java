package Pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutPage {

	AndroidDriver driver;

	By Checkout_Button = AppiumBy.accessibilityId("test-CHECKOUT");

	public CheckoutPage(AndroidDriver driver) {
		this.driver = driver;
	}

	public Boolean Checkout_ButtonIsDisplayed() {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Checkout_Button));
		
		return driver.findElement(Checkout_Button).isDisplayed();
	}

	public void ClickOnCheckout_Button(){
		
		driver.findElement(Checkout_Button).click();
	}

}
