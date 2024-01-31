package pageActions;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import com.aventstack.extentreports.util.Assert;
import org.testng.Assert;

import freemarker.core.ReturnInstruction.Return;

import org.openqa.selenium.interactions.Actions;

import io.reactivex.rxjava3.functions.Action;
import pageObject.HomePage;
import pageObject.UploadPdfContent;
import pageObject.VDNObj;
import utility.BaseClass;
import utility.Listeners;
import utility.VDNUtils;

public class VDNMethods extends BaseClass {

	public static String createProject() throws InterruptedException {

		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
		Date.setTodayDate(driver, VO.getNominationEndDate());

		Thread.sleep(500);
		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
		Date.setTomorrowDate(driver, VO.getShortlistEndDate());
		Thread.sleep(500);
		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);
		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}
}

	public static void VerifySourcingOrgAdminIsAbleToCreateAndCanViewProjectOnContributor(String ProjectName)
			throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = ProjectName + " is Available in All Projects tab for contributors";
		String actual = ProjectName + " is not Available in All Projects tab for contributors";
		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']";
		Thread.sleep(10000);
		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
		assertProjectOnContributor.isDisplayed();
		home = VO.getAllProjectsTab().getText();
		actual = ProjectName + " is Available in All Projects tab for contributors";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("All Projects", homeText, expect, actual);
	}
	}

	public static void openAndNominate(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = ProjectName + " Nomination is sent Successfully";
		String actual = ProjectName + " Nomination is not sent Successfully";
		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
		VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
		Thread.sleep(5000);
		Thread.sleep(5000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
		VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
		home=VO.getAssertNominationSent().getText();
		actual = ProjectName + " Nomination is sent Successfully";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Nomination sent", homeText, expect, actual);
	}

}

	public static void verifySourcingOrgAdminIsAbleToAcceptNomination(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated";
		String actual = ProjectName + " is not Successfully Nominated";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnAccept());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			home = VO.getAssertNominationSuccess().getText();
			actual = ProjectName + " is Successfully Nominated";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination updated successfully...", homeText, expect, actual);
		}

}

	public static void validateCreateNewProjectwithAllContentTypes() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create From anyone along with the Tabs";
		String actual = "Sourcing org admin is unable to create From anyone along with the Tabs";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());
			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);
			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());
			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());
			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());
			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
			VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			Thread.sleep(10000);
			WebElement assertProjectOnMyProjects = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnMyProjects.isDisplayed();
			String s4 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement projectOpenbtn = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitToBeClickableAndClick(projectOpenbtn);
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			Thread.sleep(2000);
			Assert.assertTrue(VO.getAsserCourse().isDisplayed());
			Assert.assertTrue(VO.getAssertNominations().isDisplayed());
			Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());
			Assert.assertTrue(VO.getAssertContribution().isDisplayed());
			Assert.assertTrue(VO.getAssertReport().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertContribution());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReport());
			VDNUtils.waitToBeClickableAndClick(VO.getAsserCourse());
			home = VO.getAssertContribution().getText();
			actual = "Sourcing org admin is able to create From anyone along with the Tabs";
			
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
		}

}

	public static void verifySourcingOrgAdminIsAbleToRejectNomination(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated for Reject";
		String actual = ProjectName + " is not Successfully Nominated for Reject";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getRejectSubmit());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			home = VO.getAssertNominationSuccess().getText();
			actual = ProjectName + " is Successfully Nominated for Reject";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination updated successfully...", homeText, expect, actual);
		}

	}

	public static void validateAdminIsAbleToCreateFromOrganizationOnly() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create From anyone along with the Tabs";
		String actual = "Sourcing org admin is unable to create From anyone along with the Tabs";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());
			
			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);
			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
			VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());
			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
			VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			Thread.sleep(10000);
			WebElement assertProjectOnMyProjects = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnMyProjects.isDisplayed();
			String s4 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement projectOpenbtn = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitToBeClickableAndClick(projectOpenbtn);
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			Thread.sleep(2000);
			Assert.assertTrue(VO.getAsserCourse().isDisplayed());
			Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());
			Assert.assertTrue(VO.getAssertContribution().isDisplayed());
			Assert.assertTrue(VO.getAssertReport().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertContribution());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReport());
			VDNUtils.waitToBeClickableAndClick(VO.getAsserCourse());
			home = VO.getAssertContribution().getText();
			System.out.println(home);
			actual = "Sourcing org admin is able to create From anyone along with the Tabs";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
		}

	}

	public static void VerifyCreatedProjectsAreAvailableOnAllProjectsTab(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = ProjectName + " is Available on All My Projects Tab for Individual Contributor";
		String actual = ProjectName + " is not Available on All My Projects Tab for Individual Contributor";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			Thread.sleep(10000);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnContributor.isDisplayed();
			home = assertProjectOnContributor.getText();
			System.out.println(home);
			actual = ProjectName + " is Available on All My Projects Tab for Individual Contributor";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert(ProjectName, homeText, expect, actual);
		}
	}

	public static String validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create From anyone along with the Tabs";
		String actual = "Sourcing org admin is unable to create From anyone along with the Tabs";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());
			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);
			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());
			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());
			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());
			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
			VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			Thread.sleep(10000);
			WebElement assertProjectOnMyProjects = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnMyProjects.isDisplayed();
			String s4 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement projectOpenbtn = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitToBeClickableAndClick(projectOpenbtn);
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			Thread.sleep(2000);
			Assert.assertTrue(VO.getAssertNominations().isDisplayed());
			Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());
			Assert.assertTrue(VO.getAssertContribution().isDisplayed());
			Assert.assertTrue(VO.getAssertReport().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertContribution());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReport());
			home = VO.getAssertContribution().getText();
			actual = "Sourcing org admin is able to create From anyone along with the Tabs";
			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
		}

}

	public static void addSampleFromContriutionSideWithoutNominate(String ProjectName) throws InterruptedException {
		String home = null;
		String expect = ProjectName + " is Available on All My Projects Tab for Individual Contributor";
		String actual = ProjectName + " is not Available on All My Projects Tab for Individual Contributor";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			VDNUtils.waitToBeClickableAndClick(VO.getSelContentTypesbtn());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckCorseAssesment());

			VDNUtils.waitToBeClickableAndClick(VO.getCheckETextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckLearningRes());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckQuestionSet());

			VDNUtils.waitToBeClickableAndClick(VO.getCheckEContent());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckTeachingRes());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());

			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());

			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());

			home=VO.getAssertNominationSent().getText();
			System.out.println(home);
			actual =  ProjectName + " is Available on All My Projects Tab for Individual Contributor";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Nomination Sent", homeText, expect, actual);
		}
	}
	
	public static void VerifyCreatedProjectsAreAvailableOnAllProjectsTabForContOrgAdmin(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = ProjectName + " is Available on All My Projects Tab for Org Contributor";
		String actual = ProjectName + " is not Available on All My Projects Tab for Org Contributor";

		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnContributor.isDisplayed();
			home = assertProjectOnContributor.getText();
			System.out.println(home);
			actual = ProjectName + " is Available on All My Projects Tab for Org Contributor";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert(ProjectName, homeText, expect, actual);
		}
	}
	
	
	
	public static void VerifyContributorsAreAbleToNominateToTheProjectAndPendingStatus(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = ProjectName + " is Available on My Projects Tab for Org Contributor With Pending Status";
		String actual = ProjectName + " is not Available on My Projects Tab for Org Contributor or not With Pending Status";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 =" ']//following::span[text()='Pending'][1]";
			Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			WebElement assertProjectPendingStatus = driver.findElement(By.xpath(s1 + s2 + s4));
			assertProjectOnContributor.isDisplayed();
			assertProjectPendingStatus.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertPendingStatus().isDisplayed());
			Assert.assertTrue(VO.getAssertDigiTextbooks().isDisplayed());
			Assert.assertTrue(VO.getAsserAssignUsers().isDisplayed());
			home = VO.getAsserAssignUsers().getText();
			System.out.println(home);
			actual = ProjectName + " is Available on My Projects Tab for Org Contributor With Pending Status";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Assign users to project", homeText, expect, actual);
		}
	}
	
	
	public static String createProjectWithDigitalTextBook() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());

			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());

			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());


			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to Create and Publish The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	
	
	public static void validatePreApprovedUserNominationIsDisplayedInNominationsTab(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = ProjectName + " Pre-approved nomination should be displayed in the Nomination tab with approved status";
		String actual = ProjectName + " Pre-approved nomination is not displayed in the Nomination tab with approved status.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			//String s4 =" ']//following::span[text()='Pending'][1]";
			Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			//WebElement assertProjectPendingStatus = driver.findElement(By.xpath(s1 + s2 + s4));
			assertProjectOnContributor.isDisplayed();
			//assertProjectPendingStatus.isDisplayed();
			assertProjectOnContributor.click();
			//Thread.sleep(10000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertDigiTextBooks());
			
			Assert.assertTrue(VO.getAssertDigiTextBooks().isDisplayed());

			Assert.assertTrue(VO.getAssertNominations().isDisplayed());

			Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());

			Assert.assertTrue(VO.getAssertContribution().isDisplayed());

			Assert.assertTrue(VO.getAssertReport().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());

			VDNUtils.waitForElementToBeVisible(VO.getAssertPreApprovedOrgName());
			Assert.assertTrue(VO.getAssertPreApprovedOrgName().isDisplayed());
			
			Assert.assertTrue(VO.getAssertPreApprovedStatus().isDisplayed());
			
			home = VO.getAssertPreApprovedStatus().getText();
			System.out.println(home);
			actual = ProjectName + " Pre-approved nomination displayed in the Nomination tab with approved status.";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Approved", homeText, expect, actual);
		}
	}
	
	public static String createProjectWithCourse() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());

			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());

			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to Create and Publish The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}

	
	public static void verifySourcingOrgAdminIsAbleToAssignReviewer(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			VDNUtils.waitForElementToBeVisible(VO.getAssertNominations());

			Assert.assertTrue(VO.getAssertNominations().isDisplayed());

			Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());

			Assert.assertTrue(VO.getAssertContribution().isDisplayed());

			Assert.assertTrue(VO.getAssertReport().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());

			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "Jaga2");
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	
	
	public static void validateAssignedReviewerIsAbleToViewDetailsWithNominationEnable(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = "Assigned reviewer is able to view the assigned Project "+ProjectName+" in My Projects tab with details";
		String actual = "Assigned reviewer is unable to view the assigned Project "+ProjectName+" in My Projects tab with details";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			//String s4 =" ']//following::span[text()='Pending'][1]";
			Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			//WebElement assertProjectPendingStatus = driver.findElement(By.xpath(s1 + s2 + s4));
			assertProjectOnContributor.isDisplayed();
			//assertProjectPendingStatus.isDisplayed();
			assertProjectOnContributor.click();
			//Thread.sleep(10000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertDigiTextBooks());
			
			Assert.assertTrue(VO.getAssertDigiTextBooks().isDisplayed());

			Assert.assertTrue(VO.getAssertNominations().isDisplayed());

			//Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());

			Assert.assertTrue(VO.getAssertContribution().isDisplayed());

			Assert.assertTrue(VO.getAssertReport().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());

			VDNUtils.waitForElementToBeVisible(VO.getAssertPreApprovedOrgName());
			Assert.assertTrue(VO.getAssertPreApprovedOrgName().isDisplayed());
			
			Assert.assertTrue(VO.getAssertPreApprovedStatus().isDisplayed());
			
			home = VO.getAssertPreApprovedStatus().getText();
			System.out.println(home);
			actual = "Assigned reviewer is able to view the assigned Project "+ProjectName+" in My Projects tab with details";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Approved", homeText, expect, actual);
		}
	}
	
	public static String createProjectWithTextBook() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());

			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());

			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to Create and Publish The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	
	public static String createProjectWithTextBookWithUploadPDF() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			//UploadContentMethods UC = PageFactory.initElements(driver, UploadContentMethods.class);
			UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
			
			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());

			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());

			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
			Thread.sleep(3000);
			
			UploadContentMethods.UploadPdf();

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to Create and Publish The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	
	public static String createProjectWithTextBookWithNominationDisable() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
