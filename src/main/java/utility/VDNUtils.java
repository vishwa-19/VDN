package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import pageObject.BMCPopup;

public class VDNUtils extends BaseClass {

	public static String generate_Do_id() {

		String currentUrl = driver.getCurrentUrl();
		String do_id = "do_";

		int startIndex = currentUrl.indexOf(do_id);
		String parsedString = currentUrl.substring(startIndex);

		String end_id = "/";
		int endIndex = parsedString.indexOf(end_id);

		endIndex = startIndex + endIndex;

		String DO_ID = currentUrl.substring(startIndex, endIndex);

		return DO_ID;

	}

	public static String set_Content_Name(String type) {

		String content_name = type + RandomStringUtils.randomAlphabetic(6);

		return content_name;
	}

	public static void pdf_page_Count() {

		String pdfFilePath = "System.getProperty(\"user.dir\")+\"\\src\\main\\resources\\pdf_13.pdf\")";

		try {
			// Load the PDF document
			PDDocument document = PDDocument.load(new File(pdfFilePath));

			// Get the number of pages in the PDF
			int pageCount = document.getNumberOfPages();

			// Print the number of pages
			System.out.println("Number of Pages: " + pageCount);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static WebElement waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitToBeVisibleAndClick(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

	}

//	public static void waitToBeClickableAndClick(WebElement element) {
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		element.click();
//
//	}
	
//	public static void waitToBeClickableAndClick(WebElement element) {
//
//		 
//
//        String elementValue = generateXpathString(element);
//
// 
//
//        // created a while loop to wait until the element is present on the screen
//
////        while (driver.findElements(By.xpath(elementValue)).size() == 0) 
//          for(int i=0;i<=5;i++){
//
// 
//
//            // System.out.println("element size is
//
//            // "+driver.findElements(By.xpath(elementValue)).size()) ;
//
//            Date currentTime = new Date();
//
//            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//
//            String currTime = timeFormat.format(currentTime);
//
//            System.out.println(currTime);
//
// 
//
//            explicitCustomWait();
//
//            if (!(driver.findElements(By.xpath(elementValue)).size() == 0)) {
//
//                // System.out.println("element found in while loop
//
//                // "+driver.findElements(By.xpath(elementValue)).size()) ;
//
//                break;
//
//            } else {
//
//                // driver.navigate().refresh();
//
//                explicitCustomWait();
//
//            }
//
// 
//
//        }
//
// 
//
//        // moved out of while loop
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//        element.click();
//
// 
//
//    }
	
	public static void waitToBeClickableAndClick(WebElement element) {

		boolean isElementPresent = false;
		int size,size2;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));

		String elementValue = generateXpathString(element);
		
		
		try {
			isElementPresent = element.isDisplayed();
			
			if(isElementPresent==true) {
				element.click();
			}
		}

		catch (NoSuchElementException e) {
			// Handle the case when the element with the specified ID is not found
			
			size=driver.findElements(By.xpath(elementValue)).size();
			if(size!=0) {
				element.click();
			}
			else {
				driver.navigate().refresh();
				size2=driver.findElements(By.xpath(elementValue)).size();
				if(size2!=0) {
					element.click();
				}
				else
					System.out.println("Element "+elementValue+" is not available");
			}
			
		} catch (StaleElementReferenceException e) {
			// Handle the case when the element becomes stale (e.g., DOM changes)
			
			driver.navigate().refresh();
			size=driver.findElements(By.xpath(elementValue)).size();
			if(size!=0) {
				element.click();
			}
			else
				System.out.println("Element "+elementValue+" is not available");	
		}

	}	

	public static void waitToBeVisibleAndSendKeys(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);

	}

	public static void waitToBeClickableAndSendKeys(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);

	}

	public static void mergeXpathAndClick(String loc, String val) throws InterruptedException {
		String locatorInfo = loc.substring(loc.indexOf("//"), loc.lastIndexOf("'']"));
		String xpath = locatorInfo + "'" + val + "']";
		System.out.println(xpath);
		Thread.sleep(4000);
		// WebElement element =driver.findElement(By.xpath(xpath));
		// waitToBeClickableAndClick(element);
		driver.findElement(By.xpath(xpath)).click();
	}
		
	public static void dragAndDrop(WebElement element) throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.dragAndDrop(element, element).build().perform();
		Thread.sleep(2000);
	}
	
	public static void waitWebDriver(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		}
	}	
	
	public static void selectValueFromDropdown(WebDriver driver, String locator, String text){
		
		WebElement lang = driver.findElement(By.xpath(locator));
		List<WebElement> list = lang.findElements(By.xpath(locator));
		for (WebElement opt : list) {
			try {
			String value = opt.getText();
			
			if (value.equals(text)) {
				System.out.println("Value clicked =" + value);
				opt.click();
			}
		}catch(StaleElementReferenceException e) {}
	}
	}
	
	public static String generateXpathString(WebElement element) {

		 

        String elementString = element.toString();

        String do_id = "xpath: ";

 

        int startIndex = elementString.indexOf(do_id) + 7;

        int endIndex = elementString.length() - 1;

        String parsedElementString = elementString.substring(startIndex, endIndex);

        // System.out.println("Element String "+elementString);

        // System.out.println("Element value from Page Object class is " +

        // parsedElementString);

 

        return parsedElementString;

 

    }
	
	public static void explicitCustomWait() {

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }
}