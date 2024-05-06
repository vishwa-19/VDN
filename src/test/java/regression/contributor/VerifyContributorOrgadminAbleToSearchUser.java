package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributorOrgadminAbleToSearchUser extends BaseClass {
	@Test
	public static void verifyContributorOrgadminAbleToSearchUser() throws Exception {
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.validateContributorOrgadminAbleToSearchUser();
	}

}
