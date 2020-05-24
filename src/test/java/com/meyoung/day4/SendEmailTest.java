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
        //�������
        webDriver = new FirefoxDriver();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://mail.163.com/");
    }

    @Test
    public void sendEmail(){
        LoginTest.loginReadyTest(webDriver,"1233","12312312");
        //���д�Ű�ť
        webDriver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //�ռ���
        webDriver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("123@163.com");
        //����
        webDriver.findElement(By.xpath(".//*[@aria-label='�ʼ�����������������ʼ�����']/input")).sendKeys("�Զ����Ͷ���");
        //�ϴ�����
        webDriver.findElement(By.xpath(".//*[@title=\"һ�οɷ���2000����Ƭ��600��MP3��һ�������Ӱ\"]/input")).sendKeys("C:\\Users\\test.jpg");
        //��λiframe,ת�ƿ���Ȩ
        WebElement iframe = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(iframe);
        //д����
        webDriver.findElement(By.xpath("/html/body")).sendKeys("dsadasdsa");
        //����Ȩת����ҳ��
        webDriver.switchTo().defaultContent();
        //������Ͱ�ť
        webDriver.findElement(By.xpath(".//*[@text()='����']")).click();

        //��֤���ͳɹ��ı�
        Boolean b = webDriver.findElement(By.xpath(".//*[text()='���ͳɹ�']")).isDisplayed();
        Assert.assertTrue(b);
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
