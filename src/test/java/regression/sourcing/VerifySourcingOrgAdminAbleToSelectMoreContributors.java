package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifySourcingOrgAdminAbleToSelectMoreContributors extends BaseClass {
	

@Test
public static void VerifySourcingOrgAdminAbleToSelectMoreContributors() throws Exception {
UserOnBoarding.loginAsSourcing("Admin");
VDNSourcingMethods.createProjectBookSkipEnableSelectedCont();
VDNSourcingMethods.createProjectBookWithSkipReviewEnableAndSelIndCon();
}
}

