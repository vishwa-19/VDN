package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgreviewerIsNotAbleToSendBackTheContentForCorrectionForClosedProject extends BaseClass{

	@Test
	public static void verifySourcingOrgreviewerIsNotAbleToSendBackTheContentForCorrectionForClosedProject() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		VDNSourcingMethods.verifySourcingOrgAdminIsAbleToAssignReviewerNoTC(ProjectName);
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
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifyPublishRejectedsendBackForCorrectionButtonNotAvailableForCloseProjectNoTC(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.validateSourceOrgReviewerIsUnAbleToPublishTheContentForTheDigitalTextbookNoTC(ProjectName);
		
	}
}


