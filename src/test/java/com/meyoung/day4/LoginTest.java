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
        //打开浏览器
        webDriver = new FirefoxDriver();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://mail.163.com/");
    }

    @Test
    public void loginSuccess(){
        LoginTest.loginReadyTest(webDriver,"1233","12312312");
        //显示等待
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        //验证退出按钮
        String logout = webDriver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }

    @Test
    public void loginError(){
        LoginTest.loginReadyTest(webDriver,"1233","12312312");
        //显示等待
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        //获取用户名或密码错误文本
        String error = webDriver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
        Assert.assertEquals(error,"账号或密码错误");
    }

    public static void loginReadyTest(WebDriver driver,String email,String password){
        driver.findElement(By.id("lbNormal")).click();
        //控制权转交给iframe里面
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
