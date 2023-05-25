package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task05_Jquery extends TestBase {
        /*
   Given
       Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
   When
       Click on the "Animals and Nature" emoji
   And
       Print emojis under "Animals and Nature" emoji
   And
       Fill the form
   And
       Press the apply button
   Then
       Verify "code" element is displayed
    */

    @Test
    public void clickAndPrintTest(){


//        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

//        Click on the "Animals and Nature" emoji
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        waitFor(1);
        WebElement animal = driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]"));
        animal.click();

//        Print emojis under "Animals and Nature" emoji
        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']"));
        emojis.forEach(t-> System.out.println(t.getText()));

//        Fill the form
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("Start");
        driver.findElement(By.xpath("//input[@id='smiles']")).sendKeys("Good");
        driver.findElement(By.xpath("//input[@id='nature']")).sendKeys("Nature");
        driver.findElement(By.xpath("//input[@id='food']")).sendKeys("Nut");
        driver.findElement(By.xpath("//input[@id='activities']")).sendKeys("Run");
        driver.findElement(By.xpath("//input[@id='places']")).sendKeys("Prison");
        driver.findElement(By.xpath("//input[@id='symbols']")).sendKeys("Star");
        driver.findElement(By.xpath("//input[@id='flags']")).sendKeys("People");

//        Press the apply button
        driver.findElement(By.xpath("//button[@id='send']")).click();

//        Verify "code" element is displayed
        WebElement textArea= driver.findElement(By.xpath("//textarea[@id='code']"));
        Assert.assertTrue(textArea.isDisplayed());


    }
}
