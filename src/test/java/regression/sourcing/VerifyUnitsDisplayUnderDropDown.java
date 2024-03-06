package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyUnitsDisplayUnderDropDown extends BaseClass{
	
	@Test
	public static void verifyUnitsDisplayUnderDropDown() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String projectName1 = VDNMethods.createProjectWithDigitalTextBook();
		VDNSourcingMethods.verifyUnitsDisplayUnderDropDown(projectName1);
		String projectName2 = VDNMethods.createProjectWithCourse();
		VDNSourcingMethods.verifyUnitsDisplayUnderDropDown(projectName2);
	}

}
