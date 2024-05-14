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
			boolean test = false;
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
				test = true;
			}
			Assert.assertTrue(test);
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
	

	public static void verifySelectContentTypePopup(String ProjectName) throws InterruptedException {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String text = "N/A";
		String expect = "Select content type popup should be closed on click of cancel button";
		String actual = "Select content type popup is not closed on click of cancel button";
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
		VDNUtils.waitToBeClickableAndClick(VC.getContentTypeCancelBtn());
		Thread.sleep(500);
		Assert.assertTrue(VC.getContentTypeToasrMsg().isDisplayed());
		text = "Completed";
		actual = "Select content type popup is closed on click of cancel button successfully";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}

}
	
	public static void verifyToastMessageWhileContributorSelectContentType(String ProjectName) throws InterruptedException {
			
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String text = "N/A";
			String expect = "Toast message Selected Content Type(s) saved successfully should be displayed";
			String actual = "Toast message Selected Content Type(s) saved successfully is not displayed";
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
			Thread.sleep(500);
			Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
			text = "Completed";
			actual = "Toast message Selected Content Type(s) saved successfully is displayed";
		} finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	
	}
	
	public static void verifyPreviouslyOpenedProjectAvailableUnderMyProjectsTab(String ProjectName) throws InterruptedException {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String text = "N/A";
		String expect = "Previously opened project should be available under my project";
		String actual = "Previously opened project is not available under my project";
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
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VC.getMyProjectTab());
			String s4 = "//div[text()=' ";
			String s5 = ProjectName;
			String s6 = " ']//following::span[text()='Initiated'][1]";
			WebElement statusInitiated = driver.findElement(By.xpath(s4 + s5 + s6));
			Assert.assertTrue(statusInitiated.isDisplayed());
		text = "Completed";
		actual = "Previously opened project is available under my project successfully";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}

}
	
		public static void verifyContributorAdminAbleToClickAndChooseTheContentTypes(String ProjectName) throws InterruptedException {
			
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			String text = "N/A";
			String expect = "Content type instruction text shoud be display to user";
			String actual = "Content type instruction text is not display to user";
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
			Assert.assertTrue(VC.getInstructionText().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());
			Thread.sleep(500);
			Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
			text = "Completed";
			actual = "Content type instruction text is display to user successfully";
		} finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	
	}
		
	public static void verifyAllDetailsAreDisplayedOnOpeningAProject(String ProjectName) throws InterruptedException {
				
				VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
				String text = "N/A";
				String expect = "All details should be display on opening the project";
				String actual = "All details are not displayed on opening the project";
				try {
					VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
					VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
				String s1 = "//div[text()=' ";
				String s2 = ProjectName;
				String s3 = " ']//following::button[text()='Open '][1]";
				String s4 = "((//*[text()='";
				String s5 = " ']))";
				Thread.sleep(1000);
				WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
				VDNUtils.waitToBeClickableAndClick(clkOpenProject);
				WebElement projectname = driver.findElement(By.xpath(s4 + s2 + s5));
				Assert.assertTrue(projectname.isDisplayed());
				Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
				Assert.assertTrue(VS.getProjectDates().isDisplayed());
				Assert.assertTrue(VC.getNominationProcess().isDisplayed());
				Assert.assertTrue(VC.getGuidelineDocument().isDisplayed());
				text = "Completed";
				actual = "All details are display on opening the project successfully";
			} finally {
				Listeners.customAssert("Completed", text, expect, actual);
			}
		
		}
	
	public static void verifyContributorAdminIsAbleToApplyFilterInAllProjectsTab() throws InterruptedException {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String text = "N/A";
		String expect = "Contributor admin should be able to apply filter in all project tab";
		String actual = "Contributor admin is not able to apply filter in all project tab";
		try {
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VC.getApplyFilterButton());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VC.getSelectSourcingOrg());
			VDNUtils.waitToBeClickableAndClick(VC.getSelectOrg());
			VDNUtils.waitToBeClickableAndClick(VC.getFilterApplyBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getApplyFilterButton());
			VDNUtils.waitToBeClickableAndClick(VC.getFilterResetBtn());
		text = "Completed";
		actual = "Contributor admin is able to apply filter in all project tab successfully";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}

}
	
public static void verifyAllTheFieldsAreAvailableInApplyFilterPopUp() throws InterruptedException {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String text = "N/A";
		String expect = "All the fields should be available in apply filter popup";
		String actual = "All the fields are not available in apply filter popup";
		try {
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VC.getApplyFilterButton());
			Thread.sleep(1000);
			Assert.assertTrue(VC.getSelectSourcingOrg().isDisplayed());
			Assert.assertTrue(VC.getFilterResetBtn().isDisplayed());
			Assert.assertTrue(VC.getFilterApplyBtn().isDisplayed());
		
		text = "Completed";
		actual = "All the fields are available in apply filter popup";
	} finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}

}

public static void verifyTermsAndPoliciesPageIsOpenedInSeparateTab() {
	
	String text = "N/A";
	String expect = "Verify terms and policies page should be opend in another tab";
	String actual = "Terms and policies page is not opend in another tab";
	
	try {
	VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
	VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
	String mainWindowHandle = driver.getWindowHandle();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", VC.getTermsAndPolicies());
	VDNUtils.waitForElementToBeVisible(VC.getTermsAndPolicies());
	VDNUtils.waitToBeClickableAndClick(VC.getTermsAndPolicies());
	Set<String> allWindowHandles = driver.getWindowHandles();
	for (String handle : allWindowHandles) {
	    
	    if (!handle.equals(mainWindowHandle)) {
	        System.out.println("New window opened");
	    }
	}
	text = "Completed";
	actual = "Terms and policies page is opend in another tab successfully";
	}finally {
		Listeners.customAssert("Completed", text, expect, actual);
	}
	
}

