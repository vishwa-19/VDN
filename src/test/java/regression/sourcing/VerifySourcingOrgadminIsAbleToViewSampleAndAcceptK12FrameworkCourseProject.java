package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsAbleToViewSampleAndAcceptK12FrameworkCourseProject extends BaseClass {
	@Test
	public static void verifyViewContributionButtonIsAvailableForApprovedNominationContentPlaylist() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectCourseWithSkipReviewEnableK12Framework();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
//	VDNMethods.openAndNominate(ProjectName);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsSourcing("Admin");
	//VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);	
	//VDNSourcingMethods.verifyViewContributionOnApprovedContentPlaylist();
	
	}


}
