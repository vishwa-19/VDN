package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyConfirmationPopUpIsDisplayedOnClickOfDeleteIconForTheDraftProject extends BaseClass {

	@Test
	public static void verifyConfirmationPopUpIsDisplayedOnClickOfDeleteIconForTheDraftProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBookAndSave();
	VDNSourcingMethods.verifyConfirmationPopUpIsDisplayed(ProjectName);
	}
}
