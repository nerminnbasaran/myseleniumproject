package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q02_FileUpload extends TestBase {

    /*
    Given
        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    When
       Type "My File" into "Notes about the file" input
    And
        Click "Choose File" button
    And
        Select the file to upload
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals "My File"
    And
        Assert that file Content contains "Hello, I am uploaded file"
     */

    @Test
    public void uploadTest(){

//        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

//       Type "My File" into "Notes about the file" input
        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("My File");

//        Click "Choose File" button
//        Select the file to upload
        WebElement chooseAFile = driver.findElement(By.xpath("//input[@type='file']"));
        String pathOfText = System.getProperty("user.home")+"/Desktop/text.txt";
        chooseAFile.sendKeys(pathOfText);

//        Click on "Press" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        Assert that "Your notes on the file were" equals "My File"
        String note = driver.findElement(By.xpath("//blockquote")).getText();
        Assert.assertEquals("My File",note);

//        Assert that file Content contains "Hello, I am uploaded file"
        String fileContent = driver.findElement(By.xpath("//pre")).getText();
        Assert.assertTrue(fileContent.contains("Hello, I am uploaded file"));

    }

}
