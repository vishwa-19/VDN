package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsAbleToClickOpenAndViewTheProjectDetails extends BaseClass {
	@Test
	public static void verifySourcingOrgadminIsAbleToClickOpenAndViewTheProjectDetails() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.validateSourcingOrgadminIsAbleToClickOpenAndViewTheProjectDetails();
	}

}
