package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserHomeTab {

	@FindBy(how = How.XPATH, using = "//a[text()=' Home ']")
	private WebElement homeTab;

	@FindBy(how = How.XPATH, using = "//span[text()='Continue Learning']")
	private WebElement continueLearning;

	@FindBy(how = How.XPATH, using = "//div[text()='Browse by Subjects']")
	private WebElement browseBySubject;

	@FindBy(how = How.XPATH, using = "//div[text()='Browse by Categories']")
	private WebElement browseByCategories;

	@FindBy(how = How.XPATH, using = "//div[text()='Browse Other Categories']")
	private WebElement browseByOtherCategories;

	@FindBy(how = How.XPATH, using = "//div[text()=' Recently published courses ']")
	private WebElement recentlyPublishedCourse;

	@FindBy(how = How.XPATH, using = "//bdi[text()='बहुकक्षीय-बहुस्तरीय शिक्षण (KGBV उत्तर प्रदेश)']")
	private WebElement enrolledCourseName;

	public WebElement getHomeTab() {
		return homeTab;
	}

	public WebElement getEnrolledCourseName() {
		return enrolledCourseName;
	}

	@FindBy(how = How.XPATH, using = "//div[@role='link']")
	private WebElement clickContentCardUnderRecentlyPublishedCourse;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'CHANGE PREFERENCE')]")
	private WebElement clickChangePreference;

	public WebElement gethomeTab() {
		return homeTab;
	}

	public WebElement getContinueLearning() {
		return continueLearning;
	}

	public WebElement getBrowseBySubject() {
		return browseBySubject;
	}

	public WebElement getBrowseByCategories() {
		return browseByCategories;
	}

	public WebElement getBrowseByOtherCategories() {
		return browseByOtherCategories;
	}

	public WebElement getRecentlyPublishedCourse() {
		return recentlyPublishedCourse;
	}

	public WebElement getValidateClickChangePreference() {
		return clickChangePreference;
	}
}
