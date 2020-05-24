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
 * @date 2020-05-07-21:28
 **/
public class WindowSelectTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 打开测试页面
     * 点击open new window
     * 点击baidu
     */
    @Test
    public void test1() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.linkText("Open new window")).click();

        Thread.sleep(3000);
        String handle1 = webDriver.getWindowHandle();//获取当前页面句柄值

        for (String hanles:webDriver.getWindowHandles()){
            if(hanles.equals(handle1)){
                continue;
            }else {//获取其他页面的句柄值
                webDriver.switchTo().window(hanles);
            }
        }

        webDriver.findElement(By.linkText("baidu")).click();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
