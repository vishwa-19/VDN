package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyTotalAndApprovalPendingCountAvailableForAssignedReviewer extends BaseClass{
	
	@Test
	public static void verifyTotalAndApprovalPendingCountAvailableForAssignedReviewer() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.assignRoleToUser(projectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyTotalAndAwaitingForMyReviewCountIsAvailable(projectName);
	}

}
