package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyNomDisProjectIsAvailableOnMyProjectsTabWithApprovedStatusForDefCont extends BaseClass {
	@Test
	public static void verifyNomDisProjectIsAvailableOnMyProjectsTabWithApprovedStatusForDefCont() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNSourcingMethods.createProjectCourseWithNominationDisAndSkipReviewEnable();
		VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Admin");
		VDNMethods.verifyNominationDisabledProjectAvailableOnMyProjectsTabForDefCont(ProjectName);
	}
}
