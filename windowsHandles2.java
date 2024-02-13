package interactions;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowsHandles2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set <String> windows =driver.getWindowHandles();
		Iterator <String> nav=windows.iterator();
		String parent=nav.next();
		String child=nav.next();
		driver.switchTo().window(child);
		 System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parent);
		 System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
