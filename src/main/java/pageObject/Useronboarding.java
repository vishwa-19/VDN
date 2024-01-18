package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Useronboarding {

	@FindBy(how = How.XPATH, using = "//img[@alt='Teacher']")
	private WebElement Teacher;

	@FindBy(how = How.XPATH, using = "//h1[text()='Welcome to diksha ']")
	private WebElement WelcomeToDiksha;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement ContinueButton;

	@FindBy(how = How.XPATH, using = "//img[@alt='Student']")
	private WebElement StudentIcon;

	@FindBy(how = How.XPATH, using = "//img[@alt='Parent']")
	private WebElement other;

	@FindBy(how = How.XPATH, using = "//img[@alt='Parent']")
	private WebElement parent;

	@FindBy(how = How.XPATH, using = "//img[@alt='School head OR Officials']")
	private WebElement Headteacher;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Your Location']")
	private WebElement WelcomeToDikshaLocation;

	public WebElement getWelcomeToDikshaLocation() {
		return WelcomeToDikshaLocation;
	}
	
	public WebElement getHeadteacher() {
		return Headteacher;
	}

	public WebElement getParent() {
		return parent;
	}

	public WebElement getOther() {
		return other;
	}

	public WebElement getStudentIcon() {
		return StudentIcon;
	}

	public WebElement getTeacher() {
		return Teacher;
	}

	public WebElement getWelcomeToDiksha() {
		return WelcomeToDiksha;
	}

	public WebElement getContinueButton() {
		return ContinueButton;
	}
}
