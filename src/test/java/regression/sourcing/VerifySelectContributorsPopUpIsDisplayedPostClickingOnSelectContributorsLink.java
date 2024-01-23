package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySelectContributorsPopUpIsDisplayedPostClickingOnSelectContributorsLink extends BaseClass {

	@Test
	public static void verifySelectContributorsPopUpIsDisplayedPostClickingOnSelectContributorsLink() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifySelectContributorsPopUpIsDisplayed();
	}
}
