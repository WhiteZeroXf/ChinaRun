/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: RunController
 * Author:   LJQ
 * Date:     2018/8/23 14:17
 * Description: 跑步视图层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zero.cr.controller;

import com.zero.cr.pojo.Point;
import com.zero.cr.pojo.Run;
import com.zero.cr.pojo.Subject;
import com.zero.cr.pojo.User;
import com.zero.cr.service.PointService;
import com.zero.cr.service.RunService;
import com.zero.cr.service.SubjectService;
import com.zero.cr.service.UserService;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 〈跑步视图层〉
 *
 * @author LJQ
 * @create 2018/8/23
 * @since 1.0.0
 */
@RestController
@RequestMapping("/run")
public class RunController {

    @Autowired
    private RunService runService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private PointService pointService;
    @Autowired
    private UserService userService;


    @RequestMapping("/toBegin")
    public ResponseBean toBegin(long subjectId){
        Subject subject = subjectService.getById(subjectId);
        return ResponseBeanUtil.success(subject);
    }


    //获取当前定位的经纬度数据
    @RequestMapping("/getNowPos")
    public ResponseBean getPosition(Point point){
        point.setCreateTime(new Date());
        if(pointService.add(point)){
            return ResponseBeanUtil.success(point);
        }
        return ResponseBeanUtil.systemError();
    }

    /**
     * 将后台的位置坐标传到前台
     * @return
     */
    @RequestMapping("/putPoses")
    public ResponseBean getPos(long runId){
        List<Point> points = pointService.getPointByRunId(runId);
        if(points!=null){
            return ResponseBeanUtil.success(points);
        }
        return ResponseBeanUtil.parameterError();
    }

    @RequestMapping("/newRun")
    public ResponseBean newRun(Run run){
        if(runService.add(run)){
            return ResponseBeanUtil.success(run);
        }
        return ResponseBeanUtil.systemError();
    }

    @RequestMapping("/getTop3User")
    public ResponseBean getTop3User(long subjectId){
        List<User> list = userService.getSubjectUserTop3(subjectId);
        if(list.size()>0){
            return  ResponseBeanUtil.success(list);
        }
        return  ResponseBeanUtil.systemError();
    }

    @RequestMapping("/finishRun")
    public ResponseBean finishRun(Run run) throws ParseException {
        if(runService.update(run)){
            User user = userService.getUserById(run.getUserId());
            user.setContributeSum(user.getContributeSum()+1);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date = sdf.parse(run.getTotalTime());
            Double d = (double) (date.getTime() / 1000 / 60 / 60);
            user.setContributeHours(user.getContributeHours()+d);
            user.setContributeMils(run.getTotalMileage());
            userService.update(user);
            return ResponseBeanUtil.success(1);
        }
        return ResponseBeanUtil.systemError();
    }
}
