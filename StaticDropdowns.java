import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class StaticDropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown =new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		///////////////////////////////////
		 Thread.sleep(2000L);
			//driver.findElement(By.id("hrefIncAdt")).click();
			for(int i=1;i<5;i++) {
				
			driver.findElement(By.id("hrefIncAdt")).click();	
			}
			
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
			driver.findElement(By.id("btnclosepaxoption")).click();
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
