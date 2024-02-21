package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyQuestionMarkIconWithNeedHelpInManageUsersTab extends BaseClass {
	@Test
	public static void VerifyQuestionMarkIconWithNeedHelpInManageUsersTab() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyQuestionMarkIconWithNeedHelp();
	}

}
