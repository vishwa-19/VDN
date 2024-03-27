package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyQuestionMarkIconWithNeedHelpDisplayedUnderManageUser extends BaseClass {
	@Test
	public static void verifyQuestionMarkIconWithNeedHelpDisplayedUnderManageUser() throws Exception {
	UserOnBoarding.loginAsSourcing("Cont OrgAdmin");
	VDNSourcingMethods.verifyQuestionMarkIconWithNeedHelp();
	}

}
