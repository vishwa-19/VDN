
package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class VDNSourcing {
	
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
	private WebElement assertClassOpt1;

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
	
	@FindBy(how=How.XPATH,using="//div[@class='twelve wide tablet five wide computer column text-right']")
	private WebElement assertGuidelineDetails;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Download Digital Textbook details ']")
	private WebElement assertDigiTextBookDet;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Details ']")
	private WebElement assertDetailsTab;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Project Scope ']")
	private WebElement assertProjectScopeTab;
	
	@FindBy(how=How.XPATH,using="//span[text()='Open']")
	private WebElement clkNomOpenStatus;
	
	@FindBy(how=How.XPATH,using="//span[text()='Closed']")
	private WebElement clkNomClosedStatus;

	@FindBy(how=How.XPATH,using="//span[text()='Any']")
	private WebElement clkNomAnyStatus;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Open'])[2]")
	private WebElement clkConOpenStatus;

	@FindBy(how=How.XPATH,using="(//span[text()='Closed'])[2]")
	private WebElement clkConClosedStatus;

	@FindBy(how=How.XPATH,using="(//span[text()='Any'])[2]")
	private WebElement clkConAnyStatus;
	
	@FindBy(how=How.XPATH,using="//label[text()='Contribution Date']//following::sui-select")
	private WebElement selContributionDate;
	
	@FindBy(how=How.XPATH,using="//label[text()='Nomination Date']//following::sui-select")
	private WebElement selNominationDate;
	
	@FindBy(how=How.XPATH,using="(//div[text()=' 2 Filters applied '])[1]")
	private WebElement assert2Filters;
	
	@FindBy(how=How.XPATH,using="//textarea[@placeholder='Add description']")
	private WebElement enterReco;
	
	@FindBy(how=How.XPATH,using="//label[text()='Framework Type ']")
	private WebElement assertFrameworkType;
	
	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[2]")
	private WebElement assertDraftCount;
	
	@FindBy(how=How.XPATH,using="//th[text()=' Draft ']")
	private WebElement assertDraftTitle;
	
	@FindBy(how=How.XPATH,using="//th[text()=' Review Pending ']")
	private WebElement assertRevPenTitle;
	
	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[3]")
	private WebElement assertRevPenCount;
	
	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[4]")
	private WebElement asssertCorPenCount;
	
	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[5]")
	private WebElement asssertAcceptedCount;
	
	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[6]")
	private WebElement asssertNotAcceptedCount;
	

	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[7]")
	private WebElement assertOrgAppPenCount;
	                   
	
	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[8]")
	private WebElement assertApprovedCount;
	
	@FindBy(how=How.XPATH,using="//td[text()='Color']//following::td[9]")
	private WebElement assertRejectedCount;
	
	@FindBy(how=How.XPATH,using="//label[text()='Need Help?']")
	private WebElement assertNeedHelp;
	
	@FindBy(how=How.XPATH,using="//i[@id='sourcing_manage_users_help']")
	private WebElement assertQuestionMarkIcon;
	
	@FindBy(how=How.XPATH,using="//button[text()='Know More']")
	private WebElement assertKnowMoreBtn;
	
	@FindBy(how=How.XPATH,using="//span[text()='Others']")
	private WebElement assertK12FrameWork;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Invite User']")
	private WebElement assertInviteUser;
	
	
	public WebElement getAssertInviteUser() {
		return assertInviteUser;
	}

	public WebElement getAssertK12FrameWork() {
		return assertK12FrameWork;
	}

	public WebElement getAssertKnowMoreBtn() {
		return assertKnowMoreBtn;
	}

	public WebElement getAssertQuestionMarkIcon() {
		return assertQuestionMarkIcon;
	}

	public WebElement getAssertNeedHelp() {
		return assertNeedHelp;
	}

	public WebElement getAssertRejectedCount() {
		return assertRejectedCount;
	}

	public WebElement getAssertApprovedCount() {
		return assertApprovedCount;
	}

	public WebElement getAsssertNotAcceptedCount() {
		return asssertNotAcceptedCount;
	}

	
	public WebElement getAssertOrgAppPenCount() {
		return assertOrgAppPenCount;
	}

	public WebElement getAsssertAcceptedCount() {
		return asssertAcceptedCount;
	}

	public WebElement getAsssertCorPenCount() {
		return asssertCorPenCount;
	}

	public WebElement getAssertRevPenCount() {
		return assertRevPenCount;
	}

	public WebElement getAssertRevPenTitle() {
		return assertRevPenTitle;
	}

	public WebElement getAssertDraftTitle() {
		return assertDraftTitle;
	}

	public WebElement getAssertDraftCount() {
		return assertDraftCount;
	}

	public WebElement getAssertFrameworkType() {
		return assertFrameworkType;
	}

	public WebElement getEnterReco() {
		return enterReco;
	}

	public WebElement getAssert2Filters() {
		return assert2Filters;
	}

	public WebElement getSelNominationDate() {
		return selNominationDate;
	}

	public WebElement getSelContributionDate() {
		return selContributionDate;
	}

	public WebElement getClkConAnyStatus() {
		return clkConAnyStatus;
	}

	public WebElement getClkConClosedStatus() {
		return clkConClosedStatus;
	}
	
	public WebElement getClkConOpenStatus() {
		return clkConOpenStatus;
	}
	
	public WebElement getClkNomAnyStatus() {
		return clkNomAnyStatus;
	}
	
	public WebElement getClkNomClosedStatus() {
		return clkNomClosedStatus;
	}
	
	public WebElement getClkNomOpenStatus() {
		return clkNomOpenStatus;
	}
	
	public WebElement getAssertProjectScopeTab() {
		return assertProjectScopeTab;
	}

	public WebElement getAssertDetailsTab() {
		return assertDetailsTab;
	}

	public WebElement getAssertDigiTextBookDet() {
		return assertDigiTextBookDet;
	}

	public WebElement getAssertGuidelineDetails() {
		return assertGuidelineDetails;
	}

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
		return assertClassOpt1;
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
	
	@FindBy(how=How.XPATH,using="//*[text()='Edit Course Unit(s) ']")
	private WebElement editCourseUnit;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Title ']/ancestor::thead/following-sibling::tbody/descendant::input")
	private WebElement courseUnitCheckBox;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Done ']")
	private WebElement courseUnitDoneBtn;
	
	@FindBy(how=How.XPATH,using="(//*[@class='item active'])[2]")
	private WebElement targetCollection;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Are you sure you want to remove the user from the project? ']")
	private WebElement assertConfirmationPopup;
	
	 
	
	public WebElement getAssertConfirmationPopup() {
		return assertConfirmationPopup;
	}


	@FindBy(how=How.XPATH,using="//*[text()='Open']")
	private WebElement contentOpenBtn;
	
	@FindBy(how=How.XPATH,using="//*[@class='sb-toc-accor-1']")
	private WebElement contentUnits;
	
	@FindBy(how=How.XPATH,using="(//*[@class='sb-meta-data'])[1]")
	private WebElement totalCount;
	
	@FindBy(how=How.XPATH,using="(//*[@class='sb-meta-data'])[2]")
	private WebElement awaitingForMyReviewCount;
	
	@FindBy(how=How.XPATH,using="//*[text()='Select Status']")
	private WebElement selectStatus;
	
	@FindBy(how=How.XPATH,using="(//*[@class='dropdown icon'])[3]")
	private WebElement selectStatusDropDown;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//*[@class='transition ui label visible']"))
	private List<WebElement> multipleStatus;
	
	@FindBy(how=How.XPATH,using="//*[text()='Nominations ']")
	private WebElement nominationTab;
	
	@FindBy(how=How.XPATH,using="(//*[@class='fa fa-sort'])[5]")
	private WebElement contributorNameSort;
	
	@FindBy(how=How.XPATH,using="(//*[@class='fa fa-sort'])[6]")
	private WebElement typeSort;
	
	@FindBy(how=How.XPATH,using="(//*[@class='fa fa-sort'])[7]")
	private WebElement contentSort;
	
	@FindBy(how=How.XPATH,using="(//*[@class='fa fa-sort'])[8]")
	private WebElement sampleSort;
	
	@FindBy(how=How.XPATH,using="(//*[@class='d-inline-block'])[2]")
	private WebElement nominationDateSort;
	
	@FindBy(how=How.XPATH,using="//*[text()='Status']")
	private WebElement nominationTabStatus;
	
	@FindBy(how=How.XPATH,using="(//*[@class='item active'])[2]/child::span")
	private WebElement nominationCount;
	
	@FindBy(how=How.XPATH,using="(//*[@class='text-left line-height-1-3']/child::div)[1]")
	private WebElement nominationTotal;
	
	@FindBy(how=How.XPATH,using="(//*[@class='text-left line-height-1-3']/child::div)[2]")
	private WebElement nominationApproved;
	
	@FindBy(how=How.XPATH,using="(//*[@class='text-left line-height-1-3']/child::div)[3]")
	private WebElement nominationRejected;
	
	@FindBy(how=How.XPATH,using="(//*[@class='text-left line-height-1-3']/child::div)[4]")
	private WebElement nominationPending;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Download Nominations List']")
	private WebElement downloadNominationsList;
	
	@FindBy(how=How.XPATH,using="//*[@class='text-left flex-grow-1']")
	private WebElement contributedBy;
	
	@FindBy(how=How.XPATH,using="//*[@class='br-1 text-center flex-grow-1 bl-2']")
	private WebElement nominationsContent;
	
	@FindBy(how=How.XPATH,using="//*[@class='br-1 text-right flex-grow-1 bl-2']")
	private WebElement nominationsContentType;
	
	@FindBy(how=How.XPATH,using="//*[text()='Approved']")
	private WebElement nominationsApproved;
	
	@FindBy(how=How.XPATH,using="//*[text()='View Contribution']")
	private WebElement viewContribution;
	
	@FindBy(how=How.XPATH,using="//*[text()='Assign users to project ']")
	private WebElement assignUserTab;
	
	@FindBy(how=How.XPATH,using="//*[text()='Content Type(s)']")
	private WebElement contentTypeProject;
	
	@FindBy(how=How.XPATH,using="//*[@class='program-timeline px-10 py-10']")
	private WebElement projectDates;
	
	@FindBy(how=How.XPATH,using="//*[@class='sb-pageSection-header']")
	private WebElement nameWithUserCount;
	
	@FindBy(how=How.XPATH,using="//*[@class='input-div relative']")
	private WebElement searchBar;
	
	@FindBy(how=How.XPATH,using="(//*[@class='w-10 cursor-pointer sb-sorting'])[5]")
	private WebElement userName;
	
	@FindBy(how=How.XPATH,using="//*[text()='Email / Mobile']")
	private WebElement userEmailMobile;
	
	@FindBy(how=How.XPATH,using="(//*[@class='w-5 cursor-pointer sb-sorting'])[1]")
	private WebElement userMedium;
	
	@FindBy(how=How.XPATH,using="(//*[@class='w-5 cursor-pointer sb-sorting'])[2]")
	private WebElement userClass;
	
	@FindBy(how=How.XPATH,using="(//*[@class='w-5 cursor-pointer sb-sorting'])[3]")
	private WebElement userSubject;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Select Role ']/parent::select")
	private WebElement selectRole;
	
	@FindBy(how=How.XPATH,using="(//*[text()=' Select Role ']/parent::select/child::option[text()=' REVIEWER '])[1]")
	private WebElement roleReviewer;
	
	@FindBy(how=How.XPATH,using="//*[text()='Roles updated...']")
	private WebElement roleUpdated;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Download Contribution Details ']")
	private WebElement downloadContributonDetails;
	
	@FindBy(how=How.XPATH,using="(//*[@class='va-top sb-sorting cursor-pointer'])[1]")
	private WebElement contributor;
	
	@FindBy(how=How.XPATH,using="(//*[@class='va-top sb-sorting cursor-pointer'])[2]")
	private WebElement typeOfContributor;
	
	@FindBy(how=How.XPATH,using="(//*[@class='bb-0 pb-0'])[1]")
	private WebElement contributingOrganisation;
	
	@FindBy(how=How.XPATH,using="(//*[@class='bb-0 pb-0'])[2]")
	private WebElement yourOrganisation;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Contribution Dashboard ']")
	private WebElement contributionDashboard;
			
	@FindBy(how=How.XPATH,using="(//button[text()='Cancel']//preceding::button[1])[2]")
	private WebElement clkNextBtn;
	

	@FindBy(how=How.XPATH,using="//*[text()=' Reports ']")
	private WebElement reportTab;
	
	@FindBy(how=How.XPATH,using="//*[text()='Report Name']")
	private WebElement reportName;
	
	@FindBy(how=How.XPATH,using="//*[text()='Description']")
	private WebElement reportDescription;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Download'])[1]")
	private WebElement reportDownloadBtn;
	
	@FindBy(how=How.XPATH,using="(//*[@class='sb-color-primary font-weight-bold'])[1]")
	private WebElement reports;
	
	@FindBy(how=How.XPATH,using="//*[text()='Manage Users']")
	private WebElement manageUsers;
	
	@FindBy(how=How.XPATH,using="(//*[@class='custom-selectbx ng-untouched ng-pristine ng-valid'])[1]")
	private WebElement roles;
	
	@FindBy(how=How.XPATH,using="(//*[text()=' Reviewer '])[1]")
	private WebElement role;
	
	@FindBy(how=How.XPATH,using="//*[@class='fa fa-sort']")
	private WebElement userNameSort;
	
	@FindBy(how=How.XPATH,using="//*[@class='fa fa-sort-desc']")
	private WebElement userRoleSort;
	
	@FindBy(how=How.XPATH,using="//*[@placeholder='Search...']")
	private WebElement manageUserSearch;
	
	@FindBy(how=How.XPATH,using="//*[text()='Search']")
	private WebElement manageUserSearchBtn;
	
	@FindBy(how=How.XPATH,using="//*[@class='sb__ellipsis sb__ellipsis--three sb-color-primary font-weight-bold']")
	private WebElement searchedUser;
	
	@FindBy(how=How.XPATH,using="//*[@class='close icon']")
	private WebElement closeIcon;
	

	@FindBy(how=How.XPATH,using="//h4[text()='List of Courses ']")
	private WebElement listOfCourses;
	
	public WebElement getListOfCourses() {
		return listOfCourses;
	}

	@FindBy(how=How.XPATH,using="(//*[text()='My Projects'])[1]")
	private WebElement myProjectHeader;
	
	@FindBy(how=How.XPATH,using="//*[@class='sb-pageSection-header mb-0']")
	private WebElement myProjectCount;
	
	@FindBy(how=How.XPATH,using="//*[@class='w-15 cursor-pointer sb-sorting']")
	private WebElement myProjectSort;
	
	@FindBy(how=How.XPATH,using="//*[text()='Medium, Class, Subject']")
	private WebElement myProjectMCS;
	
	@FindBy(how=How.XPATH,using="//*[text()='Project Dates']")
	private WebElement myProjectDates;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Apply Filter ']")
	private WebElement applyFilterBtn;
	
	@FindBy(how=How.XPATH,using="//*[@formcontrolname='medium']")
	private WebElement mediumFilter;
	
	@FindBy(how=How.XPATH,using="(//*[@class='item selected'])[1]")
	private WebElement selectMediumFilter;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Apply ']")
	private WebElement applyButton1;
	
	@FindBy(how=How.XPATH,using="//*[@class='fs-0-785 font-italic sb-color-gray-300 mb-10 d-inline-block']")
	private WebElement filterApplied;
	
	@FindBy(how=How.XPATH,using="(//*[text()='Open '])[1]")
	private WebElement projectOpenBtn;
	
	@FindBy(how=How.XPATH,using="//*[@class='m-0 p-0 pb-10 font-weight-bold d-inline-block break-word']")
	private WebElement projectName;
	
	@FindBy(how=How.XPATH,using="//*[@class='sb-color-gray-400 d-inline-block br-2 pr-10 pt-5']")
	private WebElement contentPlaylistTotalCount;
	
	@FindBy(how=How.XPATH,using="//*[@class='sb-color-gray-400 d-inline-block br-2 pr-10 pt-5']")
	private WebElement approvalPendingCount;
	
	@FindBy(how=How.XPATH,using="(//*[@class='sb-color-success d-inline-block br-2 px-10'])[1]")
	private WebElement approvedCount;
	
	@FindBy(how=How.XPATH,using="//*[@class='sb-color-error d-inline-block br-2  px-10']")
	private WebElement rejectedCount;
	
	@FindBy(how=How.XPATH,using="(//*[@class='sb-color-primary d-inline-block px-10'])[1]")
	private WebElement correctionsPendingCount;
	
	@FindBy(how=How.XPATH,using="(//*[@class='sb-table-responsive'])[1]")
	private WebElement contentList;
	
	@FindBy(how=How.XPATH,using="//*[text()='Open']")
	private WebElement openBtn;
	
	@FindBy(how=How.XPATH,using="//*[text()='Filter Content Playlists']")
	private WebElement contentPlaylistFilter;
	
	@FindBy(how=How.XPATH,using="//*[text()=' Download Content Playlist details ']")
	private WebElement contentPlaylistDownload;
	
	@FindBy(how=How.XPATH,using="//*[text()='Modify Filters']")
	private WebElement modifyFilterBtn;
	
	@FindBy(how=How.XPATH,using="//*[@class='practical-header__title ']/child::h5")
	private WebElement projectName1;
	
	@FindBy(how=How.XPATH,using="//*[text()='Approved']")
	private WebElement nominationFilterOpn;
	
	
	public WebElement getNominationFilterOpn() {
		return nominationFilterOpn;
	}

	public WebElement getProjectName1() {
		return projectName1;
	}

	public WebElement getModifyFilterBtn() {
		return modifyFilterBtn;
	}

	public WebElement getContentPlaylistDownload() {
		return contentPlaylistDownload;
	}

	public WebElement getContentPlaylistFilter() {
		return contentPlaylistFilter;
	}

	public WebElement getOpenBtn() {
		return openBtn;
	}

	public WebElement getContentList() {
		return contentList;
	}

	public WebElement getCorrectionsPendingCount() {
		return correctionsPendingCount;
	}

	public WebElement getRejectedCount() {
		return rejectedCount;
	}

	public WebElement getApprovedCount() {
		return approvedCount;
	}

	public WebElement getApprovalPendingCount() {
		return approvalPendingCount;
	}

	public WebElement getContentPlaylistTotalCount() {
		return contentPlaylistTotalCount;
	}

	public WebElement getProjectName() {
		return projectName;
	}

	public WebElement getProjectOpenBtn() {
		return projectOpenBtn;
	}

	public WebElement getFilterApplied() {
		return filterApplied;
	}

	public WebElement getApplyButton1() {
		return applyButton1;
	}

	public WebElement getSelectMediumFilter() {
		return selectMediumFilter;
	}

	public WebElement getMediumFilter() {
		return mediumFilter;
	}

	public WebElement getApplyFilterBtn() {
		return applyFilterBtn;
	}

	public WebElement getMyProjectDates() {
		return myProjectDates;
	}

	public WebElement getMyProjectMCS() {
		return myProjectMCS;
	}

	public WebElement getMyProjectSort() {
		return myProjectSort;
	}

	public WebElement getMyProjectCount() {
		return myProjectCount;
	}

	public WebElement getMyProjectHeader() {
		return myProjectHeader;

	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public WebElement getSearchedUser() {
		return searchedUser;
	}

	public WebElement getManageUserSearchBtn() {
		return manageUserSearchBtn;
	}

	public WebElement getManageUserSearch() {
		return manageUserSearch;
	}

	public WebElement getUserRoleSort() {
		return userRoleSort;
	}

	public WebElement getUserNameSort() {
		return userNameSort;
	}

	public WebElement getRole() {
		return role;
	}

	public WebElement getRoles() {
		return roles;
	}

	public WebElement getManageUsers() {
		return manageUsers;
	}

	public WebElement getReports() {
		return reports;
	}
	
	public WebElement getReportDownloadBtn() {
		return reportDownloadBtn;
	}

	public WebElement getReportDescription() {
		return reportDescription;
	}

	public WebElement getReportName() {
		return reportName;
	}

	public WebElement getReportTab() {
		return reportTab;
	}	

	public WebElement getClkNextBtn() {
		return clkNextBtn;

	}

	public WebElement getContributionDashboard() {
		return contributionDashboard;
	}

	public WebElement getYourOrganisation() {
		return yourOrganisation;
	}

	public WebElement getContributingOrganisation() {
		return contributingOrganisation;
	}

	public WebElement getTypeOfContributor() {
		return typeOfContributor;
	}

	public WebElement getContributor() {
		return contributor;
	}

	public WebElement getDownloadContributonDetails() {
		return downloadContributonDetails;
	}

	public WebElement getRoleUpdated() {
		return roleUpdated;
	}

	public WebElement getRoleReviewer() {
		return roleReviewer;
	}

	public WebElement getSelectRole() {
		return selectRole;
	}

	public WebElement getUserMedium() {
		return userMedium;
	}

	public WebElement getUserClass() {
		return userClass;
	}

	public WebElement getUserSubject() {
		return userSubject;
	}

	public WebElement getUserEmailMobile() {
		return userEmailMobile;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getNameWithUserCount() {
		return nameWithUserCount;
	}

	public WebElement getProjectDates() {
		return projectDates;
	}

	public WebElement getContentTypeProject() {
		return contentTypeProject;
	}

	public WebElement getAssertClassOpt1() {
		return assertClassOpt1;
	}

	public WebElement getAssignUserTab() {
		return assignUserTab;
	}

	public WebElement getViewContribution() {
		return viewContribution;
	}

	public WebElement getNominationsApproved() {
		return nominationsApproved;
	}

	public WebElement getNominationsContentType() {
		return nominationsContentType;
	}

	public WebElement getNominationsContent() {
		return nominationsContent;
	}

	public WebElement getContributedBy() {
		return contributedBy;
	}

	public WebElement getDownloadNominationsList() {
		return downloadNominationsList;
	}

	public WebElement getNominationTotal() {
		return nominationTotal;
	}

	public WebElement getNominationApproved() {
		return nominationApproved;
	}

	public WebElement getNominationRejected() {
		return nominationRejected;
	}

	public WebElement getNominationPending() {
		return nominationPending;
	}	
	
	public WebElement getNominationCount() {
		return nominationCount;
	}

	public WebElement getNominationTabStatus() {
		return nominationTabStatus;
	}
		
	public WebElement getNominationDateSort() {
		return nominationDateSort;
	}
	
	public WebElement getSampleSort() {
		return sampleSort;
	}
	
	public WebElement getContentSort() {
		return contentSort;
	}
	
	public WebElement getTypeSort() {
		return typeSort;
	}
	
	public WebElement getContributorNameSort() {
		return contributorNameSort;
	}
	
	public WebElement getNominationTab() {
		return nominationTab;
	}
	
	public List<WebElement> getMultipleStatus() {
		return multipleStatus;
	}
	
	public WebElement getSelectStatusDropDown() {
		return selectStatusDropDown;
	}
	
	public WebElement getSelectStatus() {
		return selectStatus;
	}
	
	public WebElement getAwaitingForMyReviewCount() {
		return awaitingForMyReviewCount;
	}
	
	public WebElement getTotalCount() {
		return totalCount;
	}
	
	public WebElement getContentUnits() {
		return contentUnits;
	}
	
	public WebElement getContentOpenBtn() {
		return contentOpenBtn;
	}
	
	public WebElement getTargetCollection() {
		return targetCollection;
	}
	

	public WebElement getCourseUnitDoneBtn() {
		return courseUnitDoneBtn;
	}
	
	public WebElement getCourseUnitCheckBox() {
		return courseUnitCheckBox;
	}
	
	public WebElement getEditCourseUnit() {
		return editCourseUnit;
	}
	
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

