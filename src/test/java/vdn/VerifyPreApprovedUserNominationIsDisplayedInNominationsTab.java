package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyPreApprovedUserNominationIsDisplayedInNominationsTab extends BaseClass {
	@Test
	public static void PreApprovedUserNominationIsDisplayedInNominationsTab() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithDigitalTextBook();
	VDNMethods.validatePreApprovedUserNominationIsDisplayedInNominationsTab(ProjectName);
	UserOnBoarding.VDNlogout();
	}
}
