package com.zero.cr.service;

import com.zero.cr.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends BaseService<User> {
    User getUserById(Long userId);

    Long getUserFollowSum(Long userId);

    User login(String username, String password);

    List<User> getSubjectUserTop3(long subjectId);


    boolean updateUser(User user, HttpServletRequest request, String userToken) throws Exception;
}
