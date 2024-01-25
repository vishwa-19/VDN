package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyMessageDisplayedWithSkipTwoLevelReviewOption extends BaseClass {
	@Test
	public static void verifyMessageDisplayedWithSkipTwoLevelReviewOption() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.verifyMessageDisplayedWithSkipTwoLevelReview();
	
	}

}
