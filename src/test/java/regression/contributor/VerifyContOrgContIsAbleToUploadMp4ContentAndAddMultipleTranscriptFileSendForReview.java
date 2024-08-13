package regression.contributor;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContOrgContIsAbleToUploadMp4ContentAndAddMultipleTranscriptFileSendForReview extends BaseClass {
	@Test
	public static void verifyContOrgContIsAbleToUploadMp4ContentAndAddMultipleTranscriptFileSendForReview() throws Exception {
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
	UserOnBoarding.loginAsContributor("Cont Only");
	VDNContributorMethods.validateAddorEditTranscriptPopUpDisplayedOnPostClickAddTranscriptButton(ProjectName);
	VDNContributorMethods.validateIndContAbleToUploadMP4ContentAndAddMultipleTranscriptFilesAndSendForApproval();
	}

}

