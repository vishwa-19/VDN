package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyContributorAbleToSelectBoardValueInTheEditDetailsPopUp extends BaseClass{
	
	@Test
	public static void verifyContributorAbleToSelectBoardValueInTheEditDetailsPopUp() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Ind Contributor");
	VDNContributorMethods.verifyAllTheFrameworkAttributeValuesAreDisplayedInEditDetailsPopUp(ProjectName);
	}

}
