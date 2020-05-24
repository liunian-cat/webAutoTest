package com.meyoung.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-10-10:33
 **/
public class RegisterTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openFF(){
        System.setProperty("webdriver.firefox.bin", "D:\\Mozilla_Firefox\\firefox.exe");
        //打开浏览器
        webDriver = new FirefoxDriver();
        webDriver.get("http://mail.163.com/");
    }

    @Test
    public void registerTest(){
        webDriver.findElement(By.id("lbNormal")).click();
        //控制权转交给iframe里面
        webDriver.switchTo().frame(0);
        //点击注册按钮
        webDriver.findElement(By.id("changepage")).click();
//        webDriver.findElement(By.xpath(".//*[@id='commonOperation']/a[2]")).click();
        //获取当前driver所在的handle值
        String handle1 = webDriver.getWindowHandle();
        //driver切换到新的window页面
        for(String handle:webDriver.getWindowHandles()){
            if(handle.equals(handle1)){
                continue;
            }else{
                webDriver.switchTo().window(handle);
            }
        }

        String time = String.valueOf(System.currentTimeMillis());
        webDriver.findElement(By.id("username")).sendKeys("iloveyou"+time);
        webDriver.findElement(By.id("password")).sendKeys("123123"+time);
        webDriver.findElement(By.id("phone")).sendKeys("13523452345");
        webDriver.findElement(By.id("service")).click();
        webDriver.findElement(By.className("j-register")).click();
    }

    @AfterMethod
    public void closeBrower() throws InterruptedException{
        Thread.sleep(3000);
        webDriver.quit();
    }
}
