package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyFilterWhileCreatingProject extends BaseClass{
	
	@Test
	public static void verifyFilterWhileCreatingProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.applyAndResetFilterWhileCreatingProject();
	}

}