//			Date.setTodayDate(driver, VO.getNominationEndDate());
//
//			Thread.sleep(500);
//			Date.setTodayDate(driver);
//			Thread.sleep(1000);
//			Actions action = new Actions(driver);
//			action.sendKeys("\b").perform();
//			Thread.sleep(500);
//			action.sendKeys("3").perform();
//			Thread.sleep(500);
//
//			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
//			Date.setTomorrowDate(driver, VO.getShortlistEndDate());
//
//			Thread.sleep(500);
//			Date.setTomorrowDate(driver);
//			Thread.sleep(1000);
//			action.sendKeys("\b").perform();
//			Thread.sleep(500);
//			action.sendKeys("3").perform();
//			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to Create and Publish The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	
	public static void verifySourcingOrgAdminIsAbleToAssignReviewerNominationDisable(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			//String s4 =" ']//following::span[text()='Pending'][1]";
			//Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			//WebElement assertProjectPendingStatus = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			//assertProjectPendingStatus.isDisplayed();
			assertProjectOnContributor.click();
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertAssignUsers());
			
			//Assert.assertTrue(VO.getAsserCourse().isDisplayed());

			//Assert.assertTrue(VO.getAssertNominations().isDisplayed());

			Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());

			Assert.assertTrue(VO.getAssertContribution().isDisplayed());

			Assert.assertTrue(VO.getAssertReport().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());

			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
//			Assert.assertTrue(VO.getAssertPreApprovedOrgName().isDisplayed());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "Jaga2");
			
			Thread.sleep(10000);
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			
			//VO.getSearchField().clear();
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	public static void validateAssignedReviewerIsAbleToViewDetailsWithNominationDisable(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = "Assigned reviewer is able to view the assigned Project "+ProjectName+" in My Projects tab with details";
		String actual = "Assigned reviewer is unable to view the assigned Project "+ProjectName+" in My Projects tab with details";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			//String s4 =" ']//following::span[text()='Pending'][1]";
			Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			//WebElement assertProjectPendingStatus = driver.findElement(By.xpath(s1 + s2 + s4));
			assertProjectOnContributor.isDisplayed();
			//assertProjectPendingStatus.isDisplayed();
			assertProjectOnContributor.click();
			//Thread.sleep(10000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertDigiTextBooks());
			
			Assert.assertTrue(VO.getAssertDigiTextBooks().isDisplayed());

			//Assert.assertTrue(VO.getAssertNominations().isDisplayed());

			//Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());

			Assert.assertTrue(VO.getAssertContribution().isDisplayed());

			Assert.assertTrue(VO.getAssertReport().isDisplayed());

			//VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());

//			VDNUtils.waitForElementToBeVisible(VO.getAssertPreApprovedOrgName());
//			Assert.assertTrue(VO.getAssertPreApprovedOrgName().isDisplayed());
			
//			Assert.assertTrue(VO.getAssertPreApprovedStatus().isDisplayed());
			
			home = VO.getAssertContribution().getText();
			System.out.println(home);
			actual = "Assigned reviewer is able to view the assigned Project "+ProjectName+" in My Projects tab with details";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
		}
	}
	
	
	public static void verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getAsserAssignUsers().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAsserAssignUsers());
			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "Jaga1");
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "ekstep17");
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "rating2");
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectBothPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}

	
	public static String createProjectWithoutTargetCollection() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully without Target Collection";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully without Target Collection";

		try {
			
		Thread.sleep(5000);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
		Thread.sleep(5000);

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
		Date.setTodayDate(driver, VO.getNominationEndDate());

		Thread.sleep(500);
		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);
		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
		Date.setTomorrowDate(driver, VO.getShortlistEndDate());

		Thread.sleep(500);
		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);


		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);		

		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		

		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Target Collection";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	public static void verifySourcingOrgAdminIsAbleToAcceptNominationWithoutTargetCollection(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated";
		String actual = ProjectName + " is not Successfully Nominated";

		try {
			
			
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);

			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());

			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnAccept());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			home = VO.getAssertNominationSuccess().getText();
			actual = ProjectName + " is Successfully Nominated";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination updated successfully...", homeText, expect, actual);
		}

	}
	
	public static void openAndNominateWithoutTargetCollection(String ProjectName) throws InterruptedException {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);

		VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
		VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());

	//	VO.getAssertSelectedCTMsg.isDisplayed();
		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
		Thread.sleep(5000);

//		Thread.sleep(5000);
//		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());

		VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());

	}
	
	
	
	public static void verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Assert.assertTrue(VO.getAsserAssignUsers().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getAsserAssignUsers());
			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color1");
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color3");
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color5");
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectBothPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	public static void verifyDefaultContributionOrgContributorIsAbleToUploadContentForSkipReviewEnabled(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadbtn().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			VDNUtils.waitForElementToBeVisible(VO.getClkCreateNew());
			
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
//			
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color1");
//			
//			
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssessment());
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
//			
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color3");
//			
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			home = VO.getRolesUpdatedMsg().getText();
//			System.out.println(home);
			
			//VO.getSearchField().clear();
			//VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
//			
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color5");
//			
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectBothPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
            Thread.sleep(3000);
			
		//	UploadContentMethods.UploadPdf();
			
