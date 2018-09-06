package com.zero.cr.utils;

import com.zero.cr.config.Constant;
import com.zero.cr.pojo.User;

import java.security.MessageDigest;
import java.util.Date;

/**
 * @author Hxf
 * @version V1.0
 * @Title: 工具类
 * @Description:
 * @date 2018/8/29 10:41
 */
public class Util {

    /**
     * 通过用户生成 userToken
     *
     * @param user 用户实体
     * @return userToken 16位 MD5 加密字符串
     */
    public static String user2token(User user) {
        if (user == null)
            return "";
        String token = MD5(user.getUserId() + user.getUsername() + new Date().getTime());
        Constant.TOKEN_USER.put(token, user);
        Constant.TOKEN_VALID.put(token, new Date(new Date().getTime() + 1000 * 60 * 60));
        return token;
    }

    /**
     * 通过用户 token 获取用户, 并校验 token 是否过期
     *
     * @param token
     * @return
     */
    public static User token2user(String token) {
        Date date = Constant.TOKEN_VALID.get(token);
        if (token == null || token.equals("") || date == null) {
            return null;
        }
        if (date.before(new Date())) {
            Constant.TOKEN_USER.remove(token);
            Constant.TOKEN_VALID.remove(token);
        }
        return Constant.TOKEN_USER.get(token);
    }

    /**
     * 检测 A B token 是否匹配
     * @param tokenA
     * @param tokenB
     * @return
     */
    public static boolean tokenIsMatch(String tokenA, String tokenB) {
        if (tokenA == null || tokenB == null || tokenA.equals("") || tokenB.equals(""))
            return false;
        return tokenA.toUpperCase().equals(tokenB.toUpperCase());
    }

    /**
     * md5 加密
     *
     * @param key 要加密的字符串
     * @return
     */
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return "";
        }
    }

    // 测试主函数
    public static void main(String args[]) {
        String s = Util.user2token(User.builder().userId(1L).username("hxf").build());
        System.out.println(MD5(1 + "hxf").equals(s));
        System.out.println("MD5后：" + s);
        System.out.println(Constant.TOKEN_USER.get(s));
    }

}
