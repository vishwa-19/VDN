package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class SourcingOrgAdminIsAbleToAssignReviewer extends BaseClass {
	@Test
	public static void verifySourcingOrgAdminIsAbleToAssignReviewer() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithCourse();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
	}
}