//			home = VO.getRolesUpdatedMsg().getText();
//			System.out.println(home);
			
			//VO.getSearchField().clear();
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
//			String homeText = home != null ? home : "N/A";
//			System.out.println(homeText);
//			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	
	public static void uploadTheContentFromIndividualContributorSideAndVerifyDraftStatusInTOC(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Content should be available on the TOC with draft status for "+ProjectName+" and is Displayed on the Top";
		String actual =  "Content is not available on the TOC with draft status for "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadbtn().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getContentSavedtMessage());
			Assert.assertTrue(VO.getContentSavedtMessage().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertDraft());
			Assert.assertTrue(VO.getAssertDraft().isDisplayed());
			String stausDraft = VO.getAssertDraft().getText();
			Assert.assertEquals(stausDraft,"Draft");			
			home = VO.getAssertDraft().getText();			

			actual = "Content available on the TOC with draft status for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Draft" ,homeText, expect, actual);
		}
	}
	
	
	
	
	public static void uploadContentAndVerifyApprovalPendingStatusInTOCPostPublish(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Content should be available on the TOC with Approval Pending status for "+ProjectName+" and is Displayed on the Top";
		String actual =  "Content is not available on the TOC with Approval Pending status for "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadbtn().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			//js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(2000);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkCheckBox());
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getContentAcceptedMsg());
			Assert.assertTrue(VO.getContentAcceptedMsg().isDisplayed());
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getSelectSample1());
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPendingOnTOC());
			Assert.assertTrue(VO.getAssertApprovalPendingOnTOC().isDisplayed());
			String stausApprovalPending = VO.getAssertApprovalPendingOnTOC().getText();
			Assert.assertEquals(stausApprovalPending,"Approval Pending");			
			home = VO.getAssertApprovalPendingOnTOC().getText();	
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			//js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(2000);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkCheckBox());
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getContentAcceptedMsg());
			Assert.assertTrue(VO.getContentAcceptedMsg().isDisplayed());
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getSelectSample1());
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending2OnTOC());
			Assert.assertTrue(VO.getAssertApprovalPending2OnTOC().isDisplayed());
			String stausApprovalPending2 = VO.getAssertApprovalPending2OnTOC().getText();
			Assert.assertEquals(stausApprovalPending2,"Approval Pending");			
			//home = VO.getAssertApprovalPending2OnTOC().getText();
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			//js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(2000);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkCheckBox());
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getContentAcceptedMsg());
			Assert.assertTrue(VO.getContentAcceptedMsg().isDisplayed());
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getSelectSample1());
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending3OnTOC());
			Assert.assertTrue(VO.getAssertApprovalPending3OnTOC().isDisplayed());
			String stausApprovalPending3 = VO.getAssertApprovalPending3OnTOC().getText();
			Assert.assertEquals(stausApprovalPending3,"Approval Pending");
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			//js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(2000);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkCheckBox());
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getContentAcceptedMsg());
			Assert.assertTrue(VO.getContentAcceptedMsg().isDisplayed());
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getSelectSample1());
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending4OnTOC());
			Assert.assertTrue(VO.getAssertApprovalPending4OnTOC().isDisplayed());
			String stausApprovalPending4 = VO.getAssertApprovalPending4OnTOC().getText();
			Assert.assertEquals(stausApprovalPending4,"Approval Pending");

			actual = "Content available on the TOC with Approval Pending status for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static String createProjectBookWithoutTargetCollection() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully without Target Collection";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully without Target Collection";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
		Date.setTodayDate(driver, VO.getNominationEndDate());

		Thread.sleep(500);
		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);
		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
		Date.setTomorrowDate(driver, VO.getShortlistEndDate());

		Thread.sleep(500);
		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);


		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);		

		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		

		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Target Collection";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}

	public static void contributorIsAbleToNominateWithoutTargetCollectionWithSample(String ProjectName) throws Exception {
		
		String home = null;
		String expect = ProjectName + " From Contribution org admin should be able to nominate to the project by uplaoding the sample";
		String actual = ProjectName + " From Contribution org admin is unable to nominate to the project by uplaoding the sample";
		
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);

			VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
			
			Thread.sleep(10000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadSample());
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(5000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentUpload());
			Assert.assertTrue(VO.getAssertContentUpload().isDisplayed());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSubmit());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			//js.executeScript("window.scrollBy(0, 500)");
			Thread.sleep(2000);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkCheckBox());
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
//			Thread.sleep(5000);
//
//
			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home=VO.getAssertNominationSent().getText();
			actual = ProjectName + " From Contribution org admin is able to nominate to the project by uplaoding the sample";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination sent", homeText, expect, actual);
		}
	
	}
	
	public static void verifProjectyWithoutTargetCollectionIsAvailableInMyProjectTabWithNominationPendingStatus(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " without target collection is available in My project tab with nomination pending status";
		String actual = ProjectName + " without target collection is not available in My project tab with nomination pending status";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
		
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);

			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());

			
			Assert.assertTrue(VO.getAssertPending().isDisplayed());
			home = VO.getAssertPending().getText();
			actual = ProjectName + " without target collection is available in My project tab with nomination pending status";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Pending", homeText, expect, actual);
		}
	}
	public static void verifyCreatedProjectWithSkipReviewDisabled(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = " Admin able to create "+ProjectName+" and publish the nomination open with Skip Review Disabled for Withot Target Collection ";
		String actual = " Admin unable to create "+ProjectName+" and publish the nomination open with Skip Review Disabled for Withot Target Collection ";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " '])[3]";
			String s4 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
		
			WebElement PublishedProject = driver.findElement(By.xpath(s1 + s2 + s3));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", PublishedProject);
			Assert.assertTrue(PublishedProject.isDisplayed());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s4));
			home = clkOpenProject.getText();
			actual = " Admin able to create "+ProjectName+" and publish the nomination open with Skip Review Disabled for Withot Target Collection ";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Open", homeText, expect, actual);
		}
	}
	
	public static String createProjectBookWithoutTargetCollectionOrgOnly() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully without Target Collection";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully without Target Collection";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);
		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());
		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
	
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Target Collection";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	public static void verifyCreatedProjectWithSkipReviewEnabled(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = " sourcing org admin should be able to create nomination disabled without target and skip review enabled for project "+ProjectName;
		String actual = " sourcing org admin is unable to create nomination disabled without target and skip review enabled for project "+ProjectName;

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " '])[3]";
			String s4 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
		
			WebElement PublishedProject = driver.findElement(By.xpath(s1 + s2 + s3));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", PublishedProject);
			Assert.assertTrue(PublishedProject.isDisplayed());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Assert.assertTrue(VO.getAssertSkipReviewEnabled().isDisplayed());
			String tabDetails = VO.getAssertTabs().getText();
			
			String[] lines = tabDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Nominations");
			}
			home = VO.getAssertSkipReviewEnabled().getText();
			actual = "sourcing org admin is able to create nomination disabled without target and skip review enabled for project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Skip two level review enabled", homeText, expect, actual);
		}
	}
	
	public static void verifyMyContentsTabIsAvailable() throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = " 'My Contents' tab should be available with Information for Contributor Org Admin, Individual Contributor and Contributor Org Contributor";
		String actual = " 'My Contents' tab is not available with Information for Contributor Org Admin, Individual Contributor and Contributor Org Contributor";

		try {
			
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			Assert.assertTrue(VO.getClkMyContent().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyContent());
			
			Assert.assertTrue(VO.getAssertMyContentHeader().isDisplayed());
			String Header = VO.getAssertMyContentHeader().getText();
			Assert.assertEquals(Header, "My Content");
			
			Assert.assertTrue(VO.getAssertTotalContributed().isDisplayed());
			
			Assert.assertTrue(VO.getAssertPublishedOnDiksha().isDisplayed());
			
			Assert.assertTrue(VO.getAssertNotPublishedOnDiksha().isDisplayed());
		
			home = VO.getAssertMyContentHeader().getText();
			actual = " 'My Contents' tab is available with Information for Contributor Org Admin, Individual Contributor and Contributor Org Contributor";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("My Content", homeText, expect, actual);
		}
	}
	
	
	public static void IndContributorIsAbleToNominateWithoutTargetCollectionThroughTenCard(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = ProjectName + " Nomination is sent Successfully";
		String actual = ProjectName + " Nomination is not sent Successfully";
		try {
			driver.get(config.get_Env_Sourcing());
			Thread.sleep(5000);
			Assert.assertTrue(VO.getClkTenentCard().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getClkTenentCard());	
			Thread.sleep(5000);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
			Thread.sleep(5000);
			Thread.sleep(5000);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home=VO.getAssertNominationSent().getText();
			actual = ProjectName + " Nomination is sent Successfully";
			String s4 = "//*[contains(text(),'";
			String s5 = ProjectName;
			String s6 = " ')]//following::span[text()='Pending']";
			WebElement assertPending = driver.findElement(By.xpath(s4 + s5 + s6));
			Assert.assertTrue(assertPending.isDisplayed());
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination sent", homeText, expect, actual);
		}

	}
	
	public static String createProjectWithDigitalTextBookAndSave() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to Save The Project Successfully";
		String actual = "Sourcing org admin is unable to Save The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());

			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());

			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());


			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());


			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getBtnSaveAsDraft());

			VDNUtils.waitToBeClickableAndClick(VO.getBtnSaveAsDraft());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectSaved());
			
			Assert.assertTrue(VO.getAssertProjectSaved().isDisplayed());

			
			home = VO.getAssertProjectSaved().getText();
			actual = "Sourcing org admin is able to Save The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project saved as draft successfully!", homeText, expect, actual);
		}

	}
	
	
	
	public static void verifyEditDeleteIconsInDraftwithContent(String ProjectName)
			throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = " User should be able to Update and delete the draft project";
		String actual = " User is unable to Update and delete the draft project";
		try {
		String s1 = "(//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::span[text()='Edit Draft'])[1]";
		Thread.sleep(10000);
		WebElement assertProjectEdit = driver.findElement(By.xpath(s1 + s2 + s3));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", assertProjectEdit);
		assertProjectEdit.isDisplayed();
		assertProjectEdit.click();
		
		String ProjectName_Update = VDNUtils.set_Content_Name("AutoPU_");
		VO.getEnterProjectName().clear();
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName_Update);

		String ProjectDesc_Update = VDNUtils.set_Content_Name("AutoDU_");
		VO.getEnterProjectDesc().clear();
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc_Update);
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getBtnSaveAsDraft());

		VDNUtils.waitToBeClickableAndClick(VO.getBtnSaveAsDraft());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectSaved());
		
		Assert.assertTrue(VO.getAssertProjectSaved().isDisplayed());
		
		String s4 = "(//div[text()=' ";
		String s5 = ProjectName_Update;
		String s6 = " ']//following::span[text()='Edit Draft'])[1]";
		String s7 = " ']//following::div[@class='sb-dock-icon-tooltip d-inline-block'])[1]";
		Thread.sleep(10000);
		WebElement assertProjectUpdated = driver.findElement(By.xpath(s4 + s5 + s6));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", assertProjectUpdated);
		assertProjectUpdated.isDisplayed();
		WebElement clkProjectDelete = driver.findElement(By.xpath(s4 + s5 + s7));
		clkProjectDelete.click();
		VDNUtils.waitToBeClickableAndClick(VO.getConfirmDeletion());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertDeleteMsg());
		
		Assert.assertTrue(VO.getAssertDeleteMsg().isDisplayed());
		
		home = VO.getAssertDeleteMsg().getText();
		actual = " User is able to Update and delete the draft project";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("The project has been deleted successfully.", homeText, expect, actual);
	}
	}
	
	public static void nominateWithoutTargetCollectionThroughTenCard(String ProjectName) throws Exception {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = ProjectName + " Nomination is sent Successfully";
		String actual = ProjectName + " Nomination is not sent Successfully";
		try {
			driver.get(config.get_Env_Sourcing());
			Thread.sleep(5000);
			Assert.assertTrue(VO.getClkTenentCard().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getClkTenentCard());	
			Thread.sleep(5000);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
			Thread.sleep(5000);
			Thread.sleep(5000);
			
			Thread.sleep(10000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadSample());
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(5000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentUpload());
			Assert.assertTrue(VO.getAssertContentUpload().isDisplayed());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSubmit());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home=VO.getAssertNominationSent().getText();
			actual = ProjectName + " Nomination is sent Successfully";
			String s4 = "//*[contains(text(),'";
			String s5 = ProjectName;
			String s6 = " ')]//following::span[text()='Pending']";
			WebElement assertPending = driver.findElement(By.xpath(s4 + s5 + s6));
			Assert.assertTrue(assertPending.isDisplayed());
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination sent", homeText, expect, actual);
		}

	}
	
	public static void verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = " sourcing org admin is able to view the sample and accept the nomination for "+ProjectName;
		String actual = " sourcing org admin is unable to view the sample and accept the nomination for "+ProjectName;

		try {
			
			
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);

			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());

			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenSample());
			Assert.assertTrue(VO.getAssertSample().isDisplayed());
			Assert.assertTrue(VO.getAssertSampleContentDetails().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBtnAccept());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			home = VO.getAssertNominationSuccess().getText();
			actual = " sourcing org admin is able to view the sample and accept the nomination for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination updated successfully...", homeText, expect, actual);
		}

	}
	
	
	public static void verifyContentStatusDigitalTextBook(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated";
		String actual = ProjectName + " is not Successfully Nominated";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			//VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtn());
			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VO.getSelectSample1().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			//VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
			
			VO.getClkPublish().click();
			Thread.sleep(5000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovedTabs());
			Assert.assertTrue(VO.getAssertApprovedTabs().isDisplayed());
			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
			String AppCount = VO.getApprovedTabCount().getText();
			System.out.print(AppCount);
			
			int AppC=Integer.parseInt(AppCount); 
			
			
			//getAssertApprovedTabs
			
			
			
			
			
			
			
			
			VO.getSelectSample2().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			
			
			
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
			Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
			
			String RejCount = VO.getAssertRejectedCount().getText();
			System.out.print(RejCount);
			
			int RejC=Integer.parseInt(RejCount); 
			
			
			
			
			VO.getSelectSample3().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
		
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentCorrection());
			Assert.assertTrue(VO.getAssertContentCorrection().isDisplayed());
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getCorrectionsPenTOC());
			Assert.assertTrue(VO.getCorrectionsPenTOC().isDisplayed());
			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
			String CorCount = VO.getCorrectionsPenCount().getText();
			System.out.print(CorCount);
			
			int CorC=Integer.parseInt(CorCount); 
			
			
			VDNUtils.waitForElementToBeVisible(VO.getApprovalPenNode());
			Assert.assertTrue(VO.getApprovalPenNode().isDisplayed());
			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
			String AppPenC = VO.getApprovalPenCount().getText();
			System.out.print(AppPenC);
			
			int PenC=Integer.parseInt(AppPenC);
			
			
			
			int Tot = AppC+RejC+CorC+PenC;
			System.out.println(Tot);
			
			
			Assert.assertTrue(VO.getTotalNode().isDisplayed());
			
			String TotCount = VO.getTotalCount().getText();
			int TotalC=Integer.parseInt(TotCount);
			
			System.out.println(TotCount);
			Assert.assertEquals(Tot,TotalC);
			
			
		
			home = VO.getApprovalPenNode().getText();
			actual = ProjectName + " is Sent For Approval and Send For Correction";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending:", homeText, expect, actual);
		}

}
	
	public static void validateContentLabelInNominiatonList(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated";
		String actual = ProjectName + " is not Successfully Nominated";
		try {
			
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
//			VDNUtils.waitToBeClickableAndClick(VO.getMyProjects());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			

			Assert.assertTrue(VO.getAssertNomimnationList().isDisplayed());
			String downloadListText = VO.getAssertNomimnationList().getText();
			Assert.assertEquals(downloadListText, "Download Nominations List");
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			//VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtn());
			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VO.getSelectSample1().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			//VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
			VO.getClkPublish().click();
			Thread.sleep(5000);
			
			//VDNUtils.waitForElementToBeVisible(VO.getBackBtn());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getBackBtn());
			VO.getBackBtn().click();
			Thread.sleep(10000);
			
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount1 = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount1);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount1 = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount1);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount1 = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount1);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount1 = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount1);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount1 = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount1);
			
			
//			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
//			VDNUtils.waitToBeClickableAndClick(VO.getBtnAccept());
//			Thread.sleep(3000);
//			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
//			home = VO.getAssertNominationSuccess().getText();
//			actual = ProjectName + " is Successfully Nominated";
		} finally {
//			String homeText = home != null ? home : "N/A";
//			Listeners.customAssert("Nomination updated successfully...", homeText, expect, actual);
		}

}
	public static void ContributorOrgAdminIsAbleToSearchAndAssignBothRoles(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Assert.assertTrue(VO.getAsserAssignUsers().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getAsserAssignUsers());
//			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color1");
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
			
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color3");
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			home = VO.getRolesUpdatedMsg().getText();
//			System.out.println(home);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color3");
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectBothPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	public static void validateUserShouldNotBeAllowedToReviewHisOwnContent(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " User should not be allowed to review his own content";
		String actual =  "User is allowed to review his own content";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadContent().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadContent());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			Thread.sleep(5000);
			VO.getClkOpenReviePending().click();
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertReviewPending());
			
			
			String tabDetails = VO.getAssertAllReviewContentHead().getText();
			
			String[] lines = tabDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Submit for Approval");
			    Assert.assertNotEquals(line,"Request changes");
			}
			home = VO.getAssertReviewPending().getText();
			actual = "User should not be allowed to review his own content ";

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
		}
	}
	
	
	public static void uploadContentFromAssignedContributor(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Content should be available on the TOC with Approval Pending status for "+ProjectName+" and is Displayed on the Top";
		String actual =  "Content is not available on the TOC with Approval Pending status for "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadContent().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadContent());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			Thread.sleep(5000);
			VO.getSelectSample1().click();
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			home = VO.getAssertApprovalPending().getText();
			actual = "sourcing org admin is able to create nomination disabled without target and skip review enabled for project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static String validateAdminIsAbleToCreateFromOrganizationOnlyWithSkipReviewEnable() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create From anyone along with the Tabs";
		String actual = "Sourcing org admin is unable to create From anyone along with the Tabs";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());
			
			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);
			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
			VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());
			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
			VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			Thread.sleep(10000);
			WebElement assertProjectOnMyProjects = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnMyProjects.isDisplayed();
			String s4 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement projectOpenbtn = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitToBeClickableAndClick(projectOpenbtn);
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			Thread.sleep(2000);
			Assert.assertTrue(VO.getAssertContribution().isDisplayed());
			Assert.assertTrue(VO.getAssertReport().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertContribution());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReport());
			home = VO.getAssertContribution().getText();
			System.out.println(home);
			actual = "Sourcing org admin is able to create From anyone along with the Tabs";
			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
		}
	}
	
	
	public static void validateSendbackCorrectionsAndRejectBtnsNotDisplayed(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " default contribution org reviewer is able to view the uploaded content for skip for review enabled Projects and 'accept' and 'request' for changes button should not be available.";
		String actual =  "default contribution org reviewer is able to view the uploaded content for skip for review enabled Projects and 'accept' and 'request' for changes buttons are available.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Assert.assertTrue(VO.getClkReviewContent().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContent());
			Thread.sleep(2000);
			VO.getSelectSample1().click();
			Thread.sleep(3000);
			String tabDetails = VO.getAssertAllReviewContentHead().getText();
			String[] lines = tabDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Submit for Approval");
			    Assert.assertNotEquals(line,"Request changes");
			}
			home = VO.getAssertApprovalPending().getText();
			actual = "default contribution org reviewer is able to view the uploaded content for skip for review enabled Projects and 'accept' and 'request' for changes button is not available. ";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static void validateDefaultOrgUserWithBothAsRoleIsAbleToReviewTheContent(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " default contribution org reviewer is able to preview the uploaded content by contributor.";
		String actual =  "default contribution org reviewer is unable to preview the uploaded content by contributor.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			VDNUtils.waitForElementToBeVisible(VO.getAssertReviewPending());
			Assert.assertTrue(VO.getAssertReviewPending().isDisplayed());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnReview());
			Assert.assertTrue(VO.getClkOpenBtnReview().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnReview());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			Assert.assertTrue(VO.getAssertSample().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertEditDetails());
			Assert.assertTrue(VO.getAssertEditDetails().isDisplayed());
			home = VO.getAssertEditDetails().getText();
			actual = "default contribution org reviewer is able to preview the uploaded content by contributor.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Edit details" ,homeText, expect, actual);
		}
	}
	
	public static void uploadContentFromContributor(String ProjectName)
			throws Exception {
		String ReviewPending = null;
		String expect = "Assigned Contributor Org is able to upload Content For Project "+ProjectName;
		String actual =  "Assigned Contributor Org is unable to upload Content For Project "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadContent().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadContent());
			Thread.sleep(2000);
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			VDNUtils.waitForElementToBeVisible(VO.getAssertReviewPending());
			Assert.assertTrue(VO.getAssertReviewPending().isDisplayed());
			
			ReviewPending = VO.getAssertReviewPending().getText();
			actual = "Assigned Contributor Org is able to upload Content For Project "+ProjectName;
		} finally {
			String homeText = ReviewPending != null ? ReviewPending : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
		}
	}
	
	
	public static void verifyCreatedProjectIsAvailableInIndividualContentWithoutCollectionSection(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Created Project "+ProjectName + " Is Available In Individual Content Without Collection Section with Nomination Enable and Skip Review Disable";
		String actual = "Created Project "+ProjectName + " Is not Available In Individual Content Without Collection Section with Nomination Enable and Skip Review Disable";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			String s4 = " '])";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
//			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s4));
//			Assert.assertTrue(assertProjectOnContributor.isDisplayed());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			String contentDetails = VO.getAssertContnts().getText();
			String[] lines = contentDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Skip two level review enabled");
			}
			
			Assert.assertTrue(VO.getAssertNominations().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());
			VDNUtils.waitForElementToBeVisible(VO.getAssertNomimnationList());
			home = VO.getAssertNomimnationList().getText();
			actual = "Created Project "+ProjectName + " Is Available In Individual Content Without Collection Section with Nomination Enable and Skip Review Disable";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Download Nominations List", homeText, expect, actual);
		}

	}
	
	public static void assignReviewerRoleToTheCreatedProject()
			throws InterruptedException {
		String home = null;
		String expect = " sourcing org admin is able to assign the reviewer with Nomination Enable and Skip review Disable";
		String actual =  "sourcing org admin is unable to assign the reviewer with Nomination Enable and Skip review Disable";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());

			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "Jaga2");
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			Thread.sleep(5000);
			VDNUtils.waitForElementToBeVisible(VO.getMyProjects());

			actual = " sourcing org admin is able to assign the reviewer with Nomination Enable and Skip review Disable" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	public static String createProjectWithDigitalTextBookAndSave1() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to Save The Project Successfully";
		String actual = "Sourcing org admin is unable to Save The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());

			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());

			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());


			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());


			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getBtnSaveAsDraft());

			VDNUtils.waitToBeClickableAndClick(VO.getBtnSaveAsDraft());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectSaved());
			
			Assert.assertTrue(VO.getAssertProjectSaved().isDisplayed());

			
			home = VO.getAssertProjectSaved().getText();
			actual = "Sourcing org admin is able to Save The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project saved as draft successfully!", homeText, expect, actual);
		}

	}
	
	public static String createProjectBookWithoutTargetCollectionSelectedCont() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully without Target Collection For Selected Organization";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully without Target Collection For Selected Organization";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSelectedContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
		VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"Color");
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());

		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);		

		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		

		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Target Collection For Selected Organization";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	public static void verifyCreatedProjectIsAvailableInIndividualContentWithoutCollectionSectionForSelected(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Created Project "+ProjectName + " Is Available In Individual Content Without Collection Section with Nomination Enable and Skip Review Disable For Selected Contributor ";
		String actual = "Created Project "+ProjectName + " Is not Available In Individual Content Without Collection Section with Nomination Enable and Skip Review Disable For Selected Contributor";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			String s4 = " '])";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			String contentDetails = VO.getAssertContnts().getText();
			String[] lines = contentDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Skip two level review enabled");
			}
			
			Assert.assertTrue(VO.getAssertNominations().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());
			VDNUtils.waitForElementToBeVisible(VO.getAssertNomimnationList());
			home = VO.getAssertNomimnationList().getText();
			actual = "Created Project "+ProjectName + " Is Available In Individual Content Without Collection Section with Nomination Enable and Skip Review Disable For Selected Contributor";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Download Nominations List", homeText, expect, actual);
		}

	}
	
	
	
	public static void validateChangeRoleToAdminInManageUsersAndVerifyToastMessage() throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "contributor org admin is able to assign admin role for a contribution org user.";
		String actual = "contributor org admin is unable to assign admin role for a contribution org user.";

		try {
//			String s1 = "(//div[text()=' ";
//			String s2 = ProjectName;
//			String s3 = " ']//following::button[text()='Open '][1])[3]";
//			String s4 = " '])";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
//			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s4));
//			Assert.assertTrue(assertProjectOnContributor.isDisplayed());
//			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(VO.getAllProjectsTab());
			Assert.assertTrue(VO.getAllProjectsTab().isDisplayed());
			
			Assert.assertTrue(VO.getMyProjectTab().isDisplayed());
			Assert.assertTrue(VO.getAllProjectsTab().isDisplayed());
			Assert.assertTrue(VO.getClkManageUsers().isDisplayed());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkManageUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getClkManageUsers());
			
			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color2");
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			Thread.sleep(5000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectAdmin());
			VDNUtils.waitForElementToBeVisible(VO.getAssertRolesUpdatedSuccess());
			home = VO.getAssertRolesUpdatedSuccess().getText();
			System.out.println(home);
			
			Thread.sleep(5000);
			
