package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsAbleToFilterTheTextbookInProjectDetailsPage extends BaseClass {
	@Test
	public static void verifySourcingOrgadminIsAbleToFilterTheTextbookInProjectDetailsPage() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods.createProjectTextBookWithSkipReviewDisable();
	VDNSourcingMethods.verifyProjectCreatedWithNominationOpenAndSkipRevDisable(ProjectName);
	VDNSourcingMethods.verifyOrgadminIsAbleToFilterTheTextbook();
	}
}
