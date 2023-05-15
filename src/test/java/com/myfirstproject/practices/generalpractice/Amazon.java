package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Amazon extends TestBase {

    @Test
    public void amazonTest(){

//    Go to https://amazon.com
        driver.get("https://amazon.com");

//    Print all the options in the 'Departments' dropdown on the left side of the search box
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        Select options = new Select(dropDown);
        options.selectByVisibleText("All Departments");

//    Search for each first five options and print titles
       List<WebElement> firstFiveOptions = driver.findElements(By.xpath("(//span[@class='s-heavy'])"));
       for(WebElement w : firstFiveOptions){

        }




    }
}
