package com.zero.cr.dao;

import com.zero.cr.pojo.FlashCommentLog;
import com.zero.cr.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface FlashCommentLogMapper extends MyMapper<FlashCommentLog> {
    int insertCommentFlashRecord(@Param("userId")long userId,@Param("typeId") long typeId);//添加评论日志

    int insertZanCommentFlashRecord(@Param("userId")long userId,@Param("typeId") long typeId);//赞评论记录

    int insertZanFlashRecord(@Param("userId")long userId,@Param("typeId") long typeId);//赞日志记录

    int selectZanFlashRecord(@Param("userId")long userId,@Param("typeId") long typeId);//查询日志记录

    int deleteZanFlashRecord(@Param("userId")long userId,@Param("typeId") long typeId);//删除日志记录

    int selectZanCommentRecord(@Param("userId")long userId,@Param("typeId") long typeId);//查询评论记录

    int selectFlashCommentLogID(@Param("userId")long userId,@Param("typeId") long typeId);//查询主键Id

}