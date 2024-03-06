package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToSortTheUserBasedOnNameAndRole extends BaseClass{
	
	@Test
	public static void verifyAdminIsAbleToSortTheUserBasedOnNameAndRole() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifyAdminIsAbleToSortTheUserBasedOnNameAndRole();
	}

}
