
package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyTheDetailsAndCountsForSkipReviewEnabledProjectInTheContributionDashboard extends BaseClass {
	@Test
	public static void verifyTheDetailsAndCountsForSkipReviewEnabledProjectInTheContributionDashboard() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.validateCreateNewProjectwithAllContentTypesSkipRevEnable();
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
	UserOnBoarding.loginAsContributor("Cont Only");
	VDNSourcingMethods.uploadTheContentFromContOrgContributorSaveAsDraftAndSendForReview(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Rev Only");
	VDNSourcingMethods .verifyAssignedReviewerIsAbleApprove(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyContentStatusDigitalTextBook(ProjectName);
	VDNSourcingMethods.verifyDetailsAndCountsContributionDashboardWithSkipReviewEnabled();
	}
}