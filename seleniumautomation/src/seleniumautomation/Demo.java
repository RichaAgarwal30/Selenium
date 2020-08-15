package seleniumautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//selenium code-
		
		//Create driver object for chrome browser
		//We will strictly implement methods of webdriver- interface (webdriver) and it gives all the methods to automate
		//invoke .exe file first
		
		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https:dev-seekify.com");//Hit url on the browser
		
		System.out.println(driver.getTitle());//validate if your page title is correct
		System.out.println(driver.getCurrentUrl()); //validate if you are landed on correct url
		//System.out.println(driver.getPageSource());//To print the page source.
		
		driver.get("https:dev-seekify.com/learn");
		
		driver.navigate().back();
		//driver.navigate().forward();
		driver.close();//it closes the current browser
		//driver.quit();//it closes all the browsers opened bt selenium script.
		
	}

}
