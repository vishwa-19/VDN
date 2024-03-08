package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyProjectDetailsOfSelectedSetOfContributorsWithSkipReviewDisabled extends BaseClass{
	
	@Test
	public static void verifyProjectDetailsOfSelectedSetOfContributorsWithSkipReviewDisabled() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionSelectedCont();
	VDNSourcingMethods.verifyProjectDetailsOfSelectedSetOfContributorsWithSkipReviewDisabled(ProjectName);
	}

}
