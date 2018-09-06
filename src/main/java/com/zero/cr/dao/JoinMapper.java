package com.zero.cr.dao;

import com.zero.cr.pojo.Join;
import com.zero.cr.pojo.Subject;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.MyRunVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JoinMapper extends MyMapper<Join> {

    /**
     * 根据主题ID跟当前用户ID查询参与主体记录表
     * @param join
     * @return
     * @throws Exception
     */
    Join queryJoinBysubjectIdAndUserId(Join join) throws Exception;


    /**
     * 加入主题
     * @param join
     * @return
     * @throws Exception
     */
    int addJoin(Join join) throws Exception;

    List<Join> getMyRunById(Long UserId);

    //获得我的发起
    public List<MyRunVo> getMyStart(Long userId);

    //获得某主题的所有用户id
    List<Long> getUserIdBySubjectId(Long subjectId);
}