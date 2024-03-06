package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class ValidErrorMessageThrownIfAdminTriedToPublishProjectwithoutMandatoryFields extends BaseClass {

	@Test
	public static void validErrorMessageThrownIfAdminTriedToPublishProjectwithoutMandatoryFields() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.validErrorMessagewithoutMandatoryFields();
	}
	
}
