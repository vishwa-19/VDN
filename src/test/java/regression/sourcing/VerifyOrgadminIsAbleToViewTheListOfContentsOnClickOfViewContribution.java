package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgadminIsAbleToViewTheListOfContentsOnClickOfViewContribution extends BaseClass{
	@Test
	public static void verifyOrgadminIsAbleToViewTheListOfContentsOnClickOfViewContribution() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(ProjectName);
		VDNSourcingMethods.verifyViewContributionOnApprovedContent();
		
	}
}
