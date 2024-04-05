package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyMyContentsTabIsAvailableForContributorOrg extends BaseClass {
	@Test
	public static void verifyMyContentsTabIsAvailableForContributorOrg() throws Exception {
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.VerifyMyContentsTabIsAvailable();
		
	}

}
