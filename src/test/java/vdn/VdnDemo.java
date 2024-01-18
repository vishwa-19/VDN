package vdn;

import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageObject.VDNObj;
import utility.BaseClass;

public class VdnDemo extends BaseClass {

	@Test
	public static void LaunchSource() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.createProject();
//		UserOnBoarding.VDNlogout();
//		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
//		UserOnBoarding.VDNlogout();
	}
}