public static void verifyListOfUploadedSampleIsDisplayedInProjectDetailsPage(String ProjectName) throws Exception {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	String home = null;
	String expect = "List of uploaded sample should be displayed in project details page";
	String actual = "List of uploaded sample is not displayed in project details page";
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
	Assert.assertTrue(VC.getNumberOfSamples().isDisplayed());
	Thread.sleep(3000);
	VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
	Thread.sleep(3000);
	VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
	VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
	Thread.sleep(3000);
	Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
	home=VO.getAssertNominationSent().getText();
	actual = "List of uploaded sample is displayed in project details page";
} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Nomination sent", homeText, expect, actual);
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
public static void validateContributorIsAbleToUpdateNominationBeforeApprovalOrRejection(String ProjectName) throws Exception {
	
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	String home = null;
	String expect = "contributor should be able to update the nomination before approval or rejection by sourcing orgadmin.";
	String actual = "contributor is unable to update the nomination before approval or rejection by sourcing orgadmin.";
	
	String home2 = null;
	String expect2 = "The status of the project should be pending post Updating";
	String actual2 = "The status of the project is not pending post Updating";
	
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
	actual = "contributor is able to update the nomination before approval or rejection by sourcing orgadmin.";
	String s4 = " ']//following::span[text()='Pending'][1]";
	
	WebElement assertPendStatus = driver.findElement(By.xpath(s1 + s2 + s4));
	Assert.assertTrue(assertPendStatus.isDisplayed());
	home2=assertPendStatus.getText();
	actual2 = "The status of the project is pending post Updating";
} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Nomination sent", homeText, expect, actual);
	String homeText2 = home2 != null ? home2 : "N/A";
	Listeners.customAssert("Pending", homeText2, expect2, actual2);
}

}

public static void verifyContributorIsAbleToOpenFromMyProjectsTab(String ProjectName) throws Exception {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	String home = null;
	String expect = ProjectName + " Nomination is sent Successfully";
	String actual = ProjectName + " Nomination is not sent Successfully";
	
	String home2 = null;
	String expect2 = "contributor should be able to open the Framework project from My Projects tab post nomination is approved";
	String actual2 =  "contributor is able to open the Framework project from My Projects tab post nomination is approved";
	
	
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
	
	VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
	Thread.sleep(3000);
	
	WebElement assertStatusUpdate = driver.findElement(By.xpath(s1 + s2 + s3));
	Assert.assertTrue(assertStatusUpdate.isDisplayed());
	Thread.sleep(3000);
	
	home2=assertStatusUpdate.getText();;
	System.out.println(home2);
	actual2 = "contributor is able to open the Framework project from My Projects tab post nomination is approved";
} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Nomination sent", homeText, expect, actual);
	String homeText2 = home2 != null ? home2 : "N/A";
	System.out.println(homeText2);
	Listeners.customAssert("Open", homeText2, expect2, actual2);
}

}

public static void openAndNominateWithoutTargetCollectionWithSample(String ProjectName) throws Exception {
	String s1 = "//div[text()=' ";
	String s2 = ProjectName;
	String s3 = " ']//following::button[text()='Open '][1]";
	Thread.sleep(10000);
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
	WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
	VDNUtils.waitToBeClickableAndClick(clkOpenProject);
	
//	VDNUtils.waitToBeClickableAndClick(clkOpenProject);
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
	
	

//	VDNUtils.waitToBeClickableAndClick(VO.getBtnSelectContentTypes());
//	VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
//	VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());

//	VO.getAssertSelectedCTMsg.isDisplayed();
//	Thread.sleep(3000);
//	Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
//	Thread.sleep(5000);

//	Thread.sleep(5000);
//	VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());

	VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());

	VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
	Thread.sleep(3000);
	Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());

}


public static void verifyContOrgContributorAbleToUploadContentAndAddAllDetails() throws Exception {
	
	String home = null;
	String expect = "Contributor org contributor should be able to upload the content and add all the details in the edit details pop up and send it for review";
	String actual = "Contributor org contributor is unable to upload the content and add all the details in the edit details pop up and send it for review";
	
	try {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
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

		actual = " Contributor org contributor is able to upload the content and add all the details in the edit details pop up and send it for review ";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Content sent for review", homeText, expect, actual);
	}

}

public static void uploadContentFromAssignedContributorWithoutTC(String ProjectName)
		throws Exception {
	String home = null;
	String expect = " Content should be available on the TOC with Review Pending status for "+ProjectName+" and is Displayed on the Top";
	String actual =  "Content is not available on the TOC with Review Pending status for "+ProjectName+" or is not Displayed on the Top";

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
		VDNUtils.waitForElementToBeVisible(VO.getAssertReviewPending());
		
//		home = VO.getAssertApprovalPending().getText();
		home = VO.getAssertReviewPending().getText();
		actual = " Content should be available on the TOC with Review Pending status for "+ProjectName+" and is Displayed on the Top";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}

public static void validateOrgReviewerIsAbleApproveNoTC(String ProjectName)
		throws Exception {
	String home = null;
	String expect = " Contributor orgreviewer should be able review the content and submit for approval.";
	String actual =  "Contributor orgreviewer is unable review the content and submit for approval.";

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
		

//		VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
		
		VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
		Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
		
		
		VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
		Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
		
		Assert.assertTrue(VO.getContentDetails().isDisplayed());
		VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitForApproval());
		Thread.sleep(3000);
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
		Assert.assertTrue(VO.getAssertApprovalPending().isDisplayed());
		String stausApprovalPending = VO.getAssertApprovalPending().getText();
		Assert.assertEquals(stausApprovalPending,"Approval Pending");			
		home = VO.getAssertApprovalPending().getText();
		System.out.print(home);
		
		actual = "Contributor orgreviewer is able review the content and submit for approval.";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
	}
}


