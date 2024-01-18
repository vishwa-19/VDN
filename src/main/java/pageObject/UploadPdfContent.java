package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UploadPdfContent {

	@FindBy(how=How.XPATH,using="//button[text()='Upload']")
	private WebElement uploadButtonAfterUrl;

	public WebElement getUploadButtonAfterUrl() {
		return uploadButtonAfterUrl;
	}

	@FindBy(how=How.XPATH,using="(//div[@id='url-upload'])/div/input")
	private WebElement contentURL;

	@FindBy(how=How.XPATH,using="//button[text()='Select']")
	private WebElement selectButton;

	@FindBy(how=How.XPATH,using="//div[text()='Select Subject']")
	private WebElement selectSubject;


	//@FindBy(how=How.XPATH,using="//div[text()='EVS']")

	@FindBy(how=How.XPATH,using="//div[text()='Select Subject']/../div/div")
    private WebElement subjectSelected;
	//div[text()='EVS']
	//(//div[text()='English'])[2]

	@FindBy(how=How.XPATH,using="//div[text()='Select Class']")
	private WebElement selectClass;

	@FindBy(how=How.XPATH,using="//div[text()='Class 1']")
	private WebElement classSelected;

	@FindBy(how=How.XPATH,using="//div[text()='Select Medium']")
	private WebElement selectMedium;

	@FindBy(how=How.XPATH,using="//div[@class='menu transition visible']/div[text()='English']")
	private WebElement mediumSelected;


	@FindBy(how=How.XPATH,using="//div[text()='Others']")
	//@FindBy(how=How.XPATH,using="//div[text()='Select Board/Syllabus']/../div/div")
   private WebElement boardSelected;
	//div[text()='Others']
	//div[text()='State (Tamil Nadu)']
	////select[@name='sb-dropdown']/option[text()='Others']

	@FindBy(how=How.XPATH,using="//div[text()='Select Board/Syllabus']")
	private WebElement selectBoardSyllabus;
//	//select[@name='sb-dropdown']/option[text()='Select Board/Syllabus ']
	//div[text()='Select Board/Syllabus']

	@FindBy(how=How.XPATH,using="//div[text()='Add an image']")
	private WebElement clickOnAddImage;

	@FindBy(how=How.XPATH,using="//a[text()='All image']")
	private WebElement clickOnAllImage;

	@FindBy(how=How.XPATH,using="//div[@id='all-image-tab']//following-sibling::div[2]/div/div/div/img")
	private WebElement selectImageFromAllImage;

	@FindBy(how=How.XPATH,using="//i[@class='send icon']")
	private WebElement sendforreview;

	@FindBy(how=How.XPATH,using="//button[@class='ui blue button ']")
	private WebElement savebutton;


	@FindBy(how=How.XPATH,using="//button[text()='Close']")
	private WebElement close;


	@FindBy(how=How.XPATH,using="//span[text()='Save']")
	private WebElement save;


	@FindBy(how=How.XPATH,using="//input[@id='copyrightYear']")
	private WebElement copyright;


	@FindBy(how=How.XPATH,using="//input[@id='name']")
	private WebElement name;


	@FindBy(how=How.XPATH,using="//span[@class='ng-scope']")
	private WebElement editdetail;


	@FindBy(how=How.XPATH,using="//span[text()='Upload Content']")
	private WebElement uploadcontent;

	@FindBy(how=How.XPATH,using="//span[text()='Upload Large Videos (>50 MB)']")
	private WebElement uploadMoreThan50Mbcontent;


	public WebElement getUploadMoreThan50Mbcontent() {
		return uploadMoreThan50Mbcontent;
	}

	@FindBy(how=How.XPATH,using="//*[@id='_selectPrimaryCategory']")
	private WebElement contenttypetab;


	@FindBy(how=How.XPATH,using="//option[@data-value='eTextbook']")
	private WebElement eTextbook;


	@FindBy(how=How.XPATH,using="//*[@id='browseButton']//input")
	private WebElement browserbutton;



	@FindBy(how=How.XPATH,using="(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;

	@FindBy(how=How.XPATH,using="//*[contains(text(),'Workspace')]")
	private WebElement Workspace;

	@FindBy(how=How.XPATH,using="//div[@id='url-upload']")
	private WebElement enterurl;

	@FindBy(how=How.XPATH,using="//select[@id='_selectyear']")
	private WebElement YearDropdown;


	@FindBy(how=How.XPATH,using="//select[@id='_selectyear']//option[@data-value='2008']")
	private WebElement YearVlaue;
	//select[@id='_selectyear']//option[@data-value='2008']
	//option[text()='2008']
	//select[@id='_selectyear']//option[2]
	
	@FindBy(how=How.XPATH,using="//button[text()='Upload ']")
	private WebElement uploadBtn;
	
	@FindBy(how=How.XPATH,using="//div[@class='qq-upload-button-selector qq-upload-button sb-btn sb-btn-normal sb-btn-success']")
	private WebElement selectFiles;
	
	//div[text()='Select file(s)']

	public WebElement getSelectFiles() {
		return selectFiles;
	}


	public WebElement getUploadBtn() {
		return uploadBtn;
	}


	public WebElement getYearVlaue() {
		return YearVlaue;
	}


	public WebElement getYearDropdown() {
		return YearDropdown;
	}


	public WebElement getContentURL() {
		return contentURL;
	}

	public WebElement getSelectButton() {
		return selectButton;
	}

	public WebElement getSelectSubject() {
		return selectSubject;
	}

	public WebElement getSubjectSelected() {
		return subjectSelected;
	}

	public WebElement getSelectClass() {
		return selectClass;
	}

	public WebElement getClassSelected() {
		return classSelected;
	}

	public WebElement getSelectMedium() {
		return selectMedium;
	}

	public WebElement getMediumSelected() {
		return mediumSelected;
	}

	public WebElement getBoardSelected() {
		return boardSelected;
	}

	public WebElement getSelectBoardSyllabus() {
		return selectBoardSyllabus;
	}

	public WebElement getClickOnAddImage() {
		return clickOnAddImage;
	}

	public WebElement getClickOnAllImage() {
		return clickOnAllImage;
	}

	public WebElement getSelectImageFromAllImage() {
		return selectImageFromAllImage;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getSendforreview() {
		return sendforreview;
	}

	public void setSendforreview(WebElement sendforreview) {
		this.sendforreview = sendforreview;
	}


	public WebElement getClose() {
		return close;
	}

	public void setClose(WebElement close) {
		this.close = close;
	}

	public WebElement getUploadcontent() {
		return uploadcontent;
	}

	public void setUploadcontent(WebElement uploadcontent) {
		this.uploadcontent = uploadcontent;
	}

	public WebElement getContenttypetab() {
		return contenttypetab;
	}

	public void setContenttypetab(WebElement contenttypetab) {
		this.contenttypetab = contenttypetab;
	}

	public WebElement geteTextbook() {
		return eTextbook;
	}

	public void seteTextbook(WebElement eTextbook) {
		this.eTextbook = eTextbook;
	}

	public WebElement getBrowserbutton() {
		return browserbutton;
	}

	public void setBrowserbutton(WebElement browserbutton) {
		this.browserbutton = browserbutton;
	}

	public WebElement getHeaderDropdown() {
		return headerDropdown;
	}

	public void setHeaderDropdown(WebElement headerDropdown) {
		this.headerDropdown = headerDropdown;
	}

	public WebElement getWorkspace() {
		return Workspace;
	}

	public void setWorkspace(WebElement workspace) {
		Workspace = workspace;
	}

	public WebElement getEnterurl() {
		return enterurl;
	}

	public void setEnterurl(WebElement enterurl) {
		this.enterurl = enterurl;
	}
	public WebElement getEditdetail() {
		return editdetail;
	}

	public void setEditdetail(WebElement editdetail) {
		this.editdetail = editdetail;
	}
	public WebElement getName() {
		return name;
	}

	public void setName(WebElement name) {
		this.name = name;
	}

	public WebElement getCopyright() {
		return copyright;
	}

	public void setCopyright(WebElement copyright) {
		this.copyright = copyright;
	}

	public WebElement getSave() {
		return save;
	}
}
