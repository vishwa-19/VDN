package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyKnowMoreButtonIsNotDisplayedAfterGoingToHelpCenter extends BaseClass{
	
	@Test
	public static void verifyKnowMoreButtonIsNotDisplayedAfterGoingToHelpCenter() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNSourcingMethods.verifyKnowMoreButtonIsNotDisplayedAfterGoingToHelpCenter();
	}

}
