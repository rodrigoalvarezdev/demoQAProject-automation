package com.demoQa.utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider
	public Object[][] dataTextBox(){
		String sheetName = "textBox";
		int rowNum = Excel.rowTotal(sheetName);
		int cellNum = Excel.cellTotal(sheetName);
		Object[][] data = new Object[rowNum-1][cellNum];
		for(int i=0; i<rowNum-1; i++) {
			for(int j=0; j<cellNum;j++) {
				data[i][j] = Excel.cellValue(sheetName, i+1, j);
			}
		}
		return data;
	}
	
	@DataProvider
	public Object[][] webTableData(){
		String sheetName = "webTable";
		int row = Excel.rowTotal(sheetName);
		int cell = Excel.cellTotal(sheetName);
		Object[][] data = new Object[row-1][cell];
		
		for(int i=0; i<row-1;i++) {
			for(int j=0; j<cell;j++) {
				data[i][j] = Excel.cellValue(sheetName, i+1, j);
			}
		}
		return data;
	}
	
	@DataProvider
	public Object[][] formData(){
		String sheetName = "form";
		int row = Excel.rowTotal(sheetName);
		int cell = Excel.cellTotal(sheetName);
		Object[][] data = new Object[row-1][cell];
		
		for(int i=0; i<row-1;i++) {
			for(int j=0; j<cell;j++) {
				data[i][j] = Excel.cellValue(sheetName, i+1, j);
			}
		}
		return data;
	}
}
