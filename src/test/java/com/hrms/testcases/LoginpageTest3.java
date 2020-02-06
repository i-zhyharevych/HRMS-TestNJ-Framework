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

public class LoginpageTest3 extends CommonMethods{
	Properties prop;

	@Test(groups= "regression")
	public void syntaxLoginPageValidation() {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/configs/Configuration.properties";

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//store username and pswd from  Comfiguratin.properties file
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		//calling login method from LoginPafeElements  class
		LoginPageElements login = new LoginPageElements();
		
		login.login(username, password);
		//verify login
		DashboardPageElements dash = new DashboardPageElements();
		Assert.assertEquals(dash.welcome.getText(), "Welcome Admin");
		
		takeScreenshot("LoginValidation");
	}

}
