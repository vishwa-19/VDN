package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class VDNContributor {
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Approval Pending')]//following::button[1]")
	private WebElement clkOpenBtn2;
	
	@FindBy(how=How.XPATH,using="//*[text()='My Projects']")
	private WebElement myProjectTab;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Open '])[1]")
	private WebElement openBtn;
	
	@FindBy(how=How.XPATH,using="//*[@class='practical-header__title ']")
	private WebElement pojectDetails;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Yes ']")
	private WebElement modifyNominationYesBtn;
	
	@FindBy(how=How.XPATH,using="//*[text()='Total Content']")
	private WebElement totalContent;

	public WebElement getTotalContent() {
		return totalContent;
	}

	public WebElement getModifyNominationYesBtn() {
		return modifyNominationYesBtn;
	}

	public WebElement getPojectDetails() {
		return pojectDetails;
	}

	public WebElement getOpenBtn() {
		return openBtn;
	}

	public WebElement getMyProjectTab() {
		return myProjectTab;
	}

	public WebElement getClkOpenBtn2() {
		return clkOpenBtn2;
	}
}

