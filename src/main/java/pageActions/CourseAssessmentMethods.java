package pageActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pageObject.CourseAssesment;
import pageObject.ResourcesPom;
import pageObject.UploadPdfContent;
import utility.BaseClass;
import utility.VDNUtils;
import utility.Library;
import utility.Listeners;
import utility.VDNUtils;

public class CourseAssessmentMethods extends BaseClass {

	public static String createAssessmentWithAllTypeContent() throws InterruptedException, Exception {
		
		CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		
		VDNUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
		VDNUtils.waitToBeClickableAndClick(Upload.getWorkspace());
		VDNUtils.waitToBeClickableAndClick(assesment.getCourseAssesmentTab());
		String randomName=VDNUtils.set_Content_Name("CourseAssessment_");
		excel.updateData("TestData","CourseAssessment" ,randomName, "");
		VDNUtils.waitToBeClickableAndSendKeys(assesment.getNameTextField(), randomName);
		VDNUtils.waitToBeClickableAndSendKeys(assesment.getMaxAttemptTextField(), "3");
		VDNUtils.waitToBeVisibleAndClick(assesment.getStartCreatingButton());
		Thread.sleep(8000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		VDNUtils.waitToBeClickableAndClick(assesment.getAddTextbutton());
		VDNUtils.waitToBeVisibleAndClick(assesment.getAddTextbutton());
		VDNUtils.waitToBeClickableAndSendKeys(assesment.getTextareaTextfield(), "Done Via Automation");
		VDNUtils.waitToBeClickableAndClick(assesment.getDonebutton());
		
		VDNUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
		VDNUtils.waitToBeClickableAndClick(assesment.getAddShapebutton());
		VDNUtils.waitToBeClickableAndClick(assesment.getAddingTriangleShape());
		
		VDNUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
		VDNUtils.waitToBeClickableAndClick(assesment.getAddVideoButton());
		VDNUtils.waitToBeClickableAndClick(assesment.getselectVideoFromVideoList());
		VDNUtils.waitToBeClickableAndClick(assesment.getSelectvideoButton());
		
		VDNUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
		VDNUtils.waitToBeClickableAndClick(assesment.getAddImagebutton());
		VDNUtils.waitToBeClickableAndClick(Upload.getClickOnAllImage());
		VDNUtils.waitToBeClickableAndClick(Upload.getSelectImageFromAllImage());
		VDNUtils.waitToBeClickableAndClick(Upload.getSelectButton());
	    
		VDNUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
		VDNUtils.waitToBeClickableAndClick(assesment.getAddaudiobutton());
		VDNUtils.waitToBeClickableAndClick(assesment.getAllAudiobutton());
		VDNUtils.waitToBeClickableAndClick(assesment.getSelectaudiofromlist());
	    VDNUtils.waitToBeClickableAndClick(assesment.getSelectaudioButton());
	    
	    VDNUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
	    VDNUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
	    VDNUtils.waitToBeClickableAndClick(assesment.getSelectQuestionCheckBox1());
	    VDNUtils.waitToBeClickableAndClick(assesment.getNextButton());
	    VDNUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(),"QA Questions");
	    VDNUtils.waitToBeClickableAndClick(assesment.getAddButton());
	    
	    VDNUtils.waitToBeClickableAndClick(assesment.getAddSlideButton());
	    VDNUtils.waitToBeClickableAndClick(assesment.getAddActivityButton());
	    VDNUtils.waitToBeClickableAndClick(assesment.getAddtimeAndClockButton());
	    
	    VDNUtils.waitToBeClickableAndClick(Upload.getSave());
	    VDNUtils.waitToBeClickableAndClick(Upload.getClose());
	   
	    return randomName;
	    
	}
	
