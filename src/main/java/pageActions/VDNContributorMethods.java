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

}