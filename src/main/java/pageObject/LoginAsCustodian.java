package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginAsCustodian {

	

	@FindBy(how = How.XPATH, using = "(//div[@class='avatar-container'])[2]")
	private WebElement headerDropdown;

	@FindBy(how = How.XPATH, using = "//a[text()=' Login ']")
	private WebElement logintab;

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	private WebElement userName;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@id='login']")
	private WebElement login;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Register here')]")
	private WebElement registerHereButton;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'signup-form-name')]")
	private WebElement enterFullNameInRegisterPage;

	@FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Select year')]")
	private WebElement selectYeardropDown;

	@FindBy(how = How.XPATH, using = "//div[contains(@role,'listbox')]")
	private WebElement selectYeardropDownValues;
	
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue')]")
	private WebElement continueButton;
	
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
	private WebElement submitButton;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@for,'email')]")
	private WebElement emailRadioButton;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@placeholder,'Email address')]")
	private WebElement enterEmail;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'signup-form-password')]")
	private WebElement signUpPassWord;
	
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'signup-form-confirmPassword')]")
	private WebElement signUpReEnterPassWord;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@placeholder,'Enter your inbox here')]")
	private WebElement enterEmailToYopmail;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(@title,'Check Inbox @yopmail.com')]")
	private WebElement clickSearchInYopMail;
	
	
	
	@FindBy(how = How.XPATH, using = "//button[contains(@id,'refresh')]")
	private WebElement refreshButtonInYopmail;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'OTP to verify your email ID on DIKSHA')]")
	private WebElement emailOtpSentence;
	
	
	@FindBy(how = How.XPATH, using = "//iframe[contains(@id,'ifmail')]")
	private WebElement otpFrame;
	
	public WebElement getHeaderDropdown() {
		return headerDropdown;
	}

	public WebElement getLogintab() {
		return logintab;
	}

	public void setLogintab(WebElement logintab) {
		this.logintab = logintab;
	}

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}

	public void setHeaderDropdown(WebElement headerDropdown) {
		this.headerDropdown = headerDropdown;
	}

	public WebElement getRegisterHereButton() {
		return registerHereButton;
	}

	public WebElement getEnterFullNameInRegisterPage() {
		return enterFullNameInRegisterPage;
	}

	public WebElement getSelectYearDropdown() {
		return selectYeardropDown;
	}

	public WebElement getselectYeardropDownValues() {
		return selectYeardropDownValues;
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
	public WebElement getEmailRadioButton() {
		return emailRadioButton;
	}
	
	public WebElement getEnterEmail() {
		return enterEmail;
	}
	
	public WebElement getSignUpPassWord() {
		return signUpPassWord;
	}
	
	public WebElement getSignUpReEnterPassWord() {
		return signUpReEnterPassWord;
	}
	
	
	public WebElement getEnterEmailToYopmail() {
		return enterEmailToYopmail;
	}
	
	public WebElement getClickSearchInYopMail() {
		return clickSearchInYopMail;
	}
	
	public WebElement getRefreshButtonInYopmail() {
		return refreshButtonInYopmail;
	}
	
	public WebElement getEmailOtpSentence() {
		return emailOtpSentence;
	}
	
	public WebElement getOtpFrame() {
		return otpFrame;
	}
	
	
	
	
}