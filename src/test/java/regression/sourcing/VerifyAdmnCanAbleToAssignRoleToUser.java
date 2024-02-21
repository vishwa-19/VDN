package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdmnCanAbleToAssignRoleToUser extends BaseClass{
	
	@Test
	public static void verifyAdmnCanAbleToAssignRoleToUser() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.assignRoleToUser(projectName);
	}

}
