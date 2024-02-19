package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToApplyStatusFilterAndFetchTheResultInTheNominationStatus extends BaseClass{
	
	@Test
	public static void verifyAdminIsAbleToApplyStatusFilterAndFetchTheResultInTheNominationStatus() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyStatusFilterInNominationTab(projectName);
	}

}
