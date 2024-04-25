package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyThatOclickingNominateButtonNominationConfirmationPopupPageDisplayed extends BaseClass {

	@Test
	public static void verifyThatOclickingNominateButtonNominationConfirmationPopupPageDisplayed() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.verifyNominationConfirmationPopUp(ProjectName);

	
	}
}
