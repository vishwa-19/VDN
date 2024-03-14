package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgadminIsNotAbleToModifyProjectScopeWithoutTC extends BaseClass {
	@Test
	public static void verifyOrgadminIsNotAbleToModifyProjectScopeWithoutTC() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods. createProjectWithMandatoryAndNonMandatoryFields();
	VDNSourcingMethods.VerifyNotAbleToModifProjectScopePostPublishing(ProjectName);
	
	}
}