//			VDNUtils.waitForElementToBeVisible(VO.getSelectOptions());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectOptions());
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			
			
			actual = "contributor org admin is able to assign admin role for a contribution org user.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Role updated successfully", homeText, expect, actual);
		}

	}
	
	
	public static void assignAdminRoleThroughManageUser() throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "contributor org admin is able to assign admin role for a contribution org user.";
		String actual = "contributor org admin is unable to assign admin role for a contribution org user.";

		try {
//			String s1 = "(//div[text()=' ";
//			String s2 = ProjectName;
//			String s3 = " ']//following::button[text()='Open '][1])[3]";
//			String s4 = " '])";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
//			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s4));
//			Assert.assertTrue(assertProjectOnContributor.isDisplayed());
//			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(VO.getAllProjectsTab());
			Assert.assertTrue(VO.getAllProjectsTab().isDisplayed());
			
			Assert.assertTrue(VO.getMyProjectTab().isDisplayed());
			Assert.assertTrue(VO.getAllProjectsTab().isDisplayed());
			Assert.assertTrue(VO.getClkManageUsers().isDisplayed());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkManageUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getClkManageUsers());
			
			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color2");
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			Thread.sleep(5000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectAdmin());
			VDNUtils.waitForElementToBeVisible(VO.getAssertRolesUpdatedSuccess());
			home = VO.getAssertRolesUpdatedSuccess().getText();
			System.out.println(home);
			
			Thread.sleep(5000);
			
