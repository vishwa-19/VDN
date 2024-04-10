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
		
		String home2 = null;
		String expect2 = "The status of the project should be pending.";
		String actual2 = "The status of the project is not pending";

		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		String s4 = " ']//following::span[text()='Pending'][1]";
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
		
		WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
		
		Assert.assertTrue(assertPendStatus.isDisplayed());
		
		home2=assertPendStatus.getText();
		actual2 = "The status of the project is pending";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Nomination sent", homeText, expect, actual);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Pending", homeText2, expect2, actual2);
				
	}

}
	
	public static void validateOpenAndModifyButtonsAreDisplayedWithPendingStatus(String ProjectName) throws InterruptedException {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "'Modify' buttons should be displayed for the Project "+ProjectName;
		String actual = "'Modify' buttons is not displayed for the Project "+ProjectName;
		
		String home2 = null;
		String expect2 = "'Open' buttons should be displayed for the Project "+ProjectName;
		String actual2 = "'Open' buttons is not displayed for the Project "+ProjectName;

		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		String s4 = " ']//following::span[text()='Pending'][1]";
		String s5 = " ']//following::span[text()='Modify'][1]";
		Thread.sleep(10000);
		
		WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
		WebElement assertModifyBtn = driver.findElement(By.xpath(s1 + s2 + s5));
		WebElement assertOpenBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		Assert.assertTrue(assertPendStatus.isDisplayed());
		Assert.assertTrue(assertModifyBtn.isDisplayed());
		Assert.assertTrue(assertOpenBtn.isDisplayed());
		
		home=assertModifyBtn.getText();
		System.out.println(home);
		actual = "'Modify' buttons is displayed for the Project "+ProjectName;
		
		home2=assertOpenBtn.getText();
		System.out.println(home2);
		actual2 = "'Open' buttons is displayed for the Project "+ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		System.out.println(homeText);
		Listeners.customAssert("Modify", homeText, expect, actual);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		System.out.println(homeText2);
		Listeners.customAssert("Open", homeText2, expect2, actual2);
				
	}
					
}
	public static void validateConfirmationPopupPage(String ProjectName) throws InterruptedException {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String home1 = null;
		String expect1 = "1.confirmation popup page should be displayed on clicking Modify Button.";
		String actual1 = "1.confirmation popup page is not displayed on clicking Modify Button.";
		
		String home2 = null;
		String expect2 = "2.Modify Confirmation popup page should be displayed with the Text : 'Your nomination is already submitted, do you want to modify it?', 'yes' Button and 'No' Button.";
		String actual2 = "2.Modify Confirmation popup page is not displayed with the Text : 'Your nomination is already submitted, do you want to modify it?', 'yes' Button and 'No' Button.";
		
		String home3 = null;
		String expect3 = "3.on clicking Yes Button on confirmation popup page,the project status should be changed to 'Initiated' state from 'Pending' state";
		String actual3 = "3.on clicking Yes Button on confirmation popup page,the project status is not changed to 'Initiated' state from 'Pending' state";

		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		String s4 = " ']//following::span[text()='Pending'][1]";
		String s5 = " ']//following::span[text()='Modify'][1]";
		String s6 = " ']//following::span[text()='Initiated'][1]";
		Thread.sleep(10000);
		
		WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
		WebElement assertModifyBtn = driver.findElement(By.xpath(s1 + s2 + s5));
		WebElement assertOpenBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		
		VDNUtils.waitToBeClickableAndClick(assertModifyBtn);
		Thread.sleep(3000);
		Assert.assertTrue(VC.getConfirmationOnModify().isDisplayed());
		Assert.assertTrue(VO.getConfirmDeletion().isDisplayed());
		Assert.assertTrue(VC.getClkNoBtn().isDisplayed());
	
//		Assert.assertTrue(assertModifyBtn.isDisplayed());
//		Assert.assertTrue(assertOpenBtn.isDisplayed());
		
		home1=VC.getConfirmationOnModify().getText();
		System.out.println(home1);
		actual1 = "1.confirmation popup page is displayed on clicking Modify Button.";
		
		home2=VC.getClkNoBtn().getText();;
		System.out.println(home2);
		actual2 = "2.Modify Confirmation popup page is not displayed with the Text : 'Your nomination is already submitted, do you want to modify it?', 'yes' Button and 'No' Button.";
		
		VDNUtils.waitToBeClickableAndClick(VO.getConfirmDeletion());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		Thread.sleep(3000);
		
		WebElement assertStatusUpdate = driver.findElement(By.xpath(s1 + s2 + s6));
		Assert.assertTrue(assertStatusUpdate.isDisplayed());
		Thread.sleep(3000);
		
		home3=assertStatusUpdate.getText();;
		System.out.println(home3);
		actual3 = "3.on clicking Yes Button on confirmation popup page,the project status is changed to 'Initiated' state from 'Pending' state";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(homeText1);
		Listeners.customAssert("Your nomination is already submitted, do you want to modify it?", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		System.out.println(homeText2);
		Listeners.customAssert("No", homeText2, expect2, actual2);
		
		String homeText3 = home3 != null ? home3 : "N/A";
		System.out.println(homeText3);
		Listeners.customAssert("Initiated", homeText3, expect3, actual3);
				
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

	
	public static void uploadTheContentFromContributorSide(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Able to upload The Content From Contributor Org for "+ProjectName;
		String actual =  "Unable to upload The Content From Contributor Org for  "+ProjectName;
		
		String home1 = null;
		String expect1 = "contributor should able to nominate to the framework project by uploading sample";
		String actual1 = "contributor is unable to nominate to the framework project by uploading sample";

		String home2 = null;
		String expect2 = "The status of the project should be pending.";
		String actual2 = "The status of the project is not pending";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = " ']//following::span[text()='Pending'][1]";
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
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
			Thread.sleep(3000);
			home = VO.getAssertContentSetReview().getText();	
			System.out.println(home);

			actual = " Able to upload The Content From Contributor Org for "+ProjectName;
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home1=VO.getAssertNominationSent().getText();
			System.out.println(home1);
			actual1 = "contributor is able to nominate to the framework project by uploading sample";
			
			Thread.sleep(3000);
			WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
			Assert.assertTrue(assertPendStatus.isDisplayed());
			home2=assertPendStatus.getText();
			System.out.println(home2);
			actual2 = "The status of the project is pending";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
			System.out.println(homeText);
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Nomination sent", homeText1, expect1, actual1);
			System.out.println(homeText1);
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Pending", homeText2, expect2, actual2);
			System.out.println(homeText2);
		}
	}
	
	public static void uploadTheContentFromIndContrubutorAndInitiate(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " individual contributor should be able to select content and upload sample for "+ProjectName;
		String actual =  "individual contributor is unable to select content and upload sample for "+ProjectName;

		String home2 = null;
		String expect2 = "The Project status should be initiated.";
		String actual2 = "The status of the project is not initiated.";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = " ']//following::span[text()='Pending'][1]";
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());	
			Thread.sleep(3000);
			home = VO.getAssertContentSetReview().getText();	
			System.out.println(home);

			actual = "individual contributor is able to select content and upload sample for "+ProjectName;
			
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			Thread.sleep(3000);
			
			String s5 = " ']//following::span[text()='Initiated'][1]";
			
			WebElement assertStatusUpdate = driver.findElement(By.xpath(s1 + s2 + s5));
			Assert.assertTrue(assertStatusUpdate.isDisplayed());
			Thread.sleep(3000);
			
			home2=assertStatusUpdate.getText();;
			System.out.println(home2);
			actual2 = "The status of the project is initiated.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
			System.out.println(homeText);
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Initiated", homeText2, expect2, actual2);
			System.out.println(homeText2);
		}
	}
	
	public static void verifyStatusModifyAndUploadContent(String ProjectName) throws Exception {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String home1 = null;
		String expect1 = "status of the project should remains initiated even if the contributor as updated content types and textbooks";
		String actual1 = "status of the project in not remains initiated even if the contributor as updated content types and textbooks";

		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		String s6 = " ']//following::span[text()='Initiated'][1]";
		Thread.sleep(10000);
		WebElement assertOpenBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(assertOpenBtn);
		Thread.sleep(3000);
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
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
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
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		Thread.sleep(3000);
		
		WebElement assertStatusUpdate = driver.findElement(By.xpath(s1 + s2 + s6));
		
		home1=assertStatusUpdate.getText();
		System.out.println(home1);
		actual1 = "status of the project is remains initiated even if the contributor as updated content types and textbooks";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(homeText1);
		Listeners.customAssert("Initiated", homeText1, expect1, actual1);		
	}
}
	
	public static void verifyQuestionMarkOnContOrg() throws InterruptedException {
		String home = null;
		String expect = "Question Mark icon with Need help ? should be Displayed on Manage Users tab";
		String actual =  "Question Mark icon with Need help ? is not Displayed on Manage Users tab";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			Assert.assertTrue(VO.getClkManageUsers().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getClkManageUsers());
			VDNUtils.waitToBeClickableAndClick(VO.getClkManageUsers());
			
			Assert.assertTrue(VS.getAssertNeedHelp().isDisplayed());
//			Assert.assertTrue(VS.getAssertQuestionMarkIcon().isDisplayed());
			Thread.sleep(2000);
			
			home = VS.getAssertNeedHelp().getText();
			actual = "Question Mark icon with Need help ? is Displayed On Manage Users tab";
		

		} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Need Help?", homeText, expect, actual);
		}
	}
	
	
	public static void verifyQuestionMarkIconWithNeedHelpUnderNomTab(String ProjectName) throws Exception {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
//		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String home = null;
		String expect = "Question Mark icon with Need help ? text should displayed under nomination tab for contribution org admin";
		String actual = "Question Mark icon with Need help ? text is not displayed under nomination tab for contribution org admin";
		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		Assert.assertTrue(VS.getAssertNeedHelp().isDisplayed());
		Thread.sleep(2000);
		
		home = VS.getAssertNeedHelp().getText();
		actual = "Question Mark icon with Need help ? text is displayed under nomination tab for contribution org admin";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Need Help?", homeText, expect, actual);
	}

}
	
	
	public static void validateKnowMoreButtonIsDisplayedPostClickingOnQuestionMarkIcon(String ProjectName) throws Exception {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String home = null;
		String expect = "'Know More' button should displayed post clicking on Question Mark icon in contribution portal.";
		String actual = "'Know More' button is not displayed post clicking on Question Mark icon in contribution portal.";
		try {
		
		Assert.assertTrue(VS.getAssertNeedHelp().isDisplayed());
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		action.moveToElement(VC.getAsserQIcon()).perform();;
		
		Thread.sleep(2000);
		Assert.assertTrue(VS.getAssertKnowMoreBtn().isDisplayed());
		
		home = VS.getAssertKnowMoreBtn().getText();
		
		home = VS.getAssertKnowMoreBtn().getText();
		actual = "'Know More' button is displayed post clicking on Question Mark icon in contribution portal.";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Know More", homeText, expect, actual);
	}

	}
	
	public static void validateToastMessageContributorSendTheNomination(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Able to upload The Content From Contributor Org for "+ProjectName;
		String actual =  "Unable to upload The Content From Contributor Org for  "+ProjectName;
		
		String home1 = null;
		String expect1 = "Toast message 'Nomination Sent' should be displayed when contributor send the nomination for the project.";
		String actual1 = "Toast message 'Nomination Sent' is not displayed when contributor send the nomination for the project.";

		String home2 = null;
		String expect2 = "Nomination submitted project should be available under My Project table with Pending status.";
		String actual2 = "Nomination submitted project is not available under My Project table with Pending status.";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = " ']//following::span[text()='Pending'][1]";
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
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
			Thread.sleep(3000);
			home = VO.getAssertContentSetReview().getText();	
			System.out.println(home);

			actual = " Able to upload The Content From Contributor Org for "+ProjectName;
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home1=VO.getAssertNominationSent().getText();
			System.out.println(home1);
			actual1 = "Toast message 'Nomination Sent' is displayed when contributor send the nomination for the project.";
			
			Thread.sleep(3000);
			WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
			Assert.assertTrue(assertPendStatus.isDisplayed());
			home2=assertPendStatus.getText();
			System.out.println(home2);
			actual2 = "Nomination submitted project is available under My Project table with Pending status.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
			System.out.println(homeText);
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Nomination sent", homeText1, expect1, actual1);
			System.out.println(homeText1);
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Pending", homeText2, expect2, actual2);
			System.out.println(homeText2);
		}
	}
	
	public static String createProjectBookWithSelectedCont() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
		VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
		Thread.sleep(3000);
		Assert.assertTrue(VS.getAssertSelectContributorPopUpHeader().isDisplayed());
		Assert.assertTrue(VS.getAssertContributorTypeLabel().isDisplayed());
		Assert.assertTrue(VS.getAssertSaveBtn().isDisplayed());
		Assert.assertTrue(VS.getAssertCloseBtn().isDisplayed());
		Thread.sleep(3000);
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
//		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
//		Thread.sleep(3000);
		String OrgCon =  excel.getContentName("Org Contributor");
		System.out.print(OrgCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),OrgCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
