package com.zero.cr.service.impl;

import com.zero.cr.dao.MsgUserMapper;
import com.zero.cr.pojo.MsgUser;
import com.zero.cr.service.MsgUserService;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.FansUserBean;
import com.zero.cr.vo.FocusUserBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date 2018-08-23 17:30
 */

@Service
public class MsgUserServiceImpl extends BaseServiceImpl<MsgUser> implements MsgUserService {

    @Resource
    private MsgUserMapper msgUserMapper;

    @Override
    public MyMapper<MsgUser> getMapper() {
        return msgUserMapper;
    }

    @Override
    public List<FansUserBean> selectUnreadFocus(Long userid) {
        List<FansUserBean> msgUserList = msgUserMapper.selectUnreadFocus(userid);
        return msgUserList;
    }

    @Override
    public List<FocusUserBean> selectUnreadZans(Long userid) {
        List<FocusUserBean> focusUserBeanList = msgUserMapper.selectUnreadZans(userid);
        return focusUserBeanList;
    }
}
