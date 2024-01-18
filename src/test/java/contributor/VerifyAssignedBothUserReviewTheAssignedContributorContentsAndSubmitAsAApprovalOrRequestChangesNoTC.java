package contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyAssignedBothUserReviewTheAssignedContributorContentsAndSubmitAsAApprovalOrRequestChangesNoTC extends BaseClass{

	@Test
	public static void VerifyAssignedBothUserReviewTheAssignedContributorContentsAndSubmitAsAApprovalOrRequestChangesNoTC() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("ContOrgAdmin");
		VDNMethods.openAndNominateWithoutTargetCollection(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNominationWithoutTargetCollection(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("ContOrgAdmin");
		VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont Only");
		VDNMethods.uploadTheContentFromContOrgContributorAndSendForReviewWithoutTC(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Both Role");
		VDNMethods.validateAssignedReviewerIsAbleApproveReqChangesNoTC(ProjectName);
	}
}
