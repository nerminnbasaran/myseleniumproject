package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Task11_HerOkuApp extends TestBase {
    /*
Given
   Go to https://testpages.herokuapp.com/
When
   Click on File Downloads
And
   Click on Server Download
Then
   Verify that file is downloaded
*/
    @Test
    public void downloadTest(){

        driver.get("https://testpages.herokuapp.com/");
        scrollDownActions();
        driver.findElement(By.id("download")).click();
        driver.findElement(By.id("server-download")).click();
        String filePath = System.getProperty("user.home")+"/Downloads/textfile.txt";
        waitFor(2);
        Assert.assertTrue(Files.exists(Paths.get(filePath)));


    }


}
