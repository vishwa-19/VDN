package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributorIsAbleToOpenProjectFromAllProjectsTab extends BaseClass {
	@Test
	public static void verifyContributorIsAbleToOpenProjectFromAllProjectsTab() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProject();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.VerifyCreatedProjectsAreAvailableOnAllProjectsTabForContOrgAdmin(ProjectName);
	}

}
