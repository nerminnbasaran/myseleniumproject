package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Day13_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest(){
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//    When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

//        TRYING FLUENT WAIT
//        1.Create Wait object
        Wait<WebDriver> wait = new FluentWait<>(driver)//creating wait object
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);


//    Then verify the 'Hello World!' Shows up on the screen


    }




}
