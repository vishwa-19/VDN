package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyManageUsersTabIsAvailableForContributorOrgAdmin extends BaseClass {
	@Test
	public static void verifyQuestionMarkIconWithNeedHelpDisplayedUnderManageUser() throws Exception {
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.VerifyManageUsersTabIsAvailableForContOrgAdmin();
	VDNContributorMethods.validateManageUsersTabIsAvailableForOgadmin();
	}

}
