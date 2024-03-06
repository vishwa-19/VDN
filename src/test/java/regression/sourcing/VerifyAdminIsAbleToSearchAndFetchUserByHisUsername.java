package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;


public class VerifyAdminIsAbleToSearchAndFetchUserByHisUsername extends BaseClass {

@Test
public static void verifyAdminIsAbleToSearchAndFetchUserByHisUsername() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
	VDNSourcingMethods.validateNoneOptionIsDisplayedAsDropdown();
	}
}