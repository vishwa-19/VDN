package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyThatContributorIsAbleToResetTheFiltersInMyProjectsTab extends BaseClass{
	
	@Test
	public static void verifyThatContributorIsAbleToResetTheFiltersInMyProjectsTab() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyContributorAdminIsAbleToApplyFilterInAllProjectsTab();
	}

}
