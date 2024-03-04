package regression.sourcing;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyPublishedProjectsAreAvailableUnderForIndContentsNotForTC extends BaseClass {
	@Test
	public static void verifyPublishedProjectsAreAvailableUnderForIndContentsNotForTC() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectFromYourOrgOnlyWithSkipDisable();
	VDNSourcingMethods.verifyPublishedProjectsShouldBeAvailableForTC(ProjectName);
	
	}

}
