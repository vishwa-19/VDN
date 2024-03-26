package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class VDNContributor {
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Approval Pending')]//following::button[1]")
	private WebElement clkOpenBtn2;

	public WebElement getClkOpenBtn2() {
		return clkOpenBtn2;
	}
}

