package Pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CheckOutInformation {

	AndroidDriver driver;
	By FirstName = AppiumBy.accessibilityId("test-First Name");
	By LastName = AppiumBy.accessibilityId("test-Last Name");
	By ZipCode = AppiumBy.accessibilityId("test-Zip/Postal Code");
	By ContinueButton = AppiumBy.accessibilityId("test-CONTINUE");

	public CheckOutInformation(AndroidDriver driver) {
		this.driver = driver;
	}

	public void EnterCheckoutInformations(String Fn, String LN, String Code) {
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FirstName));
		
		driver.findElement(FirstName).sendKeys(Fn + Keys.ENTER);
		driver.findElement(LastName).sendKeys(LN + Keys.ENTER);
		driver.findElement(ZipCode).sendKeys(Code);

	}

	public void ClickOnContinueButton(){

		driver.findElement(ContinueButton).click();
	}

}
