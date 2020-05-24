package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-07-21:14
 **/
public class SelectTest {
    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 打开测试页面
     * 下拉框选择vivo
     * 第二次选择huawei
     * 第三次选择iphone
     */
    @Test
    public void selectTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = webDriver.findElement(By.id("moreSelect"));
        //实例化select类
        Select select = new Select(element);
        //通过索引选择下拉框
        select.selectByIndex(2);
        Thread.sleep(3000);
        //通过属性value值选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(3000);
        //通过文本值选择下拉框
        select.selectByVisibleText("iphone");
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
