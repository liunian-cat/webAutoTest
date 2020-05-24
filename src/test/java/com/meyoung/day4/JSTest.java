package com.meyoung.day4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-09-20:04
 **/
public class JSTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //´ò¿ªä¯ÀÀÆ÷
        webDriver = new FirefoxDriver();
    }

    //Ö´ÐÐjs
    @Test
    public void jsTest(){
        webDriver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
