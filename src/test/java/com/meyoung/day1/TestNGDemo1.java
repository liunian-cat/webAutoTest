package com.meyoung.day1;

import org.testng.annotations.*;

/**
 * @author liangjunjun
 * @date 2020-05-03-14:55
 **/
public class TestNGDemo1 {

    @BeforeTest
    public void beforeTest1(){
        System.out.println("²âÊÔbeforeTest1");
    }

    @BeforeMethod
    public void beforeMethod1(){
        System.out.println("²âÊÔbeforeMethod1");
    }

    @Test
    public void test2(){
        System.out.println("²âÊÔtestng×¢½â,case2");
    }

    @Test
    public void test1(){
        System.out.println("²âÊÔtestng×¢½â,case1");
    }

    @AfterMethod
    public void afterMethod1(){
        System.out.println("²âÊÔafterMethod1");
    }

    @AfterTest
    public void afterTest1(){
        System.out.println("²âÊÔafterTest1");
    }
}
