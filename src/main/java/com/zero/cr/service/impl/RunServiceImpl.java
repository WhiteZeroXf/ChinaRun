package com.zero.cr.service.impl;

import com.zero.cr.dao.RunMapper;
import com.zero.cr.pojo.Run;
import com.zero.cr.service.RunService;
import com.zero.cr.utils.MyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date
 */

@Service
public class RunServiceImpl extends BaseServiceImpl<Run> implements RunService {

    @Resource
    private RunMapper runMapper;

    @Override
    public MyMapper<Run> getMapper() {
        return runMapper;
    }
}
