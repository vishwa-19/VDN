package regression.sourcing;


import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgCreateAndPublishK12FrameworkProjectCourseWithNomAndSkipDis extends BaseClass {
	@Test
	public static void verifyOrgCreateAndPublishK12FrameworkProjectCourseWithNomAndSkipDis() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseYourOrgOnlySkipDis();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipDisable(ProjectName);
	}
}
