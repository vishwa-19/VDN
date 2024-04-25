package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContributorAdminIsAbleToApplyFilterInAllProjectsTab extends BaseClass{
	
	@Test
	public static void verifyContributorAdminIsAbleToApplyFilterInAllProjectsTab() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyContributorAdminIsAbleToApplyFilterInAllProjectsTab();
	}

}
