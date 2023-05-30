package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task13{

    /*
    Given
        Save EarningList.xlsx file into your project
    When
        In the row column, write the row numbers according to the earnings amount(Natural Order).
    Then
        Assert that row number of Wednesday is 1
     */

    @Test
    public void excelTest() throws IOException {

        String path = "resources/EarningsList.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");

        sheet1.getRow(3).createCell(2).setCellValue("1");



        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);


    }





    //EarningList.xlsx file:
//    Days	   Earnings   Row
//    Monday	    $512
//    Tuesday	    $205
//    Wednesday	$632
//    Thursday	$344
//    Friday	    $480
//    Saturday	$0
//    Sunday	    $0
}
