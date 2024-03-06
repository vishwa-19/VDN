package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgReviewerWhoHasContentReviewerRoleAndAbleToPublishTheContent extends BaseClass {

	@Test
	public static void verifySourcingOrgReviewerWhoHasContentReviewerRoleAndAbleToPublishTheContent() throws Exception {
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
	VDNMethods.validateSourceOrgReviewerIsAbleToPublishTheContentForTheDigitalTextbook(ProjectName);
	
	}
}

