package hadeelselenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
        WebDriver driver=new ChromeDriver();
        SoftAssert a=new SoftAssert();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
for(WebElement link:links) {
	 String url= link.getAttribute("href");

     HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

     conn.setRequestMethod("HEAD");

     conn.connect();

     int respCode = conn.getResponseCode();

     System.out.println(respCode);

     a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

    



 }



 a.assertAll();
	
	
	
	
}

}
