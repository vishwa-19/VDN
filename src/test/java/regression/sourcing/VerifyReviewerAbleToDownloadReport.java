package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyReviewerAbleToDownloadReport extends BaseClass{
	
	@Test
	public static void verifyReviewerAbleToDownloadReport() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyAllTheReportsAreAvailableInTheReportSection(projectName,"Digital Textbook Level Content Report");

	}

}
