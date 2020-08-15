package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");//Hit url on the browser
		driver.findElement(By.cssSelector("[type='email']")).sendKeys("anything");
		driver.findElement(By.cssSelector("#password")).sendKeys("ji");
		driver.findElement(By.cssSelector("#Login")).click();
	}

}
