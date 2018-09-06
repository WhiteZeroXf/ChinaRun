package com.zero.cr.controller;

import com.zero.cr.pojo.Comment;
import com.zero.cr.pojo.MsgUser;
import com.zero.cr.service.CommentService;
import com.zero.cr.service.FlashCommentLogService;
import com.zero.cr.service.MsgUserService;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Resource(name = "commentService")
    private CommentService commentService;
    @Resource(name = "flashCommentLogService")
    private FlashCommentLogService flashCommentLogService;
    @Autowired
    private MsgUserService msgUserService;

    //获取当前用户当前日志的评论
    @RequestMapping("/queryInfo")
    public ResponseBean queryCommentInfoByUTId(Long userId, Long flashId) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Comment> listC = commentService.selectByUTId(userId, flashId);
        map.put("listC", listC);
        return ResponseBean.builder().data(map).build();

    }

    //添加评论
    @RequestMapping("/addInfo")
    public ResponseBean addCommentInfo(Long userId, Long flashId, String content, MsgUser msgUser)
    {
        commentService.addCommentInfo(userId, flashId, content);
        commentService.addFlashCommentSum(flashId);
        flashCommentLogService.insertCommentFlashRecord(userId, flashId);//添加评论记录
        msgUser.setType(2);
        msgUser.setUserId(userId);
        msgUser.setTypeId(flashId);
        msgUser.setContent(content);
        msgUser.setState(0);
        msgUserService.add(msgUser);
        return ResponseBean.builder().data(commentService.selectByUTId(userId, flashId)).build();
    }

    //赞评论
    @RequestMapping("/zanComment")
    public ResponseBean zanComment(Long userId, Long typeId,MsgUser msgUser) {
        int ok = 0;
        if (flashCommentLogService.selectZanCommentRecord(userId, typeId) == 0) {
            if (flashCommentLogService.insertZanCommentRecord(userId, typeId) > 0) {
                msgUser.setType(2);
                msgUser.setUserId(userId);
                msgUser.setTypeId(typeId);
                msgUser.setState(0);
                Number number= flashCommentLogService.selectFlashCommentLogID(userId,typeId);
                Long flashCommentLogID = number.longValue();
                msgUser.setFlashCommentLogId(flashCommentLogID);
                msgUserService.add(msgUser);
                ok = commentService.updateSupportSum(typeId);
            }
        }
        return ResponseBeanUtil.success(ok);
    }
}
