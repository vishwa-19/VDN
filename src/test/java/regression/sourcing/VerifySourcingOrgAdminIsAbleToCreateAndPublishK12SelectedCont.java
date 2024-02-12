package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToCreateAndPublishK12SelectedCont extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToCreateAndPublishK12SelectedCont() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCPWithSkipReviewEnableAndSelConK12();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}
}