public static void ValidateIndContributorIsAbleToUploadContentAndSave(String ProjectName)
		throws Exception {
	String home1 = null;
	String expect1 = " 1.individual contributor should be able to upload the content and save the content, content status should be 'Draft'";
	String actual1 =  "1.individual contributor is unable to upload the content and save the content, content status should be 'Draft'";
	
	String home2 = null;
	String expect2 = " 2.Move/remove option should be available against the Draft content for individual contributor.";
	String actual2 =  "2.Move/remove option are not available against the Draft content for individual contributor.";

	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
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
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
		
		VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());


		VDNUtils.waitForElementToBeVisible(VO.getContentSavedtMessage());
		Assert.assertTrue(VO.getContentSavedtMessage().isDisplayed());
		
		VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertDraft());
		Assert.assertTrue(VO.getAssertDraft().isDisplayed());
		String stausDraft = VO.getAssertDraft().getText();
		Assert.assertEquals(stausDraft,"Draft");			
		Thread.sleep(2000);
		
		home1 = VO.getAssertDraft().getText();
		System.out.print(home1);		
		actual1 = "1.individual contributor is able to upload the content and save the content, content status should be 'Draft'";
		
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(200, 200)");
//		VDNUtils.waitForElementToBeVisible(VC.getClkDottedMenue());
		VDNUtils.waitToBeClickableAndClick(VC.getClkDottedMenue());
		Thread.sleep(2000);
		Assert.assertTrue(VC.getAssertEditOpt().isDisplayed());
		Assert.assertTrue(VC.getAssertMoveOpt().isDisplayed());
		Assert.assertTrue(VC.getAssertDeleteOpt().isDisplayed());
		
		
		home2 = VC.getAssertDeleteOpt().getText();
		System.out.print(home2);		
		actual2 = "2.Move/remove options are available against the Draft content for individual contributor";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Draft" ,homeText1, expect1, actual1);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Delete" ,homeText2, expect2, actual2);
	}
}


public static void ValidateAddFromLibraryNotAvailableAndCreateNewOptAvailableOnTOC(String ProjectName)
		throws Exception {
	String home1 = null;
	String expect1 = " 1.Only Create new option is available for nomination enabled projects.";
	String actual1 =  "1.Only Create new option is not available for nomination enabled projects.";
	
	String home2 = null;
	String expect2 = " 2.+Add from library option is not available for nomination enabled projects.";
	String actual2 =  "2.+Add from library option is available for nomination enabled projects.";

	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
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
		
		Assert.assertTrue(VO.getClkCreateNew().isDisplayed());
		

		home1 = VO.getClkCreateNew().getText();
		System.out.print(home1);		
		actual1 = "1.Only Create new option is available for nomination enabled projects.";
		
//		Thread.sleep(2000);
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(200, 200)");
//		VDNUtils.waitForElementToBeVisible(VC.getClkDottedMenue());
//		VDNUtils.waitToBeClickableAndClick(VC.getClkDottedMenue());
//		Thread.sleep(2000);
//		Assert.assertTrue(VC.getAssertEditOpt().isDisplayed());
//		Assert.assertTrue(VC.getAssertMoveOpt().isDisplayed());
//		Assert.assertTrue(VC.getAssertDeleteOpt().isDisplayed());
		
		//div[@class='title active']
		
		
		String contentDetails = VC.getAssertTOC().getText();
		String[] lines = contentDetails.split("\r\n|\r|\n");
		System.out.println(lines.length);
		
		for (String line : lines) {
		    System.out.println(line);
		    Assert.assertNotEquals(line,"Add from library");
		}
		
		
		home2 = VO.getClkCreateNew().getText();
		System.out.print(home2);		
		actual2 = "2.+Add from library option is not available for nomination enabled projects.";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Create new" ,homeText1, expect1, actual1);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Create new" ,homeText2, expect2, actual2);
	}
}

public static void ValidateCheckboxBeforeDisclaimerTextAndItsMandatory(String ProjectName)
		throws Exception {
	String home1 = null;
	String expect1 = " 1.individual contributor should be able to upload the content and save the content, content status should be 'Draft'";
	String actual1 =  "1.individual contributor is unable to upload the content and save the content, content status should be 'Draft'";
	
	String home2 = null;
	String expect2 = " 2.Move/remove option should be available against the Draft content for individual contributor.";
	String actual2 =  "2.Move/remove option are not available against the Draft content for individual contributor.";

	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
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
		
        VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());
		
		
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
//		VO.getClkCheckBox().click();
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());
//		Thread.sleep(3000);
//		Assert.assertTrue(VC.getTotalContent().isDisplayed());
		
//		home1 = VO.getAssertDraft().getText();
//		System.out.print(home1);		
//		actual1 = "1.individual contributor is able to upload the content and save the content, content status should be 'Draft'";
//		
//		Thread.sleep(2000);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(200, 200)");
//////		VDNUtils.waitForElementToBeVisible(VC.getClkDottedMenue());
//		VDNUtils.waitToBeClickableAndClick(VC.getClkDottedMenue());
//		Thread.sleep(2000);
//		Assert.assertTrue(VC.getAssertEditOpt().isDisplayed());
//		Assert.assertTrue(VC.getAssertMoveOpt().isDisplayed());
//		Assert.assertTrue(VC.getAssertDeleteOpt().isDisplayed());
//		
//		
//		home2 = VC.getAssertDeleteOpt().getText();
//		System.out.print(home2);		
//		actual2 = "2.Move/remove options are available against the Draft content for individual contributor";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Draft" ,homeText1, expect1, actual1);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Delete" ,homeText2, expect2, actual2);
	}
}

public static void validateContributionOrgReviewerIsAbleToAcceptAndRequestChangesOfDT(String ProjectName)
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
		
//		VDNUtils.waitForElementToBeVisible(VO.getClkUploadfromBothRole());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadfromBothRole());
//		Thread.sleep(3000);
		
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContentBtn());
		Thread.sleep(3000);

		VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
		Thread.sleep(3000);
		
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

		
		actual = "Assigned Reviewer Is Able is able to preview the uploaded content by contributor.";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
	}
}

