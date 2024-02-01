package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyProjectDetailForforSourcingOrgadmin extends BaseClass{
	
	@Test
	public static void verifyProjectDetailForforSourcingOrgadmin() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifyProjectDetailForforSourcingOrgadmin();
	}

}
