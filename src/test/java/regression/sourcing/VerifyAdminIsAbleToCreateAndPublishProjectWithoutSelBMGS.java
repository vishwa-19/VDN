package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateAndPublishProjectWithoutSelBMGS extends BaseClass  {
	@Test
	public static void verifyAdminIsAbleToCreateAndPublishProjectWithoutSelBMGS() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNSourcingMethods.createProjectFromYourOrgOnlyWithSkipDisableTC();
		VDNSourcingMethods.verifyCreatedProjectWithSkipReviewDisabledandNomDisWithoutTC(ProjectName);
		
	}
}
