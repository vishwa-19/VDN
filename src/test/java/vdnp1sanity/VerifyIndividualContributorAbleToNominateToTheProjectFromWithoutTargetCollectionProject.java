package vdnp1sanity;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyIndividualContributorAbleToNominateToTheProjectFromWithoutTargetCollectionProject extends BaseClass {

	@Test
	public static void verifyIndividualContributorAbleToNominateToTheProjectFromWithoutTargetCollectionProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
	}
}
