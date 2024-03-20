package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCloseTheLiveProjectViaFrontEnd extends BaseClass{
	
	@Test
	public static void verifyAdminIsAbleToCloseTheLiveProjectViaFrontEnd() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyAdminIsAbleToCloseTheLiveProjectViaFrontEnd(ProjectName);
	}

}