public static void VerifyManageUsersTabIsAvailableForContOrgAdmin() throws InterruptedException {
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
//		Assert.assertTrue(VS.getAssertQuestionMarkIcon().isDisplayed());
		Thread.sleep(2000);
		
		home = VS.getAssertNeedHelp().getText();
		actual = "Question Mark icon with Need help ? is Displayed On Manage Users tab";
	

	} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Need Help?", homeText, expect, actual);
	}
	
}	
	
	public static void validateManageUsersTabIsAvailableForOgadmin() throws InterruptedException {
		String home1 = null;
		String expect1 = "1.User name should be Displayed on Manage Users tab";
		String actual1 =  "1.User name is not Displayed on Manage Users tab";
		
		String home2 = null;
		String expect2 = "2. Email / Mobile should be Displayed on Manage Users tab";
		String actual2 = "2. Email / Mobile is not Displayed on Manage Users tab";
		
		String home3 = null;
		String expect3 = "3. Roles should be Displayed on Manage Users tab";
		String actual3 = "3. Roles is not Displayed on Manage Users tab";
		
//		String home4 = null;
//		String expect4 = "4. Create new Project button Should Displayed on top";
//		String actual4 = "4. Create new Project button is not Displayed on top";
		
		String home5 = null;
		String expect5 = "5. Invite user option Should Displayed on top";
		String actual5 = "5. Invite user option is not Displayed on top";
		
		String home6 = null;
		String expect6 = "6. Search bar with text field Should Displayed";
		String actual6 = "6. Search bar with text field is Not Displayed";
		
		String home7 = null;
		String expect7 = "7. All users Header Should Displayed";
		String actual7 = "7. All users Header is Not Displayed";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			Thread.sleep(3000);
			Assert.assertTrue(VS.getAssertUserTitle().isDisplayed());
			Thread.sleep(2000);
			
			WebElement table=driver.findElement(By.xpath("/html/body/app-root/div/app-org-user-list/div/div[2]/div/table/tbody/tr[1]/td[1]"));
			List<WebElement> lst=table.findElements(By.tagName("tr"));
			System.out.println(lst);
			
			
			home1 = VS.getAssertUserTitle().getText();
			System.out.println(home1);
			actual1 = "1.User name is not Displayed on Manage Users tab";
			
			Assert.assertTrue(VS.getAssertEmailMobTitle().isDisplayed());
			Thread.sleep(2000);
			
			home2 = VS.getAssertEmailMobTitle().getText();
			System.out.println(home2);
			actual2 = "2.Email / Mobile option is Displayed on Manage Users tab";
			
			Assert.assertTrue(VS.getAssertRolesTitle().isDisplayed());
			Thread.sleep(2000);
			
			home3 = VS.getAssertRolesTitle().getText();
			System.out.println(home3);
			actual3 = "3. Roles Title Header is Displayed on Manage Users tab";
			
//			Assert.assertTrue(VO.getCreateNewBtn().isDisplayed());
//			Thread.sleep(2000);
//			
//			home4 = VO.getCreateNewBtn().getText();
//			System.out.println(home4);
//			actual4 = "4. Create new Project button is Displayed on top";
			
			Assert.assertTrue(VS.getAssertInviteUser().isDisplayed());
			Thread.sleep(2000);
			
			home5 = VS.getAssertInviteUser().getText();
			System.out.println(home5);
			actual5 = "5. Invite user option is Displayed on top";
			
			Assert.assertTrue(VS.getAssertSearchBar().isDisplayed());
			Thread.sleep(2000);
			Assert.assertTrue(VO.getSearchBtn().isDisplayed());
			
			home6 = VO.getSearchBtn().getText();
			System.out.println(home6);
			actual6 = "6. Search bar with text field is Displayed";
			
			Assert.assertTrue(VS.getAssertAllUserHeader().isDisplayed());
			
			home7 = VS.getAssertAllUserHeader().getText();
			System.out.println(home7);
			actual7 = "7. All users Header is Displayed";
			
		} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(home1);
		Listeners.customAssert("User   ", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		System.out.println(home2);
		Listeners.customAssert("Email / Mobile", homeText2, expect2, actual2);
		
		String homeText3 = home3 != null ? home3 : "N/A";
		System.out.println(home3);
		Listeners.customAssert("Roles   ", homeText3, expect3, actual3);
//		
//		String homeText4 = home4 != null ? home4 : "N/A";
//		System.out.println(home4);
//		Listeners.customAssert("Create New Project", homeText4, expect4, actual4);
//		
		String homeText5 = home5 != null ? home5 : "N/A";
		System.out.println(home5);
		Listeners.customAssert("Invite User", homeText5, expect5, actual5);
		
		String homeText6 = home6 != null ? home6 : "N/A";
		System.out.println(home6);
		Listeners.customAssert("Search", homeText6, expect6, actual6);
		
		String homeText7 = home7 != null ? home7 : "N/A";
		System.out.println(home7);
		Listeners.customAssert("All Users", homeText7, expect7, actual7);
		
		}

}
	
	public static void validateDataDisplayedForContributorOrgAdmin() throws InterruptedException {
		String home1 = null;
		String expect1 = "1.Vidyadaan logo should be Displayed on ContributorOrgAdmin";
		String actual1 =  "1.Vidyadaan logo is not Displayed on ContributorOrgAdmin";
		
		String home2 = null;
		String expect2 = "2. Organization Should Displayed on Contributor Org Admin";
		String actual2 = "2. Organization is not Displayed on Contributor Org Admin";
		
		String home3 = null;
		String expect3 = "3. All Projects Should Displayed on Contributor Org Admin";
		String actual3 = "3. All Projects is not Displayed on Contributor Org Admin";
		
		String home4 = null;
		String expect4 = "4. My Projects Should Displayed on Contributor Org Admin";
		String actual4 = "4. My Projects Should Displayed on Contributor Org Admin";
		
		String home5 = null;
		String expect5 = "5. Manage Users Should Displayed on Contributor Org Admin";
		String actual5 = "5. Manage Users is not Displayed on Contributor Org Admin";
		
		String home6 = null;
		String expect6 = "6. Click here to get started Should Displayed on Contributor Org Admin";
		String actual6 = "6. Click here to get started is not Displayed on Contributor Org Admin";
		
		String home7 = null;
		String expect7 = "7. Help center at the footer on left Should Displayed on Contributor Org Admin";
		String actual7 = "7. Help center at the footer on left is not Displayed on Contributor Org Admin";
		
		String home8 = null;
		String expect8 = "8. Terms and policies Should Displayed on Contributor Org Admin";
		String actual8 = "8. Terms and policies is not Displayed on Contributor Org Admin";
		
		String home9 = null;
		String expect9 = "9. My content tab Should Displayed on Contributor Org Admin";
		String actual9 = "9. My content tab is Displayed on Contributor Org Admin";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			Thread.sleep(3000);
			Assert.assertTrue(VC.getAssertVDNLogo().isDisplayed());
			Thread.sleep(2000);
					
			
			home1 = VO.getAllProjectsTab().getText();
			System.out.println(home1);
			actual1 = "Vidyadaan logo is Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VC.getAssertOrg().isDisplayed());
			Thread.sleep(2000);
			
			home2 = VC.getAssertOrg().getText();
			System.out.println(home2);
			actual2 = "2. Organization is Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VO.getAllProjectsTab().isDisplayed());
			Thread.sleep(2000);
			
			home3 = VO.getAllProjectsTab().getText();
			System.out.println(home3);
			actual3 = "3. All Projects is Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VO.getClkMyProject().isDisplayed());
			Thread.sleep(2000);
			
			home4 = VO.getClkMyProject().getText();
			System.out.println(home4);
			actual4 = "4. My Projects Should Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VO.getClkManageUsers().isDisplayed());
			Thread.sleep(2000);
			
			home5 = VO.getClkManageUsers().getText();
			System.out.println(home5);
			actual5 = "5. Manage Users is Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VC.getAssertGoStarted().isDisplayed());
			
			home6 = VC.getAssertGoStarted().getText();
			System.out.println(home6);
			actual6 = "Click here to get started is Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VC.getAssertHelpCenter().isDisplayed());
			
			home7 = VC.getAssertHelpCenter().getText();
			System.out.println(home7);
			actual7 = "7. Help center at the footer on left is Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VC.getAssertTnC().isDisplayed());
			
			home8 = VC.getAssertTnC().getText();
			System.out.println(home8);
			actual8 = "8. Terms and policies is Displayed on Contributor Org Admin";
			
			Assert.assertTrue(VC.getAssertTnC().isDisplayed());
			
			home9 = VC.getAssertTnC().getText();
			System.out.println(home9);
			actual9 = "9. My content tab is Displayed on Contributor Org Admin";
			
		} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(home1);
		Listeners.customAssert("All Projects", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		System.out.println(home2);
		Listeners.customAssert("Organisation : ", homeText2, expect2, actual2);
		
		String homeText3 = home3 != null ? home3 : "N/A";
		System.out.println(home3);
		Listeners.customAssert("All Projects", homeText3, expect3, actual3);
		
		String homeText4 = home4 != null ? home4 : "N/A";
		System.out.println(home4);
		Listeners.customAssert("My Projects", homeText4, expect4, actual4);
		
		String homeText5 = home5 != null ? home5 : "N/A";
		System.out.println(home5);
		Listeners.customAssert("Manage Users", homeText5, expect5, actual5);
		
		String homeText6 = home6 != null ? home6 : "N/A";
		System.out.println(home6);
		Listeners.customAssert("Click here to get started", homeText6, expect6, actual6);
		
		String homeText7 = home7 != null ? home7 : "N/A";
		System.out.println(home7);
		Listeners.customAssert("Help Center", homeText7, expect7, actual7);
		
		String homeText8 = home8 != null ? home8 : "N/A";
		System.out.println(home8);
		Listeners.customAssert("Terms and Policies", homeText8, expect8, actual8);
		
		String homeText9 = home9 != null ? home9 : "N/A";
		System.out.println(home9);
		Listeners.customAssert("Terms and Policies", homeText9, expect9, actual9);
		
		}

}
	
	public static void validateContributorOrgadminAbleToSearchUser() throws InterruptedException {
		String home1 = null;
		String expect1 = "1.Contributor orgadmin should be able to search the user using search box under Manage users tab.";
		String actual1 = "1.Contributor orgadmin is unable to search the user using search box under Manage users tab.";
		
		String home2 = null;
		String expect2 = "2.The users list should displayed according to the search data.";
		String actual2 = "2.The users list is not displayed according to the search data.";
		
		String home3 = null;
		String expect3 = "3. contributor org admin should able to assign admin role for a contribution org user.";
		String actual3 = "3. contributor org admin is unable to assign admin role for a contribution org user";
		
		

		try {
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);

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
			
			home1 = VO.getSearchBtn().getText();
			System.out.println(home1);
			Thread.sleep(3000);
			actual1 = "1.Contributor orgadmin is able to search the user using search box under Manage users tab.";
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			Thread.sleep(5000);
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertSearchedUser());
			Assert.assertTrue(VC.getAssertSearchedUser().isDisplayed());
			
			home2 = VC.getAssertSearchedUser().getText();
			System.out.println(home2);
			
			actual2 = "2.The users list is displayed according to the search data";
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectAdmin());
			VDNUtils.waitForElementToBeVisible(VO.getAssertRolesUpdatedSuccess());
			home3 = VO.getAssertRolesUpdatedSuccess().getText();
			System.out.println(home3);
			
			Thread.sleep(5000);
			
			actual3 = "3. contributor org admin is able to assign admin role for a contribution org user.";
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectAdmin ());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSelectUsers());
			VDNUtils.waitForElementToBeVisible(VO.getAssertRolesUpdatedSuccess());
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Search", homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("color2", homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Role updated successfully", homeText3, expect3, actual3);
		}

	}
	
	public static void validateSelectRoleOptionIsByDefaultUnderAssignUsers(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Select Role option should be by default selected in the drop down under the assign users to projects tab for Contributor orgadmin. ";
		String actual =  "Select Role option is not by default selected in the drop down under the assign users to projects tab for Contributor orgadmin.";

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
			
			Assert.assertTrue(VO.getSelectRolePostSearch().isDisplayed());
			
			home = VO.getSelectRolePostSearch().getText();
			System.out.println(home);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color3");
//			Thread.sleep(5000);
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
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color5");
//			Thread.sleep(5000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectBothPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			
//			home = VO.getRolesUpdatedMsg().getText();
//			System.out.println(home);
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = "Select Role option is by default selected in the drop down under the assign users to projects tab for Contributor orgadmin. " ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Select Role", homeText, expect, actual);
		}
	}
	
	
	public static void validateListOfUploadedContentsIsDisplayedContributorOrgreviewer(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " The list of uploaded contents should be displayed on contents tab with open button in project details page for Contributor orgreviewer.";
		String actual =  "The list of uploaded contents is not displayed on contents tab with open button in project details page for Contributor orgreviewer.";

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
		
			home = VO.getClkOpenBtnNoRC().getText();
			System.out.print(home);
			
			actual = " The list of uploaded contents is displayed on contents tab with open button in project details page for Contributor orgreviewer.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Open" ,homeText, expect, actual);
		}
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
	
	
	public static void validateMsgNoUsersFoundIsDisplayedIfSearchDataNotFound(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " 'No users found' should be displayed if the search data is not found in the list of users for Contributor orgadmin ";
		String actual =  "'No users found' is not displayed if the search data is not found in the list of users for Contributor orgadmin";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color7");
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			
//			Assert.assertTrue(VO.getSearchField().isDisplayed());
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color3");
//			Thread.sleep(5000);
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
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color5");
//			Thread.sleep(5000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectRolePostSearch());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelectBothPostSearch());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getRolesUpdatedMsg());
//			Thread.sleep(5000);
//			
//			home = VO.getRolesUpdatedMsg().getText();
//			System.out.println(home);
//			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
//			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());
			Assert.assertTrue(VS.getAssertNoUsersFound().isDisplayed());
			home = VS.getAssertNoUsersFound().getText();
			System.out.println(home);

			actual = "'No users found' is displayed if the search data is not found in the list of users for Contributor orgadmin" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("No users found.", homeText, expect, actual);
		}
	}
	
	public static void validateContributorOrgReviewerIsAbleToEditNameOfContentAndSave(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " The list of uploaded contents should be displayed on contents tab with open button in project details page for Contributor orgreviewer.";
		String actual =  "The list of uploaded contents is not displayed on contents tab with open button in project details page for Contributor orgreviewer.";

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
		
			home = VO.getClkOpenBtnNoRC().getText();
			System.out.print(home);
			
			actual = " The list of uploaded contents is displayed on contents tab with open button in project details page for Contributor orgreviewer.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Open" ,homeText, expect, actual);
		}
	}
	
	
	public static void openAndNominateUploadWithoutTC(String ProjectName) throws Exception {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = ProjectName + " Nomination is sent Successfully";
		String actual = ProjectName + " Nomination is not sent Successfully";
		try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
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
		
//		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
//		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadSample());
		
//		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		
//		VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//		Thread.sleep(2000);
//		VO.getClkCheckBox().click();
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());
		VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
		
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
	
	
	public static void validateContributorAbleToUploadContentAndSaveAsDraft(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Contributor should be able to upload the content and add all the details in the edit details pop up and save it as Draft content.";
		String actual =  "contributor should be able to upload the content and add all the details in the edit details pop up and is not save it as Draft content.";

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
			
			home = VO.getAssertSaveAsDraftNoTC().getText();
			System.out.print(home);
			
			
			actual = "contributor should be able to upload the content and add all the details in the edit details pop up and is save it as Draft content.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Draft" ,homeText, expect, actual);
	}
}

	
	public static String createProjectWithoutTargetCollectionAllContentTypes() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
		VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
		VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
		VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
		VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());

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
	
	public static void validateListOfContentTypesWhichContributorAsNominatedIsDisplayedInPopUp(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " list of content types which contributor as nominated should be displayed in content types pop up.";
		String actual =  "list of content types which contributor as nominated is not displayed in content types pop up.";

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

			Assert.assertTrue(VO.getSeltextBook().isDisplayed());
			Assert.assertTrue(VO.getSelCourseAssessment().isDisplayed());
			Assert.assertTrue(VO.getSelLearningRes().isDisplayed());
			Assert.assertTrue(VO.getSelPractQSet().isDisplayed());
			Assert.assertTrue(VO.getSelExpContent().isDisplayed());
			Assert.assertTrue(VO.getSelTeacherRes().isDisplayed());
			Thread.sleep(3000);

			home = VO.getSelTeacherRes().getText();
			System.out.print(home);
			
			actual = "list of content types which contributor as nominated is displayed in content types pop up.";
		} finally {
			String homeText = home != null ? home: "N/A";
			Listeners.customAssert("Teacher Resource" ,homeText, expect, actual);
	}
}
	
	
	public static void openAndNominateWithoutTargetCollectionAllTypes(String ProjectName) throws InterruptedException {
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
//		VDNUtils.waitToBeClickableAndClick(VO.getSelectContetCheckbox());
		VDNUtils.waitToBeClickableAndClick(VO.getCheckCorseAssesment());

		VDNUtils.waitToBeClickableAndClick(VO.getCheckETextBook());
		VDNUtils.waitToBeClickableAndClick(VO.getCheckLearningRes());
		VDNUtils.waitToBeClickableAndClick(VO.getCheckQuestionSet());

		VDNUtils.waitToBeClickableAndClick(VO.getCheckEContent());
		VDNUtils.waitToBeClickableAndClick(VO.getCheckTeachingRes());
		VDNUtils.waitToBeClickableAndClick(VO.getClkbtnSelectedContent());

		Thread.sleep(3000);
		Assert.assertTrue(VO.getAssertSelectedCTMsg().isDisplayed());
		Thread.sleep(5000);

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
	
	public static void validateContributionOrgReviewerIsAbleToRequestChangeCorrectedContent(String ProjectName)
			throws Exception {
		String home = null;
		String expect = "program contributor should be able to upload and resubmit the rejected content.";
		String actual =  "program contributor is unable to upload and resubmit the rejected content.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			
			VDNUtils.waitForElementToBeVisible(VC.getClkOpenNotAccepted());
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenNotAccepted());
			
			VDNUtils.waitForElementToBeVisible(VC.getClkReplaceBtn());
			VDNUtils.waitToBeClickableAndClick(VC.getClkReplaceBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
						
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());

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
			
			home = VO.getAssertReviewPending().getText();
			
			
			actual = "program contributor is able to upload and resubmit the rejected content.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	public static void validateSourcingOrgAdminIsAbleToSendBackToCorrectionTheContentFromWithoutTargetCollectionProject(String ProjectName) throws InterruptedException {
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
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
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
	
		
			VDNUtils.waitForElementToBeVisible(VC.getAssertCorrPenNoTC1());
			Assert.assertTrue(VC.getAssertCorrPenNoTC1().isDisplayed());
			
			
			home = VC.getAssertCorrPenNoTC1().getText();
			actual = "sourcing org admin is able to send back to correction the content for The Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Corrections pending", homeText, expect, actual);
		}

	}	
	
	public static void validateAssignedContributorAbleToEditAndSubmitPendingCorrectionContentForReview(String ProjectName)
			throws Exception {
		String home = null;
		String expect = "program contributor should be able to edit and submit the pending correction content for review";
		String actual =  "program contributor is unable to edit and submit the pending correction content for review";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
			
			VDNUtils.waitForElementToBeVisible(VC.getClkOpenCorrPen());
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenCorrPen());
			
			VDNUtils.waitForElementToBeVisible(VC.getClkReplaceBtn());
			VDNUtils.waitToBeClickableAndClick(VC.getClkReplaceBtn());
			
		
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			

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
			
			home = VO.getAssertReviewPending().getText();
					
			actual = "program contributor is able to edit and submit the pending correction content for review";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	public static void verifyContentStatusOnTocPageIsApprovedForIndContributor(String ProjectName) throws InterruptedException {
		String home = null;
		String expect = "Content status on toc page should be 'Approved' for Individual contributor when source or Approve the content.";
		String actual =  "Content status on toc page is not 'Approved' for Individual contributor when source or Approve the content.";
		
		String home2 = null;
		String expect2 = "Move/remove option should not be available against the approved content.";
		String actual2 =  "Move/remove option is available against the approved content.";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
//			String s4 = " ']//following::span[text()='Pending'][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitForElementToBeVisible(VC.getClkUploadCont());
			VDNUtils.waitToBeClickableAndClick(VC.getClkUploadCont());
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovedOnTOC());
			
			Assert.assertTrue(VC.getAssertApprovedOnTOC().isDisplayed());
			
			home = VC.getAssertApprovedOnTOC().getText();	
			System.out.println(home);
			actual = "Content status on toc page is 'Approved' for Individual contributor when source or Approve the content.";
			
			String tabDetails = VC.getAssertApprovedRow().getText();
			
			String[] lines = tabDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Move");
			    Assert.assertNotEquals(line,"Delete");
			}
			
			home2 = VC.getAssertApprovedOnTOC().getText();	
			System.out.println(home);
			actual2 = "Move/remove option should not be available against the approved content.";
			
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approved" ,homeText, expect, actual);
			System.out.println(homeText);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Approved" ,homeText2, expect2, actual2);
			System.out.println(homeText2);

		}
	}
	
	public static void validateContributorOrgreviewerIsAbleToReviewContentAndDetailsInViewDetails(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Contributor orgreviewer should be able to review the content and details in the view details pop up.";
		String actual =  "Contributor orgreviewer is unable to review the content and details in the view details pop up.";

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
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(3000);

			
			VDNUtils.waitForElementToBeVisible(VO.getAssertEditDetails());
			Assert.assertTrue(VO.getAssertEditDetails().isDisplayed());
			home = VO.getAssertEditDetails().getText();
			System.out.println(home);
			
			actual = "Contributor orgreviewer is able to review the content and details in the view details pop up.";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Edit details" ,homeText, expect, actual);
		}
	}
	
	public static void verifyCorrectContentFromSourceOrg(String ProjectName) throws InterruptedException {
//		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home1 = null;
		String expect1 = "sourcing orgadmin should able to Approve for the Project "+ProjectName+" under View Contribution";
		String actual1 = "sourcing orgadmin is unable to Approve for the Project "+ProjectName+" under View Contribution";
		
//		String home2 = null;
//		String expect2 = "sourcing orgadmin should able to Reject for the Project "+ProjectName+" under View Contribution";
//		String actual2 = "sourcing orgadmin is unable to Reject for the Project "+ProjectName+" under View Contribution";
//		
//		String home3 = null;
//		String expect3 = "sourcing orgadmin should able to Send for Correction for the Project "+ProjectName+" under View Contribution";
//		String actual3 = "sourcing orgadmin is unable to Send for Correction for the Project "+ProjectName+" under View Contribution";
		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1])[3]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollection());
			Thread.sleep(5000);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
