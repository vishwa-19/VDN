package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class VDNObj {
	

	@FindBy(how=How.XPATH,using="//button[text()=' Create New Project']")
	private WebElement createNewBtn;
	
	@FindBy(how=How.XPATH,using="//label[text()='Get content targeted to Textbooks, Courses or other collections']")
	private WebElement projOpt1;


	@FindBy(how=How.XPATH,using="//span[text()='My Projects']")
	private WebElement myProjectTab;
	
	
	@FindBy(how=How.XPATH,using="//button[text()='Cancel']//preceding::button[1]")
	private WebElement clkbtn;
	
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter project name']")
	private WebElement enterProjectName;


	@FindBy(how=How.XPATH,using="//textarea[@placeholder='Enter project description']")
	private WebElement enterProjectDesc;


	@FindBy(how=How.XPATH,using="//input[@formcontrolname='nomination_enddate']")
	private WebElement nominationEndDate;
	


	@FindBy(how=How.XPATH,using="//input[@formcontrolname='shortlisting_enddate']")
	private WebElement shortlistEndDate;


	@FindBy(how=How.XPATH,using="(//i[@class='calendar icon date-calendar'])[3]")
	private WebElement clkcontributionEndDate;
	

	@FindBy(how=How.XPATH,using="//input[@formcontrolname='content_submission_enddate']")
	private WebElement contributionEndDate;

	@FindBy(how=How.XPATH,using="//input[@formcontrolname='enddate']")
	private WebElement enrollmentEndDate;
	
	
	@FindBy(how=How.XPATH,using="//button[text()='Next']")
	private WebElement clkNextButton;
	
	@FindBy(how=How.XPATH,using="//sui-multi-select[@formcontrolname='targetPrimaryCategories']")
	private WebElement clkContentTypes;
	
	@FindBy(how=How.XPATH,using="//span[text()='Course Assessment']")
	private WebElement selCourseAssesment;

	@FindBy(how=How.XPATH,using="//sui-select[@formcontrolname='target_collection_category']")
	private WebElement clkTargetCollectionCat;
	

	@FindBy(how=How.XPATH,using="//span[text()='Course']")
	private WebElement selCourse;

	@FindBy(how=How.XPATH,using="(//td[@class='collapsing'])[1]")
	private WebElement chooseTargetCollection;


	@FindBy(how=How.XPATH,using="//button[text()='Publish Project']")
	private WebElement clkPublishBtn;


	@FindBy(how=How.XPATH,using="//button[text()='Yes']")
	private WebElement clkConfirm;
	
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Select Content Types')]")
	private WebElement btnSelectContentTypes;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Select Content Types ']//following::div[2]")
	private WebElement selectContetCheckbox;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Submit')]")
	private WebElement clkbtnSelectedContent;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Selected Content type(s) saved successfully']")
	private WebElement assertSelectedCTMsg;
	
	@FindBy(how=How.XPATH,using="//button[text()='Upload Sample']//preceding::div[1]")
	private WebElement clkUploadCheckBox;
	
	@FindBy(how=How.XPATH,using="//button[text()='Nominate']")
	private WebElement nomitateBtn;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Submit')]")
	private WebElement submitPostNominate;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Nomination sent']")
	private WebElement assertNominationSent;
	
	@FindBy(how=How.XPATH,using="//a[text()='Nominations ']")
	private WebElement assertNominationTab;
	
	


	@FindBy(how=How.XPATH,using="//span[contains(text(),' Pending ')]//following::button[1]")
	private WebElement openUserAction;
	

	@FindBy(how=How.XPATH,using="//button[contains(text(),'Accept')]")
	private WebElement btnAccept;
	
	


	@FindBy(how=How.XPATH,using="//strong[text()='Nomination updated successfully...']")
	private WebElement assertNominationSuccess;
	
	
	@FindBy(how=How.XPATH,using="//span[text()='eTextbook']")
	private WebElement selEtextBook;


	@FindBy(how=How.XPATH,using="//span[text()='Explanation Content']")
	private WebElement selExplanationContent;


	@FindBy(how=How.XPATH,using="//span[text()='Learning Resource']")
	private WebElement selLearningResource;


	@FindBy(how=How.XPATH,using="//span[text()='Practice Question Set']")
	private WebElement selPQuestionSet;


	@FindBy(how=How.XPATH,using="//span[text()='Teacher Resource']")
	private WebElement selTeacherResource;
	
	@FindBy(how=How.XPATH,using="//a[text()='Courses ']")
	private WebElement asserCourse;
	

	@FindBy(how=How.XPATH,using="//a[text()='Nominations ']")
	private WebElement assertNominations;


	@FindBy(how=How.XPATH,using="//a[text()='Assign users to project ']")
	private WebElement assertAssignUsers;


	@FindBy(how=How.XPATH,using="//a[text()=' Contribution Dashboard ']")
	private WebElement assertContribution;


	@FindBy(how=How.XPATH,using="//a[text()=' Reports ']")
	private WebElement assertReport;
	
	@FindBy(how=How.XPATH,using="//button[text()='Reject']")
	private WebElement btnReject;
	
	@FindBy(how=How.XPATH,using="//textarea[@placeholder='Add comment']")
	private WebElement enterCommentForReject;
	
	
	@FindBy(how=How.XPATH,using="//button[text()=' Submit ']")
	private WebElement rejectSubmit;
	
	@FindBy(how=How.XPATH,using="//label[text()='From your organization only']")
	private WebElement selYourOrgOnly;
	
	@FindBy(how=How.XPATH,using="//span[text()='Digital Textbook']")
	private WebElement selDigitalTextBook;
	
	@FindBy(how=How.XPATH,using="//button[text()='Select Content Types']")
	private WebElement selContentTypesbtn;


	@FindBy(how=How.XPATH,using="//label[contains(text(),'Course Assessment')]")
	private WebElement checkCorseAssesment;
	
	

	@FindBy(how=How.XPATH,using="//label[contains(text(),'eTextbook')]")
	private WebElement checkETextBook;


	@FindBy(how=How.XPATH,using="//label[contains(text(),'Explanation Content')]")
	private WebElement checkEContent;
	
	


	@FindBy(how=How.XPATH,using="//label[contains(text(),'Learning Resource')]")
	private WebElement checkLearningRes;


	@FindBy(how=How.XPATH,using="//label[contains(text(),'Practice Question Set')]")
	private WebElement checkQuestionSet;
	

	@FindBy(how=How.XPATH,using="//label[contains(text(),'Teacher Resource')]")
	private WebElement checkTeachingRes;


	@FindBy(how=How.XPATH,using="//button[contains(text(),'Submit')]")
	private WebElement submitBtn;


	@FindBy(how=How.XPATH,using="//button[text()='Upload Sample']")
	private WebElement uploadSampleBtn;
	
	@FindBy(how=How.XPATH,using="//p[text()='Pending']")
	private WebElement assertPendingStatus;


	@FindBy(how=How.XPATH,using="//div[text()='Digital Textbooks']")
	private WebElement assertDigiTextbooks;
	
	@FindBy(how=How.XPATH,using="//span[text()='My Projects']")
	private WebElement clkMyProject;
	
	@FindBy(how=How.XPATH,using="//div[text()='Assign users to project']")
	private WebElement asserAssignUsers;
	
	@FindBy(how=How.XPATH,using="//b[text()='Project published successfully!']")
	private WebElement assertProjectPublished;
	
	@FindBy(how=How.XPATH,using="//a[text()='Digital Textbooks ']")
	private WebElement assertDigiTextBooks;
	
	@FindBy(how=How.XPATH,using="//div[text()=' EKSTEP ']")
	private WebElement assertPreApprovedOrgName;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Approved ']")
	private WebElement assertPreApprovedStatus;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search...']")
	private WebElement SearchField;
	
	@FindBy(how=How.XPATH,using="//button[text()='Search']")
	private WebElement SearchBtn;
	
	@FindBy(how=How.XPATH,using="//option[text()=' Select Role ']")
	private WebElement selectRolePostSearch;
	
	@FindBy(how=How.XPATH,using="//option[text()=' REVIEWER ']")
	private WebElement selectReviewerPostSearch;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Roles updated...']")
	private WebElement rolesUpdatedMsg;
	
	@FindBy(how=How.XPATH,using="//i[@class='close icon']")
	private WebElement closeIcon;
	
	@FindBy(how=How.XPATH,using="//th[contains(text(),'User Name')]//following::td[1]")
	private WebElement assertReviewerOnTop;
	
	@FindBy(how=How.XPATH,using="//option[text()=' CONTRIBUTOR ']")
	private WebElement selectContributorPostSearch;



	@FindBy(how=How.XPATH,using="//option[text()=' BOTH ']")
	private WebElement selectBothPostSearch;
	
	@FindBy(how=How.XPATH,using="//label[text()='Get individual content not targeted to any collection']")
	private WebElement ProjOpt3;
	
	@FindBy(how=How.XPATH,using="//a[text()='For individual content not for any collection ']")
	private WebElement clkTargetCollection;
	
	
	@FindBy(how=How.XPATH,using="//button[text()='Upload Content']")
	private WebElement clkUploadbtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='Create new ']")
	//@FindBy(how=How.XPATH,using="//span[contains(text(),' Chapter')]//following::button[2]")
	
	private WebElement clkCreateNew;
	
	@FindBy(how=How.XPATH,using="//div[text()='Course Assessment']")
	private WebElement selCourseAssessment;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Continue ']")
	private WebElement continueBtn;
	
	@FindBy(how=How.XPATH,using="//span[text()='All Projects']")
	private WebElement allProjectsTab;
	
	@FindBy(how=How.XPATH,using="//div[text()='eTextbook']")
	private WebElement seltextBook;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Back ']")
	private WebElement backBtn;
	
	@FindBy(how=How.XPATH,using="//a[text()='Content Details']")
	private WebElement contentDetails;
	
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Name']")
	private WebElement enterName;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter Copyright and Year']")
	private WebElement enterYear;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Save')]")
	private WebElement saveBtn;
	
	@FindBy(how=How.XPATH,using="//strong[contains(text(),'Content updated successfully')]")
	private WebElement ContentSavedtMessage;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample1']//following::span[text()='Draft']")
	private WebElement assertDraft;
	
	@FindBy(how=How.XPATH,using="//button[text()='Submit for review']")
	private WebElement submitForReviewBtn;
	
	@FindBy(how=How.XPATH,using="//input[@id='content-policy-check']")
	private WebElement clkCheckBox;
	
	@FindBy(how=How.XPATH,using="//button[text()='Submit']")
	private WebElement clkSubmit;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample1']")
	private WebElement selectSample1;
	
	
	@FindBy(how=How.XPATH,using="//span[text()='Approval Pending']")
	private WebElement assertApprovalPending;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample1']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingOnTOC;
	
	@FindBy(how=How.XPATH,using="//strong[contains(text(),'Content accepted successfully')]")
	private WebElement contentAcceptedMsg;
	
	@FindBy(how=How.XPATH,using="//label[text()='Subject']//following::sb-dynamic-checkbox")
	private WebElement clkCheckBox1;
	
	
	@FindBy(how=How.XPATH,using="//button[text()='Create/Upload Sample']")
	private WebElement clkUploadSample;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Content Successfully Uploaded...']")
	private WebElement assertContentUpload;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Content sent for review']")
	private WebElement assertContentSetReview;
	
	@FindBy(how=How.XPATH,using="(//button[text()='Submit'])[2]")
	private WebElement clkPostSubmit;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),' Pending ')]")
	private WebElement assertPending;
	
	@FindBy(how=How.XPATH,using="//label[text()='Skip two - level Review']")
	private WebElement clkSkipReview;
	
	@FindBy(how=How.XPATH,using="//span[text()='Skip two level review enabled']")
	private WebElement assertSkipReviewEnabled;
	
	
	@FindBy(how=How.XPATH,using="//div[@class='ui container p-0 m-0 d-flex flex-ai-center flex-jc-center']")
	private WebElement assertTabs;
	
	
	@FindBy(how=How.XPATH,using="//span[text()='My Content']")
	private WebElement clkMyContent;
	
	@FindBy(how=How.XPATH,using="//h3[text()=' My Content']")
	private WebElement assertMyContentHeader;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Total Contributed ']")
	private WebElement assertTotalContributed;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Published on DIKSHA ']")
	private WebElement assertPublishedOnDiksha;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Not Published on DIKSHA']")
	private WebElement assertNotPublishedOnDiksha;

	@FindBy(how=How.XPATH,using="//label[text()='EKSTEP']//following::a[text()='Contribute'][1]")
	private WebElement clkTenentCard;

	@FindBy(how=How.XPATH,using="//button[text()='Save as Draft']")
	private WebElement btnSaveAsDraft;
	
	@FindBy(how=How.XPATH,using="//b[text()='Project saved as draft successfully!']")
	private WebElement assertProjectSaved;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Yes ']")
	private WebElement confirmDeletion;
	
	@FindBy(how=How.XPATH,using="//strong[text()='The project has been deleted successfully.']")
	private WebElement assertDeleteMsg;
	
	@FindBy(how=How.XPATH,using="//td[contains(text(),'Sample1')]//following::button[1]")
	private WebElement clkOpenSample;
	
	@FindBy(how=How.XPATH,using="//div[text()='Sample1 ']")
	private WebElement assertSample;
	
	@FindBy(how=How.XPATH,using="//a[text()='Content Details']")
	private WebElement assertSampleContentDetails;
	
	@FindBy(how=How.XPATH,using="//a[text()='My Projects']")
	private WebElement MyProjects;
	
	@FindBy(how=How.XPATH,using="(//div[text()=' Total'])[1]")
	private WebElement assertTotalTab1;
	
	
	@FindBy(how=How.XPATH,using="//div[text()=' Approval Pending']")
	private WebElement assertApprovalPendingTab;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Approved']")
	private WebElement assertApprovedTab;
	
	
	@FindBy(how=How.XPATH,using="//div[text()=' Rejected']")
	private WebElement assertRejectedTab;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Corrections pending']")
	private WebElement assertCorrectionTab;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),' Approval Pending')]//following::button[1]")
	private WebElement clkOpenBtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='Publish']")
	private WebElement clkPublish;
	
	
	@FindBy(how=How.XPATH,using="//button[text()=' Download Nominations List']")
	private WebElement assertNomimnationList;
	
	//th[contains(text(),'Contributor Name')]
	
	//th[contains(text(),'Type')]
	
	//th[contains(text(),'Digital Textbooks')]
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Upload Content')]")
	private WebElement clkUploadContent;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Review Pending')]//following::button[1]")
	private WebElement clkOpenReviePending;
	
	@FindBy(how=How.XPATH,using="//span[text()='Review Pending']")
	private WebElement assertReviewPending;
	
	@FindBy(how=How.XPATH,using="//div[@class='d-flex flex-ai-center flex-jc-space-between practical-header__content w-100']")
	private WebElement assertAllReviewContentHead;
	
	
	@FindBy(how=How.XPATH,using="//button[text()='Review Content']")
	private WebElement clkReviewContent;
	
	@FindBy(how=How.XPATH,using="//span[text()='Review Pending']//following::button[text()='Open']")
	private WebElement clkOpenBtnReview;
	
	@FindBy(how=How.XPATH,using="//button[text()='Submit for Approval']")
	private WebElement clkSubmitForApproval;
	
	@FindBy(how=How.XPATH,using="//button[text()='Request changes ']")
	private WebElement clkRequestChanges;
	
	@FindBy(how=How.XPATH,using="//div[text()='Edit details']")
	private WebElement assertEditDetails;
	
	@FindBy(how=How.XPATH,using="//div[@class='nine wide column pl-20']")
	private WebElement assertContnts;
	
	@FindBy(how=How.XPATH,using="//label[text()='From a selected set of contributors']")
	private WebElement clkSelectedContributors;
	
	@FindBy(how=How.XPATH,using="//span[text()='Select Contributors']")
	private WebElement clkSelectContributors;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search by user name/ Organisation name']")
	private WebElement enterOrgName;
	
	@FindBy(how=How.XPATH,using="(//div[@class='sb-checkbox sb-checkbox-primary'])[2]")
	private WebElement selectOrg;
	
	@FindBy(how=How.XPATH,using="//button[text()='Save']")
	private WebElement clkSaveButton;
	
	@FindBy(how=How.XPATH,using="//a[text()='Manage Users']")
	private WebElement clkManageUsers;
	
	@FindBy(how=How.XPATH,using="//option[text()=' User ']")
	private WebElement clkSelectUsers;

	@FindBy(how=How.XPATH,using="//option[text()=' Admin ']")
	private WebElement clkSelectAdmin;
	
	
	@FindBy(how=How.XPATH,using="//select[@class='custom-selectbx ng-valid ng-dirty ng-touched']")
	private WebElement selectOptions;
	
	
	
	@FindBy(how=How.XPATH,using="//strong[text()='Role updated successfully']")
	private WebElement assertRolesUpdatedSuccess;
	
	@FindBy(how=How.XPATH,using="//p[text()='Initiated']")
	private WebElement assertStatusInitiate;
	
	
	@FindBy(how=How.XPATH,using="//label[text()='Contributor Type ']//following::sui-select")
	private WebElement clkContributionType;
	
	@FindBy(how=How.XPATH,using="//span[text()='Individual']")
	private WebElement selIndividual;
	
	@FindBy(how=How.XPATH,using="//button[text()='Update']")
	private WebElement clkUpdateBtn;
	
	
	@FindBy(how=How.XPATH,using="//strong[text()='The project has been modified successfully.']")
	private WebElement assertModify;
	
	@FindBy(how=How.XPATH,using="//strong[text()='The project has been closed successfully.']")
	private WebElement assertClose;
	
	@FindBy(how=How.XPATH,using="//span[text()='Draft:']")
	private WebElement assertDraftNode;


	@FindBy(how=How.XPATH,using="//span[text()='Draft:']//following::span[1]")
	private WebElement assertDraftCount;
	
	
	@FindBy(how=How.XPATH,using="//span[text()='Review Pending:']")
	private WebElement ReviewPendingNode;


	@FindBy(how=How.XPATH,using="//span[text()='Review Pending:']//following::span[1]")
	private WebElement assertReviewPendingCount;
	
	@FindBy(how=How.XPATH,using="//span[text()='Total Content:']")
	private WebElement TotalNode;


	@FindBy(how=How.XPATH,using="//span[text()='Total Content:']//following::span[1]")
	private WebElement TotalCount;
	
	@FindBy(how=How.XPATH,using="//button[text()='Review Content']")
	private WebElement clkReviewContentBtn;
	
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample2']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPendingTOC;
	
	@FindBy(how=How.XPATH,using="//span[text()='color1']")
	private WebElement AssertReviewPendingOrProcessing;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Submit Review ']")
	private WebElement clkSubmitRevBtn;
	
	
	@FindBy(how=How.XPATH,using="//span[text()=' Rejected:']")
	private WebElement assertRejectedOnTOC;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Rejected:']//following::span[1]")
	private WebElement assertRejectedCount;
	
	@FindBy(how=How.XPATH,using="//span[text()='Total Content:']")
	private WebElement assertTotalContOnTOC;
	
	

	@FindBy(how=How.XPATH,using="//span[text()='Total Content:']//following::span[1]")
	private WebElement assertTotalContCount;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample2']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPending2OnTOC;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample3']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPending3OnTOC;
	
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample4']//following::span[text()='Approval Pending']")
	private WebElement assertApprovalPending4OnTOC;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample2']")
	private WebElement selectSample2;
	

	@FindBy(how=How.XPATH,using="//span[text()=' Sample3']")
	private WebElement selectSample3;
	

	@FindBy(how=How.XPATH,using="//span[text()=' Sample4']")
	private WebElement selectSample4;
	
	@FindBy(how=How.XPATH,using="//button[text()='Send back for corrections']")
	private WebElement BtnSendCorrect;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Content sent for corrections']")
	private WebElement assertContentCorrection;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Approved:']")
	private WebElement assertApprovedTabs;
	
	
	@FindBy(how=How.XPATH,using="//span[text()=' Approved:']//following::span[1]")
	private WebElement ApprovedTabCount;
	
	
	@FindBy(how=How.XPATH,using="//span[text()=' Corrections pending:']")
	private WebElement correctionsPenTOC;
	
	

	@FindBy(how=How.XPATH,using="//span[text()=' Corrections pending:']//following::span[1]")
	private WebElement correctionsPenCount;
	
	
	@FindBy(how=How.XPATH,using="//span[text()='Approval Pending:']")
	private WebElement ApprovalPenNode;


	@FindBy(how=How.XPATH,using="//span[text()='Approval Pending:']//following::span[1]")
	private WebElement ApprovalPenCount;
	
	@FindBy(how=How.XPATH,using="//span[text()='Content Playlist']")
	private WebElement selContentPlay;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'View Sample Content')]")
	private WebElement viewSampleBtn;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'View Sample Content')]//preceding::td[1]")
	private WebElement assertSampleCount1;
	
	@FindBy(how=How.XPATH,using="//i[@class='icon close']")
	private WebElement closeEditDetail;
	
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Upload Content')]")
	private WebElement clkUploadfromBothRole;
	
	@FindBy(how=How.XPATH,using="//span[text()='rating2']//following::span[text()='Review Pending']")
	private WebElement assertRevPending2;
	
	
	
	@FindBy(how=How.XPATH,using="//span[text()='rating2']//following::span[text()='Review Pending']//following::button[1]")
	private WebElement OpenOwnContent;
	
