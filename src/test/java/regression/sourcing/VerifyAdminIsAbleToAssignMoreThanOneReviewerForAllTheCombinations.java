package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminIsAbleToAssignMoreThanOneReviewerForAllTheCombinations extends BaseClass {
		
	@Test
	public static void verifyAdminIsAbleToAssignMoreThanOneReviewerForAllTheCombinations() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName1=VDNSourcingMethods.createProjectBookWithSkipReviewEnable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName1);
	VDNSourcingMethods.verifySourcingOrgAdminIsAbleToAssignMoreThanOneReviewer(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer2");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName2=VDNSourcingMethods.createProjectCourseWithSkipReviewDisable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName2);
	VDNSourcingMethods.verifySourcingOrgAdminIsAbleToAssignMoreThanOneReviewer(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer2");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName3=VDNSourcingMethods.createProjectCourseWithNominationDisAndSkipReviewEnable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName3);
	VDNSourcingMethods.verifySourcingOrgAdminIsAbleToAssignMoreThanOneReviewer(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer2");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName4=VDNSourcingMethods.createProjectCourseWithNomAndSkipDisable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipDisable(ProjectName4);
	VDNSourcingMethods.verifySourcingOrgAdminIsAbleToAssignMoreThanOneReviewer(ProjectName4);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName4);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Assigned Reviewer2");
	VDNSourcingMethods.verifyAssignedProjectsAreAvailableOnSourceOrgrev(ProjectName4);
	
	}

}