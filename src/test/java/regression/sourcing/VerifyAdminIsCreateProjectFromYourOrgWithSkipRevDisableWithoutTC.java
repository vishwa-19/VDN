package regression.sourcing;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsCreateProjectFromYourOrgWithSkipRevDisableWithoutTC extends BaseClass {
	@Test
	public static void verifyAdminAbleToCreateAndPublishProjectWithGuidelineForNT() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectFromYourOrgOnlyWithSkipDisable();
	VDNSourcingMethods.verifyProjectWithSkipReviewDisabledWithoutTC(ProjectName);
	
	}

}
