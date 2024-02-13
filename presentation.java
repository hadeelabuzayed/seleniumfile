package magentoTestCases;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class presentation extends parameters {
	SoftAssert softassert = new SoftAssert();
	WebDriverWait wait;
	  

	@BeforeTest
	public void Setup() {
		driver.manage().window().maximize();
		driver.get(URL);
		

	}

	@Test(priority = 1)
	public void SignUp() throws InterruptedException {
		driver.get(signUpUrl);
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement Button = driver.findElement(By.className("primary"));
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastNames);
		Email.sendKeys(EmailFinal);
		Password.sendKeys(FinalPassoward);
		confirmPassword.sendKeys(FinalPassoward);
		Button.click();
		softassert.assertEquals(driver.getCurrentUrl(), SignUpSuccesfullyUrl,
				"test the current URL with succsefully SignUp page");
		softassert.assertAll();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void LogoutTest() throws InterruptedException {

		driver.get(logoutUrl);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void LoginTest() throws InterruptedException {

		driver.get(loginUrl);
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passInput = driver.findElement(By.id("pass"));
		WebElement loginbut = driver.findElement(By.id("send2"));
		emailInput.sendKeys(EmailFinal);
		passInput.sendKeys(FinalPassoward);
		loginbut.click();
		softassert.assertEquals(driver.getCurrentUrl(), loginSuccessfullyUrl,
				"test the current URL with succsefully login page");
		softassert.assertAll();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void SubscribtionTest() throws InterruptedException {
		WebElement subscribeLink = driver
				.findElement(By.cssSelector("a[href='https://softwaretestingboard.com/subscribe/']"));
		subscribeLink.click();
		WebElement emailAddress = driver.findElement(By.cssSelector("#mce-EMAIL"));
		WebElement FirstName = driver.findElement(By.cssSelector("#mce-FNAME"));
		WebElement LastName = driver.findElement(By.cssSelector("#mce-LNAME"));
		WebElement CompanyName = driver.findElement(By.cssSelector("#mce-COMPANY"));
		WebElement position = driver.findElement(By.cssSelector("#mce-POSITION"));
		emailAddress.sendKeys(EmailFinal);
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastNames);
		CompanyName.sendKeys("LTUC");
		position.sendKeys("QA");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");
		Thread.sleep(5000);
		driver.findElement(By.className("button")).click();
		WebElement subscriptionMsg = driver.findElement(By.id("mce-success-response"));
		String MsgResponse=subscriptionMsg.getText();
		softassert.assertTrue(MsgResponse.contains("subscription is done and an email will be sent"),
		        "Subscription message does not contain the expected substring.");
		
	}
	@Test(priority = 5)
	public void AddToCartTest() throws InterruptedException { 
	    for (int i = 2; i < 5; i++) {
		  driver.get(AddToCartUrl);
    		WebElement ItemsContainer = driver.findElement(By.cssSelector(".products.wrapper.grid.products-grid"));
    		List<WebElement> allItems = ItemsContainer.findElements(By.tagName("li"));
            WebElement item = allItems.get(i);
			addItem(item);
			Thread.sleep(2000);
			}
		}
	    private void addItem(WebElement item) throws InterruptedException {
			item.click();
			Thread.sleep(1000);
			//driver.findElement(By.id("bundle-slide")).click();
			//driver.findElement(By.id("bundle-option-1-1")).click();
			//driver.findElement(By.id("bundle-option-3-5")).click();
			WebElement AddtoCart = driver.findElement(By.id("product-addtocart-button"));
			AddtoCart.click();
		
	     
	}

	@Test(priority = 6)
	public void sortItems() {
		driver.get(sortingUrl);
		WebElement staticDropdown = driver.findElement(By.id("sorter"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(2);

		// Extract prices using Java streams
		List<WebElement> priceElements = driver.findElements(By.className("price"));
		List<Double> prices = priceElements.stream().map(priceElement -> priceElement.getText().trim())
				.filter(priceString -> !priceString.isEmpty()) // Skip empty strings
				.map(priceString -> Double.parseDouble(priceString.replaceAll("[^0-9.]", "")))
				.collect(Collectors.toList());

		// Sort the prices
		prices.sort(Double::compareTo);

		// Compare the first and last prices
		double firstPrice = prices.get(0);
		double lastPrice = prices.get(prices.size() - 1);

		// Assertion: The first price should be lower than the last one
		Assert.assertTrue(firstPrice < lastPrice, "Prices are not sorted correctly.");
		System.out.println(firstPrice);
		System.out.println(lastPrice);
	}

	@AfterTest
	public void AfterTest() {
		//driver.close();

	}
}
