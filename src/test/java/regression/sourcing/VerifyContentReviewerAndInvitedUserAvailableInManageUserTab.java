package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContentReviewerAndInvitedUserAvailableInManageUserTab extends BaseClass{
	
	@Test
	public static void verifyContentReviewerAndInvitedUserAvailableInManageUserTab() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifyManageUserTab();
	}

}
