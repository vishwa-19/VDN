

package regression.sourcing;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNSourcingMethods;
import utility.BaseClass;

public class VerifyAdminAbleToSaveTheProjectWithoutTargetCollectionByProvidingNameAlone extends BaseClass{
	
	@Test
	public static void verifyAdminAbleToSaveTheProjectWithoutTargetCollectionByProvidingNameAlone() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNSourcingMethods.CreateAndSaveProjectWithoutTCWithNameAlone();
	//VDNSourcingMethods.verifyStatusOfTheProjectCreatedWithEditAndDelOpt(ProjectName);
	
	}

}