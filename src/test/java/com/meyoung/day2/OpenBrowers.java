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

    //IE�ں˰汾��webdriver�汾һ��

    @Test
    public void openFirefox(){
        //����·����48���²���Ҫ�ں�
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }

}
