package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageObject.VDNContributor;
import utility.BaseClass;

public class VerifyAssignedBothRoleShouldAbleToLoginContributorPortalAndAssignedRolesAvailable extends BaseClass {
	@Test
	public static void verifyAssignedBothRoleShouldAbleToLoginContributorPortalAndAssignedRolesAvailable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNContributorMethods.CreateNewProjectwithAllContentTypesWithDigitalTextBooksSkipEnabled();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.addSampleFromContriutionSideWithoutNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Both Role");
	VDNContributorMethods.validateAssignedRolesAvailableonBothRole(ProjectName);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsContributor("Rev Only");
//	VDNContributorMethods.validateReviewerAbleToSubmitForApprovalAndAllContentStatusIsApprovalPending(ProjectName);
	}

}
