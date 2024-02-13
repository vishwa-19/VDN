package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminCanCreateAndPublishProjectWithPartialChapter extends BaseClass{
	
	@Test
	public static void verifyAdminCanCreateAndPublishProjectWithPartialChapter() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.createProjectWithPartialChapter();
	}

}