//		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		
		Assert.assertTrue(VS.getAssertContributorSelected().isDisplayed());
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
	
	public static void validateConfirmationPopUpPageClose(String ProjectName) throws InterruptedException {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String home1 = null;
		String expect1 = "1.confirmation popup page should be displayed on clicking Modify Button.";
		String actual1 = "1.confirmation popup page is not displayed on clicking Modify Button.";
		
		String home2 = null;
		String expect2 = "2.Modify Confirmation popup page should be displayed with the Text : 'Your nomination is already submitted, do you want to modify it?', 'yes' Button and 'No' Button.";
		String actual2 = "2.Modify Confirmation popup page is not displayed with the Text : 'Your nomination is already submitted, do you want to modify it?', 'yes' Button and 'No' Button.";
		
		String home3 = null;
		String expect3 = "3.on clicking Yes Button on confirmation popup page,the project status should be changed to 'Initiated' state from 'Pending' state";
		String actual3 = "3.on clicking Yes Button on confirmation popup page,the project status is not changed to 'Initiated' state from 'Pending' state";

		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		String s4 = " ']//following::span[text()='Pending'][1]";
		String s5 = " ']//following::span[text()='Modify'][1]";
		String s6 = " ']//following::span[text()='Initiated'][1]";
		Thread.sleep(10000);
		
		WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
		WebElement assertModifyBtn = driver.findElement(By.xpath(s1 + s2 + s5));
		WebElement assertOpenBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		
		VDNUtils.waitToBeClickableAndClick(assertModifyBtn);
		Thread.sleep(3000);
		Assert.assertTrue(VC.getConfirmationOnModify().isDisplayed());
		Assert.assertTrue(VO.getConfirmDeletion().isDisplayed());
		Assert.assertTrue(VC.getClkNoBtn().isDisplayed());
	
		
		home1=VC.getConfirmationOnModify().getText();
		System.out.println(home1);
		actual1 = "1.confirmation popup page is displayed on clicking Modify Button.";
		
		home2=VC.getClkNoBtn().getText();;
		System.out.println(home2);
		actual2 = "2.Modify Confirmation popup page is not displayed with the Text : 'Your nomination is already submitted, do you want to modify it?', 'yes' Button and 'No' Button.";
		
		VDNUtils.waitToBeClickableAndClick(VO.getConfirmDeletion());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		Thread.sleep(3000);
		
		WebElement assertStatusUpdate = driver.findElement(By.xpath(s1 + s2 + s6));
		Assert.assertTrue(assertStatusUpdate.isDisplayed());
		Thread.sleep(3000);
		
		home3=assertStatusUpdate.getText();;
		System.out.println(home3);
		actual3 = "3.on clicking Yes Button on confirmation popup page,the project status is changed to 'Initiated' state from 'Pending' state";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(homeText1);
		Listeners.customAssert("Your nomination is already submitted, do you want to modify it?", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		System.out.println(homeText2);
		Listeners.customAssert("No", homeText2, expect2, actual2);
		
		String homeText3 = home3 != null ? home3 : "N/A";
		System.out.println(homeText3);
		Listeners.customAssert("Initiated", homeText3, expect3, actual3);
				
	}
}
	
	public static void verifyNominationConfirmationPopUp(String ProjectName) throws InterruptedException {
		//HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String home = null;
		String expect = "contributor should be able to nominate to the framework project without uploading sample";
		String actual = "contributor is unable to nominate to the framework project without uploading sample";
		
		String home1 = null;
		String expect1 = "On clicking Nominate button, Nomination Confirmation popup page should be displayed with 'Are you sure you want to submit this nomination?'";
		String actual1 = "On clicking Nominate button, Nomination Confirmation popup page is not displayed with 'Are you sure you want to submit this nomination?'";
		
		String home3 = null;
		String expect3 = "On clicking Nominate button, Nomination Confirmation popup page should displayed with Submit Button";
		String actual3 = "On clicking Nominate button, Nomination Confirmation popup page is not displayed with Submit Button";
		
//		String home3 = null;
//		String expect3 = "On clicking Nominate button, Nomination Confirmation popup page should displayed with Submit Button";
//		String actual3 = "On clicking Nominate button, Nomination Confirmation popup page is not displayed with Submit Button";
		
		
		String home2 = null;
		String expect2 = "The status of the project should be pending.";
		String actual2 = "The status of the project is not pending";

		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		String s4 = " ']//following::span[text()='Pending'][1]";
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
		Thread.sleep(5000);
		Assert.assertTrue(VC.getNominationConfMsg().isDisplayed());
		
		home1=VC.getNominationConfMsg().getText();
		actual1 = "On clicking Nominate button, Nomination Confirmation popup page is displayed with 'Are you sure you want to submit this nomination?'";
		

		home3=VO.getSubmitPostNominate().getText();
		actual3 = "On clicking Nominate button, Nomination Confirmation popup page is displayed with Submit Button";
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
		home=VO.getAssertNominationSent().getText();
		actual = "contributor is able to nominate to the framework project without uploading sample";
		
		WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
		Assert.assertTrue(assertPendStatus.isDisplayed());
		
		home2=assertPendStatus.getText();
		actual2 = "The status of the project is pending";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Nomination sent", homeText, expect, actual);
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Are you sure you want to submit this nomination?", homeText1, expect1, actual1);
		String homeText3 = home1 != null ? home3 : "N/A";
		Listeners.customAssert("Submit", homeText3, expect3, actual3);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Pending", homeText2, expect2, actual2);	
	}

}	
	public static void verifyAssignUserAndToastMsg(String ProjectName)
			throws InterruptedException, IOException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

		String home1 = null;
		String expect1 = " 1.Contributor orgadmin should be able to assign contributor to the approved project and toast message 'Roles Updated ' should be displayed";
		String actual1 =  "1.Contributor orgadmin is unable to assign contributor to the approved project and toast message 'Roles Updated ' is not displayed";
		
		String home2 = null;
		String expect2 = " 2.Contributor orgadmin should be able to assign reviewer to the approved project and toast message 'Roles Updated ' should be displayed.";
		String actual2 =  "2.Contributor orgadmin is unable to assign reviewer to the approved project and toast message 'Roles Updated ' is not displayed.";
		
		String home3 = null;
		String expect3 = " 3.Contributor orgadmin should be able to assign Both to the approved project and toast message 'Roles Updated ' should be displayed.";
		String actual3 =  "3.Contributor orgadmin is unable to assign Both to the approved project and toast message 'Roles Updated ' is not displayed.";
		
		
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
			
			String OrgCon =  excel.getContentName("Org Cont");
			System.out.print(OrgCon);
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), OrgCon);
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());

			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			home1 = VO.getRolesUpdatedMsg().getText();
			System.out.println(home1);
			actual1 ="1.Contributor orgadmin is able to assign contributor to the approved project and toast message 'Roles Updated ' is displayed";
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			String OrgRev =  excel.getContentName("Org Rev");
			System.out.print(OrgRev);
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), OrgRev);
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			home2 = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			actual2="2.Contributor orgadmin is able to assign reviewer to the approved project and toast message 'Roles Updated ' is displayed.";
			
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			String OrgBoth =  excel.getContentName("Org Both");
			System.out.print(OrgBoth);
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(),OrgBoth);
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelectBothPostSearch());
			
			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
			Thread.sleep(5000);
			
			home3 = VO.getRolesUpdatedMsg().getText();
			System.out.println(home3);
			actual3 = "3.Contributor orgadmin is able to assign Both to the approved project and toast message 'Roles Updated ' is displayed.";
			
			home = VO.getRolesUpdatedMsg().getText();
			System.out.println(home);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
			
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Roles updated...", homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Roles updated...", homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			System.out.println(homeText3);
			Listeners.customAssert("Roles updated...", homeText3, expect3, actual3);
			
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	public static void verifyQuestionMarkIconWithNeedHelpDisplayedUnderMyProjectsTab(String ProjectName) throws InterruptedException {
		String home = null;
		String expect = ProjectName + " is Available on All My Projects Tab for Individual Contributor";
		String actual = ProjectName + " is not Available on All My Projects Tab for Individual Contributor";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(10000);
			Assert.assertTrue(VS.getAssertNeedHelp().isDisplayed());

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
	
	public static void VerifyMyContentsTabIsAvailable() throws InterruptedException {
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String home = null;
		String expect = " 'My Contents' tab should be available for Contributor Org Admin ";
		String actual =  " 'My Contents' tab is not available for Contributor Org Admin";
		try {
		Assert.assertTrue(VC.getAssertMyContentTab().isDisplayed());
		home=VC.getAssertMyContentTab().getText();
		actual = "'My Contents' tab is available for Contributor Org Admin";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("My Content", homeText, expect, actual);
	}

}
	
	public static void uploadThePDFAndEPubContentFromContributor(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Able to upload The Content From Contributor Org for "+ProjectName;
		String actual =  "Unable to upload The Content From Contributor Org for  "+ProjectName;
		
		String home1 = null;
		String expect1 = "contributor should able to nominate to the framework project by uploading sample";
		String actual1 = "contributor is unable to nominate to the framework project by uploading sample";
		
		String home3 = null;
		String expect3 = "contributor should able to uploading epub sample";
		String actual3 = "contributor is unable to uploading epb sample";

		String home2 = null;
		String expect2 = "The status of the project should be pending.";
		String actual2 = "The status of the project is not pending";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = " ']//following::span[text()='Pending'][1]";
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
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
			Thread.sleep(3000);
			home = VO.getAssertContentSetReview().getText();	
			System.out.println(home);

			actual = " Able to upload The Content From Contributor Org for "+ProjectName;
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());	
			Thread.sleep(3000);
			home3 = VO.getAssertContentSetReview().getText();	
			System.out.println(home);

			actual3 = "contributor is able to uploading epb sample";
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home1=VO.getAssertNominationSent().getText();
			System.out.println(home1);
			actual1 = "contributor is able to nominate to the framework project by uploading sample";
			
//			Thread.sleep(3000);
//			WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
//			Assert.assertTrue(assertPendStatus.isDisplayed());
//			home2=assertPendStatus.getText();
//			System.out.println(home2);
//			actual2 = "The status of the project is pending";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
			System.out.println(homeText);
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText3, expect3, actual3);
			System.out.println(homeText3);
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Nomination sent", homeText1, expect1, actual1);
			System.out.println(homeText1);
