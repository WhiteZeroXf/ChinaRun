package com.zero.cr.dao;

import com.zero.cr.pojo.Comment;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.PLCountBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    List<Comment> selectByUFId(@Param("userId") Long userId,@Param("flashId") Long flashId);//查询当前日志的评论

    int insertComment(@Param("userId") Long userId, @Param("flashId")Long flashId,@Param("content")String content);

    int updateSupportSum(@Param("commentId") Long commentId);//点赞评论

}