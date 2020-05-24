package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.HTML;
import java.util.List;

/**
 * @author liangjunjun
 * @date 2020-05-03-19:00
 **/
public class FindElement {

    WebDriver webDriver;

    @BeforeMethod
    public void openBrower(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 打开百度首页
     * 通过id定位搜索文本框
     */
    @Test
    public void byIdTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.id("kw"));
        element.sendKeys("UI自动化");
    }

    /**
     * 打开百度首页
     * 通过name定位搜索文本框
     */
    @Test
    public void byNameTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.name("wd"));
        element.sendKeys("UI自动化");
    }

    /**
     * 打开百度首页
     * 通过className定位搜索文本框
     */
    @Test
    public void byClassNameTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.className("s_ipt"));
        element.sendKeys("UI自动化");
    }

    /**
     * 打开百度首页
     * 通过linkText定位a标签（新闻）
     */
    @Test
    public void byLinkTextTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.linkText("新闻"));
        element.click();
    }

    /**
     * 打开百度首页
     * 通过partialLinkText定位a标签（新闻）
     */
    @Test
    public void byPartialLinkTextTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.partialLinkText("新"));
        element.click();
    }

    /**
     * 打开百度首页
     * 通过tagName定位input标签
     */
    @Test
    public void byTagNameTest(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> elements = webDriver.findElements(By.tagName("input"));
        System.out.println(elements.size());
    }

    /**
     * 打开百度首页
     * 通过xpath定位"百度一下"按钮
     */
    @Test
    public void byXpathTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='su']"));
        element.click();
    }

    /**
     * 打开百度首页
     * 通过cssSelector定位"百度"图片
     */
    @Test
    public void byCssSelectorTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.cssSelector("#lg>map>area"));
        element.click();
    }

    /**
     * 打开百度首页
     * 通过xpath定位"新闻"
     */
    @Test
    public void byXpathTest1(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> elements = webDriver.findElements(By.xpath(".//*[@id='u1']/a"));
        //获取文本
        for(int i=0;i<elements.size();i++){
            String text = elements.get(i).getText();
            System.out.println(text);
        }
    }


    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        //关闭浏览器
        webDriver.quit();
    }
}
