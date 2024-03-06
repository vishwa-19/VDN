package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgCreateAndPublishK12FrameworkProjectCourseWithSkipEnableForSelCont extends BaseClass {
	@Test
	public static void verifyOrgCreateAndPublishK12FrameworkProjectCourseWithSkipEnableForSelCont() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseWithSkipReviewEnableAndSelConK12();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}
}