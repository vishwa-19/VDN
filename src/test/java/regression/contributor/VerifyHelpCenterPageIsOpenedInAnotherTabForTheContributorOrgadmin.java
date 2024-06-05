package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyHelpCenterPageIsOpenedInAnotherTabForTheContributorOrgadmin extends BaseClass{
	
	@Test
	public static void verifyHelpCenterPageIsOpenedInAnotherTabForTheContributorOrgadmin() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNSourcingMethods.verifyHelpCenterOpendInAnotherTabForDefaultContributer();
	}

}
