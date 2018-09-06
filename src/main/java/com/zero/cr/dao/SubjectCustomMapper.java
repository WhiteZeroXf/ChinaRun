package com.zero.cr.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.H
 * @className SubjectCustomMapper
 * @Date 2018/8/26 14:23
 * @Version v1.0
 */
public interface SubjectCustomMapper {

    //查询所有主题
    List<Map<String,Object>> queryAllSubject() throws Exception;

    /**
     * 根据主题ID查询对应的主题及用户信息
     * @param subjectId
     * @return
     * @throws Exception
     */
    Map<String,Object> querySbjectAndUserBySubjectId(Integer subjectId) throws Exception;

    /**
     * 附近主题
     * @param lat
     * @param lng
     * @return
     * @throws Exception
     */
   List< Map<String,Object>> querySubjectNear(@Param("lat") Float lat , @Param("lng") Float lng) throws Exception;

}
