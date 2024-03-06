package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminAableToCreateAndPublishProjectOfTargetCollectionTextbook extends BaseClass {
	@Test
	public static void verifySourcingOrgAdminAableToCreateAndPublishProjectOfTargetCollectionTextbook() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectBookYourOrgOnly();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName);
	}

}
