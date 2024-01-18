package utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.ExplorePage;
import pageObject.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	public static ConfigDataProvider config;
	public static ExcelDataProvider excel;
	public static WebDriverWait wait;
	public static ExtendReportGenerator reporter;

	@BeforeClass
	public void BS() throws Exception {

		config = new ConfigDataProvider();
		excel = new ExcelDataProvider();

	}

	@BeforeMethod
	public void Open() {

		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C://Users//Qualitrix//Downloads//chromedriver-win64 (1)//chromedriver-win64//chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get(config.get_Env());
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		ExplorePage explore = PageFactory.initElements(driver, ExplorePage.class);
//		DikshaUtils.waitToBeClickableAndClick(explore.getExplorebutton());

	}

	//@AfterMethod
	public void Close() {
		driver.quit();

	}

}
