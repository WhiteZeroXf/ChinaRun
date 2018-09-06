package com.zero.cr.service.impl;

import com.zero.cr.dao.PointMapper;
import com.zero.cr.pojo.Point;
import com.zero.cr.service.PointService;
import com.zero.cr.utils.MyMapper;
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

@Service
public class PointServiceImpl extends BaseServiceImpl<Point> implements PointService {

    @Resource
    private PointMapper pointMapper;

    @Override
    public MyMapper<Point> getMapper() {
        return pointMapper;
    }

    @Override
    public List<Point> getPointByRunId(long runId) {
        return pointMapper.getPointByRunId(runId);
    }
}
