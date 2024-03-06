package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyMyProjectTabForSourcingOrgreviewer extends BaseClass{
	
	@Test
	public static void verifyMyProjectTabForSourcingOrgreviewer() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyMyProjectTabForSourcingOrgreviewer();
	}

}
