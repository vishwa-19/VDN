package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyNominateButtonIsEnabledAfterSelectionOfTextbook extends BaseClass {
	@Test
	public static void verifyNominateButtonIsEnabledAfterSelectionOfTextbook() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
		VDNSourcingMethods.assignRoleToUser(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.openAndNominateWithUpload(ProjectName);
		
	}

}
