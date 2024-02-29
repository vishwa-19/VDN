package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminCanSelectOnlyOneFrameworkType extends BaseClass{
	
	@Test
	public static void verifyAdminCanSelectOnlyOneFrameworkType() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifyAdminCanSelectOnlyOneFrameworkType();
	}

}
