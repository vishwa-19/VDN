package contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyAssignedReviewerIsAbleToPublishTheContentForWithoutTC extends BaseClass {
	@Test
	public static void verifyAssignedReviewerIsAbleToPublishTheContentForWithoutTC() throws Exception {
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
		VDNMethods.uploadTheContentFromContOrgContributorSaveAsDraftAndSendForReviewWithoutTC(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Rev Only");
		VDNMethods.validateAssignedReviewerIsAbleApproveNoTC(ProjectName);
		UserOnBoarding.VDNlogout();
	}

}
