package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyManageUsersTabIsAvailableForOgadmin extends BaseClass {
	@Test
	public static void verifyManageUsersTabIsAvailableForOgadmin() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyQuestionMarkIconWithNeedHelp();
	VDNSourcingMethods.validateManageUsersTabIsAvailableForOgadmin();
	}

}