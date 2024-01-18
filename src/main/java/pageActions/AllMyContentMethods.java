//package pageActions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//
//import io.reactivex.rxjava3.core.Notification;
//import pageObject.AllMyContentBucket;
//import pageObject.CourseCreation;
//import pageObject.FiltersInDiffrentTabs;
//import pageObject.HomePage;
//import pageObject.UserNotification;
//import pageObject.userProfile;
//import utility.BaseClass;
//import utility.VDNUtils;
//import utility.Listeners;
//
//public class AllMyContentMethods extends BaseClass {
//
//public static void searchContent(String value) {
//		
//
//	CourseCreation content = PageFactory.initElements(driver, CourseCreation.class);
//	AllMyContentBucket allContent = PageFactory.initElements(driver, AllMyContentBucket.class);
//	String searchedContent = null;
//	String expect = "Creator should be able to search the Content Sucessfully";
//	String actual = "Creator is unable to  able to search the Content";
//	try {
//		VDNUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
//		VDNUtils.waitToBeClickableAndClick(content.getWorkspace());
//		VDNUtils.waitToBeClickableAndClick(allContent.getAllMyContentTab());
//
//		VDNUtils.waitToBeClickableAndSendKeys(allContent.getSearchContentTextfield(), value);
//		VDNUtils.waitToBeClickableAndClick(allContent.getSearchButton());
//
//		Assert.assertTrue(allContent.getSearchedContent().isDisplayed());
//		searchedContent = allContent.getSearchedContent().getText();
//
//		actual = "Creator is able to search the Content Sucessfully";
//	} finally {
//
//		String popupText = searchedContent != null ? searchedContent : "N/A";
//		Listeners.customAssert(searchedContent, popupText, expect, actual);
//	}
//
//}
//
//	
//	public static void CourseUnderMyLearningSection(String coursename) throws Exception {
//
//		 
//
//	    FiltersInDiffrentTabs filter=PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
//	    CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
//	    
//	    VDNUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
//	    VDNUtils.waitToBeClickableAndClick(filter.getProfile());
//       Thread.sleep(1000);
//       JavascriptExecutor js=(JavascriptExecutor)driver;
//	   js.executeScript("window.scrollBy(0, 1000)");
//	   Thread.sleep(1000);
//	   VDNUtils.waitToBeClickableAndClick(filter.getViewMore());
//	   js.executeScript("window.scrollBy(0, 1500)");
//	   
//	     String dynamicValue = coursename;
//         String xpath = String.format("//a[text()='%s']", dynamicValue);
//         WebElement element = driver.findElement(By.xpath(xpath));
//         Thread.sleep(2000);
//
//	    Assert.assertTrue(element.isDisplayed());
//
//	        
//
//	    }
//	public static void VerifyCourseUnderRecentlyPublishedCourse(String coursename) throws Exception {
//
//		  FiltersInDiffrentTabs filter=PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
//		   HomePage home=PageFactory.initElements(driver, HomePage.class);
//	   
//	    Thread.sleep(1000);
//	    VDNUtils.waitToBeClickableAndClick(home.getCourseTab());
//	    Thread.sleep(1000);
//        VDNUtils.waitToBeClickableAndClick(home.getHomeTab());
//       Thread.sleep(1000);
//       JavascriptExecutor js=(JavascriptExecutor)driver;
//	   js.executeScript("window.scrollBy(0, 1200)");
//	   Thread.sleep(3000);
//	   VDNUtils.waitToBeClickableAndClick(filter.getViewAllButton());
//	   Thread.sleep(1000);
//	    String dynamicValue = coursename;
//         String xpath = String.format("//bdi[text()='%s']", dynamicValue);
//         WebElement element = driver.findElement(By.xpath(xpath));
//         Thread.sleep(2000);
//
//	    Assert.assertTrue(element.isDisplayed());
//
//	        
//
//	    }
//	public static void VerifyCourseStatusIsOngoingUnderMyLearningSection(String coursename) throws Exception {
//
//		  FiltersInDiffrentTabs filter=PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
//		   HomePage home=PageFactory.initElements(driver, HomePage.class);
//		   CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
//		    
//		   Thread.sleep(2000);
//		   VDNUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
//		    VDNUtils.waitToBeClickableAndClick(filter.getProfile());
//	       Thread.sleep(1000);
//	       JavascriptExecutor js=(JavascriptExecutor)driver;
//		   js.executeScript("window.scrollBy(0, 1000)");
//		   Thread.sleep(1000);
//		   VDNUtils.waitToBeClickableAndClick(filter.getViewMore());
//		   js.executeScript("window.scrollBy(0, 1500)");
//		   
//		   
//	    String dynamicValue = coursename;
//       String xpath = String.format("//a[text()='%s']", dynamicValue);
//      
//       
//       WebElement element = driver.findElement(By.xpath(xpath));
//       Thread.sleep(2000);
//       
//       System.out.println(element.getText());
//	    Assert.assertTrue(element.isDisplayed());
//	    String  status= String.format("//a[text()='%s']/../../div[4]", dynamicValue);
//	    
//	    WebElement element1 = driver.findElement(By.xpath(status));
//	       Thread.sleep(2000);
//	      System.out.println(element1.getText());
//	     String  StatusIsOngoing =element1.getText();
//	 //     Assert.assertEquals(StatusIsOngoing, "Ongoing");
//	       Thread.sleep(1000);
//	       
//	       js.executeScript("window.scrollTo(0, 0)");
//	    }
//	public static void VerifyCourseStatusIsCompletedUnderMyLearningSection(String coursename) throws Exception {
//
//		  FiltersInDiffrentTabs filter=PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
//		   HomePage home=PageFactory.initElements(driver, HomePage.class);
//		   CourseCreation content=PageFactory.initElements(driver, CourseCreation.class);
//		    
//		   Thread.sleep(2000);
//		   VDNUtils.waitToBeClickableAndClick(content.getHeaderDropdown());
//		    VDNUtils.waitToBeClickableAndClick(filter.getProfile());
//	       Thread.sleep(1000);
//	       JavascriptExecutor js=(JavascriptExecutor)driver;
//		   js.executeScript("window.scrollBy(0, 1000)");
//		   Thread.sleep(1000);
//		   VDNUtils.waitToBeClickableAndClick(filter.getViewMore());
//		   js.executeScript("window.scrollBy(0, 1500)");
//		   
//		   
//	    String dynamicValue = coursename;
//     String xpath = String.format("//a[text()='%s']", dynamicValue);
//    
//     
//     WebElement element = driver.findElement(By.xpath(xpath));
//     Thread.sleep(2000);
//     
//     System.out.println(element.getText());
//	    Assert.assertTrue(element.isDisplayed());
//	    String  status= String.format("//a[text()='%s']/../../div[4]", dynamicValue);
//	    
//	    WebElement element1 = driver.findElement(By.xpath(status));
//	       Thread.sleep(2000);
//	     System.out.println(element1.getText());
//	     
//	   //  String  StatusIsCompleted =element1.getText();
//	    //  Assert.assertEquals(StatusIsCompleted, "Ongoing");
//	       Thread.sleep(1000);
//	       
//	       js.executeScript("window.scrollTo(0, 0)");
//	    }
//
//
//	public static void myCourseSection() throws Exception {
//
//		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
//		String courseSection = null;
//		String expect = "Custodian user should be able to see the course under my courses section Sucessfully";
//		String actual = "Custodian user is unable to see the course under my courses section";
//		try {
//		
//		VDNUtils.waitToBeClickableAndClick(filter.getCoursesTab());
//		Thread.sleep(1000);
//		Assert.assertTrue(filter.getMyCourseSection().isDisplayed());
//		courseSection=filter.getMyCourseSection().getText();
//		actual = "Custodian user is able to see the course under my courses section Sucessfully";
//
//		} finally {
//			String Text =courseSection != null ? courseSection : "N/A";
//			Listeners.customAssert(courseSection, Text, expect, actual);
//		}
//	}
//
//	public static void CourseUnderMyCoursesSection(String coursename) throws Exception {
//
//
//		FiltersInDiffrentTabs filter = PageFactory.initElements(driver, FiltersInDiffrentTabs.class);
//		
//		String course = null;
//		String expect = "Custodian user should be able to see the course under my courses section Sucessfully";
//		String actual = "Custodian user is unable to see the course under my courses section";
//		try {
//		VDNUtils.waitToBeClickableAndClick(filter.getCoursesTab());
//		Thread.sleep(1000);
//		Assert.assertTrue(filter.getMyCourseSection().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(filter.getViewAllButton());
//		String dynamicValue = coursename;
//		String xpath = String.format("//bdi[text()='%s']", dynamicValue);
//		WebElement element = driver.findElement(By.xpath(xpath));
//		Thread.sleep(1000);
//		Assert.assertTrue(element.isDisplayed());
//		course = element.getText();
//		actual = "Custodian user is able to see the course under my courses section Sucessfully";
//
//	} finally {
//		String Text =course != null ? course : "N/A";
//		Listeners.customAssert(course, Text, expect, actual);
//	}
//	}
//
//	public static void verifyUserSeeNotificationInBellIcon() throws Exception {
//		UserNotification notify = PageFactory.initElements(driver, UserNotification.class);
//		String Clearnotification = null;
//		String expect = "Custodian user should be able to see notification in Bell icon Sucessfully";
//		String actual = "Custodian user is unable to see notification in Bell icon ";
//		try {
//			Thread.sleep(1000);
//			Assert.assertTrue(notify.getBellIcon().isDisplayed());
//			Assert.assertTrue(notify.getNotificationCount().isDisplayed());
//			VDNUtils.waitToBeClickableAndClick(notify.getBellIcon());
//			Assert.assertTrue(notify.getNewNotificationsText().isDisplayed());
//			
//			Clearnotification = notify.getClearNotificationButton().getText();
//			actual = "Custodian user is able to see notification in Bell icon Sucessfully";
//
//		} finally {
//			String Text =Clearnotification != null ? Clearnotification : "N/A";
//			Listeners.customAssert("Clear", Text, expect, actual);
//		}
//	}
//
//	public static void verifySeeMoreOptionInNotification() throws Exception {
//
//UserNotification notify = PageFactory.initElements(driver, UserNotification.class);
//		
//		String expect = "Custodian user should be able to see SeeMore notification Sucessfully";
//		String actual = "Custodian user is unable to  see SeeMore notification";
//		String Clearnotification=null;
//		try {
//		Thread.sleep(1000);
//		Assert.assertTrue(notify.getBellIcon().isDisplayed());
//		Assert.assertTrue(notify.getNotificationCount().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(notify.getBellIcon());
//		Assert.assertTrue(notify.getNewNotificationsText().isDisplayed());
//		Assert.assertTrue(notify.getSeeMoreButton().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(notify.getSeeMoreButton());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 50)");
//		Clearnotification =notify.getClearNotificationButton().getText();
//	    actual = "Custodian user is able to see SeeMore notification Sucessfully";
//		} finally {
//			String Text =Clearnotification != null ? Clearnotification : "N/A";
//			Listeners.customAssert("Clear", Text, expect, actual);
//		} 
//		
//	}
//
//	public static void verifyUserAbleToDeleteNotification() throws Exception {
//
//		UserNotification notify = PageFactory.initElements(driver, UserNotification.class);
//		String expect = "Custodian user should be able to delete notification in Bell icon Sucessfully";
//		String actual = "Custodian user is unable to delete notification in Bell icon ";
//		String notificationIcon=null;
//		try {
//			Thread.sleep(1000);
//			Assert.assertTrue(notify.getBellIcon().isDisplayed());
//			Assert.assertTrue(notify.getNotificationCount().isDisplayed());
//			VDNUtils.waitToBeClickableAndClick(notify.getBellIcon());
//			Assert.assertTrue(notify.getNewNotificationsText().isDisplayed());
//			VDNUtils.waitToBeClickableAndClick(notify.getDeleteNotificationIcon());
//			notificationIcon = notify.getClearNotificationButton().getText();
//			actual = "Custodian user is able to delete notification in Bell icon Sucessfully";
//
//		} finally {
//			String Text =notificationIcon != null ? notificationIcon : "N/A";
//			Listeners.customAssert("Clear", Text, expect, actual);
//		}
//	}
//
//	public static void verifyUserAbleToClearAllNotification() throws Exception {
//
//		UserNotification notify = PageFactory.initElements(driver, UserNotification.class);
//		String expect = "Custodian user should be able to clear all notification in Bell icon Sucessfully";
//		String actual = "Custodian user is unable to clear all notification in Bell icon ";
//		String Clearnotification=null;
//		try {
//		Thread.sleep(1000);
//		Assert.assertTrue(notify.getBellIcon().isDisplayed());
//		Assert.assertTrue(notify.getNotificationCount().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(notify.getBellIcon());
//		Assert.assertTrue(notify.getNewNotificationsText().isDisplayed());
//		Clearnotification = notify.getClearNotificationButton().getText();
//
//		VDNUtils.waitToBeClickableAndClick(notify.getClearNotificationButton());
//		actual = "Custodian user is able to clear all notification in Bell icon Sucessfully";
//
//	} finally {
//		String Text = Clearnotification != null ? Clearnotification : "N/A";
//		Listeners.customAssert("Clear", Text, expect, actual);
//	}
//	}
//
//	public static void verifySeeLessOptionInNotification() throws Exception {
//
//
//		UserNotification notify = PageFactory.initElements(driver, UserNotification.class);
//		String expect = "Custodian user should be able to see SeeMore notification Sucessfully";
//		String actual = "Custodian user is unable to  see SeeMore notification";
//		String Clearnotification=null;
//		try {
//		Thread.sleep(1000);
//		Assert.assertTrue(notify.getBellIcon().isDisplayed());
//		Assert.assertTrue(notify.getNotificationCount().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(notify.getBellIcon());
//		Assert.assertTrue(notify.getNewNotificationsText().isDisplayed());
//		Assert.assertTrue(notify.getSeeMoreButton().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(notify.getSeeMoreButton());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 50)");
//		Assert.assertTrue(notify.getSeeLessButton().isDisplayed());
//		VDNUtils.waitToBeClickableAndClick(notify.getSeeLessButton());
//		js.executeScript("window.scrollBy(0, 0)");
//		Clearnotification = notify.getClearNotificationButton().getText();
//		actual = "Custodian user is able to see SeeMore notification Sucessfully";
//
//	} finally {
//		String Text =Clearnotification != null ? Clearnotification : "N/A";
//		Listeners.customAssert("Clear", Text, expect, actual);
//	}
//	}
//	public static void VerifyLearnerPassbookSection() throws Exception {
//
//		userProfile usp = PageFactory.initElements(driver, userProfile.class);
//		
//		String expect = "Custodian user should be able to see SeeMore notification Sucessfully";
//		String actual = "Custodian user is unable to  see SeeMore notification";
//		String learnerPassbookSection=null;
//		try {
//		Thread.sleep(1000);
//		VDNUtils.waitToBeClickableAndClick(usp.headerDropdown());
//		VDNUtils.waitToBeClickableAndClick(usp.getProfilebutton());
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 1100)");
//		Thread.sleep(1000);
//		Assert.assertTrue(usp.getlearnerPassBookSection().isDisplayed());
//		learnerPassbookSection=usp.getlearnerPassBookSection().getText();
//		actual = "Custodian user is able to see SeeMore notification Sucessfully";
//
//		} finally {
//			String Text =learnerPassbookSection != null ? learnerPassbookSection : "N/A";
//			Listeners.customAssert(learnerPassbookSection, Text, expect, actual);
//		}
//	}
//	public static void verifyNotificationForGuestUser() throws Exception {
//
//		UserNotification notify = PageFactory.initElements(driver, UserNotification.class);
//		
//		String Icon = null;
//		String expect = "Guest user should not be able to see Bell icon Sucessfully";
//		String actual = "Guest user is able to see Bell icon ";
//		try {
//		
//		Thread.sleep(1000);
//		 boolean bellIcon = notify.getBellIcon().isDisplayed();
//		Assert.assertTrue((bellIcon));
//		actual = "Guest user is not able to see Bell icon Sucessfully";
//
//	} finally {
//		String Text =Icon != null ? Icon : "N/A";
//		Listeners.customAssert(Icon, Text, expect, actual);
//	}
//	}
//}
