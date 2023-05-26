package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
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
        WebElement emojis = driver.findElement(By.xpath("//*[@id='nature']//div"));
        System.out.println(emojis.getText());
//        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']"));
//        emojis.forEach(t-> System.out.println(t.getText()));

//        Go outside iFrame
        driver.switchTo().defaultContent();

//        Fill the form
        List<WebElement> allInputs = driver.findElements(By.xpath("//input"));
        List<String> allWords = new ArrayList<>(Arrays.asList("This","iFrame","example","looks","very","funny","does", "not", "it","?","?"));
        for(int i = 0; i<allInputs.size(); i++){
            allInputs.get(i).sendKeys(allWords.get(i));
        }

//        Press the apply button
        driver.findElement(By.xpath("//button[@id='send']")).click();

//        Verify "code" element is displayed
        WebElement textArea= driver.findElement(By.xpath("//textarea[@id='code']"));
        Assert.assertTrue(textArea.isDisplayed());


    }
}
