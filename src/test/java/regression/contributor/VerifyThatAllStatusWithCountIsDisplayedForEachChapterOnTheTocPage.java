package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyThatAllStatusWithCountIsDisplayedForEachChapterOnTheTocPage extends BaseClass{
	
	@Test
	public static void verifyThatAllStatusWithCountIsDisplayedForEachChapterOnTheTocPage() throws Exception {
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
	UserOnBoarding.loginAsContributor("Both Role");
	VDNSourcingMethods.verifyAssignedReviewerIsAbleApproveFromBothRole(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyContentStatusDigitalTextBook(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Both Role");
	VDNContributorMethods.validateTheCountOnTocAndTopForUserWithBothRole(ProjectName);
	}

}
