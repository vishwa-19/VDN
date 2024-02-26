package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContentPlayListForSourcingOrgreviewer extends BaseClass{
	
	@Test
	public static void verifyContentPlayListForSourcingOrgreviewer() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyContentPlayListForSourcingOrgreviewer();
	}

}
