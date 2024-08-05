package regression.contributor;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyEnrollmentFormIsDisplayedWhenUserLogsInForFirststTime extends BaseClass{
	
	@Test
	public static void verifyEnrollmentFormIsDisplayedWhenUserLogsInForFirststTime() throws Exception {
	UserOnBoarding.loginAsContributor("First Time");
//	VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
//	VDNContributorMethods.validateToastMessageContributorSendTheNomination(ProjectName);
	}

}

