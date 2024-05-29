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
	
	@FindBy(how=How.XPATH,using="//span[@class='sb-dotmenu']")
	private WebElement  clkDottedMenue;
	
	@FindBy(how=How.XPATH,using="//div[text()='Edit']")
	private WebElement  assertEditOpt;
	
	@FindBy(how=How.XPATH,using="//div[text()='Move']")
	private WebElement  assertMoveOpt;
	
	@FindBy(how=How.XPATH,using="//div[text()='Delete']")
	private WebElement  assertDeleteOpt;
	
	@FindBy(how=How.XPATH,using="//div[@class='title active']")
	private WebElement  assertTOC;
	
	
	
	
	
	
	public WebElement getAssertTOC() {
		return assertTOC;
	}

	public WebElement getAssertDeleteOpt() {
		return assertDeleteOpt;
	}

	public WebElement getAssertMoveOpt() {
		return assertMoveOpt;
	}

	public WebElement getAssertEditOpt() {
		return assertEditOpt;
	}

	public WebElement getClkDottedMenue() {
		return clkDottedMenue;
	}

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
	
	@FindBy(how=How.XPATH,using="//p[text()='Are you sure you want to submit this nomination?']")
	private WebElement nominationConfMsg;
	
	@FindBy(how=How.XPATH,using="//span[text()='My Content']")
	private WebElement assertMyContentTab;
	
	@FindBy(how=How.XPATH,using="//button[text()='Upload Content']")
	private WebElement clkUploadCont;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample2']//following::span[text()='Rejected']")
	private WebElement assertRejectOnTOC;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Select to contribute ']")
	private WebElement assertContentTypesPopUp;
	
	@FindBy(how=How.XPATH,using="//img[@src='/tenant/ntp/logo.png']")
	private WebElement assertVDNLogo;
	
	@FindBy(how=How.XPATH,using="//span[text()='Organisation : ']")
	private WebElement assertOrg;
	
	@FindBy(how=How.XPATH,using="//a[text()='Click here to get started']")
	private WebElement assertGoStarted;
	
	@FindBy(how=How.XPATH,using="//a[text()=' Help Center ']")
	private WebElement assertHelpCenter;
	
	@FindBy(how=How.XPATH,using="//a[text()=' Terms and Policies ']")
	private WebElement assertTnC;
	
	@FindBy(how=How.XPATH,using="//span[text()='My Content']")
	private WebElement assertMyContent;
	
	@FindBy(how=How.XPATH,using="//div[text()=' color2  ']")
	private WebElement assertSearchedUser;
	
	@FindBy(how=How.XPATH,using="//span[text()='Not Accepted']//following::button[text()='Open']")
	private WebElement clkOpenNotAccepted;
	
	@FindBy(how=How.XPATH,using="//button[text()='Replace File']")
	private WebElement clkReplaceBtn;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Sample2 ']//following::span[text()='Corrections pending']")
	private WebElement assertCorrPenNoTC1;
	
	@FindBy(how=How.XPATH,using="//span[text()='Corrections pending']//following::button[text()='Open']")
	private WebElement clkOpenCorrPen;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample1']//following::span[text()='Approved']")
	private WebElement assertApprovedOnTOC;
	
	
	@FindBy(how=How.XPATH,using="//div[@class='chapter-lists--item']")
	private WebElement assertApprovedRow;
	
	@FindBy(how=How.XPATH,using="//span[text()='Corrections pending']//following::button[text()='Open']")
	private WebElement clkOpenCorBtn;
	
	@FindBy(how=How.XPATH,using="//span[text()='color5']//following::span[text()='Review Pending']")
	private WebElement assertRevPending5;
	
	@FindBy(how=How.XPATH,using="//label[text()='Content Type(s)']")
	private WebElement assertContentTypes;
	
	@FindBy(how=How.XPATH,using="//div[text()='Nomination End Date']")
	private WebElement assertNominationDates;
	
	@FindBy(how=How.XPATH,using="//p[text()='Approved']")
	private WebElement assertApprovedStatus;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Digital Textbook')]")
	private WebElement assertDigiText;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'Medium')]")
	private WebElement assertMedium;

	@FindBy(how=How.XPATH,using="//th[contains(text(),'Class')]")
	private WebElement assetClass;

	@FindBy(how=How.XPATH,using="//th[contains(text(),'Subject')]")
	private WebElement assertSubject;
	
	@FindBy(how=How.XPATH,using="//a[text()=' View Content Guidelines Document ']")
	private WebElement assertViewGuidelineDoc;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Approval Pending')]//following::button[1]")
	private WebElement clkOpenBtn;
	
	@FindBy(how=How.XPATH,using="//span[text()='Approved']//following::button[text()='Open']")
	private WebElement clkOpenBtnApproved;
	
	@FindBy(how=How.XPATH,using="//span[text()='Not Accepted']//following::button[text()='Open']")
	private WebElement clkOpenBtnNotAccepted;
	
	@FindBy(how=How.XPATH,using="//span[text()='Approval Pending']//following::button[text()='Open']")
	private WebElement clkOpenBtnAppPen;
	
	@FindBy(how=How.XPATH,using="//span[text()='Review Pending']//following::button[text()='Open']")
	private WebElement clkOpenBtnRevPen;
	
	@FindBy(how=How.XPATH,using="//i[@class='close icon']//following::button[text()='Done']")
	private WebElement clkDoneBtn;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Pdf']")
	private WebElement assertPDFUpload;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Html']")
	private WebElement assertHTMLUpload;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Mp4']")
	private WebElement assertMP4Upload;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Webm']")
	private WebElement assertWEBMUpload;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_H5p']")
	private WebElement assertH5pUpload;
	
	
	
	
	
	
	
	
	public WebElement getAssertH5pUpload() {
		return assertH5pUpload;
	}

	public WebElement getAssertWEBMUpload() {
		return assertWEBMUpload;
	}

	public WebElement getAssertMP4Upload() {
		return assertMP4Upload;
	}

	public WebElement getAssertHTMLUpload() {
		return assertHTMLUpload;
	}

	public WebElement getAssertPDFUpload() {
		return assertPDFUpload;
	}

	public WebElement getClkDoneBtn() {
		return clkDoneBtn;
	}

	public WebElement getClkOpenBtnRevPen() {
		return clkOpenBtnRevPen;
	}

	public WebElement getClkOpenBtnAppPen() {
		return clkOpenBtnAppPen;
	}

	public WebElement getClkOpenBtnNotAccepted() {
		return clkOpenBtnNotAccepted;
	}

	public WebElement getClkOpenBtnApproved() {
		return clkOpenBtnApproved;
	}

	public WebElement getClkOpenBtn() {
		return clkOpenBtn;
	}

	public WebElement getAssertViewGuidelineDoc() {
		return assertViewGuidelineDoc;
	}

	public WebElement getAssertSubject() {
		return assertSubject;
	}

	public WebElement getAssetClass() {
		return assetClass;
	}
	
	public WebElement getAssertMedium() {
		return assertMedium;
	}
	
	
	public WebElement getAssertDigiText() {
		return assertDigiText;
	}
	
	
	public WebElement getAssertApprovedStatus() {
		return assertApprovedStatus;
	}

	public WebElement getAssertNominationDates() {
		return assertNominationDates;
	}

	public WebElement getAssertContentTypes() {
		return assertContentTypes;
	}

	public WebElement getAssertRevPending5() {
		return assertRevPending5;
	}

	public WebElement getClkOpenCorBtn() {
		return clkOpenCorBtn;
	}

	public WebElement getAssertApprovedRow() {
		return assertApprovedRow;
	}

	public WebElement getAssertApprovedOnTOC() {
		return assertApprovedOnTOC;
	}

	public WebElement getClkOpenCorrPen() {
		return clkOpenCorrPen;
	}

	public WebElement getAssertCorrPenNoTC1() {
		return assertCorrPenNoTC1;
	}

	public WebElement getClkReplaceBtn() {
		return clkReplaceBtn;
	}

	public WebElement getClkOpenNotAccepted() {
		return clkOpenNotAccepted;
	}

	public WebElement getAssertSearchedUser() {
		return assertSearchedUser;
	}

	public WebElement getAssertMyContent() {
		return assertMyContent;
	}

	public WebElement getAssertTnC() {
		return assertTnC;
	}

	public WebElement getAssertHelpCenter() {
		return assertHelpCenter;
	}

	public WebElement getAssertGoStarted() {
		return assertGoStarted;
	}

	public WebElement getAssertOrg() {
		return assertOrg;
	}

	public WebElement getAssertVDNLogo() {
		return assertVDNLogo;
	}

	public WebElement getAssertContentTypesPopUp() {
		return assertContentTypesPopUp;
	}

	public WebElement getAssertRejectOnTOC() {
		return assertRejectOnTOC;
	}

	public WebElement getClkUploadCont() {
		return clkUploadCont;
	}

	public WebElement getAssertMyContentTab() {
		return assertMyContentTab;
	}

	public WebElement getNominationConfMsg() {
		return nominationConfMsg;
	}


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

