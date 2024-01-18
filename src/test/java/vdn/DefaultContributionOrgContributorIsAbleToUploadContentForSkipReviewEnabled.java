package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class DefaultContributionOrgContributorIsAbleToUploadContentForSkipReviewEnabled  extends BaseClass {
	@Test
	public static void verifyDefaultContributionOrgContributorIsAbleToUploadContentForSkipReviewEnabled() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithCourse();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Default Contributor");
	//VDNMethods.verifyDefaultContributionOrgContributorIsAbleToUploadContentForSkipReviewEnabled(ProjectName);
	}
}
