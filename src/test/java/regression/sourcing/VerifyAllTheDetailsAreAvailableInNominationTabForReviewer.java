package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAllTheDetailsAreAvailableInNominationTabForReviewer extends BaseClass{
	
	@Test
	public static void verifyAllTheDetailsAreAvailableInNominationTabForReviewer() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyAllTheDetailsAreAvailableInNominationTabForReviewer();
	}

}
