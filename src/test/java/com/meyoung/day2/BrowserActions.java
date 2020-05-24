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
        //�������
        webDriver = new FirefoxDriver();
    }

    /**
     * �򿪻�������
     * �򿪰ٶ���ҳ
     * �ȴ�5S
     * �ر������
     */

    @Test
    public void openFirefox() throws InterruptedException{
        //�򿪰ٶ�������
        webDriver.get("https://www.baidu.com");
        //�ȴ�5s
        Thread.sleep(5000);
    }

    /**
     * �򿪻�������
     * �򿪰ٶ���ҳ
     * �ȴ�3S
     * ����
     * �ȴ�3S
     * �ر������
     */
    @Test
    public void backTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //����
        webDriver.navigate().back();
        Thread.sleep(3000);
    }

    /**
     * �򿪻�������
     * �򿪰ٶ���ҳ
     * ���Ա���ҳ
     * �ȴ�3S
     * ����
     * �ȴ�3S
     * ǰ��
     * �ȴ�3s
     * �ر������
     */
    @Test
    public void forwardTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        webDriver.get("http://www.taobao.com");
        Thread.sleep(3000);
        //����
        webDriver.navigate().back();
        Thread.sleep(3000);
        //ǰ��
        webDriver.navigate().forward();
        Thread.sleep(3000);
    }

    /**
     * �򿪻�������
     * ���Ա���ҳ
     * �ȴ�3S
     * ˢ��
     * �ȴ�3s
     * �ر������
     */
    @Test
    public void refreshTest() throws InterruptedException{
        webDriver.get("http://www.taobao.com");
        Thread.sleep(3000);
        //ˢ��
        webDriver.navigate().refresh();
        Thread.sleep(3000);
    }

    /**
     * �򿪻�������
     * ���ô��ڴ�С300*300
     * �ȴ�3S
     * ���
     * �ȴ�3s
     * �ر������
     */
    @Test
    public void winTest() throws InterruptedException{
        webDriver.get("https://www.baidu.com");
        //ʵ����Dimension�����ô��ڴ�С
        Dimension dimension = new Dimension(300,300);
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        //���
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
    }

    /**
     * �򿪻�������
     * �򿪰ٶ���ҳ
     * �ȴ�3S
     * ��ȡ��ǰҳ���url
     * У�鵱ǰҳ��url�ǲ��ǰٶȵ�ַ
     * �ر������
     */
    @Test
    public void getUrlTest() throws InterruptedException{
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //��ȡ��ǰ�������ַ
        String url = webDriver.getCurrentUrl();
        System.out.println("��ȡ����url�ǣ�"+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }

    @AfterMethod
    public void closeBrower(){
        //�ر������
        webDriver.quit();
    }
}
