package com.hrms.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginPageTest2 extends CommonMethods {

	@Test(groups = "regression")
	public void syntaxLoginPageValidation() {
		
		//calling login method from LoginPafeElements  class
		LoginPageElements login = new LoginPageElements();
		ConfigsReader reader = new ConfigsReader();
		login.login(reader.getProperty("username"), reader.getProperty("password"));
		//verify login
		DashboardPageElements dash = new DashboardPageElements();
		Assert.assertEquals(dash.welcome.getText(), "Welcome Admin");
		
		takeScreenshot("LoginValidation");
	}

}
