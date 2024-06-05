package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyFieldsAvailableInApplyFiltersPopUpInMyProjectsTab extends BaseClass {
	@Test
	public static void verifyFieldsAvailableInApplyFiltersPopUpInMyProjectsTab() throws Exception {
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.validateFieldsAvailableInApplyFiltersPopUpInMyProjectsTab();
	}

}
