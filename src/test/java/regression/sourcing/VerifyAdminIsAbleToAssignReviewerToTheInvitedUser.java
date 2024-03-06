package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToAssignReviewerToTheInvitedUser extends BaseClass{
	
	@Test
	public static void verifyAdminIsAbleToAssignReviewerToTheInvitedUser() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectWithContentPlayList();
		VDNSourcingMethods.verifyAdminIsAbleToAssignReviewerToTheInvitedUser(ProjectName);
		
		}

}
