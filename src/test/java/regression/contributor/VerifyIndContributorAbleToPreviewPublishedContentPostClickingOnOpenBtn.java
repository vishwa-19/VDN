package regression.contributor;
import org.testng.annotations.Test;
import pageActions.UserOnBoarding;
import pageActions.VDNContributorMethods;
import utility.BaseClass;

public class VerifyIndContributorAbleToPreviewPublishedContentPostClickingOnOpenBtn extends BaseClass{
	
	@Test
	public static void verifyContributedContentsPageIsAvailablePostClickingOpenButton() throws Exception {
		UserOnBoarding.loginAsContributor("Ind Contributor");
		VDNContributorMethods.validateContributedContentsPageIsAvailablePostClickingOpenButton();
		VDNContributorMethods.validateIndContributorAbleToPreviewPublishedContentPostClickingOnOpenBtn();
		
	}

}

