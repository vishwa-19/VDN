package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyOrgadminIsAbleToCreateProjectBySelectingContributorsAndSaveProjectAsDraft extends BaseClass {
	@Test
	public static void verifyOrgadminIsAbleToCreateProjectBySelectingContributorsAndSaveProjectAsDraft() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBookAndSave();
	VDNSourcingMethods.validateOrgadminIsAbleToAddOrRemoveBySelectingContributorsAndSaveProjectAsDraft(ProjectName);
	}
}
