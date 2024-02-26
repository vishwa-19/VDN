package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyPreviouslyAppliedFilter extends BaseClass{
	
	@Test
	public static void verifyPreviouslyAppliedFilter() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		String projectName = VDNSourcingMethods.verifyAssignedReviewerAbleToUseFilterAndResetFilter();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyPreviouslyAppliedFilter(projectName);
		
	}

}
