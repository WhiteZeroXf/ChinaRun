package com.zero.cr.service.impl;

import com.zero.cr.dao.FansMapper;
import com.zero.cr.dao.MsgUserMapper;
import com.zero.cr.dao.UserMapper;
import com.zero.cr.pojo.Fans;
import com.zero.cr.pojo.MsgUser;
import com.zero.cr.pojo.User;
import com.zero.cr.service.FansService;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.FansUserBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date 2018-08-23 17:30
 */

@Service
public class FansServiceImpl extends BaseServiceImpl<Fans> implements FansService {

    @Resource
    private FansMapper fansMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private MsgUserMapper msgUserMapper;

    @Override
    public MyMapper<Fans> getMapper() {
        return fansMapper;
    }

    @Override
    public boolean isFans(Long userId, Long userFansId) throws Exception {
        return fansMapper.queryFansByuserIdAnduserFansId(userId, userFansId) != null;
    }

    @Override
    public int follow(Integer state, Long userId, Long userFansId) throws Exception {
        User toUser = userMapper.selectByPrimaryKey(userId);
        User fansUser = userMapper.selectByPrimaryKey(userFansId);
        //关注
        if (state == 0) {
            //粉丝
            fansUser.setFollowSum(fansUser.getFollowSum() + 1);
            userMapper.updateByPrimaryKey(fansUser);
            //被关注
            toUser.setFansSum(toUser.getFansSum() + 1);
            userMapper.updateByPrimaryKey(toUser);

            //添加消息
            msgUserMapper.insert(MsgUser.builder().userId(userId).type(1).typeId(userFansId).fansId(userFansId).createTime(new Date()).build());

            return fansMapper.addFans(new Fans(null, userId, userFansId, null));
        }
        //取消关注
        if (state == 1) {
            //粉丝
            fansUser.setFollowSum(fansUser.getFollowSum() - 1);
            userMapper.updateByPrimaryKey(fansUser);
            //被关注
            toUser.setFansSum(toUser.getFansSum() - 1);
            userMapper.updateByPrimaryKey(toUser);
            return fansMapper.removeFans(new Fans(null, userId, userFansId, null));
        }
        return -1;
    }

    @Override
    public List<FansUserBean> listFansUser() {
        List<FansUserBean> fansUserBeanList = fansMapper.selectFansUser();
        return fansUserBeanList;
    }

    /**
     * 根据当前用户ID查询粉丝信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<User> getFansById(Long userId) {
        return fansMapper.getFansById(userId);
    }

    /**
     * 根据当前用户ID查询关注信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<User> getFollowById(Long userId) {
        return fansMapper.getFollowById(userId);
    }

    /**
    * 查询主键ID
     * */
    @Override
    public int selectFansId(Long userId, Long userFansId) {
        return fansMapper.selectFansId(userId, userFansId);
    }
}
