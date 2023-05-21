package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day12_JSExecutor extends TestBase {

    @Test
    public void scrollIntoViewTest() throws IOException {
        driver.get("https://www.amazon.com");

//        Locating footer element on amazon page
        WebElement footer = driver.findElement(By.xpath("//div[@id='navFooter']//tbody"));

//        Scroll into that element
        scrollIntoViewJS(footer);

//        Assert if that footer is exists on the page
        Assert.assertTrue(footer.isDisplayed());

//        Take a screenshot of the page
        takeScreenshotOfTheEntirePage();

//        Locate the search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchbox"));

//        and scroll into that element
        scrollIntoViewJS(searchBox);

//        then verify the element is displayed
        Assert.assertTrue(searchBox.isDisplayed());

//        then take screenshot
        takeScreenshotOfTheEntirePage();
    }

    @Test
    public void scrollAllTheWayUpDownTest() throws IOException, InterruptedException {
        driver.get("https://www.amazon.com");

//        Scroll all the way down and take a screenshot of the page
        scrollAllTheWayDownJS();
        takeScreenshotOfTheEntirePage();

        Thread.sleep(3000);

//        Scroll all the way up and take a screenshot of the page
        scrollAllTheWayUpJS();
        takeScreenshotOfTheEntirePage();
    }

    @Test
    public void clickByJSTest() throws InterruptedException, IOException {
//        search porcelain tea set on amazon
        driver.get("https://www.amazon.com");

//        locating searchbox
        WebElement searchBox = driver.findElement(By.id("twotabsearchbox"));

//        typing porcelain tea set
        searchBox.sendKeys("porcelain tea set");
        Thread.sleep(5000);
        takeScreenshotOfTheEntirePage();

//        locating search button and clicking on it with js executor
        WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
        clickByJS(searchIcon);//JS CLICK
        takeScreenshotOfTheEntirePage();
    }

    @Test
    public void locateElementByJSTest() throws InterruptedException {
//        search porcelain tea set on amazon
        driver.get("https://www.amazon.com");

//        locating the search box using js executor
        WebElement searchBox = locateElementByJS("twotabsearchbox");
        searchBox.sendKeys("porcelain tea set");
        Thread.sleep(5000);

//        locating search box icon using js executor
        WebElement searchIcon = locateElementByJS("nav-search-submit-button");
        clickByJS(searchIcon);
    }

    @Test
    public void typeWithJS(){
//        search porcelain tea set on amazon
        driver.get("https://www.amazon.com");

//        locating the search box using js executor
        WebElement searchBox = locateElementByJS("twotabsearchbox");

//        type the search box
        setValueByJS(searchBox,"porcelain tea set");

//        locating search box icon using js executor
        WebElement searchIcon = locateElementByJS("nav-search-submit-button");
        clickByJS(searchIcon);
    }
}
