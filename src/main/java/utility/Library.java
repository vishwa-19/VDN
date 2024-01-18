package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import pageObject.BMCPopup;


public class Library  {
 
	static ExtentTest test;
	public static WebDriver driver;

     	public static void custom_click(WebElement element,String Fieldname) {
    	 
    	
    		   element.click();
    	//	   test.log(Status.PASS, " Succesfully Clicked On "+ Fieldname);
    	
     }
     
     	public static void custom_sendkeys(WebElement element,String value,String fieldname) {
    	 
    	 
    		   element.sendKeys(value);
    	//	   test.log(Status.PASS, value + "Value Succesfully send "+ fieldname );
    		    
 }
 

    		    
     	public  static void assert_Is_Displayed(WebElement element,String fieldname) {
     		
			 if(element.isDisplayed()) {
		//		 test.log(Status.PASS, " Succesfully Clicked On "+ fieldname);
			 }else {
	    	//	 test.log(Status.FAIL,"not able to Clicked On "+ fieldname );
			 }	  
	}
 
    		   
}
 

 

 
 
 
 
 
 

