package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpForReview {

	@FindBy(how=How.XPATH,using="//tr[@class='UpForReviewListHover cursor-pointer ng-star-inserted']")
	private WebElement taboncourse;

	@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;


	@FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
	private WebElement Workspace;


	@FindBy(how=How.XPATH,using="//a[contains(text(),'Up For Review')]")
	private WebElement upForReview;


	@FindBy(how=How.XPATH,using="//input[@placeholder='Search content']")

	private WebElement searchForReview;



	@FindBy(how=How.XPATH,using="//div[@class='UpReviewHeader']")
	private WebElement searchedContentForPublish;

	@FindBy(how=How.XPATH,using="(//div[@class='UpReviewHeader'])[1]")
	private WebElement clickSearchContent;



	@FindBy(how=How.XPATH,using="//button[text()= ' Publish ']")
	private WebElement publishTheCourse;

	@FindBy(how=How.XPATH,using="//button[text()= ' Yes ']")
	private WebElement confirmpublishTheCourse;



	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[1]")
    private WebElement noHateSpeech;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[2]")
    private WebElement noSexualContent;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[3]")
    private WebElement noDiscrimination;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[4]")
    private WebElement suitableForChildren;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[5]")
    private WebElement appropriateTitle;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[6]")
    private WebElement correctBMC;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[7]")
    private WebElement appropriateTags;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[8]")
    private WebElement relevantKeywords;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[9]")
    private WebElement Contentplayscorrectly;


	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[10]")
    private WebElement contentclearOnDesk;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[11]")
    private WebElement audio;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[12]")
    private WebElement NoSpellingmistakes;

	@FindBy(how=How.XPATH,using="(//input[@class='listItem'])[13]")
    private WebElement language;



	@FindBy(how=How.XPATH,using="(//button[text()=' Publish '])[2]")
    private WebElement confirmForPublishBook;


	@FindBy(how=How.XPATH,using="//span[text()='Publish']")
    private WebElement publishLessonPlan;


	@FindBy(how=How.XPATH,using="(//button[text()='Publish'])[1]")
    private WebElement confirmForPublishLessonPlan;

	@FindBy(how=How.XPATH,using="//button[text()=' Reject ']")
    private WebElement RejectTheContent;


	@FindBy(how=How.XPATH,using="//textarea[@placeholder='Add comment']")
    private WebElement AddReviewComment;

	@FindBy(how=How.XPATH,using="//button[@id='submitReview']")
    private WebElement SubmitReviewButton;

	@FindBy(how=How.XPATH,using="//a[text()=' Published ']")
    private WebElement clkPublished;


	@FindBy(how=How.XPATH,using="//span[contains(text(),'Course_')]")
    private WebElement selectedCourse;
	
	@FindBy(how = How.XPATH, using = "//div[@class='practical-header__title font-weight-bold pl-20 fs-0-92']")
	private WebElement courseTitle;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'View Comments ')]")
	private WebElement SelectViewComment;
	
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Close')]")
	private WebElement SelectClose;
	
	@FindBy(how=How.XPATH,using="//button[text()='Cancel']")
	private WebElement clkBtnCance;
	
	
	
	public WebElement getClkBtnCance() {
		return clkBtnCance;
	}

	public WebElement getSelectClose() {
		return SelectClose;
	}
	
	public WebElement getSelectViewComment() {
		return SelectViewComment;
	}

	public WebElement getCourseTitle() {
		return courseTitle;
	}

	public WebElement getAddReviewComment() {
		return AddReviewComment;
	}


	public void setAddReviewComment(WebElement addReviewComment) {
		AddReviewComment = addReviewComment;
	}


	public WebElement getSubmitReviewButton() {
		return SubmitReviewButton;
	}


	public void setSubmitReviewButton(WebElement submitReviewButton) {
		SubmitReviewButton = submitReviewButton;
	}


	public WebElement getRejectTheContent() {
		return RejectTheContent;
	}


	public WebElement getconfirmForPublishLessonPlan() {
		return confirmForPublishLessonPlan;
	}


	public WebElement getpublishLessonPlan() {
		return publishLessonPlan;
	}


	public WebElement getConfirmpublishTheCourse() {
		return confirmpublishTheCourse;
	}


	public void setConfirmpublishTheCourse(WebElement confirmpublishTheCourse) {
		this.confirmpublishTheCourse = confirmpublishTheCourse;
	}

	public WebElement getNoHateSpeech() {
		return noHateSpeech;
	}


	public void setNoHateSpeech(WebElement noHateSpeech) {
		this.noHateSpeech = noHateSpeech;
	}


	public WebElement getNoSexualContent() {
		return noSexualContent;
	}


	public void setNoSexualContent(WebElement noSexualContent) {
		this.noSexualContent = noSexualContent;
	}


	public WebElement getNoDiscrimination() {
		return noDiscrimination;
	}


	public void setNoDiscrimination(WebElement noDiscrimination) {
		this.noDiscrimination = noDiscrimination;
	}


	public WebElement getSuitableForChildren() {
		return suitableForChildren;
	}


	public void setSuitableForChildren(WebElement suitableForChildren) {
		this.suitableForChildren = suitableForChildren;
	}


	public WebElement getAppropriateTitle() {
		return appropriateTitle;
	}


	public void setAppropriateTitle(WebElement appropriateTitle) {
		this.appropriateTitle = appropriateTitle;
	}


	public WebElement getCorrectBMC() {
		return correctBMC;
	}


	public void setCorrectBMC(WebElement correctBMC) {
		this.correctBMC = correctBMC;
	}


	public WebElement getAppropriateTags() {
		return appropriateTags;
	}


	public void setAppropriateTags(WebElement appropriateTags) {
		this.appropriateTags = appropriateTags;
	}


	public WebElement getRelevantKeywords() {
		return relevantKeywords;
	}


	public void setRelevantKeywords(WebElement relevantKeywords) {
		this.relevantKeywords = relevantKeywords;
	}


	public WebElement getContentplayscorrectly() {
		return Contentplayscorrectly;
	}


	public void setContentplayscorrectly(WebElement contentplayscorrectly) {
		Contentplayscorrectly = contentplayscorrectly;
	}


	public WebElement getContentclearOnDesk() {
		return contentclearOnDesk;
	}


	public void setContentclearOnDesk(WebElement contentclearOnDesk) {
		this.contentclearOnDesk = contentclearOnDesk;
	}


	public WebElement getAudio() {
		return audio;
	}


	public void setAudio(WebElement audio) {
		this.audio = audio;
	}


	public WebElement getNoSpellingmistakes() {
		return NoSpellingmistakes;
	}


	public void setNoSpellingmistakes(WebElement noSpellingmistakes) {
		NoSpellingmistakes = noSpellingmistakes;
	}


	public WebElement getLanguage() {
		return language;
	}


	public void setLanguage(WebElement language) {
		this.language = language;
	}




	public WebElement getClickSearchContent() {
		return clickSearchContent;
	}


	public void setClickSearchContent(WebElement clickSearchContent) {
		this.clickSearchContent = clickSearchContent;
	}


	public WebElement getHeaderDropdown() {

	return headerDropdown;

	}


	public WebElement getWorkspace() {

	return Workspace;

	}


	public WebElement getUpForReview() {

	return upForReview;

	}

	public WebElement getSearchForReview() {

	return searchForReview;

	}


	public WebElement getSearchedContentForPublish() {

	return searchedContentForPublish;

	}

	public WebElement getPublishTheCourse() {
	return publishTheCourse;

	}


	public WebElement getConfirmForPublishBook() {
	return confirmForPublishBook;

	}

	public WebElement getTaboncourse() {
		return taboncourse;
	}


	public void setTaboncourse(WebElement taboncourse) {
		this.taboncourse = taboncourse;
	}

	public WebElement getclkPublished() {
		return clkPublished;
	}

	public WebElement getselectedCourse() {
		return selectedCourse;
	}


}



