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
//			VDNUtils.waitToBeClickableAndClick(VS.getAssertCollection());
			
			Assert.assertTrue(VS.getAssertCollection().isDisplayed());
			
			Assert.assertTrue(VS.getAssertForQSet().isDisplayed());
			
			Assert.assertTrue(VS.getAssertIndContent().isDisplayed());
		
//			Thread.sleep(3000);
//			VDNUtils.waitToBeClickableAndClick(VO.getAssertReviewPending());
//			
//			VDNUtils.waitForElementToBeVisible(VO.getClkOpenBtnNoRC());
//			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
//			
//			
		
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
			
			

//			VDNUtils.waitToBeClickableAndClick(VO.getClkOpenBtnNoRC());
//			
//			
		
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
			throws InterruptedException {
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
			//span[contains(text(),' Pending ')]//following::button[1]
			
//			VDNUtils.waitToBeClickableAndClick(VO.getBtnAccept());
//			Thread.sleep(3000);
//			Assert.assertTrue(VO.getAssertNominationSuccess().isDisplayed());
			
			
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
			throws InterruptedException {
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
			VDNUtils.waitToBeClickableAndSendKeys(VO.getSearchField(), "Jaga2");
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		
		VDNUtils.waitForElementToBeVisible(VO.getEnterOrgName());
		VDNUtils.waitToBeVisibleAndSendKeys(VO.getEnterOrgName(),"testUser");
		
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
		
//		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkDropdown());
//		
//		Thread.sleep(3000);
//		VDNUtils.waitToBeClickableAndClick(VS.getSelFrameworkTypeK12());
//		
//		VDNUtils.waitToBeClickableAndClick(VS.getBtnApply());
//		Thread.sleep(3000);
	
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
	

}




