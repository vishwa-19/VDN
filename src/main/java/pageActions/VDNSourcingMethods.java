package pageActions;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.awt.RenderingHints.Key;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
import pageObject.VDNSourcing;

public class VDNSourcingMethods extends BaseClass {

	public static void validateTabsAvailableUnderMyProjectsTab()
			throws Exception {
		String home = null;
		String expect = "1.For Books/Course/Other Collections 2.For individual content not for any collection 3. For Question sets Tabs Should Displayed After Login Sourcing Portal";
		String actual = "1.For Books/Course/Other Collections 2.For individual content not for any collection 3. For Question sets Tabs Not Displayed After Login Sourcing Portal";

		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		
			Assert.assertTrue(VS.getAssertCollection().isDisplayed());
			Assert.assertTrue(VS.getAssertForQSet().isDisplayed());
			Assert.assertTrue(VS.getAssertIndContent().isDisplayed());
			
			home = VS.getAssertIndContent().getText();
			System.out.print(home);
			
			actual = "1.For Books/Course/Other Collections 2.For individual content not for any collection 3. For Question sets Tabs Displayed After Login Sourcing Portal";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("For individual content not for any collection" ,homeText, expect, actual);
		}
	}
	
	
	public static void validateyApplyFiltersPopUpPageAndItsDetails()
			throws Exception {
		String home = null;
		String expect = "Apply Filters pop up page sould displayed post clicking on Apply Filter button for sourcing orgadmin With the Details";
		String actual = "Apply Filters pop up page is not displayed post clicking on Apply Filter button for sourcing orgadmin With the Details";

		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			Thread.sleep(3000);
			
			Assert.assertTrue(VS.getAssertApplyFilterPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertMediumOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertClassOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertSubjectsOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertContentTypesOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertTargetCollOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getAssertNominationDateOnPopUp().isDisplayed());
		
			Assert.assertTrue(VS.getAssertContributionDateOnPopUp().isDisplayed());
			
			Assert.assertTrue(VS.getResetBtn().isDisplayed());
			
			Assert.assertTrue(VS.getApplyButton().isDisplayed());
			
			home = VS.getApplyButton().getText();
			System.out.print(home);
			
			actual = "Apply Filters pop up page is displayed post clicking on Apply Filter button for sourcing orgadmin With the Details";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Apply" ,homeText, expect, actual);
		}
	}
	
	public static void verifyAdminIsAbleToDeleteTheDraftProject(String ProjectName)
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
	
	
	
	public static void verifyConfirmationPopUpIsDisplayed(String ProjectName)
			throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String ConfirmationPopUp = null;
		String expect = " Confirmation pop up should be displayed post clicking on delete icon.";
		String actual = " Confirmation pop up is Not displayed post clicking on delete icon.";
		try {

		String s4 = "(//div[text()=' ";
		String s5 = ProjectName;
		String s6 = " ']//following::span[text()='Edit Draft'])[1]";
		String s7 = " ']//following::div[@class='sb-dock-icon-tooltip d-inline-block'])[1]";
		Thread.sleep(10000);
		WebElement assertProjectUpdated = driver.findElement(By.xpath(s4 + s5 + s6));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", assertProjectUpdated);
		assertProjectUpdated.isDisplayed();
		WebElement clkProjectDelete = driver.findElement(By.xpath(s4 + s5 + s7));
		clkProjectDelete.click();
		Thread.sleep(5000);
		
		Assert.assertTrue(VS.getAssertHeaerConfirmationPopUp().isDisplayed());
		
		Assert.assertTrue(VS.getAssertConfirmationPopUpMsg().isDisplayed());
		
		Assert.assertTrue(VO.getConfirmDeletion().isDisplayed());
		
		Assert.assertTrue(VS.getAssertNoOption().isDisplayed());
				
		ConfirmationPopUp = VS.getAssertConfirmationPopUpMsg().getText();
		actual = " Confirmation pop up Message displayed post clicking on delete icon.";
	
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getCloseConfirmationIcon());
		
	} finally {
		String ConfirmationPopUpText = ConfirmationPopUp != null ? ConfirmationPopUp : "N/A";
		Listeners.customAssert("Are you sure you want to delete this project?", ConfirmationPopUpText, expect, actual);
	}
	}
	
	public static void validateErrorMessageIsDisplayedOnClickOfDeleteForTheProjectWithNominations(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = " Error message should displayed on click of delete for the Project "+ProjectName+" with nominations";
		String actual = " Error message is not displayed on click of delete for the Project "+ProjectName+" with nominations";
		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::span[@class='sb-dotmenu'])[1]";
			//String s4 = "']//following::a[text()='Delete '])[1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			WebElement clkProjectKebab = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkProjectKebab);
			String s4 = "//div[text()=' ";
			String s5 = ProjectName;
			String s6 = " ']//following::a[text()='Delete '][1]";
			WebElement clkDelete = driver.findElement(By.xpath(s4 + s5 + s6));
			VDNUtils.waitToBeClickableAndClick(clkDelete);
			Assert.assertTrue(VS.getAssertErrorMsgOnDeleteNominatedProject().isDisplayed());
			
			home = VS.getAssertErrorMsgOnDeleteNominatedProject().getText();
			actual = " Error message displayed on click of delete for the Project "+ProjectName+" with nominations";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("The project cannot be deleted because it has nominations", homeText, expect, actual);
		}

}
	
	public static void verifySelectContributorsPopUpIsDisplayed() throws Exception {
		String home = null;
		String expect = "sourcing orgadmin should be able to search the contributor using contributor name, select and deselect the contributor";
		String actual = "sourcing orgadmin should not be able to search the contributor using contributor name, select and deselect the contributor";

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
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSelectedContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
		VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
		Thread.sleep(3000);
		Assert.assertTrue(VS.getAssertSelectContributorPopUpHeader().isDisplayed());
		Assert.assertTrue(VS.getAssertContributorTypeLabel().isDisplayed());
		Assert.assertTrue(VS.getAssertSaveBtn().isDisplayed());
		Assert.assertTrue(VS.getAssertCloseBtn().isDisplayed());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		
		Assert.assertTrue(VS.getAssertContributorSelected().isDisplayed());
		
		VDNUtils.waitForElementToBeVisible(VS.getAssertContributorSelected());
		VDNUtils.waitToBeClickableAndClick(VS.getAssertContributorSelected());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());		
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());	
		Assert.assertTrue(VO.getClkSelectContributors().isDisplayed());
		
		home = VO.getClkSelectContributors().getText();
		actual = "sourcing orgadmin should is able to search the contributor using contributor name, select and deselect the contributor";

	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Select Contributors", homeText, expect, actual);
	}

	}

	public static String CreateAndSaveProjectWithNameAlone() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin is able to Save The Project with Name Alone Successfully";
		String actual = "Sourcing org admin is unable to Save The Project with Name Alone Successfully";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);

			VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

			VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

			String ProjectName = VDNUtils.set_Content_Name("AutoP_");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

//			String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
//			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

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
			actual = "Sourcing org admin is able to Save The Project with Name Alone Successfully";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project saved as draft successfully!", homeText, expect, actual);
		}

	}
	
	public static void verifyStatusOfTheProjectCreatedWithEditAndDelOpt(String ProjectName) throws InterruptedException  {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = " Draft Status ,Edit draft and Delete icon should be available for "+ProjectName;
		String actual = " Draft Status ,Edit draft and Delete icon is not available for "+ProjectName;
		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::div[text()='Draft'])[1]";
			//String s4 = "']//following::a[text()='Delete '])[1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			WebElement assertDraftStatus = driver.findElement(By.xpath(s1 + s2 + s3));
			//DNUtils.waitToBeClickableAndClick(clkProjectKebab);
			Assert.assertTrue(assertDraftStatus.isDisplayed());
			String s4 = " ']//following::span[text()='Edit Draft'])[1]";
			String s5 = " ']//following::div[@class='sb-dock-icon-tooltip d-inline-block'])[1]";
			String s6 = " ']//following::a[text()='Delete '][1]";
			WebElement assertEditDraft = driver.findElement(By.xpath(s1 + s2 + s4));
			Assert.assertTrue(assertEditDraft.isDisplayed());
			//VDNUtils.waitToBeClickableAndClick(clkDelete);
			
			WebElement assertDeleteIcon = driver.findElement(By.xpath(s1 + s2 + s5));
			Assert.assertTrue(assertDeleteIcon.isDisplayed());
			
			//VDNUtils.waitToBeClickableAndClick();
			assertDeleteIcon.click();
			VDNUtils.waitToBeClickableAndClick(VO.getConfirmDeletion());
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertDeleteMsg());
			
			Assert.assertTrue(VO.getAssertDeleteMsg().isDisplayed());
			
			home = VO.getAssertDeleteMsg().getText();
			//Assert.assertTrue(VS.getAssertErrorMsgOnDeleteNominatedProject().isDisplayed());
			
//			home = VS.getAssertErrorMsgOnDeleteNominatedProject().getText();
			actual = " Draft Status ,Edit draft and Delete icon should be available for "+ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("The project has been deleted successfully.", homeText, expect, actual);
		}
		
	}
	public static String validateSourcingOrgadminIsAbleToClickOpenAndViewTheProjectDetails() throws InterruptedException {
		String home = null;
		String expect = "Sourcing org admin should be able to view the Project details";
		String actual = "Sourcing org admin is unable to view the Project details";
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
			actual = "Sourcing org admin is able to view the Project details";
			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
		}

}
	
	public static String createProjectWithDigitalTextBookAndSaveAsDraft() throws InterruptedException {
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
	
	
	
	public static void validateOrgadminIsAbleToAddOrRemoveBySelectingContributorsAndSaveProjectAsDraft(String ProjectName)
			throws InterruptedException, IOException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String home = null;
		String expect = "Sourcing orgadmin should be able to create the project by selecting the contributors and save the project as Draft.";
		String actual = "Sourcing orgadmin is unable to create the project by selecting the contributors and save the project as Draft";
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
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSelectedContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
		VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		Assert.assertTrue(VS.getAssertSelectContributorPopUpHeader().isDisplayed());
		Assert.assertTrue(VS.getAssertContributorTypeLabel().isDisplayed());
		Assert.assertTrue(VS.getAssertSaveBtn().isDisplayed());
		Assert.assertTrue(VS.getAssertCloseBtn().isDisplayed());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		
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
		WebElement clkUpatedProject = driver.findElement(By.xpath(s4 + s5 + s6));
		clkUpatedProject.click();
//		VDNUtils.waitToBeClickableAndClick(VO.getConfirmDeletion());
//		
//		VDNUtils.waitForElementToBeVisible(VO.getAssertDeleteMsg());
//		
//		Assert.assertTrue(VO.getAssertDeleteMsg().isDisplayed());
		
//		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSelectedContributors());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
//		VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
		
		Assert.assertTrue(VS.getAssertContributorSelected().isDisplayed());
		
		VDNUtils.waitForElementToBeVisible(VS.getAssertContributorSelected());
		VDNUtils.waitToBeClickableAndClick(VS.getAssertContributorSelected());
		
		
		Thread.sleep(3000);
		Assert.assertTrue(VS.getAssertSelectContributorPopUpHeader().isDisplayed());
		Assert.assertTrue(VS.getAssertContributorTypeLabel().isDisplayed());
		Assert.assertTrue(VS.getAssertSaveBtn().isDisplayed());
		Assert.assertTrue(VS.getAssertCloseBtn().isDisplayed());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getBtnSaveAsDraft());

		VDNUtils.waitToBeClickableAndClick(VO.getBtnSaveAsDraft());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectSaved());
		
		Assert.assertTrue(VO.getAssertProjectSaved().isDisplayed());
		
		home = VO.getAssertProjectSaved().getText();
		actual = "Sourcing orgadmin is able to create the project by selecting the contributors and save the project as Draft.";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project saved as draft successfully!", homeText, expect, actual);
	}
	}
	
	public static String createProjectWithGuidelineDocument() throws Exception {
		String home = null;
		String expect = "Sourcing or admin should be able to create and Publish Project with guideline document";
		String actual = "Sourcing or admin is unable to create and Publish Project with guideline document";

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
			actual = "Sourcing org admin is able to create and Publish Project with guideline document";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	public static String CreateAndSaveProjectWithoutTCWithNameAlone() throws Exception {
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

//		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
//		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);

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
	
	public static String createProjectWithMandatoryAndNonMandatoryFields() throws Exception {
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
	
	public static String createProjectFromYourOrgOnlyWithSkipDisable() throws Exception {
		String home1 = null;
		String expect1 = "Sourcing org admin is able to upload guideline document without Target Collection";
		String actual1 = "Sourcing org admin is unable to upload guideline document without Target Collection";
		
		String home2 = null;
		String expect2 = "Sourcing org admin is able to create and publish the Project with guideline document for without Target Collection";
		String actual2 = "Sourcing org admin is unable to create and publish the Project with guideline document for without Target Collection";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
//		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
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
		
		VDNUtils.waitForElementToBeVisible(VS.getAssertUploadDocument());
		Assert.assertTrue(VS.getAssertUploadDocument().isDisplayed());
		
		home1 = VS.getAssertUploadDocument().getText();
		actual1 = "Sourcing org admin is able to upload guideline document without Target Collection";
	
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home2 = VO.getAssertProjectPublished().getText();
		actual2 = "Sourcing org admin is able to create and publish the Project with guideline document for without Target Collection";
		return ProjectName;
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Document Successfully Uploaded...", homeText1, expect1, actual1);
		Listeners.customAssert("Project published successfully!", homeText2, expect2, actual2);
	}

	}
	
	public static String createProjectFromYourOrgOnlyWithoutDocumentWithSkipDisable() throws Exception {
//		String home1 = null;
//		String expect1 = "Sourcing org admin is able to upload guideline document without Target Collection";
//		String actual1 = "Sourcing org admin is unable to upload guideline document without Target Collection";
		
		String home = null;
		String expect = "Sourcing org admin is able to create and publish the Project without guideline document for without Target Collection";
		String actual = "Sourcing org admin is unable to create and publish the Project without guideline document for without Target Collection";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
//		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
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

//		Thread.sleep(3000);
//		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
//		Thread.sleep(3000);
//		UploadContentMethods.UploadPdf();
		
//		VDNUtils.waitForElementToBeVisible(VS.getAssertUploadDocument());
//		Assert.assertTrue(VS.getAssertUploadDocument().isDisplayed());
//		
//		home1 = VS.getAssertUploadDocument().getText();
//		actual1 = "Sourcing org admin is able to upload guideline document without Target Collection";
	
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to create and publish the Project with guideline document for without Target Collection";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		//String homeText2 = home2 != null ? home2 : "N/A";
		//Listeners.customAssert("Document Successfully Uploaded...", homeText1, expect1, actual1);
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	public static String createProjectBookYourOrgOnly() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

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
	
	public static void verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Created Project "+ProjectName + " Must be Displayed with Nomination Disable and Skip Review Enable";
		String actual = "Created Project "+ProjectName + " is Not Displayed with Nomination Disable and Skip Review Enable";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '])[1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			
			Assert.assertTrue(VO.getAssertSkipReviewEnabled().isDisplayed());
			
			String TabDetails = VS.getAssertTabList().getText();
			String[] lines = TabDetails.split("\r\n|\r|\n");
			System.out.println(lines);
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Nominations");
			}
			home = VO.getAssertSkipReviewEnabled().getText();
			actual = "Created Project "+ProjectName + " is Displayed with Nomination Disable and Skip Review Enable";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Skip two level review enabled", homeText, expect, actual);
		}

	}
	
	
	public static String verifyMessageDisplayedWithSkipTwoLevelReview() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
		Assert.assertTrue(VS.getAssertDisplayMsgWithSkipRev().isDisplayed());
		
//		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
//		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
//		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
//		Thread.sleep(500);
//		Date.setDayAfterTomorrowDate(driver);
//		Thread.sleep(1000);
//		Actions action = new Actions(driver);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
//		VDNUtils.waitToBeClickableAndClick(VO.getEnrollmentEndDate());
//		Date.setNextToDayAfterTomorrowDate(driver, VO.getEnrollmentEndDate());
//		Thread.sleep(500);
//		Date.setNextToDayAfterTomorrowDate(driver);
//		Thread.sleep(1000);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
//
//		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
//		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
//
//		Thread.sleep(3000);
//		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
//		Thread.sleep(3000);
//		UploadContentMethods.UploadPdf();
//		
//		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
//
//		VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
//		
//		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
//	
//		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
//		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VS.getAssertDisplayMsgWithSkipRev().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Select this option in case you do not want to have review done by your organization while contributing.", homeText, expect, actual);
	}

	}
	
	public static void verifyProjectCreatedWithoutNominationShortlistingDate(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Created Project "+ProjectName + " Must be Displayed with Nomination Disable and Skip Review Enable";
		String actual = "Created Project "+ProjectName + " is Not Displayed with Nomination Disable and Skip Review Enable";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '])[1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			
			Assert.assertTrue(VO.getAssertSkipReviewEnabled().isDisplayed());
			
			String TabDetails = VS.getAssertTabList().getText();
			String[] lines = TabDetails.split("\r\n|\r|\n");
			System.out.println(lines);
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Nominations");
			}
			home = VO.getAssertSkipReviewEnabled().getText();
			actual = "Created Project "+ProjectName + " is Displayed with Nomination Disable and Skip Review Enable";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Skip two level review enabled", homeText, expect, actual);
		}

	}
	
	public static String createProjectBookWithSkipReviewEnable() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
