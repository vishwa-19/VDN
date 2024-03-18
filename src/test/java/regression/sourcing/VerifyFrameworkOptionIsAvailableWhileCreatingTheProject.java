package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyFrameworkOptionIsAvailableWhileCreatingTheProject extends BaseClass{
	
	@Test
	public static void verifyFrameworkOptionIsAvailableWhileCreatingTheProject() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyFrameworkOptionIsAvailableWhileCreatingTheProject();
	}

}
