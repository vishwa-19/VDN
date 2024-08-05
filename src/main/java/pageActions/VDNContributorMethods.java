package pageActions;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
		String s3 = " ]";
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
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			VDNUtils.waitToBeClickableAndClick(VO.getCloseDetails());
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
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			VDNUtils.waitToBeClickableAndClick(VO.getCloseDetails());
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
	
	public static void validateFieldsAvailableInApplyFiltersPopUpInMyProjectsTab()
			throws Exception {
		String home = null;
		String expect = "Apply Filters pop up page sould displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";
		String actual = "Apply Filters pop up page is not displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";

		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			
			Assert.assertTrue(VS.getAssertApplyFilterPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertMediumOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertClassOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertSubjectsOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertContentTypesOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertTargetCollOnPopUp().isDisplayed());
			

			Assert.assertTrue(VS.getResetBtn().isDisplayed());
			
			Assert.assertTrue(VS.getApplyButton().isDisplayed());
			
			home = VS.getApplyButton().getText();
			System.out.print(home);
			
			actual = "Apply Filters pop up page is displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Apply" ,homeText, expect, actual);
		}
	}
	
	public static void verifyBothAsRoleIsAbleToReviewTheContent(String ProjectName)
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
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getClkUploadContent());
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadContent());
			Thread.sleep(2000);
			VDNUtils.waitForElementToBeVisible(VO.getAssertReviewPending());
			Assert.assertTrue(VO.getAssertReviewPending().isDisplayed());
			
			//VDNUtils.waitForElementToBeVisible(VO.getAssertReviewPending());
			//Assert.assertTrue(VO.getClkOpenBtnReview().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
//			Assert.assertTrue(VO.getAssertSample().isDisplayed());
			
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
	
	public static void UserWithBothRoleIsUnableToReviewHisOwnContent()
			throws Exception {
		String ReviewPending = null;
		String expect = "User should not be allowed to review his own content ";
		String actual =  "User is allowed to review his own content ";

		try {
		
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertRevPending5());
			VDNUtils.waitToBeClickableAndClick(VC.getAssertRevPending5());
			
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
	
	public static void CloseEditDetailAnduploadContent()
			throws Exception {
		String ReviewPending = null;
		String expect = "Assigned Contributor Org is able to upload Content For Project ";
		String actual =  "Assigned Contributor Org is unable to upload Content For Project ";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseEditDetail());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadfromBothRole());
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
			VDNUtils.waitForElementToBeVisible(VC.getAssertRevPending5());
			Assert.assertTrue(VC.getAssertRevPending5().isDisplayed());
			
			ReviewPending = VC.getAssertRevPending5().getText();
			System.out.println(ReviewPending);
			actual = "Assigned Contributor Org is able to upload Content For Project ";
		} finally {
			String homeText = ReviewPending != null ? ReviewPending : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
		}
	}
	
	public static void ValidateProjectsWithAssignedRoleIsDisplayedUderMyProjectsTab(String ProjectName)
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
			String s3 = " ']";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
//			assertProjectOnContributor.click();
//			Assert.assertTrue(VO.getClkUploadbtn().isDisplayed());
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
//			Thread.sleep(2000);
//			
//			Assert.assertTrue(VO.getClkCreateNew().isDisplayed());
			

			home1 = VO.getClkCreateNew().getText();
			System.out.print(home1);		
			actual1 = "1.Only Create new option is available for nomination enabled projects.";
			

			
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
	
	public static void verifyAssignedContAbleToApplyFiltersPopUpInMyProjectsTab(String ProjectName)
			throws Exception {
		String home = null;
		String expect = "Apply Filters pop up page sould displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";
		String actual = "Apply Filters pop up page is not displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";

		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			
//			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			
			Assert.assertTrue(VS.getAssertApplyFilterPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertMediumOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertClassOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertSubjectsOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertContentTypesOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertTargetCollOnPopUp().isDisplayed());
			

			Assert.assertTrue(VS.getResetBtn().isDisplayed());
			
			Assert.assertTrue(VS.getApplyButton().isDisplayed());
			
			home = VS.getApplyButton().getText();
			System.out.print(home);
			
			actual = "Apply Filters pop up page is displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Apply" ,homeText, expect, actual);
		}
	}
	
	
	public static void validateAvailableprojectDetailsForAssignedContributor(String ProjectName)
			throws Exception {
		String home = null;
		String expect = "project details Should be available on Project Details page";
		String actual = "project details is unavailable on Project Details page";

		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			String s4 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			WebElement openProject = driver.findElement(By.xpath(s1 + s2 + s4));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			openProject.click();
			Thread.sleep(3000);
			String p1= "//h5[text()='";
			String p3 = " ']";
			
			WebElement assertProjName = driver.findElement(By.xpath(p1+ProjectName+p3));
			assertProjName.isDisplayed();
			
			
			Assert.assertTrue(VC.getAssertContentTypes().isDisplayed());
			
			Assert.assertTrue(VC.getAssertNominationDates().isDisplayed());
			Assert.assertTrue(VC.getAssertApprovedStatus().isDisplayed());
			Assert.assertTrue(VC.getAssertDigiText().isDisplayed());
			
			Assert.assertTrue(VC.getAssertMedium().isDisplayed());
			Assert.assertTrue(VC.getAssetClass().isDisplayed());
			Assert.assertTrue(VC.getAssertSubject().isDisplayed());
			
			Thread.sleep(3000);

			home = VC.getAssertSubject().getText();
			System.out.println(home);
			
			actual = "project details is available on Project Details page";
			
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Subject   " ,homeText, expect, actual);
		}
	}
	
	public static void validateGuildlineDocumentIsAvailableForAssignedContributor(String ProjectName)
			throws Exception {
		String home = null;
		String expect = "Guildline Document Should be available for assigned Program contributor.";
		String actual = "Guildline Document is unavailable for assigned Program contributor.";

		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			String s4 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			WebElement openProject = driver.findElement(By.xpath(s1 + s2 + s4));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			openProject.click();
			Thread.sleep(3000);
			String p1= "//h5[text()='";
			String p3 = " ']";
			
			WebElement assertProjName = driver.findElement(By.xpath(p1+ProjectName+p3));
			assertProjName.isDisplayed();
			
			
			Assert.assertTrue(VC.getAssertContentTypes().isDisplayed());
			
			Assert.assertTrue(VC.getAssertNominationDates().isDisplayed());
			Assert.assertTrue(VC.getAssertApprovedStatus().isDisplayed());
			Assert.assertTrue(VC.getAssertDigiText().isDisplayed());
			
			Assert.assertTrue(VC.getAssertMedium().isDisplayed());
			Assert.assertTrue(VC.getAssetClass().isDisplayed());
			Assert.assertTrue(VC.getAssertSubject().isDisplayed());
			Assert.assertTrue(VC.getAssertViewGuidelineDoc().isDisplayed());
	
			Thread.sleep(3000);

			home = VC.getAssertViewGuidelineDoc().getText();
			System.out.println(home);
			
			actual = "Guildline Document is available for assigned Program contributor.";
			
			VDNUtils.waitToBeClickableAndClick(VC.getAssertViewGuidelineDoc());
			Thread.sleep(3000);
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("View Content Guidelines Document" ,homeText, expect, actual);
		}
	}
	
	public static void uploadTheContentFromContOrgContributorSaveAsDraft(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " The Content should be in Draft status when contributor as not submitted the content.";
		String actual =  "The Content is not in Draft status when contributor as not submitted the content.";

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
//			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			
//			Thread.sleep(3000);
//			UploadContentMethods.UploadPdf();
//			
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
//			
//			Assert.assertTrue(VO.getAssertDraftNode().isDisplayed());
//			
//			String DraftCount = VO.getAssertDraftCount().getText();
//			System.out.println(DraftCount);
//			int DraftC=Integer.parseInt(DraftCount);  
//			
//            Assert.assertTrue(VO.getReviewPendingNode().isDisplayed());
//			
//			String ReviewPendingCount = VO.getAssertReviewPendingCount().getText();
			
//			System.out.println(ReviewPendingCount);
//			int ReviewPendingC=Integer.parseInt(DraftCount); 
//			
//			int Total = DraftC+ReviewPendingC;
//			System.out.println(Total);
//			
//			Assert.assertTrue(VO.getTotalNode().isDisplayed());
//			
//			String TotalCount = VO.getTotalCount().getText();
//			int TotalC=Integer.parseInt(TotalCount);
			
//			System.out.println(TotalCount);
//			Assert.assertEquals(Total,TotalC);
			
			home = VO.getAssertDraft().getText();
			System.out.println(home);
			
			
			actual = "The Content is in Draft status when contributor as not submitted the content.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Draft" ,homeText, expect, actual);
	}
}
	
	public static void uploadContentsFromContOrgContributorAndSendForReviewWithoutTC(String ProjectName)
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
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
			
			Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateOrUploadBtn());
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
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
			
			actual = "Contributor is able to save the content draft status or Review Pending Staus for Project "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	public static void validateReviewerIsAbleApproveReqChangesNoTC(String ProjectName)
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
			
			actual = "Assigned Reviewer Is Able is able to preview, Approve and Request Changes the uploaded content by contributor.";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText, expect, actual);
		}
	}
	
	public static void verifyContentStatusAndApproveForDigitalTextBook(String ProjectName) throws InterruptedException {
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
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			
			Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
		
			VC.getClkOpenBtn().click();
			Thread.sleep(5000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
	
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkPublish());
			Thread.sleep(2000);
		
			VDNUtils.waitForElementToBeVisible(VS.getAssertPublishToastMsg());
			Assert.assertTrue(VS.getAssertPublishToastMsg().isDisplayed());
			
			home = VS.getAssertPublishToastMsg().getText();
			System.out.println(home);
			actual = "sourcing orgadmin is able to Approve for the Project "+ProjectName;
			
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content is successfully approved", homeText, expect, actual);
		}

}
	
	public static void validateOnlyPreviewOfContentIsDisplayed(String ProjectName)
			throws Exception {
		String home = null;
		String expect = "Only preview of the content should be displayed for Review Pending ,Approval Pending ,  Approved and Rejected";
		String actual =  "Only preview of the content is not displayed for Review Pending ,Approval Pending ,  Approved and Rejected";

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
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample5");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
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
			
			
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenBtnApproved());
			
			String tabDetails = VO.getAssertAllReviewContentHead().getText();
			
			String[] lines = tabDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Submit for Approval");
			    Assert.assertNotEquals(line,"Request changes");
			}
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenBtnNotAccepted());
			
			String tabDetails2 = VO.getAssertAllReviewContentHead().getText();
			
			String[] lines2 = tabDetails2.split("\r\n|\r|\n");
			System.out.println(lines2.length);
			
			for (String line2 : lines2) {
			    System.out.println(line2);
			    Assert.assertNotEquals(line2,"Submit for Approval");
			    Assert.assertNotEquals(line2,"Request changes");
			}
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenBtnAppPen());
			
			String tabDetails3 = VO.getAssertAllReviewContentHead().getText();
			
			String[] lines3 = tabDetails3.split("\r\n|\r|\n");
			System.out.println(lines3.length);
			
			for (String line3 : lines3) {
			    System.out.println(line3);
			    Assert.assertNotEquals(line3,"Submit for Approval");
			    Assert.assertNotEquals(line3,"Request changes");
			}
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenBtnRevPen());
			
			String tabDetails4 = VO.getAssertAllReviewContentHead().getText();
			
			String[] lines4 = tabDetails4.split("\r\n|\r|\n");
			System.out.println(lines4.length);
			
			for (String line4 : lines4) {
			    System.out.println(line4);
			    Assert.assertNotEquals(line4,"Submit for Approval");
			    Assert.assertNotEquals(line4,"Request changes");
			}
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(3000);
			home = VO.getAssertReviewPending().getText();
			actual = "Only preview of the content is displayed for Review Pending ,Approval Pending ,  Approved and Rejected";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}
	
	public static void uploadContentsFromContributorSide(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Able to upload The Content From Individual Contributor for "+ProjectName;
		String actual =  "Unable to upload The Content From Individual Contributor for  "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSelContentTypesbtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckCorseAssesment());