//		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
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
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		//Actions action = new Actions(driver);
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
	
	
	
	public static void verifyProjectCreatedWithNominationOpenAndSkipRevEnable(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		
		String home = null;
		String expect = "Created Project "+ProjectName + " Must be Displayed with Nomination Open and Skip Review Enable";
		String actual = "Created Project "+ProjectName + " is Not Displayed with Nomination Open and Skip Review Enable";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '])[1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			
			Assert.assertTrue(VO.getAssertSkipReviewEnabled().isDisplayed());
			
			Assert.assertTrue(VO.getAssertNominationTab().isDisplayed());	
			

			home = VO.getAssertSkipReviewEnabled().getText();
			actual = "Created Project "+ProjectName + " is Displayed with Nomination Open and Skip Review Enable";
		} finally {
			
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Skip two level review enabled", homeText, expect, actual);
		}

	}
	
	public static String createProjectCourseYourOrgOnly() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project with Course As Target Collection Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project with Course As Target Collection Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

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
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
	
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project with Course As Target Collection Successfully";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	public static String createProjectCourseWithSkipReviewEnable() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
//		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
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
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		//Actions action = new Actions(driver);
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
	
	public static String createProjectBookWithSkipReviewEnableAndSelCon() throws Exception {
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
//		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
//		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
//		Date.setTodayDate(driver, VO.getNominationEndDate());
//
//		Thread.sleep(500);
//		Date.setTodayDate(driver);
//		Thread.sleep(1000);
//		Actions action = new Actions(driver);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);

//		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
//		Date.setTomorrowDate(driver, VO.getShortlistEndDate());
//
//		Thread.sleep(500);
//		Date.setTomorrowDate(driver);
//		Thread.sleep(1000);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
		
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
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
	
	public static String createProjectCourseWithSkipReviewDisable() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
//		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
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
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		//VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		//Actions action = new Actions(driver);
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
	
	public static void verifyProjectCreatedWithNominationOpenAndSkipRevDisable(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		
		String home = null;
		String expect = "Created Project "+ProjectName + " Must be Displayed with Nomination Open and Skip Review Disable";
		String actual = "Created Project "+ProjectName + " is Not Displayed with Nomination Open and Skip Review Disable";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '])[1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			
//			Assert.assertTrue(VO.getAssertSkipReviewEnabled().isDisplayed());
			
			Assert.assertTrue(VO.getAssertNominationTab().isDisplayed());	
			
			Thread.sleep(5000);
			String contentDetails = VO.getAssertContnts().getText();
			String[] lines = contentDetails.split("\r\n|\r|\n");
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Skip two level review enabled");
			}
			

			home = VO.getAssertAssignUsers().getText();
			System.out.print(home);
			actual = "Created Project "+ProjectName + " is Displayed with Nomination Open and Skip Review Disable";
		} finally {
			
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Assign users to project", homeText, expect, actual);
		}

	}
	
	public static String createProjectCourseWithNominationDisAndSkipReviewEnable() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
//		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
//		Date.setTodayDate(driver, VO.getNominationEndDate());
//
//		Thread.sleep(500);
//		Date.setTodayDate(driver);
//		Thread.sleep(1000);
//		Actions action = new Actions(driver);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
//
//		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
//		Date.setTomorrowDate(driver, VO.getShortlistEndDate());
//
//		Thread.sleep(500);
//		Date.setTomorrowDate(driver);
//		Thread.sleep(1000);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworTypeAsCPD());
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
		
		
		
		
		
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
	
	public static String createProjectCourseWithSkipReviewEnableAndSelConCPD() throws Exception {
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
//		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
//		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
//		Date.setTodayDate(driver, VO.getNominationEndDate());
//
//		Thread.sleep(500);
//		Date.setTodayDate(driver);
//		Thread.sleep(1000);
//		Actions action = new Actions(driver);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);

//		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
//		Date.setTomorrowDate(driver, VO.getShortlistEndDate());
//
//		Thread.sleep(500);
//		Date.setTomorrowDate(driver);
//		Thread.sleep(1000);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
		
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
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

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworTypeAsCPD());
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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
	
	
	public static String createProjectCourseWithNomAndSkipDisable() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
//		js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
//		Date.setTodayDate(driver, VO.getNominationEndDate());
//
//		Thread.sleep(500);
//		Date.setTodayDate(driver);
//		Thread.sleep(1000);
//		Actions action = new Actions(driver);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
//
//		VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
//		Date.setTomorrowDate(driver, VO.getShortlistEndDate());
//
//		Thread.sleep(500);
//		Date.setTomorrowDate(driver);
//		Thread.sleep(1000);
//		action.sendKeys("\b").perform();
//		Thread.sleep(500);
//		action.sendKeys("4").perform();
//		Thread.sleep(500);
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		//VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
        VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworTypeAsCPD());
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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
	
	public static void verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipDisable(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home = null;
		String expect = "Created Project "+ProjectName + " Must be Displayed with Nomination Disable and Skip Review Enable";
		String actual = "Created Project "+ProjectName + " is Not Displayed with Nomination Disable and Skip Review Enable";

		try {
			String s1 = "(//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '])[1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			Thread.sleep(5000);
			
			//Assert.assertTrue(VO.getAssertSkipReviewEnabled().isDisplayed());
			
			String TabDetails = VS.getAssertTabList().getText();
			String[] lines = TabDetails.split("\r\n|\r|\n");
			System.out.println(lines);
			System.out.println(lines.length);
			
			for (String line : lines) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Nominations");
			}
			
			String contentDetails = VO.getAssertContnts().getText();
			String[] lines1 = contentDetails.split("\r\n|\r|\n");
			System.out.println(lines1.length);
			
			for (String line : lines1) {
			    System.out.println(line);
			    Assert.assertNotEquals(line,"Skip two level review enabled");
			}
			
			home = VO.getAssertAssignUsers().getText();
			actual = "Created Project "+ProjectName + " is Displayed with Nomination Disable and Skip Review Enable";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Assign users to project", homeText, expect, actual);
		}

	}
	
	public static String createProjectCourseWithSkipReviewDisableAndSelConCPD() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		
		Assert.assertTrue(VS.getAssertContributorSelected().isDisplayed());
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());

		
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

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworTypeAsCPD());
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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
	

	public static void addNewContributorsToProject(String ProjectName) throws InterruptedException {
		
		String expect = "Admin should be able to add new contributor to live project";
		String actual = "Admin unable to add new contributor to live project";
		String text = "N/A";
		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
//		((//*[text()=' AutoP_qrPFEC '])[1]/parent::td/following-sibling::td)[5]/child::div/child::div/child::i
//		((//*[text()=' AutoP_PdlIqN '])[3]/parent::td/following-sibling::td)[5]/child::div/child::div/child::i[@data-tooltip='Modify']
		String s1 = "((//*[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])[3]/parent::td/following-sibling::td)[5]/child::div/child::div/child::i[@data-tooltip='Modify']";
		
		WebElement clickModify = driver.findElement(By.xpath(s1+s2+s3));
		Thread.sleep(2000);
		clickModify.click();
//		VDNUtils.waitToBeClickableAndClick(VS.getModifyButton());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VS.getModifyContributor());
		VDNUtils.waitToBeClickableAndClick(VS.getModifyContributor());
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		js.executeScript("arguments[0].scrollIntoView(true);", VS.getUpdateButton());
		VDNUtils.waitToBeClickableAndClick(VS.getUpdateButton());
		text = "Completed";
		actual = "Admin is able to add new contributor to live project successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}

	public static void validateOpenButtonIsAvailableAgainstPendingNomination(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String Result1 = null;
		String expect1 = " 1. Open button should be available against the pending nomination";
		String actual1 = "1. Open button is not available against the pending nomination";
		
		String Result2 = null;
		String expect2 = "2. Should Display Nominated textbook list";
		String actual2 = "2. Not Displayed Nominated textbook list ";
		
		String Result3 = null;
		String expect3 = "3.Textbook tile, medium, class and subject Should Displayed";
		String actual3 = "3.Textbook tile, medium, class and subject is Not Displayed ";
		
		
		
//		String expect = ProjectName + " is Successfully Nominated";
//		String actual = ProjectName + " is not Successfully Nominated";
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
			
			Assert.assertTrue(VO.getAssertPending().isDisplayed());
			
			Assert.assertTrue(VO.getOpenUserAction().isDisplayed());
			//span[contains(text(),' Pending ')]//following::button[1]
			
//			VDNUtils.waitToBeClickableAndClick(VO.getBtnAccept());
//			Thread.sleep(3000);
//			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			Result1 = VO.getOpenUserAction().getText();
			System.out.println(Result1);
			actual1 =  "1. Open button should be available against the pending nomination";
			
			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
			
			Thread.sleep(3000);
			
			Assert.assertTrue(VS.getAssertListOfTextBook().isDisplayed());
			
			Result2 = VS.getAssertListOfTextBook().getText();
			System.out.println(Result2);
			actual2 =  "2.Displayed Nominated textbook list";
			
			
			Assert.assertTrue(VS.getAssertMedium().isDisplayed());
			
			Assert.assertTrue(VS.getAssertTitle().isDisplayed());
			
			Assert.assertTrue(VS.getAssertClass().isDisplayed());
			
			Assert.assertTrue(VS.getAssertSubject().isDisplayed());
			
			
			Result3 = VS.getAssertSubject().getText();
			System.out.println(Result3);
			actual3 =  "3.Textbook tile, medium, class and subject is Displayed";
			
			
			
			Assert.assertTrue(VO.getBtnAccept().isDisplayed());
			
			Assert.assertTrue(VO.getBtnReject().isDisplayed());
			
			Assert.assertTrue(VS.getAssertContentTypes().isDisplayed());
			
			Assert.assertTrue(VS.getAssertOrg().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VS.getAssertOrg());
			
			Thread.sleep(3000);
			
			Assert.assertTrue(VS.getAssertProfileDet().isDisplayed());
			
			
		} finally {
			String Resul1Text = Result1 != null ? Result1 : "N/A";
			Listeners.customAssert("Open", Resul1Text, expect1, actual1);
			
			String Resul2Text = Result2 != null ? Result2 : "N/A";
			Listeners.customAssert("List of Digital Textbooks", Resul2Text, expect2, actual2);
			
			String Resul3Text = Result3 != null ? Result3 : "N/A";
			Listeners.customAssert("Subject", Resul3Text, expect3, actual3);
		}

	}
		public static void verfiCreateNewProjectPopUp() {
		
		String expect = "Project option should be display to admin";
		String actual = "Project option is not display to admin";
		String text = "N/A";
		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
		Assert.assertTrue(VO.getProjOpt3().isDisplayed());
		Assert.assertTrue(VO.getProjOpt1().isDisplayed());
		Assert.assertTrue(VO.getProjectOption2().isDisplayed());
		text = "Completed";
		actual = "Project option is display to admin successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyProjectDetailForforSourcingOrgadmin() {
		
		String expect = "Project details should be display to sourcing orgadmin";
		String actual = "Project details is not displayed to sourcing orgadmin";
		String text = "N/A";
		
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());
		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());
		Assert.assertTrue(VO.getEnterProjectName().isDisplayed());
		Assert.assertTrue(VO.getEnterProjectDesc().isDisplayed());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VS.getNomination());
		Assert.assertTrue(VS.getNomination().isDisplayed());
		js.executeScript("arguments[0].scrollIntoView(true);", VS.getSkipTwoLevelBtn());
		Assert.assertTrue(VS.getSkipTwoLevelBtn().isDisplayed());
		js.executeScript("window.scrollBy(0,100)");
		Assert.assertTrue(VO.getNominationEndDate().isDisplayed());
		Assert.assertTrue(VO.getShortlistEndDate().isDisplayed());
		Assert.assertTrue(VO.getContributionEndDate().isDisplayed());
		Assert.assertTrue(VO.getEnrollmentEndDate().isDisplayed());
		Assert.assertTrue(VS.getRecognition().isDisplayed());
		text = "Completed";
		actual = "Project details is displayed to sourcing orgadmin successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
		
	
	public static void validateProfilePopUpIsOpenedOnClickOfContributorName(String ProjectName) throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String Result1 = null;
		String expect1 = " 1.Profile pop up should be opened on click of contributor name.";
		String actual1 = "1. Profile pop up is not opened on click of contributor name.";
		
		String Result2 = null;
		String expect2 = "2. The details should be correct in the profile pop up.";
		String actual2 = "2. The details are not correct in the profile pop up. ";
		
		try {
			String s1 = "//div[text()=' ";
			String s2 = ProjectName;
			String s3 = " ']//following::button[text()='Open '][1]";
			Thread.sleep(10000);
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(clkOpenProject);
			VDNUtils.waitToBeClickableAndClick(VO.getAssertNominationTab());
			
			Assert.assertTrue(VO.getAssertPending().isDisplayed());
			
			Assert.assertTrue(VO.getOpenUserAction().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VO.getOpenUserAction());
			
			Thread.sleep(3000);
			
			Assert.assertTrue(VS.getAssertListOfTextBook().isDisplayed());
			
			Assert.assertTrue(VS.getAssertMedium().isDisplayed());
			
			Assert.assertTrue(VS.getAssertTitle().isDisplayed());
			
			Assert.assertTrue(VS.getAssertClass().isDisplayed());
			
			Assert.assertTrue(VS.getAssertSubject().isDisplayed());
			
			Assert.assertTrue(VO.getBtnAccept().isDisplayed());
			
			Assert.assertTrue(VO.getBtnReject().isDisplayed());
			
			Assert.assertTrue(VS.getAssertContentTypes().isDisplayed());
			
			Assert.assertTrue(VS.getAssertOrg().isDisplayed());
			
			VDNUtils.waitToBeClickableAndClick(VS.getAssertOrg());
			
			Thread.sleep(3000);
			
			Assert.assertTrue(VS.getAssertProfileDet().isDisplayed());
			
			Result1 = VS.getAssertProfileDet().getText();
			System.out.println(Result1);
			actual1 =  "1. Profile pop up is opened on click of contributor name.";
			
			Assert.assertTrue(VS.getAssertOrgNameOnPopUp().isDisplayed());
			Assert.assertTrue(VS.getAssertOrgTypeOnPopUp().isDisplayed());
			
			Result2 = VS.getAssertOrgTypeOnPopUp().getText();
			System.out.println(Result2);
			actual2 =  "2.The details are correct in the profile pop up.";
			
		} finally {
			String Resul1Text = Result1 != null ? Result1 : "N/A";
			Listeners.customAssert("Profile Details", Resul1Text, expect1, actual1);
			
			String Resul2Text = Result2 != null ? Result2 : "N/A";
			Listeners.customAssert("Organisation", Resul2Text, expect2, actual2);
			
		}

	}	
	
	
	public static void validateNoneOptionIsDisplayedAsDropdown()
			throws InterruptedException, IOException {
		String home = null;
		String expect = " Admin should be able to assign reviewer to the Project and is Displayed on the Top";
		String actual =  "Admin should be unable to assign reviewer to the Project or is not Displayed on the Top";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

			VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());

			VDNUtils.waitForElementToBeVisible(VO.getSearchField());
			
			Assert.assertTrue(VO.getSearchField().isDisplayed());
			Thread.sleep(3000);
			
			String user =  excel.getContentName("User Role1");
			System.out.print(user);
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), user);
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			Thread.sleep(5000);
			VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
			Thread.sleep(5000);
			Assert.assertTrue(VS.getAssertNonOpt().isDisplayed());
			
			home = VS.getAssertNonOpt().getText();
			System.out.println(home);
			
			VDNUtils.waitToBeClickableAndClick(VS.getAssertNonOpt());
			
			VDNUtils.waitToBeClickableAndClick(VS.getClkYesBtn());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
			Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

			actual = " Admin should be able to assign reviewer to the Project and is Displayed on the Top" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("NONE", homeText, expect, actual);
		}
	}

	public static String createProjectCourseYourOrgOnlySkipDis() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
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
	
	public static String createProjectCourseWithSkipReviewEnableAndSelConK12() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
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
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
		VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
		VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
		VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
		VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
//		VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
		
//		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
//		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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
	
	
	public static String createProjectCourseWithSkipReviewDisableAndSelConK12() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSaveButton());
		
		Assert.assertTrue(VS.getAssertContributorSelected().isDisplayed());
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		//VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
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
//		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
//		VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
		
