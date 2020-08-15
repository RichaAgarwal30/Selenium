package com.seekify.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.seekify.factories.ReporterFactory;
import com.seekify.utilities.ConfigReader;

public class AssessmentPage {
	WebDriver driver;
	ExtentTest testReporter;
	WebDriverWait wait;

	@FindBy(id = "tab-id-Assessment")
	private WebElement assessmentTab;

	@FindBy(xpath = "//*[@id = 'root']//div[@class= 'head-container ']//p")
	private WebElement headerText;

	@FindBy(xpath = "//img[@alt= 'Safejob-Aptitude-Test.jpg']")
	private WebElement safejobApptitudeTestImage;

	@FindBy(xpath = "//img[@alt= 'Safejob-Aptitude-Test.jpg']/following-sibling::div/p")
	private WebElement safejobAptitudeTestText;

	@FindBy(xpath = "//img[@alt= 'Safejob-Aptitude-Test.jpg']/following-sibling::div/button")
	private WebElement safejobAptitudeTestViewDetailsButton;

	public AssessmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testReporter = ReporterFactory.getTest();
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnAssessmentTab() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.assessmentTab)).isDisplayed()) {
			this.assessmentTab.click();
		}
	}

	public String isHeaderTextPresent() {
		if (this.headerText.isDisplayed()) {
			return this.headerText.getText();

		} else
			return null;
	}

	public boolean isSafejobAptitudeTestImagePresent() {
		if (this.wait.until(ExpectedConditions.visibilityOf(this.safejobApptitudeTestImage)).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public String isSafejobAptitudeTestTextPresent() {
		if (this.safejobAptitudeTestText.isDisplayed()) {
			return this.safejobAptitudeTestText.getText();
		} else {
			return null;
		}

	}

	public AssessmentDetailsPage clickOnSafejobAptitudeTestViewDetailsButton() {
		if (this.safejobAptitudeTestViewDetailsButton.isDisplayed()) {
			this.safejobAptitudeTestViewDetailsButton.click();
		} else {
			System.out.println(" View Details button for Safejob Aptitude Test is not Present");
		}
		return new AssessmentDetailsPage(driver);
	}

	public String isSafejobAptitudeTestViewDetailsButtonPresent() {
		if (this.safejobAptitudeTestViewDetailsButton.isDisplayed()) {
			return this.safejobAptitudeTestViewDetailsButton.getText();
		} else {
			return null;
		}
	}
}