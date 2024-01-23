package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminAbleToCreateProjectBySelectingContributorsAndSaveProjectAsDraft extends BaseClass {

	@Test
	public static void verifyOrgAdminAbleToCreateProjectBySelectingContributorsAndSaveProjectAsDraft() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifySelectContributorsPopUpIsDisplayed();
	}
}
