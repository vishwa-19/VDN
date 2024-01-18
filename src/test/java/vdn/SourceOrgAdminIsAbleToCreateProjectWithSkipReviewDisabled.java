package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class SourceOrgAdminIsAbleToCreateProjectWithSkipReviewDisabled extends BaseClass {
	@Test
	public static void verifySourceOrgAdminIsAbleToCreateProjectWithSkipReviewDisabled() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollection();
		VDNMethods.verifyCreatedProjectWithSkipReviewDisabled(ProjectName);
	}
}
