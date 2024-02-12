package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToCreateAndPublishK12FrameworkProjectOfContentPlaylistNomDisAndSkipEnable extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToCreateAndPublishK12FrameworkProjectOfContentPlaylistNomDisAndSkipEnable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectFromYourOrgOnlyWithSkipEnable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName);
	
	}

}
