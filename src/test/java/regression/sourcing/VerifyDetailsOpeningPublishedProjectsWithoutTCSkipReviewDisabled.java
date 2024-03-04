package regression.sourcing;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyDetailsOpeningPublishedProjectsWithoutTCSkipReviewDisabled extends BaseClass {
	@Test
	public static void verifyDetailsOpeningPublishedProjectsWithoutTCSkipReviewDisabled() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectBookSkipDisabledWithoutTargetCollection();
	VDNSourcingMethods.verifyPublishedProjectsShouldBeAvailableForTCWithNomOpenAndSkipDis(ProjectName);
	VDNSourcingMethods.verifyDetailsOpeningPublishedProjectsWithSkipReviewDisabled(ProjectName);
	
	}

}