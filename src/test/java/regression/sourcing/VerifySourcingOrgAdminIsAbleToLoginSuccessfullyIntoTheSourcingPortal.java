package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToLoginSuccessfullyIntoTheSourcingPortal extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToLoginSuccessfullyIntoTheSourcingPortal() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	}
}
