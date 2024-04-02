package pageActions;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

import freemarker.core.ReturnInstruction.Return;

import org.openqa.selenium.interactions.Actions;

import io.reactivex.rxjava3.functions.Action;
import pageObject.CourseAssesment;
import pageObject.HomePage;
import pageObject.ResourcesPom;
import pageObject.UploadPdfContent;
import pageObject.VDNContributor;
import pageObject.VDNObj;
import utility.BaseClass;
import utility.Listeners;
import utility.VDNUtils;
import pageObject.VDNSourcing;

public class VDNContributorMethods extends BaseClass {

	
	
	public static void ContributorIsAbleToNominateProjectWithoutUploadingSample(String ProjectName) throws InterruptedException {
		//HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "contributor should be able to nominate to the framework project without uploading sample";
		String actual = "contributor is unable to nominate to the framework project without uploading sample";
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
		actual = "contributor is able to nominate to the framework project without uploading sample";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Nomination sent", homeText, expect, actual);
	}

	
	}
	
	public static void verifyIndividualContributorAbleToViewTheProjectDetails() throws InterruptedException {
		
		String text = "N/A";
		String expect = "Individual contributor able to view project details";
		String actual = "Individual contributor not able to view project details";
		try {
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VC.getMyProjectTab());
			VDNUtils.waitToBeClickableAndClick(VC.getOpenBtn());
			Assert.assertTrue(VC.getPojectDetails().isDisplayed());
			Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
			Assert.assertTrue(VS.getProjectDates().isDisplayed());
			text = "Completed";
			actual = "Individual contributor is able to view project details successfully";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}

	}
	
		public static void verifyIndividualContributorIsAbleToModifyTheNomination(String ProjectName) throws InterruptedException {
			
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String home = null;
			String expect = "Individual Contributor should be able to modify Nomination";
			String actual = "Individual Contributor not able to modify Nomination";
			try {
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::span[text()='Modify'][1]";
			Thread.sleep(10000);
			WebElement clkModify = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkModify);
			VDNUtils.waitToBeClickableAndClick(VC.getModifyNominationYesBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
			Thread.sleep(5000);
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home=VO.getAssertNominationSent().getText();
			actual = "Individual Contributor is able to modify Nomination successfully";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Nomination sent", homeText, expect, actual);
		}
	
	}
public static void verifyModifyOptionNotAvailable(String ProjectName) throws InterruptedException {
			
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String text = "N/A";
			String expect = "Modify option should not be prensent post approving and rejecting the nomination";
			String actual = "Modify option is prensent post approving and rejecting the nomination";
			try {
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VC.getMyProjectTab());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::span[text()='Modify'][1]";
			Thread.sleep(1000);
			try {
				WebElement clkModify = driver.findElement(By.xpath(s1 + s2 + s3));
			}catch(NoSuchElementException e) {
				System.out.println("Modify option not present");
			}
			text = "Completed";
			actual = "Modify option is not prensent post approving and rejecting the nomination";
		} finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	
	}

	public static void verifyIndividualContributorCanSubmitNominationAndStatusPending(String ProjectName) throws InterruptedException {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String text = "N/A";
		String expect = "Nomination status should be pending post submiting nomination";
		String actual = "Nomination status is not pending post submiting nomination";
		try {
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::span[text()='Pending'][1]";
		Thread.sleep(10000);
		WebElement pending = driver.findElement(By.xpath(s1 + s2 + s3));
		Assert.assertTrue(pending.isDisplayed());
		text = "Completed";
		actual = "Nomination status is pending post submiting nomination successfully";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}
	
	}
	
public static void verifyProjectIsNotAvailableInMyProjectsAfterSavedTheContentType(String ProjectName) throws InterruptedException {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String text = "N/A";
		String expect = "Project should not be available in my project after saved the content type";
		String actual = "Project should is available in my project after saved the content type";
		try {
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
		VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
		VDNUtils.waitToBeClickableAndClick(VC.getMyProjectTab());
		String s4 = "//div[text()=' ";
		String s5 = ProjectName;
		String s6 = " ']";
		try {
		WebElement projectName = driver.findElement(By.xpath(s4 + s5 + s6));
		}catch(NoSuchElementException e) {
			System.out.println("Project not present");
		}
		text = "Completed";
		actual = "Project is not be available in my project after saved the content type";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}
	
	}

	public static void totalSampleCountUploadedShouldBeDisplayedOnTheTOCPage(String ProjectName) throws Exception {
		
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String text = "N/A";
		String expect = ProjectName + " Nomination is sent Successfully";
		String actual = ProjectName + " Nomination is not sent Successfully";
		try {
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
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
		Assert.assertTrue(VC.getTotalContent().isDisplayed());
		text = "Completed";
		actual = "Project is not be available in my project after saved the content type";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}
	
	}
}

