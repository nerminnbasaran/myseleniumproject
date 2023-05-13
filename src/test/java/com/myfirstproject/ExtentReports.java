package com.myfirstproject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReports {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public void extentReportsSetup(){
//        PATH
        String now = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports"+now+"extent_reports.html";

//
    }
}