//			VDNUtils.waitForElementToBeVisible(VO.getSelectOptions());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectOptions());
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			
			
			actual = "contributor org admin is able to assign admin role for a contribution org user.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Role updated successfully", homeText, expect, actual);
		}

	}
	
	public static void assignUserRoleThroughManageUser() throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "contributor org admin is able to assign admin role for a contribution org user.";
		String actual = "contributor org admin is unable to assign admin role for a contribution org user.";

		try {
//			String s1 = "(//div[text()=' ";
//			String s2 = ProjectName;
//			String s3 = " ']//following::button[text()='Open '][1])[3]";
//			String s4 = " '])";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
//			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s4));
//			Assert.assertTrue(assertProjectOnContributor.isDisplayed());
//			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(VO.getAllProjectsTab());
			Assert.assertTrue(VO.getAllProjectsTab().isDisplayed());
			
			Assert.assertTrue(VO.getMyProjectTab().isDisplayed());
			Assert.assertTrue(VO.getAllProjectsTab().isDisplayed());
			Assert.assertTrue(VO.getClkManageUsers().isDisplayed());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkManageUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getClkManageUsers());
			
			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color2");
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			Thread.sleep(5000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectAdmin());
			VDNUtils.waitForElementToBeVisible(VO.getAssertRolesUpdatedSuccess());
			home = VO.getAssertRolesUpdatedSuccess().getText();
			System.out.println(home);
			
			Thread.sleep(5000);
			
//			VDNUtils.waitForElementToBeVisible(VO.getSelectOptions());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectOptions());
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			
			
			actual = "contributor org admin is able to assign admin role for a contribution org user.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Role updated successfully", homeText, expect, actual);
		}

	}
	
	public static void uploadTheContentFromIndividualContributorSide(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Able to upload The Content From Individual Contributor for "+ProjectName;
		String actual =  "Unable to upload The Content From Individual Contributor for  "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelContentTypesbtn());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckCorseAssesment());

			VDNUtils.waitToBeClickableAndClick(VO.getCheckETextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckLearningRes());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckQuestionSet());

			VDNUtils.waitToBeClickableAndClick(VO.getCheckEContent());
			VDNUtils.waitToBeClickableAndClick(VO.getCheckTeachingRes());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());

			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
			
			VDNUtils.waitToBeClickableAndClick(VO.getUploadSampleBtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());	
			home = VO.getAssertContentSetReview().getText();			

			actual = " Able to upload The Content From Individual Contributor for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
		}
	}
	
	
	
	public static void validteIntiateStatusUnderMyProjects(String ProjectName ) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Project "+ProjectName +"  is displayed in 'My Projects' tab with initiated status.";
		String actual = "Project "+ProjectName +"  is not displayed in 'My Projects' tab with initiated status.";

		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = " ']//following::span[text()='Initiated'][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			driver.navigate().refresh();
			Thread.sleep(5000);
			Thread.sleep(2000);
			VO.getMyProjectTab().click();
			WebElement assertProjectInitiatedStats = driver.findElement(By.xpath(s1 + s2 + s4));
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			String assertInitiate = assertProjectInitiatedStats.getText();
			Assert.assertEquals(assertInitiate,"Initiated");
			
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertStatusInitiate());
			Assert.assertTrue(VO.getAssertStatusInitiate().isDisplayed());

			home = VO.getAssertStatusInitiate().getText();			

			actual = "Project "+ProjectName +"  is displayed in 'My Projects' tab with initiated status.";

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Initiated", homeText, expect, actual);
		}

	}
	
	public static void uploadTheContentFromContOrgContributorSaveAsDraftAndSendForReview(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Contributor should be able to save the content draft status and Review Pending Staus for Project  "+ProjectName;
		String actual =  "Contributor is unable to save the content draft status or Review Pending Staus for Project "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadbtn().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getContentSavedtMessage());
			Assert.assertTrue(VO.getContentSavedtMessage().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertDraft());
			Assert.assertTrue(VO.getAssertDraft().isDisplayed());
			String stausDraft = VO.getAssertDraft().getText();
			Assert.assertEquals(stausDraft,"Draft");			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			String stausReviewPending = VO.getAssertReviewPending().getText();
			Assert.assertEquals(stausReviewPending,"Review Pending");
			
			
			Assert.assertTrue(VO.getAssertDraftNode().isDisplayed());
			
			String DraftCount = VO.getAssertDraftCount().getText();
			System.out.println(DraftCount);
			int DraftC=Integer.parseInt(DraftCount);  
			
            Assert.assertTrue(VO.getReviewPendingNode().isDisplayed());
			
			String ReviewPendingCount = VO.getAssertReviewPendingCount().getText();
			
			System.out.println(ReviewPendingCount);
			int ReviewPendingC=Integer.parseInt(DraftCount); 
			
			int Total = DraftC+ReviewPendingC;
			System.out.println(Total);
			
			Assert.assertTrue(VO.getTotalNode().isDisplayed());
			
			String TotalCount = VO.getTotalCount().getText();
			int TotalC=Integer.parseInt(TotalCount);
			
			System.out.println(TotalCount);
			Assert.assertEquals(Total,TotalC);
			
			
			actual = "Content available on the TOC with draft status for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	
	public static String createProjectBookWithoutTargetCollectionSelectedInd() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully without Target Collection For Selected Individual User";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully without Target Collection For Selected Individual User";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSelectedContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
		VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());

		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);		

		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		

		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Target Collection For Selected Individual User";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	public static void SourcingOrgAdminIsAbleToEditAndModififyThePrpjectWithoutTargetCol(String ProjectName)
			throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "Sourcing org admin is able to edit and Modifify the Prpject Wihout Target Collection";
		String actual = " Sourcing org admin is unable to edit or Modifify the Prpject Wihout Target Collection";
		try {
		String s1 = "(//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])[3]";
		String s4 = "//following::i[@data-tooltip='Modify'][1]";
		Thread.sleep(10000);
		WebElement assertProjectEdit = driver.findElement(By.xpath(s1 + s2 + s3+s4));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", assertProjectEdit);
		assertProjectEdit.isDisplayed();
		assertProjectEdit.click();
		
		String ProjectName_Update = VDNUtils.set_Content_Name("AutoPU_");
		VO.getEnterProjectName().clear();
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName_Update);

		String ProjectDesc_Update = VDNUtils.set_Content_Name("AutoDU_");
		VO.getEnterProjectDesc().clear();
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc_Update);
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkUpdateBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkUpdateBtn());
		VDNUtils.waitForElementToBeVisible(VO.getAssertModify());
		Assert.assertTrue(VO.getAssertModify().isDisplayed());		
		home = VO.getAssertModify().getText();
		actual = " User is able to Update and delete the draft project";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("The project has been modified successfully.", homeText, expect, actual);
	}
	}
	
	public static void SourcingOrgAdminIsAbleToDeleteThePrpjectWithoutTargetCol(String ProjectName)
			throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "Sourcing org admin is able to edit and Modifify the Prpject Wihout Target Collection";
		String actual = " Sourcing org admin is unable to edit or Modifify the Prpject Wihout Target Collection";
		try {
		String s1 = "(//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])[3]";
		String s4 = "//following::span[@class='sb-dotmenu'][1]";
		Thread.sleep(10000);
		WebElement assertProjectEdit = driver.findElement(By.xpath(s1 + s2 + s3+s4));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", assertProjectEdit);
		assertProjectEdit.isDisplayed();
		assertProjectEdit.click();
		
		String s5 ="//following::a[text()='Delete '][1]";
		
		WebElement assertProjectDeleteBtn = driver.findElement(By.xpath(s1 + s2 + s3+s5));
		assertProjectDeleteBtn.isDisplayed();
		assertProjectDeleteBtn.click();
		
		VDNUtils.waitToBeClickableAndClick(VO.getConfirmDeletion());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertDeleteMsg());
		
		Assert.assertTrue(VO.getAssertDeleteMsg().isDisplayed());
		
		home = VO.getAssertDeleteMsg().getText();
		
		System.out.print(home);

		actual = " User is able to Update and delete the draft project";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("The project has been modified successfully.", homeText, expect, actual);
	}
	}
	
	public static void SourcingOrgAdminIsAbleToCloseThePrpjectWithoutTargetCol(String ProjectName)
			throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "Sourcing org admin is able to edit and Modifify the Prpject Wihout Target Collection";
		String actual = " Sourcing org admin is unable to edit or Modifify the Prpject Wihout Target Collection";
		try {
		String s1 = "(//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])[3]";
		String s4 = "//following::span[@class='sb-dotmenu'][1]";
		Thread.sleep(10000);
		WebElement assertProjectEdit = driver.findElement(By.xpath(s1 + s2 + s3+s4));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", assertProjectEdit);
		assertProjectEdit.isDisplayed();
		assertProjectEdit.click();
		
		String s5 ="//following::a[text()='Close '][1]";
		
		WebElement assertProjectCloseBtn = driver.findElement(By.xpath(s1 + s2 + s3+s5));
		assertProjectCloseBtn.isDisplayed();
		assertProjectCloseBtn.click();
		
		VDNUtils.waitToBeClickableAndClick(VO.getConfirmDeletion());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertClose());
		
		Assert.assertTrue(VO.getAssertClose().isDisplayed());
		
		home = VO.getAssertClose().getText();
		
		System.out.print(home);

		actual = " User is able to Update and delete the draft project";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("The project has been closed successfully.", homeText, expect, actual);
	}
	}
	
	public static String createProjectWithoutTargetCollectionAndSave() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to Save The Project Successfully without Target Collection";
		String actual = "Sourcing org admin is able to Save The Project Successfully without Target Collection";

		try {
			
		Thread.sleep(5000);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
		Thread.sleep(5000);

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
		Date.setTodayDate(driver, VO.getNominationEndDate());

		Thread.sleep(500);
		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);
		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
		Date.setTomorrowDate(driver, VO.getShortlistEndDate());

		Thread.sleep(500);
		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);


		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);		

		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getBtnSaveAsDraft());

		VDNUtils.waitToBeClickableAndClick(VO.getBtnSaveAsDraft());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectSaved());
		
		Assert.assertTrue(VO.getAssertProjectSaved().isDisplayed());

		
		//home = VO.getAssertProjectSaved().getText();
		
		home = VO.getAssertProjectSaved().getText();
		actual = "Sourcing org admin is able to Save The Project Successfully";
		

