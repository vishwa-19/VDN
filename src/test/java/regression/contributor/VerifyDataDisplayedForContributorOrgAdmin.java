package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyDataDisplayedForContributorOrgAdmin extends BaseClass {
	@Test
	public static void verifyDataDisplayedForContributorOrgAdmin() throws Exception {
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.validateDataDisplayedForContributorOrgAdmin();
	}

}
