package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class CreateNewProjectwithAllContentTypes extends BaseClass {
	@Test
	public static void verifyCreateNewProjectwithAllContentTypes() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.validateCreateNewProjectwithAllContentTypes();
	UserOnBoarding.VDNlogout();
	}
}
