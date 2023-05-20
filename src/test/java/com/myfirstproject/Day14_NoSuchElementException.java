package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day14_NoSuchElementException extends TestBase {

    /*
    NoSuchElementException:
        -Locator is wrong
        -Element is not on the page because of the iframe or popup or new window
        -Loading issue-synchronization issue, implicit wait is not enough
        -Element is hidden

    Solutions:
        -Make sure locator is correct.
        -Do manual testing to make there is no iframe, popups or any other blocked on the page
        -Maybe element is hidden or loading slower
        -Sometimes implicit wait may not be enough
        -Try using explicit wait.
     */

    @Test
    public void noSuchElementExceptionTest1(){
        driver.get("https://www.amazon.com");

    /*
          *WRONG LOCATORS CAUSES NO SUCH ELEMENT EXCEPTION
          *FRAMES, WINDOWS, ALERTS, HIDDEN ELEMENTS CAUSE NO SUCH ELEMENT EXCEPTION
          * IN SHORT, IF ELEMENT İS NOT FOUND ON THE PAGE WE GET NO SUCH ELEMENT EXCEPTION
          * SOLUTION:
          * 1. CHECK LOCATOR. CHECK SYNTAX
          * 2. CHECK FRAMES, NEW WINDOWS, ALERTS, POP UPS, HTML ELEMENT THAT MIGHT BE DISPLAYED
          * 3. DO MANUAL TEST TO COMPLETELY UNDERSTAND THE STEPS. DO CHECK YOUR TEST STEPS. YOUR LOGIC AND TEXT EXECUTION FLOW SHOULD BE GOOD
    */
//        driver.findElement(By.id("twotabsearchtextbox "));//NoSuchElementException
//        driver.findElement(By.name("twotabsearchtextbox"));////NoSuchElementException


    }
}
