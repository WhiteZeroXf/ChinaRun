package com.zero.cr.service.impl;

import com.zero.cr.dao.JoinMapper;
import com.zero.cr.pojo.Join;
import com.zero.cr.pojo.Subject;
import com.zero.cr.service.JoinService;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.MyRunVo;
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

@Service
public class JoinServiceImpl extends BaseServiceImpl<Join> implements JoinService {

    @Resource
    private JoinMapper joinMapper;

    @Override
    public MyMapper<Join> getMapper() {
        return joinMapper;
    }

    @Override
    public boolean isJoinSubject(Long subjectId, Long userId) throws Exception {
        return joinMapper.queryJoinBysubjectIdAndUserId(new Join(null,subjectId , userId , null , null))==null?false:true;
    }

    @Override
    public int joinSubject(Long subjectId, Long userId) throws Exception {
        return joinMapper.addJoin(new Join(null,subjectId , userId , null , null));
    }

    @Override
    public List<Join> getMyRunById(Long userId) {
        return joinMapper.getMyRunById(userId);
    }

    @Override
    public List<MyRunVo> getMyStart(Long userId) {
        return joinMapper.getMyStart(userId);
    }
}
