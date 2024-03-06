package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsAbleToClickDigiTextBookAndDetails extends BaseClass {
	@Test
	public static void verifySourcingOrgadminIsAbleToClickDigiTextBookAndDetails() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.validateSourcingOrgadminIsAbleToClickOpenAndViewProjectDetails(ProjectName);
		VDNSourcingMethods.verifyDigitalTextDetails(ProjectName);

}
}
