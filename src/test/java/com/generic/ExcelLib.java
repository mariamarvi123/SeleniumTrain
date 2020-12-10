package com.generic;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
    //Field
   public String filePath = "Files\\SampleFile.xlsx";

   //Method
   public String readExcelFile(String sheetName,int rowNum,int cellNum) throws Exception
   {
       File excelFile = new File(filePath);
       FileInputStream fis = new FileInputStream(excelFile);
       Workbook wb = null;
       wb = new XSSFWorkbook(fis);
       DataFormatter formatter = new DataFormatter();
       Cell c= wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
       String cellData =  formatter.formatCellValue(c);

       return cellData;
   }
}
