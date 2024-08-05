

package regression.contributor;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyIndContributorAbleToSelectTranscriptLanguageUsingDropDownAndAddTranscriptFile extends BaseClass {
	@Test
	public static void verifyIndContributorAbleToSelectTranscriptLanguageUsingDropDownAndAddTranscriptFile() throws Exception {
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
	VDNContributorMethods.validateAddorEditTranscriptPopUpDisplayedOnPostClickAddTranscriptButton(ProjectName);
	VDNContributorMethods.validateIndContributorAbleAddTranscriptFile();

	}

}

