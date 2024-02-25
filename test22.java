
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class test22 extends parameters {

	@BeforeTest
	public void Setup() {
		driver.manage().window().maximize();
		driver.get(URL);

	}

	@Test(priority = 1)
	public void LoginTest() throws InterruptedException {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		WebElement Username = driver.findElement(By.cssSelector(".login_Form input[type=text]"));
		Username.sendKeys(userInput);
		WebElement password = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		password.sendKeys(passwordInput);
		WebElement checkboxButton = driver.findElement(By.cssSelector("input[type='checkbox']"));
		checkboxButton.click();
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginButton.click();
		Thread.sleep(5000);

		// Verify if the URL navigate to homepage
		Assert.assertEquals(driver.getCurrentUrl(), mainURL);

	}

	@Test(priority = 5, enabled = false)
	public void LogoutTest() throws InterruptedException {
		driver.get(mainURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement profileButton = driver.findElement(By.cssSelector("i.fa.fa-angle-down.mr-2::before"));
		profileButton.click();
		WebElement logoutButton = driver.findElement(By.id("logoutBtn"));
		logoutButton.click();

		WebElement popUpMsg = driver.findElement(
				By.cssSelector("div[class='mt-2 ml-auto mr-auto'] button[class='btn custom-btn-primary']"));
		popUpMsg.click();

		softassert.assertEquals(driver.getCurrentUrl(), URL, "logout process is fail");
		softassert.assertAll();
		Thread.sleep(5000);
	}

	@Test(priority = 2, enabled = false)
	public void BuyFromOrderEntry() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement symbolInput = driver.findElement(By.xpath(
				"//div[@class='Laptop-BuyOrdersEntry display-vertically']//div[@class='bg-grey']//div[@class='ml-3 mt-2 mr-3']//div//input[@placeholder='Symbol']"));

		// WebElement
		// symbolInput=driver.findElement(By.cssSelector("div[class='select-search
		// has-focus'] input[placeholder='Symbol']"));
		symbolInput.sendKeys("EMA");
		// driver.findElement(By.cssSelector("input[value=\"EMAAR\"]\r\n")).click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("button[value='EMAAR']"));
		for (WebElement option : options) {
			if (option.getText().equals("EMAAR")) {
				option.click();

				break;

			}
		}

		WebElement AccountDropdown = driver
				.findElement(By.xpath("//div[@id='buy-order-box']//select[@id='accountNumberBuyOrder']"));
		Select dropdown2 = new Select(AccountDropdown);
		dropdown2.selectByValue("2947539");
		WebElement QTYInput = driver.findElement(By.xpath(
				"//div[@class='Laptop-BuyOrdersEntry display-vertically']//div[@class='ml-2 mr-2 mt-2']//div//input[@id='quantityBuyOrders']"));
		QTYInput.sendKeys("2");
		WebElement priceInput = driver.findElement(By.xpath(
				"//div[@class='Laptop-BuyOrdersEntry display-vertically']//div[@class='ml-2 mr-2 mt-2']//div//div//input[@id='priceBuyOrders']"));
		priceInput.sendKeys("7.1");

		WebElement OrderTypeDropdown = driver
				.findElement(By.xpath("//div[@id='buy-order-box']//select[@id='orderTypeBuyOrder']"));
		Select dropdown3 = new Select(OrderTypeDropdown);
		dropdown3.selectByValue("2");

		WebElement validityInput = driver.findElement(By
				.xpath("//div[@class='Laptop-BuyOrdersEntry display-vertically']//select[@id='validityDateBuyOrder']"));
		Select dropdown4 = new Select(validityInput);
		dropdown4.selectByValue("0001");

		WebElement actionType = driver
				.findElement(By.xpath("//div[@id='buy-order-box-Action']//select[@name='orderTypeBuyOrder']"));
		Select dropdown5 = new Select(actionType);
		dropdown5.selectByValue("B");
		WebElement BuyButton = driver
				.findElement(By.cssSelector("div[id='buy-order-entry-btn'] div:nth-child(1) button:nth-child(1)"));
		BuyButton.click();
		Thread.sleep(3000);
		WebElement ConfirmButton = driver.findElement(
				By.cssSelector("div[class='mt-2 ml-auto mr-auto'] button[class='btn custom-btn-primary']"));

		ConfirmButton.click();
	}

	@Test(priority = 3, enabled = false)
	public void ReportTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement DownloadReport = driver.findElement(
				By.cssSelector("div[class='header-dots'] div:nth-child(1) button:nth-child(1) span:nth-child(1)"));
		DownloadReport.click();
		WebElement staticDropdown = driver.findElement(By.cssSelector("#accountNumberStatementByEmail"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("2948861");
		WebElement FromDate = driver
				.findElement(By.cssSelector("div[class='position-calendar'] input[placeholder='----']"));
		FromDate.click();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
		String currentDay = formatter.format(currentDate);
		WebElement CurrentDateElement = driver.findElement(By.xpath(
				"//button[@class='react-calendar__tile react-calendar__tile--now react-calendar__tile--active react-calendar__tile--range react-calendar__tile--rangeStart react-calendar__tile--rangeEnd react-calendar__tile--rangeBothEnds react-calendar__month-view__days__day react-calendar__month-view__days__day--weekend']"));
		CurrentDateElement.click();
		WebElement staticDropdown2 = driver.findElement(By.cssSelector("#statementByEmailDropdown"));
		Select dropdown2 = new Select(staticDropdown);
		dropdown2.selectByIndex(2);
		WebElement submitButton = driver.findElement(By.cssSelector(".btn.custom-btn-primary.mt-3"));
		submitButton.click();
		Thread.sleep(9000);

	}

	@Test(priority = 4, enabled = false)
	public void SellFromOrderEntry() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement symbolInput = driver.findElement(By.xpath(
				"//div[@class='Laptop-BuyOrdersEntry display-vertically']//div[@class='bg-grey']//div[@class='ml-3 mt-2 mr-3']//div//input[@placeholder='Symbol']"));

		// WebElement
		// symbolInput=driver.findElement(By.cssSelector("div[class='select-search
		// has-focus'] input[placeholder='Symbol']"));
		symbolInput.sendKeys("EMA");
		// driver.findElement(By.cssSelector("input[value=\"EMAAR\"]\r\n")).click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("button[value='EMAAR']"));
		for (WebElement option : options) {
			if (option.getText().equals("EMAAR")) {
				option.click();

				break;

			}
		}

		WebElement AccountDropdown = driver
				.findElement(By.xpath("//div[@id='buy-order-box']//select[@id='accountNumberBuyOrder']"));
		Select dropdown2 = new Select(AccountDropdown);
		dropdown2.selectByValue("2947539");
		WebElement QTYInput = driver.findElement(By.xpath(
				"//div[@class='Laptop-BuyOrdersEntry display-vertically']//div[@class='ml-2 mr-2 mt-2']//div//input[@id='quantityBuyOrders']"));
		QTYInput.sendKeys("2");
		WebElement priceInput = driver.findElement(By.xpath(
				"//div[@class='Laptop-BuyOrdersEntry display-vertically']//div[@class='ml-2 mr-2 mt-2']//div//div//input[@id='priceBuyOrders']"));
		priceInput.sendKeys("7.1");

		WebElement OrderTypeDropdown = driver
				.findElement(By.xpath("//div[@id='buy-order-box']//select[@id='orderTypeBuyOrder']"));
		Select dropdown3 = new Select(OrderTypeDropdown);
		dropdown3.selectByValue("2");

		WebElement validityInput = driver.findElement(By
				.xpath("//div[@class='Laptop-BuyOrdersEntry display-vertically']//select[@id='validityDateBuyOrder']"));
		Select dropdown4 = new Select(validityInput);
		dropdown4.selectByValue("0001");

		WebElement actionType = driver
				.findElement(By.xpath("//div[@id='buy-order-box-Action']//select[@name='orderTypeBuyOrder']"));
		Select dropdown5 = new Select(actionType);
		dropdown5.selectByValue("S");
		WebElement BuyButton = driver
				.findElement(By.cssSelector("div[id='buy-order-entry-btn'] div:nth-child(1) button:nth-child(1)"));
		BuyButton.click();
		Thread.sleep(3000);
		WebElement ConfirmButton = driver.findElement(
				By.cssSelector("div[class='mt-2 ml-auto mr-auto'] button[class='btn custom-btn-primary']"));

		ConfirmButton.click();
	}

	@Test(priority = 5, enabled = false)
	public void BuyFromAdvancedOrderEntry() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement AdvancedButton = driver.findElement(By.xpath("//button[normalize-space()='Advanced']"));
		AdvancedButton.click();

		Thread.sleep(2000);
		WebElement symbolInput = driver
				.findElement(By.cssSelector("div[class='select-search has-focus'] input[placeholder='Symbol']"));
		symbolInput.sendKeys("EMAA");
		driver.findElement(By.cssSelector("button[value='EMAARMALLS']")).click();
		Thread.sleep(4000);
		List<WebElement> options = driver.findElements(By.className("select-search__row"));
		for (WebElement option : options) {
			if (option.getText().equals("EMAARMALLS")) {
				option.click();

				break;

			}
		}

		WebElement AccountDropdown = driver.findElement(
				By.xpath("//div[@class='mb-1 ml-3 mr-3']//div//div//select[@id='accountNumberBuyOrderPopup']"));
		Select dropdown2 = new Select(AccountDropdown);
		dropdown2.selectByValue("2947539");
		WebElement QTYInput = driver.findElement(By.xpath(
				"//div[@id='orderEntryDropdown']//div//div//div[@class='custom-scrollable display-vertically']//div[@class='custom-scrollable display-vertically']//div[@class='ml-3 mr-3']//div//div[@class='mr-2']//div//input[@id='quantityOrderEntryPopup']"));
		QTYInput.sendKeys("2");
		WebElement priceInput = driver.findElement(By.cssSelector(
				"body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
		priceInput.sendKeys("3.21");
		//

		WebElement OrderTypeDropdown = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='orderTypeOrderEntryPopup']"));
		Select dropdown3 = new Select(OrderTypeDropdown);
		dropdown3.selectByValue("2");

		WebElement validityInput = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='validityDateBuyOrderPopup']"));
		Select dropdown4 = new Select(validityInput);
		dropdown4.selectByValue("0001");
		WebElement TradeButton = driver.findElement(By.xpath("//button[normalize-space()='Trade']"));
		TradeButton.click();

		WebElement ConfirmButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		ConfirmButton.click();

	}

	@Test(priority = 6, enabled = false)
	public void SellFromAdvancedOrderEntry() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// WebElement
		// AdvancedButton=driver.findElement(By.xpath("//button[normalize-space()='Advanced']"));
		WebElement AdvancedButton = driver
				.findElement(By.cssSelector("div[id='buy-order-entry-btn'] div:nth-child(2) button:nth-child(1)"));
		AdvancedButton.click();

		Thread.sleep(2000);
		WebElement symbolInput = driver
				.findElement(By.cssSelector("div[class='select-search has-focus'] input[placeholder='Symbol']"));
		symbolInput.sendKeys("EM");
		driver.findElement(By.cssSelector("button[value='EMAAR']")).click();
		Thread.sleep(4000);
		List<WebElement> options = driver.findElements(By.className("select-search__row"));
		for (WebElement option : options) {
			if (option.getText().equals("EMAAR")) {
				option.click();

				break;

			}
		}

		WebElement AccountDropdown = driver.findElement(
				By.xpath("//div[@class='mb-1 ml-3 mr-3']//div//div//select[@id='accountNumberBuyOrderPopup']"));
		Select dropdown2 = new Select(AccountDropdown);
		dropdown2.selectByValue("2947539");
		WebElement QTYInput = driver.findElement(By.xpath(
				"//div[@id='orderEntryDropdown']//div//div//div[@class='custom-scrollable display-vertically']//div[@class='custom-scrollable display-vertically']//div[@class='ml-3 mr-3']//div//div[@class='mr-2']//div//input[@id='quantityOrderEntryPopup']"));
		QTYInput.sendKeys("55");
		WebElement priceInput = driver.findElement(By.cssSelector(
				"body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
		priceInput.sendKeys("20.00");

		WebElement OrderTypeDropdown = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='orderTypeOrderEntryPopup']"));
		Select dropdown3 = new Select(OrderTypeDropdown);
		dropdown3.selectByValue("2");

		WebElement validityInput = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='validityDateBuyOrderPopup']"));
		Select dropdown4 = new Select(validityInput);
		dropdown4.selectByValue("0001");
		WebElement SellButton = driver.findElement(By.xpath(
				"//div[@class='mt-1 ml-3']//div[@class='mt-1 mr-3']//div//div//div[@class='pt-1 ml-3'][normalize-space()='Sell']"));
		SellButton.click();
		WebElement TradeButton = driver.findElement(By.xpath("//button[normalize-space()='Trade']"));
		TradeButton.click();

		WebElement ConfirmButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		ConfirmButton.click();

	}

	@Test(priority = 7, enabled = false)
	public void DownloadReportFromPortifolio() throws InterruptedException {
		WebElement Portifolio = driver
				.findElement(By.cssSelector("div[id='rc-tabs-2-tab-p52'] div[class='drag-initiator']"));
		Portifolio.click();
		// #accountNumberPortfolio

		WebElement AccountDropdown = driver.findElement(By.cssSelector("#accountNumberPortfolio"));
		Select dropdown2 = new Select(AccountDropdown);
		dropdown2.selectByValue("2947539");
		WebElement DownloadButton = driver.findElement(
				By.cssSelector("div[class='custom-scrollable display-vertically'] div div[class='RightSideHeader']"));
		DownloadButton.click();
		// driver.findElement(By.cssSelector("div[class='custom-popup-header pt-2']
		// span[class='my-panel-extra-btn']"))
		// .click();

		Thread.sleep(1000);//

	}

	@Test(priority = 8, enabled = false)
	public void forgetpassword() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement profileButton = driver.findElement(By.xpath("//i[@class='fa fa-angle-down mr-2']"));
		profileButton.click();
		WebElement ChangePasswordButton = driver.findElement(
				By.cssSelector("div[class='profile-dropdown-inner ml-4 mr-4 pl-2 pr-2'] button:nth-child(1)"));
		ChangePasswordButton.click();
		WebElement OldPasswordInput = driver.findElement(By.cssSelector(
				"input#OldPassword.custom-input[type=password][name=OldPassword][placeholder=\"Enter Old Password\"]"));
		OldPasswordInput.sendKeys(userInput);
		WebElement NewPasswordInput = driver.findElement(By.cssSelector(
				"input#password.custom-input[type=password][name=password][placeholder=\"Enter New Password\"]"));
		NewPasswordInput.sendKeys("Hadeel123##");
		WebElement ConfirmNewPassword = driver.findElement(By.cssSelector(
				"input#ConfirmPassword.custom-input[type=password][name=ConfirmPassword][placeholder=\"Confirm New Password\"]"));
		ConfirmNewPassword.sendKeys("Hadeel123##");

		Thread.sleep(5000);
		WebElement cancelButton = driver.findElement(By.cssSelector(".btn.custom-btn-cancel.mr-auto"));
		cancelButton.click();

	}

	@Test(priority = 9, enabled = false)
	public void InternalTransfer() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		WebElement transferButton = driver.findElement(By.xpath("//div[contains(text(),'Transfers')]"));
		transferButton.click();

		WebElement AccountName = driver.findElement(By.xpath("//select[@id='subAccountNumberSender']"));
		Select dropdown62 = new Select(AccountName);
		dropdown62.selectByValue("2933428");//

		WebElement ReceiverAccount = driver.findElement(By.xpath("//select[@id='subAccountNumberReceiver']"));
		Select dropdown5 = new Select(ReceiverAccount);
		dropdown5.selectByValue("2947539");

		WebElement transferAmount = driver.findElement(By.cssSelector("#transferAmount"));
		transferAmount.sendKeys("11,397,725,895.806");

		WebElement transferButton1 = driver.findElement(By.xpath("//button[normalize-space()='Transfer']"));
		transferButton1.click();
		WebElement Checkbox = driver.findElement(By.xpath("//input[@value='false']"));
		Checkbox.click();

		WebElement submitButton = driver.findElement(By.cssSelector(
				"div[class='mt-2 mb-2 ml-auto mr-auto'] button[class='btn btn-transfer btn-save-transfer mr-2']"));
		submitButton.click();

		Thread.sleep(5000);

	}

	@Test(priority = 10, enabled = false)
	public void ExternalTransfer() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement transferButton = driver.findElement(By.xpath("//div[contains(text(),'Transfers')]"));
		transferButton.click();

		// //button[@class='tablinksTransfers active']

		WebElement ExternalButton = driver.findElement(By.xpath("//strong[normalize-space()='External Transfer']"));
		ExternalButton.click();

		WebElement transferType = driver.findElement(By.cssSelector("#typeExternalRequest"));
		Select dropdown222 = new Select(transferType);
		dropdown222.selectByValue("REQ_TYPR_2");

		WebElement transferAmount = driver.findElement(By.xpath("//input[@id='transferAmountExternalTransfer']"));
		transferAmount.sendKeys("0.605");

		WebElement ReceiverAccount = driver.findElement(By.xpath("//select[@id='subAccountNumberExternalTransfer']"));
		Select dropdown59 = new Select(ReceiverAccount);
		dropdown59.selectByValue("2948861");

		WebElement transferButton1 = driver.findElement(By.xpath("//button[normalize-space()='Transfer']"));
		transferButton1.click();
		// driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		Thread.sleep(5000);

	}

	@Test(priority = 11, enabled = false)
	public void BanksTransfer() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement transferButton = driver.findElement(By.xpath("//div[contains(text(),'Transfers')]"));
		transferButton.click();

		// //button[@class='tablinksTransfers active']

		WebElement BanksButton = driver.findElement(By.xpath("//strong[normalize-space()='Banks']"));
		BanksButton.click();

		WebElement transferType = driver.findElement(By.cssSelector("#typeExternalRequest"));
		Select dropdown222 = new Select(transferType);
		dropdown222.selectByValue("REQ_TYPR_2");

		WebElement transferAmount = driver.findElement(By.xpath("//input[@id='transferAmountExternalTransfer']"));
		transferAmount.sendKeys("0.605");

		WebElement ReceiverAccount = driver.findElement(By.xpath("//select[@id='subAccountNumberExternalTransfer']"));
		Select dropdown59 = new Select(ReceiverAccount);
		dropdown59.selectByValue("2948861");

		WebElement transferButton1 = driver.findElement(By.xpath("//button[normalize-space()='Transfer']"));
		transferButton1.click();
		// driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		Thread.sleep(5000);

	}

	@Test(priority = 12, enabled = false)
	public void SellOrderFromStocks() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement AddButton = driver
				.findElement(By.xpath("//button[@class='btn-floating btn btn-primary btn-medium quickorderBtn']"));
		AddButton.click();
		Thread.sleep(2000);
		WebElement symbolInput = driver
				.findElement(By.cssSelector("div[class='select-search has-focus'] input[placeholder='Symbol']"));
		symbolInput.sendKeys("EM");
		driver.findElement(By.cssSelector("button[value='EMAAR']")).click();
		Thread.sleep(4000);
		List<WebElement> options = driver.findElements(By.className("select-search__row"));
		for (WebElement option : options) {
			if (option.getText().equals("EMAAR")) {
				option.click();

				break;

			}
		}
		WebElement AccountDropdown = driver.findElement(
				By.xpath("//div[@class='mb-1 ml-3 mr-3']//div//div//select[@id='accountNumberBuyOrderPopup']"));
		Select dropdown2 = new Select(AccountDropdown);
		dropdown2.selectByValue("2947512");
		WebElement QTYInput = driver.findElement(By.xpath(
				"//div[@id='orderEntryDropdown']//div//div//div[@class='custom-scrollable display-vertically']//div[@class='custom-scrollable display-vertically']//div[@class='ml-3 mr-3']//div//div[@class='mr-2']//div//input[@id='quantityOrderEntryPopup']"));
		QTYInput.sendKeys("2");
		WebElement priceInput = driver.findElement(By.cssSelector(
				"body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
		priceInput.sendKeys(".22");
		//

		WebElement OrderTypeDropdown = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='orderTypeOrderEntryPopup']"));
		Select dropdown3 = new Select(OrderTypeDropdown);
		dropdown3.selectByValue("2");

		WebElement validityInput = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='validityDateBuyOrderPopup']"));
		Select dropdown4 = new Select(validityInput);
		dropdown4.selectByValue("0001");
		WebElement SellButton = driver.findElement(By.xpath(
				"//div[@class='mt-1 ml-3']//div[@class='mt-1 mr-3']//div//div//div[@class='pt-1 ml-3'][normalize-space()='Sell']"));
		SellButton.click();
		WebElement TradeButton = driver.findElement(By.xpath("//button[normalize-space()='Trade']"));
		TradeButton.click();

		WebElement ConfirmButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		ConfirmButton.click();
	}

	@Test(priority = 13, enabled = false)
	public void BuyFromStocks() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebElement AddButton = driver
				.findElement(By.xpath("//button[@class='btn-floating btn btn-primary btn-medium quickorderBtn']"));
		AddButton.click();
		Thread.sleep(2000);
		WebElement symbolInput = driver
				.findElement(By.cssSelector("div[class='select-search has-focus'] input[placeholder='Symbol']"));
		symbolInput.sendKeys("EMAA");
		driver.findElement(By.cssSelector("button[value='EMAARMALLS']")).click();

		List<WebElement> options = driver.findElements(By.className("select-search__row"));
		for (WebElement option : options) {
			if (option.getText().equals("EMAARMALLS")) {
				option.click();

				break;

			}
		}

		WebElement AccountDropdown = driver.findElement(
				By.xpath("//div[@class='mb-1 ml-3 mr-3']//div//div//select[@id='accountNumberBuyOrderPopup']"));
		Select dropdown2 = new Select(AccountDropdown);
		dropdown2.selectByValue("2947539");
		WebElement QTYInput = driver.findElement(By.xpath(
				"//div[@id='orderEntryDropdown']//div//div//div[@class='custom-scrollable display-vertically']//div[@class='custom-scrollable display-vertically']//div[@class='ml-3 mr-3']//div//div[@class='mr-2']//div//input[@id='quantityOrderEntryPopup']"));
		QTYInput.sendKeys("2");
		WebElement priceInput = driver.findElement(By.cssSelector(
				"body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
		priceInput.sendKeys("3.21");
		//

		WebElement OrderTypeDropdown = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='orderTypeOrderEntryPopup']"));
		Select dropdown3 = new Select(OrderTypeDropdown);
		dropdown3.selectByValue("2");

		WebElement validityInput = driver
				.findElement(By.xpath("//div[@class='mt-1']//select[@id='validityDateBuyOrderPopup']"));
		Select dropdown4 = new Select(validityInput);
		dropdown4.selectByValue("0001");
		WebElement TradeButton = driver.findElement(By.xpath("//button[normalize-space()='Trade']"));
		TradeButton.click();

		WebElement ConfirmButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
		ConfirmButton.click();
		Thread.sleep(7000);

	}

	@Test(priority = 14, enabled = false)
	public void CreateAlerts() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement workspaceButton = driver.findElement(By.cssSelector("a[href='/fit_react_v2/main/NewWorkspace']"));
		workspaceButton.click();
		workspaceButton.click();

		WebElement plusButton = driver
				.findElement(By.xpath("//button[@class='btn-new-workspace btn btn-danger btn-medium']"));
		plusButton.click();

		WebElement AlertButton = driver.findElement(By.xpath("//button[normalize-space()='Alerts']"));
		AlertButton.click();
		// select#AlertMangerMarkets

		WebElement MarketDropdown = driver.findElement(By.xpath("//select[@id='AlertMangerMarkets']"));
		Select dropdown49 = new Select(MarketDropdown);
		dropdown49.selectByValue("DIFX");
		Thread.sleep(5000);
		WebElement parametersDropdown = driver.findElement(By.cssSelector("select#AlertManagerParameter"));
		Select dropdown44 = new Select(parametersDropdown);
		dropdown44.selectByValue("MW_BID_PRICE");

		WebElement criteriaDropdown = driver.findElement(By.cssSelector("select#AlertManagerCriteria"));
		Select dropdown55 = new Select(criteriaDropdown);
		dropdown55.selectByValue("GT");

		WebElement ValueInput = driver.findElement(By.cssSelector("input#AlertManagerValue"));
		ValueInput.sendKeys("500");

		WebElement symbolInput = driver
				.findElement(By.cssSelector("div[class='select-search has-focus'] input[placeholder='Symbol']"));
		symbolInput.sendKeys("RE");
		driver.findElement(By.cssSelector("button[value='REIT']")).click();
		Thread.sleep(4000);
		List<WebElement> options = driver.findElements(By.className("select-search__row"));
		for (WebElement option : options) {
			if (option.getText().equals("REIT")) {
				option.click();

				break;

			}
		}
		WebElement CreateNewButton = driver.findElement(By.cssSelector("button.btn.btn-order.btn-search-orders.mr-3"));
		CreateNewButton.click();
		WebElement DeleteAlert = driver.findElement(By.cssSelector("button.edit-btn-grid"));
		DeleteAlert.click();
	}

	
	@Test()
	public void BuyOrdersUsingAddButton() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(5000);
		WebElement addButton =driver.findElement(By.xpath("//div/button/i"));
		addButton.click();
		
		
		
		
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void AfterTest() {
		//driver.close();

	}
}