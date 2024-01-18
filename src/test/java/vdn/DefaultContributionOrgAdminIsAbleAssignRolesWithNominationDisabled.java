
package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;



@Test
public class DefaultContributionOrgAdminIsAbleAssignRolesWithNominationDisabled extends BaseClass{
	public static void verifyDefaultContributionOrgAdminIsAbleAssignRolesWithNominationDisabled() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithTextBookWithNominationDisable();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewerNominationDisable(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	}
}
