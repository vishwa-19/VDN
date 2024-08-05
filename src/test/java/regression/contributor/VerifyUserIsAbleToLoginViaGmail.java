package regression.contributor;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import utility.BaseClass;

public class VerifyUserIsAbleToLoginViaGmail extends BaseClass{
	
	@Test
	public static void verifyUserIsAbleToLoginViaGmail() throws Exception {
		
		UserOnBoarding.loginAsContributor("Ind Contributor");
	
	}

}
