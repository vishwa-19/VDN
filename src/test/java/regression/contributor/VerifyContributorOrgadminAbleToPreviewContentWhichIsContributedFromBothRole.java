package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContributorOrgadminAbleToPreviewContentWhichIsContributedFromBothRole extends BaseClass {

	@Test
	public static void verifyContributorOrgadminAbleToPreviewContentWhichIsContributedFromBothRole() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont Only");
	VDNMethods.uploadTheContentFromContOrgContributorAndSendForReview(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Both Role");
	VDNContributorMethods.verifyBothAsRoleIsAbleToReviewTheContent(ProjectName);
	VDNContributorMethods.CloseEditDetailAnduploadContent();
	VDNContributorMethods.UserWithBothRoleIsUnableToReviewHisOwnContent();
//	VDNMethods.validateAssignedReviewerIsAbleApproveOrRequestChanges(ProjectName);
	
	}
}