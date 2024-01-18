package contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyAssignedBothUserReviewTheAssignedContributorContentsAndSubmitAsAApprovalOrRequestChanges extends BaseClass {

	@Test
	public static void VerifyAssignedBothUserReviewTheAssignedContributorContentsAndSubmitAsAApprovalOrRequestChanges() throws Exception {
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
	VDNMethods.validateAssignedReviewerIsAbleApproveOrRequestChanges(ProjectName);
	
	}
}
