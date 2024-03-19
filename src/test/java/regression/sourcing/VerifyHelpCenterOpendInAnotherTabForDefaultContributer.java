package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyHelpCenterOpendInAnotherTabForDefaultContributer extends BaseClass{
	
	@Test
	public static void verifyHelpCenterOpendInAnotherTabForDefaultContributer() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyHelpCenterOpendInAnotherTabForDefaultContributer();
	}

}
