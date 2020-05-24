package com.meyoung.day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author liangjunjun
 * @date 2020-05-11-20:11
 **/
public class GridTest {

    @Test
    public void gridTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.199.206:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");

        Thread.sleep(5000);

        driver.quit();
    }

    @DataProvider(name="data4")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox","http://192.168.199.206:4444/"},
                {"chrome","http://192.168.199.206:4444/"}
        };
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser,String url) throws MalformedURLException,InterruptedException{
        DesiredCapabilities dc = null;
        if(browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if(browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }

        WebDriver driver = new RemoteWebDriver(new URL(url+"wd/hub"),dc);
        driver.get("http://www.baidu.com");

        Thread.sleep(5000);

        driver.quit();
    }

    @Test(dataProvider = "data4")
    public void testGrid3(String browser,String url) throws MalformedURLException,InterruptedException{
        DesiredCapabilities dc = null;
        if(browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if(browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }

        WebDriver driver = new RemoteWebDriver(new URL(url+"wd/hub"),dc);
        driver.get("http://www.baidu.com");

        Thread.sleep(5000);

        driver.quit();
    }
}
