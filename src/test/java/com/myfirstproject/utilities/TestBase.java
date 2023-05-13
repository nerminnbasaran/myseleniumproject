package com.myfirstproject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    protected static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    public void takeScreenshotOfTheEntirePage() throws IOException {

//        1. TakeScreenShot class with getScreenShotAs method to capture the screenshot
       File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//        2. Create a path to save the image
//           Create a data for giving dynamic name otherwise the screenshots overrides
        String now = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());//getting local date in this format
//                       CURRENT PROJECT FOLDER        foldername  subfoldername   imagename
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/" +now+"image.png";

//        3. Save the image in the path as a file
        FileUtils.copyFile(image,new File(path));
//        FileUtils.copyFile(FILE,FILE PATH); COPY FILE TO THAT FILE PATH

    }

//        This method captures screenshot of specific elements
//        This method accepts an elements and saves the screenshot of that element in the test-output folder
    public void takeScreenshotOfThisElement(WebElement element) throws IOException {
        File image = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/ElementScreenshots/"+now+"image.png";
        FileUtils.copyFile(image,new File(path));
    }


}
