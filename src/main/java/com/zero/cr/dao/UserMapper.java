package com.zero.cr.dao;

import com.zero.cr.pojo.User;
import com.zero.cr.utils.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

    User getUserById(Long userId);

    List<User> getSubjectUserTop3(long subjectId);

    /**
     * 修改-我的-个人资料
     * @param query
     * @return
     */
    int save(User query);

    Long getUserFollowSum(Long userId);
}