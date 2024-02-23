package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAllTheReportsAreAvailableInTheReportSection extends BaseClass{
	
	@Test
	public static void verifyAllTheReportsAreAvailableInTheReportSection() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyAllTheReportsAreAvailableInTheReportSection(projectName,"Digital Textbook Level Content Report");
		String projectName1 = VDNMethods.createProjectWithCourse();
		VDNSourcingMethods.verifyAllTheReportsAreAvailableInTheReportSection(projectName1,"Course Level Content Report");
		String projectName2 = VDNMethods.createProjectWithContentPlayList();
		VDNSourcingMethods.verifyAllTheReportsAreAvailableInTheReportSection(projectName2,"Content Playlist Level Content Report");
	}

}
