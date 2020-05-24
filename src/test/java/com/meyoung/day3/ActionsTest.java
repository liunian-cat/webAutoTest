package com.meyoung.day3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author liangjunjun
 * @date 2020-05-06-15:28
 **/
public class ActionsTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 点击百度首页的“新闻”链接
     * 校验是否打开新闻页面
     */
    @Test
    public void clickTest(){
        webDriver.get("http://www.baidu.com");
        //定位新闻链接
        WebElement element = webDriver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        element.click();
        //获取当前页面的url
        String url = webDriver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium关键字
     * 点击百度一下搜索
     * 校验title是否等于"selenium_百度搜索"
     */
    @Test
    public void sendKeyTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        //百度搜索框输入selenium
        webDriver.findElement(By.id("kw")).sendKeys("selenium");
        //点击百度一下按钮
        webDriver.findElement(By.id("su")).click();

        Thread.sleep(2000);
        //获取title
        String text = webDriver.getTitle();
        //校验
        Assert.assertEquals(text,"selenium_百度搜索");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium关键字
     * 清空文本框
     */
    @Test
    public void clearTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        WebElement e = webDriver.findElement(By.id("kw"));
        e.sendKeys("selenium");
        Thread.sleep(2000);
        //清空文本框
        e.clear();
    }

    /**
     * 打开百度首页
     * 获取新闻文本
     * getText获取标签之间的值
     */
    @Test
    public void getTextTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        //获取新闻文本
        String text1 = webDriver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text1,"新闻");
    }

    /**
     * 打开百度首页
     * 获取文本框的tagname
     * 校验是否为input
     */
    @Test
    public void getTagNameTest(){
        webDriver.get("http://www.baidu.com");
        //获取标签名
        String tagName = webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 打开百度页面
     * 判断按钮显示的文本值为百度一下
     */
    @Test
    public void getATest(){
        webDriver.get("http://www.baidu.com");
        //获取value值
        String value = webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(value,"百度一下");
    }

    /**
     * 打开百度首页
     * 判断是否显示百度一下按钮
     */
    @Test
    public void isDisplayTest(){
        webDriver.get("http://www.baidu.com");
        //判断是否显示
        Boolean b = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面
     * 判断Volvo单选框被选中
     */
    @Test
    public void isSelectTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='radio']/label[1]"));
        element.click();
        //判断是否选中
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面
     * 判断submit按钮处于未激活状态
     */
    @Test
    public void isEnabledTest(){
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        Boolean b = webDriver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }

    /**
     * 截图百度首页
     */
    @Test
    public void shotTest(){
        webDriver.get("http://www.baidu.com");
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File("D:\\test.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
