package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToModifyProjectDetails extends BaseClass {
	@Test
	public static void VerifyAdminIsAbleToModifyProjectDetails() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.createProjectWithGuidelineDocument();
	VDNSourcingMethods.editAndModifyTheLiveProject(ProjectName);
//	VDNSourcingMethods.validateyTargetCollectionsOnPopup();
	
	}

}
