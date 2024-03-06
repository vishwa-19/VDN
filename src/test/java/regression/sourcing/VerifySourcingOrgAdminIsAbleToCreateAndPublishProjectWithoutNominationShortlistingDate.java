package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToCreateAndPublishProjectWithoutNominationShortlistingDate extends BaseClass {
	@Test
	public static void verifySourcingOrgAdminIsAbleToCreateAndPublishProjectWithoutNominationShortlistingDate() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectBookYourOrgOnly();
	//VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName);
	VDNSourcingMethods.verifyProjectCreatedWithoutNominationShortlistingDate(ProjectName);
	}

}
