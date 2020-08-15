package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		/*driver.findElement(By.id("username")).sendKeys("Hello");
		driver.findElement(By.id("password")).sendKeys("ji");
		//driver.findElement(By.className("button r4 wide primary")).click(); //incorrect way
		//driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
		driver.findElement(By.cssSelector("#Login")).click();
        System.out.println(driver.findElement(By.cssSelector("#error")).getText());
		
		
		//Creating customized xpath
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Hell");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("pass");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		
		//Creating customized css
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("Hell");
		driver.findElement(By.cssSelector("input[name='pw']")).sendKeys("pass");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();*/
			
				
        		
	}

}
