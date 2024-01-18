package vdnp1sanity;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminIsAbleToRejectNomination extends BaseClass {

	@Test
	public static void verifySourcingOrgAdminIsAbleToRejectNomination() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProject();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToRejectNomination(ProjectName);
	UserOnBoarding.VDNlogout();
	
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName2 = VDNMethods.createProjectWithDigitalTextBook();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName2);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToRejectNomination(ProjectName2);
	UserOnBoarding.VDNlogout();
	
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName3 = VDNMethods.createProjectWithContentPlayList();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.openAndNominate(ProjectName3);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToRejectNomination(ProjectName3);

	}
}
