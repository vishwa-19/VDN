package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyApplyFilterPopUpPage extends BaseClass{
	
	@Test
	public static void verifyApplyFilterPopUpPage() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyApplyFilterPopUp();
	}

}
