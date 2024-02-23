package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCancelThePopUp extends BaseClass{
	
	@Test
	public static void verifyAdminIsAbleToCancelThePopUp() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.VerifyAdminAbleToCancelThePopUp();
	}

}
