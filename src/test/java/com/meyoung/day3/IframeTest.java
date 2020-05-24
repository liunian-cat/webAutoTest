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
        //�������
        webDriver = new FirefoxDriver();
    }

    /**
     * �򿪲���ҳ��
     * ����ٶ�����
     */
    @Test
    public void iframeTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        //ͨ��id����name��ʽת������Ȩ
//        webDriver.switchTo().frame("aa");
        //ͨ��webelement��ʽת�����ɲ��ת��
        WebElement element = webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(element);
        //����ٶ�����
        webDriver.findElement(By.linkText("baidu")).click();

        Thread.sleep(3000);
        //����Ȩת��ԭ���Ľ���
        webDriver.switchTo().defaultContent();
        //�����½��������
        webDriver.findElement(By.linkText("��½����")).click();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
