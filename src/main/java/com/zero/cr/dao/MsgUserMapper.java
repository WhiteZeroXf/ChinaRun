package com.zero.cr.dao;

import com.zero.cr.pojo.MsgUser;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.FansUserBean;
import com.zero.cr.vo.FocusUserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgUserMapper extends MyMapper<MsgUser> {
    public List<FansUserBean> selectUnreadFocus(@Param("userid") Long userid);
    public List<FocusUserBean> selectUnreadZans(@Param("userid") Long userid);
}