package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AllMyContentBucket {
	
	@FindBy(how=How.XPATH,using="//a[text()=' All My Content ']")
	private WebElement allMyContentTab;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search content']")
	private WebElement searchContentTextfield;
	
	@FindBy(how=How.XPATH,using="//i[@class='circular search link icon']")
	private WebElement searchButton;
	
	@FindBy(how=How.XPATH,using="//i[@class='circular search link icon']")
	private WebElement searchedContent;

	public WebElement getAllMyContentTab() {
		return allMyContentTab;
	}

	public WebElement getSearchContentTextfield() {
		return searchContentTextfield;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchedContent() {
		return searchedContent;
	}
	
	
	
}
