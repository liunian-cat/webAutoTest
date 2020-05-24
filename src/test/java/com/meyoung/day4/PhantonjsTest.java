package com.meyoung.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-09-20:23
 **/
public class PhantonjsTest {
    @Test
    public void pjsTest() throws InterruptedException{
        System.setProperty("phantomjs.binary.path","D:\\web_auto_test\\webauto\\src\\main\\drivers\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("webdriver");
        Thread.sleep(3000);

        String a = driver.getTitle();
        System.out.println(a);

        driver.quit();
    }
}
