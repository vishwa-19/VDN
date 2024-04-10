package regression.contributor;


import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyCheckboxIsDisplayedOnContentTypesOpeningProjectFromMyProjectInitiatedStatus extends BaseClass{
	
	@Test
	public static void verifyCheckboxIsDisplayedOnContentTypesOpeningProjectFromMyProjectInitiatedStatus() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyCheckboxIsDisplayedOnContentTypes(ProjectName);
	}

}