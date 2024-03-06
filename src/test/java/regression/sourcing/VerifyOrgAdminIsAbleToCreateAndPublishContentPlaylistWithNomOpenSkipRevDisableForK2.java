package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToCreateAndPublishContentPlaylistWithNomOpenSkipRevDisableForK2 extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToCreateAndPublishContentPlaylistWithNomOpenSkipRevDisableForK2() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectContentPlaylistFromAnyOneK12();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName);
	}

}
