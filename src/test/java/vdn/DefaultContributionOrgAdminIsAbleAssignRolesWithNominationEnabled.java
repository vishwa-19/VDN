package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class DefaultContributionOrgAdminIsAbleAssignRolesWithNominationEnabled extends BaseClass{
	@Test
	public static void verifyDefaultContributionOrgAdminIsAbleAssignRolesWithNominationEnabled() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithCourse();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	}
}
