package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOptionsAvailableForSourcingOrgadmin extends BaseClass{
	
	@Test
	public static void verifyOptionsAvailableForSourcingOrgadmin() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verfyOptionForWithoutTC();
	}

}

