package carts;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addToCart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// Add one item to cart
		// create a list of items as an array list
		List<WebElement> products = driver.findElements(By.className("product-name"));
		for (int i = 0; i < products.size(); i++) {
			// prints all items
			String name = products.get(i).getText();
			if (name.contains("Cucumber")) {
				System.out.println(name);
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;

			}

		}

	}

}
