package vdn;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyEnrollmentFormIsDisplayedForFirststTime extends BaseClass{
	
	@Test
	public static void verifyEnrollmentFormIsDisplayedForFirststTime() throws Exception {
	UserOnBoarding.loginAsContributor("First Time");
	VDNMethods.validateEnrollmentFormIsDisplayedForFirststTime();
	}

}

