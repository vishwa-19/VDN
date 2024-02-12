package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;


public class VerifyNoResultFoundMessageIsDisplayedIfTheSearchResultIsNotAvailable extends BaseClass {

@Test
public static void verifyNoResultFoundMessageIsDisplayedIfTheSearchResultIsNotAvailable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
	VDNSourcingMethods.SourcingOrgAdminIsAbleToSearchWithUserNameAndVerifyNoResultMsg(ProjectName);
//	VDNSourcingMethods.validateNoneOptionIsDisplayedAsDropdown();
	}
}