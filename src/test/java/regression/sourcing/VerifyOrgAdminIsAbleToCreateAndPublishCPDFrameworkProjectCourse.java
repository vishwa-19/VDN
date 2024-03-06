package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToCreateAndPublishCPDFrameworkProjectCourse extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToCreateAndPublishCPDFrameworkProjectCourse() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseWithSkipReviewDisable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName);
	}
}
