package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyFieldsAvailableOnProjectScopePage extends BaseClass {
	@Test
	public static void verifyFieldsAvailableOnProjectScopePage() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyFieldsOnProjectScopePage();
	}
	
}
