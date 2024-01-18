package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class ValidatePopUp {

	@FindBy(how = How.XPATH, using = "//strong[text()='Content is saved']")
	private WebElement saveAsDraftPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='Content saved successfully!']")
	private WebElement saveLessonPlanPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='Content published successfully...']")
	private WebElement contentPublishedPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='Content is published']")
	private WebElement coursePublishedPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='Content is added to the folder']")
	private WebElement contentAddFromLibraryPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='Content is published']")
	private WebElement bookPublishedPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='Content is sent for review']")
	private WebElement sendForReviewPopUp;

	@FindBy(how = How.XPATH, using = "//h2[text()='You just completed']")
	private WebElement tvLessonCompleted;

	@FindBy(how = How.XPATH, using = "//div[text()='You just completed']")
	private WebElement ETextbookCompleted;

	@FindBy(how = How.XPATH, using = "//strong[text()='User preference updated successfully']")
	private WebElement bMCPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='Batch created successfully...']")
	private WebElement batchCreatedPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='Activity added successfully']")
	private WebElement ActivityAddedPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='This course does not have any open batches']")
	private WebElement expireBatchPopUp;

	@FindBy(how = How.XPATH, using = "//strong[text()='This course does not have any open batches']")
	private WebElement DontHaveOpenBatch;

	@FindBy(how = How.XPATH, using = "//strong[text()='Group created successfully']")
	private WebElement CreateGroupsPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='Contentcreatorprod added successfully']")
	private WebElement GroupMemberAddedPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='Activity removed for the group successfully']")
	private WebElement ActivityRemovePopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='Group deleted successfully']")
	private WebElement DeleteGroupPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='Group updated successfully']")
	private WebElement GroupUpdatePopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='contentcreatorprod is now the group admin']")
	private WebElement MakeAsAdminPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='contentcreatorprod is no longer the group admin']")
	private WebElement DismissAsAdminPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='contentcreatorprod is no longer part of the group']")
	private WebElement RemoveGroupMemberPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='Enabled discussion forum successfully']")
	private WebElement EnabledDiscussionPopup;

	@FindBy(how = How.XPATH, using = "//strong[text()='Disabled discussion forum successfully']")
	private WebElement DisabledDiscussionPopup;
	
	@FindBy(how=How.XPATH,using="//strong[text()='You are no longer part of this group']")
	private WebElement LeaveGroupPopup;
	
	@FindBy(how=How.XPATH,using="//strong[text()='updated successfully']")
	private WebElement UpdatedPopup;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Certificate added successfully']")
	private WebElement CompletionCerificatePopup;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Congratulations!!']")
	private WebElement CongratulationPopup;
	
	@FindBy(how=How.XPATH,using="//div[text()='Congratulations!!']")
    private WebElement completionCongratulationPopup;
	
	public WebElement getCompletionCongratulationPopup() {
		return completionCongratulationPopup;
	}

	public void setCompletionCongratulationPopup(WebElement completionCongratulationPopup) {
		this.completionCongratulationPopup = completionCongratulationPopup;
	}

	@FindBy(how=How.XPATH,using="//strong[text()='QR codes downloaded']")
	private WebElement DownloadQRCodePopup;
	
	@FindBy(how=How.XPATH,using="//strong[text()='Content is sent back for corrections']")
	private WebElement RejectTheContentPopup;
	
	public WebElement getRejectTheContentPopup() {
		return  RejectTheContentPopup;
	}
	
	public WebElement getDownloadQRCodePopup() {
		return  DownloadQRCodePopup;
	}
	
	public WebElement getCongratulationPopup() {
		return  CongratulationPopup;
	}
	
	public WebElement getCompletionCerificatePopup() {
		return  CompletionCerificatePopup;
	}
	
	public WebElement getUpdatedPopup() {
		return  UpdatedPopup;
	}
	
	public WebElement getLeaveGroupPopup() {
		return  LeaveGroupPopup;
	}

	public WebElement getDisabledDiscussionPopup() {
		return DisabledDiscussionPopup;
	}

	public WebElement getEnabledDiscussionPopup() {
		return EnabledDiscussionPopup;
	}

	public WebElement getRemoveGroupMemberPopup() {
		return RemoveGroupMemberPopup;
	}

	public WebElement getDismissAsAdminPopup() {
		return DismissAsAdminPopup;
	}

	public WebElement getMakeAsAdminPopup() {
		return MakeAsAdminPopup;
	}

	public WebElement getGroupUpdatePopup() {
		return GroupUpdatePopup;
	}

	public WebElement getDeleteGroupPopup() {
		return DeleteGroupPopup;
	}

	public WebElement getActivityRemovePopup() {
		return ActivityRemovePopup;
	}

	public WebElement getActivityAddedPopup() {
		return ActivityAddedPopup;
	}

	public WebElement getGroupMemberAddedPopup() {
		return GroupMemberAddedPopup;
	}

	public WebElement getCreateGroupsPopup() {
		return CreateGroupsPopup;
	}

	public WebElement getDontHaveOpenBatch() {
		return DontHaveOpenBatch;
	}

	public WebElement getexpireBatchPopUp() {
		return expireBatchPopUp;
	}

	public WebElement getBatchCreatedPopUp() {
		return batchCreatedPopUp;
	}

	public WebElement getbMCPopUp() {
		return bMCPopUp;
	}

	public WebElement getETextbookCompleted() {
		return ETextbookCompleted;
	}

	public WebElement getTvLessonCompleted() {
		return tvLessonCompleted;
	}

	public WebElement getSendForReviewPopUp() {
		return sendForReviewPopUp;
	}

	public WebElement getContentAddFromLibraryPopup() {
		return contentAddFromLibraryPopup;
	}

	public WebElement getCoursePublishedPopUp() {
		return coursePublishedPopUp;
	}

	public WebElement getBookPublishedPopUp() {
		return bookPublishedPopUp;
	}

	public WebElement getContentPublishedPopUp() {
		return contentPublishedPopUp;
	}

	public WebElement getSaveLessonPlanPopUp() {
		return saveLessonPlanPopUp;
	}

	public WebElement getSaveAsDraftPopUp() {
		return saveAsDraftPopUp;
	}

}
