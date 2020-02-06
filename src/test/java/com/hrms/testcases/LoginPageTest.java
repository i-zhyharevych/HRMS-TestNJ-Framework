package com.hrms.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPage;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageTest extends CommonMethods {
	
	@Test(enabled = false, groups="smoke")
	public void login() {
		LoginPage login = new LoginPage();
		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");
		click(login.loginBtn);
		
		String expected = "Welcome Admin";
		String actual = driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals(actual, expected);
	}
	
	@Test(enabled=true, groups="smoke")
	public void syntaxLoginPageValidation() {
		
		//calling login method from LoginPafeElements  class
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		//verify login
		DashboardPageElements dash = new DashboardPageElements();
		Assert.assertEquals(dash.welcome.getText(), "Welcome Admin");
		
		takeScreenshot("LoginValidation");
	}
	
	/* Navigate to HRMS 
	 * Enter uid
	 * leave password field blank
	 * click login
	 * verify "Password cannot be empty" text 
	 * close browser
	 */
	@Test(enabled=true, groups= "regression")
	public void negativeLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		click(login.loginBtn);
		String expectedErr = "Password cannot be empty";
		Assert.assertEquals(login.errorMessage.getText(), expectedErr, "Error message is not present");
	}
	
	//data driven tc
	@Test(dataProvider="getData")
	public void multipleLogin(String uid, String pwd) throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, uid );
		sendText(login.password, pwd);
		Thread.sleep(3000);
		click(login.loginBtn);
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "Login");
	}
	

}
