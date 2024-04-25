package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributorSelectTheContentTypesAndUploadSample extends BaseClass{
	
	@Test
	public static void verifyContributorSelectTheContentTypesAndUploadSample() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNMethods.openAndNominateWithUpload(ProjectName);
	}

}
