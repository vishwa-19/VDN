package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateProjectWith100DigitalTextbookAndPublish extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToCreateProjectWith100DigitalTextbookAndPublish() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.verifycreate100TextBookProjectAndPublish();
	}

}

