package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateFromOrganizationOnly extends BaseClass {
	@Test
	public static void VerifyAdminIsAbleToCreateFromOrganizationOnly() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.validateAdminIsAbleToCreateFromOrganizationOnly();
	UserOnBoarding.VDNlogout();
	}
}
