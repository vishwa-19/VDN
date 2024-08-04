package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyThatIndividualContributorIsAbleToContributeForCpdFrameWorkTypes extends BaseClass{
	
	@Test
	public static void verifyThatIndividualContributorIsAbleToContributeForCpdFrameWorkTypes() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNMethods.createNewProjectwitCpdFrameWorkType();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNContributorMethods.uploadThePDFAndEPubContentFromContributor(ProjectName);
		}

}
