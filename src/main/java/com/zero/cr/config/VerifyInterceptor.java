package com.zero.cr.config;

import com.zero.cr.utils.Util;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hxf
 * @version V1.0
 * @Title: 用户登录，身份验证拦截器
 * @Description: TODO
 * @date 2018/8/29 17:23
 */
public class VerifyInterceptor implements HandlerInterceptor {

    /**
     * 验证用户是否登录，登录以后用户 token 和 数据请求 token 是否校验成功，不成功返回登录或者拦截
     *
     * @param request 不用管
     * @param response 不用管
     * @param handler 不用管
     * @return 是否放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken = request.getParameter("userToken");
        String token = request.getParameter("token");
        String uri = request.getRequestURI();
        String serverToken = Util.MD5(uri + userToken);


/*

        System.out.println("html-userToken: " + userToken);
        System.out.println("server-userToken-user: " + Constant.TOKEN_USER.get(userToken));
        System.out.println("html-token: " + token);
        System.out.println("server-token: " + serverToken);
        System.out.println("Util.token2user(userToken): " + Util.token2user(userToken));
        System.out.println("--------------------------");

*/

        if (token == null || userToken == null || token.equals("") || userToken.equals("") || !Util.tokenIsMatch(token, serverToken) || Util.token2user(userToken) == null) {
            response.setHeader("Origin", "*");
            response.setHeader("Access-Control-Allow-Origin", "*");
            String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            if (uri.endsWith(".html"))
                request.getRequestDispatcher("login.html").forward(request, response);
            else response.sendRedirect(path + "/user/toLogin");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