//		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
//		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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
	
	
	public static String createProjectContentPlaylistFromAnyOneK12() throws Exception {
		String home = null;
		String expect = "Sourcing or admin should be able to create and Publish Project with guideline document";
		String actual = "Sourcing or admin is unable to create and Publish Project with guideline document";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
			//VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
			
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
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelContentPlay());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
			Thread.sleep(3000);
			
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
			VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
			Thread.sleep(3000);

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to create and Publish Project with guideline document";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	
	public static String createProjectContentPlaylistFromAnyOneK12WithSkipEnable() throws Exception {
		String home = null;
		String expect = "Sourcing or admin should be able to create and Publish Project with guideline document";
		String actual = "Sourcing or admin is unable to create and Publish Project with guideline document";

		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
			
			VDNUtils.waitToBeClickableAndClick(VO.getSelContentPlay());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
			Thread.sleep(3000);
			
			UploadContentMethods.UploadPdf();
			
			VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
			
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
			VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
			Thread.sleep(3000);

			VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());

			VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

			VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

			VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
			
			home = VO.getAssertProjectPublished().getText();
			actual = "Sourcing org admin is able to create and Publish Project with guideline document";

			return ProjectName;
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		}

	}
	
	public static String createProjectFromYourOrgOnlyWithSkipEnable() throws Exception {
		String home1 = null;
		String expect1 = "Sourcing org admin is able to upload guideline document without Target Collection";
		String actual1 = "Sourcing org admin is unable to upload guideline document without Target Collection";
		
		String home2 = null;
		String expect2 = "Sourcing org admin is able to create and publish the Project with guideline document for without Target Collection";
		String actual2 = "Sourcing org admin is unable to create and publish the Project with guideline document for without Target Collection";

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

//		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
//		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		
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
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelContentPlay());
		Thread.sleep(3000);

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitForElementToBeVisible(VS.getAssertUploadDocument());
		Assert.assertTrue(VS.getAssertUploadDocument().isDisplayed());
		
		home1 = VS.getAssertUploadDocument().getText();
		actual1 = "Sourcing org admin is able to upload guideline document without Target Collection";
	
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);

		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home2 = VO.getAssertProjectPublished().getText();
		actual2 = "Sourcing org admin is able to create and publish the Project with guideline document for without Target Collection";
		return ProjectName;
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Document Successfully Uploaded...", homeText1, expect1, actual1);
		Listeners.customAssert("Project published successfully!", homeText2, expect2, actual2);
	}

	}
	
	
	public static String createProjectFromYourOrgOnlyWithSkipDisableContentPlaylis() throws Exception {
		String home1 = null;
		String expect1 = "Sourcing org admin is able to upload guideline document without Target Collection";
		String actual1 = "Sourcing org admin is unable to upload guideline document without Target Collection";
		
		String home2 = null;
		String expect2 = "Sourcing org admin is able to create and publish the Project with guideline document for without Target Collection";
		String actual2 = "Sourcing org admin is unable to create and publish the Project with guideline document for without Target Collection";

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
		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		//VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
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

//		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
//		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		
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
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelContentPlay());
		Thread.sleep(3000);

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitForElementToBeVisible(VS.getAssertUploadDocument());
		Assert.assertTrue(VS.getAssertUploadDocument().isDisplayed());
		
		home1 = VS.getAssertUploadDocument().getText();
		actual1 = "Sourcing org admin is able to upload guideline document without Target Collection";
	
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);

		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home2 = VO.getAssertProjectPublished().getText();
		actual2 = "Sourcing org admin is able to create and publish the Project with guideline document for without Target Collection";
		return ProjectName;
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Document Successfully Uploaded...", homeText1, expect1, actual1);
		Listeners.customAssert("Project published successfully!", homeText2, expect2, actual2);
	}

	}
	
	public static void verifyContentStatusAndCountDigitalTextBook(String ProjectName) throws InterruptedException {
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
			
//			Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
//			String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
//			System.out.print(ApprovedCount);
			
//			Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
//			String RejectedCount = VO.getAssertRejectedTab().getText();
//			System.out.print(RejectedCount);
			
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
			
//			VO.getClkPublish().click();
//			Thread.sleep(5000);
			
//			VO.getSelectSample1().click();
//			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
//			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
//			Thread.sleep(2000);
			
			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertApprovedTabs());
//			Assert.assertTrue(VO.getAssertApprovedTabs().isDisplayed());
			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
//			String AppCount = VO.getApprovedTabCount().getText();
//			System.out.print(AppCount);
//			
//			int AppC=Integer.parseInt(AppCount); 
			
			
						
			
			
			
//			VO.getSelectSample2().click();
//			Thread.sleep(5000);
//			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			
			
			
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct1");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentCorrection());
			Assert.assertTrue(VO.getAssertContentCorrection().isDisplayed());
			
			VO.getSelectSample2().click();
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
//			VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
//			Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
			VDNUtils.waitForElementToBeVisible(VO.getCorrectionsPenTOC());
			Assert.assertTrue(VO.getCorrectionsPenTOC().isDisplayed());
			
//			String RejCount = VO.getAssertRejectedCount().getText();
//			System.out.print(RejCount);
			
			String CorCount1 = VO.getCorrectionsPenCount().getText();
			System.out.print(CorCount1);
			
			int CorC1=Integer.parseInt(CorCount1);
			
			//int RejC=Integer.parseInt(RejCount); 
			
			
			
			
			VO.getSelectSample2().click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getBtnSendCorrect());
			VDNUtils.waitToBeClickableAndClick(VO.getBtnSendCorrect());
			
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Correct2");
			VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
			Thread.sleep(3000);
		
			VDNUtils.waitForElementToBeVisible(VO.getAssertContentCorrection());
			Assert.assertTrue(VO.getAssertContentCorrection().isDisplayed());
			
			VO.getSelectSample3().click();
			Thread.sleep(2000);
			//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
			
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			Thread.sleep(2000);
			
			VDNUtils.waitForElementToBeVisible(VO.getCorrectionsPenTOC());
			Assert.assertTrue(VO.getCorrectionsPenTOC().isDisplayed());
			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
			String CorCount2 = VO.getCorrectionsPenCount().getText();
			System.out.print(CorCount2);
			
			int CorC2=Integer.parseInt(CorCount2); 
			
			
			VDNUtils.waitForElementToBeVisible(VO.getApprovalPenNode());
			Assert.assertTrue(VO.getApprovalPenNode().isDisplayed());
			//Assert.assertTrue(VO.getAssertTotalContOnTOC().isDisplayed());
			
			String AppPenC = VO.getApprovalPenCount().getText();
			System.out.print(AppPenC);
			
			int PenC=Integer.parseInt(AppPenC);
			
			
			
			int Tot = CorC2+PenC;
			//System.out.println(Tot);
			
			
			Assert.assertTrue(VO.getTotalNode().isDisplayed());
			
			String TotCount = VO.getTotalCount().getText();
			int TotalC=Integer.parseInt(TotCount);
			
			System.out.println(TotCount);
			//Assert.assertEquals(Tot,TotalC);
			
			
		
			home = VO.getApprovalPenNode().getText();
			actual = ProjectName + " is Sent For Approval and Send For Correction";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Approval Pending:", homeText, expect, actual);
		}

}
	
	public static void validateSourcingOrgadminIsAbleToClickOpenAndViewProjectDetails(String ProjectName)
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
	
	
	public static void verifyDigitalTextDetails(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = ProjectName + " Pre-approved nomination should be displayed in the Nomination tab with approved status";
		String actual = ProjectName + " Pre-approved nomination is not displayed in the Nomination tab with approved status.";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			//VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
			
			
			VDNUtils.waitForElementToBeVisible(VO.getAssertDigiTextBooks());
			VDNUtils.waitToBeClickableAndClick(VO.getAssertDigiTextBooks());
			Thread.sleep(3000);
			
			Assert.assertTrue(VS.getAssertTotDigiTextBook().isDisplayed());

			Assert.assertTrue(VS.getAssertAppPenDigiTextBook().isDisplayed());

			Assert.assertTrue(VS.getAssertApprovedDigiTextBook().isDisplayed());

			Assert.assertTrue(VS.getAssertRejectedDigiTextBook().isDisplayed());

			Assert.assertTrue(VS.getAssertCorrPenDigiTextBook().isDisplayed());
			
			Assert.assertTrue(VS.getAssertTitleWithSort().isDisplayed());
			
			Assert.assertTrue(VS.getAssertMediumWithSort().isDisplayed());
			
			Assert.assertTrue(VS.getAssertClassWithSort().isDisplayed());
			
			Assert.assertTrue(VS.getAssertSubjectWithSort().isDisplayed());
			
			Assert.assertTrue(VS.getAssertChapter().isDisplayed());
			
			Assert.assertTrue(VS.getAssertStatusWithSort().isDisplayed());
			
			
			
			

			

//			VDNUtils.waitForElementToBeVisible(VO.getAssertPreApprovedOrgName());
//			Assert.assertTrue(VO.getAssertPreApprovedOrgName().isDisplayed());
//			
//			Assert.assertTrue(VO.getAssertPreApprovedStatus().isDisplayed());
			
			home = VO.getAssertDigiTextBooks().getText();
			System.out.println(home);
			actual = ProjectName + " Pre-approved nomination displayed in the Nomination tab with approved status.";
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("Digital Textbook", homeText, expect, actual);
		}
	}
	
	public static String createProjectCPWithSkipReviewEnableAndSelConK12() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
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
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
		VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
		VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
		VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
		VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
//		VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelContentPlay());
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
		
//		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
//		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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
	
	public static void SourcingOrgAdminIsAbleToSearchWithUserNameAndVerifyNoResultMsg(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = "No result found message should be displayed if the search result is not available";
		String actual = "Result found even search result is not available";

		try {
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			
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
			
			String UserName = VDNUtils.set_Content_Name("Auto_User");
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(),UserName);
			Thread.sleep(3000);
			
			VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
			Thread.sleep(5000);
			Assert.assertTrue(VS.getAssertNoUsersFound().isDisplayed());
			home = VS.getAssertNoUsersFound().getText();
			actual = "No result found message should be displayed if the search result is not available" ;
		} finally {
			String homeText = home != null ? home : "N/A";
			System.out.println(homeText);
			Listeners.customAssert("No users found.", homeText, expect, actual);
		}
	}
	
	
	
	public static void AdminIsAbleToDeleteProjectWithoutNomination(String ProjectName)
			throws InterruptedException {
		String home = null;
		String expect = " Admin should be allowed to delete a project only if there are no nominations for Project "+ProjectName;
		String actual =  " Admin is allowed to delete a project only if there are no nominations for Project "+ProjectName;

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
			
			String NomCount = VO.getAssertNomCount().getText();
			System.out.println(NomCount);
			
			
			Assert.assertEquals(NomCount,"1");
//			String[] lines = NomCount.split("\r\n|\r|\n");
//			System.out.println(lines);
//			System.out.println(lines.length);
//			
//			for (String line : lines) {
//			    System.out.println(line);
//			    Assert.assertEquals(line,"Nominations");
//			    Assert.assertEquals(line,"1");
//			}

			
			
			
			VDNUtils.waitToBeClickableAndClick(VO.getMyProjects());
			Thread.sleep(5000);
			

			actual = " Admin should be able to assign reviewer to the Project "+ProjectName+" and is Displayed on the Top" ;
		} finally {
//			String homeText = home != null ? home : "N/A";
//			System.out.println(homeText);
//			Listeners.customAssert("Roles updated...", homeText, expect, actual);
		}
	}
	
	
	public static void AdminIsAbleToDeleteThePrpjectWithoutTargetCol(String ProjectName)
			throws InterruptedException {
		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		String home = null;
		String expect = "Sourcing org admin is able to edit and Modifify the Prpject Wihout Target Collection";
		String actual = " Sourcing org admin is unable to edit or Modifify the Prpject Wihout Target Collection";
		try {
		String s1 = "(//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])";
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
	
	
	public static String createProjectCPWithSkipReviewEnableAndSelConK12TextBook() throws Exception {
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
		VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
		VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
		Thread.sleep(3000);
		String IndCon =  excel.getContentName("Ind Contributor");
		System.out.print(IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
		
		VDNUtils.waitForElementToBeVisible(VO.getSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSelectOrg());
				
		Assert.assertTrue(VS.getAssertSelectedContributor().isDisplayed());
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
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());
		VDNUtils.waitToBeClickableAndClick(VO.getSelExplanationContent());
		VDNUtils.waitToBeClickableAndClick(VO.getSelLearningResource());
		VDNUtils.waitToBeClickableAndClick(VO.getSelPQuestionSet());
		VDNUtils.waitToBeClickableAndClick(VO.getSelTeacherResource());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
		
//		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		//VDNUtils.waitToBeClickableAndClick(VO.getSelContentPlay());
		VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
		
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
		
//		VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
//		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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


	public static void verifyDeleteAndCloseOptionForProjectWithNomination(String ProjectName) throws Exception {
		
		String expect = "Admin should not be able to delete close project with nomination";
		String actual = "Admin is able to delete close project with nomination";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])[3]/parent::td/following-sibling::td)[5]/child::div/child::div/child::i";
		String s4 = "/following-sibling::a/child::div";
		WebElement kebabMenu = driver.findElement(By.xpath(s1 + s2 + s3 + s4));
		VDNUtils.waitToBeClickableAndClick(kebabMenu);
		String s5 = "/descendant::a/following-sibling::a/child::i[@data-tooltip='Close']";
		WebElement closeBtn = driver.findElement(By.xpath(s1 + s2 + s3 + s4 + s5));
		VDNUtils.waitToBeClickableAndClick(closeBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getCloseYesBtn());
		String s6 = "[@data-tooltip='Delete']";
		WebElement deletBtn = driver.findElement(By.xpath(s1 + s2 + s3 + s6));
		VDNUtils.waitToBeClickableAndClick(deletBtn);
		Assert.assertTrue(VS.getDeleteErrorMsg().isDisplayed());
		Thread.sleep(10000);
		text = "completed";
		actual = "Admin is not able to delete close project with nomination successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void applyAndResetFilterWhileCreatingProject() throws Exception {
		
		String expect = "Admin should be able to apply filter and reset the filter";
		String actual = "Admin is not able to apply filter and reset the filter";
		String text = "N/A";
		
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
		VDNUtils.waitToBeClickableAndClick(VS.getBoard());
		VDNUtils.waitToBeClickableAndClick(VS.getBoardValue());
		VDNUtils.waitToBeClickableAndClick(VS.getMedium());
		VDNUtils.waitToBeClickableAndClick(VS.getMediumValue());
		js.executeScript("window.scrollBy(0,100)");
		VDNUtils.waitToBeClickableAndClick(VS.getClass1());
		VDNUtils.waitToBeClickableAndClick(VS.getClassValue());
		VDNUtils.waitToBeClickableAndClick(VS.getSubject());
		VDNUtils.waitToBeClickableAndClick(VS.getSubjectValue());
		VDNUtils.waitToBeClickableAndClick(VS.getResetBtn());
		text = "Completed";
		actual = "Admin is able to apply filter and reset the filter successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	
	public static void verifyProjectPopUpAndDetails() throws Exception {
		String home = null;
		String expect = "Verify Next button is enabled post selecting any one of the radio button";
		String actual = "Next button is Not enabled post selecting any one of the radio button";
		
		String home2 = null;
		String expect2 = "Admin should be able to cancel the pop up using the cancel button.";
		String actual2 = "Admin is unable to cancel the pop up using the cancel button.";

		try {
			
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
		Thread.sleep(2000);
		Assert.assertTrue(VS.getAssertRadioOpt1().isDisplayed());
		Assert.assertTrue(VS.getAssertRadioOpt2().isDisplayed());
		Assert.assertTrue(VS.getAssertRadioOpt3().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt3());
		Thread.sleep(2000);
		Assert.assertTrue(VO.getClkbtn().isEnabled());
		VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt1());
		Thread.sleep(2000);
		Assert.assertTrue(VO.getClkbtn().isEnabled());
		VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt2());
		Thread.sleep(2000);
		Assert.assertTrue(VO.getClkbtn().isEnabled());
		
		home = VO.getClkbtn().getText();
		System.out.println(home);
		actual = "Next button is enabled post selecting any one of the radio button";
		
		Assert.assertTrue(VS.getBtnCancel().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VS.getBtnCancel());
		Assert.assertTrue(VS.getAssertCollection().isDisplayed());
		home2 = VS.getAssertCollection().getText();
		System.out.println(home2);
		actual2 = "Admin is able to cancel the pop up using the cancel button.";

	} finally {
		
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Next", homeText, expect, actual);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("For Books/Course/Other Collections", homeText2, expect2, actual2);
	}

	}
	
	
	public static void verifyFieldsOnProjectScopePage() throws InterruptedException {
		String home1 = null;
		String expect1 = "Project Scope Should Displayed With Content Types and Target Collections";
		String actual1 = "Project Scope is not Displayed With Content Types and Target Collections";
		
		String home2 = null;
		String expect2 = "Project Scope Should Displayed With BMCS Filter";
		String actual2 = "Project Scope is not Displayed With BMCS Filter";
		
		String home3 = null;
		String expect3 = "Project Scope Should Displayed With Content Guideline";
		String actual3 = "Project Scope is not Displayed With Content Guideline";
		
		String home4 = null;
		String expect4 = "Project Scope Should Displayed With Save as draft and Publish Project button";
		String actual4 = "Project Scope is not Displayed With draft and Publish Project button";
		
		try {

			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

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
			Thread.sleep(2000);
		
			Assert.assertTrue(VS.getAssertContentType().isDisplayed());
			
			Assert.assertTrue(VS.getAssertTargetCol().isDisplayed());
			
			home1 = VS.getAssertTargetCol().getText();
			actual1 = "Project Scope is Displayed With Content Types and Target Collections";
			
			
			Assert.assertTrue(VS.getAssertBoard().isDisplayed());
			
			Assert.assertTrue(VS.getAssertMed().isDisplayed());
			
			Assert.assertTrue(VS.getAssertClassOpt().isDisplayed());
			
			Assert.assertTrue(VS.getAssertSub().isDisplayed());
			
			home2 = VS.getAssertSub().getText();
			actual2 = "Project Scope is Displayed With BMCS Filter";
			
			Assert.assertTrue(VS.getAssertGuideline().isDisplayed());
			
			home3 = VS.getAssertGuideline().getText();
			actual3 = "Project Scope is Displayed With Content Guideline";
			
			Assert.assertTrue(VO.getBtnSaveAsDraft().isDisplayed());
			Assert.assertTrue(VO.getClkPublishBtn().isDisplayed());
			
			home4 = VO.getClkPublishBtn().getText();
			actual4 = "Project Scope is not Displayed With draft and Publish Project button";
			
	
			//return ProjectName;
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Select target collection", homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Subject", homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Guidelines Document", homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Publish Project", homeText4, expect4, actual4);
		}

	}
	
	public static String createProjectTextBookWithSkipReviewDisable() throws Exception {
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
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
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
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelDigitalTextBook());
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
		
		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
		Thread.sleep(3000);
		
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
	
	public static void verifySelectContributorsPopUp() {
		
		String expect = "All the element of contributors popup should be display to admin";
		String actual = "All the element of contributors is not display to admin";
		String text = "N/A";
		
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
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
		Assert.assertTrue(VO.getEnterOrgName().isDisplayed());
		Assert.assertTrue(VS.getContributorType().isDisplayed());
		Assert.assertTrue(VS.getContributorName().isDisplayed());
		Assert.assertTrue(VS.getContributorEmail().isDisplayed());
		Assert.assertTrue(VS.getContributorMobile().isDisplayed());
		Assert.assertTrue(VS.getContributorType1().isDisplayed());
		Assert.assertTrue(VS.getContributorNextBtn().isDisplayed());
		Assert.assertTrue(VO.getClkSaveButton().isDisplayed());
		text = "Completed";
		actual = "All the element of contributors popup is display to admin successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}
	
	public static void verifyAdminCanAddMoreContributorToProject() throws InterruptedException {
		String expect = "Admin should be able to add more contributor to project";
		String actual = "Admin is not able to add more contributor to project";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
		VDNUtils.waitToBeClickableAndClick(VS.getAddedContributor());
		Assert.assertTrue(VS.getSelectedContributor().isDisplayed());
		text = "Completed";
		actual = "Admin is able to add more contributor to project successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyPaginationAvailableForSourcingOrgadmin() {
		
		String expect = "Pagination should be available for sourcing org admin";
		String actual = "Pagination is not available for sourcing org admin";
		String text = "N/A";
		
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
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
		Assert.assertTrue(VO.getEnterOrgName().isDisplayed());
		Assert.assertTrue(VS.getContributorType().isDisplayed());
		Assert.assertTrue(VS.getContributorName().isDisplayed());
		Assert.assertTrue(VS.getContributorEmail().isDisplayed());
		Assert.assertTrue(VS.getContributorMobile().isDisplayed());
		Assert.assertTrue(VS.getContributorType1().isDisplayed());
		Assert.assertTrue(VS.getContributorNextBtn().isDisplayed());
		Assert.assertTrue(VO.getClkSaveButton().isDisplayed());
		text = "Completed";
		actual = "Pagination is available for sourcing org admin successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}
	
	public static void createProjectWithAllContentType() throws Exception {
		
		String expect = "Admin should be able to create project with all content type";
		String actual = "Admin is not able to create project with all content type";
		String text = "N/A";
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
		js.executeScript("arguments[0].click();", VO.getClkNextButton());
//		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());
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
//		(//*[text()=' AutoP_pvfeDU '])[1]/parent::td/following-sibling::td/child::div/child::span
		String s1 = "(//*[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])[1]/parent::td/following-sibling::td/child::div/child::span";
		WebElement contentType = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitForElementToBeVisible(contentType);
		String actualContentType = contentType.getText();
		String expectedContentType = "Course Assessment, eTextbook, Explanation Content, Learning Resource, Practice Question Set, Teacher Resource";
		Assert.assertEquals(actualContentType, expectedContentType);
		text = "Completed";
		actual = "Admin is able to create project with all content type successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void createProjectWithPartialChapter() throws Exception {
		
		String expect = "Admin should be able to create project with partial chapter";
		String actual = "Admin is not able to create project with partial chapter";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
		js.executeScript("arguments[0].click();", VO.getClkNextButton());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
		VDNUtils.waitToBeClickableAndClick(VS.getEditCourseUnit());
		Thread.sleep(1000);
		VS.getCourseUnitCheckBox().click();
		Thread.sleep(1000);
		VS.getCourseUnitCheckBox().click();
		VDNUtils.waitToBeClickableAndClick(VS.getCourseUnitDoneBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());
		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		text = "Completed";
		actual = "Admin is able to create project with partial chapter successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void createAndSaveAsDraftProjectWithPartialChapter() throws Exception {
		
		String expect = "Admin should be able to save as draft project with partial chapter";
		String actual = "Admin is not able to save as draft project with partial chapter";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
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
		js.executeScript("arguments[0].click();", VO.getClkNextButton());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourseAssesment());
		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());
		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		VDNUtils.waitToBeClickableAndClick(VO.getChooseTargetCollection());
		VDNUtils.waitToBeClickableAndClick(VS.getEditCourseUnit());
		Thread.sleep(1000);
		VS.getCourseUnitCheckBox().click();
		Thread.sleep(1000);
		VS.getCourseUnitCheckBox().click();
		VDNUtils.waitToBeClickableAndClick(VS.getCourseUnitDoneBtn());
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getBtnSaveAsDraft());
		VDNUtils.waitToBeClickableAndClick(VO.getBtnSaveAsDraft());
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectSaved());
		Assert.assertTrue(VO.getAssertProjectSaved().isDisplayed());
		text = "Completed";
		actual = "Admin is able to save as draft project with partial chapter successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyTabsOfTargetCollection(String projectName, String expectTab) {
		
		String expect = "Target collection tab should be dispaly to admin";
		String actual = "Target collection tab is not dispaly to admin";
		String text = "N/A";
		try {
//		((//*[text()=' AutoP_MVcwTv '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitForElementToBeVisible(VS.getTargetCollection());
		String targetCollection = VS.getTargetCollection().getText();
		String actualTab = targetCollection.replaceAll("[0-9]", "");
		Assert.assertEquals(actualTab.trim(), expectTab);
		text = "Completed";
		actual = "Target collection tab is dispaly to admin successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
public static void verifyUnitOfTargetCollection(String projectName) {
		
		String expect = "Target collection unit should be dispaly to admin";
		String actual = "Target collection unit is not dispaly to admin";
		String text = "N/A";
		try {

		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitForElementToBeVisible(VS.getTargetCollection());
		Assert.assertTrue(VS.getTargetCollection().isDisplayed());
		text = "Completed";
		actual = "Target collection unit is dispaly to admin successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}

	public static void verifyOrgadminIsAbleToFilterTheTextbook() throws Exception {
		String home1 = null;
		String expect1 = "Sourcing orgadmin should be able to display the filter the textbook in project details page";
		String actual1 = "Sourcing orgadmin is unable to display the filter the textbook in project details page";
		String home2 = null;
		String expect2 = "Post Fitler The Textbooks should be displayed according to the filters.";
		String actual2 = "Post Fitler The Textbooks is not displayed according to the filters";
		String home3 = null;
		String expect3 = "Filter Digital Textbook should be changes to Modify Filter post applying the filter.";
		String actual3 = "Filter Digital Textbook is not changes to Modify Filter post applying the filter.";
		String home4 = null;
		String expect4 = "Admin Should be able to reset the filters";
		String actual4 = "Admin is unable to reset the filters";
	try {
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			Assert.assertTrue(VS.getAssertFilterTextBooks().isDisplayed());
			
			home1 = VS.getAssertFilterTextBooks().getText();
			actual1 = "Sourcing orgadmin is able to display the filter the textbook in project details page";
			
			VDNUtils.waitToBeClickableAndClick(VS.getAssertFilterTextBooks());
			Thread.sleep(3000);
			VDNUtils.waitToBeClickableAndClick(VS.getClkMedDropdown());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VS.getSelectEngVal());
			VDNUtils.waitToBeClickableAndClick(VS.getClkSubDropdown());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VS.getSelectSubVal());
			
			VDNUtils.waitToBeClickableAndClick(VS.getClkClassDropdown());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VS.getSelectClass1Val());
			
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
			Thread.sleep(2000);
			Assert.assertTrue(VS.getAssertModifyFilters().isDisplayed());
			
			Assert.assertTrue(VS.getAssertMedPostFilter().isDisplayed());
			Assert.assertTrue(VS.getAssertSubPostFilter().isDisplayed());
			Assert.assertTrue(VS.getAssertClassPostFilter().isDisplayed());
			
			home2 = VS.getAssertClassPostFilter().getText();
			actual1 = "Post Fitler The Textbooks is displayed according to the filters.";
			
			home3 = VS.getAssertModifyFilters().getText();
			actual3 = "Filter Digital Textbook is changes to Modify Filter post applying the filter.";
			
			
			VDNUtils.waitToBeClickableAndClick(VS.getAssertModifyFilters());
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VS.getClkResetBtn());
			Thread.sleep(2000);
			
			home4 = VS.getAssertFilterTextBooks().getText();
			actual4 = "Admin is able to reset the filters";
				
		}finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Filter Digital Textbooks", homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Class 1", homeText2, expect2, actual2);
			
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Modify Filters'", homeText3, expect3, actual3);
			
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Filter Digital Textbooks", homeText4, expect4, actual4);
		
	}
}
	
	public static String createProjectContentPlaylistWithSkipReviewEnable() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
