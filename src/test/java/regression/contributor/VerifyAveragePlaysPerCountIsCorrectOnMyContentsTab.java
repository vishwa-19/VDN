package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyAveragePlaysPerCountIsCorrectOnMyContentsTab extends BaseClass{
	
	@Test
	public static void verifyAveragePlaysPerCountIsCorrectOnMyContentsTab() throws Exception {
	
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyTotalPlaysAveragePlaysPerContentAverageRatingFields();

	}

}
