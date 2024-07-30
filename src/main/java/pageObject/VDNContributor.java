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
	
	@FindBy(how=How.XPATH,using="//div[@class='d-flex fs-0-785 sb-color-gray-300 mb-15 pt-10 mt-10 sb-pageSection-document flex-jc-flex-end']")
	private WebElement  assertTitles;
	
	
	
	
	
	
	public WebElement getAssertTitles() {
		return assertTitles;
	}

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
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Epub']")
	private WebElement assertEpubUpload;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Mp3']")
	private WebElement assertMP3Upload;
	
	@FindBy(how=How.XPATH,using="//span[text()='My Content']")
	private WebElement clkMyContent;
	
	@FindBy(how=How.XPATH,using="//h4[text()=' Contribution Details']")
	private WebElement assertContributionDetails;
	
	@FindBy(how=How.XPATH,using="//div[text()=' K-12 framework']")
	private WebElement assertK12fwName;
	
	@FindBy(how=How.XPATH,using="//label[text()='Board']")
	private WebElement assertBoardMyContent;
	
	@FindBy(how=How.XPATH,using="//label[text()='Medium']")
	private WebElement assertMediumMyContent;
	
	@FindBy(how=How.XPATH,using="//label[text()='Class']")
	private WebElement assertClassMyContent;

	@FindBy(how=How.XPATH,using="//label[text()='Subject']")
	private WebElement assertSubjectMyContent;

	@FindBy(how=How.XPATH,using="//button[text()='Open']")
	private WebElement assertOpenBtnMyContent;
	
	@FindBy(how=How.XPATH,using="//label[@id='usernameLabel']")
	private WebElement assertEmailMob;
	
	@FindBy(how=How.XPATH,using="//label[@id='passwordLabel']")
	private WebElement assertPwd;
	
	
	@FindBy(how=How.XPATH,using="//div[text()='Forgot password?']")
	private WebElement assertForgotPwd;
	
	@FindBy(how=How.XPATH,using="//i[@class='close icon']//following::button[text()='Add Transcript']")
	private WebElement clkAddTranscriptbtn;
	
	@FindBy(how=How.XPATH,using="//div[text()='Add/Edit Transcript']")
	private WebElement assertAddorEditTrans;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Pdf']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingPDF;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Html']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingHTML;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Mp4']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingMP4;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Webm']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingWEBM;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_H5p']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingH5P;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Epub']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingEPUB;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Mp3']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingMP3;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Pdf']")
	private WebElement clkSamplePDF;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Pdf']//following::span[text()='Approved']")
	private WebElement assertPDFApproved;

	@FindBy(how=How.XPATH,using="//a[text()='View this content on DIKSHA']")
	private WebElement assertViewContOnDiksha;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Pdf-1']")
	private WebElement assertPDFUpdated;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Html-1']")
	private WebElement assertHTMLUpdated;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Mp4-1']")
	private WebElement assertMP4Updated;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Webm-1']")
	private WebElement assertWEBMUpdated;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_H5p-1']")
	private WebElement assertH5PUpdated;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Epub-1']")
	private WebElement assertEPUBUpdated;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Mp3-1']")
	private WebElement assertMP3Updated;
	
	@FindBy(how=How.XPATH,using="//a[text()='View Comments']")
	private WebElement assertViewComment;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Review Comments ']//following::div[text()=' Correct ']")
	private WebElement assertReviewComment;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Pdf']//following::span[text()='Corrections pending']")
	private WebElement clKPDFCorrPen;
	
	@FindBy(how=How.XPATH,using="(//span[text()=' Rejected:']//following::span[text()=' 1'])[1]")
	private WebElement assertRejectedCount;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Pdf']//following::span[text()='Rejected']")
	private WebElement assertPDFRejected;
	
	@FindBy(how=How.XPATH,using="//span[text()='Rejected']")
	private WebElement assertRejected;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Review Comments ']//following::div[text()=' Reject ']")
	private WebElement assertReviewReject;
	
	@FindBy(how=How.XPATH,using="//a[text()='Accessibility Details']")
	private WebElement AccessibilityDetailsBtn;
	
	@FindBy(how=How.XPATH,using="//div[text()='Accessibility']")
	private WebElement assertAccessibilityPopUp;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Cancel ']")
	private WebElement cancelBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Done ']")
	private WebElement DoneButton;
	
	@FindBy(how=How.XPATH,using="//sui-select[@formcontrolname='language']")
	private WebElement clkSelLanguage;
	
	@FindBy(how=How.XPATH,using="//span[text()='Assamese']")
	private WebElement clkSelAssamLanguage;
	
	@FindBy(how=How.XPATH,using="//i[@class='trash icon sb-color-primary']")
	private WebElement assetVTTFileUploaded;
	
	@FindBy(how=How.XPATH,using="//label[text()='Content Type(s)']")
	private WebElement assetContentTypes;
	
	@FindBy(how=How.XPATH,using="(//span[@class='font-weight-bold'])[2]")
	private WebElement getTotalCountTop;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Invalid file type (supported type: .vtt)']")
	private WebElement assertInvalidFileType;
	
	@FindBy(how=How.XPATH,using="(//td[text()=' Published']//following::button[text()='Open'])[1]")
	private WebElement clkOpenPublished;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Published on DIKSHA ']")
	private WebElement assertPublishedOnDiksha;
	
	@FindBy(how=How.XPATH,using="//a[text()='View this content on DIKSHA']")
	private WebElement clkViewContent;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Not Published on DIKSHA ']")
	private WebElement assertNotPublishedOnDiksha;
	
	@FindBy(how=How.XPATH,using="(//td[text()=' Not Published']//following::button[text()='Open'])[1]")
	private WebElement clkOpenNotPublished;
	
	@FindBy(how=How.XPATH,using="//label[text()='Create Question Sets Online']")
	private WebElement clkQSetOpt2;

	@FindBy(how=How.XPATH,using="//label[text()='MCQ - Practice Sets']")
	private WebElement clkMCQPracticeQSet;
	
	@FindBy(how=How.XPATH,using="(//span[@class='sb-card-title'])[1]")
	private WebElement QSetTemplate1;
	
	@FindBy(how=How.XPATH,using="(//button[contains(text(),'Submit')])[2]")
	private WebElement clkSubmitBtn;
	
	@FindBy(how=How.XPATH,using="//div[@aria-label='Rich Text Editor, main']")
	private WebElement Questionfield;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[2]")
	private WebElement Ans1field;

	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[3]")
	private WebElement Ans2field;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[4]")
	private WebElement Ans3field;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[5]")
	private WebElement Ans4field;
	
