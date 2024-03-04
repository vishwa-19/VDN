package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToEditTheFrameworkTypeWhenProjectInDraftStatus extends BaseClass{
	
	@Test
	public static void verifyAdminIsAbleToEditTheFrameworkTypeWhenProjectInDraftStatus() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBookAndSave();
	VDNSourcingMethods.verifyAdminIsAbleToEditTheFrameworkTypeWhenProjectInDraftStatus(ProjectName);
	}

}
