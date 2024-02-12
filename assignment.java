package hadeelselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");
		// select any checkbox
		driver.findElement(By.id("checkBoxOption2")).click();

		// Grab the label of the selected checkbox
		String ch = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		// Select an option in dropdown with same name of checkbox
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(ch);
		// enter the step 2 grabbed label text in Editbox
		driver.findElement(By.id("name")).sendKeys(ch);
		// Click Alert and then verify if text grabbed from step 2 is present in the pop
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String text = driver.switchTo().alert().getText();

		if (text.contains(ch))

		{

			System.out.println("Alert message success");

		}

		else

			System.out.println("Something wrong");

	}

}
