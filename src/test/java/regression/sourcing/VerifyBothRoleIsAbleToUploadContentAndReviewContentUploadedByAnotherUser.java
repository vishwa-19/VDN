package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyBothRoleIsAbleToUploadContentAndReviewContentUploadedByAnotherUser extends BaseClass {

	@Test
	public static void verifyBothRoleIsAbleToUploadContentAndReviewContentUploadedByAnotherUser() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned Contributor");
	VDNSourcingMethods.uploadContentFromDefaultContributor(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned BothRole");
	VDNSourcingMethods.verifyDefaultOrgUserWithBothAsRoleIsAbleToReviewTheContent(ProjectName);
	VDNSourcingMethods.CloseEditDetailAnduploadContent();
	VDNMethods.UserWithBothRoleIsUnableToReviewHisOwnContent();
	
	}
}

