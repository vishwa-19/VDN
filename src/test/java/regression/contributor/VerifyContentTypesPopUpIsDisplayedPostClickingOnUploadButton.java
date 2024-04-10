package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContentTypesPopUpIsDisplayedPostClickingOnUploadButton extends BaseClass {
	@Test
	public static void verifyContirbutionOrgAdminIsAbleToUploadSampleAndNominateWithoutTargetCollection() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(ProjectName);
		
//		UserOnBoarding.loginAsSourcing("Admin");
//		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont Only");
		VDNContributorMethods.VerifyContentTypesPopUpIsDisplayedWithoutTC(ProjectName);
//		UserOnBoarding.VDNlogout();
//		UserOnBoarding.loginAsSourcing("Admin");
//		VDNMethods.verifProjectyWithoutTargetCollectionIsAvailableInMyProjectTabWithNominationPendingStatus(ProjectName);
	}

}
