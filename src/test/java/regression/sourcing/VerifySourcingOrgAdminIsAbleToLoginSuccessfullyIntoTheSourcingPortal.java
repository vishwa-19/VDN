package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToLoginSuccessfullyIntoTheSourcingPortal extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToLoginSuccessfullyIntoTheSourcingPortal() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
//	String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsContributor("Ind Contributor");
//	VDNMethods.openAndNominate(ProjectName);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsSourcing("Admin");
//	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);
	}
}
