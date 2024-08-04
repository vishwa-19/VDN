package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyOnClickingOpenBtnContributorOrgIsAbleToViewTheProjectDetails extends BaseClass {
	@Test
	public static void verifyOnClickingOpenBtnContributorOrgIsAbleToViewTheProjectDetails() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNContributorMethods.CreateNewProjectwithAllContentTypesWithDigitalTextBooksSkipEnabled();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.addSampleFromContriutionSideWithoutNominate(ProjectName);
	VDNContributorMethods.validateOnClickingOpenBtnContributorOrgIsAbleToViewTheProjectDetails(ProjectName);
	}

}
