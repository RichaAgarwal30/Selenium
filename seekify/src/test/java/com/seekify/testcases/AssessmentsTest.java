package com.seekify.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.seekify.factories.BrowserFactory;
import com.seekify.factories.ReporterFactory;
import com.seekify.objectRepository.AssessmentDetailsPage;
import com.seekify.objectRepository.AssessmentPage;

public class AssessmentsTest extends BaseTest{
	
	@Test(groups = {"sanity", "smoke_test", "assessment_test"},priority = 2)
	public void Verify_Assessment_Page_Display() {
		WebDriver driver = BrowserFactory.getBrowser();
		ExtentTest testReporter = ReporterFactory.getTest();
		testReporter.log(LogStatus.INFO, "Test method started");
		testReporter.assignCategory("Smoke Test");
		
		AssessmentPage assessmentPage = AssessmentPageApp(driver);
		Assert.assertEquals(assessmentPage.isHeaderTextPresent(),"Browse around our industry certified learning material, which help you UP your game!");
		Assert.assertTrue(assessmentPage.isSafejobAptitudeTestImagePresent());
		Assert.assertEquals(assessmentPage.isSafejobAptitudeTestTextPresent(), "Safejob Aptitude Test");
		Assert.assertEquals(assessmentPage.isSafejobAptitudeTestViewDetailsButtonPresent(), "View Details");
	}

	@Test(groups = {"sanity", "smoke_test", "assessment_test"},priority = 3)
	public void Verify_Assessment_Display_Display() {
		WebDriver driver = BrowserFactory.getBrowser();
		ExtentTest testReporter = ReporterFactory.getTest();
		testReporter.log(LogStatus.INFO, "Test method started");
		testReporter.assignCategory("Smoke Test");
		
		AssessmentDetailsPage assessmentDetailsPage = AssessmentPageApp(driver).clickOnSafejobAptitudeTestViewDetailsButton();
		Assert.assertEquals(assessmentDetailsPage.getAssessmentDetailsPageHeader(),"Assessment Details");
		Assert.assertEquals(assessmentDetailsPage.getAssessmentTitleHeading(),"Title:");
		Assert.assertEquals(assessmentDetailsPage.getAptitudeTestname(),"Assessment Details");
		Assert.assertEquals(assessmentDetailsPage.getAssessmentDetailDescriptionTitle(),"Assessment Details");
		assessmentDetailsPage.clickOnDescriptionMoreButton();
		Assert.assertEquals(assessmentDetailsPage.getAssessmentDetailDescription(), "");
	
	
	}
}
