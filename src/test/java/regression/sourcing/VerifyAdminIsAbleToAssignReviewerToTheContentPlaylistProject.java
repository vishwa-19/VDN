package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToAssignReviewerToTheContentPlaylistProject extends BaseClass {

@Test
public static void verifyAdminIsAbleToAssignReviewerToTheContentPlaylistProject() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithContentPlayList();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
	//VDNSourcingMethods.validateConfirmationPopUpDisplayedOnClickOfNoneInTheDropDown();
	}
}

