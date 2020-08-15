package com.seekify.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.seekify.factories.ReporterFactory;

public class AssessmentDetailsPage {
	WebDriver driver;
	ExtentTest testReporter;
	WebDriverWait wait;
	
	@FindBy(xpath = "//span[@class = 'page-title bold']")
	private WebElement assessmentDetailsPageHeaderText;
	
	@FindBy(xpath = "//*[@class = 'assess-details']/p/span[@class = 'assessment-detail-info-sub-heading']")
	private WebElement assessmentTitleHeadingText;
	
	@FindBy(xpath = "//*[@class = 'assess-details']/p/span[2]")
	private WebElement aptitudeTestNameText;
	
	@FindBy(xpath = "//*[@class = 'assess-details']/div//span[@class = 'assessment-detail-info-sub-heading']")
	private WebElement assessmentDetailsDescriptionTitleText;
	
	@FindBy(xpath = "//*[@class = 'assess-details']/div//span[2]")
	private WebElement assessmentDetailsDescrptionText;
	
	@FindBy(xpath = "//*[@class = 'assess-details']/div//span[2]/button")
	private WebElement assessmentDetailsDescrptionMoreButton;
	
	@FindBy(xpath = "//*[@class = 'assess-details']/div[2]/button/span")
	private WebElement startAssessmentButtonText;
	
	@FindBy(xpath = "//*[@class = 'assess-details']/div[2]/button")
	private WebElement startAssessmentButton;
	
	
	public AssessmentDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testReporter = ReporterFactory.getTest();
		wait = new WebDriverWait(driver, 20);
	}
	
	public String getAssessmentDetailsPageHeader() {
		if (this.isassessmentDetailsPageHeaderTexPresent()) {
			return this.assessmentDetailsPageHeaderText.getText();
		} else {
			return null;
		}
		
	}
	public String getAssessmentTitleHeading() {
		if (this.isassessmentTitleHeadingTextPresent()) {
			return this.assessmentTitleHeadingText.getText();
		} else {
			return null;
		}
	}
	public String getAptitudeTestname() {
		if (this.isaptitudeTestNameTextPresent()) {
			return this.aptitudeTestNameText.getText();
		} else {
			return null;
		}
	}
	public String getAssessmentDetailDescriptionTitle() {
		if (this.isassessmentDetailsDescriptionTitleTextPresent()) {
			return this.assessmentDetailsDescriptionTitleText.getText();
		} else {
			return null;
		}
	}
	public String getAssessmentDetailDescription() {
		if (this.isassessmentDetailsDescrptionTextPresent()) {
			return this.assessmentDetailsDescrptionText.getText();
		} else {
			return null;
		}
	}
	public String getstartAssessmentButtonText() {
		if (this.isstartAssessmentButtonTextPresent()) {
			return this.startAssessmentButtonText.getText();
		} else {
			return null;
		}
	}
	
	public boolean isassessmentDetailsPageHeaderTexPresent() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.assessmentDetailsPageHeaderText)).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	public boolean isassessmentTitleHeadingTextPresent() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.assessmentTitleHeadingText)).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	public boolean isaptitudeTestNameTextPresent() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.aptitudeTestNameText)).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	public boolean isassessmentDetailsDescriptionTitleTextPresent() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.assessmentDetailsDescriptionTitleText)).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	
	public boolean isassessmentDetailsDescrptionTextPresent() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.assessmentDetailsDescrptionText)).isDisplayed()) {
			return true;
		} else
			return false;
	}
	

	public boolean isstartAssessmentButtonTextPresent() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.startAssessmentButtonText)).isDisplayed()) {
			return true;
		} else
			return false;
}

	public void clickOnDescriptionMoreButton() {
		try {
			if (this.assessmentDetailsDescrptionMoreButton.isDisplayed()) {
				this.assessmentDetailsDescrptionMoreButton.click();
			}
			} catch (Exception e) {
				
			}
	} 
	
}
