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


}

