package AndroidTests;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import Pages.LoginPage;
import Pages.SwagLabHomePage;
import Pages.CheckoutPage;
import Pages.CheckOutInformation;
import Pages.CheckoutComplete;
import Pages.CheckoutOverview;

public class NewTestForLoginAndCheckout {
	AndroidDriver driver;
	LoginPage login;
	SwagLabHomePage Home;
	CheckoutPage checkout;
	CheckOutInformation checkoutInfo;
	CheckoutOverview overview;
	CheckoutComplete Complete;
	
	@BeforeClass
	public void OpenSwagLabApp() throws MalformedURLException {

		DesiredCapabilities Caps = new DesiredCapabilities();
		Caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		Caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
		Caps.setCapability("appPackage", "com.swaglabsmobileapp");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Caps);
		login = new LoginPage(driver);
		Home = new SwagLabHomePage(driver);
		checkout = new CheckoutPage(driver);
		checkoutInfo = new CheckOutInformation(driver);
		overview = new CheckoutOverview(driver);
		Complete = new CheckoutComplete(driver);
	}

	@Test(description="Given I am on the Swag Lab Login page, Then the User is logging into SwagLab App and Cart Icon Is displayed'.")
	public void CheckUserisLoggingIntoSwagLab(){

		login.LoginPageIsScrollDown();
		login.ClickOnCredentials();
		login.ClickOnLoginButton();
		Assert.assertTrue(Home.CartIconIsDisplayed());
	}

	@Test(description="Given I am on the SwagLab Home page, Then the User add a product to Cart'.")
	public void VerifyThatTheProductsIsAddedToCart(){

		Home.ClickOnAddToCartButton();
		Home.ClickOnCartIcon();
		Assert.assertTrue(checkout.Checkout_ButtonIsDisplayed());
		checkout.ClickOnCheckout_Button();
	}

	@Test(description="Given I am on the CheckOut Information page, Then the User can add Checkout Informations to complete the purchase.")
	public void VerifyThatUserCanAddCheckoutinformation(){

		checkoutInfo.EnterCheckoutInformations("Test", "Test", "123456");
		checkoutInfo.ClickOnContinueButton();	
		Assert.assertTrue(overview.CheckOutOverviewIsDisplayed());;
	}
	
	@Test(description="Given I am on the CheckOut Overview page, Then the sucessfully message appears for completing purchase process.")
	public void VerifyThatUserCanBuyTheProductSucessfully(){

		overview.OverviewIsScrollDown();
		overview.ClickOnFinishButton();
		Assert.assertTrue(Complete.BackHomeisDisplayed());
	}
	
	@AfterClass
	public void CloseSwagLabApp(){

		driver.quit();
	}
}
