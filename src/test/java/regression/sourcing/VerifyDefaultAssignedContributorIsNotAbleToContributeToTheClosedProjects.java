package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyDefaultAssignedContributorIsNotAbleToContributeToTheClosedProjects extends BaseClass {
	@Test
	public static void verifyAssignedReviewerIsAbleToViewDetailsWithNominationDisable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithTextBookWithNominationDisable();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.CloseCreatedProject(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Default Contributor");
	VDNSourcingMethods.VerifyDefaultAssignedContributorIsUnableToContributeToClosed(ProjectName);
	
	
	}

}
