package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminAbleToViewSampleAndAcceptNomination extends BaseClass{
	
	@Test
	public static void verifySourcingOrgAdminAbleToViewSampleAndAcceptNomination() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.openAndNominateWithUpload(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifySourcingOrgAdminAbleToViewSampleAndAcceptNomination(ProjectName);
	
	}

}
