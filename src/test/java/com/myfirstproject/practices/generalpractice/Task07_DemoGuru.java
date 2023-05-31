package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Task07_DemoGuru extends TestBase {

        /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
  */

    @Test
    public void dragDropTest(){

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        scrollAllTheWayDownJS();

        dragAndDropActions(driver.findElement(By.id("credit2")),driver.findElement(By.id("bank")));
        dragAndDropActions(driver.findElement(By.id("fourth")),driver.findElement(By.id("amt7")));
        dragAndDropActions(driver.findElement(By.id("credit1")),driver.findElement(By.id("loan")));
        dragAndDropActions(driver.findElement(By.id("fourth")),driver.findElement(By.id("amt8")));

        verifyElementDisplayed(driver.findElement(By.xpath("//*[text()='Perfect!']")));



    }
}
