package com.demoQa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static int rowTotal(String sheetName) {
		String path = "dataset\\demoQaExcel.xlsx";
		try {
			FileInputStream f = new FileInputStream(path);
			XSSFWorkbook book = new XSSFWorkbook(f);
			XSSFSheet sheet = book.getSheet(sheetName);
			book.close();
			return sheet.getLastRowNum()+1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int cellTotal(String sheetName) {
		String path = "dataset\\demoQaExcel.xlsx";
		try {
			FileInputStream f = new FileInputStream(path);
			XSSFWorkbook book = new XSSFWorkbook(f);
			XSSFSheet sheet = book.getSheet(sheetName);
			book.close();
			return sheet.getRow(0).getLastCellNum();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String cellValue(String sheetName, int nrow, int ncell) {
		String path = "dataset\\demoQaExcel.xlsx";
		try {
			FileInputStream f = new FileInputStream(path);
			XSSFWorkbook book = new XSSFWorkbook(f);
			XSSFSheet sheet = book.getSheet(sheetName);
			book.close();
			DataFormatter df = new DataFormatter();
			return df.formatCellValue(sheet.getRow(nrow).getCell(ncell));
			
			//return sheet.getRow(nrow).getCell(ncell).getStringCellValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
