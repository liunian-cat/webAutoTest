package com.po;

import org.openqa.selenium.By;

/**
 * @author liangjunjun
 * @date 2020-05-12-21:46
 **/
public class LoginPage {
    //����email�ı���Ķ�λ��ʽ
    public static By emailInput = By.name("email");
    //�������������Ķ�λ��ʽ
    public static By pwdInput = By.name("password");
    //�����¼��ť�Ķ�λ��ʽ
    public static By loginButton = By.id("dologin");
    //����ע�ᰴť�Ķ�λ��ʽ
    public static By zhuceButton = By.className("j-register");
}
