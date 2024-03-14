package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyCountforForSkipReviewDisabledProjectInContributionDashboard extends BaseClass{
	
	@Test
	public static void verifyCountforForSkipReviewDisabledProjectInContributionDashboard() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionOrgWithSkipReviewDisabled();
	VDNSourcingMethods.verifyCountforForSkipReviewDisabledProjectInContributionDashboard(ProjectName);
	}

}
