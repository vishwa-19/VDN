package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import pageObject.VDNSourcing;
import utility.BaseClass;

public class VerifySourcingOrgAdminAbleToSeeAnswerButtonForMCQQuestion extends BaseClass {
	@Test
	public static void verifyAnswerButtonGettingDisplayedOnPreviewForIndMCQ() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNContributorMethods.CreateNewProjectwithAllContentTypesWithDigitalTextBooksSkipEnabled();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.createMCQquestionWithSolutionAndSendForReview(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNContributorMethods.verifySourcingOrgAdminAbleToViewSampleAndAcceptNomination(ProjectName);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsSourcing("Admin");
//	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
//	VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsContributor("Cont Only");
//	VDNContributorMethods.validateAddorEditTranscriptPopUpDisplayedOnPostClickAddTranscriptButton(ProjectName);
//	VDNContributorMethods.validateContributorUnableToAddPDFAsATranscriptFile();
	}

}