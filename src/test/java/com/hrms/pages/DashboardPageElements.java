package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{

	@FindBy(linkText="Leave")
	public WebElement leaveLink;
	
	@FindBy(linkText = "Leave List")
	public WebElement leaveList;
	
	@FindBy(linkText = "PIM")
	public WebElement PIMlink;
	
	@FindBy(xpath = "//a[text()='Add Employee']")
	public WebElement addEmployeeLink;
	
	@FindBy(id = "welcome")
	public WebElement welcome;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToTheLeaveList() {
		jsClick(leaveLink);
		jsClick(leaveList);
	}
	
	public void navigateToAddEmoloyee() {
		jsClick(PIMlink);
		jsClick(addEmployeeLink);
	}
}