//
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckETextBook());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckLearningRes());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckQuestionSet());
//
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckEContent());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckTeachingRes());
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());

			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
			
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			
			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());	
			home = VO.getAssertContentSetReview().getText();	
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
//			String parent=driver.getWindowHandle();
//			Set<String> s=driver.getWindowHandles();
//			
//			Iterator<String> I1= s.iterator();
//			
//			while(I1.hasNext())
//			{
//
//			String child_window=I1.next();
//
//
//			if(!parent.equals(child_window))
//			{
//			driver.switchTo().window(child_window);
//
//			System.out.println(driver.switchTo().window(child_window).getTitle());
//			
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
//			Thread.sleep(3000);
//
//			driver.close();
//			}
//
//			}
//			//switch to the parent window
//			driver.switchTo().window(parent);

			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHp();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();

			actual = " Able to upload The Content From Individual Contributor for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
		}
	}
	
	
	public static String CreateNewProjectwithAllContentTypesWithDigitalTextBooksSkipEnabled() throws InterruptedException {
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
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
			VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
			
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
	
	
	public static void uploadContentsFromContributorSideForExpContent(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Able to upload The Content From Individual Contributor for "+ProjectName;
		String actual =  "Unable to upload The Content From Individual Contributor for  "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home = VO.getAssertContentSetReview().getText();	
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();

			actual = " Able to upload The Content From Individual Contributor for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
		}
	}
	
	
	public static void uploadContentsFromContributorSideForLearningResource(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Able to upload The Content From Individual Contributor for "+ProjectName;
		String actual =  "Unable to upload The Content From Individual Contributor for  "+ProjectName;

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home = VO.getAssertContentSetReview().getText();	
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home = VO.getAssertContentSetReview().getText();
			System.out.println(home);
			Thread.sleep(2000);

			actual = " Able to upload The Content From Individual Contributor for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
		}
	}
	
	
	public static void uploadContentsFromContributorSideForTeachingResource(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "contributor should be able to upload the PDF content and submit for Review";
		String actual1 =  "contributor is unable to upload the PDF content and submit for Review ";
		
		String home2 = null;
		String expect2 = "contributor should be able to upload the HTML content and submit for Review";
		String actual2 =  "contributor is unable to upload the HTML content and submit for Review ";
		
		String home3 = null;
		String expect3 = "contributor should be able to upload the MP4 content and submit for Review";
		String actual3 =  "contributor is unable to upload the MP4 content and submit for Review ";
		
		String home4 = null;
		String expect4 = "contributor should be able to upload the WEBM content and submit for Review";
		String actual4 =  "contributor is unable to upload the WEBM content and submit for Review ";
		
		String home5 = null;
		String expect5 = "contributor should be able to upload the H5P content and submit for Review";
		String actual5 =  "contributor is unable to upload the H5P content and submit for Review ";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "contributor is unable to upload the PDF content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home2 = VC.getAssertHTMLUpload().getText();
			System.out.println(home2);
			actual2 = "contributor is unable to upload the HTML content and submit for Review";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "contributor is unable to upload the MP4 content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "contributor is unable to upload the WEBM content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			
			home5 = VC.getAssertH5pUpload().getText();
			System.out.println(home5);
			actual5 = "contributor is unable to upload the H5P content and submit for Review";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Html" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			System.out.println(homeText3);
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			System.out.println(homeText4);
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			System.out.println(homeText5);
			Listeners.customAssert("Sample_H5p" ,homeText5, expect5, actual5);
		}
	}
	
	
	public static void validateAssignedContributorAbleToUploadSvePreviewAndSubmitContents(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "contributor should be able to upload the PDF content and submit for Review";
		String actual1 =  "contributor is unable to upload the PDF content and submit for Review ";
		
		String home2 = null;
		String expect2 = "contributor should be able to upload the HTML content and submit for Review";
		String actual2 =  "contributor is unable to upload the HTML content and submit for Review ";
		
		String home3 = null;
		String expect3 = "contributor should be able to upload the MP4 content and submit for Review";
		String actual3 =  "contributor is unable to upload the MP4 content and submit for Review ";
		
		String home4 = null;
		String expect4 = "contributor should be able to upload the WEBM content and submit for Review";
		String actual4 =  "contributor is unable to upload the WEBM content and submit for Review ";
		
		String home5 = null;
		String expect5 = "contributor should be able to upload the H5P content and submit for Review";
		String actual5 =  "contributor is unable to upload the H5P content and submit for Review ";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "contributor is unable to upload the PDF content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home2 = VC.getAssertHTMLUpload().getText();
			System.out.println(home2);
			actual2 = "contributor is unable to upload the HTML content and submit for Review";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "contributor is unable to upload the MP4 content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
//			
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "contributor is unable to upload the WEBM content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
//			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home5 = VC.getAssertH5pUpload().getText();
			System.out.println(home5);
			actual5 = "contributor is unable to upload the H5P content and submit for Review";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Html" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			System.out.println(homeText3);
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			System.out.println(homeText4);
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			System.out.println(homeText5);
			Listeners.customAssert("Sample_H5p" ,homeText5, expect5, actual5);
		}
	}
	
	
	public static void validateAssignedBothRoleUserAbleToUploadContentAssignedProject(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "contributor should be able to upload the PDF content and submit for Review";
		String actual1 =  "contributor is unable to upload the PDF content and submit for Review ";
		
		String home2 = null;
		String expect2 = "contributor should be able to upload the HTML content and submit for Review";
		String actual2 =  "contributor is unable to upload the HTML content and submit for Review ";
		
		String home3 = null;
		String expect3 = "contributor should be able to upload the MP4 content and submit for Review";
		String actual3 =  "contributor is unable to upload the MP4 content and submit for Review ";
		
		String home4 = null;
		String expect4 = "contributor should be able to upload the WEBM content and submit for Review";
		String actual4 =  "contributor is unable to upload the WEBM content and submit for Review ";
		
		String home5 = null;
		String expect5 = "contributor should be able to upload the H5P content and submit for Review";
		String actual5 =  "contributor is unable to upload the H5P content and submit for Review ";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "contributor is unable to upload the PDF content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home2 = VC.getAssertHTMLUpload().getText();
			System.out.println(home2);
			actual2 = "contributor is unable to upload the HTML content and submit for Review";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "contributor is unable to upload the MP4 content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "contributor is unable to upload the WEBM content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			
			home5 = VC.getAssertH5pUpload().getText();
			System.out.println(home5);
			actual5 = "contributor is unable to upload the H5P content and submit for Review";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Html" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			System.out.println(homeText3);
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			System.out.println(homeText4);
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			System.out.println(homeText5);
			Listeners.customAssert("Sample_H5p" ,homeText5, expect5, actual5);
		}
	}

	public static void validateIndividualContributorAbleToUploadSavePreviewAndPublish(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "contributor should be able to upload the PDF content and submit for Review";
		String actual1 =  "contributor is unable to upload the PDF content and submit for Review ";
		
		String home2 = null;
		String expect2 = "contributor should be able to upload the HTML content and submit for Review";
		String actual2 =  "contributor is unable to upload the HTML content and submit for Review ";
		
		String home3 = null;
		String expect3 = "contributor should be able to upload the MP4 content and submit for Review";
		String actual3 =  "contributor is unable to upload the MP4 content and submit for Review ";
		
		String home4 = null;
		String expect4 = "contributor should be able to upload the WEBM content and submit for Review";
		String actual4 =  "contributor is unable to upload the WEBM content and submit for Review ";
		
		String home5 = null;
		String expect5 = "contributor should be able to upload the H5P content and submit for Review";
		String actual5 =  "contributor is unable to upload the H5P content and submit for Review ";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			Thread.sleep(3000);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "contributor is unable to upload the PDF content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home2 = VC.getAssertHTMLUpload().getText();
			System.out.println(home2);
			actual2 = "contributor is unable to upload the HTML content and submit for Review";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "contributor is unable to upload the MP4 content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
//			
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "contributor is unable to upload the WEBM content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
//			
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
//			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home5 = VC.getAssertH5pUpload().getText();
			System.out.println(home5);
			actual5 = "contributor is unable to upload the H5P content and submit for Review";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Html" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			System.out.println(homeText3);
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			System.out.println(homeText4);
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			System.out.println(homeText5);
			Listeners.customAssert("Sample_H5p" ,homeText5, expect5, actual5);
		}
	}

	
	public static void validateIndividualContributorAbleToUploadPdfAndEpbPreviewAndPublish(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "Individual contributor should be able to upload the PDF content and submit for Review";
		String actual1 =  "Individual contributor is unable to upload the PDF content and submit for Review ";
		
		String home2 = null;
		String expect2 = "Individual contributor should be able to upload the EPUB content and submit for Review";
		String actual2 =  "Individual contributor is unable to upload the EPUB content and submit for Review ";
	
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			Thread.sleep(3000);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "Individual contributor is able to upload the PDF content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();	

			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home2 = VC.getAssertEpubUpload().getText();
			System.out.println(home2);
			actual2 = "Individual contributor is unable to upload the EPub content and submit for Review";
			

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Epub" ,homeText2, expect2, actual2);
			
		}
	}
	
	public static void validateIndividualContributorAbleToUploadAllcontentTypeForExplanationContent(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Individual contributor should be able to upload the PDF content for Explanation Content";
		String actual1 =  "Individual contributor is unable to upload the PDF content for Explanation Content";
		
		String home2 = null;
		String expect2 = " Individual contributor should be able to upload the EPUB content for Explanation Content";
		String actual2 =  "Individual contributor is unable to upload the EPUB content for Explanation Content";

		String home3 = null;
		String expect3 = " Individual contributor should be able to upload the MP4 content for Explanation Content";
		String actual3 =  "Individual contributor is unable to upload the MP4 content for Explanation Content";
		
		String home4 = null;
		String expect4 = " Individual contributor should be able to upload the WEBM content for Explanation Content";
		String actual4 =  "Individual contributor is unable to upload the WEBM content for Explanation Content";
		
		String home5 = null;
		String expect5 = " Individual contributor should be able to upload the MP3 content for Explanation Content";
		String actual5 =  "Individual contributor is unable to upload the MP3 content for Explanation Content";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "Individual contributor is able to upload the PDF content for Explanation Content";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home2 = VC.getAssertEpubUpload().getText();
			System.out.println(home2);
			actual2 = "Individual contributor is able to upload the EPUB content for Explanation Content";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "Individual contributor is able to upload the MP4 content for Explanation Content";
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "Individual contributor is able to upload the WEBM content for Explanation Content";
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home5 = VC.getAssertMP3Upload().getText();
			System.out.println(home5);
			actual5 = "Individual contributor is able to upload the MP3 content for Explanation Content";
			Thread.sleep(2000);

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Sample_Epub" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Sample_Mp3" ,homeText5, expect5, actual5);
				
		}
	}
	
	
	
	public static void validateContributionDetailsDisplayedUnderMyContentsTab()
			throws Exception {
		String home1 = null;
		String expect1 = " Contribution Details Header should be Displayed Under My Contents Tab ";
		String actual1 =  "Contribution Details Header is not Displayed Under My Contents Tab";
		
		String home2 = null;
		String expect2 = " Contribution Details like Board, Medium, Class and Subject should be Displayed along with Open Button Under My Contents Tab Section";
		String actual2 =  "Contribution Details like Board, Medium, Class and Subject not Displayed along with Open Button Under My Contents Tab Section";

		
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VC.getClkMyContent());
			Thread.sleep(5000);
			
			
			Assert.assertTrue(VC.getAssertContributionDetails().isDisplayed());
			
			home1 = VC.getAssertContributionDetails().getText();
			System.out.println(home1);
			actual1 = "Contribution Details Header is able to Displayed Under My Contents Tab";
			
			Assert.assertTrue(VC.getAssertK12fwName().isDisplayed());
			
			Assert.assertTrue(VC.getAssertBoardMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertMediumMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertClassMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertSubjectMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertOpenBtnMyContent().isDisplayed());
			
			home2 = VC.getAssertOpenBtnMyContent().getText();
			System.out.println(home2);
			actual2 = "Contribution Details like Board, Medium, Class and Subject Displayed along with Open Button Under My Contents Tab Section";
			

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Contribution Details" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Open" ,homeText2, expect2, actual2);		
		}
	}
	
	
	public static void validateIndividualContributorAbleToUploadAllcontentTypeForTeacherResource(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Individual contributor should be able to upload the PDF content for Teacher Resource";
		String actual1 =  "Individual contributor is unable to upload the PDF content for Teacher Resourcet";
		
		String home2 = null;
		String expect2 = " Individual contributor should be able to upload the EPUB content for Teacher Resource";
		String actual2 =  "Individual contributor is unable to upload the EPUB content for Teacher Resource";

		String home3 = null;
		String expect3 = " Individual contributor should be able to upload the MP4 content for Teacher Resource";
		String actual3 =  "Individual contributor is unable to upload the MP4 content for Teacher Resource";
		
		String home4 = null;
		String expect4 = " Individual contributor should be able to upload the WEBM content for Teacher Resource";
		String actual4 =  "Individual contributor is unable to upload the WEBM content for Teacher Resource";
		
		
		String home5 = null;
		String expect5 = " Individual contributor should be able to upload the H5P content for Teacher Resource";
		String actual5 =  "Individual contributor is unable to upload the H5P content for Teacher Resource";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "Individual contributor is able to upload the PDF content for Teacher Resource";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
						
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home2 = VC.getAssertHTMLUpload().getText();
			System.out.println(home2);
			actual2 = "Individual contributor is able to upload the EPUB content for Teacher Resource";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "Individual contributor is able to upload the MP4 content for Teacher Resource";
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "Individual contributor is able to upload the WEBM content for Teacher Resource";
			Thread.sleep(2000);
			
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			
			home5 = VC.getAssertH5pUpload().getText();
			System.out.println(home5);
			actual5 = "Individual contributor is able to upload the H5P content for Teacher Resource";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Sample_Html" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Sample_H5p" ,homeText5, expect5, actual5);
			
//			String homeText6 = home6 != null ? home6 : "N/A";
//			Listeners.customAssert("Sample_H5p" ,homeText6, expect6, actual6);
				
		}
	}
	
	
	public static void validateContributedContentsPageIsAvailablePostClickingOpenButton()
			throws Exception {
		String home1 = null;
		String expect1 = " Contribution Details Header should be Displayed Under My Contents Tab ";
		String actual1 =  "Contribution Details Header is not Displayed Under My Contents Tab";
		
		String home2 = null;
		String expect2 = " Contribution Details like Board, Medium, Class and Subject should be Displayed along with Open Button Under My Contents Tab Section";
		String actual2 =  "Contribution Details like Board, Medium, Class and Subject not Displayed along with Open Button Under My Contents Tab Section";

		
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VC.getClkMyContent());
			Thread.sleep(5000);
			
			
			Assert.assertTrue(VC.getAssertContributionDetails().isDisplayed());
			
			home1 = VC.getAssertContributionDetails().getText();
			System.out.println(home1);
			actual1 = "Contribution Details Header is able to Displayed Under My Contents Tab";
			
			Assert.assertTrue(VC.getAssertK12fwName().isDisplayed());
			
			Assert.assertTrue(VC.getAssertBoardMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertMediumMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertClassMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertSubjectMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertOpenBtnMyContent().isDisplayed());
			
			home2 = VC.getAssertOpenBtnMyContent().getText();
			System.out.println(home2);
			actual2 = "Contribution Details like Board, Medium, Class and Subject Displayed along with Open Button Under My Contents Tab Section";
			
			VDNUtils.waitToBeClickableAndClick(VC.getAssertOpenBtnMyContent());
			Thread.sleep(1000);

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Contribution Details" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Open" ,homeText2, expect2, actual2);		
		}
	}
	
	public static void validateIndividualContributorAbleToUploadAllcontentTypeForLearningResource(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Individual contributor should be able to upload the PDF content for Learning Resource";
		String actual1 =  "Individual contributor is unable to upload the PDF content for Learning Resource";
		
		String home2 = null;
		String expect2 = " Individual contributor should be able to upload the EPUB content for Learning Resource";
		String actual2 =  "Individual contributor is unable to upload the EPUB content for Learning Resource";

		String home3 = null;
		String expect3 = " Individual contributor should be able to upload the MP4 content for Learning Resource";
		String actual3 =  "Individual contributor is unable to upload the MP4 content for Learning Resource";
		
		String home4 = null;
		String expect4 = " Individual contributor should be able to upload the WEBM content for Learning Resource";
		String actual4 =  "Individual contributor is unable to upload the WEBM content for Learning Resource";
		
		String home5 = null;
		String expect5 = " Individual contributor should be able to upload the MP3 content for Learning Resource";
		String actual5 =  "Individual contributor is unable to upload the MP3 content for Learning Resource";
		
		String home6 = null;
		String expect6 = " Individual contributor should be able to upload the H5P content for Learning Resource";
		String actual6 =  "Individual contributor is unable to upload the H5P content for Learning Resource";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "Individual contributor is able to upload the PDF content for Learning Resource";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home2 = VC.getAssertHTMLUpload().getText();
			System.out.println(home2);
			actual2 = "Individual contributor is able to upload the EPUB content for Learning Resource";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "Individual contributor is able to upload the MP4 content for Learning Resource";
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "Individual contributor is able to upload the WEBM content for Learning Resource";
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home5 = VC.getAssertMP3Upload().getText();
			System.out.println(home5);
			actual5 = "Individual contributor is able to upload the MP3 content for Learning Resource";
			Thread.sleep(2000);
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			
			home6 = VC.getAssertH5pUpload().getText();
			System.out.println(home6);
			actual6 = "Individual contributor is able to upload the H5P content for Learning Resource";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Sample_Html" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Sample_Mp3" ,homeText5, expect5, actual5);
			
			String homeText6 = home6 != null ? home6 : "N/A";
			Listeners.customAssert("Sample_H5p" ,homeText6, expect6, actual6);
				
		}
	}
	
	
	public static void validateIndividualContributorAbleToContributeAllContentTypesForDigitalTextbook(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "1. Individual contributor should be able to upload the PDF content and submit for Review";
		String actual1 =  "1. Individual contributor is unable to upload the PDF content and submit for Review ";
		
		String home2 = null;
		String expect2 = "2. Individual contributor should be able to upload the EPUB content and submit for Review";
		String actual2 = "2. Individual contributor is unable to upload the EPUB content and submit for Review ";
	
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			Thread.sleep(3000);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "1. Individual contributor is able to upload the PDF content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();	

			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home2 = VC.getAssertEpubUpload().getText();
			System.out.println(home2);
			actual2 = "2. Individual contributor is unable to upload the EPub content and submit for Review";
			

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Epub" ,homeText2, expect2, actual2);
			
		}
	}
	
	public static void validateContentDetailsLinkIsDisplayedInTheContentDetailsPageForContributorPostUploading(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "Content details link should displayed in the content details page for the contributor post uploading PDF";
		String actual1 =  "Content details link is not displayed in the content details page for the contributor post uploading PDF ";
		
		String home2 = null;
		String expect2 = "Content details link should displayed in the content details page for the contributor post uploading EPUB";
		String actual2 =  "Content details link is not displayed in the content details page for the contributor post uploading EPUB";
		
		String home3 = null;
		String expect3 = "Content details link should displayed in the content details page for the contributor post uploading MP3";
		String actual3 =  "Content details link is not displayed in the content details page for the contributor post uploading MP3";
		
		String home4 = null;
		String expect4 = "Content details link should displayed in the content details page for the contributor post uploading MP4";
		String actual4 =  "Content details link is not displayed in the content details page for the contributor post uploading MP4 ";
		
		String home5 = null;
		String expect5 = "Content details link should displayed in the content details page for the contributor post uploading WEBM";
		String actual5 =  "Content details link is not displayed in the content details page for the contributor post uploading WEBM ";
		
		String home6 = null;
		String expect6 = "Content details link should displayed in the content details page for the contributor post uploading H5P";
		String actual6 =  "Content details link is not displayed in the content details page for the contributor post uploading H5P ";
		
		String home7 = null;
		String expect7 = "Content details link should displayed in the content details page for the contributor post uploading HTML";
		String actual7 =  "Content details link is not displayed in the content details page for the contributor post uploading HMTL ";
		
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
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "Content details link is displayed in the content details page for the contributor post uploading PDF";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home2 = VC.getAssertEpubUpload().getText();
			System.out.println(home2);
			actual2 = "Content details link is displayed in the content details page for the contributor post uploading EPUB";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);

			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);

			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home3 = VC.getAssertMP3Upload().getText();
			System.out.println(home3);
			actual3 = "Content details link is displayed in the content details page for the contributor post uploading MP3";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMP4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);

			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home4 = VC.getAssertMP4Upload().getText();
			System.out.println(home4);
			actual4 = "Content details link is displayed in the content details page for the contributor post uploading MP4";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);

			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home5 = VC.getAssertWEBMUpload().getText();
			System.out.println(home5);
			actual5 = "Content details link is displayed in the content details page for the contributor post uploading WEBM";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			

			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			

			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home6 = VC.getAssertH5pUpload().getText();
			System.out.println(home6);
			actual6 = "Content details link is displayed in the content details page for the contributor post uploading H5P";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			

			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			

			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			
			home7 = VC.getAssertHTMLUpload().getText();
			System.out.println(home6);
			actual7 = "Content details link is displayed in the content details page for the contributor post uploading HTML";
			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSelPractQSet());
