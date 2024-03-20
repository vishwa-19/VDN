package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyContentColumnIntheNominationTab extends BaseClass {
	
	@Test
	public static void verifyContentColumnIntheNominationTab() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName1=VDNSourcingMethods.createProjectBookWithSkipReviewEnable();
	VDNSourcingMethods.verifyContentColumnIntheNominationTabWithTextBook(ProjectName1);
//	VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName1);
	
	String ProjectName2=VDNSourcingMethods.createProjectCourseWithSkipReviewDisable();
	VDNSourcingMethods.verifyContentColumnIntheNominationTabWithCourse(ProjectName2);
//	VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName2);
	
	String ProjectName3=VDNSourcingMethods.createProjectContentPlaylistWithSkipReviewEnable();
	VDNSourcingMethods.verifyContentColumnIntheNominationTabWithContentPlaylist(ProjectName3);
//	VDNSourcingMethods.verifyContributionDashboardAvailableForAllTheCombinations(ProjectName3);
	
	
	}

}
