package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class Upload extends BaseClass {
	@Test
	public static void verifySourcingOrgAdminIsAbleToRejectNomination() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithTextBookWithUploadPDF();
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
//	VDNMethods.openAndNominate(ProjectName);
//	UserOnBoarding.VDNlogout();
//	UserOnBoarding.loginAsSourcing("Admin");
//	VDNMethods.verifySourcingOrgAdminIsAbleToRejectNomination(ProjectName);

	}
}
