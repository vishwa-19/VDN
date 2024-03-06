
package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToDeselectAndSelectTheContributorsUsingCheckbox extends BaseClass {

	@Test
	public static void VerifyAdminIsAbleToDeselectAndSelectTheContributorsUsingCheckbox() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifySelectContributorsPopUpIsDisplayed();
	}
}
