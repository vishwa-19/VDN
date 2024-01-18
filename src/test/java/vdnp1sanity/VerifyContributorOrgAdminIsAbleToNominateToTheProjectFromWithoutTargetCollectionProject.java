package vdnp1sanity;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributorOrgAdminIsAbleToNominateToTheProjectFromWithoutTargetCollectionProject extends BaseClass {

	@Test
	public static void verifyContributorOrgAdminIsAbleToNominateToTheProjectFromWithoutTargetCollectionProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("ContOrgAdmin");
	VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
	}
}
