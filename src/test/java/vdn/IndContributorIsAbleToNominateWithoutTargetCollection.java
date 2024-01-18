package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class IndContributorIsAbleToNominateWithoutTargetCollection extends BaseClass{
	@Test
	public static void verifyIndContributorIsAbleToNominateWithoutTargetCollection() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithoutTargetCollection();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Ind Contributor");
	VDNMethods.IndContributorIsAbleToNominateWithoutTargetCollectionThroughTenCard(ProjectName);
	}
}
