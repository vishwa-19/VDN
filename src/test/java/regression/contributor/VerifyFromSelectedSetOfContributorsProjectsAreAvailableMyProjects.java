package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyFromSelectedSetOfContributorsProjectsAreAvailableMyProjects extends BaseClass {
	@Test
	public static void verifyOrgAdminIsAbleToCreateAndPublishProjectOfTCTextbookWithSelContAndSkipEnable() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectBookWithSkipReviewEnableAndSelCon();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevEnable(ProjectName);
	}

}
