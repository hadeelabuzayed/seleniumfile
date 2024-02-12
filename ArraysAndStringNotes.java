package hadeelselenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class ArraysAndStringNotes {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver","\"C:\\Users\\Dell\\Desktop\\chromedriver-win64\\chromedriver\"");
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/collections/yoga-new.html");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		// WebDriver Driver =new FirefoxDriver();
		// For run firefox locally we use
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\Dell\\Desktop\\chromedriver-win64\\chromedriver\"");

//int arr[]= {1,2,3,4,5,6};
//for(int i=1;i<arr.length;i++) {
		// System.out.println(arr[i]);}

		ArrayList<String> a = new ArrayList();
		a.add("ali");
		a.add("ahmad");
		a.add("rema");
		a.add("mousa");
		System.out.println(a);
		System.out.println("************************");
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
			System.out.println(a.contains("ali"));

		}
		System.out.println("nnnnnnnnnnnnnnnnnnnnn");
		String ARR[] = { "ali", "ahh", "tt", "uu" };
		List<String> ASLIST = Arrays.asList(ARR);
		System.out.println(ASLIST.contains("ahh"));

		String s = new String("hadeel Abu Zayed");

		String[] splited = s.split(" ");
		System.out.println(splited[0]);
		System.out.println(splited[1]);
		System.out.println(splited[2]);
		System.out.print(splited[1].trim());
		System.out.print(splited[2].trim());
		System.out.print(splited[0].trim());
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));

		}

	}
}