//		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
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
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		//Actions action = new Actions(driver);
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
	
	
	
	public static void verifyViewContributionOnApprovedContentPlaylist() throws Exception {
		String home1 = null;
		String expect1 = "View contribution button should be available";
		String actual1 = "View contribution button is available";
		String home2 = null;
		String expect2 = "List of Content playlist should be available in the Project created using Content playlist on click of view contribution in the nomination tab";
		String actual2 = "List of Content playlist is unavailable in the Project created using Content playlist on click of view contribution in the nomination tab";
		
	try {
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			Assert.assertTrue(VS.getClkViewContribution().isDisplayed());
			
			home1 = VS.getClkViewContribution().getText();
			actual1 = "View contribution button should be available";
			
			VDNUtils.waitToBeClickableAndClick(VS.getClkViewContribution());
			Thread.sleep(3000);
			Assert.assertTrue(VS.getListOfContentPlaylist().isDisplayed());
		
			home2 = VS.getListOfContentPlaylist().getText();
			actual1 = "Content playlist should be available in the Project created using Content playlist on click of view contribution in the nomination tab";
			
				
		}finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("View Contribution", homeText1, expect1, actual1);
			
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("List of Content Playlists", homeText2, expect2, actual2);
		
	}
}
	
public static String createProjectCourseWithSkipReviewEnableK12Framework() throws Exception {
		String home = null;
		String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
		String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);	
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
//		VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
		
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
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getContributionEndDate());
		VDNUtils.waitToBeClickableAndClick(VO.getContributionEndDate());
		Date.setDayAfterTomorrowDate(driver, VO.getContributionEndDate());
		Thread.sleep(500);
		Date.setDayAfterTomorrowDate(driver);
		Thread.sleep(1000);
		//Actions action = new Actions(driver);
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
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

		VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
		
		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
		
//		Thread.sleep(3000);
//		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
//		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
//		Thread.sleep(3000);
		
		
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


	public static void verifyUnitsDisplayUnderDropDown(String projectName) {
	
		String expect = "All content units should be display under drop down";
		String actual = "All content units is not display under drop down";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getContentOpenBtn());
		Assert.assertTrue(VS.getContentUnits().isDisplayed());
		text = "Completed";
		actual = "All content units is display under drop down successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyTotalAndAwaitingForMyReviewCountIsAvailable(String projectName) {
		
		String expect = "Verify total and awaiting for my review count should be display";
		String actual = "Verify total and awaiting for my review count is not display";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getContentOpenBtn());
		Assert.assertTrue(VS.getTotalCount().isDisplayed());
		Assert.assertTrue(VS.getAwaitingForMyReviewCount().isDisplayed());
		text = "Completed";
		actual = "Total and awaiting for my review count is display successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyAdminCanAbleToSelectMultipleStatus(String projectName) {
		
		String expect = "Verfi admin should be able to select multiple status";
		String actual = "Verfi admin is not able to select multiple status";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getContentOpenBtn());
		Assert.assertTrue(VS.getSelectStatus().isDisplayed());
		int statusCount = VS.getMultipleStatus().size();
		Assert.assertTrue(1<statusCount);
		text = "Completed";
		actual = "Admin is able to select multiple status successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void applySortAndFilterInNominationTab(String projectName) {
		
		String expect = "Verfi admin should be able to apply sort and filter in nomination tab";
		String actual = "Verfi admin is not able to apply sort and filter in nomination tab";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getNominationTab());
		Assert.assertTrue(VS.getContributorNameSort().isDisplayed());
		Assert.assertTrue(VS.getTypeSort().isDisplayed());
		Assert.assertTrue(VS.getContentSort().isDisplayed());
		Assert.assertTrue(VS.getSampleSort().isDisplayed());
		Assert.assertTrue(VS.getNominationDateSort().isDisplayed());
		Assert.assertTrue(VS.getNominationTabStatus().isDisplayed());
		text = "Completed";
		actual = "Verfi admin is able to apply sort and filter in nomination tab successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}


public static void verifyGuidelineNotAvailableInTheTextbookTab(String ProjectName) throws InterruptedException {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	String home = null;
	String expect = "Guideline Document should not be available in the textbook tab for "+ProjectName;
	String actual = "Guideline Document should is available in the textbook tab for "+ProjectName;

	try {
		String s1 = "(//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " ']//following::button[text()='Open '])[1]";
		Thread.sleep(10000);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		Thread.sleep(5000);
		
		String GuidelineDetails = VS.getAssertGuidelineDetails().getText();
		String[] lines = GuidelineDetails.split("\r\n|\r|\n");
		System.out.println(lines);
		System.out.println(lines.length);
		
		for (String line : lines) {
		    System.out.println(line);
		    Assert.assertNotEquals(line,"View Content Guidelines Document Filter Digital Textbooks Download Digital Textbook Details");
		}
		home = VS.getAssertDigiTextBookDet().getText();
		actual = "Guideline Document should is not available in the textbook tab for "+ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Download Digital Textbook details", homeText, expect, actual);
	}

}

public static String CreateNewProjectwithAllContentTypesWithDigitalTextBooks() throws InterruptedException {
	String home = null;
	String expect = "Sourcing org admin is able to create Project without Guideline Document";
	String actual = "Sourcing org admin is unable to create Project without Guideline Document";

	
	String home2 = null;
	String expect2 = "Confirmation pop up should displayed on click of publish button";
	String actual2 = "Confirmation pop up is not displayed on click of publish button";
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
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Sourcing org admin is able to Create and Publish The Project Successfully without Guideline Document";
		
		home2 = VO.getAssertProjectPublished().getText();
		actual2 = "Confirmation pop up is displayed on click of publish button";
		
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Project published successfully!", homeText2, expect2, actual2);
	}
}

public static void verifyProjectDetailsAndScopeTab() throws InterruptedException {
	String home1 = null;
	String expect1 = "creation details tab is should displayed post selecting the radio button in the create a project pop up and click on next button.";
	String actual1 = "creation details tab is not displayed post selecting the radio button in the create a project pop up and click on next button.";
	
	String home2 = null;
	String expect2 = "Project Scope tab should displayed post selecting the radio button in the create a project pop up and click on next button. ";
	String actual2 = "Project Scope tab is not displayed post selecting the radio button in the create a project  pop up and click on next button.";
	
	String home3 = null;
	String expect3 = "Project Scope Should Displayed With Content Guideline";
	String actual3 = "Project Scope is not Displayed With Content Guideline";
	
	String home4 = null;
	String expect4 = "Project Scope Should Displayed With Save as draft and Publish Project button";
	String actual4 = "Project Scope is not Displayed With draft and Publish Project button";
	
	try {

		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());
		
		home1 = VS.getAssertDetailsTab().getText();
		actual1 = "creation details tab is not displayed post selecting the radio button in the create a project pop up and click on next button.";
		
		home2 = VS.getAssertProjectScopeTab().getText();
		actual2 = "Project Scope tab is displayed post selecting the radio button in the create a project pop up and click on next button.";
		
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
		Thread.sleep(2000);
	
		Assert.assertTrue(VS.getAssertContentType().isDisplayed());
		
		Assert.assertTrue(VS.getAssertTargetCol().isDisplayed());
		
		
		Assert.assertTrue(VS.getAssertBoard().isDisplayed());
		
		Assert.assertTrue(VS.getAssertMed().isDisplayed());
		
		Assert.assertTrue(VS.getAssertClassOpt().isDisplayed());
		
		Assert.assertTrue(VS.getAssertSub().isDisplayed());
		
		
		Assert.assertTrue(VS.getAssertGuideline().isDisplayed());
		
		home3 = VS.getAssertGuideline().getText();
		actual3 = "Project Scope is Displayed With Content Guideline";
		
		Assert.assertTrue(VO.getBtnSaveAsDraft().isDisplayed());
		Assert.assertTrue(VO.getClkPublishBtn().isDisplayed());
		
		home4 = VO.getClkPublishBtn().getText();
		actual4 = "Project Scope is not Displayed With draft and Publish Project button";
		
		
		
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Details", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Project Scope", homeText2, expect2, actual2);
		
		String homeText3 = home3 != null ? home3 : "N/A";
		Listeners.customAssert("Guidelines Document", homeText3, expect3, actual3);
		
		String homeText4 = home4 != null ? home4 : "N/A";
		Listeners.customAssert("Publish Project", homeText4, expect4, actual4);
	}

}



public static void verifyAdminIsAbleToLoginToTheSourcingPortal() throws Exception {
	String home = null;
	String expect = "sourcing org admin should be able to login successfully into the sourcing portal";
	String actual = "sourcing org admin is unable to login successfully into the sourcing portal";

	try {
		

		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		Assert.assertTrue(VO.getCreateNewBtn().isDisplayed());

	home = VO.getCreateNewBtn().getText();
	actual = "sourcing org admin is able to login successfully into the sourcing portal, select and deselect the contributor";

} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Create New Project", homeText, expect, actual);
}

}


