package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class AssignedReviewerIsAbleToViewDetailsWithNominationEnable extends BaseClass {
	@Test
	public static void verifyAssignedReviewerIsAbleToViewDetailsWithNominationEnable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithTextBook();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNMethods.validateAssignedReviewerIsAbleToViewDetailsWithNominationEnable(ProjectName);
	UserOnBoarding.VDNlogout();
	}
}
