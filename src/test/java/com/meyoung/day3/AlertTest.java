package com.meyoung.day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-07-18:40
 **/
public class AlertTest {
    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 打开UI自动化测试主页
     * 点击alert按钮
     * 在alert警告框点击确定按钮
     */
    @Test
    public void alertTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.className("alert")).click();
        Thread.sleep(1000);
        //把控制权转交给alert
        Alert a = webDriver.switchTo().alert();
        //获取文本
        String text = a.getText();
        //点击确定
        a.accept();
        //校验文本内容
        Assert.assertEquals(text,"请点击确定");
    }

    /**
     * 打开UI自动化测试主页
     * 点击confirm按钮
     * 在confirm警告框点击取消按钮
     * 再次点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        //driver控制权转交给alert
        Alert a = webDriver.switchTo().alert();
        //点击取消
        a.dismiss();
        Thread.sleep(3000);
        //点击确定
        a.accept();
    }

    /**
     * 打开UI自动化测试主页
     * 点击prompt按钮
     * 在prompt弹框中输入这是prompt
     * 点击确定
     * 再次点击确定按钮
     */
    @Test
    public void promptTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        //driver控制权转交给alert
        Alert a = webDriver.switchTo().alert();
        //输入值
        a.sendKeys("这是prompt");
        Thread.sleep(3000);
        //点击确定
        a.accept();
        Thread.sleep(3000);
        //再次点击确定
        a.accept();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