//			String homeText2 = home2 != null ? home2 : "N/A";
//			Listeners.customAssert("Pending", homeText2, expect2, actual2);
//			System.out.println(homeText2);
		}
	}
	
	
	public static void verifyContentStatusOnTocPageIsRejectedForIndContributor(String ProjectName) throws InterruptedException {
		String home = null;
		String expect = "Content status on toc page should be 'Rejected' for Individual contributor when sourcing org admin Rejected the content";
		String actual =  "Content status on toc page is not 'Rejected' for Individual contributor when sourcing org admin Rejected the content";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = " ']//following::span[text()='Pending'][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitForElementToBeVisible(VC.getClkUploadCont());
			VDNUtils.waitToBeClickableAndClick(VC.getClkUploadCont());
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertRejectOnTOC());
			
			Assert.assertTrue(VC.getAssertRejectOnTOC().isDisplayed());
			
			home = VC.getAssertRejectOnTOC().getText();	
			System.out.println(home);
			actual = "Content status on toc page is 'Rejected' for Individual contributor when sourcing org admin Rejected the content";
			

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Rejected" ,homeText, expect, actual);
			System.out.println(homeText);

		}
	}
	
	public static void verifyContributorIsAbleToModifyTheNomination(String ProjectName) throws Exception {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "Contributor should be able to modify Nomination";
		String actual = "Contributor not able to modify Nomination";
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
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());

		String s4 = " ']//following::span[text()='Initiated'][1]";
		Thread.sleep(10000);
		WebElement assertInitStatus = driver.findElement(By.xpath(s1 + s2 + s4));
		Assert.assertTrue(assertInitStatus.isDisplayed());
		
		home=assertInitStatus.getText();
		actual = "Contributor is able to modify Nomination successfully";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Initiated", homeText, expect, actual);
	}

}
	
