package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyTooltipTextIsDisplayedOnTheDownloadPublishedContentDetailsButton extends BaseClass{
	
	@Test
	public static void verifyTooltipTextIsDisplayedOnTheDownloadPublishedContentDetailsButton() throws Exception {
	
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyDownloadPublishedContentDetailsOptionIsAvailableInContributedContentsPage();

	}

}
