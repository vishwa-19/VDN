package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToCreateAndPublishK12FrameworkProjectContentPlaylistNomAndSkipDis extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToCreateAndPublishK12FrameworkProjectContentPlaylistNomAndSkipDis() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectFromYourOrgOnlyWithSkipDisableContentPlaylis();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipDisable(ProjectName);
	
	}

}
