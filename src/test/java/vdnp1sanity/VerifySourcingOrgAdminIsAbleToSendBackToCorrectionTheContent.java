package vdnp1sanity;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToSendBackToCorrectionTheContent extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToSendBackToCorrectionTheContent() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.addSampleFromContriutionSideWithoutNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.uploadContentAndVerifyApprovalPendingStatusInTOCPostPublish(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.validateSourcingOrgAdminIsAbleToSendBackToTheCorrectionTheContent(ProjectName);
	}
}
