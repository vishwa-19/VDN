package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToCreateAndPublishCPDFrameworkProjectCourseSelectedContSkipDis extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToCreateAndPublishCPDFrameworkProjectCourseSelectedContSkipDis() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseWithSkipReviewDisableAndSelConCPD();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName);
	}
}