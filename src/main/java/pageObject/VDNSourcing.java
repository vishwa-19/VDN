
package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class VDNSourcing {
	

	@FindBy(how=How.XPATH,using="//a[text()='For Books/Course/Other Collections '] ")
	private WebElement assertCollection;
	
	@FindBy(how=How.XPATH,using="//a[text()='For Question Sets ']")
	private WebElement assertForQSet;
	
	@FindBy(how=How.XPATH,using="//a[text()='For individual content not for any collection '] ")
	private WebElement assertIndContent;
	
	@FindBy(how=How.XPATH,using="(//button[contains(text(),'Apply Filter')])[1]")
	private WebElement applyBtn;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),' Apply filters ')]")
	private WebElement assertApplyFilterPopUp;
		
	@FindBy(how=How.XPATH,using="//label[text()='Medium(s)']")
	private WebElement assertMediumOnPopUp;
	
	@FindBy(how=How.XPATH,using="//label[text()='Class(es)']")
	private WebElement assertClassOnPopUp;
	
	@FindBy(how=How.XPATH,using="//label[text()='Subject(s)']")
	private WebElement assertSubjectsOnPopUp;
	
	@FindBy(how=How.XPATH,using="//label[text()='Content Type(s)']")
	private WebElement assertContentTypesOnPopUp;
	
	@FindBy(how=How.XPATH,using="//label[text()='Target collection']")
	private WebElement assertTargetCollOnPopUp;
	
	@FindBy(how=How.XPATH,using="//label[text()='Nomination Date']")
	private WebElement assertNominationDateOnPopUp;
	
	@FindBy(how=How.XPATH,using="//label[text()='Contribution Date']")
	private WebElement assertContributionDateOnPopUp;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Reset')]")
	private WebElement resetBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Apply ']")
	private WebElement applyButton;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Delete Project ']")
	private WebElement assertHeaerConfirmationPopUp;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Are you sure you want to delete this project? ']")
	private WebElement assertConfirmationPopUpMsg;
	
	@FindBy(how=How.XPATH,using="//button[text()=' No ']")
	private WebElement assertNoOption;
	
	@FindBy(how=How.XPATH,using="//i[@class='close icon']")
	private WebElement closeConfirmationIcon;
	
	@FindBy(how=How.XPATH,using="//strong[text()='The project cannot be deleted because it has nominations']")
	private WebElement assertErrorMsgOnDeleteNominatedProject;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(), 'Select contributors')]")
	private WebElement assertSelectContributorPopUpHeader;
	
	@FindBy(how=How.XPATH,using="//label[text()='Contributor Type ']")
	private WebElement assertContributorTypeLabel;
	
	@FindBy(how=How.XPATH,using="//button[text()='Save']")
	private WebElement assertSaveBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='Close']")
	private WebElement assertCloseBtn;
	
	@FindBy(how=How.XPATH,using="//label[text()='testUser ']")
	private WebElement assertSelectedContributor;
	
	@FindBy(how=How.XPATH,using="//span[text()='contributor(s) added']")
	private WebElement assertContributorSelected;
	
	
	
	
	
	
	public WebElement getAssertContributorSelected() {
		return assertContributorSelected;
	}


	public WebElement getAssertSelectedContributor() {
		return assertSelectedContributor;
	}


	public WebElement getAssertCloseBtn() {
		return assertCloseBtn;
	}


	public WebElement getAssertSaveBtn() {
		return assertSaveBtn;
	}
	
	
	public WebElement getAssertContributorTypeLabel() {
		return assertContributorTypeLabel;
	}

	public WebElement getAssertSelectContributorPopUpHeader() {
		return assertSelectContributorPopUpHeader;
	}

	public WebElement getAssertErrorMsgOnDeleteNominatedProject() {
		return assertErrorMsgOnDeleteNominatedProject;
	}

	public WebElement getCloseConfirmationIcon() {
		return closeConfirmationIcon;
	}

	public WebElement getAssertNoOption() {
		return assertNoOption;
	}

	public WebElement getAssertConfirmationPopUpMsg() {
		return assertConfirmationPopUpMsg;
	}

	public WebElement getAssertHeaerConfirmationPopUp() {
		return assertHeaerConfirmationPopUp;
	}

	public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getResetBtn() {
		return resetBtn;
	}

	public WebElement getAssertContributionDateOnPopUp() {
		return assertContributionDateOnPopUp;
	}

	public WebElement getAssertNominationDateOnPopUp() {
		return assertNominationDateOnPopUp;
	}

	public WebElement getAssertTargetCollOnPopUp() {
		return assertTargetCollOnPopUp;
	}

	public WebElement getAssertContentTypesOnPopUp() {
		return assertContentTypesOnPopUp;
	}

	public WebElement getAssertSubjectsOnPopUp() {
		return assertSubjectsOnPopUp;
	}

	public WebElement getAssertClassOnPopUp() {
		return assertClassOnPopUp;
	}

	public WebElement getAssertMediumOnPopUp() {
		return assertMediumOnPopUp;
	}

	public WebElement getAssertApplyFilterPopUp() {
		return assertApplyFilterPopUp;
	}

	public WebElement getApplyBtn() {
		return applyBtn;
	}

	public WebElement getAssertIndContent() {
		return assertIndContent;
	}

	public WebElement getAssertForQSet() {
		return assertForQSet;
	}

	public WebElement getAssertCollection() {
		return assertCollection;
	}
	
	
	


	
	
	
	
	
	
	
}

