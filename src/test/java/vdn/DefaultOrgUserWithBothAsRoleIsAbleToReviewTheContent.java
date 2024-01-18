package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class DefaultOrgUserWithBothAsRoleIsAbleToReviewTheContent extends BaseClass {
	@Test
	public static void verifyDefaultOrgUserWithBothAsRoleIsAbleToReviewTheContent() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollection();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned Contributor");
	VDNMethods.uploadContentFromContributor(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned BothRole");
	VDNMethods.validateDefaultOrgUserWithBothAsRoleIsAbleToReviewTheContent(ProjectName);
	}
}
