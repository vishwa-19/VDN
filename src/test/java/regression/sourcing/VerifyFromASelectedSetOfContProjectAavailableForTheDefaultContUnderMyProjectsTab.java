package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyFromASelectedSetOfContProjectAavailableForTheDefaultContUnderMyProjectsTab extends BaseClass {
	@Test
	public static void verifyDefaultOrgContributorIsAbleToUploadTheContent() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectBookSkipEnableSelectedCont();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned Contributor");
	VDNSourcingMethods.uploadContentFromDefaultContOrgContributor(ProjectName);
	}
}