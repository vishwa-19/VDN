package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributionDetailsDisplayedUnderMyContentsTab extends BaseClass{
	
	@Test
	public static void verifyContributionDetailsDisplayedUnderMyContentsTab() throws Exception {
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.validateContributionDetailsDisplayedUnderMyContentsTab();
	}

}
