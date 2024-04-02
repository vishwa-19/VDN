package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyConfirmationPopupPage extends BaseClass {

	@Test
	public static void verifyConfirmationPopupPage() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.ContributorIsAbleToNominateProjectWithoutUploadingSample(ProjectName);
	VDNContributorMethods.validateOpenAndModifyButtonsAreDisplayedWithPendingStatus(ProjectName);
	VDNContributorMethods.validateConfirmationPopupPage(ProjectName);
	
	}
}
