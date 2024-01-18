package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class ContributorsAreAbleToUploadASampleAndInitiateNomination extends BaseClass {
	@Test
	public static void verifyContributorsAreAbleToUploadASampleAndInitiateNomination() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.uploadTheContentFromIndividualContributorSide(ProjectName);
	VDNMethods.validteIntiateStatusUnderMyProjects(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.uploadTheContentFromIndividualContributorSide(ProjectName);
	VDNMethods.validteIntiateStatusUnderMyProjects(ProjectName);
	}

}
