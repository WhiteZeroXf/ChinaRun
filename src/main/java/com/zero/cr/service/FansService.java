package com.zero.cr.service;

import com.github.pagehelper.PageInfo;
import com.zero.cr.pojo.Fans;
import com.zero.cr.pojo.User;
import com.zero.cr.vo.FansUserBean;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public interface FansService extends BaseService<Fans> {

    /**
     * 验证粉丝
     * @throws Exception
     */
    boolean isFans(Long userId , Long userFansId) throws Exception;


    //关注
    int follow(Integer state , Long userId , Long userFansId ) throws Exception;

    public List<FansUserBean> listFansUser();

    /**
     * 根据当前用户ID查询粉丝信息
     * @param userId
     * @return
     */
    List<User> getFansById(Long userId);
    /**
     * 根据当前用户ID查询关注信息
     * @param userId
     * @return
     */
    List<User> getFollowById(Long userId);

    /**
     *
     * 查询主键Id
     */
     int  selectFansId(Long userId,Long userFansId);

}
