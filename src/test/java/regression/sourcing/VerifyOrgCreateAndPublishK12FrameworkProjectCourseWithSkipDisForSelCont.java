package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgCreateAndPublishK12FrameworkProjectCourseWithSkipDisForSelCont extends BaseClass {
	@Test
	public static void verifyOrgCreateAndPublishK12FrameworkProjectCourseWithSkipDisForSelCont() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseWithSkipReviewDisableAndSelConK12();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName);
	}
}