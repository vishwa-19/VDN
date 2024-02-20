package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import pageObject.VDNSourcing;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateAndPublishFromAnyoneWithoutTC extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToCreateAndPublishFromAnyoneWithoutTC() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.createProjectBookSkipEnabedWithoutTargetCollection();
	}
}

