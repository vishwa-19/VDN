package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyDefaultContOrgContributorAbleToUploadSaveAndPublishContentSkipReviewEnabled extends BaseClass {
	@Test
	public static void verifyDefaultContOrgContributorAbleToUploadSaveAndPublishContentSkipReviewEnabled() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNSourcingMethods.createProjectBookWithSkipReviewEnable();
		VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
		VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Admin");
		VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Assigned Contributor");
		VDNSourcingMethods.uploadContentFromDefaultContOrgContributor(ProjectName);
	}
}


