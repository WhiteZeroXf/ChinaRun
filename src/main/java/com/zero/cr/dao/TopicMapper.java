package com.zero.cr.dao;

import com.zero.cr.pojo.Topic;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.vo.ST;

import java.util.List;

public interface TopicMapper extends MyMapper<Topic> {

    List<Topic> selectByHot();//按热度查询

    List<Topic> getOne(Long topicId);

    ST getST(Long subjectId);

}