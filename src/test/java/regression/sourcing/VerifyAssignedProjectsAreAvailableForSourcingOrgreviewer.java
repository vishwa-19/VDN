package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAssignedProjectsAreAvailableForSourcingOrgreviewer extends BaseClass {
	
	@Test
	public static void verifyAssignedProjectsAreAvailableForSourcingOrgreviewer() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName1=VDNSourcingMethods.createProjectBookWithSkipReviewEnable();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName1);
	UserOnBoarding.VDNlogout();
	
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName2=VDNSourcingMethods.createProjectCourseWithSkipReviewDisable();
	VDNMethods.verifySourcingOrgAdminIsAbleToAssignReviewer(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName2);
	UserOnBoarding.VDNlogout();

	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName3=VDNSourcingMethods.createProjectCourseWithNominationDisAndSkipReviewEnable();
	VDNSourcingMethods .verifySourcingOrgAdminIsAbleToAssignReviewerWithNomDisable(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName3);
	UserOnBoarding.VDNlogout();

	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName4=VDNSourcingMethods.createProjectCourseWithNomAndSkipDisable();
	VDNSourcingMethods.verifySourcingOrgAdminIsAbleToAssignReviewerWithNomDisable(ProjectName4);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName4);

	}

}