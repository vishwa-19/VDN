package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyDownloadPublishedContentDetailsOptionIsAvailableInContributedContentsPage extends BaseClass{
	
	@Test
	public static void verifyDownloadPublishedContentDetailsOptionIsAvailableInContributedContentsPage() throws Exception {
	
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyDownloadPublishedContentDetailsOptionIsAvailableInContributedContentsPage();

	}

}
