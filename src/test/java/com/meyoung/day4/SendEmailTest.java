package com.meyoung.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-10-21:50
 **/
public class SendEmailTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://mail.163.com/");
    }

    @Test
    public void sendEmail(){
        LoginTest.loginReadyTest(webDriver,"1233","12312312");
        //点击写信按钮
        webDriver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //收件人
        webDriver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("123@163.com");
        //主题
        webDriver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("自动发送短信");
        //上传附件
        webDriver.findElement(By.xpath(".//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\test.jpg");
        //定位iframe,转移控制权
        WebElement iframe = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(iframe);
        //写内容
        webDriver.findElement(By.xpath("/html/body")).sendKeys("dsadasdsa");
        //控制权转交回页面
        webDriver.switchTo().defaultContent();
        //点击发送按钮
        webDriver.findElement(By.xpath(".//*[@text()='发送']")).click();

        //验证发送成功文本
        Boolean b = webDriver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(b);
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
