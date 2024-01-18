package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Languages {

	@FindBy(how=How.XPATH,using="//div[@class='mat-select-arrow-wrapper']")
	private WebElement languageDropdown;
	
	@FindBy(how=How.XPATH,using="//mat-option[@aria-label='Hindi']")
	private WebElement Hindilanguage;
	
	@FindBy(how=How.XPATH,using="//mat-option[@aria-label='Urdu']")
	private WebElement urdulanguage;
	
	@FindBy(how=How.XPATH,using="//mat-option[@aria-label='English']")
	private WebElement englishlanguage;

	public WebElement getLanguageDropdown() {
		return languageDropdown;
	}

	public WebElement getHindilanguage() {
		return Hindilanguage;
	}

	public WebElement getUrdulanguage() {
		return urdulanguage;
	}

	public WebElement getEnglishlanguage() {
		return englishlanguage;
	}
	
	
	
}
