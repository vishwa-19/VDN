
package regression.contributor;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyIndContributorAbleToPreviewNotPublishedContentPostClickingOnOpenBtn extends BaseClass{
	
	@Test
	public static void verifyIndContributorAbleToPreviewNotPublishedContentPostClickingOnOpenBtn() throws Exception {
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNContributorMethods.validateContributedContentsPageIsAvailablePostClickingOpenButton();
		VDNContributorMethods.validateIndContributorAbleToPreviewNotPublishedContentPostClickingOnOpenBtn();
		
		
	}

}

