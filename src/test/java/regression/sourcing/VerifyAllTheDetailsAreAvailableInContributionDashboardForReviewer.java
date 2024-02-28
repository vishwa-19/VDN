package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAllTheDetailsAreAvailableInContributionDashboardForReviewer extends BaseClass{
	
	@Test
	public static void verifyAllTheDetailsAreAvailableInContributionDashboardForReviewer() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifyAllTheDetailsAreAvailableInContributionDashboardForReviewer();
	}

}
