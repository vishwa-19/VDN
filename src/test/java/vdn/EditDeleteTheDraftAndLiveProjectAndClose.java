package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;

public class EditDeleteTheDraftAndLiveProjectAndClose {
	@Test
	public static void verifyEditDeleteIconsInDraftwithContent() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.createProjectWithDigitalTextBookAndSave1();
	VDNMethods.verifyEditDeleteIconsInDraftwithContent(ProjectName);
	}
}
