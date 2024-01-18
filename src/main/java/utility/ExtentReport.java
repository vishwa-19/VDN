package utility;

 

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

 

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

 

public class ExtentReport {

 

// public static ExtentReports extent;

// public static ExtentReports getReport(){

//

// String path=System.getProperty("user.dir")+"\\Reports";

//

// ExtentSparkReporter reporter=new ExtentSparkReporter(path);

// reporter.config().setDocumentTitle("Diksha Automation Test Report");

// reporter.config().setReportName("Automation Test Report");

// reporter.config().setTheme(Theme.DARK);

//

// extent=new ExtentReports();

// extent.attachReporter(reporter);

// extent.setSystemInfo("Project Name","Diksha");

// extent.setSystemInfo("O.S", "Windows");

//

//

// return extent;

// }

 

private static ExtentReports extent;

private static ExtentTest test;

 

public static void initializeReport() throws IOException {

// Create an extent report instance

 

String reportPath=System.getProperty("user.dir")+"\\Reports\\";

 

Date currentDate = new Date();

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

String formattedDate = dateFormat.format(currentDate);

Date currentTime = new Date();

SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

String formattedTime = timeFormat.format(currentTime);

 

ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath+"Extentreport_"+formattedDate+"_"+formattedTime+".html");

extent = new ExtentReports();

extent.attachReporter(htmlReporter);

htmlReporter.config().setDocumentTitle("Automation Report");

final File CONF = new File("config/extent-config.xml");

htmlReporter.loadXMLConfig(CONF);

}

 

public static void createTest(String testName) {

// Create a test with the given name

test = extent.createTest(testName);

}

 

public static void logInfo(String message) {

// Log an informational message

test.info(message);

}

 

public static void logPass(String message) {

// Log a passed status with a message

test.pass(message);

}

 

public static void logFail(String message) {

// Log a failed status with a message

test.fail(message);

}

 

public static void logSkip(String message) {

// Log a skipped status with a message

test.skip(message);

}

 

// public static void logCustomTable(MyCustomLog customLog) {

// // Create a custom log table and log it

// String customLogTable = MarkupHelper.toTable(customLog, "table-sm").getMarkup();

// test.log(Status.INFO, customLogTable);

// }

 

public static void flushReport() {

// Flush the report and close it

extent.flush();

}

 

}