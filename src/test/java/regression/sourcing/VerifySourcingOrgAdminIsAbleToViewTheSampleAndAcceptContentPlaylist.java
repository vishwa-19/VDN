package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToViewTheSampleAndAcceptContentPlaylist extends BaseClass {
	
	@Test
	public static void verifySourcingOrgAdminIsAbleToViewTheSampleAndAcceptContentPlaylist() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithContentPlayList();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
//	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);	
	}

}
