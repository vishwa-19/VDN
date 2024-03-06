package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminsAbleToCreateAndPublishFrameworkProjectOfContentPlaylist extends BaseClass {
	@Test
	public static void verifyOrgAdminsAbleToCreateAndPublishFrameworkProjectOfContentPlaylist() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectContentPlaylistFromAnyOneK12WithSkipEnable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}

}
