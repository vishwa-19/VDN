package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerfiCreateNewProjectPopUp extends BaseClass{
	
	@Test
	public static void verfiCreateNewProjectPopUp() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verfiCreateNewProjectPopUp();
	}

}
