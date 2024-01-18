package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class AdminIsAbleToCreateProjectAndAccept extends BaseClass {
	@Test
	public static void VerifyAdminIsAbleToCreateProjectAndAccept() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProject();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.VerifyCreatedProjectsAreAvailableOnAllProjectsTabForContOrgAdmin(ProjectName);
	UserOnBoarding.VDNlogout();
	}
}
