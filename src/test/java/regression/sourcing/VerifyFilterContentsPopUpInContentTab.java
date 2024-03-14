package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyFilterContentsPopUpInContentTab extends BaseClass{
	
	@Test
	public static void verifyFilterContentsPopUpInContentTab() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionOrgWithSkipReviewDisabled();
	VDNSourcingMethods.verifyFilterContentsPopUpInContentTab(ProjectName);
	}

}