public static void validateConfirmationPopUpDisplayedOnClickOfNoneInTheDropDown()
		throws InterruptedException {
	String home = null;
	String expect = "Confirmation pop with message 'Are you sure you want to remove the user from the project?' Should be displayed on click of none in the drop down.";
	String actual =  "Confirmation pop with message 'Are you sure you want to remove the user from the project?' is not displayed on click of none in the drop down.";

	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);

		VDNUtils.waitToBeClickableAndClick(VO.getAssertAssignUsers());

		VDNUtils.waitForElementToBeVisible(VO.getSearchField());
		
		Assert.assertTrue(VO.getSearchField().isDisplayed());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "Jaga2");
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndClick(VO.getSearchBtn());
		Thread.sleep(5000);
		VDNUtils.waitToBeClickableAndClick(VO.getSelectReviewerPostSearch());
		Thread.sleep(5000);
		Assert.assertTrue(VS.getAssertNonOpt().isDisplayed());
		
		VDNUtils.waitToBeClickableAndClick(VS.getAssertNonOpt());
		Thread.sleep(3000);
		Assert.assertTrue(VS.getAssertConfirmationPopup().isDisplayed());
		
		home = VS.getAssertConfirmationPopup().getText();
		System.out.println(home);
		
		VDNUtils.waitToBeClickableAndClick(VS.getClkYesBtn());
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(VO.getCloseIcon());
		Assert.assertTrue(VO.getAssertReviewerOnTop().isDisplayed());

		actual = "Confirmation pop with message 'Are you sure you want to remove the user from the project?' is displayed on click of none in the drop down." ;
	} finally {
		String homeText = home != null ? home : "N/A";
		System.out.println(homeText);
		Listeners.customAssert("Are you sure you want to remove the user from the project?", homeText, expect, actual);
	}
}

public static String createProjectTextBookWithYourOrgAndSkipReviewDisable() throws Exception {
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
	
//	js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
//	Date.setTodayDate(driver, VO.getNominationEndDate());
//
//	Thread.sleep(500);
//	Date.setTodayDate(driver);
//	Thread.sleep(1000);
//	Actions action = new Actions(driver);
//	action.sendKeys("\b").perform();
//	Thread.sleep(500);
//	action.sendKeys("4").perform();
//	Thread.sleep(500);
//
//	VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
//	Date.setTomorrowDate(driver, VO.getShortlistEndDate());
//
//	Thread.sleep(500);
//	Date.setTomorrowDate(driver);
//	Thread.sleep(1000);
//	action.sendKeys("\b").perform();
//	Thread.sleep(500);
//	action.sendKeys("4").perform();
//	Thread.sleep(500);
//	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
	
	VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
	
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
	
	VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
	
	Thread.sleep(3000);
	VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
	
	VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
	Thread.sleep(3000);
	
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

public static String createProjectWithCourseWithSkipRevEnable() throws InterruptedException {
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
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
		VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
		//JavascriptExecutor js = (JavascriptExecutor) driver;
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


	public static void verifyAllTheDetailsAreAvailableInNominationTab(String projectName) {
		
		String expect = "Verify all details should be available in nomination tab";
		String actual = "All the details are not available in nomination tab";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getNominationTab());
		Assert.assertTrue(VS.getNominationCount().isDisplayed());
		Assert.assertTrue(VS.getNominationTotal().isDisplayed());
		Assert.assertTrue(VS.getNominationApproved().isDisplayed());
		Assert.assertTrue(VS.getNominationRejected().isDisplayed());
		Assert.assertTrue(VS.getNominationPending().isDisplayed());
		Assert.assertTrue(VS.getDownloadNominationsList().isDisplayed());
		Assert.assertTrue(VS.getContributedBy().isDisplayed());
		Assert.assertTrue(VS.getNominationsContent().isDisplayed());
		Assert.assertTrue(VS.getNominationsContentType().isDisplayed());
		Assert.assertTrue(VS.getContributorNameSort().isDisplayed());
		Assert.assertTrue(VS.getTypeSort().isDisplayed());
		Assert.assertTrue(VS.getContentSort().isDisplayed());
		Assert.assertTrue(VS.getSampleSort().isDisplayed());
		Assert.assertTrue(VS.getNominationDateSort().isDisplayed());
		Assert.assertTrue(VS.getNominationTabStatus().isDisplayed());
		text = "Completed";
		actual = "All the details are available in nomination tab successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyStatusFilterInNominationTab(String projectName) {
		
		String expect = "Verify admin can apply filter get the nomination status";
		String actual = "Admin is unable to apply filter get the nomination status";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getNominationTab());
		Assert.assertTrue(VS.getNominationTabStatus().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VS.getNominationTabStatus());
		VDNUtils.waitToBeClickableAndClick(VS.getNominationsApproved());
		Assert.assertTrue(VS.getViewContribution().isDisplayed());
		text = "Completed";
		actual = "Admin able to apply filter get the nomination status successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}
	

	public static void verifyAllTheDetailsInAssignUsersToProjectTab(String projectName) {
			
			String expect = "All the details in assign user tab should be display to user";
			String actual = "All the details in assign user tab is not displayed to user";
			String text = "N/A";
			try {
		
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			String s1 = "((//*[text()=' ";
			String s2 = projectName;
			String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
			String s4 = "((//*[text()='";
			String s5 = " ']))";
			WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(openBtn);
			VDNUtils.waitToBeClickableAndClick(VS.getAssignUserTab());
			WebElement projectname = driver.findElement(By.xpath(s4 + s2 + s5));
			Assert.assertTrue(projectname.isDisplayed());
			Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
			Assert.assertTrue(VS.getProjectDates().isDisplayed());
			Assert.assertTrue(VS.getNameWithUserCount().isDisplayed());
			Assert.assertTrue(VS.getSearchBar().isDisplayed());
			Assert.assertTrue(VS.getUserName().isDisplayed());
			Assert.assertTrue(VS.getUserEmailMobile().isDisplayed());
			Assert.assertTrue(VS.getUserSubject().isDisplayed());
			Assert.assertTrue(VS.getUserClass().isDisplayed());
			Assert.assertTrue(VS.getUserMedium().isDisplayed());
			text = "Completed";
			actual = "All the details in assign user tab is displayed to user successfully";
			}finally {
				Listeners.customAssert("Completed", text, expect, actual);
			}
			
		}
	
	public static void assignRoleToUser(String projectName) throws Exception {
		
		String expect = "Admin should be able to assign role to user";
		String actual = "Admin unable to assign role to user";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getAssignUserTab());
		VDNUtils.waitToBeClickableAndSendKeys(VS.getManageUserSearch(), "jaga2");
		VDNUtils.waitToBeClickableAndClick(VS.getManageUserSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getSelectRole());
		VDNUtils.waitToBeClickableAndClick(VS.getManageUserSearchBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getSelectRole());
		VDNUtils.waitToBeClickableAndClick(VS.getRoleReviewer());
		Thread.sleep(1000);
		Assert.assertTrue(VS.getRoleUpdated().isDisplayed());
		text = "Completed";
		actual = "Admin is able to assign role to user successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}
	
	public static void verifyAllTheDetailsInContributionDashboardTab(String projectName) {
		
		String expect = "All the details in contribution dashboard tab should be display to user";
		String actual = "All the details in contribution dashboard tab is not displayed to user";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		String s4 = "((//*[text()='";
		String s5 = " ']))";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getContributionDashboard());
		WebElement projectname = driver.findElement(By.xpath(s4 + s2 + s5));
		Assert.assertTrue(projectname.isDisplayed());
		Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
		Assert.assertTrue(VS.getProjectDates().isDisplayed());
		Assert.assertTrue(VS.getDownloadContributonDetails().isDisplayed());
		Assert.assertTrue(VS.getContributor().isDisplayed());
		Assert.assertTrue(VS.getTypeOfContributor().isDisplayed());
		Assert.assertTrue(VS.getContributingOrganisation().isDisplayed());
		Assert.assertTrue(VS.getYourOrganisation().isDisplayed());
		text = "Completed";
		actual = "All the details in contribution dashboard tab is display to user successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}
	

	public static void validateyNominationAndContributionStatusAndApply()
			throws Exception {

		
		String home1 = null;
		String expect1 = "sourcing orgadmin should be able apply filter as Open for contribution date.";
		String actual1 = "sourcing orgadmin is unable apply filter as Open for contribution date.";
		String home2 = null;
		String expect2 = "sourcing orgadmin should be able apply filter as Closed option for Contribution date.";
		String actual2 = "sourcing orgadmin is unable apply filter as Closed option for Contribution date.";
		String home3 = null;
		String expect3 = "sourcing orgadmin should be able apply filter as Any option for Contribution date.";
		String actual3 = "sourcing orgadmin is unable apply filter as Any option for Contribution date.";
		
		String home4 = null;
		String expect4 = "sourcing orgadmin should be able apply filter as Open for nomination date.";
		String actual4 = "sourcing orgadmin is unable apply filter as Open for nomination date.";
		String home5 = null;
		String expect5 = "sourcing orgadmin should be able apply filter as Closed option for nomination date.";
		String actual5 = "sourcing orgadmin is unable apply filter as Closed option for nomination date.";
		String home6 = null;
		String expect6 = "sourcing orgadmin should be able apply filter as Any option for nomination date.";
		String actual6 = "sourcing orgadmin is unable apply filter as Any option for nomination date.";
		
		String home7 = null;
		String expect7 = "sourcing orgadmin should be able to apply filters for Nomination date & Contribution date.";
		String actual7 = "sourcing orgadmin is unable to apply filters for Nomination date & Contribution date.";

		
		try {
			
			Thread.sleep(3000);
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			Assert.assertTrue(VS.getSelContributionDate().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VS.getSelContributionDate());
			VDNUtils.waitToBeClickableAndClick(VS.getClkConOpenStatus());
			Assert.assertTrue(VS.getClkConOpenStatus().isDisplayed());
			home1 = VS.getClkConOpenStatus().getText();
			System.out.print(home1);
			Thread.sleep(2000);
			actual1 = "sourcing orgadmin is able apply filter as Open option for Contribution date.";
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
			
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			Thread.sleep(3000);
			Assert.assertTrue(VS.getSelContributionDate().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VS.getSelContributionDate());
			VDNUtils.waitToBeClickableAndClick(VS.getClkConClosedStatus());
			Assert.assertTrue(VS.getClkConClosedStatus().isDisplayed());
			home2 = VS.getClkConClosedStatus().getText();
			System.out.print(home2);
			Thread.sleep(2000);
			actual2 = "sourcing orgadmin is able apply filter as Closed option for Contribution date.";
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
			
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			Thread.sleep(3000);
			Assert.assertTrue(VS.getSelContributionDate().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VS.getSelContributionDate());
			VDNUtils.waitToBeClickableAndClick(VS.getClkConAnyStatus());
			Assert.assertTrue(VS.getClkConAnyStatus().isDisplayed());
			home3 = VS.getClkConAnyStatus().getText();
			System.out.print(home3);
			actual3 = "sourcing orgadmin is able apply filter as Any option for Contribution date.";
			
			Thread.sleep(2000);
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
			
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			Thread.sleep(3000);
			
			Assert.assertTrue(VS.getSelNominationDate().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VS.getSelNominationDate());
			VDNUtils.waitToBeClickableAndClick(VS.getClkNomOpenStatus());
			Assert.assertTrue(VS.getClkNomOpenStatus().isDisplayed());
			home4 = VS.getClkNomOpenStatus().getText();
			System.out.print(home4);
			Thread.sleep(2000);
			actual4 = "sourcing orgadmin is able apply filter as Open option for nomination date.";
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
			
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			Thread.sleep(3000);
			Assert.assertTrue(VS.getSelNominationDate().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VS.getSelNominationDate());
			VDNUtils.waitToBeClickableAndClick(VS.getClkNomClosedStatus());
			Assert.assertTrue(VS.getClkNomClosedStatus().isDisplayed());
			home5 = VS.getClkNomClosedStatus().getText();
			System.out.print(home5);
			Thread.sleep(2000);
			actual5 = "sourcing orgadmin is able apply filter as Closed option for nomination date.";
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
			
			VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
			Thread.sleep(3000);
			Assert.assertTrue(VS.getSelNominationDate().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VS.getSelNominationDate());
			VDNUtils.waitToBeClickableAndClick(VS.getClkNomAnyStatus());
			Assert.assertTrue(VS.getClkNomAnyStatus().isDisplayed());
			
			home6 = VS.getClkNomAnyStatus().getText();
			System.out.print(home6);
			
			Thread.sleep(2000);
			actual6 = "sourcing orgadmin is able apply filter as Any option for nomination date.";
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
			
			Assert.assertTrue(VS.getAssert2Filters().isDisplayed());
			home7 = VS.getAssert2Filters().getText();
			System.out.print(home7);
			actual7 = "sourcing orgadmin is able to apply filters for Nomination date & Contribution date.";
	
		} finally {
			String homeText1 = home1 != null ? home1 : "N/A";
			Listeners.customAssert("Open" ,homeText1, expect1, actual1);
			String homeText2 = home2 != null ? home2 : "N/A";
			Listeners.customAssert("Closed" ,homeText2, expect2, actual2);
			String homeText3 = home3 != null ? home3 : "N/A";
			Listeners.customAssert("Any" ,homeText3, expect3, actual3);
			String homeText4 = home4 != null ? home4 : "N/A";
			Listeners.customAssert("Open" ,homeText4, expect4, actual4);
			String homeText5 = home2 != null ? home5 : "N/A";
			Listeners.customAssert("Closed" ,homeText5, expect5, actual5);
			String homeText6 = home6 != null ? home6 : "N/A";
			Listeners.customAssert("Any" ,homeText6, expect6, actual6);
			String homeText7 = home7 != null ? home7 : "N/A";
			Listeners.customAssert("2 Filters applied" ,homeText7, expect7, actual7);
		}
	}
	
	
	public static String createProjectBookSkipEnabedWithoutTargetCollection() throws Exception {
		String home = null;
		String expect = "Admin should be able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
		String actual = "Admin is unable to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

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
		
		//VDNUtils.waitToBeClickableAndClick(VS.getEnterReco());
		String ProjectRec = VDNUtils.set_Content_Name("AutoR_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectRec);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		
		Thread.sleep(3000);
		//VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
//		Thread.sleep(3000);
//		
//		UploadContentMethods.UploadPdf();
		

		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home = VO.getAssertProjectPublished().getText();
		actual = "Admin is able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
		return ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Project published successfully!", homeText, expect, actual);
	}

	}
	
	
	
	public static void verifyFrameworkTypeWhileCreatingProjectWithoutTC() throws Exception {
		String home1 = null;
		String expect1 = "Framework option should be available while creating the project";
		String actual1 = "Framework option is unavailable while creating the project";
		String home2 = null;
		
		String expect2 = "Admin should be able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
		String actual2 = "Admin is unable to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";

		try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

		VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

		String ProjectName = VDNUtils.set_Content_Name("AutoP_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

		String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
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
		
		//VDNUtils.waitToBeClickableAndClick(VS.getEnterReco());
		String ProjectRec = VDNUtils.set_Content_Name("AutoR_");
		VDNUtils.waitToBeClickableAndSendKeys(VS.getEnterReco(), ProjectRec);
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

		VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

		VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
		
		Thread.sleep(1000);
		
		Assert.assertTrue(VS.getAssertFrameworkType().isDisplayed());
		home1 = VS.getAssertFrameworkType().getText();
		System.out.print(home1);
		
		actual1 = "Framework option is available while creating the project";

		
		Thread.sleep(3000);
		VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
		Thread.sleep(3000);
		
		UploadContentMethods.UploadPdf();
		

		VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

		VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

		VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
		home2 = VO.getAssertProjectPublished().getText();
		actual2 = "Admin is able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Framework Type", homeText1, expect1, actual1);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Project published successfully!", homeText2, expect2, actual2);
	}

	}	
	
	
	public static void verifyContributionDashboardAvailableForAllTheCombinations(String projectName) {
			
		String home = null;
		String expect = "Contribution dashboard should be available for "+projectName;
		String actual = "Contribution dashboard is unavailable for "+projectName;
			try {
		
			VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
			Assert.assertTrue(VO.getAssertContribution().isDisplayed());
			
			home = VO.getAssertContribution().getText();
			System.out.print(home);
			
			actual = "Contribution dashboard is available for "+projectName;
			}finally {
				String homeText = home != null ? home : "N/A";
				Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);
	
			}
			
		}
	
	public static void verifyAllDetailsRreAvailableInTheReportSection(String projectName) {
			
			String expect = "All the details in report tab should be display to user";
			String actual = "All the details in report tab is not displayed to user";
			String text = "N/A";
			try {
		
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			String s1 = "((//*[text()=' ";
			String s2 = projectName;
			String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
			String s4 = "((//*[text()='";
			String s5 = " ']))";
			WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
			VDNUtils.waitToBeClickableAndClick(openBtn);
			VDNUtils.waitToBeClickableAndClick(VS.getReportTab());
			WebElement projectname = driver.findElement(By.xpath(s4 + s2 + s5));
			Assert.assertTrue(projectname.isDisplayed());
			Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
			Assert.assertTrue(VS.getProjectDates().isDisplayed());
			Assert.assertTrue(VS.getReportName().isDisplayed());
			Assert.assertTrue(VS.getReportDescription().isDisplayed());
			Assert.assertTrue(VS.getReportDownloadBtn().isDisplayed());
			text = "Completed";
			actual = "All the details in report tab is displayed to user successfully";
			}finally {
				Listeners.customAssert("Completed", text, expect, actual);
			}
			
		}
	
	public static void verifyAllTheReportsAreAvailableInTheReportSection(String projectName,String expectedReport) {
		
		String expect = expectedReport+" should be available in report tab";
		String actual = expectedReport+" is not available in report tab";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getReportTab());
		VDNUtils.waitForElementToBeVisible(VS.getReports());
		String actualReport = VS.getReports().getText();
		Assert.assertEquals(actualReport, expectedReport);
		text = "Completed";
		actual = expectedReport+" is available in report tab";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}

	
	public static void verifyManageUserTab() {
			
			String expect = "User with content reviewer role should be available in manage user tab";
			String actual = "User with content reviewer role is not available in manage user tab";
			String text = "N/A";
			try {
		
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VS.getManageUsers());
			VS.getRoles().click();
			Assert.assertTrue(VS.getRole().isDisplayed());
			text = "Completed";
			actual = "User with content reviewer role is available in manage user tab successfully";
			}finally {
				Listeners.customAssert("Completed", text, expect, actual);
			}
			
		}
	
	public static void verifyAdminIsAbleToSortTheUserBasedOnNameAndRole() {
		
		String expect = "Adimn should be able to sort users based on name and role";
		String actual = "Adimn is not able to sort users based on name and role";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getManageUsers());
		Assert.assertTrue(VS.getUserNameSort().isDisplayed());
		Assert.assertTrue(VS.getUserRoleSort().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VS.getUserNameSort());
		text = "Completed";
		actual = "Adimn is able to sort users based on name and role successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}
	
