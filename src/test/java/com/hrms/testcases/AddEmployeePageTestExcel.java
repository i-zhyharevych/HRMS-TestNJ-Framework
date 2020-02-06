package com.hrms.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class AddEmployeePageTestExcel extends CommonMethods{
   
	@Test(dataProvider="getData", groups = "regression")
    public void addMultipleEmpoyee(String firstName, String middleName, String lastName) throws InterruptedException {
       
		LoginPageElements login=new LoginPageElements();
       
	     test.info("Login in into HRMS");
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
//	    sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
        DashboardPageElements dasboard=new DashboardPageElements();
        
        test.info("Navigating to the add Employee Page");
        dasboard.navigateToAddEmoloyee();
        
        test.info("Adding Employee");
        AddEmployeePageElements addEmp=new AddEmployeePageElements();
        test.info("Login in into HRMS");
        sendText(addEmp.fName, firstName);
        sendText(addEmp.mName, middleName);
        sendText(addEmp.lName, lastName);
        String empId=addEmp.empId.getAttribute("value");
        
        Thread.sleep(1000);
        click(addEmp.saveBtn);      
        test.info("Validating Employee is added");
        PersonalDetailsPageElements pdw= new PersonalDetailsPageElements();
        
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(pdw.empId));     
        String actEmpId=pdw.empId.getAttribute("value");
    
        Assert.assertEquals(actEmpId, empId);
    }
    
    @DataProvider
    public Object[][] getData(){
        return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "AddEmployee");
    }
}