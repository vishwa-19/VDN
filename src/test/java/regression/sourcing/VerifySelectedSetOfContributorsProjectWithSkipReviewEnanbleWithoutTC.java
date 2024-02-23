package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySelectedSetOfContributorsProjectWithSkipReviewEnanbleWithoutTC extends BaseClass {
	@Test
	public static void verifySelectedSetOfContributorsProjectWithSkipReviewEnanbleWithoutTC() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectBookWithoutTargetCollectionSkipEnableSelectedCont();
	VDNSourcingMethods.verifyCreatedProjectWithNominationOpenAndSkipReviewEnabledNoTC(ProjectName);
	String ProjectName2=VDNSourcingMethods.createProjectBookWithoutTargetCollectionSkipEnableSelectedInd();
	VDNSourcingMethods.verifyCreatedProjectWithNominationOpenAndSkipReviewEnabledNoTC(ProjectName2);
	}
}
