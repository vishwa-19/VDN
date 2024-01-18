package vdnp1sanity;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToSendBackToCorrectionTheContentFromWithoutTargetCollectionProject extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToSendBackToCorrectionTheContentFromWithoutTargetCollectionProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.uploadContentFromAssignedContributorWithoutTargetColl(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToSendBackToCorrectionTheContentFromWithoutTargetCollectionProject(ProjectName);
	}
}
