package com.seekify.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seekify.factories.BrowserFactory;
import com.seekify.factories.ReporterFactory;
import com.seekify.objectRepository.LearningPathPage;
import com.seekify.utilities.ConfigReader;
import com.seekify.utilities.UtilityMethods;

public class UnitTest extends BaseTest{
	private WebDriver driver;
	
	@Test(groups = {"unit_test", "welcome"})
	public void welcome_test() throws InterruptedException {
		driver = BrowserFactory.getBrowser();
		ExtentTest testReporter = ReporterFactory.getTest();
		testReporter.log(LogStatus.INFO, "Test method started");
		testReporter.assignCategory("Unit Test");
		this.driver.navigate().to(ConfigReader.getConfig("learning_path_url"));
		LearningPathPage lp = new LearningPathPage(this.driver);
		Assert.assertTrue(lp.isFreeCourseTextPresent());
		Assert.assertTrue(lp.isFreeCourseDisplayByName("Certificate in English Comprehension"));
		System.out.println("Total course count - "+lp.getTotalFreeCourseCount());
		System.out.println("All Courses - "+lp.getAllDisplayFreeCoursesName());
		Thread.sleep(10000);
		lp.clickOnFreeCourseByName("Certificate in English Comprehension");
		Thread.sleep(10000);
	}
}
