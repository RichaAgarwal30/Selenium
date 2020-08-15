package com.seekify.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seekify.factories.BrowserFactory;
import com.seekify.factories.ReporterFactory;
import com.seekify.objectRepository.MarketingPage;
import com.seekify.objectRepository.UserHomePage;
import com.seekify.utilities.RandomeUtility;

public class SmokeTest extends BaseTest{
	
	@Test(groups = {"smoke_test"}, priority= 0)
	public void verify_that_user_can_open_marketing_page() {
		WebDriver driver = BrowserFactory.getBrowser();
		ExtentTest testReporter = ReporterFactory.getTest();
		testReporter.log(LogStatus.INFO, "Test method started");
		testReporter.assignCategory("Smoke Test");
		MarketingPage marketingApp =  app(driver);
		Assert.assertTrue(marketingApp.isSafeJobLogoPresent());
		Assert.assertTrue(marketingApp.isSafeJobFooterLogoPresent());
	}
	
	@Test(groups = {"smoke_test"}, priority=1 )
	public void vefify_that_new_user_can_login_with_email() throws InterruptedException {
		WebDriver driver = BrowserFactory.getBrowser();
		ExtentTest testReporter = ReporterFactory.getTest();
		testReporter.log(LogStatus.INFO, "Test method started");
		testReporter.assignCategory("Smoke Test");
		String email = RandomeUtility.getRandomEmails();
		UserHomePage homePage = app(driver).clickOnGetStartedLink().enterUserPhoneOrEmail(email)
		.clickOnNexButtonAndStayOnPage().enterFirstName("Krishna")
		.enterLastName("Nandan").clickOnNexButtonAndStayOnPage()
		.getOTPFromEmailAndEnter(email).clickOnNexButton();
		
		homePage.clickOnAskMeLaterIfAlertPresent();
		Assert.assertTrue(homePage.isUserNamePresent());
		Assert.assertTrue(homePage.getDispalyUserName().contains("Krishna"));
		Assert.assertTrue(homePage.getDispalyUserName().contains("Nandan"));
	}
	
	
}
