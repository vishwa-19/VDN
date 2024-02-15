package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyUnitOfTargetCollection extends BaseClass{
	
	@Test
	public static void verifyUnitOfTargetCollection() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName1 = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyUnitOfTargetCollection(projectName1);
		String projectName2 = VDNMethods.createProjectWithCourse();
		VDNSourcingMethods.verifyUnitOfTargetCollection(projectName2);
		String projectName3 = VDNMethods.createProjectWithContentPlayList();
		VDNSourcingMethods.verifyUnitOfTargetCollection(projectName3);
	}

}
