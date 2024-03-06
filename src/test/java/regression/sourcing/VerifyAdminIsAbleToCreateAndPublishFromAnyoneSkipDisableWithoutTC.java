package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import pageObject.VDNSourcing;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateAndPublishFromAnyoneSkipDisableWithoutTC extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToCreateAndPublishFromAnyoneSkipDisableWithoutTC() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String projectName = VDNSourcingMethods.createProjectBookSkipDisabledWithoutTargetCollection();
	VDNSourcingMethods.verifyCreatedProjectWithSkipReviewDisabled(projectName);
	}
}
