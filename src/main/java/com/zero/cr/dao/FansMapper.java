package com.zero.cr.dao;

import com.zero.cr.pojo.Fans;
import com.zero.cr.pojo.User;
import com.zero.cr.vo.FansUserBean;
import com.zero.cr.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FansMapper extends MyMapper<Fans> {

    /**
     * 根据用户ID跟粉丝Id查询粉丝表
     * @param userId
     * @param userFansId
     * @return
     * @throws Exception
     */
    Fans queryFansByuserIdAnduserFansId(@Param("userId") Long userId , @Param("userFansId") Long userFansId) throws Exception;


    //添加关注
    int addFans(Fans fans) throws Exception;

    //取消关注
    int removeFans(Fans fans) throws Exception;
    //查询两表个别数据
    public List<FansUserBean> selectFansUser();
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


    //查询主键Id

    int  selectFansId(@Param("userId") Long userId,@Param("userFansId") Long userFansId);
}