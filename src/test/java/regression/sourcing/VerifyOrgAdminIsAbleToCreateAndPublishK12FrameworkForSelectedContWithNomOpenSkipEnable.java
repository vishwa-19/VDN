package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToCreateAndPublishK12FrameworkForSelectedContWithNomOpenSkipEnable extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToCreateAndPublishK12FrameworkForSelectedContWithNomOpenSkipEnable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCPWithSkipReviewEnableAndSelConK12();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}
}
