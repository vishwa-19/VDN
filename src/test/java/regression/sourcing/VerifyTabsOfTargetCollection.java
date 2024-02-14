package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyTabsOfTargetCollection extends BaseClass{
	
	@Test
	public static void verifyTabsOfTargetCollection() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName1 = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyTabsOfTargetCollection(projectName1,"Digital Textbooks");
		String projectName2 = VDNMethods.createProjectWithCourse();
		VDNSourcingMethods.verifyTabsOfTargetCollection(projectName2,"Courses");
		String projectName3 = VDNMethods.createProjectWithContentPlayList();
		VDNSourcingMethods.verifyTabsOfTargetCollection(projectName3,"Content Playlists");
	}

}
