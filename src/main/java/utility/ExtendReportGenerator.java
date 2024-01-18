package utility;

 

import java.text.SimpleDateFormat;
import java.util.Date;

 

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

 

public class ExtendReportGenerator {

    public static ExtentReports extent;
    public static ExtentReports getReport(){

        String path=System.getProperty("user.dir")+"/Reports/";

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = dateFormat.format(currentDate);
        Date currentTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String reportTime = timeFormat.format(currentTime);
        String formattedTime = reportTime.replace(":", "-");

        ExtentSparkReporter reporter=new ExtentSparkReporter(path+"DIKSHA Automation Report "+formattedDate+"_"+formattedTime+".html");
        reporter.config().setDocumentTitle("Diksha Automation Test Report");
        reporter.config().setReportName("DIKSHA Automation Report");
        reporter.config().setTheme(Theme.STANDARD);

         extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Project Name","Diksha");
        extent.setSystemInfo("O.S", "Windows");


        return extent;
    }

 

}