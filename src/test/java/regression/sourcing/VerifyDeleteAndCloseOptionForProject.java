package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyDeleteAndCloseOptionForProject extends BaseClass{
	
	@Test
	public static void verifyDeleteAndCloseOptionForProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectBookWithoutTargetCollectionSelectedCont();
	VDNSourcingMethods.verifyDeleteAndCloseOptionForProjectWithNomination(ProjectName);
	String draftProjectName = VDNMethods.createProjectWithDigitalTextBookAndSave();
	VDNSourcingMethods.verifyAdminIsAbleToDeleteTheDraftProject(draftProjectName);
	}

}
