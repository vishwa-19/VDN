package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToDeleteTheDraftProject extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToDeleteTheDraftProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBookAndSave();
	VDNSourcingMethods.verifyAdminIsAbleToDeleteTheDraftProject(ProjectName);
	}
}
