package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminCanAbleToSelectMultipleStatus extends BaseClass{
	
	@Test
	public static void verifyAdminCanAbleToSelectMultipleStatus() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyAdminCanAbleToSelectMultipleStatus(projectName);
	}

}
