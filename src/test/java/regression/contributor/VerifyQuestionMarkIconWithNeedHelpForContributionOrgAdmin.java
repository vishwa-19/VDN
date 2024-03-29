package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyQuestionMarkIconWithNeedHelpForContributionOrgAdmin extends BaseClass {
	@Test
	public static void verifyQuestionMarkIconWithNeedHelpForContributionOrgAdmin() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.verifyQuestionMarkIconWithNeedHelpUnderNomTab(ProjectName);
	}

}
