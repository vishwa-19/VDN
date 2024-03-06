package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminCanCreateAndSaveAsDraftProjectWithPartialChapter extends BaseClass{
	
	@Test
	public static void verifyAdminCanCreateAndSaveAsDraftProjectWithPartialChapter() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.createAndSaveAsDraftProjectWithPartialChapter();
	}

}