	public static String createAssessmentWithQuestion() throws InterruptedException, Exception {
		ResourcesPom rs=PageFactory.initElements(driver, ResourcesPom.class);	
		CourseAssesment assesment=PageFactory.initElements(driver, CourseAssesment.class);
		UploadPdfContent Upload=PageFactory.initElements(driver, UploadPdfContent.class);
		
		String expect = "Creator should able to create course assessment successfully";
		String actual = "Creator is unable to create course assessment ";
		String closeButton=null;
	 
	 try {
		VDNUtils.waitToBeClickableAndClick(Upload.getHeaderDropdown());
		VDNUtils.waitToBeClickableAndClick(Upload.getWorkspace());
		VDNUtils.waitToBeClickableAndClick(assesment.getCourseAssesmentTab());
		String randomName=VDNUtils.set_Content_Name("CourseAssessment_");
		excel.updateData("TestData","CourseAssessment" ,randomName, "");
		VDNUtils.waitToBeClickableAndSendKeys(assesment.getNameTextField(), randomName);
		VDNUtils.waitToBeClickableAndSendKeys(assesment.getMaxAttemptTextField(), "3");
		VDNUtils.waitToBeVisibleAndClick(assesment.getStartCreatingButton());
		Thread.sleep(8000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		VDNUtils.waitToBeClickableAndClick(assesment.getAddQuestionSetButton());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(rs.getCreateQuestionButton());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(rs.getSelectMCQButton());
		Thread.sleep(2000);
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]"));
		driver.switchTo().frame(iframe1);
	
		Thread.sleep(2000);
		VDNUtils.waitToBeClickableAndClick(rs.getEnterTheQuestionTextfield());
		VDNUtils.waitToBeClickableAndSendKeys(rs.getEnterTheQuestionTextfield(),"Capital of India");
	
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@class='iziModal-iframe']"));
		driver.switchTo().frame(iframe2);
		
		
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", rs.getTickCorrectAnswer());
		
		
		VDNUtils.waitToBeClickableAndClick(rs.getTickCorrectAnswer());
		
		VDNUtils.waitToBeClickableAndClick(rs.getAnswerNo1Textfield());
		VDNUtils.waitToBeClickableAndSendKeys(rs.getAnswerNo1Textfield(),"Delhi");
		
		VDNUtils.waitToBeClickableAndClick(rs.getAnswerNo2Textfield());
		VDNUtils.waitToBeClickableAndSendKeys(rs.getAnswerNo2Textfield(),"Mumbai");
		VDNUtils.waitToBeClickableAndClick(rs.getNextButton());
	
		VDNUtils.waitToBeClickableAndClick(rs.getSelectBoardSyllabus());
		VDNUtils.waitToBeClickableAndClick(rs.getBoardSelected());
		VDNUtils.waitToBeClickableAndClick(rs.getSelectMedium());
		VDNUtils.waitToBeClickableAndClick(rs.getMediumSelected());
		VDNUtils.waitToBeClickableAndClick(rs.getSelectGrade());
		Thread.sleep(1000);
		VDNUtils.waitToBeClickableAndClick(rs.getGradeSelected());
		VDNUtils.waitToBeClickableAndClick(rs.getSelectSubject());
		VDNUtils.waitToBeClickableAndClick(rs.getSubjectSelected());
		VDNUtils.waitToBeClickableAndClick(rs.getSelectLevel());
		VDNUtils.waitToBeClickableAndClick(rs.getLevelSelected());
		VDNUtils.waitToBeClickableAndClick(rs.getSaveAndCreateButton());
		VDNUtils.waitToBeClickableAndClick(rs.getCancelButton());
		VDNUtils.waitToBeClickableAndClick(rs.getNextButtonAfterClickingCheckbox());
		
		VDNUtils.waitToBeClickableAndSendKeys(assesment.getQuestionSetTitleTextfield(),"QA Questions");
	    VDNUtils.waitToBeClickableAndClick(assesment.getAddButton());
	  
	    VDNUtils.waitToBeClickableAndClick(Upload.getSave());
	    VDNUtils.waitToBeClickableAndClick(Upload.getClose());
	    closeButton=Upload.getClose().getText();
	    actual="Creator is able to create course assessment successfully";
		return randomName;
		
	 } finally {
		 String Text = Upload.getClose() != null ? closeButton : "N/A";
			Listeners.customAssert(closeButton, Text, expect, actual);
	}
	} 
	}