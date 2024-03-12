package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyProjectDetailsOfYourOrganizationWithSkipReviewDisabled extends BaseClass{
	
	@Test
	public static void verifyProjectDetailsOfYourOrganizationWithSkipReviewDisabled() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionOrgWithSkipReviewDisabled();
	VDNSourcingMethods.verifyProjectDetailsOfYourOrganizationWithSkipReviewDisabled(ProjectName);
	}

}
