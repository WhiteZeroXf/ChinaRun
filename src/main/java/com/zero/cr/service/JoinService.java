package com.zero.cr.service;

import com.zero.cr.pojo.Join;
import com.zero.cr.pojo.Subject;
import com.zero.cr.vo.MyRunVo;

import java.util.List;

public interface JoinService extends BaseService<Join> {
    List<Join> getMyRunById(Long userId);


    /**
     * 是否参与了主题
     * @param
     * @param
     * @return
     * @throws Exception
     */
    boolean isJoinSubject(Long subjectId, Long userId) throws Exception;


    /**
     * 加入主题
     * @param
     * @param
     * @return
     * @throws Exception
     */
    int joinSubject(Long subjectId, Long userId) throws Exception;

    public List<MyRunVo> getMyStart(Long userId);

}
