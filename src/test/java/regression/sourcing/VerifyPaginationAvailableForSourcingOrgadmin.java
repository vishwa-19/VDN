package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyPaginationAvailableForSourcingOrgadmin extends BaseClass{
	
	@Test
	public static void verifyPaginationAvailableForSourcingOrgadmin() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyPaginationAvailableForSourcingOrgadmin();
	}

}
