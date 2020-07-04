package com.bolife.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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

        Double i = 2.0;
        System.out.println(i.hashCode());
//        ConcurrentHashMap
    }
    public static String reverse(String str){
        if(str == null||str.length()<=1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }

    @Test
    public void testdemo2(){
        Class<ExtendType> typeClass = ExtendType.class;
        System.out.println(typeClass);
        System.out.println(Arrays.toString(typeClass.getFields()));
        System.out.println(Arrays.toString(typeClass.getDeclaredFields()));
    }
}
