package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyAdminCanCreateProjectWithFewContentType extends BaseClass{
	
	@Test
	public static void verifyAdminCanCreateProjectWithFewContentType() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.createProject();
	}

}
