
package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyTitlesUnderManageUsersTab extends BaseClass {
	@Test
	public static void verifyTitlesUnderManageUsersTab() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyQuestionMarkIconWithNeedHelp();
	VDNSourcingMethods.validateitlesUnderManageUsersTab();
	}

}
