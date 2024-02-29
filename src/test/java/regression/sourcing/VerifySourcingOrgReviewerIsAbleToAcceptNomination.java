package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgReviewerIsAbleToAcceptNomination extends BaseClass {

	@Test
	public static void verifySourcingOrgReviewerWhoHasContentReviewerRoleAndAbleToSendTheContentForCor() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName1 = VDNMethods.createProjectWithDigitalTextBook();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName2 = VDNSourcingMethods.createProjectWithCourseWithSkipRevEnable();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName3 = VDNSourcingMethods.createProjectContentPlaylistFromAnyOneK12();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName3);
	
	}
}
