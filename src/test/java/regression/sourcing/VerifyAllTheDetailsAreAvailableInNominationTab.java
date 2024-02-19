package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAllTheDetailsAreAvailableInNominationTab extends BaseClass{
	
	@Test
	public static void verifyAllTheDetailsAreAvailableInNominationTab() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyAllTheDetailsAreAvailableInNominationTab(projectName);
	}

}
