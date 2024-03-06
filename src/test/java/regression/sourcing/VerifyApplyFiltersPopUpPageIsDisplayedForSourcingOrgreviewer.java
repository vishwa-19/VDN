package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyApplyFiltersPopUpPageIsDisplayedForSourcingOrgreviewer extends BaseClass {
	@Test
	public static void verifySourcingOrgReviewerWhoHasContentReviewerRoleAndAbleToPublishTheContent() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.validateyApplyFiltersPopUpPageAndItsDetailsForSourceOrgRev();
	VDNSourcingMethods.validateyTargetCollectionsOnPopupForSourcingOrgRev();
	}


}
