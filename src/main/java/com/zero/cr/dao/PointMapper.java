package com.zero.cr.dao;

import com.zero.cr.pojo.Point;
import com.zero.cr.utils.MyMapper;

import java.util.List;

public interface PointMapper extends MyMapper<Point> {
    List<Point> getPointByRunId(long runId);
}
