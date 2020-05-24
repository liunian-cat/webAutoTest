package com.meyoung.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-03-17:11
 **/
public class CloseBroswers {

    @Test
    public void openFirefox() throws InterruptedException{
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
        Thread.sleep(5000);
        //关闭当前窗口
//        webDriver.close();
        //关闭浏览器
        webDriver.quit();
    }

}
