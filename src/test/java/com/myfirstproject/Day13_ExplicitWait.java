package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day13_ExplicitWait extends TestBase {
    /*
    Hard Wait: Thread.sleep(millisecond)
    -We should avoid using this wait. Avoid especially putting too many hard wait
    -This will make the test execution time longer than needed
    Dynamic Wait    : Implicit Wait / Explicit Wait / Fluent Wait
    -Implicit Wait  : Global wait, Wait UP TO the given time.
    Throws NOSUCHELEMENTEXCEPTION if element is not found in the given time
    When we use implicit wait once, then whenever driver is called, then implicit wait applies
    -Explicit Wait  : Local Wait, Wait UP TO the given time.
    We will apply the wait on to the specific elements
    We must create a WebDriverWait object
    **Return type of explicit wait is WebElement
    Throws TIMEOUTEXCEPTION if element is not found
    NOTE : We must use explicit wait for each element that we want to wait for
    -Fluent Wait    : Similar to explicit wait
    We can put polling number
    We can ignore some exception
    Local wait
    Throws TIMEOUTEXCEPTION if element is not found
     */

    @Test
    public void explicitWaitTest1(){

//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

//    WAIT AFTER BUTTON CLICK
//        TRYING HARD WAIT
//        Thread.sleep(1000); -> SOLVED THE WAIT ISSUE BUT NOT RECOMMENDED CAUSE NOT DYNAMİC

//        TRYING EXTRA IMPLICIT WAIT
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); -> DIDN'T SOLVE THE ISSUE

//        TRYING EXPLICIT WAIT
//        1.Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//        2.Use the wait object to handle the wait issue
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='finish']//h4"))));

//    Then verify the 'Hello World!' Shows up on the screen
        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        Assert.assertEquals("Hello World!",helloWorld.getText());
    }

    @Test
    public void explicitWaitTest2(){

//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

//    WAIT AFTER BUTTON CLICK
//        TRYING EXPLICIT WAIT
//        1.Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//        2.Use the wait object to handle the wait issue
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='finish']//h4"))));

//    Then verify the 'Hello World!' Shows up on the screen

//        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        Assert.assertEquals("Hello World!",helloWorld.getText());
    }

    @Test
    public void explicitWaitTest3(){
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

//    WAIT FOR ELEMENT USING EXPLICIT WAIT
//    THIS IS RECOMMENDED> WE SHOULD USE REUSABLE METHODS IN AUTOMATION
        WebElement helloWorld = waitForVisibility(driver.findElement(By.xpath("//div[@id='finish']//h4")),20);

//    Then verify the 'Hello World!' Shows up on the screen
        Assert.assertEquals("Hello World!",helloWorld.getText());
    }






}
