package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyAllTheFieldsAreAvailableInApplyFilterPopUp extends BaseClass{
	
	@Test
	public static void verifyAllTheFieldsAreAvailableInApplyFilterPopUp() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.verifyAllTheFieldsAreAvailableInApplyFilterPopUp();
	}

}
