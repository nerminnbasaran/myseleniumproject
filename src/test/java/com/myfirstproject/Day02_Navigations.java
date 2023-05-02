package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_Navigations {

    public static void main(String[] args) {
//      1.Set Up
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//      2.Create the driver object
        WebDriver driver = new ChromeDriver();
//      3.Now that we have our driver instance, we can START CREATING OUR TEST SCRIPT
//      Maximize the window
        driver.manage().window().maximize();
//      Open google home page https://www.walmart.com/
        driver.get("https://www.walmart.com/");
//      On the same class Navigate to amazon home page https://www.amazon.com/
        //driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.amazon.com/");//Alternative way of navigating to a website
//      Navigate back to google
        driver.navigate().back();
//      Navigate forward to amazon
        driver.navigate().forward();
//      Refresh the page
        driver.navigate().refresh();
//      Close/Quit the browser
//      there are two ways to close the browser:close() or quit(). We should NOT use BOTH
//      driver.close();
        driver.quit();

        /*
        ***What is the difference between get and navigate to functions?
        *Similarities: both let you go to a page
        * get is more common than navigate to
        * get accepts ONLY String as URL, navigate to accepts both String and URL
        * navigate has options such as to(), back(), forward(),refresh()
        *
        ***What is difference between close() and quit()
        *close closed ONLY the last active window
        * quit closes ALL ACTIVE windows
        * recommendation is use quit at the end of the last test case
         */





    }
}
