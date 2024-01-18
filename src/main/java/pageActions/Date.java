package pageActions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BaseClass;

public class Date extends BaseClass {

	public static void setTodayDate(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

		LocalDate today = LocalDate.now().plusDays(11);
		String formattedDate = today.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		driver.findElement(By.xpath("//input[@formcontrolname='nomination_enddate']"));
		jsExecutor.executeScript(script, element, formattedDate);
	}

	public static void setTodayDate(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

		LocalDate today = LocalDate.now().plusDays(11);
		String formattedDate = today.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='nomination_enddate']")),
				formattedDate);
	}

	public static void setTomorrowDate(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate tomorrow = LocalDate.now().plusDays(12);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String formattedDate = tomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='shortlisting_enddate']")),
				formattedDate);
	}

	public static String todayDate() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(formatter);
		return formattedDate;
	}

	public static void setTomorrowDate(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate tomorrow = LocalDate.now().plusDays(12);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
		String formattedDate = tomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";

		jsExecutor.executeScript(script, element, formattedDate);

		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='shortlisting_enddate']")),
				formattedDate);
	}
	
	
	public static void setDayAfterTomorrowDate(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate dayAftertomorrow = LocalDate.now().plusDays(13);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String formattedDate = dayAftertomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";

		jsExecutor.executeScript(script, element, formattedDate);

		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='content_submission_enddate']")),
				formattedDate);
	}
	
	public static void setDayAfterTomorrowDate(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate tomorrow = LocalDate.now().plusDays(13);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String formattedDate = tomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='content_submission_enddate']")),
				formattedDate);
	}

	
	public static void setNextToDayAfterTomorrowDate(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate dayAftertomorrow = LocalDate.now().plusDays(14);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String formattedDate = dayAftertomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";

		jsExecutor.executeScript(script, element, formattedDate);

		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='enddate']")),
				formattedDate);
	}
	
	public static void setNextToDayAfterTomorrowDate(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		LocalDate tomorrow = LocalDate.now().plusDays(14);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		String formattedDate = tomorrow.format(formatter);
		String script = "arguments[0].value = arguments[1];";
		jsExecutor.executeScript(script, driver.findElement(By.xpath("//input[@formcontrolname='enddate']")),
				formattedDate);
	}

//	public static void setDayAfterTomorrowDate(WebDriver driver, WebElement element) {
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		LocalDate dayAfterTomorrow = LocalDate.now().plusDays(2);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
//		String formattedDate = dayAfterTomorrow.format(formatter);
//		String script = "arguments[0].value = arguments[1];";
//		jsExecutor.executeScript(script, element, formattedDate);
//	}

}
