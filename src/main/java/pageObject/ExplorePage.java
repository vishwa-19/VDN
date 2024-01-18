package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExplorePage {
	
	@FindBy(how=How.XPATH,using="//button[@data-translate='btnExploreDiksha']")
	private WebElement Explorebutton;

	public WebElement getExplorebutton() {
		return Explorebutton;
	}
 
}
