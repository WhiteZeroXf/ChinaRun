package com.zero.cr.service;

import com.zero.cr.pojo.Point;

import java.util.List;

public interface PointService extends BaseService<Point> {
    List<Point> getPointByRunId(long runId);
}
