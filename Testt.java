package interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Testt {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("hadeel")  ; 
driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("1234");
	
	


	}
}
