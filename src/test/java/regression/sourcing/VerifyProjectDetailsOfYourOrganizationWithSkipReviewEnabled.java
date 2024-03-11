package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyProjectDetailsOfYourOrganizationWithSkipReviewEnabled extends BaseClass{
	
	@Test
	public static void verifyProjectDetailsOfYourOrganizationWithSkipReviewEnabled() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionOrgOnly();
	VDNSourcingMethods.verifyProjectDetailsOfYourOrganizationWithSkipReviewEnabled(ProjectName);
	}

}
