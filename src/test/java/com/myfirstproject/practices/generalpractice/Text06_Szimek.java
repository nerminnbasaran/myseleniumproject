package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Text06_Szimek extends TestBase {
         /*
    Go to http://szimek.github.io/signature_pad/
    Draw the line or shape you want on the screen
    Press the clear button after drawing
    Close the page
     */

    @Test
    public void drawAndLineTest(){

//        Go to http://szimek.github.io/signature_pad/
        driver.get("http://szimek.github.io/signature_pad/");

//        Draw the line or shape you want on the screen
        WebElement canvas = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions
                .moveByOffset(100,20)
                .moveByOffset(200,100)
                .moveByOffset(300,140)
                .release()
                .perform();

//        Press the clear button after drawing
        driver.findElement(By.xpath("//button[@class='button clear']")).click();

//        Close the page

    }
}
