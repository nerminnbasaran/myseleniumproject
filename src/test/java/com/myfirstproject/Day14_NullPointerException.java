package com.myfirstproject;


import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Day14_NullPointerException{

    /*
    When a variable is created, but not instantiated, when pointer does not show any value we get NullPointerException
    Solution:
    -Instantiate the variable
     */
    WebDriver driver;
//    WebDriver driver = new ChromeDriver();
    Faker faker;
//    Faker faker = new Faker();

    @Test
    public void nullPointerExceptionTest1(){

        driver.get("https://www.amazon.com");//NullPointerException cause driver has no assigned value.(not instantiated)

    }

    @Test
    public void nullPointerExceptionTest2(){

        System.out.println(faker.name().firstName());//NullPointerException cause faker object is not instantiated
    }
}
