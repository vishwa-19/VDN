
package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyConfirmationPopupPageAndModifyStatusFromIndCont extends BaseClass {
	@Test
	public static void verifyConfirmationPopupPageAndModifyStatusFromIndCont() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNContributorMethods.ContributorIsAbleToNominateProjectWithoutUploadingSample(ProjectName);
		VDNContributorMethods.validateOpenAndModifyButtonsAreDisplayedWithPendingStatus(ProjectName);
		VDNContributorMethods.validateConfirmationPopupPage(ProjectName);
		VDNContributorMethods.verifyStatusModifyAndUploadContent(ProjectName);
	}

}

