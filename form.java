import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class form {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys("hadeel abuzayed");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("hadeelabuzayed01@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("hello");
		driver.findElement(By.cssSelector("	#exampleCheck1")).click();
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown =new Select(staticDropdown);
		dropdown.selectByIndex(1);
		
		
		driver.findElement(By.cssSelector("#inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("17/3/2001");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		
		
	}

}
