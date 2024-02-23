package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToSearchFetchTheUserAndClearTheSearch extends BaseClass{
	
	@Test
	public static void verifyAdminIsAbleToSearchFetchTheUserAndClearTheSearch() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifyAdminIsAbleToSearchFetchTheUserAndClearTheSearch("jaga sourcing");
	}

}
