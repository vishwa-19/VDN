package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyCreateProjectPopUpAndDetails extends BaseClass {
	@Test
	public static void verifyCreateProjectPopUpAndDetails() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyProjectPopUpAndDetails();
	}

}
