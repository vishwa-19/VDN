package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyReviewerAbleToViewSampleUploadedByContributors extends BaseClass{
	
	@Test
	public static void verifyReviewerAbleToViewSampleUploadedByContributors() throws Exception {
		
		UserOnBoarding.loginAsSourcing("Admin");
		String ProjectName=VDNMethods.createProjectWithTextBookWithUploadPDF();
		VDNSourcingMethods.assignRoleToUser(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNMethods.openAndNominateWithUpload(ProjectName);
		UserOnBoarding.VDNlogout();
		UserOnBoarding.loginAsSourcing("Assigned Reviewer");
		VDNSourcingMethods.verifyReviewerAbleToViewSampleUploadedByContributors(ProjectName);
	}

}
