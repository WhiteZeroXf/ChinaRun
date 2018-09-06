package com.zero.cr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zero.cr.dao.TopicMapper;
import com.zero.cr.pojo.Topic;
import com.zero.cr.service.TopicService;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.ST;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date
 */

@Service(value = "topicService")
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements TopicService {

    @Resource
    private TopicMapper topicMapper;

    @Override
    public MyMapper<Topic> getMapper() {
        return topicMapper;
    }

    //按热度分頁查询
    @Override
    public PageInfo<Topic> listByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Topic> list = topicMapper.selectByHot();
        PageInfo<Topic>  pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    //按热度查询

    @Override
    public List<Topic> listByHot() {
        return topicMapper.selectByHot();
    }

    @Override
    public ST getST(Long subjectId) {
        return topicMapper.getST(subjectId);
    }
}
