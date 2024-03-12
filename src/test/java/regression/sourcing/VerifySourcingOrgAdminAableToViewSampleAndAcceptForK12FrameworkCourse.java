package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminAableToViewSampleAndAcceptForK12FrameworkCourse extends BaseClass{
	
	@Test
	public static void verifySourcingOrgAdminAableToViewSampleAndAcceptForK12FrameworkCourse() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNSourcingMethods .createProjectCourseWithSkipReviewEnableK12Framework();
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNSourcingMethods.openAndNominateWithUploadCourse(ProjectName);
	UserOnBoarding.VDNlogout();
	UserOnBoarding.loginAsSourcing("Admin");
	VDNSourcingMethods.verifySourcingOrgAdminAbleToViewSampleAndAcceptNomination(ProjectName);
	
	}

}
