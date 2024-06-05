package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyDownloadPublishedContentDetailsOptionAvailableInTheFrameworkContributedPage extends BaseClass{
	
	@Test
	public static void verifyDownloadPublishedContentDetailsOptionAvailableInTheFrameworkContributedPage() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.validateToastMessageContributorSendTheNomination(ProjectName);
	}

}