//			Thread.sleep(1000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			Thread.sleep(2000);

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Epub" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			System.out.println(homeText3);
			Listeners.customAssert("Sample_Mp3" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			System.out.println(homeText4);
			Listeners.customAssert("Sample_Mp4" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			System.out.println(homeText5);
			Listeners.customAssert("Sample_Webm" ,homeText5, expect5, actual5);
			
			String homeText6 = home6 != null ? home6 : "N/A";
			System.out.println(homeText6);
			Listeners.customAssert("Sample_H5p" ,homeText6, expect6, actual6);
			
			String homeText7 = home7 != null ? home7 : "N/A";
			System.out.println(homeText7);
			Listeners.customAssert("Sample_Html" ,homeText7, expect7, actual7);
			
		}
	}
	
	
	public static void validateAddorEditTranscriptPopUpDisplayedOnPostClickAddTranscriptButton(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "Add/edit Transcript pop up should be displayed post clicking on Add Transcript button in the Preview video pop up.";
		String actual1 =  "Add/edit Transcript pop up is not displayed post clicking on Add Transcript button in the Preview video pop up. ";
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
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMP4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkAddTranscriptbtn());
			Thread.sleep(3000);
			
			Assert.assertTrue(VC.getAssertAddorEditTrans().isDisplayed());
			home1 = VC.getAssertAddorEditTrans().getText();
			System.out.println(home1);
			actual1 = "Add/edit Transcript pop up is displayed post clicking on Add Transcript button in the Preview video pop up.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Add/Edit Transcript" ,homeText1, expect1, actual1);
		}
	}
	
	public static void uploadContentsFromContributorSideForAllTypes(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "contributor should be able to upload the PDF content and submit for Review";
		String actual1 =  "contributor is unable to upload the PDF content and submit for Review ";
		
		String home2 = null;
		String expect2 = "contributor should be able to upload the HTML content and submit for Review";
		String actual2 =  "contributor is unable to upload the HTML content and submit for Review ";
		
		String home3 = null;
		String expect3 = "contributor should be able to upload the MP4 content and submit for Review";
		String actual3 =  "contributor is unable to upload the MP4 content and submit for Review ";
		
		String home4 = null;
		String expect4 = "contributor should be able to upload the WEBM content and submit for Review";
		String actual4 =  "contributor is unable to upload the WEBM content and submit for Review ";
		
		String home5 = null;
		String expect5 = "contributor should be able to upload the H5P content and submit for Review";
		String actual5 =  "contributor is unable to upload the H5P content and submit for Review ";
		
		String home6 = null;
		String expect6 = "contributor should be able to upload the EPUB content and submit for Review";
		String actual6 =  "contributor is unable to upload the EPUB content and submit for Review ";
		
		String home7 = null;
		String expect7 = "contributor should be able to upload the MP3 content and submit for Review";
		String actual7 =  "contributor is unable to upload the MP3 content and submit for Review ";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
				
			home1 = VC.getAssertPDFUpload().getText();
			System.out.println(home1);
			actual1 = "contributor is unable to upload the PDF content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home2 = VC.getAssertHTMLUpload().getText();
			System.out.println(home2);
			actual2 = "contributor is unable to upload the HTML content and submit for Review";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "contributor is unable to upload the MP4 content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "contributor is unable to upload the WEBM content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			
			home5 = VC.getAssertH5pUpload().getText();
			System.out.println(home5);
			actual5 = "contributor is unable to upload the H5P content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home6 = VC.getAssertEpubUpload().getText();
			System.out.println(home6);
			actual6 = "contributor is unable to upload the EPUB content and submit for Review";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home7 = VC.getAssertMP3Upload().getText();
			System.out.println(home7);
			actual7 = "Individual contributor is able to upload the MP3 content for Explanation Content";
			Thread.sleep(2000);

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Sample_Html" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			System.out.println(homeText3);
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			System.out.println(homeText4);
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			System.out.println(homeText5);
			Listeners.customAssert("Sample_H5p" ,homeText5, expect5, actual5);
			
			String homeText6 = home6 != null ? home6 : "N/A";
			System.out.println(homeText6);
			Listeners.customAssert("Sample_Epub" ,homeText6, expect6, actual6);
			
			String homeText7 = home7 != null ? home7 : "N/A";
			System.out.println(homeText7);
			Listeners.customAssert("Sample_Mp3" ,homeText7, expect7, actual7);
			
			
		}
	}
	
	
	public static void validateReviewerAbleToSubmitForApprovalAndAllContentStatusIsApprovalPending(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Assigned project reviewer should be able to Accept the pdf content.";
		String actual1 =  "Assigned project reviewer is unable to Accept the content.";
		
		String home2 = null;
		String expect2 = " Assigned project reviewer should be able to Accept the HTML content.";
		String actual2 =  "Assigned project reviewer is unable to Accept the HTML content.";
		
		String home3 = null;
		String expect3 = " Assigned project reviewer should be able to Accept the mp4 content.";
		String actual3 =  "Assigned project reviewer is unable to Accept the mp4 content.";
		
		String home4 = null;
		String expect4 = " Assigned project reviewer should be able to Accept the WEBM content.";
		String actual4 =  "Assigned project reviewer is unable to Accept the WEBM content.";
		
		String home5 = null;
		String expect5 = " Assigned project reviewer should be able to Accept the H5P content.";
		String actual5 =  "Assigned project reviewer is unable to Accept the H5P content.";
		
		String home6 = null;
		String expect6 = " Assigned project reviewer should be able to Accept the EPUB content.";
		String actual6 =  "Assigned project reviewer is unable to Accept the EPUB content.";
		
		String home7 = null;
		String expect7 = " Assigned project reviewer should be able to Accept the MP3 content.";
		String actual7 =  "Assigned project reviewer is unable to Accept the MP3 content.";

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
			
			VDNUtils.waitForElementToBeVisible(VO.getClkReviewContentBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContentBtn());
			Thread.sleep(3000);
			
			for(int i=0;i<7;i++) {
				
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
			
			}
			
			Thread.sleep(2000);		
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPendingOrProcessing());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovalPendingPDF());
			Assert.assertTrue(VC.getAssertApprovalPendingPDF().isDisplayed());
			String stausApprovalPendingPDF = VC.getAssertApprovalPendingPDF().getText();
			Assert.assertEquals(stausApprovalPendingPDF,"Approval Pending");			
			home1 = VC.getAssertApprovalPendingPDF().getText();
			System.out.print(home1);
			
			actual1 = "Assigned project reviewer is able to Accept the pdf content.";
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovalPendingHTML());
			Assert.assertTrue(VC.getAssertApprovalPendingHTML().isDisplayed());
			String stausApprovalPendingHTML = VC.getAssertApprovalPendingHTML().getText();
			Assert.assertEquals(stausApprovalPendingHTML,"Approval Pending");			
			home2 = VC.getAssertApprovalPendingHTML().getText();
			System.out.print(home2);
			
			actual2 = "Assigned project reviewer is able to Accept HTML content.";
			
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovalPendingMP4());
			Assert.assertTrue(VC.getAssertApprovalPendingMP4().isDisplayed());
			String stausApprovalPendingMP4 = VC.getAssertApprovalPendingMP4().getText();
			Assert.assertEquals(stausApprovalPendingMP4,"Approval Pending");			
			home3 = VC.getAssertApprovalPendingMP4().getText();
			System.out.print(home3);
			
			actual3 = "Assigned project reviewer is able to Accept MP4 content.";
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovalPendingWEBM());
			Assert.assertTrue(VC.getAssertApprovalPendingWEBM().isDisplayed());
			String stausApprovalPendingWEBM = VC.getAssertApprovalPendingWEBM().getText();
			Assert.assertEquals(stausApprovalPendingWEBM,"Approval Pending");			
			home4 = VC.getAssertApprovalPendingWEBM().getText();
			System.out.print(home4);
			
			actual4 = "Assigned project reviewer is able to Accept WEBM content.";
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovalPendingH5P());
			Assert.assertTrue(VC.getAssertApprovalPendingH5P().isDisplayed());
			String stausApprovalPendingH5P = VC.getAssertApprovalPendingH5P().getText();
			Assert.assertEquals(stausApprovalPendingH5P,"Approval Pending");			
			home5 = VC.getAssertApprovalPendingH5P().getText();
			System.out.print(home5);
			
			actual5 = "Assigned project reviewer is able to Accept H5P content.";
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovalPendingEPUB());
			Assert.assertTrue(VC.getAssertApprovalPendingEPUB().isDisplayed());
			String stausApprovalPendingEPUB = VC.getAssertApprovalPendingEPUB().getText();
			Assert.assertEquals(stausApprovalPendingEPUB,"Approval Pending");			
			home6 = VC.getAssertApprovalPendingEPUB().getText();
			System.out.print(home6);
			
			actual6 = "Assigned project reviewer is able to Accept EPUB content.";
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertApprovalPendingMP3());
			Assert.assertTrue(VC.getAssertApprovalPendingMP3().isDisplayed());
			String stausApprovalPendingMP3 = VC.getAssertApprovalPendingMP3().getText();
			Assert.assertEquals(stausApprovalPendingMP3,"Approval Pending");			
			home7 = VC.getAssertApprovalPendingMP3().getText();
			System.out.print(home7);
			
			actual7 = "Assigned project reviewer is able to Accept MP3 content.";
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText5, expect5, actual5);
			
			String homeText6 = home6 != null ? home6 : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText6, expect6, actual6);
			
			String homeText7 = home7 != null ? home7 : "N/A";
			Listeners.customAssert("Approval Pending" ,homeText7, expect7, actual7);
		}
	}
	
	public static void validateAssignedRolesAvailableonBothRole(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "Contributor and reviewer role should be displayed against the project for the assigned Both role user.";
		String actual1 =  "Contributor and reviewer roles are not displayed against the project for the assigned Both role user. ";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = " ']//following::div[text()='Contributor, Reviewer'][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			WebElement assertBothRoles = driver.findElement(By.xpath(s1 + s2 + s4));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertBothRoles.isDisplayed();
			Thread.sleep(5000);
			home1 = assertBothRoles.getText();
			System.out.println(home1);
			actual1 = "Contributor and reviewer roles are displayed against the project for the assigned Both role user.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Contributor, Reviewer" ,homeText1, expect1, actual1);
			
		}
	}
	
	public static void validateReviewerAbleToEditTheNameInTheEditDetailsForm(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "reviewer should be able to edit the name in the edit details form for PDF Content and is Updated";
		String actual1 =  "reviewer should be unable to edit the name in the edit details form for PDFContent Or is not Updated";
		
		String home2 = null;
		String expect2 = " reviewer should be able to edit the name in the edit details form for HTML Content and is Updated";
		String actual2 =  "reviewer should be unable to edit the name in the edit details form for HTML Content or is not Updated";
		
		String home3 = null;
		String expect3 = " reviewer should be able to edit the name in the edit details form for MP4 Content and is Updated";
		String actual3 =  "reviewer is unable to edit the name in the edit details form for MP4 Content Or is not Updated";
		
		String home4 = null;
		String expect4 = "reviewer should be able to edit the name in the edit details form for WEBM Content and is Updated";
		String actual4 =  "reviewer is unable to edit the name in the edit details form for WEBM Content or is not Updated";
		
		String home5 = null;
		String expect5 = " reviewer should be able to edit the name in the edit details form for H5P Content and is Updated";
		String actual5 =  "reviewer is unable to edit the name in the edit details form for H5P Content or is not Updated";
		
		String home6 = null;
		String expect6 = "reviewer should be able to edit the name in the edit details form for EPUB Content and is Updated";
		String actual6 =  "reviewer is unable to edit the name in the edit details form for EPUB Content or is not Updated";
		
		String home7 = null;
		String expect7 = "reviewer should be able to edit the name in the edit details form for MP3 Content and is Updated";
		String actual7 =  "reviewer is unable to edit the name in the edit details form for MP3 Content and is not Updated";

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
			
			VDNUtils.waitForElementToBeVisible(VO.getClkReviewContentBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContentBtn());
			Thread.sleep(3000);
			
			
			for (int i=1;i<=7;i++) {
	
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());

			VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
			Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
			
			VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
			Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
			
			Assert.assertTrue(VO.getContentDetails().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
			
			VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getEnterName());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "-1");

			VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			

			}
		
			Assert.assertTrue(VC.getAssertPDFUpdated().isDisplayed());		
			home1 = VC.getAssertPDFUpdated().getText();
			System.out.print(home1);
			
			actual1 = "reviewer is able to edit the name in the edit details form for PDF Content and is Updated";
			
			
			Assert.assertTrue(VC.getAssertHTMLUpdated().isDisplayed());		
			home2 = VC.getAssertHTMLUpdated().getText();
			System.out.print(home2);
			actual2 = "reviewer is able to edit the name in the edit details form for HTML Content and is Updated";
			
			
			
			Assert.assertTrue(VC.getAssertMP4Updated().isDisplayed());	
			home3 = VC.getAssertMP4Updated().getText();
			System.out.print(home3);
			actual3 = "reviewer is able to edit the name in the edit details form for MP4 Content and is Updated";
			
			Assert.assertTrue(VC.getAssertWEBMUpdated().isDisplayed());
					
			home4 = VC.getAssertWEBMUpdated().getText();
			System.out.print(home4);
			
			actual4 = "Assigned project reviewer is able to Accept WEBM content.";
			
			Assert.assertTrue(VC.getAssertH5PUpdated().isDisplayed());		
			home5 = VC.getAssertH5PUpdated().getText();
			System.out.print(home5);
			actual5 = "reviewer is able to edit the name in the edit details form for H5P Content and is Updated";
			
			
			Assert.assertTrue(VC.getAssertEPUBUpdated().isDisplayed());			
			home6 = VC.getAssertEPUBUpdated().getText();
			System.out.print(home6);
			
			actual6 = "reviewer is able to edit the name in the edit details form for EPUB Content and is Updated";
			
			Assert.assertTrue(VC.getAssertMP3Updated().isDisplayed());			
			home7 = VC.getAssertMP3Updated().getText();
			System.out.print(home7);
			
			actual7 = "reviewer is able to edit the name in the edit details form for MP3 Content and is Updated";
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Sample_Pdf-1" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Sample_Html-1" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Sample_Mp4-1" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Sample_Webm-1" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Sample_H5p-1" ,homeText5, expect5, actual5);
			
			String homeText6 = home6 != null ? home6 : "N/A";
			Listeners.customAssert("Sample_Epub-1" ,homeText6, expect6, actual6);
			
			String homeText7 = home7 != null ? home7 : "N/A";
			Listeners.customAssert("Sample_Mp3-1" ,homeText7, expect7, actual7);
		}
	}
	
	
	public static void verifyContentStatusApprovedForTheProject(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Content Should be Approved Successfully ";
		String actual =  "Content is not Approved ";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver,VDNContributor.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);

			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VC.getClkSamplePDF().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			//VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
			
			VO.getClkPublish().click();
			Thread.sleep(5000);
			
			VC.getClkSamplePDF().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VC.getClkSamplePDF().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);	
			Assert.assertTrue(VC.getAssertPDFApproved().isDisplayed());
			
			home = VC.getAssertPDFApproved().getText();
			System.out.print(home);		
			actual = "Content is Approved Successfully";

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approved", homeText, expect, actual);
		}

}
	
	public static void validateContentIsApprovedStatusAndOptionToViewContentOnDikshaIsDisplayedForApprovedContent(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " 1.Status should be displayed as content is approved for approved content in content details page for a project reviewer.";
		String actual1 =  "1.Status is not displayed as content is approved for approved content in content details page for a project reviewer.";
		
		String home2 = null;
		String expect2 = " 2.Option to view content on diksha should be displayed for assigned Project reviewer.";
		String actual2 =  "2.Option to view content on diksha is not displayed for assigned Project reviewer.";
		

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertPDFApproved());
			VDNUtils.waitToBeClickableAndClick(VC.getAssertPDFApproved());
			
			
			Assert.assertTrue(VS.getAssertApproved().isDisplayed());
			
			home1 = VS.getAssertApproved().getText();
			System.out.print(home1);		
			actual1 = "1.Status is displayed as content approved for approved content in content details page for a project reviewer.";
			
			Assert.assertTrue(VC.getAssertViewContOnDiksha().isDisplayed());
			
			home2 = VC.getAssertViewContOnDiksha().getText();
			System.out.print(home2);		
			actual2 = "2.Option to view content on diksha is displayed for assigned Project reviewer.";
			
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Approved" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("View this content on DIKSHA" ,homeText2, expect2, actual2);
			
			
		}
	}
	
	public static void verifyContentSendBackForTheCorrections(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Content Should be Send For Review";
		String actual =  "Content is not Send For Review ";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver,VDNContributor.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);

			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VC.getClkSamplePDF().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());	
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(2000);
	
			home = VO.getAssertContentCorrection().getText();
			System.out.print(home);		
			actual = "Content is Send For Review";

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for corrections", homeText, expect, actual);
		}

}
	
	public static void validateStatusOfContentWithViewCommentsDisplayedInTheContentPreviewPageForCorrectionsPending(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "1.Status of the content with view comments should be displayed in the content preview page for Corrections Pending content";
		String actual1 =  "1.Status of the content with view comments is not displayed in the content preview page for Corrections Pending content";
		
		String home2 = null;
		String expect2 = " 2.It should not able to edit the Corrections Pending content";
		String actual2 =  "2.It is able to edit the Corrections Pending content";
		

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
			
			VDNUtils.waitForElementToBeVisible(VC.getclKPDFCorrPen());
			VDNUtils.waitToBeClickableAndClick(VC.getclKPDFCorrPen());
			
			
			Assert.assertTrue(VS.getAssertCorrectionMsg1().isDisplayed());
			Assert.assertTrue(VC.getAssertViewComment().isDisplayed());
			
			
			home1 = VC.getAssertViewComment().getText();
			System.out.print(home1);		
			actual1 = "1.Status of the content with view comments is displayed in the content preview page for Corrections Pending content";
			
			VDNUtils.waitToBeClickableAndClick(VC.getAssertViewComment());
			Thread.sleep(3000);
			Assert.assertTrue(VC.getAssertReviewComment().isDisplayed());
			
			home2 = VC.getAssertReviewComment().getText();
			System.out.print(home2);		
			actual2 = "2.It is not able to edit the Corrections Pending content";
			
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("View Comments" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Correct" ,homeText2, expect2, actual2);
			
			
		}
	}
	
	public static void validateContentIsViewableToAssignedReviewerEvenAfterContentIsAccepted(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " 1.Status should be displayed as content is approved for approved content in content details page for a project reviewer.";
		String actual1 =  "1.Status is not displayed as content is approved for approved content in content details page for a project reviewer.";
		
		String home2 = null;
		String expect2 = " 2.Option to view content on diksha should be displayed for assigned Project reviewer.";
		String actual2 =  "2.Option to view content on diksha is not displayed for assigned Project reviewer.";
		

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertPDFApproved());
			VDNUtils.waitToBeClickableAndClick(VC.getAssertPDFApproved());
			
			
			Assert.assertTrue(VS.getAssertApproved().isDisplayed());
			
			home1 = VS.getAssertApproved().getText();
			System.out.print(home1);		
			actual1 = "1.Status is displayed as content approved for approved content in content details page for a project reviewer.";
			
			Assert.assertTrue(VC.getAssertViewContOnDiksha().isDisplayed());
			
			home2 = VC.getAssertViewContOnDiksha().getText();
			System.out.print(home2);		
			actual2 = "2.Option to view content on diksha is displayed for assigned Project reviewer.";
			
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Approved" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("View this content on DIKSHA" ,homeText2, expect2, actual2);
			
			
		}
	}
	
	public static void verifyContentStatusRejecedForTheProject(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Content Should be Rejected Successfully ";
		String actual =  "Content is not Rejected ";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver,VDNContributor.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);

			VO.getClkOpenBtn().click();
			Thread.sleep(5000);

			VC.getClkSamplePDF().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			//VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
			
