package com.zero.cr.service;

import com.zero.cr.pojo.FlashCommentLog;
import org.apache.ibatis.annotations.Param;

public interface FlashCommentLogService extends BaseService<FlashCommentLog> {
    int insertCommentFlashRecord(long userId, long typeId);//添加评论日志

    int insertZanFlashRecord(long userId, long typeId);//赞日志记录

    int selectZanFlashRecord(long userId, long typeId);//查询赞日志记录

    int deleteZanFlashRecord(long userId, long typeId);//删除赞日志记录

    int insertZanCommentRecord(long userId, long typeId);//赞评论记录

    int  selectZanCommentRecord(long userId, long typeId);//查询赞评论

    int selectFlashCommentLogID(long userId, long typeId);//查询记录id


}
