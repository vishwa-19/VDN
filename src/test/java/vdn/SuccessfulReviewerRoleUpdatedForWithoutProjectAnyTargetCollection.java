package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class SuccessfulReviewerRoleUpdatedForWithoutProjectAnyTargetCollection extends BaseClass {
	@Test
	public static void verifySuccessfulReviewerRoleUpdatedForWithoutProjectAnyTargetCollection() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollection();
	VDNMethods.verifyCreatedProjectIsAvailableInIndividualContentWithoutCollectionSection(ProjectName);
	VDNMethods.assignReviewerRoleToTheCreatedProject();
	String ProjectName2=VDNMethods.createProjectBookWithoutTargetCollectionSelectedCont();
	VDNMethods.verifyCreatedProjectIsAvailableInIndividualContentWithoutCollectionSectionForSelected(ProjectName2);
	VDNMethods.assignReviewerRoleToTheCreatedProject();
	}
}
