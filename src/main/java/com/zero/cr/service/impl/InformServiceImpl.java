package com.zero.cr.service.impl;

import com.zero.cr.dao.InformMapper;
import com.zero.cr.pojo.Inform;
import com.zero.cr.service.InformService;
import com.zero.cr.utils.MyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date 2018-08-23 17:30
 */

@Service
public class InformServiceImpl extends BaseServiceImpl<Inform> implements InformService {

    @Resource
    private InformMapper informMapper;

    @Override
    public MyMapper<Inform> getMapper() {
        return informMapper;
    }
}
