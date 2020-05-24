package com.meyoung.day4;

import com.po.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;

import java.util.concurrent.TimeUnit;

/**
 * @author liangjunjun
 * @date 2020-05-10-11:28
 **/
public class LoginTest {

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
    public void loginSuccess(){
        LoginTest.loginReadyTest(webDriver,"1233","12312312");
        //��ʾ�ȴ�
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("�˳�")));
        //��֤�˳���ť
        String logout = webDriver.findElement(By.linkText("�˳�")).getText();
        Assert.assertEquals(logout,"�˳�");
    }

    @Test
    public void loginError(){
        LoginTest.loginReadyTest(webDriver,"1233","12312312");
        //��ʾ�ȴ�
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        //��ȡ�û�������������ı�
        String error = webDriver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"�˺Ż��������");
    }

    public static void loginReadyTest(WebDriver driver,String email,String password){
        driver.findElement(By.id("lbNormal")).click();
        //����Ȩת����iframe����
        driver.switchTo().frame(0);

        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(password);
        driver.findElement(LoginPage.loginButton).click();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
