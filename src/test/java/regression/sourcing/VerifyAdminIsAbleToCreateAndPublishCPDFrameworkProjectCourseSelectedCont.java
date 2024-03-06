package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateAndPublishCPDFrameworkProjectCourseSelectedCont extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToCreateAndPublishCPDFrameworkProjectCourseSelectedCont() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseWithSkipReviewEnableAndSelConCPD();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}
}