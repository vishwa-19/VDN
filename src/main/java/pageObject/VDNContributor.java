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
	
	@FindBy(how=How.XPATH,using="//*[text()=' Cancel ']")
	private WebElement contentTypeCancelBtn;
	
	@FindBy(how=How.XPATH,using="//*[text()='Content Type(s) selection is mandatory for nomination']")
	private WebElement contentTypeToasrMsg;
	
	@FindBy(how=How.XPATH,using="//*[@class='fs-0-785']")
	private WebElement  instructionText ;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Nomination Process: ']")
	private WebElement  nominationProcess ;
	
	@FindBy(how=How.XPATH,using="//*[text()=' View Content Guidelines Document ']")
	private WebElement  guidelineDocument;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Apply Filter ']")
	private WebElement  applyFilterButton;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select sourcing Organisation']")
	private WebElement  selectSourcingOrg;
	
	@FindBy(how=How.XPATH,using="//*[text()='EKSTEP']")
	private WebElement  selectOrg;
	
	@FindBy(how=How.XPATH,using="//*[@formcontrolname='medium']")
	private WebElement  selectMedium;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Apply ']")
	private WebElement  filterApplyBtn;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Terms and Policies ']")
	private WebElement  termsAndPolicies;
	
	@FindBy(how=How.XPATH,using="//*[text()='Number of Samples']")
	private WebElement  numberOfSamples;
	
	public WebElement getNumberOfSamples() {
		return numberOfSamples;
	}

	public WebElement getTermsAndPolicies() {
		return termsAndPolicies;
	}


	@FindBy(how=How.XPATH,using="//*[text()=' Reset']")
	private WebElement  filterResetBtn;

	public WebElement getFilterResetBtn() {
		return filterResetBtn;
	}

	public WebElement getFilterApplyBtn() {
		return filterApplyBtn;
	}

	public WebElement getSelectMedium() {
		return selectMedium;
	}

	public WebElement getSelectOrg() {
		return selectOrg;
	}

	public WebElement getSelectSourcingOrg() {
		return selectSourcingOrg;
	}

	public WebElement getApplyFilterButton() {
		return applyFilterButton;
	}

	public WebElement getGuidelineDocument() {
		return guidelineDocument;
	}

	public WebElement getNominationProcess() {
		return nominationProcess;
	}

	public WebElement getInstructionText() {
		return instructionText;
	}

	public WebElement getContentTypeToasrMsg() {
		return contentTypeToasrMsg;
	}

	public WebElement getContentTypeCancelBtn() {
		return contentTypeCancelBtn;
	}

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

	
	@FindBy(how=How.XPATH,using="//div[text()=' Your nomination is already submitted, do you want to modify it? ']")
	private WebElement ConfirmationOnModify;
	
	@FindBy(how=How.XPATH,using="//button[text()=' No ']")
	private WebElement clkNoBtn;
	
	@FindBy(how=How.XPATH,using="//i[@id='contribution_nomination_help']")
	private WebElement asserQIcon;
	
	
	
	
	

	public WebElement getAsserQIcon() {
		return asserQIcon;
	}


	public WebElement getClkNoBtn() {
		return clkNoBtn;
	}


	public WebElement getConfirmationOnModify() {
		return ConfirmationOnModify;
	}

	public WebElement getClkOpenBtn2() {
		return clkOpenBtn2;
	}
}