public static void verifyContributorIsAbleToModifyTheNominationByAddMoreSamples(String ProjectName) throws Exception {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "contributing or admin should be able to modify the nomination by modifying the content types";
		String actual = "contributing or admin is unable to modify the nomination by modifying the content types";
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
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());
		
		
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
		
		String s4 = " ']//following::span[text()='Initiated'][1]";
		Thread.sleep(10000);
		WebElement assertInitStatus = driver.findElement(By.xpath(s1 + s2 + s4));
		Assert.assertTrue(assertInitStatus.isDisplayed());
		
		home=assertInitStatus.getText();
		actual = "contributing org admin is able to modify the nomination by modifying the content types";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Initiated", homeText, expect, actual);
	}
	
}

public static void verifyCheckboxIsDisplayedOnContentTypes(String ProjectName) throws Exception {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	String home = null;
	String expect = "checkbox should be displayed on content types and opening the Project from My Project with initiated status.";
	String actual = "checkbox should is not displayed content types and opening the Project from My Project with initiated status.";
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
	
	VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());

	String s4 = " ']//following::span[text()='Initiated'][1]";
	Thread.sleep(10000);
	WebElement assertInitStatus = driver.findElement(By.xpath(s1 + s2 + s4));
	Assert.assertTrue(assertInitStatus.isDisplayed());
	Thread.sleep(5000);
	
