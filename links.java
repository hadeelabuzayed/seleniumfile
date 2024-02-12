package hadeelselenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class links {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		// get the number of links in the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		// get the number of links in the footer
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		// click on each link in the coloumn and check if the pages are opening
		WebElement firstColumn = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
		System.out.println(firstColumn.findElements(By.tagName("a")).size());
		for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		}
		// get the title for each link
		Set<String> links = driver.getWindowHandles();
		Iterator<String> a = links.iterator();
		while (a.hasNext()) {
			driver.switchTo().window(a.next());
			System.out.println(driver.getTitle());
		}

	}

}
