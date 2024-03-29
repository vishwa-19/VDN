package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class SourcingOrgAdminAbleToViewTheSamplesUploadedByTheUsers extends BaseClass {
	@Test
	public static void verifySourcingOrgAdminAbleToViewTheSamplesUploadedByTheUsers() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.openAndNominateWithUpload(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToToViewTheSamples(ProjectName);
	}
}


