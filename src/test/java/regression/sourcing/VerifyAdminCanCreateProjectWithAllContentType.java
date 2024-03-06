package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminCanCreateProjectWithAllContentType extends BaseClass{
	
	@Test
	public static void verifyAdminCanCreateProjectWithAllContentType() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.createProjectWithAllContentType();
	}

}
