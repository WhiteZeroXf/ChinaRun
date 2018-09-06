package com.zero.cr.service;

import com.zero.cr.pojo.MsgSystem;

import java.util.List;

public interface MsgSystemService extends BaseService<MsgSystem> {
    List<MsgSystem> listUnread(Long userid);
    int addMsgBySubjectId(long subjectId);
}