public static void verifyAdminIsAbleToSearchFetchTheUserAndClearTheSearch(String expectedUser) throws Exception {
		
		String expect = "Admin should be able to search and fetch the user and clear the search";
		String actual = "Admin is not able to search and fetch the user and clear the search";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getManageUsers());
		VDNUtils.waitToBeClickableAndSendKeys(VS.getManageUserSearch(), expectedUser);
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VS.getManageUserSearchBtn());
		String searchedUser = VS.getSearchedUser().getText();
		Assert.assertEquals(searchedUser, expectedUser);
		VDNUtils.waitToBeClickableAndClick(VS.getCloseIcon());
		text = "Completed";
		actual = "Admin is able to search and fetch the user and clear the search successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
		
	}




public static String validateCreateNewProjectwithAllContentTypesSkipRevEnable() throws InterruptedException {
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
		
//		String DraftCount = VO.getAssertDraftCount().getText();
//		System.out.println(DraftCount);
//		int DraftC=Integer.parseInt(DraftCount);  
//		
//        Assert.assertTrue(VO.getReviewPendingNode().isDisplayed());
//		
//		String ReviewPendingCount = VO.getAssertReviewPendingCount().getText();
//		
//		System.out.println(ReviewPendingCount);
//		int ReviewPendingC=Integer.parseInt(DraftCount); 
//		
//		int Total = DraftC+ReviewPendingC;
//		System.out.println(Total);
//		
//		Assert.assertTrue(VO.getTotalNode().isDisplayed());
//		
//		String TotalCount = VO.getTotalCount().getText();
//		int TotalC=Integer.parseInt(TotalCount);
//		
//		System.out.println(TotalCount);
//		Assert.assertEquals(Total,TotalC);
		
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
		String stausReviewPending3 = VO.getAssertReviewPending().getText();
		Assert.assertEquals(stausReviewPending,"Review Pending");
		
		
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
		Thread.sleep(2000);
		VO.getClkCheckBox().click();
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmit());
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertContentSetReview());
		
		Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
		
		Assert.assertTrue(VO.getAssertContentSetReview().isDisplayed());
		String stausReviewPending4 = VO.getAssertReviewPending().getText();
		Assert.assertEquals(stausReviewPending,"Review Pending");
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
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
		String stausReviewPending5 = VO.getAssertReviewPending().getText();
		Assert.assertEquals(stausReviewPending,"Review Pending");
		
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample6");
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
		String stausReviewPending6 = VO.getAssertReviewPending().getText();
		Assert.assertEquals(stausReviewPending,"Review Pending");
		
		VDNUtils.waitToBeClickableAndClick(VO.getClkCreateNew());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getSeltextBook());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(VO.getContinueBtn());
		
		Thread.sleep(3000);
		UploadContentMethods.UploadPdf();
		
		VDNUtils.waitToBeClickableAndClick(VO.getSubmitForReviewBtn());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterName(), "Sample7");
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
		String stausReviewPending7 = VO.getAssertReviewPending().getText();
		Assert.assertEquals(stausReviewPending,"Review Pending");
		
		
		actual = "Content available on the TOC with draft status for "+ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Review Pending" ,homeText, expect, actual);
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


public static void verifyAssignedReviewerIsAbleApprove(String ProjectName) throws Exception {
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
		
		for(int i=0;i<4;i++) {
			
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
		}
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

		VO.getSelectSample2().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
		//VDNUtils.waitForElementToBeVisible(VO.getClkPublish());
		
		VO.getClkPublish().click();
		Thread.sleep(5000);
		
		VO.getSelectSample2().click();
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
	
		VO.getSelectSample3().click();
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkPublish());
		
		
		VDNUtils.waitForElementToBeVisible(VO.getBtnReject());
		VDNUtils.waitToBeClickableAndClick(VO.getBtnReject());
		
		Thread.sleep(3000);
		
		VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterCommentForReject(), "Reject");
		VDNUtils.waitToBeClickableAndClick(VO.getClkSubmitRevBtn());
		Thread.sleep(3000);
		
		VO.getSelectSample2().click();
		Thread.sleep(2000);
		//VDNUtils.waitForElementToBeVisible(VO.getAssertApprovalPending());
		
		VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
		Thread.sleep(2000);
		
		VDNUtils.waitForElementToBeVisible(VO.getAssertRejectedOnTOC());
		Assert.assertTrue(VO.getAssertRejectedOnTOC().isDisplayed());
		
		String RejCount = VO.getAssertRejectedCount().getText();
		System.out.print(RejCount);
		
		int RejC=Integer.parseInt(RejCount); 
		VO.getSelectSample4().click();
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
		
		VO.getSelectSample2().click();
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

public static void verifyDetailsAndCountsContributionDashboardWithSkipReviewEnabled() throws InterruptedException {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	String home1 = null;
	String expect1 = "Draft Content and Count Should Display On Content Dashboard";
	String actual1 = "Draft Content and Count is not Display On Content Dashboard";
	
	String home2 = null;
	String expect2 = "Review Pending Content and Count Should Display On Content Dashboard";
	String actual2 = "Review Pending Content and Count is not Display On Content Dashboard";
	
	String home3 = null;
	String expect3 = "Correction Pending Content and Count Should Display On Content Dashboard";
	String actual3 = "Correction Pending Content and Count is not Display On Content Dashboard";
	
	String home4 = null;
	String expect4 = "Accepted Content and Count Should Display On Content Dashboard";
	String actual4 = "Accepted Content and Count is not Display On Content Dashboard";
	
	String home5 = null;
	String expect5 = "Accepted Content and Count Should Display On Content Dashboard";
	String actual5 = "Accepted Content and Count is not Display On Content Dashboard";
	
	String home6 = null;
	String expect6 = "Accepted Content and Count Should Display On Content Dashboard";
	String actual6 = "Accepted Content and Count is not Display On Content Dashboard";
	
	String home7 = null;
	String expect7 = "Accepted Content and Count Should Display On Content Dashboard";
	String actual7 = "Accepted Content and Count is not Display On Content Dashboard";
	
	String home8 = null;
	String expect8 = "Accepted Content and Count Should Display On Content Dashboard";
	String actual8 = "Accepted Content and Count is not Display On Content Dashboard";
	
	try {
		
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
//		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
		
		VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(VO.getAssertContribution());
		Thread.sleep(2000);
		
		Assert.assertTrue(VS.getAssertDraftTitle().isDisplayed());
		
		home1 = VS.getAssertDraftCount().getText();
		System.out.print(home1);
		actual1 =" Draft Content and Count is Display On Content Dashboard";
		
		Assert.assertTrue(VS.getAssertRevPenTitle().isDisplayed());
		
		home2 = VS.getAssertRevPenCount().getText();
		System.out.print(home2);
		actual2 =" Review Pending Content and Count is Display On Content Dashboard";
		
		home3 = VS.getAsssertCorPenCount().getText();
		System.out.print(home3);
		actual3 =" Correction Pending Content and Count is Display On Content Dashboard";
		
		home4 = VS.getAsssertAcceptedCount().getText();
		System.out.print(home4);
		actual4 =" Accepted Content and Count is Display On Content Dashboard";
		
		home5 = VS.getAsssertNotAcceptedCount().getText();
		System.out.print(home5);
		actual5 =" Review Pending Content and Count is Display On Content Dashboard";
		
		home6= VS.getAssertOrgAppPenCount().getText();
		System.out.print(home6);
		actual6 =" Review Pending Content and Count is Display On Content Dashboard";
		
		home7= VS.getAssertApprovedCount().getText();
		System.out.print(home7);
		actual7 =" Review Pending Content and Count is Display On Content Dashboard";
		
		home8= VS.getAssertRejectedCount().getText();
		System.out.print(home8);
		actual8 =" Review Pending Content and Count is Display On Content Dashboard";
		
		
		//actual = " is Sent For Approval and Send For Correction";
	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("1", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("2", homeText2, expect2, actual2);
		
		String homeText3 = home3 != null ? home3 : "N/A";
		Listeners.customAssert("1", homeText3, expect3, actual3);
		
		String homeText4 = home4 != null ? home4 : "N/A";
		Listeners.customAssert("3", homeText4, expect4, actual4);
	}

}

public static void verifyknowMoreButtonDisplayed() throws InterruptedException {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	String home = null;
	String expect = "'know more' button should displayed post clicking on the Question Mark icon for sourcing portal";
	String actual =  " 'know more' button is not displayed post clicking on the Question Mark icon for sourcing portal";
	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		Assert.assertTrue(VO.getClkManageUsers().isDisplayed());
		VDNUtils.waitForElementToBeVisible(VO.getClkManageUsers());
		VDNUtils.waitToBeClickableAndClick(VO.getClkManageUsers());
		
		Assert.assertTrue(VS.getAssertNeedHelp().isDisplayed());
		Assert.assertTrue(VS.getAssertQuestionMarkIcon().isDisplayed());
		
		Actions action = new Actions(driver);
		action.moveToElement(VS.getAssertQuestionMarkIcon()).perform();;
		
		Thread.sleep(2000);
		Assert.assertTrue(VS.getAssertKnowMoreBtn().isDisplayed());
		
		home = VS.getAssertKnowMoreBtn().getText();
		actual = "'know more' button is not displayed post clicking on the Question Mark icon for sourcing portal";
	

	} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Know More", homeText, expect, actual);
	}
}



public static void verifyQuestionMarkIconWithNeedHelp() throws InterruptedException {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
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
		Assert.assertTrue(VS.getAssertQuestionMarkIcon().isDisplayed());
		Thread.sleep(2000);
		
		home = VS.getAssertNeedHelp().getText();
		actual = "Question Mark icon with Need help ? is Displayed On Manage Users tab";
	

	} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Need Help?", homeText, expect, actual);
	}
}

public static void verfyOptionForWithoutTC() throws Exception {
	String home = null;
	String expect = " 'Get individual content not targeted to any collection' should be available for sourcing orgadmin on click of create new";
	String actual = "'Get individual content not targeted to any collection' is unavailable for sourcing orgadmin on click of create new";
	
	String home1 = null;
	String expect1 = "Verify Next button is enabled post selecting any one of the radio button";
	String actual1 = "Next button is Not enabled post selecting any one of the radio button";
	
	String home2 = null;
	String expect2 = "Admin should be able to cancel the pop up using the cancel button.";
	String actual2 = "Admin is unable to cancel the pop up using the cancel button.";

	try {
		
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
	UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
	VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
	Thread.sleep(2000);
	Assert.assertTrue(VS.getAssertRadioOpt1().isDisplayed());
	Assert.assertTrue(VS.getAssertRadioOpt2().isDisplayed());
	Assert.assertTrue(VS.getAssertRadioOpt3().isDisplayed());
	
	home = VO.getClkbtn().getText();
	System.out.println(home);
	actual = "'Get individual content not targeted to any collection' is available for sourcing orgadmin on click of create new";
	
	VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt3());
	Thread.sleep(2000);
	Assert.assertTrue(VO.getClkbtn().isEnabled());
	VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt1());
	Thread.sleep(2000);
	Assert.assertTrue(VO.getClkbtn().isEnabled());
	VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt2());
	Thread.sleep(2000);
	Assert.assertTrue(VO.getClkbtn().isEnabled());
	
	home1 = VO.getClkbtn().getText();
	System.out.println(home1);
	actual1 = "Next button is enabled post selecting any one of the radio button";
	
	Assert.assertTrue(VS.getBtnCancel().isDisplayed());
	VDNUtils.waitToBeClickableAndClick(VS.getBtnCancel());
	Assert.assertTrue(VS.getAssertCollection().isDisplayed());
	home2 = VS.getAssertCollection().getText();
	System.out.println(home2);
	actual2 = "Admin is able to cancel the pop up using the cancel button.";

} finally {
	
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Get individual content not targeted to any collection", homeText, expect, actual);
	
	String homeText1 = home1 != null ? home1 : "N/A";
	Listeners.customAssert("Next", homeText1, expect1, actual1);
	
	String homeText2 = home2 != null ? home2 : "N/A";
	Listeners.customAssert("For Books/Course/Other Collections", homeText2, expect2, actual2);
}
}

public static void VerifyAdminAbleToCancelThePopUp() throws Exception {
	String home = null;
	String expect = " 'Get individual content not targeted to any collection' should be available for sourcing orgadmin on click of create new";
	String actual = "'Get individual content not targeted to any collection' is unavailable for sourcing orgadmin on click of create new";
	
	String home1 = null;
	String expect1 = "Verify Next button is enabled post selecting any one of the radio button";
	String actual1 = "Next button is Not enabled post selecting any one of the radio button";
	
	String home2 = null;
	String expect2 = "Admin should be able to cancel the pop up using the cancel button.";
	String actual2 = "Admin is unable to cancel the pop up using the cancel button.";

	try {
		
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
	UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
	VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());
	Thread.sleep(2000);
	Assert.assertTrue(VS.getAssertRadioOpt1().isDisplayed());
	Assert.assertTrue(VS.getAssertRadioOpt2().isDisplayed());
	Assert.assertTrue(VS.getAssertRadioOpt3().isDisplayed());
	
	home = VS.getAssertRadioOpt3().getText();
	System.out.println(home);
	actual = "'Get individual content not targeted to any collection' is available for sourcing orgadmin on click of create new";
	
	VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt3());
	Thread.sleep(2000);
	Assert.assertTrue(VO.getClkbtn().isEnabled());
	VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt1());
	Thread.sleep(2000);
	Assert.assertTrue(VO.getClkbtn().isEnabled());
	VDNUtils.waitToBeClickableAndClick(VS.getAssertRadioOpt2());
	Thread.sleep(2000);
	Assert.assertTrue(VO.getClkbtn().isEnabled());
	
	home1 = VO.getClkbtn().getText();
	System.out.println(home1);
	actual1 = "Next button is enabled post selecting any one of the radio button";
	
	Assert.assertTrue(VS.getBtnCancel().isDisplayed());
	VDNUtils.waitToBeClickableAndClick(VS.getBtnCancel());
	Assert.assertTrue(VS.getAssertCollection().isDisplayed());
	home2 = VS.getAssertCollection().getText();
	System.out.println(home2);
	actual2 = "Admin is able to cancel the pop up using the cancel button.";

} finally {
	
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Get individual content not targeted to any collection", homeText, expect, actual);
	
	String homeText1 = home1 != null ? home1 : "N/A";
	Listeners.customAssert("Next", homeText1, expect1, actual1);
	
	String homeText2 = home2 != null ? home2 : "N/A";
	Listeners.customAssert("For Books/Course/Other Collections", homeText2, expect2, actual2);
}
}

public static void verifyFrameworkTypeK12AndCPDAvailableWhileCreatingProjectWithoutTC() throws Exception {
	String home1 = null;
	String expect1 = "Framework option should be available while creating the project";
	String actual1 = "Framework option is unavailable while creating the project";
	String home2 = null;
	String expect2 = "K12 Framework Should be Displayed Under Framework type dropdown";
	String actual2 = "K12 Framework is not Displayed Under Framework type dropdown";
	String home3 = null;
	String expect3 = "CPD Framework Should be Displayed Under Framework type dropdown";
	String actual3 = "CPD Framework is not Displayed Under Framework type dropdown";
	String home4 = null;
	String expect4 = "Admin should be able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
	String actual4 = "Admin is unable to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";

	try {
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
	UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
	VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

	VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

	VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

	String ProjectName = VDNUtils.set_Content_Name("AutoP_");
	VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

	String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
	VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
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
	
	String ProjectRec = VDNUtils.set_Content_Name("AutoR_");
	VDNUtils.waitToBeClickableAndSendKeys(VS.getEnterReco(), ProjectRec);
	
	VDNUtils.waitToBeClickableAndClick(VO.getClkNextButton());

	VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

	VDNUtils.waitToBeClickableAndClick(VO.getSelEtextBook());

	VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());
	
	Thread.sleep(1000);
	
	Assert.assertTrue(VS.getAssertFrameworkType().isDisplayed());
	home1 = VS.getAssertFrameworkType().getText();
	System.out.print(home1);
	
	actual1 = "Framework option is available while creating the project";
	
	
	VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
	
	Thread.sleep(3000);
	Assert.assertTrue(VS.getAssertK12FrameWork().isDisplayed());
	home2 = VS.getAssertK12FrameWork().getText();
	System.out.print(home2);
	actual2 = "K12 Framework is Displayed Under Framework type dropdown";
	Assert.assertTrue(VS.getSelFrameworTypeAsCPD().isDisplayed());
	home3 = VS.getSelFrameworTypeAsCPD().getText();
	System.out.print(home3);
	actual3 = "CPD Framework is Displayed Under Framework type dropdown";
	VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworTypeAsCPD());
	Thread.sleep(2000);
	VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
	Thread.sleep(2000);
