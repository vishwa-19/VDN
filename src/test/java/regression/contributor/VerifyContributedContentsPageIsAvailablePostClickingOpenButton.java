package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributedContentsPageIsAvailablePostClickingOpenButton extends BaseClass{
	
	@Test
	public static void verifyContributedContentsPageIsAvailablePostClickingOpenButton() throws Exception {
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNContributorMethods.validateContributedContentsPageIsAvailablePostClickingOpenButton();
	}

}

