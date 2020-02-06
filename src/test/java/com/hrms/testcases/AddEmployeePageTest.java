package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddEmployeePageTest extends CommonMethods{
	/*
	 * Sprint 5
US 16767: As an admin I should be able to add an employee 

TC: Add Employee
Step 1. navigate to the application
Step 2: login into the application
Step 3: navigate to add employee page
Step 4: add employee by providing fname. mname, lname
Step 5: verify employee has been added successfully
	 */

	
	@Test(enabled = false, groups = "regression")
	public void addEmployeeValidation() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		PersonalDetailsPageElements personalDetails = new PersonalDetailsPageElements();
		
		test.info("Login into HRMS");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		jsClick(dashboard.PIMlink);
		jsClick(dashboard.addEmployeeLink);
		
		sendText(addEmployee.fName, "Miranda");
		sendText(addEmployee.mName, "Anna");
		sendText(addEmployee.lName, "Hernandez");
		click(addEmployee.saveBtn);
		
		Assert.assertTrue(personalDetails.personalDetailsLbl.isDisplayed(), "Personal Details label is not displayed");
		
	}
	
	@Test(dataProvider ="getData", groups = "regression")
	public void addingMultipleEmployees(String firstName, String middleName, String lastName) {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		AddEmployeePageElements addEmployee = new AddEmployeePageElements();
		PersonalDetailsPageElements personalDetails = new PersonalDetailsPageElements();
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		dashboard.navigateToAddEmoloyee();
		
		sendText(addEmployee.fName, firstName);
		sendText(addEmployee.mName, middleName);
		sendText(addEmployee.lName, lastName);
		click(addEmployee.saveBtn);
		
		Assert.assertTrue(personalDetails.personalDetailsLbl.isDisplayed(), "Personal Details label is not displayed");
	
		
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "AddEmployee");
	}
}
