package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");

	WebDriver driver= new ChromeDriver();
	driver.get("https://facebook.com"); //opens url in the browser	
	/*driver.findElement(By.id("email")).sendKeys("emailid");
	driver.findElement(By.name("pass")).sendKeys("password");
	driver.findElement(By.linkText("Forgotten account?")).click();
	driver.close(); */

	
	
	
	
	}

}
