package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsAbleToApplyFiltersForNominationDateAndContributionDate extends BaseClass {
	@Test
	public static void verifySourcingOrgadminIsAbleToApplyFiltersForNominationDateAndContributionDate() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.validateyApplyFiltersPopUpPageAndItsDetails();
	VDNSourcingMethods.validateyNominationAndContributionStatusAndApply();
	
	}
}

