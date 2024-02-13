
package interactions;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
public class windowsHandles {

	public static void main(String[] args) {
	
		//move from parent to child to caputure a email address then back to parent page to paste it 
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set <String> windows =driver.getWindowHandles();
		Iterator <String> it=windows.iterator();
		String patentID=it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
	System.out.println(	driver.findElement(By.cssSelector(".im-para.red")).getText());
	String emailID=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	driver.switchTo().window(patentID);
	driver.findElement(By.cssSelector("#username")).sendKeys(emailID);
	
		

				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
