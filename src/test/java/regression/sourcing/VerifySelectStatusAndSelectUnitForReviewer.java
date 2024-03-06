package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySelectStatusAndSelectUnitForReviewer extends BaseClass{
	
	@Test
	public static void verifySelectStatusAndSelectUnitForReviewer() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.assignRoleToUser(projectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifySelectStatusAndSelectUnitForReviewer(projectName);
	}

}
