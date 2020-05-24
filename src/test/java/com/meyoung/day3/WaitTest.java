package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author liangjunjun
 * @date 2020-05-07-21:56
 **/
public class WaitTest {
    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //�������
        webDriver = new FirefoxDriver();
    }

    /**
     * �򿪲��Խ���
     * ���wait��ť
     * ��ȡ�ı������ж��Ƿ�Ϊwait for display
     */
    @Test
    public void waitTest(){
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        webDriver.findElement(By.xpath(".//*[@id=\"wait\"]/input")).click();

        //�̵߳ȴ�
//        Thread.sleep(3000);

        //ȫ�ֵȴ�
//        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //��ʾ�ȴ�
        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }

}
