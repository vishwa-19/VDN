
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
	
	@FindBy(how=How.XPATH,using="//strong[text()='Document Successfully Uploaded...']")
	private WebElement assertUploadDocument;
	
	@FindBy(how=How.XPATH,using="//div[@class='ui container p-0 m-0 d-flex flex-ai-center flex-jc-center']")
	private WebElement assertTabList;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Select this option in case you do not want to have review done by your organization while contributing. ']")
	private WebElement assertDisplayMsgWithSkipRev;
	
	@FindBy(how=How.XPATH,using="//sui-select[@labelfield='name']")
	private WebElement selFrameworkDropdown;
	
	@FindBy(how=How.XPATH,using="//span[text()='Continuous Professional Development']")
	private WebElement selFrameworTypeAsCPD;
	
	@FindBy(how=How.XPATH,using="//button[text()='Yes']")
	private WebElement btnYes;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Apply ']")
	private WebElement btnApply;
	

	@FindBy(how=How.XPATH,using="//*[@class='sb-dock-icon-tooltip d-inline-block']")
	private WebElement modifyContributor;

	@FindBy(how=How.XPATH,using="//h4[text()='List of Digital Textbooks ']")
	private WebElement assertListOfTextBook;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(), 'Title')]")
	private WebElement assertTitle;
	
	

	@FindBy(how=How.XPATH,using="//th[contains(text(), 'Medium')]")
	private WebElement assertMedium;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(), 'Class')]")
	private WebElement assertClass;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(), 'Subject')]")
	private WebElement assertSubject;
	
	@FindBy(how=How.XPATH,using="//dt[contains(text(), 'Content Type(s)')]")
	private WebElement assertContentTypes;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(), 'Color ')]")
	private WebElement assertOrg;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(), 'Profile Details')]")
	private WebElement assertProfileDet;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(), 'Color')]")
	private WebElement assertOrgNameOnPopUp;
	
	@FindBy(how=How.XPATH,using="//dt[contains(text(), 'Organisation')]")
	private WebElement assertOrgTypeOnPopUp;

	
	@FindBy(how=How.XPATH,using="//*[text()='Update']")
	private WebElement updateButton;
	

	@FindBy(how=How.XPATH,using="//option[text()=' NONE ']")
	private WebElement assertNonOpt;
	
	
	@FindBy(how=How.XPATH,using="//button[text()=' Yes ']")
	private WebElement clkYesBtn;

	@FindBy(how=How.XPATH,using="(//*[@data-tooltip='Modify'])[119]")
	private WebElement modifyButton;

	
	@FindBy(how=How.XPATH,using="//*[text()='How do you want to get contributions for this project?']")
	private WebElement nomination;
	
	@FindBy(how=How.XPATH,using="//*[text()='Skip two - level Review']")
	private WebElement skipTwoLevelBtn;
	
	@FindBy(how=How.XPATH,using="//*[text()='Recognition to Contributors (If any) ']")
	private WebElement recognition;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Others'])[2]")
	private WebElement selFrameworkTypeK12;
	
	
	@FindBy(how=How.XPATH,using="(//div[text()=' Total'])[1]")
	private WebElement assertTotDigiTextBook;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Approval Pending']")
	private WebElement assertAppPenDigiTextBook;
	
	@FindBy(how=How.XPATH,using="(//div[text()=' Approved'])[1]")
	private WebElement assertApprovedDigiTextBook;
	
	@FindBy(how=How.XPATH,using="(//div[text()=' Rejected'])[1]")
	private WebElement assertRejectedDigiTextBook;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Corrections pending']")
	private WebElement assertCorrPenDigiTextBook;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Title') and @class='w-15 cursor-pointer sb-sorting']")
	private WebElement assertTitleWithSort;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Medium') and @class='w-15 cursor-pointer sb-sorting']")
	private WebElement assertMediumWithSort;
	

	@FindBy(how=How.XPATH,using="//th[contains(text(),'Class') and @class='w-15 cursor-pointer sb-sorting']")
	private WebElement assertClassWithSort;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Subject') and @class='w-15 cursor-pointer sb-sorting']")
	private WebElement assertSubjectWithSort;
	
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Chapter')]")
	private WebElement assertChapter;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Status') and @class='w-20 cursor-pointer sb-sorting']")
	private WebElement assertStatusWithSort;
	
	@FindBy(how=How.XPATH,using="//input[@type='radio']/following-sibling::label[text()='Get content targeted to Textbooks, Courses or other collections']")
	private WebElement assertRadioOpt1;


	@FindBy(how=How.XPATH,using="//input[@type='radio']//following-sibling::label[text()='Get content targeted to Question Sets']")
	private WebElement assertRadioOpt2;
	
	@FindBy(how=How.XPATH,using="//input[@type='radio']//following-sibling::label[text()='Get individual content not targeted to any collection']")
	private WebElement assertRadioOpt3;
	
	@FindBy(how=How.XPATH,using="//button[text()='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(how=How.XPATH,using="//label[text()='Content Type(s) ']")
	private WebElement assertContentType;
	
	@FindBy(how=How.XPATH,using="//label[text()='Select target collection ']")
	private WebElement assertTargetCol;
	
	@FindBy(how=How.XPATH,using="//label[text()='Board  ']")
	private WebElement assertBoard;
	
	@FindBy(how=How.XPATH,using="//label[text()='Medium']")
	private WebElement assertMed;
	
	@FindBy(how=How.XPATH,using="//label[text()='Class']")
	private WebElement assertClassOpt;


	@FindBy(how=How.XPATH,using="//label[text()='Subject']")
	private WebElement assertSub;
	
	@FindBy(how=How.XPATH,using="//label[text()='Guidelines Document ']")
	private WebElement assertGuideline;
	
	@FindBy(how=How.XPATH,using="//span[text()='Filter Digital Textbooks']")
	private WebElement assertFilterTextBooks;
	
	@FindBy(how=How.XPATH,using="(//i[@class='dropdown icon'])[2]")
	private WebElement clkMedDropdown;
	
	@FindBy(how=How.XPATH,using="(//span[text()='English'])[3]")
	private WebElement selectEngVal;
	
	@FindBy(how=How.XPATH,using="(//i[@class='dropdown icon'])[3]")
	private WebElement clkSubDropdown;
	
	@FindBy(how=How.XPATH,using="//span[text()='Mathematics']")
	private WebElement selectSubVal;
	
	@FindBy(how=How.XPATH,using="(//i[@class='dropdown icon'])[4]")
	private WebElement clkClassDropdown;

	@FindBy(how=How.XPATH,using="//span[text()='Class 1']")
	private WebElement selectClass1Val;
	
	@FindBy(how=How.XPATH,using="//span[text()='Modify Filters']")
	private WebElement assertModifyFilters;
	
	@FindBy(how=How.XPATH,using="(//div[contains(text(),'English')])[2]")
	private WebElement assertMedPostFilter;
	
	@FindBy(how=How.XPATH,using="(//div[text()=' Mathematics '])[2]")
	private WebElement assertSubPostFilter;
	
	@FindBy(how=How.XPATH,using="(//div[text()=' Class 1 '])[2]")
	private WebElement assertClassPostFilter;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Reset']")
	private WebElement clkResetBtn;
	
	
	@FindBy(how=How.XPATH,using="//div[text()=' Color ']//following::button[text()='View Contribution']")
	private WebElement clkViewContribution;
	
	@FindBy(how=How.XPATH,using="//h4[text()='List of Content Playlists ']")
	private WebElement listOfContentPlaylist;
	
	@FindBy(how=How.XPATH,using="//div[text()='No users found.']")
	private WebElement assertNoUsersFound;
	
	
	
	
	
	
	public WebElement getAssertNoUsersFound() {
		return assertNoUsersFound;
	}

	public WebElement getListOfContentPlaylist() {
		return listOfContentPlaylist;
	}

	public WebElement getClkViewContribution() {
		return clkViewContribution;
	}

	public WebElement getClkResetBtn() {
		return clkResetBtn;
	}

	public WebElement getAssertClassPostFilter() {
		return assertClassPostFilter;
	}

	public WebElement getAssertSubPostFilter() {
		return assertSubPostFilter;
	}

	public WebElement getAssertMedPostFilter() {
		return assertMedPostFilter;
	}

	public WebElement getAssertModifyFilters() {
		return assertModifyFilters;
	}

	public WebElement getSelectClass1Val() {
		return selectClass1Val;
	}

	public WebElement getClkClassDropdown() {
		return clkClassDropdown;
	}

	
	
	public WebElement getSelectSubVal() {
		return selectSubVal;
	}


	public WebElement getClkSubDropdown() {
		return clkSubDropdown;
	}


	public WebElement getSelectEngVal() {
		return selectEngVal;
	}


	public WebElement getClkMedDropdown() {
		return clkMedDropdown;
	}


	public WebElement getAssertFilterTextBooks() {
		return assertFilterTextBooks;
	}


	public WebElement getAssertGuideline() {
		return assertGuideline;
	}


	public WebElement getAssertSub() {
		return assertSub;
	}
	
	public WebElement getAssertClassOpt() {
		return assertClassOpt;
	}


	public WebElement getAssertMed() {
		return assertMed;
	}
	
	
	public WebElement getAssertBoard() {
		return assertBoard;
	}

	public WebElement getAssertTargetCol() {
		return assertTargetCol;
	}

	public WebElement getAssertContentType() {
		return assertContentType;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public WebElement getAssertRadioOpt1() {
		return assertRadioOpt1;
	}
	
	public WebElement getAssertRadioOpt2() {
		return assertRadioOpt2;
	}
	
	public WebElement getAssertRadioOpt3() {
		return assertRadioOpt3;
	}
	
	
	public WebElement getAssertStatusWithSort() {
		return assertStatusWithSort;
	}

	public WebElement getAssertChapter() {
		return assertChapter;
	}

	public WebElement getAssertSubjectWithSort() {
		return assertSubjectWithSort;
	}

	public WebElement getAssertClassWithSort() {
		return assertClassWithSort;
	}

	public WebElement getAssertMediumWithSort() {
		return assertMediumWithSort;
	}
	
	public WebElement getAssertTitleWithSort() {
		return assertTitleWithSort;
	}

	public WebElement getAssertTotDigiTextBook() {
		return assertTotDigiTextBook;
	}
	
	public WebElement getAssertAppPenDigiTextBook() {
		return assertAppPenDigiTextBook;
	}
	
	public WebElement getAssertApprovedDigiTextBook() {
		return assertApprovedDigiTextBook;
	}
	
	public WebElement getAssertRejectedDigiTextBook() {
		return assertRejectedDigiTextBook;
	}
	
	
	public WebElement getAssertCorrPenDigiTextBook() {
		return assertCorrPenDigiTextBook;
	}

	public WebElement getSelFrameworkTypeK12() {
		return selFrameworkTypeK12;
	}


	@FindBy(how=How.XPATH,using="//*[text()='The project cannot be deleted because it has nominations']")
	private WebElement deleteErrorMsg;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Yes ']")
	private WebElement closeYesBtn;
	
	@FindBy(how=How.XPATH,using="//*[@id='sb-dropdown']")
	private WebElement board;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Others'])[3]")
	private WebElement boardValue;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select Medium']")
	private WebElement medium;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select All']")
	private WebElement mediumValue;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select Class']")
	private WebElement class1;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select All']")
	private WebElement classValue;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select Subject']")
	private WebElement subject;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select All']")
	private WebElement subjectValue;
	
	@FindBy(how=How.XPATH,using="//*[text()='Contributor Type ']")
	private WebElement contributorType;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Name    ']")
	private WebElement contributorName;
	
	@FindBy(how=How.XPATH,using="//*[text()='Email']")
	private WebElement contributorEmail;
	
	@FindBy(how=How.XPATH,using="//*[text()='Mobile']")
	private WebElement contributorMobile;
	
	@FindBy(how=How.XPATH,using="//*[text()='Type']")
	private WebElement contributorType1;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Next'])[2]")
	private WebElement contributorNextBtn;
	
	@FindBy(how=How.XPATH,using="//*[text()='Color']")
	private WebElement selectedContributor;
	
	@FindBy(how=How.XPATH,using="//*[text()='contributor(s) added']")
	private WebElement addedContributor;
	
	public WebElement getAddedContributor() {
		return addedContributor;
	}
	
	public WebElement getSelectedContributor() {
		return selectedContributor;
	}
	
	public WebElement getContributorNextBtn() {
		return contributorNextBtn;
	}
	
	public WebElement getContributorType1() {
		return contributorType1;
	}
	
	public WebElement getContributorMobile() {
		return contributorMobile;
	}
	
	public WebElement getContributorEmail() {
		return contributorEmail;
	}
	
	public WebElement getContributorName() {
		return contributorName;
	}
	
	public WebElement getContributorType() {
		return contributorType;
	}
	
	public WebElement getSubjectValue() {
		return subjectValue;
	}
	
	public WebElement getSubject() {
		return subject;
	}
	
	public WebElement getClassValue() {
		return classValue;
	}
	
	public WebElement getClass1() {
		return class1;
	}
	
	public WebElement getMediumValue() {
		return mediumValue;
	}
	
	public WebElement getMedium() {
		return medium;
	}
	
	public WebElement getBoardValue() {
		return boardValue;
	}
	
	public WebElement getBoard() {
		return board;
	}
	
	public WebElement getCloseYesBtn() {
		return closeYesBtn;
	}
	
	public WebElement getDeleteErrorMsg() {
		return deleteErrorMsg;
	}
	
	public WebElement getRecognition() {
		return recognition;
	}
	
	public WebElement getSkipTwoLevelBtn() {
		return skipTwoLevelBtn;
	}
	
	public WebElement getNomination() {
		return nomination;
	}
	
	public WebElement getModifyButton() {
		return modifyButton;
	}
	
	public WebElement getUpdateButton() {
		return updateButton;
	}
	

	
	
	
	
	
	public WebElement getClkYesBtn() {
		return clkYesBtn;
	}



	public WebElement getAssertNonOpt() {
		return assertNonOpt;
	}





	public WebElement getModifyContributor() {
		return modifyContributor;
	}


	public WebElement getAssertOrgTypeOnPopUp() {
		return assertOrgTypeOnPopUp;
	}



	public WebElement getAssertOrgNameOnPopUp() {
		return assertOrgNameOnPopUp;
	}



	public WebElement getAssertProfileDet() {
		return assertProfileDet;
	}



	public WebElement getAssertOrg() {
		return assertOrg;
	}



	public WebElement getAssertContentTypes() {
		return assertContentTypes;
	}



	public WebElement getAssertSubject() {
		return assertSubject;
	}



	public WebElement getAssertClass() {
		return assertClass;
	}



	public WebElement getAssertTitle() {
		return assertTitle;
	}
	

	
	
	public WebElement getAssertMedium() {
		return assertMedium;
	}


	public WebElement getAssertListOfTextBook() {
		return assertListOfTextBook;
	}


	public WebElement getBtnApply() {
		return btnApply;
	}


	public WebElement getBtnYes() {
		return btnYes;
	}


	public WebElement getSelFrameworTypeAsCPD() {
		return selFrameworTypeAsCPD;
	}


	public WebElement getSelFrameworkDropdown() {
		return selFrameworkDropdown;
	}


	public WebElement getAssertDisplayMsgWithSkipRev() {
		return assertDisplayMsgWithSkipRev;
	}


	public WebElement getAssertTabList() {
		return assertTabList;
	}


	public WebElement getAssertUploadDocument() {
		return assertUploadDocument;
	}


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

