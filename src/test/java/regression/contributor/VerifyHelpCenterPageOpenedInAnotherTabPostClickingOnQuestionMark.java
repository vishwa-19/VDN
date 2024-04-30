package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyHelpCenterPageOpenedInAnotherTabPostClickingOnQuestionMark extends BaseClass{
	
	@Test
	public static void verifyHelpCenterPageOpenedInAnotherTabPostClickingOnQuestionMark() throws Exception {
		
		UserOnBoarding.loginAsContributor("Cont OrgAdmin");
		VDNSourcingMethods.verifyHelpCenterOpendInAnotherTabForDefaultContributer();
	}

}
