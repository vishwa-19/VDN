
package utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners extends BaseClass implements ITestListener{
    ExtentTest test;
	ExtentReports  extent=ExtendReportGenerator.getReport();
	public static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	public static String expectedResult1;
	public static String actualResult1;
	
	
	
	public void onTestStart(ITestResult result) {
	
		Library.test=extent.createTest("Test Script name - "+result.getMethod().getMethodName());
		extenttest.set(Library.test);
	}

	public void onTestSuccess(ITestResult result) {

		extenttest.get().addScreenCaptureFromBase64String(getScreenshots());
		
	}


	
	public void onTestFailure(ITestResult result) {
	    
	    Throwable throwable = result.getThrowable();
	    StringWriter stringWriter = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(stringWriter);
	    throwable.printStackTrace(printWriter);
	    String exceptionStackTrace = stringWriter.toString();
	    String linkCode = "<a class=\"button\" href=\"exception_details.html?exception=" + encodeURLParameter(exceptionStackTrace) + "\" target=\"_blank\">ERROR</a>";
	    extenttest.get().log(Status.FAIL, expectedResult1, actualResult1, MarkupHelper.createLabel(linkCode, ExtentColor.RED));
	    extenttest.get().addScreenCaptureFromBase64String(getScreenshots());
	    
	}
	
	private String encodeURLParameter(String parameter) {
	    try {
	        return URLEncoder.encode(parameter, StandardCharsets.UTF_8.toString())
	                .replaceAll("\\+", "%20")
	                .replaceAll("\\%21", "!")
	                .replaceAll("\\%27", "'")
	                .replaceAll("\\%28", "(")
	                .replaceAll("\\%29", ")")
	                .replaceAll("\\%7E", "~");
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return "";
	    }
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

	public static String getScreenshots() {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
			
	} 
	
	public static void customAssert(String expected, String actual, String expectedResult, String actualResult) {
		
		expectedResult1 = expectedResult;
		actualResult1 = actualResult;
		
		
		if(actual.equalsIgnoreCase(expected)) {
			Date currentTime = new Date();
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			String reportTime = timeFormat.format(currentTime);
			String formattedTime = reportTime.replace(":", ".");
			extenttest.get().log(Status.PASS,expectedResult, actualResult, formattedTime);
			//Assert.assertEquals(actual, expected);
		}
		
		
		
	}
	
	

}