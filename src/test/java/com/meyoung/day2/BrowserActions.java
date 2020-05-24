package com.meyoung.day2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-03-17:21
 **/
public class BrowserActions {

    WebDriver webDriver;

    @BeforeMethod
    public void openBrower(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 打开火狐浏览器
     * 打开百度首页
     * 等待5S
     * 关闭浏览器
     */

    @Test
    public void openFirefox() throws InterruptedException{
        //打开百度手语舞
        webDriver.get("https://www.baidu.com");
        //等待5s
        Thread.sleep(5000);
    }

    /**
     * 打开火狐浏览器
     * 打开百度首页
     * 等待3S
     * 后退
     * 等待3S
     * 关闭浏览器
     */
    @Test
    public void backTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //后退
        webDriver.navigate().back();
        Thread.sleep(3000);
    }

    /**
     * 打开火狐浏览器
     * 打开百度首页
     * 打开淘宝首页
     * 等待3S
     * 后退
     * 等待3S
     * 前进
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void forwardTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        webDriver.get("http://www.taobao.com");
        Thread.sleep(3000);
        //后退
        webDriver.navigate().back();
        Thread.sleep(3000);
        //前进
        webDriver.navigate().forward();
        Thread.sleep(3000);
    }

    /**
     * 打开火狐浏览器
     * 打开淘宝首页
     * 等待3S
     * 刷新
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void refreshTest() throws InterruptedException{
        webDriver.get("http://www.taobao.com");
        Thread.sleep(3000);
        //刷新
        webDriver.navigate().refresh();
        Thread.sleep(3000);
    }

    /**
     * 打开火狐浏览器
     * 设置窗口大小300*300
     * 等待3S
     * 最大化
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void winTest() throws InterruptedException{
        webDriver.get("https://www.baidu.com");
        //实例化Dimension，设置窗口大小
        Dimension dimension = new Dimension(300,300);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //最大化
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
    }

    /**
     * 打开火狐浏览器
     * 打开百度首页
     * 等待3S
     * 获取当前页面的url
     * 校验当前页面url是不是百度地址
     * 关闭浏览器
     */
    @Test
    public void getUrlTest() throws InterruptedException{
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //获取当前浏览器地址
        String url = webDriver.getCurrentUrl();
        System.out.println("获取到的url是："+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }

    @AfterMethod
    public void closeBrower(){
        //关闭浏览器
        webDriver.quit();
    }
}
