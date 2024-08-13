package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyTheAverageRatingOfTheIndividualContent extends BaseClass{
	
	@Test
	public static void verifyTheAverageRatingOfTheIndividualContent() throws Exception {
	
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyTotalPlaysAveragePlaysPerContentAverageRatingFields();

	}

}
