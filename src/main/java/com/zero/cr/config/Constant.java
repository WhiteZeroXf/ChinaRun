package com.zero.cr.config;

import com.zero.cr.pojo.User;

import java.util.*;

/**
 * @author Hxf
 * @version V1.0
 * @Title: 存放一些 常用的东西
 * @Description:
 * @date 2018/8/29 10:37
 */
public class Constant {

    /**
     * 存放与 token 对应的用户
     */
    public static Map<String, User> TOKEN_USER;

    /**
     * 存放 token 的过期时间
     */
    public static Map<String, Date> TOKEN_VALID;

    /**
     * 放行 uri
     */
    public static List<String> ALLOW_URI;

    static {
        Constant.TOKEN_USER = new LinkedHashMap<>();
        Constant.TOKEN_VALID = new LinkedHashMap<>();

        Constant.ALLOW_URI = new LinkedList<>();
        addAllowUri();
    }

    private static void addAllowUri() {
        Constant.ALLOW_URI.add("/");
        Constant.ALLOW_URI.add("/**/*.css");
        Constant.ALLOW_URI.add("/**/*.js");
        Constant.ALLOW_URI.add("/**/*.png");
        Constant.ALLOW_URI.add("/**/*.jpg");
        Constant.ALLOW_URI.add("/**/*.ico");
        Constant.ALLOW_URI.add("/**/*.ttf");
        Constant.ALLOW_URI.add("/**/*.map");
        Constant.ALLOW_URI.add("/**/*.html");
        Constant.ALLOW_URI.add("/index.html");
        Constant.ALLOW_URI.add("/login.html");
        Constant.ALLOW_URI.add("/register.html");
        Constant.ALLOW_URI.add("/user/login");
        Constant.ALLOW_URI.add("/user/toLogin");
        Constant.ALLOW_URI.add("/user/register");
    }

}
