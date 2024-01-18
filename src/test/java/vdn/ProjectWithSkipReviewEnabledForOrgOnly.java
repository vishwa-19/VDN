package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class ProjectWithSkipReviewEnabledForOrgOnly extends BaseClass {
	@Test
	public static void verifyProjectWithSkipReviewEnabledForOrgOnly() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectBookWithoutTargetCollectionOrgOnly();
		VDNMethods.verifyCreatedProjectWithSkipReviewEnabled(ProjectName);
	}
}
