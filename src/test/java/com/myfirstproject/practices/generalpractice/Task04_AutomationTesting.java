package com.myfirstproject.practices.generalpractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task04_AutomationTesting extends TestBase {

    /*
-Go to http://demo.automationtesting.in/Alerts.html

-Click the button "click the button to display an alert box:" opposite "Alert with OK"

-Print the text on the alert to the console and click the "OK" button.

-Click the "Alert with OK & Cancel" button and then click the "Click the button to display a confirm box"

-Press the "cancel" button in the alert

-Assert "You Pressed Cancel" text is displayed

-Click the "Alert with Textbox" button and then click the "Click the button to demonstrate the prompt box"

-Write your 'name' in the prompt box and click "OK"

-Print the message to console

-Verify that the message is 'Hello <your name> How are you today'
*/

    @Test
    public void alertsTest(){

//        -Go to http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

//        -Click the button "click the button to display an alert box:" opposite "Alert with OK"
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

//        -Print the text on the alert to the console and click the "OK" button.
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        waitFor(1);
        alert.accept();

//       -Click the "Alert with OK & Cancel" button and then click the "Click the button to display a confirm box"
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

//       -Press the "cancel" button in the alert
        driver.switchTo().alert().dismiss();

//       -Assert "You Pressed Cancel" text is displayed
        waitFor(1);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='demo']")).getText().contains("You Pressed Cancel"));
//
//       -Click the "Alert with Textbox" button and then click the "Click the button to demonstrate the prompt box"
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

//       -Write your 'name' in the prompt box and click "OK"
        waitFor(1);
        driver.switchTo().alert().sendKeys("nermin");
        driver.switchTo().alert().accept();
//
//       -Print the message to console
        WebElement message = driver.findElement(By.xpath("//p[@id='demo1']"));
        System.out.println(message.getText());

//       -Verify that the message is 'Hello <your name> How are you today'
        Assert.assertTrue(message.getText().contains("How are you today"));



    }
}
