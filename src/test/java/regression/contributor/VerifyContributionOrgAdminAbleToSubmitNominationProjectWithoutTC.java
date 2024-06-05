package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributionOrgAdminAbleToSubmitNominationProjectWithoutTC extends BaseClass {
	
	@Test
	public static void verifyAssignedReviewerIsAbleToPublishTheContentForWithoutTC() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.openAndNominateUploadWithoutTC(ProjectName);
		
	}

}
