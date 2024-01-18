package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BMCPopup {

	@FindBy(how = How.XPATH, using = "//mat-form-field[@id='board']")
	private WebElement Board;
	
	@FindBy(how=How.XPATH,using="//span[text()='CBSE']")
	private WebElement Cbsc;
	//span[text()='CBSE']
	//mat-option[@aria-label='CBSE/NCERT']
	//mat-form-field[@id='board']"
	
	@FindBy(how=How.XPATH,using="//mat-form-field[@id='board']")
	private WebElement BoardValue;
	
	@FindBy(how=How.XPATH,using="//mat-form-field[@id='medium']")
	private WebElement Medium;
	
	@FindBy(how=How.XPATH,using="(//span[text()='English'])[2]")
	private WebElement English;
	
	
    @FindBy(how=How.XPATH,using="//span[text()='Hindi']")
	private WebElement Hindi;
	
	@FindBy(how=How.XPATH,using="//mat-form-field[@id='gradeLevel']")
	private WebElement Classs;
	
	@FindBy(how=How.XPATH,using=" //*[contains(@aria-label,'Class 1')]//following::span[2]")
	private WebElement  Class2;
	
	@FindBy(how=How.XPATH,using="//mat-option[@aria-label='Class 4']")
	private WebElement Class4;
	
	@FindBy(how=How.XPATH,using=" //button[@class='sb-btn sb-btn-normal sb-btn-primary']")
	private WebElement   BMCSubmit;


	@FindBy(how = How.XPATH, using = "//span[text()='IGOT-Health']")
	private WebElement IGOT_Health;

	@FindBy(how = How.XPATH, using = "//span[text()='Gujarati']")
	private WebElement Gujarati;

	@FindBy(how = How.XPATH, using = "//span[text()='Pharmacist']")
	private WebElement Pharmacist;

	@FindBy(how = How.XPATH, using = "(//button[text()='Edit'])[2]")
	private WebElement BMCeditbutton;

	@FindBy(how = How.XPATH, using = "//span[text()='CBSE/NCERT']")
	private WebElement TextCbsc;

	@FindBy(how = How.XPATH, using = "(//span[text()='English'])[2]")
	private WebElement TextEnglish;

	@FindBy(how = How.XPATH, using = "//span[text()='Class 2']")
	private WebElement TextClass2;
	
	@FindBy(how=How.XPATH,using="//mat-form-field[@id='medium']")
	private WebElement MediumValue;
	
	@FindBy(how=How.XPATH,using="//mat-form-field[@id='gradeLevel']")
	private WebElement ClassValue;
	
	@FindBy(how=How.XPATH,using="//mat-option[@aria-label='English']")
	private WebElement SelectPreferenceEngilsh;
	
	@FindBy(how=How.XPATH,using="//mat-option[@aria-label='Class 1']")
	private WebElement Class1;
	
	@FindBy(how=How.XPATH,using="//span[text()='Others']")
	private WebElement Other;
	
	@FindBy(how=How.XPATH,using="//div[@id='mat-dialog-title-1']")
	private WebElement BMCHeading;
	
	@FindBy(how=How.XPATH,using="//span[@class='mat-select-min-line ng-tns-c44-79 ng-star-inserted']")
	private WebElement MediumValueEnglishHIndi;
	
	public WebElement getMediumValueEnglishHIndi() {
		return MediumValueEnglishHIndi;
	}
	
	public WebElement getBMCHeading() {
		return BMCHeading;
	}
	
	public WebElement getOther() {
		return Other;
	}
	
	public WebElement getClass1() {
		return Class1;
	}
	
	public WebElement getSelectPreferenceEngilsh() {
		return SelectPreferenceEngilsh;
	}
	
	public WebElement getClassValue() {
		return ClassValue;
	}
	
	public WebElement getMediumValue() {
		return MediumValue;
	}
	
	public WebElement getBoardValue() {
		return BoardValue;
	}


	@FindBy(how = How.XPATH, using = "(//span[text()='CBSE'])[3]")
	private WebElement Cbsccheck;

	@FindBy(how = How.XPATH, using = "(//span[text()='English'])[3]")
	private WebElement englishcheck;

	@FindBy(how = How.XPATH, using = "//div[@id='mat-select-value-79']")
	private WebElement class2check;

	public WebElement getEnglishcheck() {
		return englishcheck;
	}

	public WebElement getClass2check() {
		return class2check;
	}

	public WebElement getCbsccheck() {
		return Cbsccheck;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Board: ']//following::span[text()='CBSE/NCERT'][1]")
	private WebElement validateBoardInChangePref;

	@FindBy(how = How.XPATH, using = "//span[text()='Medium: ']//following::span[text()='English'][1]")
	private WebElement validateMediumInChangePref;

	@FindBy(how = How.XPATH, using = "//span[text()='Class: ']//following::span[text()='Class 1'][1]")
	private WebElement validateClassInChangePref;

	public WebElement getTextCbsc() {
		return TextCbsc;
	}

	public void setTextCbsc(WebElement textCbsc) {
		TextCbsc = textCbsc;
	}

	public WebElement getTextEnglish() {
		return TextEnglish;
	}

	public void setTextEnglish(WebElement textEnglish) {
		TextEnglish = textEnglish;
	}

	public WebElement getTextClass2() {
		return TextClass2;
	}

	public void setTextClass2(WebElement textClass2) {
		TextClass2 = textClass2;
	}

	public WebElement getIGOT_Health() {
		return IGOT_Health;
	}

	public void setIGOT_Health(WebElement iGOT_Health) {
		IGOT_Health = iGOT_Health;
	}

	public WebElement getGujarati() {
		return Gujarati;
	}

	public void setGujarati(WebElement gujarati) {
		Gujarati = gujarati;
	}

	public WebElement getPharmacist() {
		return Pharmacist;
	}

	public void setPharmacist(WebElement pharmacist) {
		Pharmacist = pharmacist;
	}

	public WebElement getBMCeditbutton() {
		return BMCeditbutton;
	}

	public void setBMCeditbutton(WebElement bMCeditbutton) {
		BMCeditbutton = bMCeditbutton;
	}

	public WebElement getClass4() {
		return Class4;
	}

	public WebElement getHindi() {
		return Hindi;
	}

	public WebElement getBoard() {
		return Board;
	}

	public WebElement getCbsc() {
		return Cbsc;
	}

	public WebElement getMedium() {
		return Medium;
	}

	public WebElement getEnglish() {
		return English;
	}

	public WebElement getClasss() {
		return Classs;
	}

	public WebElement getClass2() {
		return Class2;
	}

	public WebElement getBMCSubmit() {
		return BMCSubmit;
	}

	public WebElement getValidateBoardInChangePref() {
		return validateBoardInChangePref;
	}

	public WebElement getValidateMediumInChangePref() {
		return validateMediumInChangePref;
	}

	public WebElement getValidateClassInChangePref() {
		return validateClassInChangePref;
	}

}
