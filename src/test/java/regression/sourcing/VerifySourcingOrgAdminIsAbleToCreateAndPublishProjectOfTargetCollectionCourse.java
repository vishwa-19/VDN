package regression.sourcing;


import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToCreateAndPublishProjectOfTargetCollectionCourse extends BaseClass {
	@Test
	public static void verifySourcingOrgAdminIsAbleToCreateAndPublishProjectOfTargetCollectionCourse() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseYourOrgOnly();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName);
	}
}