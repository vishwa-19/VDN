package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributionOrAdminAndIndContributorAbleToNominate extends BaseClass {
	@Test
	public static void verifyContentStatusOnTocPageIsApprovedForIndCont() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.verifyListOfUploadedSampleIsDisplayedInProjectDetailsPage(ProjectName);
	UserOnBoarding.VDNlogout();
	
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName1=VDNMethods.createProjectWithTextBookWithUploadPDF();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNContributorMethods.verifyListOfUploadedSampleIsDisplayedInProjectDetailsPage(ProjectName1);
//	UserOnBoarding.VDNlogout();
	
	}
}

