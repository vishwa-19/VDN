package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminAbleToCreateAndPublishTPDFrameworkProjectCourseWithNominationDisAndSkipEnable extends BaseClass {
	@Test
	public static void verifyAdminAbleToCreateAndPublishTPDFrameworkProjectCourseWithNominationDisAndSkipEnable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseWithNominationDisAndSkipReviewEnable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName);
	}
}
