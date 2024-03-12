package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContentTabHeaderAreDisplayToAdmin extends BaseClass{
	
	@Test
	public static void verifyContentTabHeaderAreDisplayToAdmin() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName1 = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyDigitalTextbookTabHeaderIsDisplayToAdmin(projectName1);
		String projectName2 = VDNMethods.createProjectWithCourse();
		VDNSourcingMethods.verifyCourseTabHeaderIsDisplayToAdmin(projectName2);
		String projectName3 = VDNMethods.createProjectWithContentPlayList();
		VDNSourcingMethods.verifyContentPlaylistTabHeaderIsDisplayToAdmin(projectName3);
	}

}
