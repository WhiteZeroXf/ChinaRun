package com.zero.cr.service;

import com.github.pagehelper.PageInfo;
import com.zero.cr.pojo.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectService extends BaseService<Subject> {

    /**
     * 查询所有主题
     * @return
     * @throws Exception
     */
    PageInfo queryAllSubject(Integer pageNum , Integer pageSize) throws Exception;


    /**
     * 根据ID查询主题
     * @param subjectId
     * @return
     */
    Map<String,Object> querySubjectById(Integer subjectId) throws Exception;

    /**
     * 添加主题
     * @param map
     * @return
     * @throws Exception
     */
    int addSubject(Map<String,Object> map) throws Exception;


    /**
     * 获取附近主题
     * @param lat
     * @param lng
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> queryAllSubjectNear(Float lat , Float lng) throws Exception;

}
