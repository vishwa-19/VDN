package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyFrameworkAttributeValuesAreGetsPopulatedInTheEditDetails extends BaseClass{
	
	@Test
	public static void verifyFrameworkAttributeValuesAreGetsPopulatedInTheEditDetails() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.uploadTheContentFromIndContrubutorAndInitiate(ProjectName);
	}

}