//	VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
//	Thread.sleep(3000);
	
	Thread.sleep(3000);
	VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
	Thread.sleep(3000);
	
	UploadContentMethods.UploadPdf();
	VDNUtils.waitToBeClickableAndClick(VO.getClkPublishBtn());

	VDNUtils.waitToBeClickableAndClick(VO.getClkConfirm());

	VDNUtils.waitForElementToBeVisible(VO.getAssertProjectPublished());
	home4 = VO.getAssertProjectPublished().getText();
	actual4 = "Admin is able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
} finally {
	String homeText1 = home1 != null ? home1 : "N/A";
	Listeners.customAssert("Framework Type", homeText1, expect1, actual1);
	String homeText2 = home2 != null ? home2 : "N/A";
	Listeners.customAssert("Others", homeText2, expect2, actual2);
	String homeText3 = home3 != null ? home3 : "N/A";
	Listeners.customAssert("Continuous Professional Development", homeText3, expect3, actual3);
	String homeText4 = home4 != null ? home4 : "N/A";
	Listeners.customAssert("Project published successfully!", homeText4, expect4, actual4);
}

}	

public static String createProjectCourseWithNomAndSkipDisable1() throws Exception {
	String home = null;
	String expect = "Sourcing org admin is able to create and Publish The Project Successfully ";
	String actual = "Sourcing org admin is unable to create and Publish The Project Successfully";

	try {
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
	UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
	VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

	VDNUtils.waitToBeClickableAndClick(VO.getProjOpt1());

	VDNUtils.waitToBeClickableAndClick(VS.getClkNextBtn());

	String ProjectName = VDNUtils.set_Content_Name("AutoP_");
	VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

	String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
	VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);		
	VDNUtils.waitToBeClickableAndClick(VO.getSelYourOrgOnly());
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
//	VDNUtils.waitToBeClickableAndClick(VO.getNominationEndDate());
//	js.executeScript("arguments[0].scrollIntoView(true);", VO.getNominationEndDate());
//	Date.setTodayDate(driver, VO.getNominationEndDate());
//
//	Thread.sleep(500);
//	Date.setTodayDate(driver);
//	Thread.sleep(1000);
//	Actions action = new Actions(driver);
//	action.sendKeys("\b").perform();
//	Thread.sleep(500);
//	action.sendKeys("4").perform();
//	Thread.sleep(500);
//
//	VDNUtils.waitToBeClickableAndClick(VO.getShortlistEndDate());
//	Date.setTomorrowDate(driver, VO.getShortlistEndDate());
//
//	Thread.sleep(500);
//	Date.setTomorrowDate(driver);
//	Thread.sleep(1000);
//	action.sendKeys("\b").perform();
//	Thread.sleep(500);
//	action.sendKeys("4").perform();
//	Thread.sleep(500);
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
	//VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
	
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
	VDNUtils.waitToBeClickableAndClick(VO.getClkContentTypes());

	Thread.sleep(3000);
	VDNUtils.waitToBeClickableAndClick(Upload.getUploadBtn());
	Thread.sleep(3000);
	UploadContentMethods.UploadPdf();
	
	VDNUtils.waitToBeClickableAndClick(VO.getClkTargetCollectionCat());

	VDNUtils.waitToBeClickableAndClick(VO.getSelCourse());
	
    VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
	
	Thread.sleep(3000);
	VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworTypeAsCPD());
	
	VDNUtils.waitToBeClickableAndClick(VS.getBtnYes());
	Thread.sleep(2000);
	
	VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
	Thread.sleep(3000);
	
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

public static String createProjectBookSkipDisabledWithoutTargetCollection() throws Exception {
	String home = null;
	String expect = "Admin should be able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
	String actual = "Admin is unable to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";

	try {
	VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
	VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
	UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
	VDNUtils.waitToBeClickableAndClick(VO.getCreateNewBtn());

	VDNUtils.waitToBeClickableAndClick(VO.getProjOpt3());

	VDNUtils.waitToBeClickableAndClick(VO.getClkbtn());

	String ProjectName = VDNUtils.set_Content_Name("AutoP_");
	VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectName(), ProjectName);

	String ProjectDesc = VDNUtils.set_Content_Name("AutoD_");
	VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectDesc);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());

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
	String ProjectRec = VDNUtils.set_Content_Name("AutoR_");
	VDNUtils.waitToBeClickableAndSendKeys(VO.getEnterProjectDesc(), ProjectRec);
	
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
	actual = "Admin is able to create and publish 'From anyone (through Nomination Process)' with Skip review enabled and without target collection Project";
	return ProjectName;
} finally {
	String homeText = home != null ? home : "N/A";
	Listeners.customAssert("Project published successfully!", homeText, expect, actual);
}

}

public static void verifyCreatedProjectWithSkipReviewDisabled(String ProjectName) throws InterruptedException {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	String home = null;
	String expect = " Admin able to create "+ProjectName+" and publish the nomination open with Skip Review Disabled for Withot Target Collection ";
	String actual = " Admin unable to create "+ProjectName+" and publish the nomination open with Skip Review Disabled for Withot Target Collection ";
	String home2 = null;
	String expect2 = ProjectName+" Should be Created with Skip Review Disabled for Withot Target Collection ";
	String actual2 = ProjectName+" is not Created with Skip Review Disabled for Withot Target Collection ";

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
		System.out.println(home);
		actual = " Admin able to create "+ProjectName+" and publish the nomination open with Skip Review Disabled for Withot Target Collection ";
		
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		Thread.sleep(3000);
		
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
		home2 = VO.getAssertNomimnationList().getText();
		System.out.println(home2);
		actual2 = ProjectName+" is Created with Skip Review Disabled for Withot Target Collection ";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Open", homeText, expect, actual);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Download Nominations List", homeText2, expect2, actual2);
	}
}


public static String verifyContentCategoriesDuringProjectCreation() throws Exception {
	String home = null;
	String expect = "Sourcing org admin is able to create and Publish The Project Successfully without Target Collection";
	String actual = "Sourcing org admin is unable to create and Publish The Project Successfully without Target Collection";
	
	
	String home1 = null;
	String expect1 = "Course Assessment Should Displayed under Content Types";
	String actual1 = "Course Assessment is not Displayed under Content Types";
	
	String home2 = null;
	String expect2 = "Etextbook Should Displayed under Content Types";
	String actual2 = "Etextbook is not Displayed under Content Types";
	
	String home3 = null;
	String expect3 = "Explanation content Should Displayed under Content Types";
	String actual3 = "Explanation content is not Displayed under Content Types";
	
	String home4 = null;
	String expect4 = "Learning Resource Should Displayed under Content Types";
	String actual4 = "Learning Resource is not Displayed under Content Types";
	
	String home5 = null;
	String expect5 = "Practice question set Should Displayed under Content Types";
	String actual5 = "Practice question set is not Displayed under Content Types";
	
	String home6 = null;
	String expect6 = "Teacher Resource Should Displayed under Content Types";
	String actual6 = "Teacher Resource is not Displayed under Content Types";
	

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
	Thread.sleep(3000);
	home1 = VO.getSelCourseAssesment().getText();
	actual1 = "Course Assessment is Displayed under Content Types";
	
	home2 = VO.getSelEtextBook().getText();
	actual2 = "eTextBook is Displayed under Content Types";
	
	home3 = VO.getSelExplanationContent().getText();
	actual3 = "Explanation content is Displayed under Content Types";
	
	home4 = VO.getSelLearningResource().getText();
	actual4 = "Learning Resource is Displayed under Content Types";
	
	home5 = VO.getSelPQuestionSet().getText();
	actual5 = "Practice question set is Displayed under Content Types";
	
	home6 = VO.getSelTeacherResource().getText();
	actual6 = "Teacher Resource is Displayed under Content Types";

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
	String homeText1 = home1 != null ? home1 : "N/A";
	Listeners.customAssert("Course Assessment", homeText1, expect1, actual1);
	String homeText2 = home2 != null ? home2 : "N/A";
	Listeners.customAssert("eTextbook", homeText2, expect2, actual2);
	String homeText3 = home3 != null ? home3 : "N/A";
	Listeners.customAssert("Explanation Content", homeText3, expect3, actual3);
	String homeText4 = home4 != null ? home4 : "N/A";
	Listeners.customAssert("Learning Resource", homeText4, expect4, actual4);
	String homeText5 = home5 != null ? home5 : "N/A";
	Listeners.customAssert("Practice Question Set", homeText5, expect5, actual5);
	String homeText6 = home6 != null ? home6 : "N/A";
	Listeners.customAssert("Teacher Resource", homeText6, expect6, actual6);
}

}


	public static void verifyMyProjectTabForSourcingOrgreviewer() throws InterruptedException {
		
		String expect = "Verify my project details are present for sourcing orgreviewer";
		String actual = "My project details are not present for sourcing orgreviewer";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		
		Assert.assertTrue(VS.getMyProjectHeader().isDisplayed());
		Assert.assertTrue(VS.getMyProjectCount().isDisplayed());
		Assert.assertTrue(VS.getMyProjectSort().isDisplayed());
		Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
		Assert.assertTrue(VS.getMyProjectMCS().isDisplayed());
		Assert.assertTrue(VS.getMyProjectDates().isDisplayed());
		text = "Completed";
		actual = "My project details are present for sourcing orgreviewer successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyApplyFilterPopUp() throws InterruptedException {
			
			String expect = "Verify sourcing orgreviewer able to apply filter";
			String actual = "Sourcing orgreviewer not able to apply filter";
			String text = "N/A";
			try {
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VS.getApplyFilterBtn());
			VDNUtils.waitToBeClickableAndClick(VS.getMediumFilter());
			VDNUtils.waitToBeClickableAndClick(VS.getSelectMediumFilter());
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton1());
			Assert.assertTrue(VS.getFilterApplied().isDisplayed());
			text = "Completed";
			actual = "Sourcing orgreviewer is able to apply filter successfully";
			}finally {
				Listeners.customAssert("Completed", text, expect, actual);
			}
		}
	
	public static void verifyContentPlayListForSourcingOrgreviewer() throws InterruptedException {
		
		String expect = "All the details in content playlist should be display to sourcing orgreviewer";
		String actual = "All the details in content playlist is not displayed to sourcing orgreviewer";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getProjectOpenBtn());
		Assert.assertTrue(VS.getProjectName().isDisplayed());
		Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
		Assert.assertTrue(VS.getProjectDates().isDisplayed());
		Assert.assertTrue(VS.getContentPlaylistTotalCount().isDisplayed());
		Assert.assertTrue(VS.getApprovalPendingCount().isDisplayed());
		Assert.assertTrue(VS.getApprovedCount().isDisplayed());
		Assert.assertTrue(VS.getRejectedCount().isDisplayed());
		Assert.assertTrue(VS.getCorrectionsPendingCount().isDisplayed());
		Assert.assertTrue(VS.getContentList().isDisplayed());
		Assert.assertTrue(VS.getOpenBtn().isDisplayed());
		Assert.assertTrue(VS.getContentPlaylistFilter().isDisplayed());
		Assert.assertTrue(VS.getContentPlaylistDownload().isDisplayed());
		text = "Completed";
		actual = "All the details in content playlist is display to sourcing orgreviewer successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
public static void verifyContentCountIsAvailableOnTOCOnEachNode(String projectName) {
		
		String expect = "Verify content count is available on TOC on each node";
		String actual = "Content count is not available on TOC on each node";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getContentOpenBtn());
		Assert.assertTrue(VS.getSelectStatus().isDisplayed());
		int statusCount = VS.getMultipleStatus().size();
		Assert.assertTrue(1<statusCount);
		text = "Completed";
		actual = "Content count is available on TOC on each node";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}

	public static void verifyAssignedReviewerAbleToUseSortFunctionality(String projectName) {
		
		String expect = "Verfi assigned reviewer should be able to apply sort and filter in nomination tab";
		String actual = "Assigned reviewer is not able to apply sort and filter in nomination tab";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		String s1 = "((//*[text()=' ";
		String s2 = projectName;
		String s3 = " '])[1]/parent::td/following-sibling::td)[5]/descendant::button[text()='Open ']";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getNominationTab());
		Assert.assertTrue(VS.getContributorNameSort().isDisplayed());
		Assert.assertTrue(VS.getTypeSort().isDisplayed());
		Assert.assertTrue(VS.getContentSort().isDisplayed());
		Assert.assertTrue(VS.getSampleSort().isDisplayed());
		Assert.assertTrue(VS.getNominationDateSort().isDisplayed());
		Assert.assertTrue(VS.getNominationTabStatus().isDisplayed());
		text = "Completed";
		actual = "Assigned reviewer is able to apply sort and filter in nomination tab successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static String verifyAssignedReviewerAbleToUseFilterAndResetFilter() throws InterruptedException {
			
			String expect = "Assigned reviewer should be able to apply and reset filter";
			String actual = "Assigned reviewer is unable to apply and reset filter";
			String text = "N/A";
			try {
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VS.getProjectOpenBtn());
			String projectName = VS.getProjectName1().getText();
			VDNUtils.waitToBeClickableAndClick(VS.getContentPlaylistFilter());
			VDNUtils.waitToBeClickableAndClick(VS.getMediumFilter());
			VDNUtils.waitToBeClickableAndClick(VS.getSelectMediumFilter());
			VDNUtils.waitToBeClickableAndClick(VS.getApplyButton1());
			Assert.assertTrue(VS.getModifyFilterBtn().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VS.getModifyFilterBtn());
			VDNUtils.waitToBeClickableAndClick(VS.getResetBtn());
			text = "Completed";
			actual = "Assigned reviewer is able to apply and reset filter successfully";
			return projectName;
			}finally {
				Listeners.customAssert("Completed", text, expect, actual);
			}
		}
	
	public static void verifyPreviouslyAppliedFilter(String projectName) throws InterruptedException {
		
		String expect = "Verify previously applied filter are display";
		String actual = "Previously applied filter are not displayed";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		
		String s1 = "//div[text()=' ";
		String s2 = projectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		Assert.assertTrue(VS.getModifyFilterBtn().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VS.getModifyFilterBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getResetBtn());
		text = "Completed";
		actual = "Previously applied filter are displayed successfully";
		
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static String applyFilterAndResetFilter() throws InterruptedException {
		
		String expect = "Assigned reviewer should be able to apply and reset filter";
		String actual = "Assigned reviewer is unable to apply and reset filter";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getProjectOpenBtn());
		String projectName = VS.getProjectName1().getText();
		VDNUtils.waitToBeClickableAndClick(VS.getContentPlaylistFilter());
		VDNUtils.waitToBeClickableAndClick(VS.getMediumFilter());
		VDNUtils.waitToBeClickableAndClick(VS.getSelectMediumFilter());
		VDNUtils.waitToBeClickableAndClick(VS.getApplyButton1());
		Assert.assertTrue(VS.getModifyFilterBtn().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VS.getModifyFilterBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getResetBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getContentPlaylistFilter());
		VDNUtils.waitToBeClickableAndClick(VS.getMediumFilter());
		VDNUtils.waitToBeClickableAndClick(VS.getSelectMediumFilter());
		VDNUtils.waitToBeClickableAndClick(VS.getApplyButton1());
		Assert.assertTrue(VS.getModifyFilterBtn().isDisplayed());
		text = "Completed";
		actual = "Assigned reviewer is able to apply and reset filter successfully";
		return projectName;
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
public static String createProjectBookWithoutTargetCollectionSkipEnableSelectedCont() throws Exception {
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
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
	VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSelectedContributors());
	VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
	VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
	VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
	
	String OrgCon =  excel.getContentName("Org Contributor");
	System.out.print(OrgCon);
	
	VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
	VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),OrgCon);
	
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
	
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkNextButton());

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

public static String createProjectBookWithoutTargetCollectionSkipEnableSelectedInd() throws Exception {
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
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSkipReview());
	VDNUtils.waitToBeClickableAndClick(VO.getClkSkipReview());
	js.executeScript("arguments[0].scrollIntoView(true);", VO.getClkSelectedContributors());
	VDNUtils.waitToBeClickableAndClick(VO.getClkSelectedContributors());
	VDNUtils.waitForElementToBeVisible(VO.getClkSelectContributors());
	VDNUtils.waitToBeClickableAndClick(VO.getClkSelectContributors());
	
	VDNUtils.waitToBeClickableAndClick(VO.getClkContributionType());
	
	
	VDNUtils.waitToBeClickableAndClick(VO.getSelIndividual());
	Thread.sleep(3000);
	
	String IndCon =  excel.getContentName("Ind Contributor");
	System.out.print(IndCon);
	
	VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
	VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),IndCon);
	
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

public static void verifyCreatedProjectWithNominationOpenAndSkipReviewEnabledNoTC(String ProjectName) throws InterruptedException {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	String home = null;
	String expect = " sourcing org admin should be able to create nomination open without target and skip review enabled for project "+ProjectName;
	String actual = " sourcing org admin is unable to create nomination open without target and skip review enabled for project "+ProjectName;

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
		Assert.assertTrue(VO.getAssertNominationTab().isDisplayed());
		
		home = VO.getAssertSkipReviewEnabled().getText();
		actual = "sourcing org admin is able to create nomination open without target and skip review enabled for project "+ProjectName;
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Skip two level review enabled", homeText, expect, actual);
	}
}

