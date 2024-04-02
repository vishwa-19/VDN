package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyQuestionMarkIconWithNeedHelpDisplayedUnderManageUser extends BaseClass {
	@Test
	public static void verifyQuestionMarkIconWithNeedHelpDisplayedUnderManageUser() throws Exception {
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.verifyQuestionMarkOnContOrg();
	}

}
