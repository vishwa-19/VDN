package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import pageObject.VDNSourcing;
import utility.BaseClass;

public class VerifyAdminIsCreateProjectFromYourOrgWithSkipRevEnableWithoutTC extends BaseClass {
	@Test
	public static void verifyAdminIsCreateProjectFromYourOrgWithSkipRevEnableWithoutTC() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String projectName = VDNSourcingMethods.createProjectBookSkipEnabedWithoutTargetCollection();
	VDNSourcingMethods.verifyCreatedProjectWithNominationOpenAndSkipReviewEnabledNoTC(projectName);
	//VDNSourcingMethods.verifyProjectWithNomAndSkipReviewEnableWithoutTC(projectName);
	}
}