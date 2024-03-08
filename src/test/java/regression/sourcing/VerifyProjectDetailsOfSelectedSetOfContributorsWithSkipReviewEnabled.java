package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyProjectDetailsOfSelectedSetOfContributorsWithSkipReviewEnabled extends BaseClass{
	
	@Test
	public static void verifyProjectDetailsOfSelectedSetOfContributorsWithSkipReviewEnabled() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionSelectedContWithSkipReview();
	VDNSourcingMethods.verifyProjectDetailsOfSelectedSetOfContributorsWithSkipReviewEnabled(ProjectName);
	}

}
