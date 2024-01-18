package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class ContirbutionOrgAdminIsAbleToUploadSampleAndNominateWithoutTargetCollection extends BaseClass{
	@Test
	public static void verifyContirbutionOrgAdminIsAbleToUploadSampleAndNominateWithoutTargetCollection() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifProjectyWithoutTargetCollectionIsAvailableInMyProjectTabWithNominationPendingStatus(ProjectName);
	}
}