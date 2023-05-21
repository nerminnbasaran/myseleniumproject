package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day14_StaleElementReferenceException extends TestBase {

    /*
        Stale Elements means the element is no longer fresh.It is old and no longer available
        *Reasons maybe trying to use the same reference after refreshing the page or, going back and forward the pages
        *When the element is no longer fresh on the page and we try to use it
        *When the element is detached from DOM
        *When the element is removed after session started
        Solution:
        *Try not using the old reference
        *Relocate the same element again.We can use a new variable name as well.
     */

    @Test
    public void staleElementReferenceExceptionTest1(){

        driver.get("https://testcenter.techproeducation.com/");

//        locating checkboxes element
        WebElement checkboxesLink = driver.findElement(By.linkText("Checkboxes"));

//        click on CheckBox link
        checkboxesLink.click();

//        REFRESH
        driver.navigate().refresh();
//        checkboxesLink.click();//StaleElementReferenceException

        driver.findElement(By.linkText("Checkboxes")).click();//we relocate the element

    }

    @Test
    public void staleElementReferenceExceptionTest2(){

        driver.get("https://www.amazon.com");
        WebElement registry = driver.findElement(By.xpath("//*[@id='nav-xshop']//a[11]"));
        registry.click();
        waitFor(5);
        driver.navigate().back();
        waitFor(5);
        registry.click();//StaleElementReferenceException
//        SOLUTION
        driver.findElement(By.xpath("//*[@id='nav-xshop']//a[11]")).click();




    }

}
