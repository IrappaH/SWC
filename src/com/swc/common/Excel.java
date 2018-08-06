package com.swc.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;

public class Excel {

	public static int getRowCount(String path,String sheet) {
		int rc=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			rc = wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) {
		}
		return rc;
	}
	
	public static int getColumnCount(String path,String sheet,int r) {
		int cc=0;
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			cc=wb.getSheet(sheet).getRow(r).getLastCellNum();
		}
		catch (Exception e) {
		}
		return cc;
	}
	
	public static String getValue(String path,String sheet,int r,int c) {
		String v="";
		try {		
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch (Exception e) {
		}
		return v;
	}
	
	public static String writeIntoExcel(String path, String sheet, int r, int c, String data) {
		
		try {
			
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			
			String r1 = wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
			System.out.println(r1);
			
			wb.getSheet(sheet).getRow(0).createCell(0).setCellValue("2.41.0");
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
		}catch(Exception e) {
			
			System.out.println("Exception while writing data to Excel " + e.getMessage());
			e.printStackTrace();
			
		}
		return data;
		
		
	}

	
	
}

