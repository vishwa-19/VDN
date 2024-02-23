package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import pageObject.VDNSourcing;
import utility.BaseClass;

public class VerifyK12AndCPDFrameworkTypesAreDisplayed extends BaseClass {
	@Test
	public static void verifyK12AndCPDFrameworkTypesAreDisplayed() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyFrameworkTypeK12AndCPDAvailableWhileCreatingProjectWithoutTC();
	}
}
