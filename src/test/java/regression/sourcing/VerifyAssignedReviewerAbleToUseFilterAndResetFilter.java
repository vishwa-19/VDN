package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAssignedReviewerAbleToUseFilterAndResetFilter extends BaseClass{

	@Test
	public static void verifyAssignedReviewerAbleToUseFilterAndResetFilter() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyAssignedReviewerAbleToUseFilterAndResetFilter();
	}

}
