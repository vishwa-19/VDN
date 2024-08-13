package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyTotalPlaysAverageRatingCountsAreUpdatedUnderAllContentsTab extends BaseClass{
	
	@Test
	public static void verifyTotalPlaysAverageRatingCountsAreUpdatedUnderAllContentsTab() throws Exception {
	
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyTotalPlaysAveragePlaysPerContentAverageRatingFields();

	}

}
