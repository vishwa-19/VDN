package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyIndividualContributorIsAbleToModifyTheNomination extends BaseClass{
	
	@Test
	public static void verifyIndividualContributorIsAbleToModifyTheNomination() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName = VDNMethods.createProjectWithDigitalTextBook();
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNMethods.openAndNominate(ProjectName);
		VDNContributorMethods.verifyIndividualContributorIsAbleToModifyTheNomination(ProjectName);
	}

}
