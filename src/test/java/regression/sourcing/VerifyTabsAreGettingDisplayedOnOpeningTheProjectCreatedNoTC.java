package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyTabsAreGettingDisplayedOnOpeningTheProjectCreatedNoTC extends BaseClass {
	@Test
	public static void verifyTabsAreGettingDisplayedOnOpeningTheProjectCreatedNoTC() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjecName =  VDNSourcingMethods.createProjectWithoutTargetCollectionSkipEnable();
		System.out.print(ProjecName);
		VDNSourcingMethods.verifyDetailsPostOpeningTheProjectCreatedNoTC(ProjecName);
	}

}
