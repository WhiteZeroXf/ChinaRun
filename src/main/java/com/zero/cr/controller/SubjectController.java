package com.zero.cr.controller;

import com.zero.cr.pojo.Run;
import com.zero.cr.pojo.Subject;
import com.zero.cr.pojo.User;
import com.zero.cr.service.*;
import com.zero.cr.utils.ResponseBeanUtil;
import com.zero.cr.vo.ResponseBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private FansService fansService;

    @Autowired
    private JoinService joinService;
    @Autowired
    private MsgSystemService msgSystemService;
    /**
     * 获取主题
     * @return
     */
    @RequestMapping("/querySubject")
    public ResponseBean querySubject(@RequestParam(name = "pageNum" , defaultValue = "1") Integer pageNum , @RequestParam(name = "pageSize" , defaultValue = "8") Integer pageSize){
        try {
            return ResponseBeanUtil.success(subjectService.queryAllSubject(pageNum , pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBeanUtil.systemError();
        }
    }


    /**
     * 根据ID获取主题
     * @param subjectId
     * @return
     */
    @RequestMapping("/querySubjectById")
    public ResponseBean querySubjectById(Integer subjectId){
        try {
            Map<String,Object> subject =  subjectService.querySubjectById(subjectId);
            return ResponseBeanUtil.success(subject);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBeanUtil.notFound();
        }
    }

    /**
     * 验证粉丝
     * @param userId
     * @param userFansId
     * @return
     */
    @RequestMapping("/isFans")
    public ResponseBean isFans(Long userId , Long userFansId) {
        try {
           boolean is = fansService.isFans(userId , userFansId);
           if(is){
               return ResponseBeanUtil.success("0");
           }else {
               return ResponseBeanUtil.success("1");
           }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseBeanUtil.systemError();
        }
    }


    /**
     * 是否关注
     * @param state
     * @param userId
     * @param userFansId
     * @return
     */
    @RequestMapping("/followController")
    public ResponseBean followController(Integer state , Long userId , Long userFansId ){
        try {
            fansService.follow(state , userId , userFansId);
            return ResponseBeanUtil.success("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBeanUtil.systemError();
        }
    }


    /**
     * 是否参与了主题
     * @param
     * @param
     * @return
     */
    @RequestMapping("/isJoinSubject")
    public ResponseBean isJoinSubject(Long subjectId, Long userId){
        try {
            boolean is = joinService.isJoinSubject(subjectId , userId);
            if(is){
                return ResponseBeanUtil.success("0");
            }else {
                return ResponseBeanUtil.success("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBeanUtil.systemError();
        }
    }

    /**
     * 报名该主题
     * @param
     * @param
     * @return
     */
    @RequestMapping("/joinSubject")
    public ResponseBean joinSubject(Long subjectId, Long userId){
        try {
            joinService.joinSubject(subjectId , userId);
            return ResponseBeanUtil.success("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBeanUtil.systemError();
        }
    }

    @RequestMapping("/addSubject")
    public ResponseBean addSubject(@RequestParam Map<String,Object> data){
        try {
            subjectService.addSubject(data);
            return ResponseBeanUtil.success("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBeanUtil.systemError();
        }
    }


    @RequestMapping("/getSubjectById")
    public  ResponseBean getSubjectById(long subjectId){
        Subject subject = subjectService.getById(subjectId);
        return ResponseBeanUtil.success(subject);
    }


    /**
     * 附近
     * @return
     */
    @RequestMapping("/querySubjectNear")
    public ResponseBean querySubjectNear(Float lat , Float lng){
        try {
           return ResponseBeanUtil.success(subjectService.queryAllSubjectNear(lat , lng));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBeanUtil.systemError();
        }
    }

    @RequestMapping("/finishSubject")
    public ResponseBean finishSubject(Subject subject){
        if (subject.getState()==2){
            subject.setFinishTime(new Date());
            msgSystemService.addMsgBySubjectId(subject.getSubjectId());
        }
        if(subjectService.update(subject)){
            return ResponseBeanUtil.success(1);
        }
        return ResponseBeanUtil.parameterError();
    }
}
