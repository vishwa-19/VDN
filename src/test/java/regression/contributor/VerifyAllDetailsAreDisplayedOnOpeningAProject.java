package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAllDetailsAreDisplayedOnOpeningAProject extends BaseClass{
	
	@Test
	public static void verifyAllDetailsAreDisplayedOnOpeningAProject() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNSourcingMethods.createProjectWithGuidelineDocument();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyAllDetailsAreDisplayedOnOpeningAProject(ProjectName);
	}

}
