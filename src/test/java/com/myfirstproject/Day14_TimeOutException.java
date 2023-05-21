package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day14_TimeOutException extends TestBase {
    /*
    If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
    Simply put, wait time is over but commend is not completed

    Solution:
    -Increase the wait time
    -Try using different wait.
    -We can use Thread.sleep in some case
    -Case by case we can prefer different explicit waits to maximize the performance of the automation script
     */

    @Test
    public void timeOutTest1(){
        driver.get("https://www.amazon.com");

    /*
    *When explicit wait can not locate the element even after explicit wait, then we see timeoutexception
    *SOLUTION:
    * max time is not enough then increase timeout or TRY FOLLOWING:
     * 1. CHECK LOCATOR. CHECK SYNTAX
     * 2. CHECK FRAMES, NEW WINDOWS, ALERTS, POP UPS, HTML ELEMENT THAT MIGHT BE DISPLAYED
     * 3. DO MANUAL TEST TO COMPLETELY UNDERSTAND THE STEPS. DO CHECK YOUR TEST STEPS. YOUR LOGIC AND TEXT EXECUTION FLOW SHOULD BE GOOD
     */

//        USE EXPLICIT WAIT
//        waitForVisibility(driver.findElement(By.name("twotabsearchtextbox")),15);//NoSuchElementException

        waitForVisibility(By.name("twotabsearchtextbox"),25);//TimeOutException(name should be id)
        waitForVisibility(By.id("wrong-fake-id"),25);//TimeOutException.(id value should be twotabsearchtextbox)
        // cause using explicit wait time,element is not still found

//        driver.findElement(By.name("twotabsearchtextbox"));////NoSuchElementException-> we don't use explicit wait we get nosuchelementexception

//        Question: if you use explicit wait and that step fails what kind of exception do you get?
//        Answer: timeout

//        NOTE: waitForVisibility(WebElement element,15); throws NoSuchElementException
//              BUT waitForVisibility(By by,15);throws TimeOutException
//        NOTE: When we use driver with explicit wait, we get no such element exception otherwise timeout exception

//        CASE 1
        waitForVisibility(driver.findElement(By.name("twotabsearchtextbox")),15);
//        1.Explicit Wait
//        2.Failing
//        3.Using driver in the explicit wait
//        4.Getting: NoSuchElementException

//        CASE 2
        waitForVisibility(By.id("wrong-fake-id"),25);
//        1.Explicit Wait
//        2.Failing
//        3.Not using driver in the explicit wait
//        4.TimeOutException






    }
}
