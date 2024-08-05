package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyAttributeValuesSelectedBySourcingAdminGetsPopulatedInTheEditDetails extends BaseClass{
	
	@Test
	public static void verifyAttributeValuesSelectedBySourcingAdminGetsPopulatedInTheEditDetails() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.verifyContributorAbleUploadTheContentAndFrameworkAttributes(ProjectName);
	}

}
