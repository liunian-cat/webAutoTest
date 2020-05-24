package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author liangjunjun
 * @date 2020-05-03-15:28
 **/
public class TestNGDemo2 {

    /**
     * У��a=a
     */
    @Test
    public void assertEqualTest(){
        String a = "asdf";
        String b = "asdf11";
        Assert.assertEquals(a,b,"�����");//֮��Ҫ���κβ���
    }

    @Test
    public void assertNotEqualTest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }

    @Test
    public void assertNullTest(){
        String aa = "";//��ͨ��
        String bb = null;//ͨ��
        Assert.assertNull(bb);
    }

    @Test
    public void assertNotNullTest(){
        String aa = "";//ͨ��
        String bb = null;//��ͨ��
        Assert.assertNotNull(aa);
    }

    @Test
    public void assertFalse(){
        boolean aa = false;//ͨ��
        Assert.assertFalse(aa);
    }
}
