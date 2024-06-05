package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyAverageRatingCountIsCorrectOnPublishedContentPage extends BaseClass{
	
	@Test
	public static void verifyAverageRatingCountIsCorrectOnPublishedContentPage() throws Exception {
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.VerifyMyContentsTabIsAvailable();
		
	}

}
