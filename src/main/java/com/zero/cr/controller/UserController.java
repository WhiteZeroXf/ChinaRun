package com.zero.cr.controller;

import com.zero.cr.pojo.User;
import com.zero.cr.service.UserService;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.utils.Util;
import com.zero.cr.vo.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 根据当前用户ID查询用户个人信息
     *
     * @param userId
     * @return user
     */
    @RequestMapping("getById")
    public ResponseBean getUserById(Long userId) {
        if (userId == null || userId == 0) {
            return ResponseBean.builder().code(5).msg("用户id获取为空").build();
        }
        User user = userService.getUserById(userId);
        return ResponseBeanUtil.success(user);
    }

    /**
     * 跳转到用户登录页面
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/toLogin")
    public ResponseBean toLogin(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();
        map.put("url", "login.html");
        return ResponseBean.builder().code(5).data(map).build();
    }

    /**
     * 用户登录
     *
     * @param query
     * @return
     */
    @RequestMapping("login")
    public ResponseBean login(User query) {
        List<User> users = userService.getByBean(query);
        if (users == null || users.size() == 0)
            return ResponseBean.builder().code(52).build();
        User user = users.get(0);
        user.setPassword("");
        Map<String, Object> map = new HashMap<>();
        map.put("url", "index.html");
        map.put("user", user);
        map.put("userToken", Util.user2token(user));
        return ResponseBean.builder().data(map).build();
    }

    /**
     * 更新用户
     * @param data
     * @param request
     * @param userToken
     * @return
     */
    @RequestMapping("save")
    public ResponseBean save(User data, HttpServletRequest request, String userToken) {
        try {
            if (userService.updateUser(data, request, userToken)) {
                User user = userService.getById(data.getUserId());
                user.setPassword("");
                return ResponseBean.builder().data(user).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.builder().code(-1).build();
        }
        return null;
    }

}
