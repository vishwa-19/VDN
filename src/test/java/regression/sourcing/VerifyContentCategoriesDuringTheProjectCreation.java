package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContentCategoriesDuringTheProjectCreation extends BaseClass {
	@Test
	public static void verifyContentCategoriesDuringTheProjectCreation() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifyContentCategoriesDuringProjectCreation();
	}

}

