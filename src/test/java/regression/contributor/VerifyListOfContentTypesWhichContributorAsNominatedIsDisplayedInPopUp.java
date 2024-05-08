package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyListOfContentTypesWhichContributorAsNominatedIsDisplayedInPopUp extends BaseClass {

	@Test
	public static void verifyListOfContentTypesWhichContributorAsNominatedIsDisplayedInPopUp() throws Exception {
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNContributorMethods.createProjectWithoutTargetCollectionAllContentTypes();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNContributorMethods.openAndNominateWithoutTargetCollectionAllTypes(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Admin");
		VDNMethods.verifySourcingOrgAdminIsAbleToAcceptNominationWithoutTargetCollection(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.verifyContributorOrgAdminIsAbleToSearchAndAssignRoles(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont Only");
		VDNContributorMethods.validateListOfContentTypesWhichContributorAsNominatedIsDisplayedInPopUp(ProjectName);
	}
}







