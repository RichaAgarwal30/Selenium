package com.aecern;

import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.testng.Assert;
import org.testng.Assert;

public class Form {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/home/richa/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "/home/richa/Desktop/geckodriver.exe");
		//driver = new FirefoxDriver();

		driver.get("https://www.aecern.com/pd/");
		driver.findElement(By.cssSelector(".dropdown-toggle")).click();// click on login button
		driver.findElement(By.id("menu-item-1415")).click();// select teacher element
		// tried using implicit wait
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// String oldTab = driver.getWindowHandle();
		ArrayList<String> testTab = new ArrayList<String>(driver.getWindowHandles());
		String oldTab = testTab.get(0);
		// newTab.remove(oldTab);
		String newTab = testTab.get(1);
		driver.switchTo().window(newTab);
		// Now it will click on 'sign up' in the new window
		WebElement signUpButton = driver.findElement(By.xpath("//div/a[@class='theme-text-12-bold']"));
		signUpButton.click();// click on signup button

		WebElement userName = driver.findElement(By.xpath("//input[@formcontrolname='UserName']"));

		// Testcase when no fullname is entered and check if signup button is enabled or
		// not
		userName.sendKeys("");
		WebElement eMail = driver.findElement(By.xpath("//input[@formcontrolname='Email']"));
		eMail.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[1]/div")).getText());
		checkSignUpButton();

		// Testcase when fullname is entered correctly and check if signup button is
		// enabled or not
		userName.sendKeys("Richa Agarwal");
		eMail.click();
		checkValidationMessage();
		checkSignUpButton();

		// Testcase when name is entered in alphabets and check if signup button is
		// enabled or not
		clearUsername();
		userName.sendKeys("abcd");
		eMail.click();
		checkValidationMessage();
		checkSignUpButton();

		// Testcase when name is entered in numbers and check if signup button is
		// enabled or not
		clearUsername();
		userName.sendKeys("12413");
		eMail.click();
		checkValidationMessage();
		checkSignUpButton();

		// Testcase when name is entered just as first name and check if signup button
		// is enabled or not
		clearUsername();
		userName.sendKeys("Richa");
		eMail.click();
		checkValidationMessage();
		checkSignUpButton();

		// Testcase when name is entered just as last name and check if signup button is
		// enabled or not
		clearUsername();
		userName.sendKeys("Agarwal");
		eMail.click();
		checkValidationMessage();
		checkSignUpButton();

		// Testcase when name is entered as 'firstname middlename lastname' and check if
		// signup button is enabled or not
		clearUsername();
		userName.sendKeys("Richa K. Agarwal");
		eMail.click();
		checkValidationMessage();
		checkSignUpButton();

		// Testcase when name is entered as special characters and check if signup
		// button is enabled or not
		clearUsername();
		userName.sendKeys("@!#$%^");
		eMail.click();
		checkValidationMessage();
		checkSignUpButton();

		// Testcase when no email is entered
		eMail.sendKeys("");
		WebElement password = driver.findElement(By.xpath("//input[@formcontrolname='Password']"));
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when two emails are entered
		eMail.sendKeys("a@gmail.com,b@gmail.com");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when (.) is not entered
		clearEmail();
		eMail.sendKeys("a@gmailcom");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when (@) is not entered
		clearEmail();
		eMail.sendKeys("agmail.com");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when (@) is entered twice
		clearEmail();
		eMail.sendKeys("a@gmail.@com");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when (.com) is not entered
		clearEmail();
		eMail.sendKeys("a@gmail");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when (username) is not entered
		clearEmail();
		eMail.sendKeys("@gmail.com");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when (domain) is not entered
		clearEmail();
		eMail.sendKeys("a@.com");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Trailing dot in email address
		clearEmail();
		eMail.sendKeys("a@gmail.com.");
		password.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[2]/div")).getText());
		checkSignUpButton();

		// Testcase when correct email is entered
		clearEmail();
		eMail.sendKeys("Richa.agl@mailinator.com");
		password.click();
		checkSignUpButton();

		// Testcase when password field is left empty
		password.sendKeys("");
		WebElement confirmPassword = driver.findElement(By.xpath("//input[@formcontrolname='ConfirmPassword']"));
		confirmPassword.click();
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[3]/div")).getText());
		checkSignUpButton();

		// Testcase when 1 special char is entered
		password.sendKeys("!");
		checkPasswordValidation();
		checkSignUpButton();

		// Testcase when more than 1 special char is entered
		clearPassword();
		password.sendKeys("!@#");
		checkPasswordValidation();
		checkSignUpButton();

		// Testcase when no special char is entered
		clearPassword();
		password.sendKeys("Wvdg632a");
		checkPasswordValidation();
		checkSignUpButton();

		// Testcase when no number is entered
		clearPassword();
		password.sendKeys("Wvdg^&%a");
		checkPasswordValidation();
		checkSignUpButton();

		// Testcase when more than 1 number is entered
		clearPassword();
		password.sendKeys("145Gh!@#");
		checkSignUpButton();

		// Testcase when 1 number is entered
		clearPassword();
		password.sendKeys("Wvdg@@2a");
		checkSignUpButton();

		// Enter no uppercase character
		clearPassword();
		password.sendKeys("bbdg@@2a");
		checkPasswordValidation();
		checkSignUpButton();

		// Enter 1 uppercase character
		clearPassword();
		password.sendKeys("Wvdg@@2a");
		checkSignUpButton();

		// Enter more than 1 uppercase character
		clearPassword();
		password.sendKeys("WvYg@@2a");
		checkSignUpButton();

		// Enter no lower case character
		clearPassword();
		password.sendKeys("TTY@@2TW");
		checkPasswordValidation();
		checkSignUpButton();

		// Enter 1 lowercase character
		clearPassword();
		password.sendKeys("WvYY@@2H");
		checkSignUpButton();

		// Enter more than 1 lowercase character
		clearPassword();
		password.sendKeys("WvYg@@2a");
		checkSignUpButton();

		// Enter less than 8 characters (correct)
		clearPassword();
		password.sendKeys("Wy@5");
		checkPasswordValidation();
		checkSignUpButton();

		// Enter 8 characters (correct)
		clearPassword();
		password.sendKeys("Wy@58761");
		checkSignUpButton();

		// Enter more than 8 characters (correct)
		clearPassword();
		password.sendKeys("Wy@58763d");
		checkSignUpButton();

		// No confirm password
		confirmPassword.sendKeys("");
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[4]/div")).getText());
		checkSignUpButton();

		// Enter different confirm password
		confirmPassword.sendKeys("We#3j");
		System.out.println(driver.findElement(By.xpath("//div[@class='row']/div[4]/div")).getText());
		checkSignUpButton();

		// Enter same confirm password
		confirmPassword.clear();
		confirmPassword.sendKeys("Wy@58763d");
		checkSignUpButton();

		// Check it is enabled after each field is filled correctly and button gets
		// enabled
		WebElement signUp = driver.findElement(By.cssSelector(".primary-btn.center-block"));
		signUp.click();

		String url = driver.getCurrentUrl();
		System.out.println(url);

	}

	public static void clearUsername() {
		WebElement userName = driver.findElement(By.xpath("//input[@formcontrolname='UserName']"));
		userName.clear();
	}

	public static void clearEmail() {
		WebElement eMail = driver.findElement(By.xpath("//input[@formcontrolname='Email']"));
		eMail.clear();
	}

	public static void clearPassword() {
		WebElement password1 = driver.findElement(By.xpath("//input[@formcontrolname='Password']"));
		password1.clear();
	}

	public static void checkSignUpButton() {
		WebElement signUp = driver.findElement(By.cssSelector(".primary-btn.center-block"));
		if (signUp.isEnabled()) {
			System.out.println("Signup button is enabled.");
		} else {
			System.out.println("Signup button is disabled.");
		}
	}

	public static void checkValidationMessage() {
		WebElement checkValidationMessage = driver
				.findElement(By.cssSelector(".entry-input.ng-dirty.ng-touched.ng-valid"));

		if (checkValidationMessage.isDisplayed()) {
			System.out.println("Correct implementation");
		} else {
			System.out.println("Incorrect implementation");
		}
	}

	public static void checkPasswordValidation() {

		WebElement passwordValidation = driver.findElement(By.xpath("//ul[@class='password-validators']"));
		List<WebElement> message = passwordValidation.findElements(By.tagName("li"));
		for (int i = 0; i < message.size(); i++) {
			System.out.println(message.get(i).getText());
		}
	}
}
