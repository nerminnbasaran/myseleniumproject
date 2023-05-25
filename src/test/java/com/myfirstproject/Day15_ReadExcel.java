package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day15_ReadExcel {
    /*
    When we get data from external source(excel), it is known as DDT(DATA DRIVEN TESTING),
    When we change the data, the test case also changes. We control the task case by just controlling the test data.
    Excel can be used to create Data Driven Framework or to do Data Driven Tesitng
    Apache POI is the Java API to access microsoft offices
     */

    @Test
    public void readExcelTest() throws IOException {

        String path = "resources/Capitals.xlsx";

//        open the file
        FileInputStream fileInputStream = new FileInputStream(path);

//        open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");//getting Sheet1 by name
        workbook.getSheetAt(0);//ALTERNATIVELY getting Sheet1 by index

//        go to first row
        Row row1 = sheet1.getRow(0);//index starts at 0

//        go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);

//        go to second cell on that first row and print
        Cell c2r1 = row1.getCell(1);
        System.out.println(c2r1);

//        go to 2nd row first cell and assert if the data equals to USA
        Cell c1r2 = sheet1.getRow(1).getCell(0);
        System.out.println(c1r2.toString());

//        go to 3rd row and 2nd cell-chain the row and cell
        Cell c2r3 = sheet1.getRow(2).getCell(1);
        System.out.println(c2r3);

//        find the number of row
        int totalRowCount = sheet1.getLastRowNum()+1;//index starts at 0
        System.out.println(totalRowCount);

//        find the number of used row
        int usedRowCount = sheet1.getPhysicalNumberOfRows();
        System.out.println(usedRowCount);//index starts at 1

//        print country,capital key value pairs as map object
//        create a map, use a loop to add all countries as key and capitals as value
//        String country = sheet1.getRow(ROW INDEX).getCell(CELL INDEX).toString();
//        String capital = sheet1.getRow(ROW INDEX).getCell(CELL INDEX).toString();
        Map<String,String> capitals = new HashMap();
        for(int rowNum=1; rowNum<totalRowCount; rowNum++){ //iterete the rows 1 to END
            String country = sheet1.getRow(rowNum).getCell(0).toString();
            System.out.println(country);
            String capital = sheet1.getRow(rowNum).getCell(1).toString();
            System.out.println(capital);
            capitals.put(country,capital);
        }
        System.out.println(capitals);





    }
}
