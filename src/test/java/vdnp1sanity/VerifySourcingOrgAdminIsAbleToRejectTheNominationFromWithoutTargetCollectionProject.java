package vdnp1sanity;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToRejectTheNominationFromWithoutTargetCollectionProject extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToRejectTheNominationFromWithoutTargetCollectionProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.nominateWithoutTargetCollectionThroughTenCard(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleRejectNominationWithoutTargetCollection(ProjectName);

	}
}
