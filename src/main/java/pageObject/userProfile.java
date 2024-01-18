package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class userProfile {

	@FindBy(how = How.XPATH, using = "(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;

	@FindBy(how = How.XPATH, using = "//li[text()=' Profile ']")
	private WebElement profilebutton;

	@FindBy(how = How.XPATH, using = "//button[@aria-label='Back']")
	private WebElement BackButton;

	@FindBy(how = How.XPATH, using = "//div[text()=' Add user ']")
	private WebElement AddAnotherUserTab;

	@FindBy(how = How.XPATH, using = "//label[text()='Learner passbook‎']")
	private WebElement learnerPassBookSection;

	public WebElement getlearnerPassBookSection() {
		return learnerPassBookSection;
	}
	
	public WebElement getAddAnotherUserTab() {
		return AddAnotherUserTab;
	}

	public WebElement headerDropdown() {
		return headerDropdown;
	}

	public WebElement getProfilebutton() {
		return profilebutton;
	}

	public WebElement getBackButton() {
		return BackButton;
	}

}
