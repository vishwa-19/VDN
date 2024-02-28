package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyDefaultContributionOrgAdminIsAbleToAssignRolesForAllTheCombinations extends BaseClass {
	
	
	@Test
	public static void verifyDefaultContributionOrgAdminIsAbleToAssignRolesForAllTheCombinations() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName1=VDNSourcingMethods.createProjectBookWithSkipReviewEnable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName1);
	VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName1);
	
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName1);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	
	String ProjectName2=VDNSourcingMethods.createProjectCourseWithSkipReviewDisable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName2);
	VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName2);
	
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	
	
	String ProjectName3=VDNSourcingMethods.createProjectCourseWithNominationDisAndSkipReviewEnable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipEnabled(ProjectName3);
	VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName3);
	
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	
	
	String ProjectName4=VDNSourcingMethods.createProjectCourseWithNomAndSkipDisable();
	VDNSourcingMethods.verifyOrgAdminAbleToCreateAndPublishWithNominationDisableAndSkipDisable(ProjectName4);
	VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName4);
	
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Admin");
	VDNMethods.verifydefaultContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName4);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsSourcing("Admin");
	}

}