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
        //�رյ�ǰ����
//        webDriver.close();
        //�ر������
        webDriver.quit();
    }

}
