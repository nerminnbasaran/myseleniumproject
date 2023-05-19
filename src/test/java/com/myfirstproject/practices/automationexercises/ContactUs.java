package com.myfirstproject.practices.automationexercises;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactUs extends TestBase {

    @Test
    public void contactUs() throws InterruptedException {

//        1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Brands']")).isDisplayed());

//        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("(//li/a/i)[8]")).click();

//        5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Get In Touch']")).isDisplayed());

//        6. Enter name, email, subject and message
        driver.findElement(By.name("name")).sendKeys("John Doe");
        driver.findElement(By.name("email")).sendKeys("j.johndoe@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("Payment");
        driver.findElement(By.id("message")).sendKeys("I have a problem about online payment");

//        7. Upload file
        WebElement chooseAFile = driver.findElement(By.name("upload_file"));

        String pathOfFlower = System.getProperty("user.home")+"/Desktop/flower.jpeg";

        chooseAFile.sendKeys(pathOfFlower);

//        8. Click 'Submit' button
        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        clickByJS(submitButton);

        Thread.sleep(5000);

//        9. Click OK button
//        driver.switchTo().alert().accept();

//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@style='display: block;'])[1]")).isDisplayed());

//        11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[text()=' Home'])[2]")).click();

        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
    }
}