//	@FindBy(how=How.XPATH,using="//button[contains(text(),'Reject')]")
//	private WebElement btnReject;
	
	@FindBy(how=How.XPATH,using="//span[text()=' Sample1']//following::span[text()='Approved']")
	private WebElement assertApprovedContent;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Approval Pending')]//following::button[1]")
	private WebElement clkOpenBtnOnNoTC;
	
	@FindBy(how=How.XPATH,using="//div[text()=' Sample1 ']//following::span[text()='Approved']")
	private WebElement assertApprovedNoTC;
	
	
	@FindBy(how=How.XPATH,using="//div[text()=' Sample1 ']//following::span[text()='Rejected']")
	private WebElement assertRejectNoTC;
	
	
	@FindBy(how=How.XPATH,using="//div[text()=' Sample1 ']//following::span[text()='Corrections pending']")
	private WebElement assertCorrPenNoTC;
	
	@FindBy(how=How.XPATH,using="//button[text()='Create/Upload Content']")
	private WebElement clkCreateOrUploadBtn;
	
	
	@FindBy(how=How.XPATH,using="//td[text()=' Sample1 ']//following::span[text()='Draft']")
	private WebElement assertSaveAsDraftNoTC;
	
	@FindBy(how=How.XPATH,using="//span[text()='Review Pending']//following::button[text()='Open']")
	private WebElement clkOpenBtnNoRC;
	
	@FindBy(how=How.XPATH,using="//span[text()='Not Accepted']")
	private WebElement assertNotAcceptedOnRC;
	
	@FindBy(how=How.XPATH,using="//*[text()='Get content targeted to Question Sets']")
	private WebElement projectOption2;
	
	@FindBy(how=How.XPATH,using="(//a[text()='Nominations ']//following::span[1])[1]")
	private WebElement assertNomCount;
	
	
	
	
	
	
	public WebElement getAssertNomCount() {
		return assertNomCount;
	}


	public WebElement getProjectOption2() {
		return projectOption2;
	}
	
	
	public WebElement getAssertNotAcceptedOnRC() {
		return assertNotAcceptedOnRC;
	}






	public WebElement getClkOpenBtnNoRC() {
		return clkOpenBtnNoRC;
	}






	public WebElement getAssertSaveAsDraftNoTC() {
		return assertSaveAsDraftNoTC;
	}






	public WebElement getClkCreateOrUploadBtn() {
		return clkCreateOrUploadBtn;
	}






	public WebElement getassertCorrPenNoTC() {
		return assertCorrPenNoTC;
	}
	
	
	
	
	
	
	public WebElement getassertRejectNoTC() {
		return assertRejectNoTC;
	}
	
	
	
	
	
	public WebElement getAssertApprovedNoTC() {
		return assertApprovedNoTC;
	}


	public WebElement getClkOpenBtnOnNoTC() {
		return clkOpenBtnOnNoTC;
	}


	public WebElement getAssertApprovedContent() {
		return assertApprovedContent;
	}


	public WebElement getOpenOwnContent() {
		return OpenOwnContent;
	}


	public WebElement getAssertRevPending2() {
		return assertRevPending2;
	}


	public WebElement getClkUploadfromBothRole() {
		return clkUploadfromBothRole;
	}


	public WebElement getCloseEditDetail() {
		return closeEditDetail;
	}


	public WebElement getAssertSampleCount1() {
		return assertSampleCount1;
	}


	public WebElement getViewSampleBtn() {
		return viewSampleBtn;
	}


	public WebElement getSelContentPlay() {
		return selContentPlay;
	}


	public WebElement getApprovalPenNode() {
		return ApprovalPenNode;
	}
	
	
	public WebElement getApprovalPenCount() {
		return ApprovalPenCount;
	}



	public WebElement getCorrectionsPenTOC() {
		return correctionsPenTOC;
	}
	
	
	
	public WebElement getCorrectionsPenCount() {
		return correctionsPenCount;
	}


	public WebElement getApprovedTabCount() {
		return ApprovedTabCount;
	}


	public WebElement getAssertApprovedTabs() {
		return assertApprovedTabs;
	}


	public WebElement getAssertContentCorrection() {
		return assertContentCorrection;
	}


	public WebElement getBtnSendCorrect() {
		return BtnSendCorrect;
	}


	public WebElement getSelectSample2() {
		return selectSample2;
	}
	
	
	public WebElement getSelectSample3() {
		return selectSample3;
	}
	
	
	
	public WebElement getSelectSample4() {
		return selectSample4;
	}


	public WebElement getAssertApprovalPending3OnTOC() {
		return assertApprovalPending3OnTOC;
	}

	
	public WebElement getAssertApprovalPending4OnTOC() {
		return assertApprovalPending4OnTOC;
	}

	@FindBy(how=How.XPATH,using="//div[text()='Teacher Resource']")
	private WebElement selTeacherRes;
	
	
	
	
	public WebElement getSelTeacherRes() {
		return selTeacherRes;
	}



	public WebElement getAssertApprovalPending2OnTOC() {
		return assertApprovalPending2OnTOC;
	}



	public WebElement getAssertTotalContOnTOC() {
		return assertTotalContOnTOC;
	}

	
	
	public WebElement getAssertTotalContCount() {
		return assertTotalContCount;
	}


	public WebElement getAssertRejectedCount() {
		return assertRejectedCount;
	}


	public WebElement getAssertRejectedOnTOC() {
		return assertRejectedOnTOC;
	}


	public WebElement getClkSubmitRevBtn() {
		return clkSubmitRevBtn;
	}


	public WebElement getAssertReviewPendingOrProcessing() {
		return AssertReviewPendingOrProcessing;
	}


	public WebElement getAssertApprovalPendingTOC() {
		return assertApprovalPendingTOC;
	}


	public WebElement getClkReviewContentBtn() {
		return clkReviewContentBtn;
	}


	public WebElement getTotalNode() {
		return TotalNode;
	}
	
	
	public WebElement getTotalCount() {
		return TotalCount;
	}

	public WebElement getReviewPendingNode() {
		return ReviewPendingNode;
	}

	public WebElement getAssertReviewPendingCount() {
		return assertReviewPendingCount;
	}

	public WebElement getAssertDraftNode() {
		return assertDraftNode;
	}
	
	public WebElement getAssertDraftCount() {
		return assertDraftCount;
	}


	public WebElement getAssertClose() {
		return assertClose;
	}


	public WebElement getAssertModify() {
		return assertModify;
	}


	public WebElement getClkUpdateBtn() {
		return clkUpdateBtn;
	}


	public WebElement getSelIndividual() {
		return selIndividual;
	}


	public WebElement getClkContributionType() {
		return clkContributionType;
	}


	public WebElement getAssertStatusInitiate() {
		return assertStatusInitiate;
	}


	public WebElement getAssertRolesUpdatedSuccess() {
		return assertRolesUpdatedSuccess;
	}


	public WebElement getSelectOptions() {
		return selectOptions;
	}


	public WebElement getClkSelectUsers() {
		return clkSelectUsers;
	}
	
	
	public WebElement getClkSelectAdmin() {
		return clkSelectAdmin;
	}

	public WebElement getClkManageUsers() {
		return clkManageUsers;
	}

	public WebElement getClkSaveButton() {
		return clkSaveButton;
	}

	public WebElement getSelectOrg() {
		return selectOrg;
	}

	public WebElement getEnterOrgName() {
		return enterOrgName;
	}

	public WebElement getClkSelectContributors() {
		return clkSelectContributors;
	}

	public WebElement getClkSelectedContributors() {
		return clkSelectedContributors;
	}

	public WebElement getAssertContnts() {
		return assertContnts;
	}

	public WebElement getAssertEditDetails() {
		return assertEditDetails;
	}

	public WebElement getClkSubmitForApproval() {
		return clkSubmitForApproval;
	}
	
    public WebElement getClkRequestChanges() {
		return clkRequestChanges;
	}

	public WebElement getClkOpenBtnReview() {
		return clkOpenBtnReview;
	}

	public WebElement getClkReviewContent() {
		return clkReviewContent;
	}

	public WebElement getAssertAllReviewContentHead() {
		return assertAllReviewContentHead;
	}

	public WebElement getAssertReviewPending() {
		return assertReviewPending;
	}

	public WebElement getClkOpenReviePending() {
		return clkOpenReviePending;
	}

	public WebElement getClkUploadContent() {
		return clkUploadContent;
	}

	public WebElement getAssertNomimnationList() {
		return assertNomimnationList;
	}

	public WebElement getClkPublish() {
		return clkPublish;
	}

	public WebElement getClkOpenBtn() {
		return clkOpenBtn;
	}

	public WebElement getAssertCorrectionTab() {
		return assertCorrectionTab;
	}

	public WebElement getAssertRejectedTab() {
		return assertRejectedTab;
	}

	public WebElement getAssertApprovedTab() {
		return assertApprovedTab;
	}

	public WebElement getAssertApprovalPendingTab() {
		return assertApprovalPendingTab;
	}

	public WebElement getAssertTotalTab1() {
		return assertTotalTab1;
	}

	public WebElement getMyProjects() {
		return MyProjects;
	}

	public WebElement getAssertSampleContentDetails() {
		return assertSampleContentDetails;
	}

	public WebElement getAssertSample() {
		return assertSample;
	}

	public WebElement getClkOpenSample() {
		return clkOpenSample;
	}

	public WebElement getAssertDeleteMsg() {
		return assertDeleteMsg;
	}

	public WebElement getConfirmDeletion() {
		return confirmDeletion;
	}

	public WebElement getAssertProjectSaved() {
		return assertProjectSaved;
	}

	public WebElement getBtnSaveAsDraft() {
		return btnSaveAsDraft;
	}

	public WebElement getClkTenentCard() {
		return clkTenentCard;
	}

	public WebElement getAssertNotPublishedOnDiksha() {
		return assertNotPublishedOnDiksha;
	}

	public WebElement getAssertPublishedOnDiksha() {
		return assertPublishedOnDiksha;
	}

    public WebElement getAssertTotalContributed() {
		return assertTotalContributed;
	}
    
	public WebElement getAssertMyContentHeader() {
		return assertMyContentHeader;
	}

	public WebElement getClkMyContent() {
		return clkMyContent;
	}

	public WebElement getAssertTabs() {
		return assertTabs;
	}

	public WebElement getAssertSkipReviewEnabled() {
		return assertSkipReviewEnabled;
	}

	public WebElement getClkSkipReview() {
		return clkSkipReview;
	}
	
	public WebElement getAssertPending() {
		return assertPending;
	}


	public WebElement getClkPostSubmit() {
		return clkPostSubmit;
	}


	public WebElement getAssertContentSetReview() {
		return assertContentSetReview;
	}


	public WebElement getAssertContentUpload() {
		return assertContentUpload;
	}


	public WebElement getClkUploadSample() {
		return clkUploadSample;
	}


	public WebElement getClkCheckBox1() {
		return clkCheckBox1;
	}


	public WebElement getContentAcceptedMsg() {
		return contentAcceptedMsg;
	}


	public WebElement getAssertApprovalPendingOnTOC() {
		return assertApprovalPendingOnTOC;
	}


	public WebElement getAssertApprovalPending() {
		return assertApprovalPending;
	}


	public WebElement getSelectSample1() {
		return selectSample1;
	}


	public WebElement getClkSubmit() {
		return clkSubmit;
	}


	public WebElement getClkCheckBox() {
		return clkCheckBox;
	}


	public WebElement getSubmitForReviewBtn() {
		return submitForReviewBtn;
	}


	public WebElement getAssertDraft() {
		return assertDraft;
	}


	public WebElement getContentSavedtMessage() {
		return ContentSavedtMessage;
	}

	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getEnterYear() {
		return enterYear;
	}

	public WebElement getEnterName() {
		return enterName;
	}

	public WebElement getContentDetails() {
		return contentDetails;
	}

	public WebElement getBackBtn() {
		return backBtn;
	}

	public WebElement getSeltextBook() {
		return seltextBook;
	}

	public WebElement getAllProjectsTab() {
		return allProjectsTab;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getSelCourseAssessment() {
		return selCourseAssessment;
	}

	public WebElement getClkCreateNew() {
		return clkCreateNew;
	}

	public WebElement getClkUploadbtn() {
		return clkUploadbtn;
	}

	public WebElement getClkTargetCollection() {
		return clkTargetCollection;
	}

	public WebElement getProjOpt3() {
		return ProjOpt3;
	}

	public WebElement getSelectContributorPostSearch() {
		return selectContributorPostSearch;
	}

	public WebElement getSelectBothPostSearch() {
		return selectBothPostSearch;
	}


	public WebElement getAssertReviewerOnTop() {
		return assertReviewerOnTop;
	}


	public WebElement getCloseIcon() {
		return closeIcon;
	}


	public WebElement getRolesUpdatedMsg() {
		return rolesUpdatedMsg;
	}


	public WebElement getSelectReviewerPostSearch() {
		return selectReviewerPostSearch;
	}


	public WebElement getSelectRolePostSearch() {
		return selectRolePostSearch;
	}


	public WebElement getSearchBtn() {
		return SearchBtn;
	}


	public WebElement getSearchField() {
		return SearchField;
	}


	public WebElement getAssertPreApprovedStatus() {
		return assertPreApprovedStatus;
	}


	public WebElement getAssertPreApprovedOrgName() {
		return assertPreApprovedOrgName;
	}


	public WebElement getAssertDigiTextBooks() {
		return assertDigiTextBooks;
	}


	public WebElement getAssertProjectPublished() {
		return assertProjectPublished;
	}


	public WebElement getAsserAssignUsers() {
		return asserAssignUsers;
	}


	public WebElement getClkMyProject() {
		return clkMyProject;
	}


	public WebElement getAssertPendingStatus() {
		return assertPendingStatus;
	}
	
	
	public WebElement getAssertDigiTextbooks() {
		return assertDigiTextbooks;
	}

	public WebElement getSelContentTypesbtn() {
		return selContentTypesbtn;
	}
	
	public WebElement getCheckCorseAssesment() {
		return checkCorseAssesment;
	}

	
	public WebElement getCheckETextBook() {
		return checkETextBook;
	}
	
	public WebElement getCheckLearningRes() {
		return checkLearningRes;
	}
	
	public WebElement getCheckQuestionSet() {
		return checkQuestionSet;
	}
	
	public WebElement getCheckEContent() {
		return checkEContent;
	}
	
	public WebElement getCheckTeachingRes() {
		return checkTeachingRes;
	}
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	
	public WebElement getUploadSampleBtn() {
		return uploadSampleBtn;
	}


	public WebElement getSelDigitalTextBook() {
		return selDigitalTextBook;
	}


	public WebElement getSelYourOrgOnly() {
		return selYourOrgOnly;
	}


	public WebElement getRejectSubmit() {
		return rejectSubmit;
	}


	public WebElement getEnterCommentForReject() {
		return enterCommentForReject;
	}


	public WebElement getBtnReject() {
		return btnReject;
	}


	public WebElement getAsserCourse() {
		return asserCourse;
	}

	
	public WebElement getAssertNominations() {
		return assertNominations;
	}
	
	public WebElement getAssertAssignUsers() {
		return assertAssignUsers;
	}
	
	
	public WebElement getAssertContribution() {
		return assertContribution;
	}
	
	
	public WebElement getAssertReport() {
		return assertReport;
	}


	public WebElement getSelEtextBook() {
		return selEtextBook;
	}
	
	
	public WebElement getSelExplanationContent() {
		return selExplanationContent;
	}
	
	
	public WebElement getSelLearningResource() {
		return selLearningResource;
	}
	
	
	public WebElement getSelPQuestionSet() {
		return selPQuestionSet;
	}
	
	public WebElement getSelTeacherResource() {
		return selTeacherResource;
	}

	public WebElement getBtnAccept() {
		return btnAccept;
	}
	
	public WebElement getAssertNominationSuccess() {
		return assertNominationSuccess;
	}

	public WebElement getOpenUserAction() {
		return openUserAction;
	}
	
	public WebElement getAssertNominationTab() {
		return assertNominationTab;
	}
	
	
	
	

	public WebElement getAssertNominationSent() {
		return assertNominationSent;
	}


	public WebElement getSubmitPostNominate() {
		return submitPostNominate;
	}


	public WebElement getNomitateBtn() {
		return nomitateBtn;
	}


	public WebElement getClkUploadCheckBox() {
		return clkUploadCheckBox;
	}


	public WebElement getAssertSelectedCTMsg() {
		return assertSelectedCTMsg;
	}


	public WebElement getClkbtnSelectedContent() {
		return clkbtnSelectedContent;
	}


	public WebElement getSelectContetCheckbox() {
		return selectContetCheckbox;
	}


	public WebElement getBtnSelectContentTypes() {
		return btnSelectContentTypes;
	}


	public WebElement getClkNextButton() {
		return clkNextButton;
	}


	public WebElement getMyProjectTab() {
		return myProjectTab;
	}


	public WebElement getCreateNewBtn() {
		return createNewBtn;
	}
	
	
	public WebElement getProjOpt1() {
		return projOpt1;
	}
	
	
	public WebElement getClkbtn() {
		return clkbtn;
	}
	
	
	public WebElement getEnterProjectName() {
		return enterProjectName;
	}
	
	
	public WebElement getEnterProjectDesc() {
		return enterProjectDesc;
	}
	
	public WebElement getNominationEndDate() {
		return nominationEndDate;
	}
	
	public WebElement getShortlistEndDate() {
		return shortlistEndDate;
	}
	
	public WebElement getContributionEndDate() {
		return contributionEndDate;
	}

	
	public WebElement getClkcontributionEndDate() {
		return clkcontributionEndDate;
	}
	
	public WebElement getEnrollmentEndDate() {
		return enrollmentEndDate;
	}
	
	
	public WebElement getClkContentTypes() {
		return clkContentTypes;
	}
	
	public WebElement getSelCourseAssesment() {
		return selCourseAssesment;
	}
	
	public WebElement getClkTargetCollectionCat() {
		return clkTargetCollectionCat;
	}
	
	
	public WebElement getSelCourse() {
		return selCourse;
	}

	
	public WebElement getChooseTargetCollection() {
		return chooseTargetCollection;
	}
	
	
	public WebElement getClkPublishBtn() {
		return clkPublishBtn;
	}
	
	
	public WebElement getClkConfirm() {
		return clkConfirm;
	}

//	@FindBy(how = How.XPATH, using = "//strong[text()='Content is saved']")
//	private WebElement saveAsDraftPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Content saved successfully!']")
//	private WebElement saveLessonPlanPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Content published successfully...']")
//	private WebElement contentPublishedPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Content is published']")
//	private WebElement coursePublishedPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Content is added to the folder']")
//	private WebElement contentAddFromLibraryPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Content is published']")
//	private WebElement bookPublishedPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Content is sent for review']")
//	private WebElement sendForReviewPopUp;
//
//	@FindBy(how = How.XPATH, using = "//h2[text()='You just completed']")
//	private WebElement tvLessonCompleted;
//
//	@FindBy(how = How.XPATH, using = "//div[text()='You just completed']")
//	private WebElement ETextbookCompleted;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='User preference updated successfully']")
//	private WebElement bMCPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Batch created successfully...']")
//	private WebElement batchCreatedPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Activity added successfully']")
//	private WebElement ActivityAddedPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='This course does not have any open batches']")
//	private WebElement expireBatchPopUp;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='This course does not have any open batches']")
//	private WebElement DontHaveOpenBatch;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Group created successfully']")
//	private WebElement CreateGroupsPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Contentcreatorprod added successfully']")
//	private WebElement GroupMemberAddedPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Activity removed for the group successfully']")
//	private WebElement ActivityRemovePopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Group deleted successfully']")
//	private WebElement DeleteGroupPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Group updated successfully']")
//	private WebElement GroupUpdatePopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='contentcreatorprod is now the group admin']")
//	private WebElement MakeAsAdminPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='contentcreatorprod is no longer the group admin']")
//	private WebElement DismissAsAdminPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='contentcreatorprod is no longer part of the group']")
//	private WebElement RemoveGroupMemberPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Enabled discussion forum successfully']")
//	private WebElement EnabledDiscussionPopup;
//
//	@FindBy(how = How.XPATH, using = "//strong[text()='Disabled discussion forum successfully']")
//	private WebElement DisabledDiscussionPopup;
//	
//	@FindBy(how=How.XPATH,using="//strong[text()='You are no longer part of this group']")
//	private WebElement LeaveGroupPopup;
//	
//	@FindBy(how=How.XPATH,using="//strong[text()='updated successfully']")
//	private WebElement UpdatedPopup;
//	
//	@FindBy(how=How.XPATH,using="//strong[text()='Certificate added successfully']")
//	private WebElement CompletionCerificatePopup;
//	
//	@FindBy(how=How.XPATH,using="//strong[text()='Congratulations!!']")
//	private WebElement CongratulationPopup;
//	
//	@FindBy(how=How.XPATH,using="//div[text()='Congratulations!!']")
//    private WebElement completionCongratulationPopup;
//	
//	public WebElement getCompletionCongratulationPopup() {
//		return completionCongratulationPopup;
//	}
//
//	public void setCompletionCongratulationPopup(WebElement completionCongratulationPopup) {
//		this.completionCongratulationPopup = completionCongratulationPopup;
//	}
//
//	@FindBy(how=How.XPATH,using="//strong[text()='QR codes downloaded']")
//	private WebElement DownloadQRCodePopup;
//	
//	@FindBy(how=How.XPATH,using="//strong[text()='Content is sent back for corrections']")
//	private WebElement RejectTheContentPopup;
//	
//	public WebElement getRejectTheContentPopup() {
//		return  RejectTheContentPopup;
//	}
//	
//	public WebElement getDownloadQRCodePopup() {
//		return  DownloadQRCodePopup;
//	}
//	
//	public WebElement getCongratulationPopup() {
//		return  CongratulationPopup;
//	}
//	
//	public WebElement getCompletionCerificatePopup() {
//		return  CompletionCerificatePopup;
//	}
//	
//	public WebElement getUpdatedPopup() {
//		return  UpdatedPopup;
//	}
//	
//	public WebElement getLeaveGroupPopup() {
//		return  LeaveGroupPopup;
//	}
//
//	public WebElement getDisabledDiscussionPopup() {
//		return DisabledDiscussionPopup;
//	}
//
//	public WebElement getEnabledDiscussionPopup() {
//		return EnabledDiscussionPopup;
//	}
//
//	public WebElement getRemoveGroupMemberPopup() {
//		return RemoveGroupMemberPopup;
//	}
//
//	public WebElement getDismissAsAdminPopup() {
//		return DismissAsAdminPopup;
//	}
//
//	public WebElement getMakeAsAdminPopup() {
//		return MakeAsAdminPopup;
//	}
//
//	public WebElement getGroupUpdatePopup() {
//		return GroupUpdatePopup;
//	}
//
//	public WebElement getDeleteGroupPopup() {
//		return DeleteGroupPopup;
//	}
//
//	public WebElement getActivityRemovePopup() {
//		return ActivityRemovePopup;
//	}
//
//	public WebElement getActivityAddedPopup() {
//		return ActivityAddedPopup;
//	}
//
//	public WebElement getGroupMemberAddedPopup() {
//		return GroupMemberAddedPopup;
//	}
//
//	public WebElement getCreateGroupsPopup() {
//		return CreateGroupsPopup;
//	}
//
//	public WebElement getDontHaveOpenBatch() {
//		return DontHaveOpenBatch;
//	}
//
//	public WebElement getexpireBatchPopUp() {
//		return expireBatchPopUp;
//	}
//
//	public WebElement getBatchCreatedPopUp() {
//		return batchCreatedPopUp;
//	}
//
//	public WebElement getbMCPopUp() {
//		return bMCPopUp;
//	}
//
//	public WebElement getETextbookCompleted() {
//		return ETextbookCompleted;
//	}
//
//	public WebElement getTvLessonCompleted() {
//		return tvLessonCompleted;
//	}
//
//	public WebElement getSendForReviewPopUp() {
//		return sendForReviewPopUp;
//	}
//
//	public WebElement getContentAddFromLibraryPopup() {
//		return contentAddFromLibraryPopup;
//	}
//
//	public WebElement getCoursePublishedPopUp() {
//		return coursePublishedPopUp;
//	}
//
//	public WebElement getBookPublishedPopUp() {
//		return bookPublishedPopUp;
//	}
//
//	public WebElement getContentPublishedPopUp() {
//		return contentPublishedPopUp;
//	}
//
//	public WebElement getSaveLessonPlanPopUp() {
//		return saveLessonPlanPopUp;
//	}
//
//	public WebElement getSaveAsDraftPopUp() {
//		return saveAsDraftPopUp;
//	}

}
