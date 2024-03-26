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
import pageObject.VDNObj;
import utility.BaseClass;
import utility.Listeners;
import utility.VDNUtils;
import pageObject.VDNSourcing;

public class VDNContributorMethods extends BaseClass {

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
	

}

