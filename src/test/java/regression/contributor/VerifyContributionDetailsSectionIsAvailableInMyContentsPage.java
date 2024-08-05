package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyContributionDetailsSectionIsAvailableInMyContentsPage extends BaseClass{
	
	@Test
	public static void verifyContributionDetailsSectionIsAvailableInMyContentsPage() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.validateContributionDetailsDisplayedUnderMyContentsTab();
	}

}
