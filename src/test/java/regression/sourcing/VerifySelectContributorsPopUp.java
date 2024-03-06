package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySelectContributorsPopUp extends BaseClass{
	
	@Test
	public static void verifySelectContributorsPopUp() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifySelectContributorsPopUp();
	}

}
