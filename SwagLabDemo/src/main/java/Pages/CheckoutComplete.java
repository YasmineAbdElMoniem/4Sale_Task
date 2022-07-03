package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutComplete {

	AndroidDriver driver;

	By Back_Home = AppiumBy.accessibilityId("test-BACK HOME");

	public CheckoutComplete(AndroidDriver driver) {
		this.driver = driver;
	}

	public boolean BackHomeisDisplayed() {
		
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Back_Home));
		
		return driver.findElement(Back_Home).isDisplayed();

	}

}
