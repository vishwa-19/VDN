package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgReviewerSendBackForCorrectionsTheContent extends BaseClass{
	
	@Test
	public static void verifySourcingOrgReviewerSendBackForCorrectionsTheContent() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
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
		VDNMethods.uploadTheContentFromContOrgContributorSaveAsDraftAndSendForReview(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Rev Only");
		VDNMethods.validateAssignedReviewerIsAbleApprove(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifySourcingOrgAdminSendBackForCorrectionsTheContent(ProjectName);

}

}
