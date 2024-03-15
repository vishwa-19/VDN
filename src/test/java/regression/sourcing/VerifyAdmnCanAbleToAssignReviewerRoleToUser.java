package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdmnCanAbleToAssignReviewerRoleToUser extends BaseClass{
	
	@Test
	public static void verifyAdmnCanAbleToAssignReviewerRoleToUser() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectBookWithoutTargetCollectionOrgWithSkipReviewDisabled();
		VDNSourcingMethods.assignReviewerRoleToUser(projectName);
	}

}
