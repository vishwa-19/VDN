package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToCreateProjectCourseCPDWithNomOpenAndSkipEnable extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToCreateProjectCourseCPDWithNomOpenAndSkipEnable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectWithCourseWithSkipRevEnable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable (ProjectName);
	}
}