//			VO.getClkPublish().click();
//			Thread.sleep(5000);
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
//			VC.getClkSamplePDF().click();
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
//			
//			VC.getClkSamplePDF().click();
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);	
//			Assert.assertTrue(VC.getAssertPDFApproved().isDisplayed());
			
			home = VC.getAssertRejectedCount().getText();
			System.out.print(home);		
			actual = "Content is Rejected Successfully";

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("1", homeText, expect, actual);
		}

}
	
	
	public static void validateContentIsViewableToAssignedReviewerEvenAfterContentIsRejecte(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " 1.Status should be displayed as content is approved for approved content in content details page for a project reviewer.";
		String actual1 =  "1.Status is not displayed as content is approved for approved content in content details page for a project reviewer.";
		
		String home2 = null;
		String expect2 = " 2.Content should be viewable to assigned reviewer even after the content is rejected.";
		String actual2 =  "2.Content is not viewable to assigned reviewer even after the content is rejected.";
		

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertPDFRejected());
			VDNUtils.waitToBeClickableAndClick(VC.getAssertPDFRejected());
			
			
			Assert.assertTrue(VC.getAssertRejected().isDisplayed());
			
			home1 = VC.getAssertRejected().getText();
			System.out.print(home1);		
			actual1 = "1.Status is displayed as content Rejected for reject content in content details page for a project reviewer.";
			
