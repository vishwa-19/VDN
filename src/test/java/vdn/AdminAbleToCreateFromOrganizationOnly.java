package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class AdminAbleToCreateFromOrganizationOnly extends BaseClass {
	@Test
	public static void AdminAbleToCreateProjectFromOrgOnly() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProject();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.VerifySourcingOrgAdminIsAbleToCreateAndCanViewProjectOnContributor(ProjectName);
	}
}
