package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyReviewerIsAbleToApplyFilterInNominationTab extends BaseClass{
	
	@Test
	public static void verifyReviewerIsAbleToApplyFilterInNominationTab() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyReviewerIsAbleToApplyFilterInNominationTab();
	}

}
