package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

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
	
	@FindBy(how=How.XPATH,using="//li[text()=' Profile ']")
	private WebElement clkProfile;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter password']")
    private WebElement enterReportPassword;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Request ']")
    private WebElement requestButton;
	

	public WebElement getHeaderDropdown() {
		return headerDropdown;
	}

	public WebElement getLogintab() {
		return logintab;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Login')]")
	private WebElement validateLoginPopUpInGuestUser;

	
	public WebElement getclkProfile() {
		return clkProfile;
	}
	
	public WebElement getReportRequestPassword() {
        return requestButton;
    }

 
    public WebElement getEnterReportPassword() {
        return enterReportPassword;
    }
    
    public WebElement getvalidateLoginPopUpInGuestUser() {
        return validateLoginPopUpInGuestUser;
    }
}
