package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySelectedSetOfContributorsAbleToAssignRoles extends BaseClass {
	@Test
	public static void verifySelectedSetOfContributorsAbleToAssignRoles() throws Exception {	
		UserOnBoarding.loginAsSourcing("Admin");	
		String ProjectName=VDNSourcingMethods.createProjectBookSkipEnableSelectedCont();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	}

}
