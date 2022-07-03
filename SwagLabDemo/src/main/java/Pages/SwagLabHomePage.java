package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SwagLabHomePage {

	AndroidDriver driver;

	By Cart_Icon = AppiumBy.accessibilityId("test-Cart");
	By AddToCartButton = AppiumBy.accessibilityId("test-ADD TO CART");

	public SwagLabHomePage(AndroidDriver driver) {
		this.driver = driver;
	}

	public Boolean CartIconIsDisplayed() {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Cart_Icon));
		
		return driver.findElement(Cart_Icon).isDisplayed();
	}

	public void ClickOnAddToCartButton() {
		
		driver.findElement(AddToCartButton).click();
	}

	public void ClickOnCartIcon(){

		
		driver.findElement(Cart_Icon).click();

	}
}
