package regression.contributor;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyIndContAbleToUploadWEBMContentAndAddMultipleTranscriptFilesAndSendForApproval extends BaseClass {
	@Test
	public static void verifyIndContAbleToUploadMP4ContentAndAddMultipleTranscriptFilesAndSendForApproval() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNContributorMethods.CreateNewProjectwithAllContentTypesWithDigitalTextBooksSkipEnabled();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.addSampleFromContriutionSideWithoutNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.validateAddorEditTranscriptPopUpDisplayedOnWebmPostClickAddTranscriptButton(ProjectName);
	VDNContributorMethods.validateIndContAbleToUploadMP4ContentAndAddMultipleTranscriptFilesAndSendForApproval();

	}

}

