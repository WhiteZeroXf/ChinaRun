package com.zero.cr.service.impl;

import com.zero.cr.dao.CommentMapper;
import com.zero.cr.dao.FlashMapper;
import com.zero.cr.pojo.Comment;
import com.zero.cr.service.CommentService;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.PLCountBean;
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

@Service(value = "commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private FlashMapper flashMapper;

    @Override
    public MyMapper<Comment> getMapper() {
        return commentMapper;
    }

    @Override
    public List<Comment> selectByUTId(Long userId ,Long flashId) {
        return commentMapper.selectByUFId(userId, flashId);
    }

    @Override
    public int addCommentInfo(Long userId, Long flashId, String content) {
        return commentMapper.insertComment(userId, flashId, content);
    }

    @Override
    public int addFlashCommentSum(Long flashId) {
        return flashMapper.updateCommentSum(flashId);
    }

    @Override
    public int updateSupportSum(Long commentId) {
        return commentMapper.updateSupportSum(commentId);
    }
}
