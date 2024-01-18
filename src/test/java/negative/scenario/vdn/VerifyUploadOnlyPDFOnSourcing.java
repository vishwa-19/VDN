package negative.scenario.vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class VerifyUploadOnlyPDFOnSourcing  extends BaseClass{
	@Test
	public static void verifyUploadOnlyPDFOnSourcing() throws Exception {
	UserOnBoarding.loginAsSourcing("Admin");
	String ProjectName = VDNMethods.validateErrorOnUploadingOtherThanPDF();
	
	}
	
}
