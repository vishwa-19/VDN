
package regression.contributor;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySelSetOfContProjectsShouldBeAvailableUnderMyProjectsTabWithApprovedStatus extends BaseClass {
	@Test
	public static void verifySelectedSetOfContributorsAbleToAssignRoles() throws Exception {	
		UserOnBoarding.loginAsSourcing("Admin");	
		String ProjectName=VDNSourcingMethods.createProjectBookWithSkipReviewEnableAndSelIndCon();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Sel Contributor");
		VDNContributorMethods.validateSelSetOfContProjectsShouldBeAvailableUnderMyProjectsTabWithApprovedStatus(ProjectName);
		//VerifySelSetOfContProjectsShouldBeAvailableUnderMyProjectsTabWithApprovedStatus
	}

}
