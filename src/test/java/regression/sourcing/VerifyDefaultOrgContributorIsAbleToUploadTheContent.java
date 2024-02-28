package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyDefaultOrgContributorIsAbleToUploadTheContent extends BaseClass {
	@Test
	public static void verifyDefaultOrgContributorIsAbleToUploadTheContent() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Assigned Contributor");
	VDNSourcingMethods.uploadContentFromDefaultContributor(ProjectName);
	}
}