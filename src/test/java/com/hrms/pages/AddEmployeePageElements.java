package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePageElements {

	@FindBy(id = "firstName")
	public WebElement fName;
	
	@FindBy(id = "middleName")
	public WebElement mName;
	
	@FindBy(id = "lastName")
	public WebElement lName;
	
	@FindBy(id = "btnSave")
	public WebElement saveBtn;
	
	@FindBy(id="chkLogin")
	public WebElement createLoginDetails;
	
	@FindBy(id="user_name")
	public WebElement username;
	
	@FindBy(id="user_password")
	public WebElement userPassword;
	
	@FindBy(id="re_password")
	public WebElement confirmUserPassword;

	@FindBy(id="employeeId")
	public WebElement empId;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
