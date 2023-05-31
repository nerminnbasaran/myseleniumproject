package com.myfirstproject.practices.generalpractice;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Task08_HerOkuApp extends TestBase {

       /*
    Given
        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    When
        Fill the username, password and textArea comment:
    And
        Choose a file and upload it
    And
        Select all checkboxes, radio item 1 and dropdown 1
    And
        Click on submit
   Then
        Verify that uploaded file name is on the Form Details
     */

    @Test
    public void uploadTest(){

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        driver.findElement(By.name("username")).sendKeys(Faker.instance().name().username());
        driver.findElement(By.name("password")).sendKeys(Faker.instance().internet().password());
        driver.findElement(By.name("comments")).sendKeys("OK");

        WebElement chooseAFile = driver.findElement(By.name("filename"));
        String pathOfFlower = System.getProperty("user.home")+"/Desktop/flower.jpeg";
        chooseAFile.sendKeys(pathOfFlower);

        clickCheckboxByIndex(0);
        clickCheckboxByIndex(1);
        clickCheckboxByIndex(2);

        driver.findElement(By.xpath("//input[@value='rd1']")).click();

        selectByVisibleText(driver.findElement(By.name("dropdown")),"Drop Down Item 1");

        driver.findElement(By.xpath("//input[@value='submit']")).click();

        String fileName = driver.findElement(By.xpath("//li[@id='_valuefilename']")).getText();
        Assert.assertEquals("flower.jpeg",fileName);






    }

}
