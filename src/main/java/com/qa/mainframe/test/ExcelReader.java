package com.qa.mainframe.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;


import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.ss.usermodel.DataFormatter;

//import com.MainFrameWork.accelerators.ActionEngine;

import com.qa.test.TestEngine.*;

public class ExcelReader {
	
	public String path;
	public FileInputStream fis;
	public FileOutputStream fileout;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static  XSSFRow row;
	public static Column col;
	public static XSSFCell cell;
	public static String sheetname;
	public static String username;
	public static String password;
	
		 
	

	public ExcelReader(String path, String shtname)
	{
		try {
			this.path = path;
			path = (System.getProperty("user.dir") +"/Testdata/Test.xlsx");
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet("Login");
			sheetname = "Login";
			System.out.println("excel reader");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
		public static void getrowcount()
		{
			try
			{
			workbook = new XSSFWorkbook(System.getProperty("user.dir") +"\\selltisTesting\\Testdata\\Test.xlsx");
			sheet = workbook.getSheet("Login");
			int num = sheet.getLastRowNum();			
			System.out.println(num);										
		}
			catch(Exception ex)
			{
				ex.getMessage();
			}
		}
		
		public static void getcelldata()
		{
			try
			{
			workbook = new XSSFWorkbook(System.getProperty("user.dir") +"/Testdata/Test.xlsx");
			sheet = workbook.getSheet("Login");
			String celldata = sheet.getRow(1).getCell(0).getStringCellValue();
			String celldata1 = sheet.getRow(1).getCell(1).getStringCellValue();
			String celldata2 = sheet.getRow(1).getCell(2).getStringCellValue();
			System.out.println(celldata);
			System.out.println(celldata1);
			System.out.println(celldata2);
			}
			catch(Exception ex)
			{
				ex.getStackTrace();
			}			
		}			
		
		public static String getcell(String role)
		{			
			try
			{
			//String role = "HR";	
			workbook = new XSSFWorkbook(System.getProperty("user.dir") +"/Testdata/Test.xlsx");
			sheet = workbook.getSheet("Login");	
			//int index = workbook.getSheetIndex(sheetname);
			//sheet=workbook.getSheetAt(index);
			int colnum = 0;
			int rownum = 0;
			
			//System.out.println("roww");
			
			
			for(int j = 1;j<=sheet.getPhysicalNumberOfRows();j++)
			{
				row = sheet.getRow(j);
				if(row.getCell(0).toString().equalsIgnoreCase(role))
				{
					rownum = j;
					System.out.println(rownum);
					break;
				}
				
			}	
			row = sheet.getRow(rownum);
			for(int i = 0;i<row.getLastCellNum();i++)
			{
				
				if(row.getCell(i).toString().equalsIgnoreCase(role))
				{
					colnum = i;
					System.out.println(colnum);
					break;
				}				
			}
			
			System.out.println("Enter");
			row = sheet.getRow(rownum);			
			cell = row.getCell(colnum);		
			
			System.out.println(cell.getStringCellValue()) ;	
								
			username = sheet.getRow(rownum).getCell(1).getStringCellValue();
			password = sheet.getRow(rownum).getCell(2).getStringCellValue();
			System.out.println(username);
			System.out.println(password);	
			//return username + password ;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			//String rv = username + "," + password;
			//System.out.println("rv: " + rv);
			return username + "," + password;
					
		}
		
		public void writedata(String data)
		{
			try
			{
				File fil = new File(System.getProperty("user.dir")+"/Testdata/Testdata.xlsx");
				int n = 5;
				String dt = data;
				System.out.println(dt);	
						
				FileInputStream input = new FileInputStream(fil);
				System.out.println("tooo1");	
				
				XSSFWorkbook WorkBookForWritting = new XSSFWorkbook(input);
				System.out.println("tooo2");	
				
				sheet = WorkBookForWritting.getSheet("Login");
				System.out.println("tooo3");	
				
				//cell = workbook.getRow(4).createCell(Column);
				System.out.println("tooo4");	
								 
					/*
					 * workbook = new XSSFWorkbook(System.getProperty("user.dir")
					 * +"/Testdata/Testdata.xlsx"); sheet = workbook.getSheet("Login");
					 */
				 System.out.println("tooo5");	
				 row = sheet.getRow(n);
				 //cell =  sheet.getRow(5).getCell(1);
				 if(row!=null)
				 {
					cell = row.getCell(1,org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
					 					 
					FileOutputStream fi = new FileOutputStream(fil);
					WorkBookForWritting.write(fi);
					fi.close();
				 }
				 else
				 {
					 System.out.println("row is null");
				 }
				
				//sheet.getRow(5).getCell(1).setCellValue(dt);								
				  						
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			//return true;
			
		}

}
