package com.zero.cr.service.impl;

import com.zero.cr.dao.FlashCommentLogMapper;
import com.zero.cr.pojo.FlashCommentLog;
import com.zero.cr.service.FlashCommentLogService;
import com.zero.cr.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date 2018-08-23 17:30
 */

@Service(value = "flashCommentLogService")
public class FlashCommentLogServiceImpl extends BaseServiceImpl<FlashCommentLog> implements FlashCommentLogService {

    @Resource
    private FlashCommentLogMapper flashCommentLogMapper;

    @Override
    public MyMapper<FlashCommentLog> getMapper() {
        return flashCommentLogMapper;
    }

    @Override
    public int insertZanFlashRecord(long userId, long typeId) {
        return flashCommentLogMapper.insertZanFlashRecord(userId, typeId);
    }

    @Override
    public int selectZanFlashRecord(long userId, long typeId) {
        return flashCommentLogMapper.selectZanFlashRecord(userId, typeId);
    }

    @Override
    public int deleteZanFlashRecord(long userId, long typeId) {
        return flashCommentLogMapper.deleteZanFlashRecord(userId, typeId);
    }

    @Override
    public int insertCommentFlashRecord(long userId, long typeId) {
        return flashCommentLogMapper.insertCommentFlashRecord(userId, typeId);
    }

    @Override
    public int insertZanCommentRecord(long userId, long typeId) {
        return flashCommentLogMapper.insertZanCommentFlashRecord(userId, typeId);
    }

    @Override
    public int selectZanCommentRecord(long userId, long typeId) {
        return flashCommentLogMapper.selectZanCommentRecord(userId, typeId);
    }

    @Override
    public int selectFlashCommentLogID(long userId, long typeId) {
        return flashCommentLogMapper.selectFlashCommentLogID(userId, typeId);
    }
}
