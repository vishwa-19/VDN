package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyknowMoreButtonDisplayedPostClickingOnQuestionMark extends BaseClass {
	@Test
	public static void verifyknowMoreButtonDisplayedPostClickingOnQuestionMark() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyknowMoreButtonDisplayed();
	}

}
