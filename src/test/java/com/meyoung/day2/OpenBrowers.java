package com.meyoung.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-03-16:32
 **/
public class OpenBrowers {

    //IE内核版本跟webdriver版本一样

    @Test
    public void openFirefox(){
        //设置路径，48以下不需要内核
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }

}
