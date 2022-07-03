package Pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	    AndroidDriver driver;

		By Cerdintials = By.className("android.widget.TextView");
		By LoginButton = AppiumBy.accessibilityId("test-LOGIN");

				
		public LoginPage(AndroidDriver driver) {
			this.driver = driver;
		}


		public void LoginPageIsScrollDown() {
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"standard_user\").instance(0))"))
					.click();		}

		public void ClickOnCredentials() {
			driver.findElement(Cerdintials).click();

		}

		public void ClickOnLoginButton()
		{			
			driver.findElement(LoginButton).click();

		}
	}

