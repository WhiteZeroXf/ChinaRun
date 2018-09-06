package com.zero.cr.dao;

import com.zero.cr.pojo.Flash;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.UserFlashBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FlashMapper extends MyMapper<Flash> {

    List<UserFlashBean> selectFalshByTopicId(@Param("topicId") long topicId,@Param("userId") Long userId);//话题详情显示

    int updateZan(@Param("flashId") Long id);//日志获赞

    int updateNZan(@Param("flashId") Long id); //取消赞

    int updateCommentSum(@Param("flashId") Long flashId);//增加评论数

    /**
     * 获取分页后的李白跑地球首页的日志+发表用户+主题列表
     * 最后修改：Hxf
     *
     * @return 日志+发表用户+主题 的 Map
     */
    List<Map> listAllLBRun();

    /**
     * 获取所有 该主题下的日志
     *
     * @return
     */
    List<Map> listFlashByTopicId(@Param(value = "userId") Long userId, @Param(value = "topicId") Long topicId);
}