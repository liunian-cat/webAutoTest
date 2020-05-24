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
        //�������
        webDriver = new FirefoxDriver();
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��id��λ�����ı���
     */
    @Test
    public void byIdTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.id("kw"));
        element.sendKeys("UI�Զ���");
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��name��λ�����ı���
     */
    @Test
    public void byNameTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.name("wd"));
        element.sendKeys("UI�Զ���");
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��className��λ�����ı���
     */
    @Test
    public void byClassNameTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.className("s_ipt"));
        element.sendKeys("UI�Զ���");
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��linkText��λa��ǩ�����ţ�
     */
    @Test
    public void byLinkTextTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.linkText("����"));
        element.click();
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��partialLinkText��λa��ǩ�����ţ�
     */
    @Test
    public void byPartialLinkTextTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.partialLinkText("��"));
        element.click();
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��tagName��λinput��ǩ
     */
    @Test
    public void byTagNameTest(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> elements = webDriver.findElements(By.tagName("input"));
        System.out.println(elements.size());
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��xpath��λ"�ٶ�һ��"��ť
     */
    @Test
    public void byXpathTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='su']"));
        element.click();
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��cssSelector��λ"�ٶ�"ͼƬ
     */
    @Test
    public void byCssSelectorTest(){
        webDriver.get("https://www.baidu.com");
        WebElement element = webDriver.findElement(By.cssSelector("#lg>map>area"));
        element.click();
    }

    /**
     * �򿪰ٶ���ҳ
     * ͨ��xpath��λ"����"
     */
    @Test
    public void byXpathTest1(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> elements = webDriver.findElements(By.xpath(".//*[@id='u1']/a"));
        //��ȡ�ı�
        for(int i=0;i<elements.size();i++){
            String text = elements.get(i).getText();
            System.out.println(text);
        }
    }


    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        //�ر������
        webDriver.quit();
    }
}
