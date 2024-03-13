package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgadminIsAbleToSendBackContentForCorrectionsOnViewContributionList extends BaseClass {
	@Test
	public static void verifyOrgadminIsAbleToApproveRejectedTheViewContributionList() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNSourcingMethods.uploadContentsFromAssignedContributorWithoutTargetColl(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifySourcingOrgAdminIsAbleToApproveRejectAndSendBackTheContentFromWithoutTC(ProjectName);
	}

}
