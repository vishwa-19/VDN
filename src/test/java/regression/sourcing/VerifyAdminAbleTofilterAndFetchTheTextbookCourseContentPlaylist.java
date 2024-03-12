package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminAbleTofilterAndFetchTheTextbookCourseContentPlaylist extends BaseClass{
	
	@Test
	public static void verifyAdminAbleTofilterAndFetchTheTextbookCourseContentPlaylist() throws Exception {
		
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectBookWithoutTargetCollectionOrgWithSkipReviewDisabled();
	VDNSourcingMethods.adminAbleTofilterAndFetchTheTextbookCourseContentPlaylist(ProjectName);
	}

}
