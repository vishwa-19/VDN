package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyApplyFiltersPopUpPageIsDisplayedPostClickingOnApplyFilterButtonAndItsDetails extends BaseClass {
	@Test
	public static void verifyApplyFiltersPopUpPageIsDisplayedPostClickingOnApplyFilterButtonAndItsDetails() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.validateyApplyFiltersPopUpPageAndItsDetails();
	VDNSourcingMethods.validateyNominationAndContributionStatusAndApply();
	VDNSourcingMethods.validateyTargetCollectionsOnPopup();
	
	}
}
