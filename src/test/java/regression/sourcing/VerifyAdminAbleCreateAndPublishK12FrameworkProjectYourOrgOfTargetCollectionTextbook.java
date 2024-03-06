package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminAbleCreateAndPublishK12FrameworkProjectYourOrgOfTargetCollectionTextbook extends BaseClass {
	@Test
	public static void verifyAdminAbleCreateAndPublishK12FrameworkProjectYourOrgOfTargetCollectionTextbook() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectTextBookWithYourOrgAndSkipReviewDisable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipDisable(ProjectName);
	}
}