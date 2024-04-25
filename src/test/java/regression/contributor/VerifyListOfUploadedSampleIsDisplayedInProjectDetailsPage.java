package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyListOfUploadedSampleIsDisplayedInProjectDetailsPage extends BaseClass{
	
	@Test
	public static void verifyListOfUploadedSampleIsDisplayedInProjectDetailsPage() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNContributorMethods.verifyListOfUploadedSampleIsDisplayedInProjectDetailsPage(ProjectName);
	}

}
