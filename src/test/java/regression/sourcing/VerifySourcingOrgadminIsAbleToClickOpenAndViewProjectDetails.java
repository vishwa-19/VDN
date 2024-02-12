package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsAbleToClickOpenAndViewProjectDetails extends BaseClass {
	@Test
	public static void verifySourcingOrgadminIsAbleToClickOpenAndViewProjectDetails() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.validateSourcingOrgadminIsAbleToClickOpenAndViewProjectDetails(ProjectName);

}
}