//		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
//
//		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
//
//		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
//		home = VO.getAssertProjectPublished().getText();
//		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Target Collection";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project saved as draft successfully!", homeText, expect, actual);
	}

	}
	
	public static void validateAssignedReviewerIsAbleApprove(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		String actual =  "Assigned Reviewer Is Unble is able to preview the uploaded content by contributor.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getClkReviewContentBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContentBtn());
			Thread.sleep(3000);
			

			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitForApproval());
			Thread.sleep(3000);

			
			Thread.sleep(2000);		
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPendingTOC());
			Assert.assertTrue(VO.getAssertApprovalPendingTOC().isDisplayed());
			String stausApprovalPending = VO.getAssertApprovalPendingTOC().getText();
			Assert.assertEquals(stausApprovalPending,"Approval Pending");			
			home = VO.getAssertApprovalPendingTOC().getText();
			System.out.print(home);
			
			actual = "Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	
	public static void validateSourceOrgReviewerIsAbleToPublishTheContentForTheDigitalTextbook(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " default contribution org reviewer is able to preview the uploaded content by contributor.";
		String actual =  "default contribution org reviewer is unable to preview the uploaded content by contributor.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
			VDNUtils.waitToBeClickableAndClick(VO.getClkPublish());
			
			Thread.sleep(3000);
			//VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			
			//Assert.assertTrue(VO.getAssertReviewPending().isDisplayed());
			
//			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnReview());
//			Assert.assertTrue(VO.getClkOpenBtnReview().isDisplayed());
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
//			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
//			
//			
//			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
//			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			//Assert.assertTrue(VO.getAssertSample().isDisplayed());
			
//			Assert.assertTrue(VO.getContentDetails().isDisplayed());
//			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitForApproval());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
//			Thread.sleep(3000);
//			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
//			
//			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPendingTOC());
//			Assert.assertTrue(VO.getAssertApprovalPendingTOC().isDisplayed());
//			String stausApprovalPending = VO.getAssertApprovalPendingTOC().getText();
//			Assert.assertEquals(stausApprovalPending,"Approval Pending");			
//			home = VO.getAssertApprovalPendingTOC().getText();
//			System.out.print(home);
			
			
			//VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertEditDetails());
//			Assert.assertTrue(VO.getAssertEditDetails().isDisplayed());
//			home = VO.getAssertEditDetails().getText();
//			actual = "default contribution org reviewer is able to preview the uploaded content by contributor.";
		} finally {
//			String homeText = home != null ? home : "N/A";
//			Listeners.customAssert("Edit details" ,homeText, expect, actual);
		}
	}
	
	public static void validatRejectedCountUnderTextBookAndYourOrganisation(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Assigned Reviewer is able to reject the content for the Project "+ProjectName;
		String actual = " Assigned Reviewer is able to reject the content for the Project "+ProjectName;;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
			Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
			Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
			
			
			String RejectedCount = VO.getAssertRejectedCount().getText();
			System.out.print(RejectedCount);
			
			int RejectedC=Integer.parseInt(RejectedCount); 
			
			String TotalCount = VO.getAssertTotalContCount().getText();
			System.out.print(TotalCount);
			
			int TotalC=Integer.parseInt(TotalCount);
			
			Assert.assertEquals(RejectedC,1);
			Assert.assertEquals(TotalC,1);
			
			home = VO.getAssertRejectedOnTOC().getText();
			actual = "Assigned Reviewer is able to reject the content for the Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Rejected:" ,homeText, expect, actual);
		}
	}
	
	public static String validateCreateNewProjectwithAllContentTypesWithCourse() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create From anyone along with the Tabs";
		String actual = "Sourcing org admin is unable to create From anyone along with the Tabs";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());
			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);
			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());
			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());
			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());
			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);
			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
			VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
			VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			Thread.sleep(10000);
			WebElement assertProjectOnMyProjects = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnMyProjects.isDisplayed();
			String s4 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement projectOpenbtn = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitToBeClickableAndClick(projectOpenbtn);
			Thread.sleep(10000);
			js.executeScript("window.scrollBy(0, 0)");
			Thread.sleep(2000);
			Assert.assertTrue(VO.getAssertNominations().isDisplayed());
			Assert.assertTrue(VO.getAssertAssignUsers().isDisplayed());
			Assert.assertTrue(VO.getAssertContribution().isDisplayed());
			Assert.assertTrue(VO.getAssertReport().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominations());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertContribution());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReport());
			home = VO.getAssertContribution().getText();
			actual = "Sourcing org admin is able to create From anyone along with the Tabs";
			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
		}

}
	
	public static void openAndNominateWithUpload(String ProjectName) throws Exception {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = ProjectName + " Nomination is sent Successfully";
		String actual = ProjectName + " Nomination is not sent Successfully";
		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
		VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
		Thread.sleep(5000);
		Thread.sleep(5000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getUploadSampleBtn());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());
		
		
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
		home=VO.getAssertNominationSent().getText();
		actual = ProjectName + " Nomination is sent Successfully";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Nomination sent", homeText, expect, actual);
	}

}
	
	public static void verifySourcingOrgAdminIsAbleToToViewTheSamples(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "sourcing org admin is able to view the samples uploaded by the users.";
		String actual = "sourcing org admin is unable to view the samples uploaded by the users.";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
		
			
			Assert.assertTrue(VO.getViewSampleBtn().isDisplayed());
//			VDNUtils.waitToBeClickableAndClick(VO.getViewSampleBtn());
			
			String SampleCount = VO.getAssertSampleCount1().getText();
			System.out.print(SampleCount);
			
			int SampleC=Integer.parseInt(SampleCount); 
			Assert.assertEquals(SampleC, 1);
			
			VDNUtils.waitToBeClickableAndClick(VO.getViewSampleBtn());
			Thread.sleep(3000);
			//button[contains(text(),'View Sample Content')]//preceding::td[1]
			Assert.assertTrue(VO.getSelectSample1().isDisplayed());
			home = VO.getSelectSample1().getText();
			actual = "sourcing org admin is able to view the samples uploaded by the users ";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Sample1", homeText, expect, actual);
		}

}
	
	public static void CloseEditDetailAnduploadContent()
			throws Exception {
		String ReviewPending = null;
		//String expect = "Assigned Contributor Org is able to upload Content For Project "+ProjectName;
		//String actual =  "Assigned Contributor Org is unable to upload Content For Project "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
//			String s1 = "//div[text()=' ";
//			String s2 = ProjectName;
//			String s3 = " ']//following::button[text()='Open '][1]";
//			
//			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
//			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
//			assertProjectOnContributor.isDisplayed();
//			assertProjectOnContributor.click();

//			Assert.assertTrue(VO.getClkUploadContent().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getCloseEditDetail());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadfromBothRole());
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			VDNUtils.waitForElementToBeVisible(VO.getAssertRevPending2());
			Assert.assertTrue(VO.getAssertRevPending2().isDisplayed());
			
			ReviewPending = VO.getAssertRevPending2().getText();
			//actual = "Assigned Contributor Org is able to upload Content For Project "+ProjectName;
		} finally {
			String homeText = ReviewPending != null ? ReviewPending : "N/A";
//			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
		}
	}
	
	public static void UserWithBothRoleIsUnableToReviewHisOwnContent()
			throws Exception {
		String ReviewPending = null;
		String expect = "User should not be allowed to review his own content ";
		String actual =  "User is allowed to review his own content ";

		try {
		
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			
			VDNUtils.waitForElementToBeVisible(VO.getOpenOwnContent());
			VDNUtils.waitToBeClickableAndClick(VO.getOpenOwnContent());
			
			Thread.sleep(3000);
			String tabDetails = VO.getAssertAllReviewContentHead().getText();
			
			String[] lines = tabDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Submit for Approval");
			    Assert.assertNotEquals(line,"Request changes");
			}
			
			ReviewPending = VO.getAssertReviewPending().getText();
			
			
			actual = "User is not allowed to review his own content ";
		} finally {
			String homeText = ReviewPending != null ? ReviewPending : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
		}
	}
	
	public static String createProjectCourseWithoutTargetCollection() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully without Target Collection";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully without Target Collection";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
		Date.setTodayDate(driver, VO.getNominationEndDate());

		Thread.sleep(500);
		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);
		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
		Date.setTomorrowDate(driver, VO.getShortlistEndDate());

		Thread.sleep(500);
		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);


		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);		

		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		

		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Target Collection";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	public static void verifySourcingOrgAdminIsAbleToViewSampleRejectNominationWithoutTargetCollection(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = " sourcing org admin is able to view the sample and accept the nomination for "+ProjectName;
		String actual = " sourcing org admin is unable to view the sample and accept the nomination for "+ProjectName;

		try {
			
			
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);

			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());

			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenSample());
			Assert.assertTrue(VO.getAssertSample().isDisplayed());
			Assert.assertTrue(VO.getAssertSampleContentDetails().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getRejectSubmit());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			home = VO.getAssertNominationSuccess().getText();
			actual = ProjectName + " is Successfully Nominated for Reject";
