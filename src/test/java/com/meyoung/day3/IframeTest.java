package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-07-20:54
 **/
public class IframeTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 打开测试页面
     * 点击百度链接
     */
    @Test
    public void iframeTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        //通过id或者name方式转交控制权
//        webDriver.switchTo().frame("aa");
        //通过webelement方式转交，可层层转交
        WebElement element = webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(element);
        //点击百度链接
        webDriver.findElement(By.linkText("baidu")).click();

        Thread.sleep(3000);
        //控制权转回原来的界面
        webDriver.switchTo().defaultContent();
        //点击登陆界面链接
        webDriver.findElement(By.linkText("登陆界面")).click();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
