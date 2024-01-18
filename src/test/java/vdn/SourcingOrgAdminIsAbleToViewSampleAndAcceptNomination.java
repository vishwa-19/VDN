package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class SourcingOrgAdminIsAbleToViewSampleAndAcceptNomination extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToViewSampleAndAcceptNomination() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("ContOrgAdmin");
	VDNMethods.nominateWithoutTargetCollectionThroughTenCard(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(ProjectName);
	}
}
