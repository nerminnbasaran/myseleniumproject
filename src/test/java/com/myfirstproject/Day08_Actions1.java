package com.myfirstproject;


import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions1 extends TestBase {

    //Create a test method : contextClickMethod() and test the following scenario:

    @Test
    public void contextClickTest(){

    //Given user is on the https://testcenter.techproeducation.com/index.php?page=context-menu
        LoggerUtils.info("Opening the URL");
        driver.get("https://testcenter.techproeducation.com/index.php?page=context-menu");

    //When use right-click on the box
        LoggerUtils.info("Right click on the box");
        WebElement box = driver.findElement(By.id("hot-spot"));

    //Creating Actions Class
        Actions actions = new Actions(driver);//creating actions object
        actions.contextClick(box).perform();//right-click on the box
        LoggerUtils.info("Assert alert message");

    //Then verify the alert message is “You selected a context menu”
       Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu"));

    //Then accept the alert
        driver.switchTo().alert().accept();
        LoggerUtils.info("Testing SUCCESSFUL");
    }
}