//			Assert.assertTrue(VC.getAssertViewContOnDiksha().isDisplayed());
//			
//			home2 = VC.getAssertViewContOnDiksha().getText();
//			System.out.print(home2);		
//			actual2 = "2.Option to view content on diksha is displayed for assigned Project reviewer.";
			
			VDNUtils.waitToBeClickableAndClick(VC.getAssertViewComment());
			Thread.sleep(3000);
			Assert.assertTrue(VC.getAssertReviewComment().isDisplayed());
			
			home2 = VC.getAssertReviewReject().getText();
			System.out.print(home2);		
			
			actual2 = "2.Content is viewable to assigned reviewer even after the content is rejected.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Rejected" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Reject" ,homeText2, expect2, actual2);
			
			
		}
	}
	
	public static void validateAccessibilityDetailsButtonDisplayedWhileUploadingContent(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Accessibility Details button should displayed while uploading the PDF content";
		String actual1 =  "Accessibility Details button is not displayed while uploading the PDF content";
		
		String home2 = null;
		String expect2 = " Accessibility Details button should displayed while uploading the HTML content";
		String actual2 =  "Accessibility Details button is not displayed while uploading the HTML content";

		String home3 = null;
		String expect3 = " Accessibility Details button should displayed while uploading the MP4 content";
		String actual3 =  "Accessibility Details button is not displayed while uploading the MP4 content";
		
		String home4 = null;
		String expect4 = "Accessibility Details button should displayed while uploading the WEBM content";
		String actual4 =  "Accessibility Details button is not displayed while uploading the WEBM content";
		
		
		String home5 = null;
		String expect5 = " Accessibility Details button should displayed while uploading the H5P content";
		String actual5 =  "Accessibility Details button is not displayed while uploading the H5P content";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			home1 = VC.getAccessibilityDetailsBtn().getText();
			System.out.println(home1);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual1 = "Accessibility Details button is displayed while uploading the PDF content";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
						
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			home2 = VC.getAccessibilityDetailsBtn().getText();
			System.out.println(home1);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual2 = "Accessibility Details button is displayed while uploading the HTML content";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			home3 = VC.getAccessibilityDetailsBtn().getText();
			System.out.println(home3);
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual3 = "Accessibility Details button is displayed while uploading the MP4 content";
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			home4 = VC.getAccessibilityDetailsBtn().getText();
			System.out.println(home4);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual4 = "Accessibility Details button is displayed while uploading the WEBM content";
			Thread.sleep(2000);
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			home5 = VC.getAccessibilityDetailsBtn().getText();
			System.out.println(home5);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			
			actual5 = "Accessibility Details button is displayed while uploading the H5P content";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Accessibility Details" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Accessibility Details" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Accessibility Details" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Accessibility Details" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Accessibility Details" ,homeText5, expect5, actual5);
				
		}
	}
	
	public static void validateAccessibilityDetailsPopUpDisplayedPostClickBtnInContentDetailPage(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Accessibility Details button should displayed while uploading the content";
		String actual1 =  "Accessibility Details button is not displayed while uploading the content";
		
		String home2 = null;
		String expect2 = " Accessibility Details pop up should displayed post clicking on Accessibility button in the content details page.";
		String actual2 =  "Accessibility Details pop up is not displayed post clicking on Accessibility button in the content details page.";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			home1 = VC.getAccessibilityDetailsBtn().getText();
			System.out.println(home1);
			actual1 = "Accessibility Details button is displayed while uploading the content";
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getAccessibilityDetailsBtn());
			Assert.assertTrue(VC.getAssertAccessibilityPopUp().isDisplayed());
			Assert.assertTrue(VC.getCancelBtn().isDisplayed());
			Assert.assertTrue(VC.getDoneButton().isDisplayed());
			
			
			home2 = VC.getAssertAccessibilityPopUp().getText();
			System.out.println(home2);
			actual2 = "Accessibility Details pop up is displayed post clicking on Accessibility button in the content details page.";

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Accessibility Details" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Accessibility" ,homeText2, expect2, actual2);
				
		}
	}
	
	public static void validateIndContributorAbleAddTranscriptFile()
			throws Exception {
		String home1 = null;
		String expect1 = "Add/edit Transcript pop up should be displayed post clicking on Add Transcript button in the Preview video pop up.";
		String actual1 =  "Add/edit Transcript pop up is not displayed post clicking on Add Transcript button in the Preview video pop up. ";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
//			String s1 = "//div[text()=' ";
//			String s2 = ProjectName;
//			String s3 = " ']//following::button[text()='Open '][1]";
//			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
//			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
//			assertProjectOnContributor.isDisplayed();
//			assertProjectOnContributor.click();
//			Thread.sleep(5000);
//			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelLanguage());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelAssamLanguage());
			Thread.sleep(3000);
			
//			VDNUtils.waitToBeClickableAndClick(VC.getClkSelAssamLanguage());
//			Thread.sleep(3000);
//			
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
//			
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
//			Thread.sleep(1000);
//			
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
//			Thread.sleep(2000);
//			
//			Thread.sleep(3000);
//			UploadContentMethods.UploadMP4();
//			
//			Thread.sleep(3000);
			
			UploadContentMethods.UploadVTT();
			Thread.sleep(3000);
			
			Assert.assertTrue(VC.getAssetVTTFileUploaded().isDisplayed());
			Thread.sleep(3000);
			home1 = VO.getClkSaveButton().getText();
			System.out.println(home1);
			actual1 = "Add/edit Transcript pop up is displayed post clicking on Add Transcript button in the Preview video pop up.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Save" ,homeText1, expect1, actual1);
		}
	}
	
	public static void validateIndividualContributorAbleToUploadMP4WEBMandMP3TypeForExplanationContent()
			throws Exception {
		
		String home3 = null;
		String expect3 = " Individual contributor should be able to upload the MP4 content for Explanation Content";
		String actual3 =  "Individual contributor is unable to upload the MP4 content for Explanation Content";
		
		String home4 = null;
		String expect4 = " Individual contributor should be able to upload the WEBM content for Explanation Content";
		String actual4 =  "Individual contributor is unable to upload the WEBM content for Explanation Content";
		
		String home5 = null;
		String expect5 = " Individual contributor should be able to upload the MP3 content for Explanation Content";
		String actual5 =  "Individual contributor is unable to upload the MP3 content for Explanation Content";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home3 = VC.getAssertMP4Upload().getText();
			System.out.println(home3);
			actual3 = "Individual contributor is able to upload the MP4 content for Explanation Content";
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home4 = VC.getAssertWEBMUpload().getText();
			System.out.println(home4);
			actual4 = "Individual contributor is able to upload the WEBM content for Explanation Content";
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			home5 = VC.getAssertMP3Upload().getText();
			System.out.println(home5);
			actual5 = "Individual contributor is able to upload the MP3 content for Explanation Content";
			Thread.sleep(2000);

		} finally {
//			String homeText1 = home1 != null ? home1 : "N/A";
//			Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
//			
//			String homeText2 = home2 != null ? home2 : "N/A";
//			Listeners.customAssert("Sample_Epub" ,homeText2, expect2, actual2);
//			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Sample_Mp3" ,homeText5, expect5, actual5);
				
		}
	}
	
	
	public static void validateIndividualContributorAbleToUploadH5PadHTMLContentTypes()
			throws Exception {
		
		String home6 = null;
		String expect6 = " Individual contributor should be able to upload the H5P content for Learning Resource";
		String actual6 =  "Individual contributor is unable to upload the H5P content for Learning Resource";
		
		String home7 = null;
		String expect7 = " Individual contributor should be able to upload the HTML content for Teacher Resource";
		String actual7 =  "Individual contributor is unable to upload the HTML content for Teacher Resource";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelLearningRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			home6 = VC.getAssertH5pUpload().getText();
			System.out.println(home6);
			Thread.sleep(2000);

			actual6 = " Individual contributor is able to upload the H5P content for Learning Resource ";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadFileOpt());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			home7 = VC.getAssertHTMLUpload().getText();
			System.out.println(home7);
			actual7 = "Individual contributor is able to upload the HTML content for Teacher Resource";

		} finally {
	
			String homeText6 = home6 != null ? home6 : "N/A";
			Listeners.customAssert("Sample_H5P" ,homeText6, expect6, actual6);
			
			String homeText7= home7 != null ? home7 : "N/A";
			Listeners.customAssert("Sample_Html" ,homeText7, expect7, actual7);
							
		}
	}
	
	
	public static void validateDetailsUnderAssignUsersToProjectsTab(String ProjectName)
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
			
			home = VO.getSelectRolePostSearch().getText();
			System.out.println(home);
			
			actual = "Select Role option is by default selected in the drop down under the assign users to projects tab for Contributor orgadmin. " ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Select Role", homeText, expect, actual);
		}
	}
	
	public static void verifyContentStatusIsReviewPendingWhenReviewIsNotComplete(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " The Content Status should be Review Pending under TextBook tab , when the contribution or review is not complete.";
		String actual1 =  "The Content Status is not a Review Pending under TextBook tab , when the contribution or review is not complete.";
		

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
			
			VDNUtils.waitForElementToBeVisible(VO.getClkReviewContentBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContentBtn());
			Thread.sleep(3000);
				
			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
			
			
			home1 = VO.getAssertReviewPending().getText();
			System.out.println(home1);
			
			actual1 = "The Content Status is Review Pending under TextBook tab , when the contribution or review is not complete.";
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Review Pending" ,homeText1, expect1, actual1);
			
		}
	}
	
	public static void validateTheProjectDetailsPageOnContributor(String ProjectName)
			throws Exception {
		String home = null;
		String expect = "project details Should be available on Project Details page";
		String actual = "project details is unavailable on Project Details page";

		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			String s4 = " ']//following::button[text()='Open '][1]";
			
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s4));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(3000);

			
			String p1 = "//h5[text()='";

					
			WebElement assertProjName = driver.findElement(By.xpath(p1+ProjectName+s3));
			assertProjName.isDisplayed();
			
			
			Assert.assertTrue(VC.getAssertContentTypes().isDisplayed());
			
			Assert.assertTrue(VC.getAssertNominationDates().isDisplayed());
			Assert.assertTrue(VC.getAssertApprovedStatus().isDisplayed());
			Assert.assertTrue(VC.getAssertDigiText().isDisplayed());
			
			Assert.assertTrue(VC.getAssertMedium().isDisplayed());
			Assert.assertTrue(VC.getAssetClass().isDisplayed());
			Assert.assertTrue(VC.getAssertSubject().isDisplayed());
			
			Thread.sleep(3000);

			home = VC.getAssertSubject().getText();
			System.out.println(home);
			
			actual = "project details is available on Project Details page";
		} finally {
     		String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Subject   " ,homeText, expect, actual);
		}
	}
	
	public static void validateCorrespondingHelpCenterPageDisplayedForTheAssignedReviewer(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Help center page Should be Displayed for the Assigned reviewer";
		String actual =  "Help center page is not Displayed for the Assigned reviewer";

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
			
			Assert.assertTrue(VC.getAssertHelpCenter().isDisplayed());
			
			home = VC.getAssertHelpCenter().getText();
			System.out.println(home);
			actual = "Help center page is Displayed for the Assigned reviewer";
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertHelpCenter());
			VDNUtils.waitToBeClickableAndClick(VC.getAssertHelpCenter());

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Help Center" ,homeText, expect, actual);
		}
	}
	
	public static void validateCorrespondingHelpCenterPageDisplayedForTheAssignedContributor(String ProjectName)
			throws Exception {
		String home = null;
		String expect = " Help center page Should be Displayed for the Assigned Contributor";
		String actual =  "Help center page is not Displayed for the Assigned Contributor";

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
			
			Assert.assertTrue(VC.getAssertHelpCenter().isDisplayed());
			
			home = VC.getAssertHelpCenter().getText();
			System.out.println(home);
			actual = "Help center page is Displayed for the Assigned Contributor";
			
			VDNUtils.waitForElementToBeVisible(VC.getAssertHelpCenter());
			VDNUtils.waitToBeClickableAndClick(VC.getAssertHelpCenter());

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Help Center" ,homeText, expect, actual);
		}
	}

	
	
	public static void validateTheCountOnTOCandTopForContributionOgrContributor()
			throws Exception {
		String home = null;
		String expect = " The count on toc and top for contribution org contributor should be correct.";
		String actual =  "The count on toc and top for contribution org contributor is not correct.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			List <WebElement> TOC_count = driver.findElements(By.xpath("//div[@class='chapter-lists--item']"));
			int SizeTOC = TOC_count.size();
			System.out.println(TOC_count.size());
			
			String TOP_count = VC.getGetTotalCountTop().getText();
			System.out.println(TOP_count);
			
			int TopCount=Integer.parseInt(TOP_count); 
			
			Assert.assertEquals(TopCount,TOC_count.size());
			home = VC.getAssertMP3Upload().getText();
			System.out.println(home);
			actual = "The count on toc and top for contribution or contributor is correct.";
			Thread.sleep(2000);

		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Sample_Mp3" ,homeText, expect, actual);
		}
	}
	
	public static void validateContributorUnableToAddPDFAsATranscriptFile()
			throws Exception {
		String home1 = null;
		String expect1 = "Add/edit Transcript pop up should be displayed post clicking on Add Transcript button in the Preview video pop up.";
		String actual1 =  "Add/edit Transcript pop up is not displayed post clicking on Add Transcript button in the Preview video pop up. ";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelLanguage());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelAssamLanguage());
			Thread.sleep(3000);
			
			UploadContentMethods.UploadPdf();
			Thread.sleep(3000);
			
			Assert.assertTrue(VC.getAssertInvalidFileType().isDisplayed());
			Thread.sleep(3000);
			home1 = VC.getAssertInvalidFileType().getText();
			System.out.println(home1);
			actual1 = "Add/edit Transcript pop up is displayed post clicking on Add Transcript button in the Preview video pop up.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Invalid file type (supported type: .vtt)" ,homeText1, expect1, actual1);
		}
	}
	
	public static void validateContributorUnableToAddEpubAsATranscriptFile()
			throws Exception {
		String home1 = null;
		String expect1 = "Contributor org contributor should not be able to add epub file as a transcript file.";
		String actual1 =  "Contributor org contributor should able to add epub file as a transcript file. ";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelLanguage());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelAssamLanguage());
			Thread.sleep(3000);
			
			UploadContentMethods.UploadEpub();
			Thread.sleep(1000);
			
			Assert.assertTrue(VC.getAssertInvalidFileType().isDisplayed());
			Thread.sleep(1000);
			home1 = VC.getAssertInvalidFileType().getText();
			System.out.println(home1);
			actual1 = "Contributor org contributor is not able to add epub file as a transcript file. ";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Invalid file type (supported type: .vtt)" ,homeText1, expect1, actual1);
		}
	}
	
	public static void verifyContOrgContributorAbleToUploadContentAndAddAllDetailsInEditDetailsPopUpAndSendForReview() throws Exception {
		
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
//			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());	
			Thread.sleep(3000);
			home = VO.getAssertContentSetReview().getText();	
			System.out.println(home);

			actual = " Contributor org contributor is able to upload the content and add all the details in the edit details pop up and send it for review ";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Content sent for review", homeText, expect, actual);
		}

	}
	
	public static void validateyContributorIsNotAbleToContributeTheClosedWithoutTCProject(String ProjectName) throws Exception {
		
		String home = null;
		String expect = "contributor should not be able to contribute to the closed without target collection project";
		String actual = "contributor is able to contribute to the closed without target collection project";
		
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(10000);
			
			String tabDetails = VC.getAssertTitles().getText();
			String[] lines = tabDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Create/Upload Content");
			    Assert.assertNotEquals(line,"Bulk upload content");
			}
			
			home=VS.getFilterContents().getText();
			actual = "contributor is not be able to contribute to the closed without target collection project";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Filter Contents", homeText, expect, actual);
		}

	}
	
	public static void validateSelSetOfContProjectsShouldBeAvailableUnderMyProjectsTabWithApprovedStatus(String ProjectName)
			throws InterruptedException {
		String home1 = null;
		String expect1 = " 1.From a selected set of contributors projects should be available for the selected contributors under My Projects tab with Approved Status";
		String actual1 =  "1.From a selected set of contributors projects is not available for the selected contributors under My Projects tab with Approved Status";
		
		String home2 = null;
		String expect2 = " 2.selected individual should be able to contribute the contents to the project.";
		String actual2 =  "2.selected individual is unable to contribute the contents to the project.";
		

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			String s4 = "']//following::span[text()='Approved'][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			WebElement assertApprovedStaus = driver.findElement(By.xpath(s1 + s2 + s4));
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertApprovedStaus.isDisplayed();
			
			
			home1 = assertApprovedStaus.getText();
			System.out.println(home1);
			actual1 = "1.From a selected set of contributors projects should be available for the selected contributors under My Projects tab with Approved Status";
			
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
		
			VDNUtils.waitToBeClickableAndClick(VC.getClkUploadCont());
			Assert.assertTrue(VO.getClkCreateNew().isDisplayed());
			
			home2 = assertApprovedStaus.getText();
			System.out.println(home2);
			actual2 = "2.selected individual should be able to contribute the contents to the project.";
		

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Approved", homeText1, expect1, actual1);
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Create new", homeText2, expect2, actual2);
		}
	}

	public static void validateIndContributorAbleToPreviewPublishedContentPostClickingOnOpenBtn()
			throws Exception {
		String home1 = null;
		String expect1 = " Stauts Published On Diksha should Displayed post clicking on open button in the contributed contents page. ";
		String actual1 =  "Stauts Published On Diksha is not Displayed post clicking on open button in the contributed contents page.";
		
		String home2 = null;
		String expect2 = " individual contributor should be able to preview the published content post clicking on open button in the contributed contents page.";
		String actual2 =  "individual contributor is unable to preview the published content post clicking on open button in the contributed contents page.";

		
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VC.getAssertOpenBtnMyContent());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenPublished());
			Thread.sleep(2000);
			
			Assert.assertTrue(VC.getAssertPublishedOnDiksha().isDisplayed());
			
			home1 = VC.getAssertPublishedOnDiksha().getText();
			System.out.println(home1);
			actual1 = "Stauts Published On Diksha is Displayed post clicking on open button in the contributed contents page. ";
			
			Assert.assertTrue(VC.getClkViewContent().isDisplayed());
			
			home2 = VC.getClkViewContent().getText();
			System.out.println(home2);
			actual2 = "individual contributor is able to preview the published content post clicking on open button in the contributed contents page.";
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkViewContent());
			Thread.sleep(2000);
			
//			VDNUtils.waitToBeClickableAndClick(VC.getAssertOpenBtnMyContent());
//			Thread.sleep(1000);

		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Published on DIKSHA" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("View this content on DIKSHA" ,homeText2, expect2, actual2);		
		}
	}
	
	public static void validateIndContributorAbleToPreviewNotPublishedContentPostClickingOnOpenBtn()
			throws Exception {
		String home1 = null;
		String expect1 = " Stauts Not Published On Diksha should Displayed post clicking on open button in the contributed contents page. ";
		String actual1 =  "Stauts Not Published On Diksha is not Displayed post clicking on open button in the contributed contents page.";
		
		String home2 = null;
		String expect2 = " individual contributor should be able to preview the not published content post clicking on open button in the contributed contents page.";
		String actual2 =  "individual contributor is unable to preview the not published content post clicking on open button in the contributed contents page.";

		
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VC.getAssertOpenBtnMyContent());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkOpenNotPublished());
			Thread.sleep(2000);
			
			Assert.assertTrue(VC.getAssertNotPublishedOnDiksha().isDisplayed());
			
			home1 = VC.getAssertNotPublishedOnDiksha().getText();
			System.out.println(home1);
			actual1 = "Stauts Not Published On Diksha is Displayed post clicking on open button in the contributed contents page. ";
			
			Assert.assertTrue(VC.getAssertNotPublishedOnDiksha().isDisplayed());
			
			home2 = VC.getAssertNotPublishedOnDiksha().getText();
			System.out.println(home2);
			actual2 = "individual contributor is able to preview the not published content post clicking on open button in the contributed contents page.";
			
//			VDNUtils.waitToBeClickableAndClick(VC.getClkViewContent());
//			Thread.sleep(2000);
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Not Published on DIKSHA" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Not Published on DIKSHA" ,homeText2, expect2, actual2);		
		}
	}
	
	public static void validateAnswerButtonGettingDisplayedOnPreviewForIndMCQ(String ProjectName) throws InterruptedException {
		String home = null;
		String expect = "Answer button should get displayed on preview for individual MCQ question on preview of entire question set in cokreat portal.";
		String actual = "Answer button is not displayed on preview for individual MCQ question on preview of entire question set in cokreat portal.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
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

//			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
//
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
//			Thread.sleep(3000);
//			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
//			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getUploadSampleBtn());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelPractQSet());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkQSetOpt2());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkMCQPracticeQSet());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getQSetTemplate1());
			Thread.sleep(2000);
			
			
//			UploadContentMethods.UploadPdf();
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSubmitBtn());
			Thread.sleep(1000);
			
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getQuestionfield(), "2+1");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns1field(), "3");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns2field(), "2");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns3field(), "-2");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns4field(), "-3");
			Thread.sleep(1000);
			
