package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutOverview {

	AndroidDriver driver;

	By CheckOut_Overview = By.className("android.widget.TextView");
	By FinishButton = By.xpath("//android.widget.TextView[@text='FINISH']");

	public CheckoutOverview(AndroidDriver driver) {
		this.driver = driver;
	}

	public Boolean CheckOutOverviewIsDisplayed() {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CheckOut_Overview));

		return driver.findElement(CheckOut_Overview).isDisplayed();

	}

	public void OverviewIsScrollDown() {
		driver.findElement(AppiumBy.androidUIAutomator(
		"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"test-FINISH\").instance(0))"));
	}

	public void ClickOnFinishButton() {
		driver.findElement(FinishButton).click();
	}
}