//	@FindBy(how=How.XPATH,using="(//label[text()='Mark as right answer'])[1]")
	@FindBy(how=How.XPATH,using="(//label[@for='check1'])[2]//preceding::input[@name='example']")
	private WebElement MarkCorrectAnsOpt1;
	
	@FindBy(how=How.XPATH,using="//div[text()='Choose type']")
	private WebElement clkChooseSolType;
	
	@FindBy(how=How.XPATH,using="//div[text()='Text+Image']")
	private WebElement ChooseSolType1;
	
	@FindBy(how=How.XPATH,using="(//div[@aria-label='Rich Text Editor, main'])[6]")
	private WebElement enterSol;
	
	@FindBy(how=How.XPATH,using="//button[text()='Preview']")
	private WebElement btnPreview;
	
	@FindBy(how=How.XPATH,using="//div[@value='1']")
	private WebElement clkAnsOpt2;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Navigate to Next']")
	private WebElement clkNext;
	
	@FindBy(how=How.XPATH,using="//button[text()='Solution']")
	private WebElement clkSoultion;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample_Question']//following::span[text()='Review Pending']")
	private WebElement clkQSetRevPen;
	
	@FindBy(how=How.XPATH,using="//button[text()='Add/Edit Transcript']")
	private WebElement clkBtnAddOrTran;
	
	@FindBy(how=How.XPATH,using="(//sui-select[@formcontrolname='language'])[2]")
	private WebElement clkSelLanguage2;
	
	@FindBy(how=How.XPATH,using="(//span[text()='Bengali'])[2]")
	private WebElement clkSelBengaliLanguage;
	
	@FindBy(how=How.XPATH,using="//i[@class='universal access icon ']")
	private WebElement clkAccessibility;
	
	@FindBy(how=How.XPATH,using="//div[text()='Video']")
	private WebElement ChooseSolType2;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Asset Successfully Uploaded...']")
	private WebElement assertVideoAdded;
	
	@FindBy(how=How.XPATH,using="//label[text()='SA - Short Answer']")
	private WebElement clkSAtype;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Done ']")
	private WebElement clkDone;
	
	
	
	
	
	
	public WebElement getClkDone() {
		return clkDone;
	}

	public WebElement getClkSAtype() {
		return clkSAtype;
	}

	public WebElement getAssertVideoAdded() {
		return assertVideoAdded;
	}

	public WebElement getChooseSolType2() {
		return ChooseSolType2;
	}

	public WebElement getClkAccessibility() {
		return clkAccessibility;
	}

	public WebElement getClkSelBengaliLanguage() {
		return clkSelBengaliLanguage;
	}

	public WebElement getClkSelLanguage2() {
		return clkSelLanguage2;
	}

	public WebElement getClkBtnAddOrTran() {
		return clkBtnAddOrTran;
	}

	public WebElement getClkQSetRevPen() {
		return clkQSetRevPen;
	}

	public WebElement getClkSoultion() {
		return clkSoultion;
	}

	public WebElement getClkNext() {
		return clkNext;
	}

	public WebElement getClkAnsOpt2() {
		return clkAnsOpt2;
	}

	public WebElement getBtnPreview() {
		return btnPreview;
	}

	public WebElement getEnterSol() {
		return enterSol;
	}

	public WebElement getChooseSolType1() {
		return ChooseSolType1;
	}

	public WebElement getClkChooseSolType() {
		return clkChooseSolType;
	}

	public WebElement getMarkCorrectAnsOpt1() {
		return MarkCorrectAnsOpt1;
	}

	public WebElement getAns4field() {
		return Ans4field;
	}
	
	public WebElement getAns3field() {
		return Ans3field;
	}
	
	public WebElement getAns2field() {
		return Ans2field;
	}
	
	
	public WebElement getAns1field() {
		return Ans1field;
	}

	public WebElement getQuestionfield() {
		return Questionfield;
	}

	public WebElement getClkSubmitBtn() {
		return clkSubmitBtn;
	}

	public WebElement getQSetTemplate1() {
		return QSetTemplate1;
	}

	public WebElement getClkMCQPracticeQSet() {
		return clkMCQPracticeQSet;
	}

	public WebElement getClkQSetOpt2() {
		return clkQSetOpt2;
	}

	public WebElement getClkOpenNotPublished() {
		return clkOpenNotPublished;
	}

	public WebElement getAssertNotPublishedOnDiksha() {
		return assertNotPublishedOnDiksha;
	}

	public WebElement getClkViewContent() {
		return clkViewContent;
	}

	public WebElement getAssertPublishedOnDiksha() {
		return assertPublishedOnDiksha;
	}

	public WebElement getClkOpenPublished() {
		return clkOpenPublished;
	}

	public WebElement getAssertInvalidFileType() {
		return assertInvalidFileType;
	}

	public WebElement getGetTotalCountTop() {
		return getTotalCountTop;
	}

	public WebElement getAssetContentTypes() {
		return assetContentTypes;
	}

	public WebElement getAssetVTTFileUploaded() {
		return assetVTTFileUploaded;
	}

	public WebElement getClkSelAssamLanguage() {
		return clkSelAssamLanguage;
	}

	public WebElement getClkSelLanguage() {
		return clkSelLanguage;
	}

	public WebElement getDoneButton() {
		return DoneButton;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getAssertAccessibilityPopUp() {
		return assertAccessibilityPopUp;
	}

	public WebElement getAccessibilityDetailsBtn() {
		return AccessibilityDetailsBtn;
	}

	public WebElement getAssertReviewReject() {
		return assertReviewReject;
	}

	public WebElement getAssertRejected() {
		return assertRejected;
	}

	public WebElement getAssertPDFRejected() {
		return assertPDFRejected;
	}

	public WebElement getAssertRejectedCount() {
		return assertRejectedCount;
	}

	public WebElement getclKPDFCorrPen() {
		return clKPDFCorrPen;
	}

	public WebElement getAssertReviewComment() {
		return assertReviewComment;
	}

	public WebElement getAssertViewComment() {
		return assertViewComment;
	}

	public WebElement getAssertMP3Updated() {
		return assertMP3Updated;
	}

	public WebElement getAssertEPUBUpdated() {
		return assertEPUBUpdated;
	}

	public WebElement getAssertH5PUpdated() {
		return assertH5PUpdated;
	}

	public WebElement getAssertWEBMUpdated() {
		return assertWEBMUpdated;
	}

	public WebElement getAssertMP4Updated() {
		return assertMP4Updated;
	}

	public WebElement getAssertHTMLUpdated() {
		return assertHTMLUpdated;
	}

	public WebElement getAssertPDFUpdated() {
		return assertPDFUpdated;
	}

	public WebElement getAssertViewContOnDiksha() {
		return assertViewContOnDiksha;
	}

	public WebElement getAssertPDFApproved() {
		return assertPDFApproved;
	}

	public WebElement getClkSamplePDF() {
		return clkSamplePDF;
	}

	public WebElement getAssertApprovalPendingMP3() {
		return assertApprovalPendingMP3;
	}

	public WebElement getAssertApprovalPendingEPUB() {
		return assertApprovalPendingEPUB;
	}

	public WebElement getAssertApprovalPendingH5P() {
		return assertApprovalPendingH5P;
	}

	public WebElement getAssertApprovalPendingWEBM() {
		return assertApprovalPendingWEBM;
	}

	public WebElement getAssertApprovalPendingMP4() {
		return assertApprovalPendingMP4;
	}

	public WebElement getAssertApprovalPendingHTML() {
		return assertApprovalPendingHTML;
	}

	public WebElement getAssertApprovalPendingPDF() {
		return assertApprovalPendingPDF;
	}

	public WebElement getAssertAddorEditTrans() {
		return assertAddorEditTrans;
	}

	public WebElement getClkAddTranscriptbtn() {
		return clkAddTranscriptbtn;
	}

	public WebElement getAssertForgotPwd() {
		return assertForgotPwd;
	}

	public WebElement getAssertPwd() {
		return assertPwd;
	}

	public WebElement getAssertEmailMob() {
		return assertEmailMob;
	}

	public WebElement getAssertOpenBtnMyContent() {
		return assertOpenBtnMyContent;
	}

	public WebElement getAssertSubjectMyContent() {
		return assertSubjectMyContent;
	}

	public WebElement getAssertClassMyContent() {
		return assertClassMyContent;
	}

	
	
	public WebElement getAssertMediumMyContent() {
		return assertMediumMyContent;
	}

	public WebElement getAssertBoardMyContent() {
		return assertBoardMyContent;
	}

	public WebElement getAssertK12fwName() {
		return assertK12fwName;
	}

	public WebElement getAssertContributionDetails() {
		return assertContributionDetails;
	}

	public WebElement getClkMyContent() {
		return clkMyContent;
	}

	public WebElement getAssertMP3Upload() {
		return assertMP3Upload;
	}

	public WebElement getAssertEpubUpload() {
		return assertEpubUpload;
	}

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

