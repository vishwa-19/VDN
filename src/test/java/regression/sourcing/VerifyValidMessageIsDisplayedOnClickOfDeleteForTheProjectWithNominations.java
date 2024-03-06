package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyValidMessageIsDisplayedOnClickOfDeleteForTheProjectWithNominations extends BaseClass {
	@Test
	public static void verifyValidMessageIsDisplayedOnClickOfDeleteForTheProjectWithNominations() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProject();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.validateErrorMessageIsDisplayedOnClickOfDeleteForTheProjectWithNominations(ProjectName);
	}
}

	