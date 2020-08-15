package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class regularexp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		
		/*driver.get("https://rediff.com");
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Hello");//customized xpath
		driver.findElement(By.cssSelector("input#password")).sendKeys("pass"); //customized css
		driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click(); //regular expression
		*/
		
		driver.get("https://google.com");
		//driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("hello");
		//driver.findElement(By.xpath("//div[@id='gbw']/div/div/div/div[2]/a")).click();		
		
		

	}

}
