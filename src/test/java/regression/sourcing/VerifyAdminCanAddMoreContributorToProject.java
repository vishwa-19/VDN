package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminCanAddMoreContributorToProject extends BaseClass{
	
	@Test
	public static void verifyAdminCanAddMoreContributorToProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyAdminCanAddMoreContributorToProject();
	}

}
