package com.zero.cr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zero.cr.dao.JoinMapper;
import com.zero.cr.dao.MsgSystemMapper;
import com.zero.cr.dao.SubjectMapper;
import com.zero.cr.pojo.MsgSystem;
import com.zero.cr.pojo.Subject;
import com.zero.cr.pojo.User;
import com.zero.cr.service.MsgSystemService;
import com.zero.cr.utils.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date 2018-08-23 17:30
 */

@Service
public class MsgSystemServiceImpl extends BaseServiceImpl<MsgSystem> implements MsgSystemService {

    @Resource
    private MsgSystemMapper msgSystemMapper;
    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private JoinMapper joinMapper;

    @Override
    public MyMapper<MsgSystem> getMapper() {
        return msgSystemMapper;
    }

    @Override
    public List<MsgSystem> getByBean(MsgSystem query) {

        return super.getByBean(query);
    }

    @Override
    public List<MsgSystem> listUnread(Long userid) {
        List<MsgSystem> msgSystemList = msgSystemMapper.selectUnread(userid);
        System.out.println(msgSystemList);
        return msgSystemList;
    }

    @Override
    public int addMsgBySubjectId(long subjectId) {
        Subject subject = subjectMapper.selectByPrimaryKey(subjectId);
        String msg = "您参与的主题：‘"+subject.getTitle()+"’已经被点亮，完结撒花！！";
        List<MsgSystem> msgSystems = new ArrayList<>();
        List<Long> userIds = joinMapper.getUserIdBySubjectId(subjectId);
        for(Long uid:userIds){
            MsgSystem msgSystem = new MsgSystem();
            msgSystem.setUserId(uid);
            msgSystem.setContent(msg);
            msgSystem.setState(0);
            msgSystem.setCreateTime(new Date());
            msgSystems.add(msgSystem);
        }
        msgSystemMapper.insertList(msgSystems);
        return 0;
    }
}
