package com.aecern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listingofdata {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.aecern.com/pd/");

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(".dropdown-toggle")).click();// click on login button
		driver.findElement(By.id("menu-item-1415")).click();// select teacher element

		ArrayList<String> testTab = new ArrayList<String>(driver.getWindowHandles());
		String oldTab = testTab.get(0);
		String newTab = testTab.get(1);
		driver.switchTo().window(newTab);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		// User(teacher) will login on scoutlier platform
		WebElement email = driver.findElement(By.xpath("//input[@formcontrolname='Email']"));
		email.sendKeys("Usertesting045@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='Password']"));
		password.sendKeys("Quovantis@123");
		WebElement login = driver.findElement(By.cssSelector(".primary-btn.center-block"));
		login.click();

		Thread.sleep(6000);

		// System.out.println(url);// It should fetch dashboard url

		WebElement myLibrary = driver.findElement(By.cssSelector(".nav-link.assignment"));
		myLibrary.click();

		// System.out.println(url);// It should fetch assignment page url
		Thread.sleep(6000);

		WebElement searchText = driver
				.findElement(By.xpath("//div[@class='container-fluid']/div[1]/div[1]/div/div/div[1]/div/input"));
		searchText.sendKeys("Assignment");

		// click on search button
		driver.findElement(By.cssSelector("span[class='input-group-btn']")).click();
		;
		Thread.sleep(6000);
		List<WebElement> allResults = driver
				.findElements(By.xpath("//div[@class='container-fluid']/div[2]/div[2]/div"));
		int divSize = allResults.size();
		System.out.println(divSize);
		if (divSize > 0) {
			driver.findElement(By.xpath("//div[@class='container-fluid']/div[2]/div[2]/div[1]")).click();
			System.out.println("Testcase ran successfully");
		} else {
			System.out.println("No Element found");
		}

	}

}
