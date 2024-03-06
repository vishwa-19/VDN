package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAllDetailsRreAvailableInTheReportSection extends BaseClass{
	
	@Test
	public static void verifyAllDetailsRreAvailableInTheReportSection() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyAllDetailsRreAvailableInTheReportSection(projectName);
	}

}
