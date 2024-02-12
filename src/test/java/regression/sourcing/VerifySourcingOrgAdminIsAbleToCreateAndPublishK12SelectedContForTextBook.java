package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToCreateAndPublishK12SelectedContForTextBook extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToCreateAndPublishK12SelectedContForTextBook() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectCPWithSkipReviewEnableAndSelConK12();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}
}