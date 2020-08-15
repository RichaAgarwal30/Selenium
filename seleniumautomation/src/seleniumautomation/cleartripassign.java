package seleniumautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class cleartripassign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cleartrip.com/");

		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("3");
		Select b = new Select(driver.findElement(By.id("Childrens")));
		b.selectByValue("2");
		driver.findElement(By.cssSelector(".depart_date.keyValue.span.span24.required.hasDatepicker.placeholder"))
				.click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		driver.findElement(By.id("MoreOptionsDiv")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Ludhiana");
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}

}
