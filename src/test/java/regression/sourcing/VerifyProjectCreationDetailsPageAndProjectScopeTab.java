package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyProjectCreationDetailsPageAndProjectScopeTab extends BaseClass {
	@Test
	public static void verifyProjectCreationDetailsPageAndProjectScopeTab() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyProjectDetailsAndScopeTab();
	}
	
}

