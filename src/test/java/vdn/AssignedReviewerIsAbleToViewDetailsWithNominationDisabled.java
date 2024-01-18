package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class AssignedReviewerIsAbleToViewDetailsWithNominationDisabled extends BaseClass {
	@Test
	public static void verifyAssignedReviewerIsAbleToViewDetailsWithNominationDisable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithTextBookWithNominationDisable();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewerNominationDisable(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNMethods.validateAssignedReviewerIsAbleToViewDetailsWithNominationDisable(ProjectName);
	UserOnBoarding.VDNlogout();
	}
}
