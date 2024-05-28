package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributorOrgadminAbleToInitiateNominationByUploadingSample extends BaseClass {
	@Test
	public static void verifyContributorOrgadminAbleToInitiateNominationByUploadingSample() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.uploadTheContentFromIndividualContributorSide(ProjectName);
	VDNMethods.validteIntiateStatusUnderMyProjects(ProjectName);
	}

}
