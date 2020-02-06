package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LeaveListPageTest extends CommonMethods{

	@Test(groups = "regression")
	public void leaveLabelValidation() {
		
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();
		
		test.info("Logging into the application");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		test.info("Navigatinf to the Leave List");
		jsClick(dashboard.leaveLink);
		jsClick(dashboard.leaveList);
		
		test.info("Validating Leave List Label");
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
		
	
	}
	@Test(groups = "regression")
	public void leaveLabelValidation1() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToTheLeaveList();
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
	}
	
	
	
}
