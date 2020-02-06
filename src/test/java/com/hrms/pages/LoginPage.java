package com.hrms.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.testbase.BaseClass;

public class LoginPage extends BaseClass{

	
	//using finndElement(by.)
	public WebElement username =driver.findElement(By.id("txtUsername"));
	public WebElement password = driver.findElement(By.id("txtPassword"));
	public WebElement loginBtn = driver.findElement(By.id("btnLogin"));
	
	//public WebElement errMessage = driver.findElement(By.xpath("//span[text()='Password cannot be empty']"));
}