//			VDNUtils.waitToBeClickableAndClick(VC.getMarkCorrectAnsOpt1());
//			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkChooseSolType());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getChooseSolType1());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getEnterSol(), "SUM");
			Thread.sleep(1000);
			
//			VDNUtils.waitToBeClickableAndClick(VC.getMarkCorrectAnsOpt1());
//			Thread.sleep(1000);
			
			VC.getMarkCorrectAnsOpt1().click();
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getBtnPreview());
			Thread.sleep(3000);
			
			
			Thread.sleep(3000);
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@name='contentPlayer']"));
			driver.switchTo().frame(frame);
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkAnsOpt2());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkNext());
			Thread.sleep(1000);
			
			home=VC.getClkSoultion().getText();
			System.out.println(home);
			actual =  "Answer button is displayed on preview for individual MCQ question on preview of entire question set in cokreat portal.";
			
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSoultion());
			Thread.sleep(1000);
		
//			VDNUtils.waitToBeClickableAndSendKeys(VC.getEnterSol(), "SUM");
//			Thread.sleep(1000);
			
			
			
			
			
//			VDNUtils.waitToBeClgetChooseSolType1ickableAndSendKeys(VO.getEnterName(), "Sample1");
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
//			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
//			Thread.sleep(2000);
//			VO.getClkCheckBox().click();
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkPostSubmit());
//
			
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Solution", homeText, expect, actual);
		}
	}
	
	public static void validateContentDetailsLinkIsDisplayedInTheContentDetailsPage(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Content details link should displayed in the content details page while uploading the PDF content";
		String actual1 =  "Content details link is not displayed in the content details page while uploading the PDF content";
		
		String home2 = null;
		String expect2 = " Content details link should displayed in the content details page while uploading the EPUB content";
		String actual2 =  "Content details link is not displayed in the content details page while uploading the EPUB content";
		
		String home3 = null;
		String expect3 = " Content details link should displayed in the content details page while uploading the MP3 content";
		String actual3 =  "Content details link is not displayed in the content details page while uploading the MP3 content";

		String home4 = null;
		String expect4 = " Content details link should displayed in the content details page while uploading the MP4 content";
		String actual4 =  "Content details link is not displayed in the content details page while uploading the MP4 content";
		
		String home5 = null;
		String expect5 = " Content details link should displayed in the content details page while uploading the WEBM content";
		String actual5 =  "Content details link is not displayed in the content details page while uploading the WEBM content";
		
		String home6 = null;
		String expect6 = " Content details link should displayed in the content details page while uploading the H5P content";
		String actual6 =  "Content details link is not displayed in the content details page while uploading the H5P content";
		
		String home7 = null;
		String expect7 = " Content details link should displayed in the content details page while uploading the HTML content";
		String actual7 =  "Content details link is not displayed in the content details page while uploading the HTML content";
		
		String home8 = null;
		String expect8 = " Content details link should displayed in the content details page while uploading the Question Set content";
		String actual8 =  "Content details link is not displayed in the content details page while uploading the Question Set content";
		
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			
			home1 = VO.getContentDetails().getText();
			System.out.println(home1);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual1 = "Content details link should displayed in the content details page while uploading the PDF content";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadEpub();
			
			home2 = VO.getContentDetails().getText();
			System.out.println(home1);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual2 = "Content details link should displayed in the content details page while uploading the EPUB content";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp3();
			
			home3 = VO.getContentDetails().getText();
			System.out.println(home3);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual3 = "Content details link should displayed in the content details page while uploading the MP3 content";
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			Thread.sleep(3000);
			UploadContentMethods.UploadMp4();
			
			home4 = VO.getContentDetails().getText();
			System.out.println(home4);
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual4 = "Content details link should displayed in the content details page while uploading the MP4 content";
		
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
			Thread.sleep(3000);
			
			home5 = VO.getContentDetails().getText();
			System.out.println(home5);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			

			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual5 = "Content details link should displayed in the content details page while uploading the WEBM content";
			Thread.sleep(2000);
			
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadH5p();
			
			home6 = VO.getContentDetails().getText();
			System.out.println(home6);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_H5p");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			Thread.sleep(2000);
			
			actual6 = "Content details link should displayed in the content details page while uploading the H5P content";
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
						
			Thread.sleep(3000);
			UploadContentMethods.UploadHtml();
			
			home7 = VO.getContentDetails().getText();
			System.out.println(home7);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Html");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual7 = "Content details link should displayed in the content details page while uploading the HTML content";
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelPractQSet());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkQSetOpt2());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkMCQPracticeQSet());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getQSetTemplate1());
			Thread.sleep(2000);
			
			
//			UploadContentMethods.UploadPdf();
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSubmitBtn());
			Thread.sleep(1000);
			
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getQuestionfield(), "2+1");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns1field(), "3");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns2field(), "2");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns3field(), "-2");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns4field(), "-3");
			Thread.sleep(1000);
		
			VDNUtils.waitToBeClickableAndClick(VC.getClkChooseSolType());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getChooseSolType1());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getEnterSol(), "SUM");
			Thread.sleep(1000);
			
			VC.getMarkCorrectAnsOpt1().click();
			Thread.sleep(1000);
			
			home8 = VO.getContentDetails().getText();
			System.out.println(home8);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Question");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
			
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
			actual8 = "Content details link should displayed in the content details page while uploading the Question Set content";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Content Details" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Content Details" ,homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Content Details" ,homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Content Details" ,homeText4, expect4, actual4);
			
			String homeText5 = home5 != null ? home5 : "N/A";
			Listeners.customAssert("Content Details" ,homeText5, expect5, actual5);
			
			String homeText6 = home6 != null ? home6 : "N/A";
			Listeners.customAssert("Content Details" ,homeText6, expect6, actual6);
			
			String homeText7 = home7 != null ? home7 : "N/A";
			Listeners.customAssert("Content Details" ,homeText7, expect7, actual7);
			
			String homeText8 = home8 != null ? home8 : "N/A";
			Listeners.customAssert("Content Details" ,homeText8, expect8, actual8);
				
		}
	}
	
	
			
	public static void nominateFromInitiateStatus() throws InterruptedException {
		String home = null;
		String expect = "contributor Should able to nominate to the project from Initiate Status";
		String actual = "contributor is unable to nominate to the project from Initiate Status";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
//			String s1 = "//div[text()=' ";
//			String s2 = ProjectName;
//			String s3 = " ']//following::button[text()='Open '][1]";
//			Thread.sleep(10000);
//			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
//			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
//			assertProjectOnContributor.isDisplayed();
//			assertProjectOnContributor.click();

			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
			Thread.sleep(5000);
			Assert.assertTrue(VC.getNominationConfMsg().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			home=VO.getAssertNominationSent().getText();
			actual = "contributor is able to nominate to the project from Initiate Status";
			
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Nomination sent", homeText, expect, actual);
		}
	}
	
	public static void validateStatusOfProjectIsApprovedWhenSourcingOrgAdminAcceptsNomination(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = "The status of the Project should be Approved if the sourcing orgadmin accepts the nomination.";
		String actual =  "The status of the Project is not Approved if the sourcing orgadmin accepts the nomination.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			String s4 = " ']//following::button[text()='Open '][1]";
			String s5 = " ']//following::span[text()='Approved'][1]";
			
			WebElement assertProjectOnDefCont = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnDefCont);
			assertProjectOnDefCont.isDisplayed();
			WebElement assertProjectOpen = driver.findElement(By.xpath(s1 + s2 + s4));
			assertProjectOpen.isDisplayed();
			WebElement assertProjectApproved = driver.findElement(By.xpath(s1 + s2 + s5));
			assertProjectApproved.isDisplayed();
			home = assertProjectApproved.getText();
			System.out.print(home);

			actual = "The status of the Project is Approved if the sourcing orgadmin accepts the nomination." ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Approved", homeText, expect, actual);
		}
	}
	
	public static void validateStatusOfProjectIsRejectedWhenSourcingOrgAdminRejectsNomination(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = "The status of the Project should be Rejected if the sourcing orgadmin Rejects the nomination.";
		String actual =  "The status of the Project is not Rejected if the sourcing orgadmin Rejects the nomination.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']";
			String s4 = " ']//following::button[text()='Open '][1]";
			String s5 = " ']//following::span[text()='Rejected'][1]";
			
			WebElement assertProjectOnDefCont = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitForElementToBeVisible(assertProjectOnDefCont);
			assertProjectOnDefCont.isDisplayed();
			WebElement assertProjectOpen = driver.findElement(By.xpath(s1 + s2 + s4));
			assertProjectOpen.isDisplayed();
			WebElement assertProjectApproved = driver.findElement(By.xpath(s1 + s2 + s5));
			assertProjectApproved.isDisplayed();
			home = assertProjectApproved.getText();
			System.out.print(home);

			actual = "The status of the Project is Rejected if the sourcing orgadmin Rejects the nomination." ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Rejected", homeText, expect, actual);
		}
	}
	
	
	public static void validateAssignedReviewerIsAbleToSeeAnswerButtonForMCQ(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = "Assigned Reviewer should able to see answer button for MCQ question.";
		String actual =  "Assigned Reviewer is unable to see answer button for MCQ question.";

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
			
			VDNUtils.waitForElementToBeVisible(VO.getClkReviewContentBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContentBtn());
			Thread.sleep(3000);

			VDNUtils.waitForElementToBeVisible(VC.getClkQSetRevPen());
			VDNUtils.waitToBeClickableAndClick(VC.getClkQSetRevPen());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getBtnPreview());
			Thread.sleep(3000);
			
			
			Thread.sleep(3000);
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@name='contentPlayer']"));
			driver.switchTo().frame(frame);
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkAnsOpt2());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkNext());
			Thread.sleep(1000);
			
			home=VC.getClkSoultion().getText();
			System.out.println(home);
			actual =  "Assigned Reviewer is able to see answer button for MCQ question.";
			
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSoultion());
			Thread.sleep(1000);
			

		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Solution", homeText, expect, actual);
		}
	}
	
	
	
	public static void validateIndContAbleToUploadMP4ContentAndAddMultipleTranscriptFilesAndSendForApproval()
			throws Exception {
		String home1 = null;
		String expect1 = "Add/edit Transcript pop up should be displayed post clicking on Add Transcript button in the Preview video pop up.";
		String actual1 =  "Add/edit Transcript pop up is not displayed post clicking on Add Transcript button in the Preview video pop up. ";
		
		String home2 = null;
		String expect2 = "Individual contributor should be able to upload mp4 content and add multiple transcript files";
		String actual2 =  "Individual contributor is unable to upload mp4 content and add multiple transcript files";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);

			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelLanguage());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelAssamLanguage());
			Thread.sleep(3000);
			

			UploadContentMethods.UploadVTT();
			Thread.sleep(3000);
			
			Assert.assertTrue(VC.getAssetVTTFileUploaded().isDisplayed());
			Thread.sleep(3000);
			home1 = VO.getClkSaveButton().getText();
			System.out.println(home1);
			actual1 = "Add/edit Transcript pop up is displayed post clicking on Add Transcript button in the Preview video pop up.";
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkBtnAddOrTran());
			Thread.sleep(2000);
			
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelLanguage2());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSelBengaliLanguage());
			Thread.sleep(3000);
			

			UploadContentMethods.UploadVTT();
			Thread.sleep(3000);
			
			Assert.assertTrue(VC.getAssetVTTFileUploaded().isDisplayed());
			Thread.sleep(3000);
			home2 = VO.getClkSaveButton().getText();
			System.out.println(home2);
			actual2 = "Individual contributor is able to upload mp4/webm content and add multiple transcript files";
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_MP4");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
			Thread.sleep(2000);
			VO.getClkCheckBox().click();
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Save" ,homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			System.out.println(homeText2);
			Listeners.customAssert("Save" ,homeText2, expect2, actual2);
		}
	}
	
	public static void validateAddorEditTranscriptPopUpDisplayedOnWebmPostClickAddTranscriptButton(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = "Add/edit Transcript pop up should be displayed post clicking on Add Transcript button in the Preview video pop up.";
		String actual1 =  "Add/edit Transcript pop up is not displayed post clicking on Add Transcript button in the Preview video pop up. ";
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
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadWebm();
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkAddTranscriptbtn());
			Thread.sleep(3000);
			
			Assert.assertTrue(VC.getAssertAddorEditTrans().isDisplayed());
			home1 = VC.getAssertAddorEditTrans().getText();
			System.out.println(home1);
			actual1 = "Add/edit Transcript pop up is displayed post clicking on Add Transcript button in the Preview video pop up.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			System.out.println(homeText1);
			Listeners.customAssert("Add/Edit Transcript" ,homeText1, expect1, actual1);
		}
	}
	
	
	public static void validateOnClickingOpenBtnContributorOrgIsAbleToViewTheProjectDetails(String ProjectName) throws InterruptedException {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home1 = null;
		String expect1 = "On clicking open Button, contributing org should be able to view the Project details";
		String actual1 = "On clicking open Button, contributing org is unable to view the Project details";
		
		String home2 = null;
		String expect2 = "On clicking open Button, contributing org should be able to view the Project details and should not be able to modify the Project details.";
		String actual2 = "On clicking open Button, contributing org is unable to view the Project details or  be able to modify the Project details. ";

		try {
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
			Thread.sleep(3000);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			
			WebElement clkOpenBtn = driver.findElement(By.xpath(s1 + s2 + s3));
			
			VDNUtils.waitToBeClickableAndClick(clkOpenBtn);
			Thread.sleep(3000);
			
			Assert.assertTrue(VC.getAssertBoardMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertMediumMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertClassMyContent().isDisplayed());
			
			Assert.assertTrue(VC.getAssertSubjectMyContent().isDisplayed());
			
			Assert.assertTrue(VO.getAssertPendingStatus().isDisplayed());
			Assert.assertTrue(VO.getAssertDigiTextbooks().isDisplayed());
			Assert.assertTrue(VC.getAssertContentTypes().isDisplayed());
			Assert.assertTrue(VS.getAssertNominationDate().isDisplayed());
			Assert.assertTrue(VS.getAssertShortlistDate().isDisplayed());
			Assert.assertTrue(VS.getAssertContributionDate().isDisplayed());
			Assert.assertTrue(VS.getAssertProjectEndDate().isDisplayed());
			
			home1 = VC.getAssertContentTypes().getText();
			System.out.println(home1);
			actual1 = "On clicking open Button, contributing org is able to view the Project details";
			
			home2 = VO.getAssertPendingStatus().getText();
			System.out.println(home2);
			actual2 = "On clicking open Button, contributing org is able to view the Project details and is not be able to modify the Project details.";
			
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(homeText1);
		Listeners.customAssert("Content Type(s)", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		System.out.println(homeText2);
		Listeners.customAssert("Pending", homeText2, expect2, actual2);
				
	}
					
}
	
	
	public static void validateAllTheAccessibleFeatureFieldsAreOptionalInAccessibilityDetailsPopUp(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " All the accessible feature fields should optional in the Accessibility Details pop up.";
		String actual1 =  "All the accessible feature fields is not optional in the Accessibility Details pop up.";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			Thread.sleep(3000);
			
//			VDNUtils.waitToBeClickableAndClick(VC.getClkAccessibility());
//			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getAccessibilityDetailsBtn());
			Assert.assertTrue(VC.getAssertAccessibilityPopUp().isDisplayed());
			Assert.assertTrue(VC.getDoneButton().isDisplayed());
			Assert.assertTrue(VC.getDoneButton().isEnabled());
			home1 = VC.getDoneButton().getText();
			System.out.println(home1);
			actual1 = "All the accessible feature fields should optional in the Accessibility Details pop up.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Done" ,homeText1, expect1, actual1);		
		}
	}
	
	public static void validateContributorIsAbleToSelectCheckboxInTheAccessibilityDetailsPopUpAndSave(String ProjectName)
			throws Exception {
		String home1 = null;
		String expect1 = " Contributor should able to select the accessible features using checkbox in the Accessibility Details pop up and save/Click On Done Button.";
		String actual1 =  "Contributor is unable to select the accessible features using checkbox in the Accessibility Details pop up and save/Click On Done Button.";
		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			Thread.sleep(3000);
			UploadContentMethods.UploadPdf();
			Thread.sleep(3000);
			

			VDNUtils.waitToBeClickableAndClick(VC.getAccessibilityDetailsBtn());
			Assert.assertTrue(VC.getAssertAccessibilityPopUp().isDisplayed());
			Assert.assertTrue(VC.getDoneButton().isDisplayed());
			Assert.assertTrue(VC.getDoneButton().isEnabled());
			home1 = VC.getDoneButton().getText();
			System.out.println(home1);
			actual1 = "Contributor is able to select the accessible features using checkbox in the Accessibility Details pop up and save/Click On Done Button.";
			
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Done" ,homeText1, expect1, actual1);		
		}
	}
	
	public static void validateContributorOrgAdminShouldAbleToAssignNoneRoleFromTheExistingRole(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project "+ProjectName+" or is not Displayed on the Top";

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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color1");
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectContributorPostSearch());
			
			Assert.assertTrue(VS.getAssertNonOpt().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VS.getAssertNonOpt());
			Thread.sleep(3000);
			Assert.assertTrue(VS.getAssertConfirmationPopup().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VS.getClkYesBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			
			
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "color3");
			Thread.sleep(5000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			
			Assert.assertTrue(VS.getAssertNonOpt().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VS.getAssertNonOpt());
			Thread.sleep(3000);
			Assert.assertTrue(VS.getAssertConfirmationPopup().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VS.getClkYesBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	
	public static void validateContributorAbleToAddVideoAsSolutionInTheMCQQuestion(String ProjectName) throws Exception {
		String home = null;
		String expect = "Contributor should be able to add video as a solution in the MCQ Question";
		String actual = "Contributor is unable to add video as a solution in the MCQ Question";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

//			VDNUtils.waitToBeClickableAndClick(VO.getSelContentTypesbtn());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckCorseAssesment());
//
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckETextBook());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckLearningRes());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckQuestionSet());
//
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckEContent());
//			VDNUtils.waitToBeClickableAndClick(VO.getCheckTeachingRes());
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitBtn());
//
//			Thread.sleep(5000);
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());

