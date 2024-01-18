
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

