package com.zero.cr.controller;

import com.github.pagehelper.PageInfo;
import com.zero.cr.pojo.Topic;
import com.zero.cr.service.TopicService;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/topic")
public class TopicController {

    @Resource(name = "topicService")
    private TopicService topicService;

    @RequestMapping(value = "/queryAllByHotPage")
    public ResponseBean queryAllByHotPage(@RequestParam(value = "pageNum", defaultValue = "1" ) int pageNum,@RequestParam(value = "pageSize", defaultValue = "10" ) int pageSize){
        try {

            PageInfo<Topic> pageInfo = topicService.listByPage(pageNum,pageSize);

            return ResponseBeanUtil.success(pageInfo);
        }catch (Exception e){
            return ResponseBean.builder().code(-1).msg(e.getMessage()).build();
        }


    }
    @RequestMapping(value = "/queryAllByHot")
    public ResponseBean queryAllByHot(){
        try {
            List<Topic> topicList = topicService.listByHot();
            return ResponseBeanUtil.success(topicList);
        }catch (Exception e){
            return ResponseBean.builder().code(-1).msg(e.getMessage()).build();
        }
    }

    /**
     * 获取 Subject + Topic
     * @param subjectId
     * @return
     */
    @RequestMapping(value = "getST")
    public ResponseBean getTS(Long subjectId){
        return ResponseBean.builder().data(topicService.getST(subjectId)).build();
    }

    @RequestMapping("/getTopicById")
    public ResponseBean getTopicById(Long topicId){
        return ResponseBeanUtil.success(topicService.getById(topicId));
    }
}