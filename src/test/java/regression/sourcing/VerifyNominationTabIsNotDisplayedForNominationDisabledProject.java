package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyNominationTabIsNotDisplayedForNominationDisabledProject extends BaseClass {
	@Test
	public static void verifyNominationTabIsNotDisplayedForNominationDisabledProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCourseWithNomAndSkipDisable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipDisable(ProjectName);
	}
}
