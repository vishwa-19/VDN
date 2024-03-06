package regression.sourcing;


import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateAndPublishProjectWithoutGuidelineForNT extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToCreateAndPublishProjectWithoutGuidelineForNT() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectFromYourOrgOnlyWithoutDocumentWithSkipDisable();
	
	}

}

