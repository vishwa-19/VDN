package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToSaveAProjectAsDraftWithManditoryAndNonManditoryField extends BaseClass {
	@Test
	public static void verifyTabsAvailableUnderMyProjectsTab() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectWithDigitalTextBookAndSaveAsDraft();
	VDNSourcingMethods.verifyStatusOfTheProjectCreatedWithEditAndDelOpt(ProjectName);
	
	}

}
