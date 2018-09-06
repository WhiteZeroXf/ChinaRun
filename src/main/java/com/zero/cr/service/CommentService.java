package com.zero.cr.service;

import com.zero.cr.pojo.Comment;


import java.util.List;

public interface CommentService extends BaseService<Comment> {
    List<Comment> selectByUTId(Long userId ,Long flashId);

    int addCommentInfo(Long userId ,Long flashId,String content);

    int addFlashCommentSum(Long flashId);

    int updateSupportSum(Long commentId);
}
