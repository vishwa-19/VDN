

package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminAbleToPublishProjectPostProvidingMandatoryAndNonMandatoryFields extends BaseClass {
	@Test
	public static void verifyAdminAbleToPublishProjectPostProvidingMandatoryAndNonMandatoryFields() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectWithMandatoryAndNonMandatoryFields();
	
	}

}
