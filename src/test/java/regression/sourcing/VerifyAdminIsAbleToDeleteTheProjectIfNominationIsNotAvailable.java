package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import pageObject.VDNSourcing;
import utility.BaseClass;

public class VerifyAdminIsAbleToDeleteTheProjectIfNominationIsNotAvailable extends BaseClass {
	@Test
	public static void verifyAdminIsAbleToDeleteTheProjectIfNominationIsNotAvailable() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String Project =  VDNMethods.createProject();
		VDNSourcingMethods.AdminIsAbleToDeleteProjectWithoutNomination(Project);
		VDNSourcingMethods.AdminIsAbleToDeleteThePrpjectWithoutTargetCol(Project);
	}
}
