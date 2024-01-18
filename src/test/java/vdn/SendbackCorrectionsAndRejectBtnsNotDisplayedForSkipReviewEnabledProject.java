package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class SendbackCorrectionsAndRejectBtnsNotDisplayedForSkipReviewEnabledProject extends BaseClass {
	@Test
	public static void verifyDefaultContributionOrgAdminIsAbleAssignRolesWithNominationEnabled() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateAdminIsAbleToCreateFromOrganizationOnlyWithSkipReviewEnable();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned Contributor");
	VDNMethods.uploadContentFromAssignedContributor(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned Reviewer1");
	VDNMethods.validateSendbackCorrectionsAndRejectBtnsNotDisplayed(ProjectName);
	}
}
