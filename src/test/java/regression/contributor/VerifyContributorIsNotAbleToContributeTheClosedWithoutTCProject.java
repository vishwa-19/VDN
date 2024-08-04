package regression.contributor;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContributorIsNotAbleToContributeTheClosedWithoutTCProject extends BaseClass {

	@Test
	public static void verifyContributorIsNotAbleToContributeTheClosedWithoutTCProject() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.contributorIsAbleToNominateWithoutTargetCollectionWithSample(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifySourcingOrgAdminIsAbleToViewSampleAcceptNominationWithoutTargetCollection(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont Only");
		VDNContributorMethods.VerifyContentTypesPopUpIsDisplayedWithoutTC(ProjectName);
		VDNContributorMethods.verifyContOrgContributorAbleToUploadContentAndAddAllDetailsInEditDetailsPopUpAndSendForReview();
        UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNSourcingMethods.CloseCreatedProjectNoTC(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont Only");
		VDNContributorMethods.validateyContributorIsNotAbleToContributeTheClosedWithoutTCProject(ProjectName);
	}
}
