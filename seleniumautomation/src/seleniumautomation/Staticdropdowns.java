package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Staticdropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");//Hit url on the browser
		
		/*Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
	    //s.selectByValue("INR");
		s.selectByIndex(3);
		//s.selectByVisibleText("USD");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByIndex(3);
		
		Select u = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		u.selectByIndex(2);
		
		Select v = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		v.selectByIndex(2);*/
		
		
		
	}

}
