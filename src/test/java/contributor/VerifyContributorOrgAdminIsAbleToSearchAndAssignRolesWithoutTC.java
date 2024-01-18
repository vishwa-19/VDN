package contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributorOrgAdminIsAbleToSearchAndAssignRolesWithoutTC extends BaseClass {
	@Test
	public static void verifyContributorOrgAdminIsAbleToSearchAndAssignRolesWithoutTC() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("ContOrgAdmin");
		VDNMethods.openAndNominateWithoutTargetCollection(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNominationWithoutTargetCollection(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("ContOrgAdmin");
		VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	}

}
