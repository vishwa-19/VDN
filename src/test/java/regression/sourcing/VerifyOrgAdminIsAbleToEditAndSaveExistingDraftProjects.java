package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgAdminIsAbleToEditAndSaveExistingDraftProjects extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToEditAndSaveExistingDraftProjects() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectWithDigitalTextBookAndSaveAsDraft();
	VDNSourcingMethods.verifyAdminIsAbleToEditProjectInDraftStatus(ProjectName);
	
	}

}