//			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertNominationTab());
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
//			
//			VDNUtils.waitForElementToBeVisible(VS.getClkNomViewContr());
//			VDNUtils.waitToBeClickableAndClick(VS.getClkNomViewContr());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtn2());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtn2());
			Thread.sleep(3000);
			
//			VDNUtils.waitForElementToBeVisible(VS.getClkOpenSample1());
//			VDNUtils.waitToBeClickableAndClick(VS.getClkOpenSample1());

			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
//			VO.getClkPublish().click();
//			Thread.sleep(2000);
			
//			VDNUtils.waitForElementToBeVisible(VS.getAssertPublishToastMsg());
//			Assert.assertTrue(VS.getAssertPublishToastMsg().isDisplayed());
			
//			home1 = VS.getAssertPublishToastMsg().getText();
//			System.out.println(home1);
//			actual1 = "sourcing orgadmin is able to Approve for the Project "+ProjectName+" under View Contribution";
//			
//			for(int i=0;i<3;i++) {
//				VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//				Thread.sleep(2000);
//				VDNUtils.waitForElementToBeVisible(VS.getClkNomViewContr());
//				VDNUtils.waitToBeClickableAndClick(VS.getClkNomViewContr());
//			}	
//			
//			Assert.assertTrue(VS.getAssertApprovedMsg().isDisplayed());	
//			VDNUtils.waitForElementToBeVisible(VS.getClkOpenSample2());
//			VDNUtils.waitToBeClickableAndClick(VS.getClkOpenSample2());
//
//			Thread.sleep(5000);
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
//			VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
//			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());	
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
//			Thread.sleep(3000);
//			
//			VDNUtils.waitForElementToBeVisible(VS.getAssertRejectToastMsg());
//			Assert.assertTrue(VS.getAssertRejectToastMsg().isDisplayed());
//			
//			home2 = VS.getAssertRejectToastMsg().getText();
//			System.out.println(home2);
//			actual2 = "sourcing orgadmin is able to Reject for the Project "+ProjectName+" under View Contribution";
//			for(int i=0;i<3;i++) {
//				VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//				Thread.sleep(2000);
//				VDNUtils.waitForElementToBeVisible(VS.getClkNomViewContr());
//				VDNUtils.waitToBeClickableAndClick(VS.getClkNomViewContr());
//			}	
			
