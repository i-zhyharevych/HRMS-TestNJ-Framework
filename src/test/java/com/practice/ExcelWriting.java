package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriting {

	@Test
	public void write() throws IOException {
		String filePath = "/Users/ivankazhyharevych/Desktop/MyFile.xlsx";

		FileInputStream fis = new FileInputStream(filePath);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet("Test");
		
		//if cell is not there you need to create it
		sheet.getRow(0).createCell(2).setCellValue("Language");
		sheet.getRow(0).createCell(2).setCellValue("Instructor");
		sheet.createRow(2).createCell(0).setCellValue("Syntax123");
		sheet.getRow(2).createCell(1).setCellValue("TestNG");
		FileOutputStream fos= new FileOutputStream(filePath);
		book.write(fos);
		fos.close();
		book.close();
		fis.close();
	}

}
