package regression.contributor;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import pageObject.VDNObj;
import utility.BaseClass;

public class VerifyStatusOfProjectIsApprovedWhenSourcingOrgAdminAcceptsNomination extends BaseClass {
	@Test
	public static void verifyStatusOfProjectIsApprovedWhenSourcingOrgAdminAcceptsNomination() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNMethods.uploadTheContentFromIndividualContributorSide(ProjectName);
	VDNMethods.validteIntiateStatusUnderMyProjects(ProjectName);
	VDNContributorMethods.nominateFromInitiateStatus();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNomination(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.validateStatusOfProjectIsApprovedWhenSourcingOrgAdminAcceptsNomination(ProjectName);
	}

}

