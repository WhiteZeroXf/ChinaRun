package com.zero.cr.dao;

import com.zero.cr.pojo.MsgSystem;
import com.zero.cr.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgSystemMapper extends MyMapper<MsgSystem> {
    public  List<MsgSystem> selectUnread(@Param("userid") Long userid);
}