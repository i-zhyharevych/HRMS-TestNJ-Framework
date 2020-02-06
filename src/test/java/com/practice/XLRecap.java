package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLRecap {
	
	@Test
	public void read() throws IOException {
		String filePath = "/Users/ivankazhyharevych/Desktop/MyFile.xlsx";
		
		FileInputStream fis= new FileInputStream(filePath);
		Workbook wbook = new XSSFWorkbook(fis);
		Sheet sheet = wbook.getSheet("Test");
		String value = sheet.getRow(1).getCell(0).toString();
		System.out.println(value);
		
		//how to find number of rows and cols
		int row = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		
		System.out.println(row);
		System.out.println(cols);
				
		//how to get data from excel and store in 2D array
		//creating object t store data  from 3 rows(avoid header)
		Object[][] data = new Object[row-1][cols];
//		data[0][0]="Hello";
//		data[0][1]= "Hello1";
//		//-------------------
//		data[1][0] ="Bye";
//		data[1][1] = "Bye1";
		
		//read entire data from excel 1 by 1
		
		//loop from row 2 of excel sheet
		for(int i = 1; i<row; i++) {
			//looping from 1 column in excel
			for(int y=0;y<cols; y++) {
				//retrieve value fron excel 
				String value2 = sheet.getRow(i).getCell(y).toString();
				System.out.println(value2);
				//store retrieved data  into 2d array 
				data[i-1][y]=value;
			}
		}
		System.out.println("Values from 2d array");
		for(Object[] rowArray : data) {
			for(Object d:rowArray) {
				System.out.println(d);
			}
			
		}
		wbook.close();
		fis.close();
	}

}
