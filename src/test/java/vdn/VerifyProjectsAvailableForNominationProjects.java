package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyProjectsAvailableForNominationProjects extends BaseClass {
	@Test
	public static void VerifyCreatedProjectsAreAvailableOnAllProjectsTabContAndInd() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProject();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.VerifyCreatedProjectsAreAvailableOnAllProjectsTabForContOrgAdmin(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.VerifyCreatedProjectsAreAvailableOnAllProjectsTab(ProjectName);
	
	}
}
