package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyViewContributionButtonIsAvailableForApprovedNominationContentPlaylist extends BaseClass {
	
	@Test
	public static void verifyViewContributionButtonIsAvailableForApprovedNominationContentPlaylist() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectContentPlaylistWithSkipReviewEnable();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);	
	VDNSourcingMethods.verifyViewContributionOnApprovedContentPlaylist();
	
	}

}
