package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyIndividualContributorTypeAndOrganisationContributorType extends BaseClass{
	
	@Test
	public static void verifyIndividualContributorTypeAndOrganisationContributorType() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifySelectContributorsPopUp();
	}

}
