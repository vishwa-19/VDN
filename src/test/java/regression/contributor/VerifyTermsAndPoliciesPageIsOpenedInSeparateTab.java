package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyTermsAndPoliciesPageIsOpenedInSeparateTab extends BaseClass{
	
	@Test
	public static void verifyTermsAndPoliciesPageIsOpenedInSeparateTab() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyTermsAndPoliciesPageIsOpenedInSeparateTab();
	}

}
