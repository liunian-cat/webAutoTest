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
        //�������
        webDriver = new FirefoxDriver();
    }

    /**
     * ��UI�Զ���������ҳ
     * ���alert��ť
     * ��alert�������ȷ����ť
     */
    @Test
    public void alertTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.className("alert")).click();
        Thread.sleep(1000);
        //�ѿ���Ȩת����alert
        Alert a = webDriver.switchTo().alert();
        //��ȡ�ı�
        String text = a.getText();
        //���ȷ��
        a.accept();
        //У���ı�����
        Assert.assertEquals(text,"����ȷ��");
    }

    /**
     * ��UI�Զ���������ҳ
     * ���confirm��ť
     * ��confirm�������ȡ����ť
     * �ٴε��ȷ����ť
     */
    @Test
    public void confirmTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        //driver����Ȩת����alert
        Alert a = webDriver.switchTo().alert();
        //���ȡ��
        a.dismiss();
        Thread.sleep(3000);
        //���ȷ��
        a.accept();
    }

    /**
     * ��UI�Զ���������ҳ
     * ���prompt��ť
     * ��prompt��������������prompt
     * ���ȷ��
     * �ٴε��ȷ����ť
     */
    @Test
    public void promptTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        //driver����Ȩת����alert
        Alert a = webDriver.switchTo().alert();
        //����ֵ
        a.sendKeys("����prompt");
        Thread.sleep(3000);
        //���ȷ��
        a.accept();
        Thread.sleep(3000);
        //�ٴε��ȷ��
        a.accept();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
