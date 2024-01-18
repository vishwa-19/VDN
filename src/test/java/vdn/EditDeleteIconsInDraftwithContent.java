package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class EditDeleteIconsInDraftwithContent extends BaseClass {
	
	@Test
	public static void verifyEditDeleteIconsInDraftwithContent() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBookAndSave();
	VDNMethods.verifyEditDeleteIconsInDraftwithContent(ProjectName);
	}
}
