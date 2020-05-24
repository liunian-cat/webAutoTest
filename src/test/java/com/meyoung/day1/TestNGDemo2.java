package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-03-15:28
 **/
public class TestNGDemo2 {

    /**
     * 校验a=a
     */
    @Test
    public void assertEqualTest(){
        String a = "asdf";
        String b = "asdf11";
        Assert.assertEquals(a,b,"不相等");//之后不要接任何操作
    }

    @Test
    public void assertNotEqualTest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }

    @Test
    public void assertNullTest(){
        String aa = "";//不通过
        String bb = null;//通过
        Assert.assertNull(bb);
    }

    @Test
    public void assertNotNullTest(){
        String aa = "";//通过
        String bb = null;//不通过
        Assert.assertNotNull(aa);
    }

    @Test
    public void assertFalse(){
        boolean aa = false;//通过
        Assert.assertFalse(aa);
    }
}