//			Thread.sleep(3000);
//			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
//			home = VO.getAssertNominationSuccess().getText();
//			actual = " sourcing org admin is able to view the sample and accept the nomination for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination updated successfully...", homeText, expect, actual);
//			String homeText = home != null ? home : "N/A";
//			Listeners.customAssert("Nomination updated successfully...", homeText, expect, actual);
		}

	}
	
	public static String createProjectWithContentPlayList() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
			Date.setTodayDate(driver, VO.getNominationEndDate());

			Thread.sleep(500);
			Date.setTodayDate(driver);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
			Date.setTomorrowDate(driver, VO.getShortlistEndDate());

			Thread.sleep(500);
			Date.setTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
			Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());

			Thread.sleep(500);
			Date.setDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());			
			Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

			Thread.sleep(500);
			Date.setNextToDayAfterTomorrowDate(driver);
			Thread.sleep(1000);
			action.sendKeys("\b").perform();
			Thread.sleep(500);
			action.sendKeys("4").perform();
			Thread.sleep(500);

			VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());


			VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

			VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

			VDNUtils.waitToBeClickableAndClick(VO.getSelContentPlay());

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to Create and Publish The Project Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	
	public static void validateSourcingOrgAdminIsAbleToApproveTheContent(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated";
		String actual = ProjectName + " is not Successfully Nominated";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VO.getSelectSample1().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VO.getClkPublish().click();
			Thread.sleep(5000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovedTabs());
			Assert.assertTrue(VO.getAssertApprovedTabs().isDisplayed());
			
			String AppCount = VO.getApprovedTabCount().getText();
			System.out.print(AppCount);
			
			int AppC=Integer.parseInt(AppCount);
			
			VO.getSelectSample2().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
			Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
			
			String RejCount = VO.getAssertRejectedCount().getText();
			System.out.print(RejCount);
			
			int RejC=Integer.parseInt(RejCount); 
			VO.getSelectSample3().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
		
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentCorrection());
			Assert.assertTrue(VO.getAssertContentCorrection().isDisplayed());
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getCorrectionsPenTOC());
			Assert.assertTrue(VO.getCorrectionsPenTOC().isDisplayed());
			
			String CorCount = VO.getCorrectionsPenCount().getText();
			System.out.print(CorCount);
			
			int CorC=Integer.parseInt(CorCount); 
			VDNUtils.waitForElementToBeVisible(VO.getApprovalPenNode());
			Assert.assertTrue(VO.getApprovalPenNode().isDisplayed());
			
			String AppPenC = VO.getApprovalPenCount().getText();
			System.out.print(AppPenC);
			
			int PenC=Integer.parseInt(AppPenC);
			int Tot = AppC+RejC+CorC+PenC;
			System.out.println(Tot);
			
			Assert.assertTrue(VO.getTotalNode().isDisplayed());
			String TotCount = VO.getTotalCount().getText();
			int TotalC=Integer.parseInt(TotCount);
			
			System.out.println(TotCount);
			Assert.assertEquals(Tot,TotalC);				
			
			home = VO.getAssertApprovedContent().getText();
			actual = "Sourcing org admin is able to Approve the content for The Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approved", homeText, expect, actual);
		}
}
	
	public static void validateSourcingOrgAdminIsAbleToRejectTheContent(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated";
		String actual = ProjectName + " is not Successfully Nominated";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VO.getSelectSample1().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VO.getClkPublish().click();
			Thread.sleep(5000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovedTabs());
			Assert.assertTrue(VO.getAssertApprovedTabs().isDisplayed());
			
			String AppCount = VO.getApprovedTabCount().getText();
			System.out.print(AppCount);
			
			int AppC=Integer.parseInt(AppCount);
			
			VO.getSelectSample2().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
			Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
			
			String RejCount = VO.getAssertRejectedCount().getText();
			System.out.print(RejCount);
			
			int RejC=Integer.parseInt(RejCount); 
			VO.getSelectSample3().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
		
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentCorrection());
			Assert.assertTrue(VO.getAssertContentCorrection().isDisplayed());
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getCorrectionsPenTOC());
			Assert.assertTrue(VO.getCorrectionsPenTOC().isDisplayed());
			
			String CorCount = VO.getCorrectionsPenCount().getText();
			System.out.print(CorCount);
			
			int CorC=Integer.parseInt(CorCount); 
			VDNUtils.waitForElementToBeVisible(VO.getApprovalPenNode());
			Assert.assertTrue(VO.getApprovalPenNode().isDisplayed());
			
			String AppPenC = VO.getApprovalPenCount().getText();
			System.out.print(AppPenC);
			
			int PenC=Integer.parseInt(AppPenC);
			int Tot = AppC+RejC+CorC+PenC;
			System.out.println(Tot);
			
			Assert.assertTrue(VO.getTotalNode().isDisplayed());
			String TotCount = VO.getTotalCount().getText();
			int TotalC=Integer.parseInt(TotCount);
			
			System.out.println(TotCount);
			Assert.assertEquals(Tot,TotalC);				
			
			home = VO.getAssertRejectedOnTOC().getText();
			actual = "Sourcing org admin is able to Reject the content for The Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Rejected:", homeText, expect, actual);
		}
}
	
	public static void uploadContentFromAssignedContributorWithoutTargetColl(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Content should be available on the TOC with Approval Pending status for "+ProjectName+" and is Displayed on the Top";
		String actual =  "Content is not available on the TOC with Approval Pending status for "+ProjectName+" or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadContent().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadContent());
			Thread.sleep(2000);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			Thread.sleep(5000);
			//VO.getSelectSample1().click();
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			home = VO.getAssertApprovalPending().getText();
			actual = "sourcing org admin is able to create nomination disabled without target and skip review enabled for project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static void verifySourcingOrgAdminIsAbleToApproveTheContentFromWithoutTargetCollectionProject(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = ProjectName + " is Successfully Nominated";
		String actual = ProjectName + " is not Successfully Nominated";
		try {
//			String s1 = "//div[text()=' ";
//			String s2 = ProjectName;
//			String s3 = " ']//following::button[text()='Open '][1]";
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			//VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtn());
			VO.getClkOpenBtnOnNoTC().click();
			Thread.sleep(5000);

//			VO.getSelectSample1().click();
//			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			//VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
			
			VO.getClkPublish().click();
			Thread.sleep(5000);
			
//			VO.getSelectSample1().click();
//			Thread.sleep(2000);
//			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovedNoTC());
			Assert.assertTrue(VO.getAssertApprovedNoTC().isDisplayed());
			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
//			String AppCount = VO.getApprovedTabCount().getText();
//			System.out.print(AppCount);
//			
//			int AppC=Integer.parseInt(AppCount); 
			
			
			//getAssertApprovedTabs
			
			
			
			
			
			
			
			
//			VO.getSelectSample2().click();
//			Thread.sleep(5000);
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
//			
			
			
			
			
//			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
//			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
//			
//			Thread.sleep(3000);
//			
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
//			Thread.sleep(3000);
//			
//			VO.getSelectSample1().click();
//			Thread.sleep(2000);
//			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
//			Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
//			
//			String RejCount = VO.getAssertRejectedCount().getText();
//			System.out.print(RejCount);
//			
//			int RejC=Integer.parseInt(RejCount); 
//			
//			
//			
//			
//			VO.getSelectSample3().click();
//			Thread.sleep(5000);
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
//			
//			
//			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
//			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
//			
//			Thread.sleep(3000);
//			
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
//			Thread.sleep(3000);
//		
//			VDNUtils.waitForElementToBeVisible(VO.getAssertContentCorrection());
//			Assert.assertTrue(VO.getAssertContentCorrection().isDisplayed());
//			
//			VO.getSelectSample1().click();
//			Thread.sleep(2000);
//			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitForElementToBeVisible(VO.getCorrectionsPenTOC());
//			Assert.assertTrue(VO.getCorrectionsPenTOC().isDisplayed());
//			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
//			
//			String CorCount = VO.getCorrectionsPenCount().getText();
//			System.out.print(CorCount);
//			
//			int CorC=Integer.parseInt(CorCount); 
//			
//			
//			VDNUtils.waitForElementToBeVisible(VO.getApprovalPenNode());
//			Assert.assertTrue(VO.getApprovalPenNode().isDisplayed());
//			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
//			
//			String AppPenC = VO.getApprovalPenCount().getText();
//			System.out.print(AppPenC);
//			
//			int PenC=Integer.parseInt(AppPenC);
//			
//			
//			
//			int Tot = AppC+RejC+CorC+PenC;
//			System.out.println(Tot);
//			
//			
//			Assert.assertTrue(VO.getTotalNode().isDisplayed());
//			
//			String TotCount = VO.getTotalCount().getText();
//			int TotalC=Integer.parseInt(TotCount);
//			
//			System.out.println(TotCount);
//			Assert.assertEquals(Tot,TotalC);
			
			
			
			//*******************************
			//VDNUtils.waitForElementToBeVisible(VO.getBackBtn());
			
			//*******************************
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getBackBtn());
//			VO.getBackBtn().click();
//			Thread.sleep(10000);
//			
//			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
//			String TotalCount1 = VO.getAssertTotalTab1().getText();
//			System.out.println(TotalCount1);
//			
//			
//			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
//			String APCount1 = VO.getAssertApprovalPendingTab().getText();
//			System.out.println(APCount1);
//			
//			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
//			String ApprovedCount1 = VO.getAssertApprovedTab().getText();
//			System.out.println(ApprovedCount1);
//			
//			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
//			String RejectedCount1 = VO.getAssertRejectedTab().getText();
//			System.out.println(RejectedCount1);
//			
//			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
//			String CorrectioCountCount1 = VO.getAssertCorrectionTab().getText();
//			System.out.println(CorrectioCountCount1);
			
			//************************
			
			
//			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
//			VDNUtils.waitToBeClickableAndClick(VO.getBtnAccept());
//			Thread.sleep(3000);
//			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			home = VO.getAssertApprovedNoTC().getText();
			actual = ProjectName + " is Successfully Nominated";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approved", homeText, expect, actual);
		}

}
	
	public static void verifySourcingOrgAdminIsAbleToRejectTheContentFromWithoutTargetCollectionProject(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "sourcing org admin is able to Reject the content for The Project "+ProjectName;
		String actual = "sourcing org admin is unable to Reject the content for The Project "+ProjectName;
		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			VO.getClkOpenBtnOnNoTC().click();
			Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			
			Thread.sleep(3000);
		
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);			
			
			VDNUtils.waitForElementToBeVisible(VO.getassertRejectNoTC());
			Assert.assertTrue(VO.getassertRejectNoTC().isDisplayed());
			
			
			home = VO.getassertRejectNoTC().getText();
			actual = "sourcing org admin is able to Reject the content for The Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Rejected", homeText, expect, actual);
		}

}
	public static void verifySourcingOrgAdminIsAbleToSendBackToCorrectionTheContentFromWithoutTargetCollectionProject(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "sourcing org admin is able to send back to correction the content for The Project "+ProjectName;
		String actual = "sourcing org admin is unable to send back to correction the content for The Project "+ProjectName;
		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			VO.getClkOpenBtnOnNoTC().click();
			Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());	
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
	
		
			VDNUtils.waitForElementToBeVisible(VO.getassertCorrPenNoTC());
			Assert.assertTrue(VO.getassertCorrPenNoTC().isDisplayed());
			
			
			home = VO.getassertCorrPenNoTC().getText();
			actual = "sourcing org admin is able to send back to correction the content for The Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Corrections pending", homeText, expect, actual);
		}

}
	public static void validateSourcingOrgAdminIsAbleToSendBackToTheCorrectionTheContent(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Sourcing org admin is able to Send Back To Correction the content for The Project "+ProjectName;
		String actual = "Sourcing org admin is unable to Send Back To Correction the content for The Project "+ProjectName;
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
			String TotalCount = VO.getAssertTotalTab1().getText();
			System.out.print(TotalCount);
			
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
			String APCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(APCount);
			
			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
			System.out.print(ApprovedCount);
			
			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
			String RejectedCount = VO.getAssertRejectedTab().getText();
			System.out.print(RejectedCount);
			
			Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
			String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
			System.out.print(CorrectioCountCount);
			
			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VO.getSelectSample1().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VO.getClkPublish().click();
			Thread.sleep(5000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovedTabs());
			Assert.assertTrue(VO.getAssertApprovedTabs().isDisplayed());
			
			String AppCount = VO.getApprovedTabCount().getText();
			System.out.print(AppCount);
			
			int AppC=Integer.parseInt(AppCount);
			
			VO.getSelectSample2().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
			Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
			
			String RejCount = VO.getAssertRejectedCount().getText();
			System.out.print(RejCount);
			
			int RejC=Integer.parseInt(RejCount); 
			VO.getSelectSample3().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
		
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentCorrection());
			Assert.assertTrue(VO.getAssertContentCorrection().isDisplayed());
			
			VO.getSelectSample1().click();
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getCorrectionsPenTOC());
			Assert.assertTrue(VO.getCorrectionsPenTOC().isDisplayed());
			
			String CorCount = VO.getCorrectionsPenCount().getText();
			System.out.print(CorCount);
			
			int CorC=Integer.parseInt(CorCount); 
			VDNUtils.waitForElementToBeVisible(VO.getApprovalPenNode());
			Assert.assertTrue(VO.getApprovalPenNode().isDisplayed());
			
			String AppPenC = VO.getApprovalPenCount().getText();
			System.out.print(AppPenC);
			
			int PenC=Integer.parseInt(AppPenC);
			int Tot = AppC+RejC+CorC+PenC;
			System.out.println(Tot);
			
			Assert.assertTrue(VO.getTotalNode().isDisplayed());
			String TotCount = VO.getTotalCount().getText();
			int TotalC=Integer.parseInt(TotCount);
			
			System.out.println(TotCount);
			Assert.assertEquals(Tot,TotalC);				
			
			home = VO.getCorrectionsPenTOC().getText();
			actual = "Sourcing org admin is able to Send Back To Correction the content for The Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Corrections pending:", homeText, expect, actual);
		}
}
	
	public static String validateErrorOnUploadingOtherThanPDF() throws Exception {

		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
			
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
		Date.setTodayDate(driver, VO.getNominationEndDate());

		Thread.sleep(500);
		Date.setTodayDate(driver);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
		Date.setTomorrowDate(driver, VO.getShortlistEndDate());
		Thread.sleep(500);
		Date.setTomorrowDate(driver);
		Thread.sleep(1000);
		
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);

		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());

		Thread.sleep(500);
		Date.setNextToDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		action.sendKeys("\b").perform();
		Thread.sleep(500);
		action.sendKeys("4").perform();
		Thread.sleep(500);
		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadMP4();
		String a =driver.switchTo().alert().getText();

		//Alert 
		System.out.print(a);
		a.equalsIgnoreCase("Invalid content type (supported type: pdf)");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