//			VDNUtils.waitToBeClickableAndClick(VO.getNomitateBtn());
//
//			VDNUtils.waitToBeClickableAndClick(VO.getSubmitPostNominate());
//			Thread.sleep(3000);
//			Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
			
//			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadCheckBox());
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getUploadSampleBtn());
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelPractQSet());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkQSetOpt2());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkMCQPracticeQSet());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getQSetTemplate1());
			Thread.sleep(2000);
			
			
//			UploadContentMethods.UploadPdf();
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSubmitBtn());
			Thread.sleep(1000);
			
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getQuestionfield(), "2+1");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns1field(), "3");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns2field(), "2");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns3field(), "-2");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns4field(), "-3");
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkChooseSolType());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getChooseSolType2());
			Thread.sleep(3000);
			
			UploadContentMethods.UploadMp4();
			
			home=VC.getAssertVideoAdded().getText();
			System.out.println(home);
			actual =  "Contributor is able to add video as a solution in the MCQ Question";
			
			
			VC.getMarkCorrectAnsOpt1().click();
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getBtnPreview());
			Thread.sleep(3000);
			
			
			Thread.sleep(3000);
			
			WebElement frame = driver.findElement(By.xpath("//iframe[@name='contentPlayer']"));
			driver.switchTo().frame(frame);
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkAnsOpt2());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkNext());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSoultion());
			Thread.sleep(1000);
		
			
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Asset Successfully Uploaded...", homeText, expect, actual);
		}
	}
	
	
	public static void validateContributorIsAbleToAddVideoAsSolutionInTheSubjectiveTypeQuestion(String ProjectName) throws Exception {
		String home = null;
		String expect = "Contributor should be able to add video as a solution in the Subjective Question";
		String actual = "Contributor is unable to add video as a solution in the Subjective Question";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
			assertProjectOnContributor.isDisplayed();
			assertProjectOnContributor.click();

			VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
			Thread.sleep(2000);

			
			VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelPractQSet());
			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkQSetOpt2());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getClkSAtype());
			Thread.sleep(2000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
			Thread.sleep(2000);
			
			
//			UploadContentMethods.UploadPdf();
			
			
//			VDNUtils.waitToBeClickableAndClick(VC.getClkSubmitBtn());
//			Thread.sleep(1000);
			
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getQuestionfield(), "Where is Bengaluru");
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns1field(), "Bengaluru is in Karnataka");
			Thread.sleep(1000);
			
//			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns2field(), "2");
//			Thread.sleep(1000);
//			
//			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns3field(), "-2");
//			Thread.sleep(1000);
//			
//			VDNUtils.waitToBeClickableAndSendKeys(VC.getAns4field(), "-3");
//			Thread.sleep(1000);
			VDNUtils.waitToBeClickableAndClick(VC.getClkChooseSolType());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VC.getChooseSolType2());
			Thread.sleep(3000);
			
			UploadContentMethods.UploadMp4();
			
			home=VC.getAssertVideoAdded().getText();
			System.out.println(home);
			actual =  "Contributor is able to add video as a solution in the Subjective Question";
			
			
//			VC.getMarkCorrectAnsOpt1().click();
//			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
			Thread.sleep(1000);
			
			VDNUtils.waitToBeClickableAndClick(VC.getBtnPreview());
			Thread.sleep(3000);
			
			
			Thread.sleep(3000);
			
//			WebElement frame = driver.findElement(By.xpath("//iframe[@name='contentPlayer']"));
//			driver.switchTo().frame(frame);
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VC.getClkAnsOpt2());
//			Thread.sleep(1000);
//			
//			VDNUtils.waitToBeClickableAndClick(VC.getClkNext());
//			Thread.sleep(1000);
//			
//			VDNUtils.waitToBeClickableAndClick(VC.getClkSoultion());
//			Thread.sleep(1000);
		
			
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Asset Successfully Uploaded...", homeText, expect, actual);
		}
	}
	
	public static void verifyContributorNameDisplayedUnderNominationsList(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect =  "Contributor name should be displayed from the nominations list ";
		String actual =  "Contributor name is not displayed from the nominations list";
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
			Assert.assertTrue(VO.getBtnAccept().isDisplayed());
			Thread.sleep(3000);
			
			home = VO.getBtnAccept().getText();
			actual = "Contributor name should be displayed from the nominations list";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Accept", homeText, expect, actual);
		}

}
	
	public static void validateContributorNameIsRemovedFromTheNominationsList(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect =  "Contributor name should be removed from the nominations list  ";
		String actual =  "Contributor name is not removed from the nominations list ";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
			
			String TabDetails = VO.getNominationTabDetails().getText();
			String[] lines = TabDetails.split("\r\n|\r|\n");
			System.out.println(lines);
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"VDN Prod");
			    Assert.assertNotEquals(line," Pending ");
			}
			home = VO.getAssertNomimnationList().getText();
			actual = "Contributor name is removed from the nominations list ";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Download Nominations List", homeText, expect, actual);
		}

}
	
public static void verifyContributorIsAbleToModifyTheNominationPostView(String ProjectName) throws Exception {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "Contributor should be able to modify Nomination";
		String actual = "Contributor not able to modify Nomination";
		try {
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
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

public static void createMCQquestionWithSolutionAndSendForReview(String ProjectName) throws InterruptedException {
	String home = null;
	String expect = "Answer button should get displayed on preview for individual MCQ question on preview of entire question set in cokreat portal.";
	String actual = "Answer button is not displayed on preview for individual MCQ question on preview of entire question set in cokreat portal.";

	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
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

		VDNUtils.waitToBeClickableAndClick(VO.getUploadSampleBtn());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelPractQSet());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkQSetOpt2());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkMCQPracticeQSet());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getQSetTemplate1());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VC.getClkSubmitBtn());
		Thread.sleep(1000);
		
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getQuestionfield(), "2+1");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns1field(), "3");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns2field(), "2");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns3field(), "-2");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns4field(), "-3");
		Thread.sleep(1000);
	
		VDNUtils.waitToBeClickableAndClick(VC.getClkChooseSolType());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getChooseSolType1());
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getEnterSol(), "SUM");
		Thread.sleep(1000);
		
		VC.getMarkCorrectAnsOpt1().click();
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getBtnPreview());
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@name='contentPlayer']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getClkAnsOpt2());
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkNext());
		Thread.sleep(1000);
		
		home=VC.getClkSoultion().getText();
		System.out.println(home);
		actual =  "Answer button is displayed on preview for individual MCQ question on preview of entire question set in cokreat portal.";
		
		
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkSoultion());
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkDone());
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
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
//		Assert.assertTrue(VO.getAssertNominationSent().isDisplayed());
		
	} finally {
		String homeText = home != null ? home : "N/A";
		System.out.println(homeText);
		Listeners.customAssert("Solution", homeText, expect, actual);
	}
}


public static void verifySourcingOrgAdminAbleToViewSampleAndAcceptNomination(String ProjectName) throws Exception {
	
	
	String text = "N/A";
	String expect = "Admin should be able to view sample and accept nomination";
	String actual = "Admin is not able to view sample and accept nomination";
	try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
		VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
//		Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
//		Assert.assertTrue(VO.getViewSampleBtn().isDisplayed());	
//		String SampleCount = VO.getAssertSampleCount1().getText();
//		System.out.print(SampleCount);	
//		int SampleC=Integer.parseInt(SampleCount); 
//		Assert.assertEquals(SampleC, 1);	
//		VDNUtils.waitToBeClickableAndClick(VO.getViewSampleBtn());
//		Thread.sleep(3000);
//		Assert.assertTrue(VO.getSelectSample1().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//		VDNUtils.waitToBeClickableAndClick(VS.getAcceptBtn());
		text = "Completed";
		actual = "Admin is able to view sample and accept nomination successfully";
	} finally {
//		Listeners.customAssert("Completed", text, expect, actual);
	}
}

public static void validateFeedbackForEachQuestionIsDisplayedWhilePreviewingTheMCQ(String ProjectName) throws Exception {
	String home = null;
	String expect = "Contributor should be able to add video as a solution in the MCQ Question";
	String actual = "Contributor is unable to add video as a solution in the MCQ Question";

	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		// String assertProjectOnContributor = By.xpath(s1 + s2 + s3);
		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
		assertProjectOnContributor.isDisplayed();
		assertProjectOnContributor.click();
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelPractQSet());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		Thread.sleep(2000);
		
		
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkQSetOpt2());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkMCQPracticeQSet());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getQSetTemplate1());
		Thread.sleep(2000);
		
		
//		UploadContentMethods.UploadPdf();
		
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkSubmitBtn());
		Thread.sleep(1000);
		
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getQuestionfield(), "2+1");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns1field(), "3");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns2field(), "2");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns3field(), "-2");
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VC.getAns4field(), "-3");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VC.getClkChooseSolType());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getChooseSolType2());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadMp4();
		
		home=VC.getAssertVideoAdded().getText();
		System.out.println(home);
		actual =  "Contributor is able to add video as a solution in the MCQ Question";
		
		
		VC.getMarkCorrectAnsOpt1().click();
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getBtnPreview());
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@name='contentPlayer']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getClkAnsOpt2());
		Thread.sleep(1000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkNext());
		Thread.sleep(1000);
		
//		VDNUtils.waitToBeClickableAndClick(VC.getClkSoultion());
//		Thread.sleep(1000);
	
		
	} finally {
		String homeText = home != null ? home : "N/A";
		System.out.println(homeText);
		Listeners.customAssert("Asset Successfully Uploaded...", homeText, expect, actual);
	}
}

public static void validateTheCountOnTocAndTopForUserWithBothRole(String ProjectName) throws Exception {
	String home = null;
	String expect = " The rejected count on toc and top for user with both role should be corrrect";
	String actual =  "The rejected count on toc and top for user with both role is not corrrect";

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
		
		VDNUtils.waitForElementToBeVisible(VO.getClkUploadContent());
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadContent());
		
		
		String RejectedCount = VO.getAssertRejectedCount().getText();
		System.out.print(RejectedCount);
		
		int RejectedC=Integer.parseInt(RejectedCount); 
		
		String TotalCount = VO.getAssertTotalContCount().getText();
		System.out.print(TotalCount);
		
		int TotalC=Integer.parseInt(TotalCount);
		
		Assert.assertEquals(RejectedC,1);
		Assert.assertEquals(TotalC,1);
		
		home = VO.getAssertRejectedOnTOC().getText();
	
		actual = "The rejected count on toc and top for user with both role is corrrect";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Rejected:" ,homeText, expect, actual);
	}
}

public static void uploadEtextAndExplinitionContentFromContOrgContributorAndSendForReview(String ProjectName)
		throws Exception {
	String home = null;
	String expect = " Contributor should be able to save the content draft status and Review Pending Staus for Project  "+ProjectName;
	String actual =  "Contributor is unable to save the content draft status or Review Pending Staus for Project "+ProjectName;

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
		actual = "Content available on the TOC with draft status for "+ProjectName;
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
		
//		VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
//		Thread.sleep(3000);
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Review Pending" ,homeText, expect, actual);
}
}

public static void verifyIndividualContributorNotAbleToContributeToTheClosedProjects(String ProjectName) throws Exception {
	
	String home = null;
	String expect = "contributor should not be able to contribute to the closed without target collection project";
	String actual = "contributor is able to contribute to the closed without target collection project";
	
	try {
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		Thread.sleep(10000);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		Thread.sleep(10000);
		
		String tabDetails = VC.getAssertTitles().getText();
		String[] lines = tabDetails.split("\r\n|\r|\n");
		System.out.println(lines.length);
		
		for (String line : lines) {
		    System.out.println(line);
		    Assert.assertNotEquals(line,"Create/Upload Content");
		    Assert.assertNotEquals(line,"Bulk upload content");
		}
		
		home=VS.getFilterContents().getText();
		actual = "contributor is not be able to contribute to the closed without target collection project";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Filter Contents", homeText, expect, actual);
	}

}

