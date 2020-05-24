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
        //�������
        webDriver = new FirefoxDriver();
    }

    /**
     * ����ٶ���ҳ�ġ����š�����
     * У���Ƿ������ҳ��
     */
    @Test
    public void clickTest(){
        webDriver.get("http://www.baidu.com");
        //��λ��������
        WebElement element = webDriver.findElement(By.name("tj_trnews"));
        //�����������
        element.click();
        //��ȡ��ǰҳ���url
        String url = webDriver.getCurrentUrl();
        //У�鵱ǰҳ���ǲ�������ҳ��
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * �򿪰ٶ���ҳ
     * ����ؼ���selenium�ؼ���
     * ����ٶ�һ������
     * У��title�Ƿ����"selenium_�ٶ�����"
     */
    @Test
    public void sendKeyTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        //�ٶ�����������selenium
        webDriver.findElement(By.id("kw")).sendKeys("selenium");
        //����ٶ�һ�°�ť
        webDriver.findElement(By.id("su")).click();

        Thread.sleep(2000);
        //��ȡtitle
        String text = webDriver.getTitle();
        //У��
        Assert.assertEquals(text,"selenium_�ٶ�����");
    }

    /**
     * �򿪰ٶ���ҳ
     * ����ؼ���selenium�ؼ���
     * ����ı���
     */
    @Test
    public void clearTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        WebElement e = webDriver.findElement(By.id("kw"));
        e.sendKeys("selenium");
        Thread.sleep(2000);
        //����ı���
        e.clear();
    }

    /**
     * �򿪰ٶ���ҳ
     * ��ȡ�����ı�
     * getText��ȡ��ǩ֮���ֵ
     */
    @Test
    public void getTextTest() throws InterruptedException{
        webDriver.get("http://www.baidu.com");
        //��ȡ�����ı�
        String text1 = webDriver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text1,"����");
    }

    /**
     * �򿪰ٶ���ҳ
     * ��ȡ�ı����tagname
     * У���Ƿ�Ϊinput
     */
    @Test
    public void getTagNameTest(){
        webDriver.get("http://www.baidu.com");
        //��ȡ��ǩ��
        String tagName = webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     * �򿪰ٶ�ҳ��
     * �жϰ�ť��ʾ���ı�ֵΪ�ٶ�һ��
     */
    @Test
    public void getATest(){
        webDriver.get("http://www.baidu.com");
        //��ȡvalueֵ
        String value = webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(value,"�ٶ�һ��");
    }

    /**
     * �򿪰ٶ���ҳ
     * �ж��Ƿ���ʾ�ٶ�һ�°�ť
     */
    @Test
    public void isDisplayTest(){
        webDriver.get("http://www.baidu.com");
        //�ж��Ƿ���ʾ
        Boolean b = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    /**
     * �򿪲���ҳ��
     * �ж�Volvo��ѡ��ѡ��
     */
    @Test
    public void isSelectTest() throws InterruptedException{
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='radio']/label[1]"));
        element.click();
        //�ж��Ƿ�ѡ��
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * �򿪲���ҳ��
     * �ж�submit��ť����δ����״̬
     */
    @Test
    public void isEnabledTest(){
        webDriver.get("file:///G:/%E6%B5%8B%E8%AF%95%E8%B5%84%E6%96%99/%E5%85%B6%E4%BB%96/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium+java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        Boolean b = webDriver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }

    /**
     * ��ͼ�ٶ���ҳ
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
