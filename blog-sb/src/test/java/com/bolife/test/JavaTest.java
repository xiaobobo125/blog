package com.bolife.test;

import org.junit.jupiter.api.Test;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 17:34
 * @Description:
 */
public class JavaTest {
    @Test
    public void TestDemo(){
        System.out.println(reverse("1233454"));
        StringBuilder str = new StringBuilder("123");
        str.reverse();
    }
    public static String reverse(String str){
        if(str == null||str.length()<=1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }
}
