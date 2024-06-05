package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyContributorApplyAndResetTheFilter extends BaseClass{
	
	@Test
	public static void verifyContributorApplyAndResetTheFilter() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyContributorAdminIsAbleToApplyFilterInAllProjectsTab();
	}

}
