package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgadminIsAbleToCreateAndPublishProjectWithGuidelineDocument extends BaseClass {
	
	@Test
	public static void verifyOrgadminIsAbleToCreateAndPublishProjectWithGuidelineDocument() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.createProjectWithGuidelineDocument();
	}
	

}