//		driver.switchTo().defaultContent();
//		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
//		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
//		home = VO.getAssertProjectPublished().getText();
//		actual = "Sourcing org admin is able to Create and Publish The Project Successfully";
		return ProjectName;
	} finally {
//		String homeText = home != null ? home : "N/A";
//		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}
}
	
	public static void uploadTheContentFromContOrgContributorSaveAsDraftAndSendForReviewWithoutTC(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Contributor should be able to save the content draft status and Review Pending Staus for Project  "+ProjectName;
		String actual =  "Contributor is unable to save the content draft status or Review Pending Staus for Project "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkCreateOrUploadBtn().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
//			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getContentSavedtMessage());
			Assert.assertTrue(VO.getContentSavedtMessage().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertSaveAsDraftNoTC());
			Assert.assertTrue(VO.getAssertSaveAsDraftNoTC().isDisplayed());
			String stausDraft = VO.getAssertSaveAsDraftNoTC().getText();
			Assert.assertEquals(stausDraft,"Draft");			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			String stausReviewPending = VO.getAssertReviewPending().getText();
			Assert.assertEquals(stausReviewPending,"Review Pending");
			
			
//			Assert.assertTrue(VO.getAssertDraftNode().isDisplayed());
//			
//			String DraftCount = VO.getAssertDraftCount().getText();
//			System.out.println(DraftCount);
//			int DraftC=Integer.parseInt(DraftCount);  
			
//            Assert.assertTrue(VO.getReviewPendingNode().isDisplayed());
//			
//			String ReviewPendingCount = VO.getAssertReviewPendingCount().getText();
//			
//			System.out.println(ReviewPendingCount);
//			int ReviewPendingC=Integer.parseInt(DraftCount); 
			
//			int Total = DraftC+ReviewPendingC;
//			System.out.println(Total);
			
//			Assert.assertTrue(VO.getTotalNode().isDisplayed());
//			
//			String TotalCount = VO.getTotalCount().getText();
//			int TotalC=Integer.parseInt(TotalCount);
//			
//			System.out.println(TotalCount);
//			Assert.assertEquals(Total,TotalC);
			home = VO.getAssertReviewPending().getText();
			
			
			actual = "Content available on the TOC with draft status for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	public static void validateAssignedReviewerIsAbleApproveNoTC(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		String actual =  "Assigned Reviewer Is Unble is able to preview the uploaded content by contributor.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnNoRC());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
			Thread.sleep(3000);
			

//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitForApproval());
			Thread.sleep(3000);

			
//			Thread.sleep(2000);		
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			Assert.assertTrue(VO.getAssertApprovalPending().isDisplayed());
			String stausApprovalPending = VO.getAssertApprovalPending().getText();
			Assert.assertEquals(stausApprovalPending,"Approval Pending");			
			home = VO.getAssertApprovalPending().getText();
			System.out.print(home);
			
			actual = "Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	public static void uploadTheContentFromContOrgContributorAndSendForReviewWithoutTC(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Contributor should be able to save the content draft status and Review Pending Staus for Project  "+ProjectName;
		String actual =  "Contributor is unable to save the content draft status or Review Pending Staus for Project "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkCreateOrUploadBtn().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getContentSavedtMessage());
			Assert.assertTrue(VO.getContentSavedtMessage().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertSaveAsDraftNoTC());
			Assert.assertTrue(VO.getAssertSaveAsDraftNoTC().isDisplayed());
			String stausDraft = VO.getAssertSaveAsDraftNoTC().getText();
			Assert.assertEquals(stausDraft,"Draft");			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			String stausReviewPending = VO.getAssertReviewPending().getText();
			Assert.assertEquals(stausReviewPending,"Review Pending");
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			String stausReviewPending2 = VO.getAssertReviewPending().getText();
			Assert.assertEquals(stausReviewPending2,"Review Pending");
			
			
			actual = "Content available on the TOC with draft status for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	public static void validateAssignedReviewerIsAbleApproveReqChangesNoTC(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Assigned Reviewer Is Able is able to preview, Approve and Request Changes the uploaded content by contributor.";
		String actual =  "Assigned Reviewer Is Unble is able to preview, Approve and Request Changes the uploaded content by contributor.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnNoRC());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
			Thread.sleep(3000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitForApproval());
			Thread.sleep(3000);

			
//			Thread.sleep(2000);		
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			Assert.assertTrue(VO.getAssertApprovalPending().isDisplayed());
			String stausApprovalPending = VO.getAssertApprovalPending().getText();
			Assert.assertEquals(stausApprovalPending,"Approval Pending");			
			home = VO.getAssertApprovalPending().getText();
			System.out.print(home);
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnNoRC());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getClkRequestChanges());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Request");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertNotAcceptedOnRC());
			Assert.assertTrue(VO.getAssertNotAcceptedOnRC().isDisplayed());
			String stausNotAcceptedOnRC = VO.getAssertNotAcceptedOnRC().getText();
			Assert.assertEquals(stausNotAcceptedOnRC,"Not Accepted");	
			
			actual = "Assigned Reviewer Is Able is able to preview, Approve and Request Changes the uploaded content by contributor.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static void uploadTheContentFromContOrgContributorAndSendForReview(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Contributor should be able to save the content draft status and Review Pending Staus for Project  "+ProjectName;
		String actual =  "Contributor is unable to save the content draft status or Review Pending Staus for Project "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			Assert.assertTrue(VO.getClkUploadbtn().isDisplayed());

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getContentSavedtMessage());
			Assert.assertTrue(VO.getContentSavedtMessage().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertDraft());
			Assert.assertTrue(VO.getAssertDraft().isDisplayed());
			String stausDraft = VO.getAssertDraft().getText();
			Assert.assertEquals(stausDraft,"Draft");			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			String stausReviewPending = VO.getAssertReviewPending().getText();
			Assert.assertEquals(stausReviewPending,"Review Pending");
			
			
			Assert.assertTrue(VO.getAssertDraftNode().isDisplayed());
			
			String DraftCount = VO.getAssertDraftCount().getText();
			System.out.println(DraftCount);
			int DraftC=Integer.parseInt(DraftCount);  
			
            Assert.assertTrue(VO.getReviewPendingNode().isDisplayed());
			
			String ReviewPendingCount = VO.getAssertReviewPendingCount().getText();
			
			System.out.println(ReviewPendingCount);
			int ReviewPendingC=Integer.parseInt(DraftCount); 
			
			int Total = DraftC+ReviewPendingC;
			System.out.println(Total);
			
			Assert.assertTrue(VO.getTotalNode().isDisplayed());
			
			String TotalCount = VO.getTotalCount().getText();
			int TotalC=Integer.parseInt(TotalCount);
			
			System.out.println(TotalCount);
			Assert.assertEquals(Total,TotalC);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
//			String stausReviewPending = VO.getAssertReviewPending().getText();
//			Assert.assertEquals(stausReviewPending,"Review Pending");
			
			
			actual = "Content available on the TOC with draft status for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	public static void validateAssignedReviewerIsAbleApproveOrRequestChanges(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		String actual =  "Assigned Reviewer Is Unble is able to preview the uploaded content by contributor.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getClkUploadfromBothRole());
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadfromBothRole());
			Thread.sleep(3000);
			

			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitForApproval());
			Thread.sleep(3000);

			
			Thread.sleep(2000);		
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPendingTOC());
			Assert.assertTrue(VO.getAssertApprovalPendingTOC().isDisplayed());
			String stausApprovalPending = VO.getAssertApprovalPendingTOC().getText();
			Assert.assertEquals(stausApprovalPending,"Approval Pending");			
			home = VO.getAssertApprovalPendingTOC().getText();
			System.out.print(home);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkRequestChanges());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Request");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertNotAcceptedOnRC());
			Assert.assertTrue(VO.getAssertNotAcceptedOnRC().isDisplayed());
			String stausNotAcceptedOnRC = VO.getAssertNotAcceptedOnRC().getText();
			Assert.assertEquals(stausNotAcceptedOnRC,"Not Accepted");	

			
//			Thread.sleep(2000);		
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
			actual = "Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static void validateAssignedReviewerIsAbleRequestChangesNoTC(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		String actual =  "Assigned Reviewer Is Unble is able to preview the uploaded content by contributor.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnNoRC());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
			Thread.sleep(3000);
			

//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkRequestChanges());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Request");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertNotAcceptedOnRC());
			Assert.assertTrue(VO.getAssertNotAcceptedOnRC().isDisplayed());
			String stausNotAcceptedOnRC = VO.getAssertNotAcceptedOnRC().getText();
			Assert.assertEquals(stausNotAcceptedOnRC,"Not Accepted");
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitForApproval());
//			Thread.sleep(3000);

			
//			Thread.sleep(2000);		
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
//			Assert.assertTrue(VO.getAssertApprovalPending().isDisplayed());
//			String stausApprovalPending = VO.getAssertApprovalPending().getText();
//			Assert.assertEquals(stausApprovalPending,"Approval Pending");			
			home = VO.getAssertNotAcceptedOnRC().getText();
			System.out.print(home);
			
			actual = "Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Not Accepted" ,homeText, expect, actual);
		}
	}
}
