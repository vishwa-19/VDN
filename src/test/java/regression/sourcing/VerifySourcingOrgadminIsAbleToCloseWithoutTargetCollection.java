package regression.sourcing;
import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifySourcingOrgadminIsAbleToCloseWithoutTargetCollection extends BaseClass {
	@Test
	public static void verifySourcingOrgadminIsAbleToCloseWithoutTargetCollection() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName=VDNMethods.createProjectWithoutTargetCollection();
	VDNMethods.SourcingOrgAdminIsAbleToEditAndModififyThePrpjectWithoutTargetCol(ProjectName);
	String ProjectName1=VDNMethods.createProjectWithoutTargetCollection();
	VDNMethods.SourcingOrgAdminIsAbleToDeleteThePrpjectWithoutTargetCol(ProjectName1);
	String ProjectName2=VDNMethods.createProjectWithoutTargetCollection();
	VDNMethods.SourcingOrgAdminIsAbleToCloseThePrpjectWithoutTargetCol(ProjectName2);

	}
}
