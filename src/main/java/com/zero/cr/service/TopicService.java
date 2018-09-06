package com.zero.cr.service;

import com.zero.cr.pojo.Topic;
import com.zero.cr.vo.ST;

import java.util.List;

public interface TopicService extends BaseService<Topic> {

    List<Topic> listByHot();//根据热度查询

    ST getST(Long subjectId);//获取主题+话题
}
