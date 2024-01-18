package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManageUser {
     
	
	
			
	@FindBy(how=How.XPATH,using="//input[@placeholder='Enter your name']")
	private WebElement EnterName;
	
	@FindBy(how=How.XPATH,using="//button[text()=' Add user ']")
	private WebElement AddUserTab;

	
	
	public WebElement getEnterName() {
		return EnterName;
	}

	public void setEnterName(WebElement enterName) {
		EnterName = enterName;
	}

	public WebElement getAddUserTab() {
		return AddUserTab;
	}

	public void setAddUserTab(WebElement addUserTab) {
		AddUserTab = addUserTab;
	}
	
}