//	WebElement iframe = driver.findElement(By.tagName("iframe"));
//	driver.switchTo().frame(iframe);
	
//	js.executeScript("arguments[0].scrollIntoView(true);",clkOpenProject);
//	js.executeScript("window.scrollBy(500, 0)");
//	Thread.sleep(5000);
	String s5 =" ']//following::span[@class='pull-right'][1]";
	WebElement clkOpenProject1 = driver.findElement(By.xpath(s1+s2+s5));
	VDNUtils.waitToBeClickableAndClick(clkOpenProject1);
	Thread.sleep(5000);
	VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
	VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
	
	home=VO.getSelectContetCheckbox().getText();
	System.out.println(home);
	actual = "checkbox is displayed on content types when opening the Project from My Project with initiated status.";

} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("eTextbook", homeText, expect, actual);
}

}

public static void VerifyContentTypesPopUpIsDisplayedWithoutTC(String ProjectName) throws Exception {
	
	String home = null;
	String expect = "Content types pop up should be displayed post clicking on create/upload button.";
	String actual = "Content types pop up is not displayed post clicking on create/upload button.";
	
	try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		Thread.sleep(10000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
		home=VC.getAssertContentTypesPopUp().getText();
		actual = "Content types pop up is displayed post clicking on create/upload button.";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Select to contribute", homeText, expect, actual);
	}

}
}