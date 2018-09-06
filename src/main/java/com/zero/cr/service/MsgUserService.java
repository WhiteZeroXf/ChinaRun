package com.zero.cr.service;

import com.zero.cr.pojo.MsgUser;
import com.zero.cr.vo.FansUserBean;
import com.zero.cr.vo.FocusUserBean;

import java.util.List;

public interface MsgUserService extends BaseService<MsgUser> {
    public List<FansUserBean> selectUnreadFocus(Long userid);
    public List<FocusUserBean> selectUnreadZans(Long userid);
}