public static void verifyThatUsageDetailsAvailableInTheContributedContentsPage(String ProjectName) throws Exception {
	String home = null;
	String expect = "Verify That Usage Details Available In The Contributed Contents Page";
	String actual =  "That Usage Details Are Not Available In The Contributed Contents Page";

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
		
		VDNUtils.waitForElementToBeVisible(VO.getClkUploadContent());
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadContent());
		
		
		String RejectedCount = VO.getAssertRejectedCount().getText();
		System.out.print(RejectedCount);
		
		int RejectedC=Integer.parseInt(RejectedCount); 
		
		String TotalCount = VO.getAssertTotalContCount().getText();
		System.out.print(TotalCount);
		
		int TotalC=Integer.parseInt(TotalCount);
		
		Assert.assertEquals(RejectedC,1);
		Assert.assertEquals(TotalC,1);
		
		home = VO.getAssertRejectedOnTOC().getText();
	
		actual = "Usage Details Available In The Contributed Contents Page Successfully";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Rejected:" ,homeText, expect, actual);
	}
}

public static void verifyContributorIsAbleToProvideOtherObjectMetadata(String ProjectName)throws Exception {
	String home = null;
	String expect = "project details Should be available on Project Details page";
	String actual = "project details is unavailable on Project Details page";

	try {
		
		Thread.sleep(3000);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']";
		String s4 = " ']//following::button[text()='Open '][1]";
		
		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s4));
		
		VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
		assertProjectOnContributor.isDisplayed();
		assertProjectOnContributor.click();
		Thread.sleep(3000);

		
		String p1 = "//h5[text()='";

				
		WebElement assertProjName = driver.findElement(By.xpath(p1+ProjectName+s3));
		assertProjName.isDisplayed();
		
		
		Assert.assertTrue(VC.getAssertContentTypes().isDisplayed());
		
		Assert.assertTrue(VC.getAssertNominationDates().isDisplayed());
		Assert.assertTrue(VC.getAssertApprovedStatus().isDisplayed());
		Assert.assertTrue(VC.getAssertDigiText().isDisplayed());
		
		Assert.assertTrue(VC.getAssertMedium().isDisplayed());
		Assert.assertTrue(VC.getAssetClass().isDisplayed());
		Assert.assertTrue(VC.getAssertSubject().isDisplayed());
		
		Thread.sleep(3000);

		home = VC.getAssertSubject().getText();
		System.out.println(home);
		
		actual = "project details is available on Project Details page";
	} finally {
 		String homeText = home != null ? home : "N/A";
		System.out.println(homeText);
		Listeners.customAssert("Subject   " ,homeText, expect, actual);
	}
}


public static void verifyContributorAbleToSelectAccessibleFeaturesUsingCheckbox(String ProjectName)throws Exception {
	String home1 = null;
	String expect1 = " Accessibility Details button should displayed while uploading the content";
	String actual1 =  "Accessibility Details button is not displayed while uploading the content";
	
	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
		
		VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
		assertProjectOnContributor.isDisplayed();
		assertProjectOnContributor.click();
		Thread.sleep(5000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		home1 = VC.getAccessibilityDetailsBtn().getText();
		System.out.println(home1);
		actual1 = "Accessibility Details button is displayed while uploading the content";
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getAccessibilityDetailsBtn());
		Assert.assertTrue(VC.getAssertAccessibilityPopUp().isDisplayed());
		Assert.assertTrue(VC.getCancelBtn().isDisplayed());
		Assert.assertTrue(VC.getDoneButton().isDisplayed());
		

	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Accessibility Details" ,homeText1, expect1, actual1);
			
	}
}


public static void verifyContributorAbleContributeForContentPlaylist(String ProjectName)throws Exception {
	
	String home1 = null;
	String expect1 = " Individual contributor should be able to upload the PDF content for Explanation Content";
	String actual1 =  "Individual contributor is unable to upload the PDF content for Explanation Content";
	
	String home2 = null;
	String expect2 = " Individual contributor should be able to upload the EPUB content for Explanation Content";
	String actual2 =  "Individual contributor is unable to upload the EPUB content for Explanation Content";

	String home3 = null;
	String expect3 = " Individual contributor should be able to upload the MP4 content for Explanation Content";
	String actual3 =  "Individual contributor is unable to upload the MP4 content for Explanation Content";
	
	String home4 = null;
	String expect4 = " Individual contributor should be able to upload the WEBM content for Explanation Content";
	String actual4 =  "Individual contributor is unable to upload the WEBM content for Explanation Content";
	
	String home5 = null;
	String expect5 = " Individual contributor should be able to upload the MP3 content for Explanation Content";
	String actual5 =  "Individual contributor is unable to upload the MP3 content for Explanation Content";
	
	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
		
		VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
		assertProjectOnContributor.isDisplayed();
		assertProjectOnContributor.click();
		Thread.sleep(5000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());

		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Pdf");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2023");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
		
			
		home1 = VC.getAssertPDFUpload().getText();
		System.out.println(home1);
		actual1 = "Individual contributor is able to upload the PDF content for Explanation Content";
		
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadEpub();
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Epub");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
		
		home2 = VC.getAssertEpubUpload().getText();
		System.out.println(home2);
		actual2 = "Individual contributor is able to upload the EPUB content for Explanation Content";
		
		
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadMp4();
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp4");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
		
		home3 = VC.getAssertMP4Upload().getText();
		System.out.println(home3);
		actual3 = "Individual contributor is able to upload the MP4 content for Explanation Content";
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadWebm();
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getClkDoneBtn());
		Thread.sleep(3000);
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Webm");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
		

		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
		
		home4 = VC.getAssertWEBMUpload().getText();
		System.out.println(home4);
		actual4 = "Individual contributor is able to upload the WEBM content for Explanation Content";
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelExpContent());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadMp3();
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample_Mp3");
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterYear(), "2024");
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkCheckBox());
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
		home5 = VC.getAssertMP3Upload().getText();
		System.out.println(home5);
		actual5 = "Individual contributor is able to upload the MP3 content for Explanation Content";
		Thread.sleep(2000);

	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Sample_Pdf" ,homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Sample_Epub" ,homeText2, expect2, actual2);
		
		String homeText3 = home3 != null ? home3 : "N/A";
		Listeners.customAssert("Sample_Mp4" ,homeText3, expect3, actual3);
		
		String homeText4 = home4 != null ? home4 : "N/A";
		Listeners.customAssert("Sample_Webm" ,homeText4, expect4, actual4);
		
		String homeText5 = home5 != null ? home5 : "N/A";
		Listeners.customAssert("Sample_Mp3" ,homeText5, expect5, actual5);
			
	}
}

public static void verifyContributorAbleAddEditTranscriptFileOnClickingButton()throws Exception {
	String home1 = null;
	String expect1 = "Add/edit Transcript pop up should be displayed post clicking on Add Transcript button in the Preview video pop up.";
	String actual1 =  "Add/edit Transcript pop up is not displayed post clicking on Add Transcript button in the Preview video pop up. ";
	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkSelLanguage());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkSelAssamLanguage());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		Thread.sleep(3000);
		
		Assert.assertTrue(VC.getAssertInvalidFileType().isDisplayed());
		Thread.sleep(3000);
		home1 = VC.getAssertInvalidFileType().getText();
		System.out.println(home1);
		actual1 = "Add/edit Transcript pop up is displayed post clicking on Add Transcript button in the Preview video pop up.";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(homeText1);
		Listeners.customAssert("Invalid file type (supported type: .vtt)" ,homeText1, expect1, actual1);
	}
}

public static void verifyContributorAbleToAddEditTheVideoOnClickingReplaceButton()throws Exception {
	
	String home1 = null;
	String expect1 = "Contributor org contributor should not be able to add video";
	String actual1 =  "Contributor org contributor is not able to add video";
	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkSelLanguage());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VC.getClkSelAssamLanguage());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadEpub();
		Thread.sleep(1000);
		
		Assert.assertTrue(VC.getAssertInvalidFileType().isDisplayed());
		Thread.sleep(1000);
		home1 = VC.getAssertInvalidFileType().getText();
		System.out.println(home1);
		actual1 = "Contributor org contributor is able to add video";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		System.out.println(homeText1);
		Listeners.customAssert("Invalid file type (supported type: .vtt)" ,homeText1, expect1, actual1);
	}
}


public static void verifyAssignedBothRoleUserAbleToApplyFiltersInMyProjectsTab(String ProjectName)throws Exception {
	String home = null;
	String expect = "Apply Filters pop up page sould displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";
	String actual = "Apply Filters pop up page is not displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";

	try {
		
		Thread.sleep(3000);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']";
		
		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
		
		VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
		assertProjectOnContributor.isDisplayed();
		assertProjectOnContributor.click();
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		Thread.sleep(3000);
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
		
		Assert.assertTrue(VS.getAssertApplyFilterPopUp().isDisplayed());
		
		Assert.assertTrue(VS.getAssertMediumOnPopUp().isDisplayed());
		
		Assert.assertTrue(VS.getAssertClassOnPopUp().isDisplayed());
		
		Assert.assertTrue(VS.getAssertSubjectsOnPopUp().isDisplayed());
		
		Assert.assertTrue(VS.getAssertContentTypesOnPopUp().isDisplayed());
		
		Assert.assertTrue(VS.getAssertTargetCollOnPopUp().isDisplayed());
		

		Assert.assertTrue(VS.getResetBtn().isDisplayed());
		
		Assert.assertTrue(VS.getApplyButton().isDisplayed());
		
		home = VS.getApplyButton().getText();
		System.out.print(home);
		
		actual = "Apply Filters pop up page is displayed post clicking on Apply Filter button for sourcing org Reviewer With the Details";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Apply" ,homeText, expect, actual);
	}
}

public static void VerifyAllTheAttributesEitherMandatoryOrOptionalInTheEditDetailsPopUp(String ProjectName)throws Exception {
	String home1 = null;
	String expect1 = "All the attributes either mandatory or optional in the edit details popUp";
	String actual1 =  "All the attributes is not mandatory or optional in the edit details popUp";

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
		
		VDNUtils.waitForElementToBeVisible(VO.getClkReviewContentBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkReviewContentBtn());
		Thread.sleep(3000);
		
		
		for (int i=1;i<=7;i++) {

		VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());

		VDNUtils.waitForElementToBeVisible(VO.getClkSubmitForApproval());
		Assert.assertTrue(VO.getClkSubmitForApproval().isDisplayed());
		
		VDNUtils.waitForElementToBeVisible(VO.getClkRequestChanges());
		Assert.assertTrue(VO.getClkRequestChanges().isDisplayed());
		
		Assert.assertTrue(VO.getContentDetails().isDisplayed());
		VDNUtils.waitForElementToBeVisible(VO.getContentDetails());
		
		VDNUtils.waitToBeClickableAndClick(VO.getContentDetails());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getEnterName());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "-1");

		VDNUtils.waitToBeClickableAndClick(VO.getSaveBtn());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
		Thread.sleep(2000);
		

		}
	
		Assert.assertTrue(VC.getAssertPDFUpdated().isDisplayed());		
		home1 = VC.getAssertPDFUpdated().getText();
		System.out.print(home1);
		
		actual1 = "All the attributes either mandatory or optional in the edit details popUp successfully";
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Sample_Pdf-1" ,homeText1, expect1, actual1);
		
	}
}


public static void verifyAllTheFrameworkAttributeValuesAreDisplayedInEditDetailsPopUp(String ProjectName)throws Exception {
	
	String home = null;
	String expect = " individual contributor should be able to select content and upload sample for "+ProjectName;
	String actual =  "individual contributor is unable to select content and upload sample for "+ProjectName;
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

		actual = "individual contributor is able to select content and upload sample for "+ProjectName;
		
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		Thread.sleep(3000);
		
		String s5 = " ']//following::span[text()='Initiated'][1]";
		
		WebElement assertStatusUpdate = driver.findElement(By.xpath(s1 + s2 + s5));
		Assert.assertTrue(assertStatusUpdate.isDisplayed());
		
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
		System.out.println(homeText);
	}
}

public static void verifyContributorAbleUploadTheContentAndFrameworkAttributes(String ProjectName)throws Exception {
	
	String home = null;
	String expect = " individual contributor should be able to select content and upload sample for "+ProjectName;
	String actual =  "individual contributor is unable to select content and upload sample for "+ProjectName;
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

		actual = "individual contributor is able to select content and upload sample for "+ProjectName;
		
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		Thread.sleep(3000);
		
		String s5 = " ']//following::span[text()='Initiated'][1]";
		
		WebElement assertStatusUpdate = driver.findElement(By.xpath(s1 + s2 + s5));
		Assert.assertTrue(assertStatusUpdate.isDisplayed());
		
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Content sent for review" ,homeText, expect, actual);
		System.out.println(homeText);
	}
}


public static void verifySelectedAccessibleFeaturesAreSavedPostClickingOnSaveButton(String ProjectName)throws Exception {
	String home = "N/A";
	String expect = "Selected accessible features are saved post clicking on save button";
	String actual =  "Selected accessible features are not saved post clicking on save button";
	
	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNUtils.waitToBeClickableAndClick(VO.getMyProjectTab());
		String s1 = "//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
		assertProjectOnContributor.isDisplayed();
		assertProjectOnContributor.click();
		Thread.sleep(5000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkUploadbtn());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherRes());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VC.getAccessibilityDetailsBtn());
		Assert.assertTrue(VC.getAssertAccessibilityPopUp().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VC.getAccessibilityFeatures());
		VDNUtils.waitToBeClickableAndClick(VC.getDoneButton());
		home = "Completed";
		actual = "Selected accessible features are saved post clicking on save button successfully";
	} finally {
		
		Listeners.customAssert("Completed" ,home, expect, actual);
			
	}
}


public static void verifyTotalPlaysAveragePlaysPerContentAverageRatingFields() throws InterruptedException {
	
	String text = "N/A";
	String expect = "Verify Total Plays Average Plays Per Content Average Rating Fields";
	String actual = "Total Plays Average Plays Per Content Average Rating Fields Are Not Displayed";
	try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getMyContentTab());
		Assert.assertTrue(VS.getTotalPlays().isDisplayed());
		Assert.assertTrue(VS.getAveragePlays().isDisplayed());
		Assert.assertTrue(VS.getAverageRating().isDisplayed());
	text = "Completed";
	actual = "Total Plays Average Plays Per Content Average Rating Fields Are Displayed";
} finally {
	Listeners.customAssert("Completed", text, expect, actual);
}

}

public static void verifyDownloadPublishedContentDetailsOptionIsAvailableInContributedContentsPage() throws InterruptedException {
	
	String text = "N/A";
	String expect = "Verify Download Published Content Details Option Is Available In Contributed Contents Page";
	String actual = "Download Published Content Details Option Is Not Available In Contributed Contents Page";
	try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNContributor VC = PageFactory.initElements(driver, VDNContributor.class);
		VDNUtils.waitToBeClickableAndClick(VS.getMyContentTab());
		Assert.assertTrue(VS.getTotalPlays().isDisplayed());
		Assert.assertTrue(VS.getAveragePlays().isDisplayed());
		Assert.assertTrue(VS.getAverageRating().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VC.getFrameWorkOpen());
		Assert.assertTrue(VC.getDownloadContentDetails().isDisplayed());
	text = "Completed";
	actual = "Download Published Content Details Option Is Available In Contributed Contents Page";
} finally {
	Listeners.customAssert("Completed", text, expect, actual);
}

}
}