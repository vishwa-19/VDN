package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class TotalSampleCountUploadedShouldBeDisplayedOnTheTOCPage extends BaseClass{
	
	@Test
	public static void totalSampleCountUploadedShouldBeDisplayedOnTheTOCPage() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.totalSampleCountUploadedShouldBeDisplayedOnTheTOCPage(ProjectName);

	}

}
