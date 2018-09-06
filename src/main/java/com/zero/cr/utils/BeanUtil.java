package com.zero.cr.utils;

import org.apache.tomcat.util.security.MD5Encoder;

import java.util.Arrays;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: TODO
 * @date 2018/8/27 17:24
 */
public class BeanUtil {

    public static void main(String[] args){

        System.out.println(Arrays.toString("abc".getBytes()));
        System.out.println(MD5Encoder.encode("abc".getBytes()));

    }
}
