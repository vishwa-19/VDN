package pageActions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import pageObject.BMCPopup;
import pageObject.ExplorePage;
import pageObject.HomePage;
import pageObject.HomePage;
import pageObject.LocationPopup;
import pageObject.LoginAsCustodian;
import pageObject.LoginPage;
import pageObject.Logout;
import pageObject.ManageUser;
//import pageObject.SubmitDetails;
//import pageObject.UpdateProfile;
import pageObject.UserHomeTab;
import pageObject.Useronboarding;
import pageObject.VDNObj;
import pageObject.ValidatePopUp;
import pageObject.userProfile;
import utility.BaseClass;
import utility.VDNUtils;
import utility.ExcelDataProvider;
import utility.Library;
import utility.Listeners;

public class UserOnBoarding extends BaseClass {

//	public static String SelectUserRole(String role) throws Exception {
//
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
		//Useronboarding Ub = PageFactory.initElements(driver, Useronboarding.class);
		VDNObj VO = PageFactory.initElements(driver, VDNObj.class);
		
//
//		
//		
//		
//		String expectedContinueButton = null;
//		boolean checkRoles = false;
//		boolean checkIfRoleIsSelected = false;
//		String expectedRole = null;
//		
//		String expected1 = "Verify user should be able to see the roles";
//		String actual1 = "User is not able to see the roles";
//
//		String expected2 = "Verify user should be able to select one of the roles";
//		String actual2 = "User is not able to select the roles";
//
//		try {
//
//			if (Ub.getWelcomeToDiksha().isDisplayed()) {
//				checkRoles = true;
//
//				Assert.assertTrue(Ub.getStudentIcon().isDisplayed());
//				Assert.assertTrue(Ub.getTeacher().isDisplayed());
//				Assert.assertTrue(Ub.getOther().isDisplayed());
//				Assert.assertTrue(Ub.getParent().isDisplayed());
//				Assert.assertTrue(Ub.getHeadteacher().isDisplayed());
//
//				actual1 = "User is able to see the roles successfully";
//				expectedRole = "True";
//			}
//
//			if (role.equals("Student")) {
//				VDNUtils.waitToBeClickableAndClick(Ub.getStudentIcon());
//				VDNUtils.waitToBeClickableAndClick(Ub.getContinueButton());
//			}
//
//			else if (role.equals("Teacher")) {
//				VDNUtils.waitToBeClickableAndClick(Ub.getTeacher());
//				VDNUtils.waitToBeClickableAndClick(Ub.getContinueButton());
//			}
//
//			else if (role.equals("Other")) {
//				VDNUtils.waitToBeClickableAndClick(Ub.getOther());
//				VDNUtils.waitToBeClickableAndClick(Ub.getContinueButton());
//			}
//
//			else if (role.equals("Parent")) {
//				VDNUtils.waitToBeClickableAndClick(Ub.getParent());
//				VDNUtils.waitToBeClickableAndClick(Ub.getContinueButton());
//			}
//
//			else if (role.equals("HT")) {
//				VDNUtils.waitToBeClickableAndClick(Ub.getHeadteacher());
//				VDNUtils.waitToBeClickableAndClick(Ub.getContinueButton());
//			}
//
//			if (bmcpopup.getBoard().isDisplayed()) {
//				checkIfRoleIsSelected = true;
//				// actual2 = "User is able to select the roles successfully";
//				actual2 = " User select role as a " + role + " successfully";
//				expectedContinueButton = "True";
//			}
//
//		} finally {
//
//			Listeners.customAssert("True", expectedRole, expected1, actual1);
//			Listeners.customAssert("True", expectedContinueButton, expected2, actual2);
//		}
//		return role;
//	}
//
//	public static void bmcpopuphandle() throws InterruptedException {
//
//		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//
//		String expected1 = "Verify user should be able to see BMC fields successfully";
//		String actual1 = "User is not able to see BMC fields";
//
//		String expected2 = "Verify user should be able to select BMC values successfully";
//		String actual2 = "User is not able to select BMC values";
//
//		boolean checkBMCValue = false;
//		boolean checkIfBMCIsSelected = false;
//
//		String expectedSubmitButton = null;
//		String expectedBMC = null;
//		String BMCPopup = null;
//
//		try {
//
//			if (bmcpopup.getBMCHeading().isDisplayed()) {
//				checkBMCValue = true;
//
//				Assert.assertTrue(bmcpopup.getBoard().isDisplayed());
//				Assert.assertTrue(bmcpopup.getMedium().isDisplayed());
//				Assert.assertTrue(bmcpopup.getClasss().isDisplayed());
//
//				actual1 = "User is able to see the BMC value successfully";
//				expectedBMC = "True";
//			}
//
//			VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
//			VDNUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
//			Thread.sleep(4000);
//			VDNUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
//			VDNUtils.waitToBeClickableAndClick(bmcpopup.getEnglish());
//
//			Actions act = new Actions(driver);
//			act.moveByOffset(50, 100).click().build().perform();
//			Thread.sleep(1000);
//			VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
//			VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClass2());
//
//			act.moveByOffset(50, 100).click().build().perform();
//			Thread.sleep(1000);
//			VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());
//			Thread.sleep(1000);
//			BMCPopup = popup.getbMCPopUp().getText();
//			Assert.assertEquals(BMCPopup, "User preference updated successfully");
//			Thread.sleep(2000);
//
//			if (BMCPopup.equals("User preference updated successfully")) {
//				checkIfBMCIsSelected = true;
//				actual2 = "User is able to selected the BMC values successfully";
//				expectedSubmitButton = "True";
//			}
//
//		} finally {
//
//			Listeners.customAssert("True", expectedBMC, expected1, actual1);
//			Listeners.customAssert("True", expectedSubmitButton, expected2, actual2);
//		}
//	}
//
//	public static void locationpopuphandle(String UserRole) throws Exception {
//
//		Useronboarding Ub = PageFactory.initElements(driver, Useronboarding.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//
//		String expected1 = "Verify user is able to see Name And Role fields successfully";
//		String actual1 = "User is not able to see Name And Role fields";
//
//		String expected2 = "Verify user is able to submit location details successfully";
//		String actual2 = "User is not able to submit location details";
//
//		boolean checkSubmitButtonIsSelected = false;
//		boolean checkRoleAndName = false;
//		String expectedRoleAndName = null;
//		String expectedSubmitButton = null;
//		Thread.sleep(2000);
//
//		try {
//
//			if (Ub.getWelcomeToDikshaLocation().isDisplayed()) {
//				checkRoleAndName = true;
//
//				Assert.assertTrue(locationpopup.getGuestNameTextField().isDisplayed());
//				String nameText = locationpopup.getGuestNameTextField().getAttribute("value");
//				Assert.assertEquals(nameText, "Guest");
//				Assert.assertTrue(locationpopup.getguestRole().isDisplayed());
//				String Guestrole = locationpopup.getguestRole().getText();
//				Assert.assertEquals(Guestrole, UserRole);
//				Assert.assertTrue(locationpopup.getState().isDisplayed());
//				Assert.assertTrue(locationpopup.getDistrict().isDisplayed());
//
//				actual1 = "User is able to see  Name And Role fields successfully";
//				expectedRoleAndName = "True";
//			}
//
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getState());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getMaharashtraState());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getAkolaDistrict());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getSubmitButton());
//
//			if (home.getHomeTab().isDisplayed()) {
//				checkSubmitButtonIsSelected = true;
//
//				actual2 = "user is able to submit location details successfully";
//				expectedSubmitButton = "True";
//			}
//
//		} finally {
//
//			Listeners.customAssert("True", expectedRoleAndName, expected1, actual1);
//			Listeners.customAssert("True", expectedSubmitButton, expected2, actual2);
//		}
//	}
//
//	public static void locationpopuphandle() throws Exception {
//
//		Useronboarding Ub = PageFactory.initElements(driver, Useronboarding.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//
//		String expected1 = "Verify user is able to see location popup fields successfully";
//		String actual1 = "User is not able to see location popup fields";
//
//		String expected2 = "Verify user is able to submit location details successfully";
//		String actual2 = "User is not able to submit location details";
//
//		boolean checkSubmitButtonIsSelected = false;
//		boolean checkRoleAndName = false;
//		String expectedRoleAndName = null;
//		String expectedSubmitButton = null;
//		Thread.sleep(2000);
//
//		try {
//
//			if (Ub.getWelcomeToDikshaLocation().isDisplayed()) {
//				checkRoleAndName = true;
//
//				Assert.assertTrue(locationpopup.getGuestNameTextField().isDisplayed());
//				String nameText = locationpopup.getGuestNameTextField().getAttribute("value");
//				Assert.assertEquals(nameText, "Guest");
//				Assert.assertTrue(locationpopup.getguestRole().isDisplayed());
//				String Guestrole = locationpopup.getguestRole().getText();
//				// Assert.assertEquals(Guestrole,UserRole);
//				Assert.assertTrue(locationpopup.getState().isDisplayed());
//				Assert.assertTrue(locationpopup.getDistrict().isDisplayed());
//
//				actual1 = "User is able to see location popup fields successfully";
//				expectedRoleAndName = "True";
//			}
//
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getState());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getMaharashtraState());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getAkolaDistrict());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getSubmitButton());
//
//			if (home.getHomeTab().isDisplayed()) {
//				checkSubmitButtonIsSelected = true;
//
//				actual2 = "user is able to submit location details successfully";
//				expectedSubmitButton = "True";
//			}
//
//		} finally {
//
//			Listeners.customAssert("True", expectedRoleAndName, expected1, actual1);
//			Listeners.customAssert("True", expectedSubmitButton, expected2, actual2);
//		}
//	}
//
//	public static void locationpopuphandleWithGuestName() throws Exception {
//
//		String Expected = "user able to change guest name as well as state and district value and updated on profile successfully";
//		String actual = "user not able to get updated name as well as state and district value on profile page ";
//
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//
//		try {
//			locationpopup.getGuestNameTextField().clear();
//			VDNUtils.waitToBeClickableAndSendKeys(locationpopup.getGuestNameTextField(), "Custodian");
//
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getState());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getMaharashtraState());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getAkolaDistrict());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getSubmitButton());
//			Thread.sleep(1000);
//			actual = "user able to see updated guest name as well as state and district value on profile page successfully ";
//
//		} finally {
//			String homeText = home.getHomeTab() != null ? home.getHomeTab().getText() : "N/A";
//			System.out.println(homeText);
//			Listeners.customAssert("Home", homeText, Expected, actual);
//		}
//
//	}
//
//	public static void login(String user) throws Exception {
//
//		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
//		String home=null;
//		String expect = user + " should be able to login successfully";
//		String actual = "Unable to login as " + user;
//
//		try {
//			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
//
////			DikshaUtils.waitToBeVisibleAndClick(loginpage.getHeaderDropdown());
////			DikshaUtils.waitToBeClickableAndClick(loginpage.getLogintab());
//
//			String cred[] = excel.getCredentails(user);
//			String username = cred[0];
//			String password = cred[1];
//			
//			String AppendExplore = "/sourcing";
//	        driver.get("https://vdn.diksha.gov.in/" + AppendExplore);
//
//			VDNUtils.waitToBeClickableAndSendKeys(loginpage.getUserName(), username);
//			VDNUtils.waitToBeClickableAndSendKeys(loginpage.getPassword(), password);
//			VDNUtils.waitToBeClickableAndClick(loginpage.getLogin());
//			Thread.sleep(5000);
//			 home=HomePage.getHomeTab().getText();
//			actual = user + " is able to login successfully";
//		} finally {
//			String homeText = home != null ? home : "N/A";
//			Listeners.customAssert("Home", homeText, expect, actual);
//		}
//	}
//
//	public static void logout(String user) throws Exception {
//		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
//		String Explorebutton = null;
//		String expect = user + " should be able to logout Successfully";
//		String actual = "Unable to logout";
//		try {
//
//			Logout log = PageFactory.initElements(driver, Logout.class);
//
//			VDNUtils.waitToBeClickableAndClick(log.getCreatorIcon());
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
//			VDNUtils.waitToBeClickableAndClick(log.getLogout());
//			Thread.sleep(2000);
//			Explorebutton = explore.getExplorebutton().getText();
//			VDNUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
//			actual = user + " is able to logout Successfully";
//		} finally {
//			String ExplorebuttonText = Explorebutton != null ? Explorebutton : "N/A";
//			Listeners.customAssert("EXPLORE DIKSHA", ExplorebuttonText, expect, actual);
//
//		}
//
//	}
//
//	public static void logout() throws Exception {
//
//		Logout log = PageFactory.initElements(driver, Logout.class);
//		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
//		String Explorebutton = null;
//
//		String expected = "User should logout Successfully";
//		String actual = "Unable to logout";
//		try {
//
//			VDNUtils.waitToBeClickableAndClick(log.getCreatorIcon());
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
//			VDNUtils.waitToBeClickableAndClick(log.getLogout());
//			Thread.sleep(2000);
//			Explorebutton = explore.getExplorebutton().getText();
//			VDNUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
//
//			actual = "Successfully logout";
//
//		} finally {
//			String ExplorebuttonText = Explorebutton != null ? Explorebutton : "N/A";
//			System.out.println(ExplorebuttonText);
//			Listeners.customAssert("EXPLORE DIKSHA", ExplorebuttonText, expected, actual);
//
//		}
//
//	}
//
//	public static void Verify_Guest_user_is_able_to_edit_BMC_Values() throws Exception {
//
//		userProfile guest = PageFactory.initElements(driver, userProfile.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
//		UserHomeTab home = PageFactory.initElements(driver, UserHomeTab.class);
//
//		String expected = "Verify user should be able to edit BMC values successfully";
//		String actual = "User is not able to to edit BMC values successfully";
//
//		boolean checkValue = false;
//		String expectedValue = null;
//
//		try {
//
//			if (home.gethomeTab().isDisplayed()) {
//				checkValue = true;
//
//				VDNUtils.waitToBeClickableAndClick(guest.headerDropdown());
//				VDNUtils.waitToBeClickableAndClick(guest.getProfilebutton());
//				VDNUtils.waitToBeClickableAndClick(locationpopup.getLocationeditbutton());
//				VDNUtils.waitToBeVisibleAndClick(locationpopup.getguestRole());
//				VDNUtils.waitToBeClickableAndClick(locationpopup.getTeacher());
//				VDNUtils.waitToBeVisibleAndClick(locationpopup.getDistrict());
//				VDNUtils.waitToBeClickableAndClick(locationpopup.getAmravati());
//				VDNUtils.waitToBeClickableAndClick(locationpopup.getLocationSubmitButton());
//
//				Thread.sleep(2000);
//
//				String actualRoleName = locationpopup.getTeacherprofile().getText();
//				String actualDistrictName = locationpopup.getTextAmravati().getText();
//
//				Thread.sleep(2000);
//
//				System.out.println(actualRoleName);
//				System.out.println(actualDistrictName);
//
//				Assert.assertEquals(actualRoleName, "Teacher");
//				Assert.assertEquals(actualDistrictName, "Amravati");
//
//				Thread.sleep(2000);
//
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].scrollIntoView(true);", bmcpopup.getBMCeditbutton());
//				Library.custom_click(bmcpopup.getBMCeditbutton(), "BMCEditbutton");
//				Thread.sleep(1000);
//
//				VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
//				VDNUtils.waitToBeClickableAndClick(bmcpopup.getIGOT_Health());
//				Thread.sleep(4000);
//				VDNUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
//				VDNUtils.waitToBeClickableAndClick(bmcpopup.getGujarati());
//				Thread.sleep(1000);
//
//				Actions act = new Actions(driver);
//				act.moveByOffset(50, 100).click().build().perform();
//				Thread.sleep(1000);
//
//				VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
//				VDNUtils.waitToBeVisibleAndClick(bmcpopup.getPharmacist());
//				act.moveByOffset(50, 100).click().build().perform();
//				Thread.sleep(1000);
//				Library.custom_click(bmcpopup.getBMCSubmit(), "bmcsubmit");
//				Thread.sleep(2000);
//
//				String actualBoardName = bmcpopup.getIGOT_Health().getText();
//				String actualMediumName = bmcpopup.getGujarati().getText();
//				String actualClassName = bmcpopup.getPharmacist().getText();
//
//				System.out.println(actualBoardName);
//				System.out.println(actualMediumName);
//				System.out.println(actualClassName);
//
//				Assert.assertEquals(actualBoardName, "IGOT-Health");
//				Assert.assertEquals(actualMediumName, "Gujarati");
//				Assert.assertEquals(actualClassName, "Pharmacist");
//
//				actual = "User able to able to edit BMC values successfully";
//				expectedValue = "True";
//			}
//
//		} finally {
//
//			Listeners.customAssert("True", expectedValue, expected, actual);
//
//		}
//	}
//
//	public static void ValidateBMCFilterValueAsPerOnBoarding() throws Exception {
//
//		userProfile guest = PageFactory.initElements(driver, userProfile.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//
//		VDNUtils.waitToBeVisibleAndClick(home.getTVClassesTab());
//		Thread.sleep(2000);
//		driver.switchTo().defaultContent();
//		Thread.sleep(1000);
//		String actualBoardName = bmcpopup.getBoardValue().getText();
//		String actualMediumName = bmcpopup.getMediumValue().getText();
//		String actualClassName = bmcpopup.getClassValue().getText();
//
//		Assert.assertEquals(actualBoardName, "CBSE/NCERT");
//		Assert.assertEquals(actualMediumName, "English");
//		Assert.assertEquals(actualClassName, "Class 2");
//
//		VDNUtils.waitToBeVisibleAndClick(home.getdigitalTextbookTab());
//		Thread.sleep(2000);
//		actualBoardName = bmcpopup.getBoardValue().getText();
//		actualMediumName = bmcpopup.getMediumValue().getText();
//		actualClassName = bmcpopup.getClassValue().getText();
//
//		Assert.assertEquals(actualBoardName, "CBSE/NCERT");
//		Assert.assertEquals(actualMediumName, "English");
//		Assert.assertEquals(actualClassName, "Class 2");
//	}
//
//	public static void ChangePreferenceAsCBSC() throws Exception {
//
//		userProfile guest = PageFactory.initElements(driver, userProfile.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//
//		VDNUtils.waitToBeVisibleAndClick(home.getHomeTab());
//		VDNUtils.waitToBeVisibleAndClick(home.getChnagePreferences());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
//		Thread.sleep(3000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getSelectPreferenceEngilsh());
//
//		Actions act = new Actions(driver);
//
//		act.moveByOffset(50, 100).click().build().perform();
//		Thread.sleep(1000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClass1());
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClass2());
//		act.moveByOffset(50, 100).click().build().perform();
//		Thread.sleep(1000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());
//
//	}
//
//	public static void ChangePreferenceAsOther() throws Exception {
//
//		userProfile guest = PageFactory.initElements(driver, userProfile.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//
//		VDNUtils.waitToBeVisibleAndClick(home.getHomeTab());
//		VDNUtils.waitToBeVisibleAndClick(home.getChnagePreferences());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getOther());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
//		Thread.sleep(1000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getSelectPreferenceEngilsh());
//
//		Actions act = new Actions(driver);
//		Robot rb = new Robot();
//
//		act.moveByOffset(50, 100).click().build().perform();
//		Thread.sleep(1000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClass1());
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClass2());
//		rb.keyPress(KeyEvent.VK_TAB);
//		Thread.sleep(1000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());
//
//	}
//
//	public static void VerifyTheUserShouldBeAbleToEditTheSubmittedDetailsOptionInProfile() throws Exception {
//
//		userProfile user = PageFactory.initElements(driver, userProfile.class);
//		Logout log = PageFactory.initElements(driver, Logout.class);
//		SubmitDetails sumbitdetails = PageFactory.initElements(driver, SubmitDetails.class);
//		Thread.sleep(1000);
//
//		String RequiredDetailsText = null;
//		String expected = "User Able To Edit Submit Details";
//		String actual = "Unable To Edit Submit Details ";
//
//		try {
//
//			VDNUtils.waitToBeClickableAndClick(user.headerDropdown());
//			VDNUtils.waitToBeClickableAndClick(user.getProfilebutton());
//
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			// js.executeScript("arguments[0].scrollIntoView(true);",user.getSubmitDetails());
//			js.executeScript("window.scrollBy(0, 500)");
//			Thread.sleep(2000);
//			sumbitdetails.getSubmitDetails().isDisplayed();
//			Thread.sleep(1000);
//			VDNUtils.waitToBeClickableAndClick(sumbitdetails.getSubmitDetails());
//			VDNUtils.waitToBeVisibleAndClick(sumbitdetails.getInstitutionTab());
//			VDNUtils.waitToBeClickableAndClick(sumbitdetails.getCbscTab());
//			VDNUtils.waitToBeClickableAndClick(sumbitdetails.getSubmitDetailCheckbox());
//			Thread.sleep(1000);
//			System.out.println(sumbitdetails.getSubmitDetailCheckbox());
//			sumbitdetails.getProfileSubmitbutton().isDisplayed();
//			Thread.sleep(2000);
//			js.executeScript("window.scrollTo(0, 0)");
//
//			RequiredDetailsText = sumbitdetails.getRequiredDetails().getText();
//			Thread.sleep(2000);
//			actual = "Edit Submit Details Successfully";
//
//		} finally {
//			String ValidateText = RequiredDetailsText != null ? RequiredDetailsText : "N/A";
//			System.out.println(ValidateText);
//			Listeners.customAssert("Required details", ValidateText, expected, actual);
//		}
//	}
//
//	public static void VerifyTheUserIsAbleToUpdateTheBMCAndLocationDetails() throws Exception {
//
//		userProfile user = PageFactory.initElements(driver, userProfile.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		Thread.sleep(1000);
//
//		VDNUtils.waitToBeClickableAndClick(user.headerDropdown());
//		VDNUtils.waitToBeClickableAndClick(user.getProfilebutton());
//		VDNUtils.waitToBeClickableAndClick(locationpopup.getLocationeditbutton());
//		VDNUtils.waitToBeVisibleAndClick(locationpopup.getRole());
//		VDNUtils.waitToBeClickableAndClick(locationpopup.getparent());
//		VDNUtils.waitToBeClickableAndClick(locationpopup.getState());
//		VDNUtils.waitToBeClickableAndClick(locationpopup.getAndhraPradesh());
//		VDNUtils.waitToBeClickableAndClick(locationpopup.getDistrict());
//		VDNUtils.waitToBeClickableAndClick(locationpopup.getDistrictAlluriSitaRamaRaju());
//		VDNUtils.waitToBeClickableAndClick(locationpopup.getLocationSubmitButton());
//		Thread.sleep(2000);
//
//		String actualRoleName = locationpopup.getTextParent().getText();
//		String actualDistrictName = locationpopup.getTextDistrict().getText();
//		String actualStateName = locationpopup.getTextAP().getText();
//
//		System.out.println(actualRoleName);
//		System.out.println(actualDistrictName);
//		System.out.println(actualStateName);
//
//		Assert.assertEquals(actualRoleName, "Parent");
//		Assert.assertEquals(actualDistrictName, "Alluri Sita Rama Raju");
//		Assert.assertEquals(actualStateName, "Andhra Pradesh");
//
//		Thread.sleep(2000);
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		// js.executeScript("arguments[0].scrollIntoView(true);",user.getBMCeditbutton());
//		js.executeScript("window.scrollBy(0, 500)");
//
//		// Library.custom_click(user.getBMCeditbutton(), "BMCeditbutton");
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getBMCeditbutton());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getBoard());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getMedium());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getHindi());
//		Actions act = new Actions(driver);
//		act.moveByOffset(50, 100).click().build().perform();
//		Thread.sleep(1000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getClasss());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getClass4());
//		act.moveByOffset(50, 100).click().build().perform();
//		Thread.sleep(1000);
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getBMCSubmit());
//		Thread.sleep(2000);
//		js.executeScript("window.scrollTo(0, 0)");
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(user.getBackButton());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeClickableAndClick(home.getHomeTab());
//		Thread.sleep(5000);
//		VDNUtils.waitToBeClickableAndClick(home.getChnagePreferences());
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBoard());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getCbsc());
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getMedium());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getEnglish());
//		act.moveByOffset(50, 100).click().build().perform();
//		Thread.sleep(1000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getClasss());
//		VDNUtils.waitToBeClickableAndClick(bmcpopup.getClass2());
//		act.moveByOffset(50, 100).click().build().perform();
//		Thread.sleep(1000);
//		VDNUtils.waitToBeVisibleAndClick(bmcpopup.getBMCSubmit());
//		Thread.sleep(2000);
//
//		String actualBoardName = bmcpopup.getTextCbsc().getText();
//		String actualMediumName = bmcpopup.getTextEnglish().getText();
//		String actualClassName = bmcpopup.getTextClass2().getText();
//
//		System.out.println(actualBoardName);
//		System.out.println(actualMediumName);
//		System.out.println(actualClassName);
////	        
////	        Assert.assertEquals(actualBoardName, "CBSE/NCERT");
////	        Assert.assertEquals(actualMediumName, "English");
////	        Assert.assertEquals(actualClassName, "Class 2"); 
////		  
////		 	 	 	 
//	}
//
//	public static void VerifyBMCUnderChangePreference() throws Exception {
//
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		BMCPopup bmcpopup = PageFactory.initElements(driver, BMCPopup.class);
//
//		String expected = "Verify user should be able to change preference successfully";
//		String actual = "User is unable to change preference";
//
//		String validateBMC = null;
//		boolean checkBMC = false;
//
//		try {
//
//			if (home.getHomeTab().isDisplayed()) {
//				checkBMC = true;
//
//				Thread.sleep(1000);
//				VDNUtils.waitToBeClickableAndClick(home.getHomeTab());
//				Thread.sleep(2000);
//				VDNUtils.waitToBeClickableAndClick(home.getChnagePreferences());
//				Thread.sleep(2000);
//				String actualBoardName = bmcpopup.getCbsccheck().getText();
//				String actualMediumName = bmcpopup.getEnglishcheck().getText();
//				String actualClassName = bmcpopup.getClass2check().getText();
//
//				Assert.assertEquals(actualBoardName, "CBSE");
//				Assert.assertEquals(actualMediumName, "English");
//				Assert.assertEquals(actualClassName, "Class 2");
//
//				actual = "user is be able to change preference successfully";
//				validateBMC = "True";
//			}
//
//		} finally {
//
//			Listeners.customAssert("True", validateBMC, expected, actual);
//
//		}
//
//	}
//
//	public static void VerifyUserShouldBeAbleToEditTheSubmittedDetails() throws Exception {
//
//		userProfile user = PageFactory.initElements(driver, userProfile.class);
//		UpdateProfile update = PageFactory.initElements(driver, UpdateProfile.class);
//		ValidatePopUp popup = PageFactory.initElements(driver, ValidatePopUp.class);
//
//		String updatedPopUp = null;
//		String expected = "User should Update Details Successfully";
//		String actual = "Unable to Update Details";
//		try {
//
//			VDNUtils.waitToBeClickableAndClick(user.headerDropdown());
//			VDNUtils.waitToBeClickableAndClick(user.getProfilebutton());
//			Thread.sleep(2000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0, 1200)");
//
//			// js.executeScript("arguments[0].scrollIntoView(true);",user.getBeforeUpdateButton());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(update.getBeforeUpdateButton());
//			VDNUtils.waitToBeClickableAndClick(update.getId());
//			update.getId().clear();
//			String Id = VDNUtils.set_Content_Name("Updated_");
//			VDNUtils.waitToBeClickableAndSendKeys(update.getId(), Id);
//			VDNUtils.waitToBeClickableAndClick(update.getAfterUpdateButton());
//			Thread.sleep(1000);
//			// js.executeScript("arguments[0].scrollIntoView(true);",update.getUpdateIdText());
//			// Thread.sleep(1000);
//
//			// String actualIdName =update.getUpdateIdText().getText();
//			// Assert.assertEquals(actualIdName, "Akash123");
//
//			updatedPopUp = popup.getUpdatedPopup().getText();
//			actual = "Update Details Successfully";
//		} finally {
//
//			String popupText = updatedPopUp != null ? updatedPopUp : "N/A";
//			System.out.println(popupText);
//			Listeners.customAssert("updated successfully", popupText, expected, actual);
//
//		}
//
//	}
//
//	public static void validateObservationTab() throws Exception {
//
//		String except = "User Should Able To See Observation Tab Successfully";
//		String actual = "User Should Not Able To See Observation Tab Successfully";
//		String Tab = null;
//
//		userProfile user = PageFactory.initElements(driver, userProfile.class);
//		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		LocationPopup locationpopup = PageFactory.initElements(driver, LocationPopup.class);
//		Thread.sleep(1000);
//
//		try {
//			VDNUtils.waitToBeClickableAndClick(user.headerDropdown());
//			VDNUtils.waitToBeClickableAndClick(user.getProfilebutton());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(locationpopup.getLocationeditbutton());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getRole());
//			VDNUtils.waitToBeClickableAndClick(locationpopup.getHTOfficial());
//			Thread.sleep(2000);
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getSubRole());
//			VDNUtils.waitToBeVisibleAndClick(locationpopup.getPrinciple());
//			Thread.sleep(2000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollTo(0, 1000)");
//			VDNUtils.waitToBeClickableAndClick(locationpopup.getPersonalDetailSubmitButton());
//			Thread.sleep(2000);
//
//			js.executeScript("window.scrollTo(0, 0)");
//			Thread.sleep(2000);
//			VDNUtils.waitToBeClickableAndClick(user.getBackButton());
//			Thread.sleep(2000);
//			Assert.assertTrue(home.getObservationTab().isDisplayed());
//
//			Tab = home.getObservationTab().getText();
//			actual = "User Successfully See Observation Tab ";
//		} finally {
//			String observationtab = Tab != null ? Tab : "N/A";
//			Listeners.customAssert("Observation", observationtab, except, actual);
//		}
//	}
//
//	public static String addManagedUser() throws Exception {
//
//		ManageUser adduser = PageFactory.initElements(driver, ManageUser.class);
//
//		VDNUtils.waitToBeClickableAndClick(adduser.getEnterName());
//		String name = VDNUtils.set_Content_Name("Abc_");
//		adduser.getEnterName().sendKeys(name);
//		VDNUtils.waitToBeClickableAndClick(adduser.getAddUserTab());
//		Thread.sleep(1000);
//		VDNUtils.waitToBeVisibleAndClick(adduser.getAddUserTab());
//
//		return name;
//	}
//
//	public static void CustodianUserIsAableToAddTheMUAUser() throws Exception {
//
//		userProfile user = PageFactory.initElements(driver, userProfile.class);
//
//		VDNUtils.waitToBeClickableAndClick(user.headerDropdown());
//		VDNUtils.waitToBeClickableAndClick(user.getAddAnotherUserTab());
//
//		for (int i = 0; i < 30; i++) {
//
//			UserOnBoarding.addManagedUser();
//		}
//
//	}
//
//	public static void validatelogout() throws Exception {
//		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
//		Logout log = PageFactory.initElements(driver, Logout.class);
//		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
//
//		VDNUtils.waitToBeClickableAndClick(Log.getHeaderDropdown());
//		Thread.sleep(1000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
//		VDNUtils.waitToBeClickableAndClick(log.getLogout());
//		Thread.sleep(2000);
//		VDNUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
//	}
//
//	public static void registerHerePage() throws Exception {
//
//		// ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
//		// Logout log = PageFactory.initElements(driver, Logout.class);
//		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		VDNUtils.waitToBeClickableAndClick(Log.getHeaderDropdown());
//		js.executeScript("arguments[0].scrollIntoView(true);", Log.getLogintab());
//		Library.custom_click(Log.getLogintab(), "logintab");
//		VDNUtils.waitToBeClickableAndClick(Log.getRegisterHereButton());
//
//	}
//
//	public static String fakerEmail() throws Exception {
//		ExcelDataProvider data = new ExcelDataProvider();
//		String randomFakeEmail = "diksa##@yopmail.com";
//		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
//		String email = fakeValuesService.bothify(randomFakeEmail);
////		data.updateData("TestData", email, "", "");
////		String readData = data.getExcelData(email, 1, 3);
////		System.out.println(readData);
//		return email;
//	}
//
//	public static void ragisterWithDikshaUsingAnyEmails() throws Exception {
//
////		CreateBatchForCourse createBatch = PageFactory.initElements(driver, CreateBatchForCourse.class);
//		// UserOnBoarding enterFullName = new UserOnBoarding();
////		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
////		Logout log = PageFactory.initElements(driver, Logout.class);
//
//		LoginAsCustodian Log = PageFactory.initElements(driver, LoginAsCustodian.class);
//		ExcelDataProvider emailPass = new ExcelDataProvider();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String year = "//div[contains(@role,'listbox')]//following::span";
//
////		DikshaUtils.waitToBeClickableAndClick(Log.getRegisterHereButton());
////		Thread.sleep(3000);
//		String emailId = UserOnBoarding.fakerEmail();
//		VDNUtils.waitToBeClickableAndClick(Log.getEnterFullNameInRegisterPage());
//		Thread.sleep(3000);
//		VDNUtils.waitToBeClickableAndSendKeys(Log.getEnterFullNameInRegisterPage(), emailId);
//		VDNUtils.waitToBeClickableAndClick(Log.getSelectYearDropdown());
//		VDNUtils.selectValueFromDropdown(driver, year, "1990");
//		VDNUtils.waitToBeClickableAndClick(Log.getContinueButton());
//		VDNUtils.waitToBeClickableAndClick(Log.getSubmitButton());
//		VDNUtils.waitToBeClickableAndClick(Log.getEmailRadioButton());
//		VDNUtils.waitToBeClickableAndSendKeys(Log.getEnterEmail(), emailId);
//		String data = emailPass.getExcelData("TestData", 362, 1);
//		System.out.println(data);
//		VDNUtils.waitToBeClickableAndSendKeys(Log.getSignUpPassWord(), data);
//		VDNUtils.waitToBeClickableAndSendKeys(Log.getSignUpReEnterPassWord(), data);
//		js.executeScript("arguments[0].scrollIntoView(true);", Log.getContinueButton());
//		VDNUtils.waitToBeClickableAndClick(Log.getContinueButton());
//		VDNUtils.waitToBeClickableAndClick(Log.getContinueButton());
//		Thread.sleep(3000);
//		String url = config.get_yopmail_test_data();
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		VDNUtils.waitWebDriver(3000);
//		driver.get(url);
//		VDNUtils.waitWebDriver(3000);
//		VDNUtils.waitToBeClickableAndSendKeys(Log.getEnterEmailToYopmail(), emailId);
//		VDNUtils.waitWebDriver(3000);
//		VDNUtils.waitToBeClickableAndClick(Log.getClickSearchInYopMail());
//		VDNUtils.waitWebDriver(3000);
//		VDNUtils.waitToBeClickableAndClick(Log.getRefreshButtonInYopmail());
//		VDNUtils.waitWebDriver(3000);
//		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
////		driver.switchTo().window(tabs.get(0));
////		DikshaUtils.waitWebDriver(3000);
////		driver.switchTo().window(tabs.get(1));
////		DikshaUtils.waitWebDriver(3000);
//		VDNUtils.waitToBeClickableAndClick(Log.getRefreshButtonInYopmail());
//		VDNUtils.waitWebDriver(3000);
//		driver.switchTo().frame(Log.getOtpFrame());
//		VDNUtils.waitWebDriver(3000);
//		String otpSent = Log.getEmailOtpSentence().getText();
//		System.out.println(otpSent);
//
//	}
//
//	public static void usePasswordForReportRequest(String user) throws Exception {
//		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
//
//		String cred[] = excel.getCredentails(user);
//		String password = cred[1];
//
//		 VDNUtils.waitToBeClickableAndSendKeys(loginpage.getEnterReportPassword(),
//		 password);
//		 VDNUtils.waitToBeClickableAndClick(loginpage.getReportRequestPassword());
//		Thread.sleep(2000);
//	}
//
//	public static void validateloginPopUpInGuestUse(String user) throws Exception {
//		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
//
//		VDNUtils.waitToBeClickableAndClick(loginpage.getvalidateLoginPopUpInGuestUser());
//
//		String cred[] = excel.getCredentails(user);
//		String username = cred[0];
//		String password = cred[1];
//
//		VDNUtils.waitToBeClickableAndSendKeys(loginpage.getUserName(), username);
//		VDNUtils.waitToBeClickableAndSendKeys(loginpage.getPassword(), password);
//		VDNUtils.waitToBeClickableAndClick(loginpage.getLogin());
//		Thread.sleep(2000);
//	}
//	
//	public static void logoutWithOutExploreTab() throws Exception {
//
//		 
//
//        ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
//        Logout log = PageFactory.initElements(driver, Logout.class);
//
// 
//
//        // DikshaUtils.waitToBeVisibleAndClick(log.getDigitaltextbooktab());
//        VDNUtils.waitToBeClickableAndClick(log.getCreatorIcon());
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", log.getLogout());
//        VDNUtils.waitToBeClickableAndClick(log.getLogout());
//        Thread.sleep(2000);
//        VDNUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
//    }
//	
//	
	public static void loginAsSourcing(String user) throws Exception {

		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home=null;
		String expect = "sourcing " + user + " should be able to login successfully";
		String actual = "Unable to login as sourcing" + user;

		try {
			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
			

//			DikshaUtils.waitToBeVisibleAndClick(loginpage.getHeaderDropdown());
//			DikshaUtils.waitToBeClickableAndClick(loginpage.getLogintab());

			String cred[] = excel.getCredentails(user);
			String username = cred[0];
			String password = cred[1];
			
			String AppendExplore = "/sourcing";
			
			driver.get(config.get_Env_Sourcing()+AppendExplore);
			
	        //driver.get("https://vdn.diksha.gov.in/" + AppendExplore);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			VDNUtils.waitToBeClickableAndSendKeys(loginpage.getUserName(), username);
			VDNUtils.waitToBeClickableAndSendKeys(loginpage.getPassword(), password);
			VDNUtils.waitToBeClickableAndClick(loginpage.getLogin());
			Thread.sleep(5000);
			driver.navigate().refresh();
			home=HomePage.getMyProjects().getText();
			actual = "sourcing "+ user + " is able to login successfully";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("My Projects", homeText, expect, actual);
		}
	}

	public static void loginAsContributor(String user) throws Exception {

		HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
		String home=null;
		String expect = user + " should be able to login successfully";
		String actual = "Unable to login as " + user;

		try {
			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

//			DikshaUtils.waitToBeVisibleAndClick(loginpage.getHeaderDropdown());
//			DikshaUtils.waitToBeClickableAndClick(loginpage.getLogintab());

			String cred[] = excel.getCredentails(user);
			String username = cred[0];
			String password = cred[1];
			
			String AppendExplore = "/contribute";
			
			driver.get(config.get_Env_Contribute()+AppendExplore);
			
	       // driver.get("https://vdn.diksha.gov.in/" + AppendExplore);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			VDNUtils.waitToBeClickableAndSendKeys(loginpage.getUserName(), username);
			VDNUtils.waitToBeClickableAndSendKeys(loginpage.getPassword(), password);
			VDNUtils.waitToBeClickableAndClick(loginpage.getLogin());
			Thread.sleep(5000);
			driver.navigate().refresh();
			 home=HomePage.getMyProjectTab().getText();
			actual = user + " is able to login successfully";
		} finally {
			String homeText = home != null ? home : "N/A";
			Listeners.customAssert("My Projects", homeText, expect, actual);
		}
	}
	
	public static void VDNlogout() throws Exception {
		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
		String Explorebutton = null;
//		String expect = user + " should be able to logout Successfully";
//		String actual = "Unable to logout";
		try {

			Logout log = PageFactory.initElements(driver, Logout.class);

			VDNUtils.waitToBeClickableAndClick(log.getUserProfile());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView(true);", log.getVdnLogout());
			VDNUtils.waitToBeClickableAndClick(log.getVdnLogout());
			Thread.sleep(2000);
//			Explorebutton = explore.getExplorebutton().getText();
//			DikshaUtils.waitToBeVisibleAndClick(explore.getExplorebutton());
//			actual = user + " is able to logout Successfully";
		} finally {
//			String ExplorebuttonText = Explorebutton != null ? Explorebutton : "N/A";
//			Listeners.customAssert("EXPLORE DIKSHA", ExplorebuttonText, expect, actual);

		}

	}
	
	
	
	//
	
}
