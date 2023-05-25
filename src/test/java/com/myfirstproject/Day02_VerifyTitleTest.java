package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
//      Navigate to techproeducation homepage
//      Verify if page title is "TechPro Education | Online It Courses & Bootcamps"
        LoggerUtils.info("Starting the testing...Opening the URL");
        driver.get("https://www.techproeducation.com");
        LoggerUtils.info("Getting the page title");
        String actualTitle = driver.getTitle();//returns the TITLE of the page as String
        if(actualTitle.equals("TechPro Education | Online It Courses & Bootcamps")){
            System.out.println("PASS");
            LoggerUtils.info("PASS...Page Title is "+driver.getTitle());
        }else{
            System.out.println("FAIL");
            System.out.println("EXPECTED TITLE: TechPro Education | Online It Courses & Bootcamps");
            System.out.println("ACTUAL TITLE: "+ actualTitle);
            LoggerUtils.info("FAIL... Page title is "+driver.getTitle());
        }
        driver.quit();


    }

}
