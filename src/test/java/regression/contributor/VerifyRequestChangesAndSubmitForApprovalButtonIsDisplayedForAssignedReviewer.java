package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyRequestChangesAndSubmitForApprovalButtonIsDisplayedForAssignedReviewer extends BaseClass {

	@Test
	public static void verifyRequestChangesAndSubmitForApprovalButtonIsDisplayedForAssignedReviewer() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNContributorMethods.CreateNewProjectwithAllContentTypesWithDigitalTextBooksSkipEnabled();
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
	VDNContributorMethods.uploadEtextAndExplinitionContentFromContOrgContributorAndSendForReview(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Rev Only");
	VDNContributorMethods.validateContributionOrgReviewerIsAbleToAcceptAndRequestChangesOfDT(ProjectName);
	
	}
}

