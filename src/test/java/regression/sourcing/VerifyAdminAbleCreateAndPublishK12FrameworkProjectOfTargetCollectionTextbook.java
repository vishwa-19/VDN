package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminAbleCreateAndPublishK12FrameworkProjectOfTargetCollectionTextbook extends BaseClass {
	@Test
	public static void verifyAdminAbleCreateAndPublishK12FrameworkProjectOfTargetCollectionTextbook() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectTextBookWithSkipReviewDisable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName);
	}
}
