package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class ProjectWithSkipReviewDisabledForSetOfContributors extends BaseClass {
	@Test
	public static void verifyProjectWithSkipReviewDisabledForSetOfContributors() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionSelectedCont();
	VDNMethods.verifyCreatedProjectIsAvailableInIndividualContentWithoutCollectionSectionForSelected(ProjectName);
	String ProjectName2=VDNMethods.createProjectBookWithoutTargetCollectionSelectedInd();
	VDNMethods.verifyCreatedProjectIsAvailableInIndividualContentWithoutCollectionSectionForSelected(ProjectName2);
	}
}
