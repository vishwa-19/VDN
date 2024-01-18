package vdn;

import org.testng.annotations.Test;

import pageActions.UserOnBoarding;
import pageActions.VDNMethods;
import utility.BaseClass;

public class ChangeRoleToAdminInManageUsersAndVerifyToastMessage extends BaseClass {
	@Test
	public static void verifyChangeRoleToAdminInManageUsersAndVerifyToastMessage() throws Exception {
	UserOnBoarding.loginAsContributor("Cont OrgAdmin");
	VDNMethods.validateChangeRoleToAdminInManageUsersAndVerifyToastMessage();
	}

}