//			Assert.assertTrue(VS.getAssertRejectedMsg().isDisplayed());
//			
//			VDNUtils.waitForElementToBeVisible(VS.getClkOpenSample3());
//			VDNUtils.waitToBeClickableAndClick(VS.getClkOpenSample3());
//
//			Thread.sleep(5000);
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
//			VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
//			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VS.getAssertCorrectioToastMsg());
			Assert.assertTrue(VS.getAssertCorrectioToastMsg().isDisplayed());
			
			home1 = VS.getAssertCorrectioToastMsg().getText();
			System.out.println(home1);
			actual1 = "sourcing orgadmin is able to Send For Correction for the Project "+ProjectName+" under View Contribution";
			
//			for(int i=0;i<3;i++) {
//				VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//				Thread.sleep(2000);
//				VDNUtils.waitForElementToBeVisible(VS.getClkNomViewContr());
//				VDNUtils.waitToBeClickableAndClick(VS.getClkNomViewContr());
//			}	
			
			Assert.assertTrue(VS.getAssertCorrectionMsg1().isDisplayed());

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Content is successfully approved", homeText1, expect1, actual1);
			
//			String homeText2 = home2 != null ? home2 : "N/A";
//			Listeners.customAssert("Content is successfully rejected", homeText2, expect2, actual2);
//			
//			String homeText3 = home3 != null ? home3 : "N/A";
//			Listeners.customAssert("Content sent for corrections", homeText3, expect3, actual3);
		}

	}
	
	public static void verifySendForRevPostCorrection(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " contribution org contributor should be able to Submit Fpr Review Post Correction";
		String actual =  "contribution org contributor is unable to Submit Fpr Review Post Correction";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(3000);

//			Assert.assertTrue(VO.getClkCreateOrUploadBtn().isDisplayed());
//
//			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			
//			Thread.sleep(3000);
//			UploadContentMethods.UploadPdf();
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample1");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getContentSavedtMessage());
//			Assert.assertTrue(VO.getContentSavedtMessage().isDisplayed());
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertSaveAsDraftNoTC());
//			Assert.assertTrue(VO.getAssertSaveAsDraftNoTC().isDisplayed());
//			String stausDraft = VO.getAssertSaveAsDraftNoTC().getText();
//			Assert.assertEquals(stausDraft,"Draft");			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			
//			Thread.sleep(3000);
//			UploadContentMethods.UploadPdf();
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenCorBtn());
			Thread.sleep(3000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample2");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
//			
//			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
//			
//			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
//			String stausReviewPending = VO.getAssertReviewPending().getText();
//			Assert.assertEquals(stausReviewPending,"Review Pending");
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			
//			Thread.sleep(3000);
//			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample3");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			home = VO.getAssertReviewPending().getText();
			
			
			actual = "contribution org contributorr is able to Submit For Review Post Correction";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	public static void validateAssignedReviewerIsAbleApproveReqChangesNoTCPostCor(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " contribution or reviewer should be able to submit for approval  the corrected content";
		String actual =  "contribution or reviewer is unable to submit for approval  the corrected content.";

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
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
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
			
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnNoRC());
//			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
//			Thread.sleep(3000);
//			
//			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
//			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
//			VDNUtils.waitToBeClickableAndClick(VO.getClkRequestChanges());
			
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Request");
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
//			Thread.sleep(3000);
//			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertNotAcceptedOnRC());
//			Assert.assertTrue(VO.getAssertNotAcceptedOnRC().isDisplayed());
//			String stausNotAcceptedOnRC = VO.getAssertNotAcceptedOnRC().getText();
//			Assert.assertEquals(stausNotAcceptedOnRC,"Not Accepted");	
			
			actual = "contribution or reviewer is able to submit for approval the corrected content.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static void validateAssignedReviewerIsAbleRequestChangeTheCorrectedContent(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " contribution or reviewer should be able to request change the corrected content";
		String actual =  "contribution or reviewer is unable to request change the corrected content.";

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

			
			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnNoRC());
			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
			Thread.sleep(3000);
			
			
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

			home = VO.getAssertNotAcceptedOnRC().getText();
			System.out.print(home);
			
			actual = "contribution or reviewer is able to request change the corrected content.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Not Accepted" ,homeText, expect, actual);
		}
	}
}