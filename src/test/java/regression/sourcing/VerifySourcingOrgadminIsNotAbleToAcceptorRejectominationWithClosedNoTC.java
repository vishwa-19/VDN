package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsNotAbleToAcceptorRejectominationWithClosedNoTC extends BaseClass{
	@Test
	public static void VerifySourcingOrgadminIsNotAbleToAcceptorRejectominationWithClosedNoTC() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.SourcingOrgadminIsNotAbleToAcceptorRejectominationWithClosedNoTC(ProjectName);
//		VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(ProjectName);
//		VDNSourcingMethods.verifyViewContributionOnApprovedContent();
		
	}
}

