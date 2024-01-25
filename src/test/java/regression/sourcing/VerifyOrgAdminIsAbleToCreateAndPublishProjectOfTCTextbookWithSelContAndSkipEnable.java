package regression.sourcing;


import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToCreateAndPublishProjectOfTCTextbookWithSelContAndSkipEnable extends BaseClass {
	
	
	@Test
	public static void verifyOrgAdminIsAbleToCreateAndPublishProjectOfTCTextbookWithSelContAndSkipEnable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectBookWithSkipReviewEnableAndSelCon();
	//VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName);
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}

}