package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class ContentLabelInNominiatonList extends BaseClass {

	@Test
	public static void verifyContentLabelInNominiatonList() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.validateCreateNewProjectwithAllContentTypesWithDigitalTextBooks();
	VDNMethods.validateContentLabelInNominiatonList(ProjectName);
	}
	
}
