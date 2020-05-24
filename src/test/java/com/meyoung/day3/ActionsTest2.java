package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @author liangjunjun
 * @date 2020-05-08-17:51
 **/
public class ActionsTest2 {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
    }

    /**
     * 打开百度页面
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClickTest(){
        webDriver.get("http://www.baidu.com");

        WebElement element = webDriver.findElement(By.id("su"));
        //实例化Actions
        Actions actions = new Actions(webDriver);
        //在百度一下按钮右键
        actions.contextClick(element).perform();
    }

    /**
     * 打开百度页面
     * 双击百度一下按钮
     */
    @Test
    public void doubleClickTest(){
        webDriver.get("http://www.baidu.com");

        WebElement element = webDriver.findElement(By.id("su"));
        //实例化Actions
        Actions actions = new Actions(webDriver);
        //在百度一下按钮双击
        actions.doubleClick(element).perform();
    }

    /**
     * 打开测试页面
     * 鼠标移动到action按钮
     * 显示hello world
     */
    @Test
    public void onfocusTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='action']/input"));

        //实例化Actions
        Actions actions = new Actions(webDriver);
        //鼠标移动到action按钮
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        String text = webDriver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(text,"Hello World!");
    }

    @Test
    public void dropTest(){
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        WebElement element = webDriver.findElement(By.id("drag"));
        Actions actions = new Actions(webDriver);
        //拖拽元素
        actions.dragAndDropBy(element,500,500).perform();
    }

    @Test
    public void dropTest1(){
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        WebElement element = webDriver.findElement(By.id("drag"));
        WebElement element1 = webDriver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(webDriver);
        //拖拽、移动、释放
        actions.clickAndHold(element)
                .moveToElement(element1).release(element).perform();
    }

    @Test
    public void moreSelectTest(){
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = webDriver.findElements(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']/option"));

        Actions actions = new Actions(webDriver);
        //按住shift键选择多个
        actions.keyDown(Keys.SHIFT)
                .click(list.get(1))
                .click(list.get(2))
                .keyUp(Keys.SHIFT)
                .perform();
    }

    @Test
    public void saveHtml() throws AWTException {
        webDriver.get("http://www.baidu.com");
        Robot robot = new Robot();
        //ctrl+s  保存
        robot.keyPress(KeyEvent.VK_CONTROL);
//        int keyS = (int)new Character('S');  ASCII码
        robot.keyPress(KeyEvent.VK_S);
        //按回车键保存
        robot.keyPress(KeyEvent.VK_ENTER);
        //释放ctrl键
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     * 上传
     */
    @Test
    public void uploadTest(){
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.id("load"))
                .sendKeys("C:\\Users\\liang\\Pictures\\Saved Pictures\\狗子1.jpg");

    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
