package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how = How.XPATH, using = "//a[text()=' Home ']")
	private WebElement HomeTab;

	@FindBy(how = How.XPATH, using = "//a[text()=' Digital textbooks ']")
	private WebElement digitalTextbookTab;

	@FindBy(how = How.XPATH, using = "//a[text()=' Courses ']")
	private WebElement CourseTab;

	@FindBy(how = How.XPATH, using = "(//a[text()=' TV classes '])[1]")
	private WebElement TVClassesTab;

	@FindBy(how = How.XPATH, using = "(//a[text()=' All '])[1]")
	private WebElement AllTab;

	@FindBy(how = How.XPATH, using = "//span[text()='State (Uttarakhand)']")
	private WebElement BoardValue;

	@FindBy(how = How.XPATH, using = "//span[text()='Hindi']")
	private WebElement MediumValue;
	
	@FindBy(how=How.XPATH,using="//h4[text()=' Showing results ']")
	private WebElement AllTabText;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Create New Project']")
	private WebElement createNewBtn;
	
	@FindBy(how=How.XPATH,using="//span[text()='My Projects']")
	private WebElement myProjectTab;
	
	
	
	@FindBy(how=How.XPATH,using="(//button[text()=' Apply Filter '])[1]")
	private WebElement btnFilter;
	
	@FindBy(how=How.XPATH,using="//a[text()='My Projects']")
	private WebElement MyProjects;
	
    public WebElement getMyProjects() {
		return MyProjects;
	}
	

	
	public WebElement getBtnFilter() {
		return btnFilter;
	}
	
	
	public WebElement getMyProjectTab() {
		return myProjectTab;
	}


	public WebElement getCreateNewBtn() {
		return createNewBtn;
	}


	public WebElement getAllTabText() {
		return AllTabText;
	}
	

	public WebElement getBoardValue() {
		return BoardValue;
	}

	public void setBoardValue(WebElement boardValue) {
		BoardValue = boardValue;
	}

	public WebElement getMediumValue() {
		return MediumValue;
	}

	public void setMediumValue(WebElement mediumValue) {
		MediumValue = mediumValue;
	}

	public WebElement getClassValue() {
		return ClassValue;
	}

	public void setClassValue(WebElement classValue) {
		ClassValue = classValue;
	}

	@FindBy(how = How.XPATH, using = "(//span[text()='Class 1'])[1]")
	private WebElement ClassValue;

	public WebElement getTVClassesTab() {
		return TVClassesTab;
	}

	public void setTVClassesTab(WebElement tVClassesTab) {
		TVClassesTab = tVClassesTab;
	}

	public WebElement getAllTab() {
		return AllTab;
	}

	public void setAllTab(WebElement allTab) {
		AllTab = allTab;
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Observation ']")
	private WebElement ObservationTab;

	@FindBy(how = How.XPATH, using = "//button[text()='CHANGE PREFERENCE']")
	private WebElement ChnagePreferences;

	@FindBy(how = How.XPATH, using = "//span[text()='CBSE/NCERT']")
	private WebElement TextCbsc;

	@FindBy(how = How.XPATH, using = "(//span[text()='English'])[2]")
	private WebElement TextEnglish;

	@FindBy(how = How.XPATH, using = "//span[text()='Class 2']")
	private WebElement TextClass2;

	@FindBy(how = How.XPATH, using = "//input[@title='Search or enter QR code']")
	private WebElement searchtextfield;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	private WebElement searchbutton;

	@FindBy(how = How.XPATH, using = "//bdi[contains(text(),'eTextbook')]")
	private WebElement searchedTextbook;

	@FindBy(how = How.XPATH, using = "//span[text()='Switch to classic theme']")
	private WebElement ClassicTheme;

	public WebElement getCourseTab() {
		return CourseTab;
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Cbse Training']")
	private WebElement cbseTrainingsTab;

	@FindBy(how = How.XPATH, using = "//span[text()='Select Board']")
	private WebElement selectBoardDropdown;

	@FindBy(how = How.XPATH, using = "//span[text()=' CBSE/NCERT ']")
	private WebElement BoardSelectedCBSE;

	@FindBy(how = How.XPATH, using = "//span[text()='Select Content type']")
	private WebElement selectPrimaryCategoryDropdown;

	@FindBy(how = How.XPATH, using = "//span[text()='Select Additional Categories']")
	private WebElement selectAdditionalCategoryDropdown;

	@FindBy(how = How.XPATH, using = "//span[text()=' lesson plan ']")
	private WebElement AdditionalCategorySelected;

	@FindBy(how = How.XPATH, using = "//span[text()=' content playlist ']")
	private WebElement PrimaryCategorySelected;

	@FindBy(how = How.XPATH, using = "//a[text()=' cbse training ']")
	private WebElement verifyCbseTrainingsFilter;

	@FindBy(how = How.XPATH, using = "//a[text()=' content playlist ']")
	private WebElement verifyContentPlaylistFilter;

	@FindBy(how = How.XPATH, using = "//a[text()=' lesson plan ']")
	private WebElement verifyAdditionalCategoryFilter;

	public WebElement getSelectAdditionalCategoryDropdown() {
		return selectAdditionalCategoryDropdown;
	}

	public WebElement getAdditionalCategorySelected() {
		return AdditionalCategorySelected;
	}

	public WebElement getVerifyAdditionalCategoryFilter() {
		return verifyAdditionalCategoryFilter;
	}

	public WebElement getVerifyCbseTrainingsFilter() {
		return verifyCbseTrainingsFilter;
	}

	public WebElement getVerifyContentPlaylistFilter() {
		return verifyContentPlaylistFilter;
	}

	public WebElement getSearchedTextbook() {
		return searchedTextbook;
	}

	public WebElement getCbseTrainingsTab() {
		return cbseTrainingsTab;
	}

	public WebElement getSelectBoardDropdown() {
		return selectBoardDropdown;
	}

	public WebElement getBoardSelectedCBSE() {
		return BoardSelectedCBSE;
	}

	public WebElement getSelectPrimaryCategoryDropdown() {
		return selectPrimaryCategoryDropdown;
	}

	public WebElement getPrimaryCategorySelected() {
		return PrimaryCategorySelected;
	}

	public WebElement getClassicTheme() {
		return ClassicTheme;

	}

	public WebElement getdigitalTextbookTab() {
		return digitalTextbookTab;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public void setSearchtextfield(WebElement searchtextfield) {
		this.searchtextfield = searchtextfield;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public void setSearchbutton(WebElement searchbutton) {
		this.searchbutton = searchbutton;
	}

	public WebElement getsearchedTextbook() {
		return searchedTextbook;
	}

	public WebElement getHomeTab() {
		return HomeTab;
	}

	public WebElement getObservationTab() {
		return ObservationTab;
	}

	public WebElement getChnagePreferences() {
		return ChnagePreferences;
	}

	public WebElement getTextCbsc() {
		return TextCbsc;
	}

	public WebElement getTextEnglish() {
		return TextEnglish;
	}

	public WebElement getTextClass2() {
		return TextClass2;
	}

}