public static void verifyProjectWithSkipReviewDisabledWithoutTC(String ProjectName) throws InterruptedException {
	HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
	String home = null;
	String expect = "Created Project "+ProjectName + " Must be Displayed with Nomination Disable and Skip Review Enable";
	String actual = "Created Project "+ProjectName + " is Not Displayed with Nomination Disable and Skip Review Enable";

	try {
		String s1 = "(//div[text()=' ";
		String s2 = ProjectName;
		String s3 = " '])[3]";
		String s4 = " ']//following::button[text()='Open '][1])[3]";
		Thread.sleep(10000);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
//
//		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s3));
//		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
//		Thread.sleep(5000);
		
		//Assert.assertTrue(VO.getAssertSkipReviewEnabled().isDisplayed());
		
		WebElement PublishedProject = driver.findElement(By.xpath(s1 + s2 + s3));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", PublishedProject);
		Assert.assertTrue(PublishedProject.isDisplayed());
		WebElement clkOpenProject = driver.findElement(By.xpath(s1 + s2 + s4));
		VDNUtils.waitToBeClickableAndClick(clkOpenProject);
		
		String TabDetails = VS.getAssertTabList().getText();
		String[] lines = TabDetails.split("\r\n|\r|\n");
		System.out.println(lines);
		System.out.println(lines.length);
		
		for (String line : lines) {
		    System.out.println(line);
		    Assert.assertNotEquals(line,"Nominations");
		}
		
		String contentDetails = VO.getAssertContnts().getText();
		String[] lines1 = contentDetails.split("\r\n|\r|\n");
		System.out.println(lines1.length);
		
		for (String line : lines1) {
		    System.out.println(line);
		    Assert.assertNotEquals(line,"Skip two level review enabled");
		}
		
		home = VO.getAssertAssignUsers().getText();
		actual = "Created Project "+ProjectName + " is Displayed with Nomination Disable and Skip Review Enable";
	} finally {
		String homeText = home != null ? home : "N/A";
		Listeners.customAssert("Assign users to project", homeText, expect, actual);
	}

}

public static void verifyReportSectionsdAvailableForAllTheCombinations(String projectName) {
	
	String home = null;
	String expect = "Reports sections should be available for "+projectName;
	String actual = "Reports sections is unavailable for "+projectName;
		try {
	
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		Assert.assertTrue(VO.getAssertReport().isDisplayed());
		
		home = VO.getAssertContribution().getText();
		System.out.print(home);
		
		actual = "Reports sections is unavailable for "+projectName;
		}finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("Contribution Dashboard", homeText, expect, actual);

		}
		

	}


	public static void verifyTotalAndAwaitingForMyReviewCountIsAvailableForReviewer() {
		
		String expect = "Verify total and awaiting for my review count should be display";
		String actual = "Verify total and awaiting for my review count is not display";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getProjectOpenBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getContentOpenBtn());
		Assert.assertTrue(VS.getTotalCount().isDisplayed());
		Assert.assertTrue(VS.getAwaitingForMyReviewCount().isDisplayed());
		text = "Completed";
		actual = "Total and awaiting for my review count is display successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
public static void verifySelectStatusAndSelectUnitForReviewer(String projectName) throws InterruptedException {
		
		String expect = "Verify select status and select unit for reviewer";
		String actual = "Select status and select unit is not displayed for reviewer";
		String text = "N/A";
		try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		
		String s1 = "//div[text()=' ";
		String s2 = projectName;
		String s3 = " ']//following::button[text()='Open '][1]";
		WebElement openBtn = driver.findElement(By.xpath(s1 + s2 + s3));
		VDNUtils.waitToBeClickableAndClick(openBtn);
		VDNUtils.waitToBeClickableAndClick(VS.getContentOpenBtn());
		Assert.assertTrue(VS.getContentUnits().isDisplayed());
		Assert.assertTrue(VS.getSelectStatus().isDisplayed());
		text = "Completed";
		actual = "Select status and select unit is displayed for reviewer successfully";
		
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}

	public static void verifyAllTheDetailsAreAvailableInNominationTabForReviewer() {
		
		String expect = "Verify all details should be available in nomination tab";
		String actual = "All the details are not available in nomination tab";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getProjectOpenBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getNominationTab());
		Assert.assertTrue(VS.getNominationCount().isDisplayed());
		Assert.assertTrue(VS.getNominationTotal().isDisplayed());
		Assert.assertTrue(VS.getNominationApproved().isDisplayed());
		Assert.assertTrue(VS.getNominationRejected().isDisplayed());
		Assert.assertTrue(VS.getNominationPending().isDisplayed());
		Assert.assertTrue(VS.getDownloadNominationsList().isDisplayed());
		Assert.assertTrue(VS.getContributedBy().isDisplayed());
		Assert.assertTrue(VS.getNominationsContent().isDisplayed());
		Assert.assertTrue(VS.getNominationsContentType().isDisplayed());
		Assert.assertTrue(VS.getContributorNameSort().isDisplayed());
		Assert.assertTrue(VS.getTypeSort().isDisplayed());
		Assert.assertTrue(VS.getContentSort().isDisplayed());
		Assert.assertTrue(VS.getSampleSort().isDisplayed());
		Assert.assertTrue(VS.getNominationDateSort().isDisplayed());
		Assert.assertTrue(VS.getNominationTabStatus().isDisplayed());
		text = "Completed";
		actual = "All the details are available in nomination tab successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}
	
	public static void verifyReviewerIsAbleToApplyFilterInNominationTab() {
			
			String expect = "Verify reviewer is able to apply filter in nomination tab";
			String actual = "Reviewer is unable to apply filter in nomination tab";
			String text = "N/A";
			try {
		
			VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
			VDNUtils.waitToBeClickableAndClick(VS.getProjectOpenBtn());
			VDNUtils.waitToBeClickableAndClick(VS.getNominationTab());
			VDNUtils.waitToBeClickableAndClick(VS.getNominationTabStatus());
			VDNUtils.waitToBeClickableAndClick(VS.getNominationFilterOpn());
			text = "Completed";
			actual = "Reviewer is able to apply filter in nomination tab successfully";
			}finally {
				Listeners.customAssert("Completed", text, expect, actual);
			}
		}

public static void verifyViewContributionOnApprovedCourse() throws Exception {
	String home1 = null;
	String expect1 = "View contribution button should be available";
	String actual1 = "View contribution button is available";
	String home2 = null;
	String expect2 = "List of Courses should be available in the Project created using Content playlist on click of view contribution in the nomination tab";
	String actual2 = "List of Courses playlist is unavailable in the Project created using Content playlist on click of view contribution in the nomination tab";
	
try {
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		Assert.assertTrue(VS.getClkViewContribution().isDisplayed());
		
		home1 = VS.getClkViewContribution().getText();
		actual1 = "View contribution button should be available";
		
		VDNUtils.waitToBeClickableAndClick(VS.getClkViewContribution());
		Thread.sleep(3000);
		Assert.assertTrue(VS.getListOfCourses().isDisplayed());
	
		home2 = VS.getListOfCourses().getText();
		actual1 = "Content Courses should be available in the Project created using Content playlist on click of view contribution in the nomination tab";
		
			
	}finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("View Contribution", homeText1, expect1, actual1);
		
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("List of Courses", homeText2, expect2, actual2);
	
}
}

	public static void verifyAllTheDetailsAreAvailableInContributionDashboardForReviewer() {
		
		String expect = "All the details in contribution dashboard tab should be display to user";
		String actual = "All the details in contribution dashboard tab is not displayed to user";
		String text = "N/A";
		try {
	
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		VDNUtils.waitToBeClickableAndClick(VS.getProjectOpenBtn());
		VDNUtils.waitToBeClickableAndClick(VS.getContributionDashboard());
		Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
		Assert.assertTrue(VS.getProjectDates().isDisplayed());
		Assert.assertTrue(VS.getDownloadContributonDetails().isDisplayed());
		Assert.assertTrue(VS.getContributor().isDisplayed());
		Assert.assertTrue(VS.getTypeOfContributor().isDisplayed());
		Assert.assertTrue(VS.getContributingOrganisation().isDisplayed());
		Assert.assertTrue(VS.getYourOrganisation().isDisplayed());
		text = "Completed";
		actual = "All the details in contribution dashboard tab is display to user successfully";
		}finally {
			Listeners.customAssert("Completed", text, expect, actual);
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
			Assert.assertTrue(VS.getContentTypeProject().isDisplayed());
			Assert.assertTrue(VO.getViewSampleBtn().isDisplayed());	
			String SampleCount = VO.getAssertSampleCount1().getText();
			System.out.print(SampleCount);	
			int SampleC=Integer.parseInt(SampleCount); 
			Assert.assertEquals(SampleC, 1);	
			VDNUtils.waitToBeClickableAndClick(VO.getViewSampleBtn());
			Thread.sleep(3000);
			Assert.assertTrue(VO.getSelectSample1().isDisplayed());
			VDNUtils.waitToBeClickableAndClick(VO.getBackBtn());
			VDNUtils.waitToBeClickableAndClick(VS.getAcceptBtn());
			text = "Completed";
			actual = "Admin is able to view sample and accept nomination successfully";
		} finally {
			Listeners.customAssert("Completed", text, expect, actual);
		}
	}

public static void uploadContentFromDefaultContributor(String ProjectName)
		throws Exception {
	String ReviewPending = null;
	String expect = "Default Contributor Org is able to upload Content For Project "+ProjectName;
	String actual =  "Default Contributor Org is unable to upload Content For Project "+ProjectName;

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
		VDNUtils.waitForElementToBeVisible(VO.getAssertReviewPending());
		Assert.assertTrue(VO.getAssertReviewPending().isDisplayed());
		
		ReviewPending = VO.getAssertReviewPending().getText();
		actual = "Default Contributor Org is able to upload Content For Project "+ProjectName;
	} finally {
		String homeText = ReviewPending != null ? ReviewPending : "N/A";
		Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}

public static void verifyDefaultOrgUserWithBothAsRoleIsAbleToReviewTheContent(String ProjectName)
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


public static void CloseEditDetailAnduploadContent()
		throws Exception {
	String ReviewPending = null;
	String expect = "Assigned Contributor Org is able to upload Content For Project ";
	String actual =  "Assigned Contributor Org is unable to upload Content For Project ";

	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
//		VDNUtils.waitToBeClickableAndClick(VO.getClkMyProject());
//		String s1 = "//div[text()=' ";
//		String s2 = ProjectName;
//		String s3 = " ']//following::button[text()='Open '][1]";
//		
//		WebElement assertProjectOnContributor = driver.findElement(By.xpath(s1 + s2 + s3));
		
//		VDNUtils.waitForElementToBeVisible(assertProjectOnContributor);
//		assertProjectOnContributor.isDisplayed();
//		assertProjectOnContributor.click();

//		Assert.assertTrue(VO.getClkUploadContent().isDisplayed());

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
		VDNUtils.waitForElementToBeVisible(VO.getAssertRevPending2());
		Assert.assertTrue(VO.getAssertRevPending2().isDisplayed());
		
		ReviewPending = VO.getAssertRevPending2().getText();
		System.out.println(ReviewPending);
		actual = "Assigned Contributor Org is able to upload Content For Project ";
	} finally {
		String homeText = ReviewPending != null ? ReviewPending : "N/A";
		Listeners.customAssert("Review Pending" ,homeText, expect, actual);
	}
}

public static void validateitlesUnderManageUsersTab() throws InterruptedException {
	String home1 = null;
	String expect1 = "1.User name should be Displayed on Manage Users tab";
	String actual1 =  "1.User name is not Displayed on Manage Users tab";
	
	String home2 = null;
	String expect2 = "2. Email / Mobile should be Displayed on Manage Users tab";
	String actual2 = "2. Email / Mobile is not Displayed on Manage Users tab";
	
	String home3 = null;
	String expect3 = "3. Roles should be Displayed on Manage Users tab";
	String actual3 = "3. Roles is not Displayed on Manage Users tab";
	try {
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		Thread.sleep(3000);
		Assert.assertTrue(VS.getAssertUserTitle().isDisplayed());
		Thread.sleep(2000);
		
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
	
	}
}

public static void validateSourceOrgReviewerIsAbleToSendTheContentForCorrection(String ProjectName)
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
		
//		Assert.assertTrue(VO.getAssertTotalTab1().isDisplayed());
//		String TotalCount = VO.getAssertTotalTab1().getText();
//		System.out.print(TotalCount);
//		
//		
//		Assert.assertTrue(VO.getAssertApprovalPendingTab().isDisplayed());
//		String APCount = VO.getAssertApprovalPendingTab().getText();
//		System.out.print(APCount);
//		
//		Assert.assertTrue(VO.getAssertApprovedTab().isDisplayed());
//		String ApprovedCount = VO.getAssertApprovalPendingTab().getText();
//		System.out.print(ApprovedCount);
//		
//		Assert.assertTrue(VO.getAssertRejectedTab().isDisplayed());
//		String RejectedCount = VO.getAssertRejectedTab().getText();
//		System.out.print(RejectedCount);
//		
//		Assert.assertTrue(VO.getAssertCorrectionTab().isDisplayed());
//		String CorrectioCountCount = VO.getAssertCorrectionTab().getText();
//		System.out.print(CorrectioCountCount);
		
		VO.getClkOpenBtnOnNoTC().click();
		Thread.sleep(3000);
		VO.getAssertApprovalPending().click();
		Thread.sleep(3000);

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
		System.out.println(home);
		actual = "sourcing org admin is able to send back to correction the content for The Project "+ProjectName;
		
		
	} finally {
//		String homeText = home != null ? home : "N/A";
//		Listeners.customAssert("Edit details" ,homeText, expect, actual);
	}
}


public static void validateyTargetCollectionsOnPopup()
		throws Exception {

	
	String home1 = null;
	String expect1 = "Content Playlist should be Available Under Tarhet Collection Dropdown";
	String actual1 = "Content Playlist is not Available Under Tarhet Collection Dropdown";
	String home2 = null;
	String expect2 = "Course should be Available Under Tarhet Collection Dropdown";
	String actual2 = "Course is not Available Under Tarhet Collection Dropdown";
	String home3 = null;
	String expect3 = "Digital Textbook should be Available Under Tarhet Collection Dropdown";
	String actual3 = "Digital Textbook is not Available Under Tarhet Collection Dropdown";
	
	String home4 = null;
	String expect4 = "Question paper should be Available Under Tarhet Collection Dropdown";
	String actual4 = "Question paper is Available Under Tarhet Collection Dropdown";
	
	try {
		
		Thread.sleep(3000);
		VDNSourcing VS = PageFactory.initElements(driver, VDNSourcing.class);
		Thread.sleep(2000);
		
		VDNUtils.waitToBeClickableAndClick(VS.getApplyBtn());
		Thread.sleep(3000);
		Assert.assertTrue(VS.getClkTargetColl().isDisplayed());
		VDNUtils.waitToBeClickableAndClick(VS.getClkTargetColl());
		Assert.assertTrue(VS.getClkContentPlaylist().isDisplayed());
		home1 = VS.getClkContentPlaylist().getText();
		System.out.print(home1);
		Thread.sleep(2000);
		actual1 = "Content Playlist is Available Under Tarhet Collection Dropdown";
		
		Thread.sleep(3000);
		Assert.assertTrue(VS.getClkTargetColl().isDisplayed());
		//VDNUtils.waitToBeClickableAndClick(VS.getClkTargetColl());
		Assert.assertTrue(VS.getClkCourse().isDisplayed());
		home2 = VS.getClkCourse().getText();
		System.out.print(home2);
		Thread.sleep(2000);
		actual2 = "Course is Available Under Tarhet Collection Dropdown";
		
		Thread.sleep(3000);
		Assert.assertTrue(VS.getClkTargetColl().isDisplayed());
		//VDNUtils.waitToBeClickableAndClick(VS.getClkTargetColl());
		Assert.assertTrue(VS.getClkDigiTextBook().isDisplayed());
		home3 = VS.getClkDigiTextBook().getText();
		System.out.print(home3);
		Thread.sleep(2000);
		actual3 = "Digital Textbook is not Available Under Tarhet Collection Dropdown";
		
		Thread.sleep(3000);
		Assert.assertTrue(VS.getClkTargetColl().isDisplayed());
		//VDNUtils.waitToBeClickableAndClick(VS.getClkTargetColl());
		Assert.assertTrue(VS.getClkQPaper().isDisplayed());
		home4 = VS.getClkQPaper().getText();
		System.out.print(home4);
		Thread.sleep(2000);
		actual4 = "Question paper is not Available Under Tarhet Collection Dropdown";
		
		VDNUtils.waitToBeClickableAndClick(VS.getApplyButton());
		
		

	} finally {
		String homeText1 = home1 != null ? home1 : "N/A";
		Listeners.customAssert("Content Playlist" ,homeText1, expect1, actual1);
		String homeText2 = home2 != null ? home2 : "N/A";
		Listeners.customAssert("Course" ,homeText2, expect2, actual2);
		String homeText3 = home3 != null ? home3 : "N/A";
		Listeners.customAssert("Digital Textbook" ,homeText3, expect3, actual3);
		String homeText4 = home4 != null ? home4 : "N/A";
		Listeners.customAssert("Question paper" ,homeText4, expect4, actual4);
//		String homeText5 = home2 != null ? home5 : "N/A";
//		Listeners.customAssert("Closed" ,homeText5, expect5, actual5);
//		String homeText6 = home6 != null ? home6 : "N/A";
//		Listeners.customAssert("Any" ,homeText6, expect6, actual6);
//		String homeText7 = home7 != null ? home7 : "N/A";
//		Listeners.customAssert("2 Filters applied" ,homeText7, expect7, actual7);
	}
}

}




